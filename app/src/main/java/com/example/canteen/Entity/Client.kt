package com.example.canteen.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Client(
  @PrimaryKey(autoGenerate = true) val Id: Int? = null,
  val FullName: String,
  val PhoneNumber: String,
  val Address: String
)