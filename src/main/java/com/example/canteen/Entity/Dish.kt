package com.example.canteen.Entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = Canteen::class, parentColumns = ["Id"],
    childColumns = ["Canteen_Id"])])
data class Dish(
    @PrimaryKey(autoGenerate = true)
    val Id: Int,
    val Title: String,
    val Price: Int,
    val Canteen_Id: Int
)