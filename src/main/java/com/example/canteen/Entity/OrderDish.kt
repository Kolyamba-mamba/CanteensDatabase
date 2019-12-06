package com.example.canteen.Entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Order_Dish",foreignKeys =
    [ForeignKey(entity = Order::class, parentColumns = ["Id"], childColumns = ["Order_Id"]),
    ForeignKey(entity = Dish::class, parentColumns = ["Id"], childColumns = ["Dish_Id"]),
    ForeignKey(entity = Cook::class, parentColumns = ["Id"], childColumns = ["Cook_Id"])])
data class OrderDish(
    @PrimaryKey(autoGenerate = true)
    val Id: Int,
    val Order_Id: Int,
    val Dish_Id: Int,
    val Cook_Id: Int
)