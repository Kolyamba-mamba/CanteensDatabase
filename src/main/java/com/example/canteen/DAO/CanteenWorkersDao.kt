package com.example.canteen.DAO

import androidx.room.Dao
import androidx.room.Insert
import com.example.canteen.Entity.CanteenWorker
import com.example.canteen.Entity.Cook
import com.example.canteen.Entity.Courier

@Dao
interface CanteenWorkersDao {
    @Insert
    suspend fun insertCanteenWorker(canteenWorker: CanteenWorker)

    @Insert
    suspend fun insertCook(cook: Cook)

    @Insert
    suspend fun onsertCourier(courier: Courier)
}