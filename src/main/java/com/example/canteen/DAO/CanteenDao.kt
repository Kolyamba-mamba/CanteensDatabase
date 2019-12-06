package com.example.canteen.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.canteen.Entity.Canteen

@Dao
interface CanteenDao{
    @Query("SELECT * from Canteen")
    fun getAllCanteens():LiveData<List<Canteen>>

    @Insert
    suspend fun insertCanteen(canteen: Canteen)
}