package com.example.canteen.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Canteen (
    @PrimaryKey(autoGenerate = true)  val Id: Int? = null,
    val Title: String,
    val WorkingHours: String,
    val PhoneNumber: String,
    val Address: String
)