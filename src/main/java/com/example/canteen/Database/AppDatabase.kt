package com.example.canteen.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.canteen.DAO.CanteenDao
import com.example.canteen.Entity.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Canteen::class, CanteenWorker::class, Client::class,
    Cook::class, Courier::class, CourierHasCanteen::class, Dish::class,
    Order::class, OrderDish::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase(){
    abstract fun canteenDao():CanteenDao

    companion object{
        @Volatile
        var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope):AppDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "Canteens_database"
                ).addCallback(CanteenDatabaseCallback(scope)).build()
                INSTANCE = instance
                return instance
            }
        }
    }
    private class CanteenDatabaseCallback(private val scope: CoroutineScope):
            RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.canteenDao())
                }
            }
        }

        suspend fun populateDatabase(canteenDao: CanteenDao) {
            var canteen = Canteen(Title = "100ловая",PhoneNumber = "8-800-555-35-35",
                Address = "ул.Пушкина д.22",WorkingHours = "8.00-23.00")
            canteenDao.insertCanteen(canteen)
            canteen = Canteen(Title = "Ложка",PhoneNumber = "8-888-777-66-55",
                Address = "ул.Абрамова д.13",WorkingHours = "7.00-23.00")
            canteenDao.insertCanteen(canteen)
            canteen = Canteen(Title = "Вкусно",PhoneNumber = "8-927-367-77-27",
                Address = "ул.Ложкина д.11",WorkingHours = "9.00-20.00")
            canteenDao.insertCanteen(canteen)
            canteen = Canteen(Title = "Гурман",PhoneNumber = "8-917-767-11-22",
                Address = "ул.Колотушкина д.82",WorkingHours = "Круглосуточно")
            canteenDao.insertCanteen(canteen)
            canteen = Canteen(Title = "Одесса",PhoneNumber = "8-800-135-14-88",
                Address = "ул.Одессы д.2",WorkingHours = "9.00-21.00")
            canteenDao.insertCanteen(canteen)

        }
    }
}