package com.example.canteen.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Courier (
  @PrimaryKey(autoGenerate = true) val Id: Int? = null,
  val FullName: String,
  val Transport: String?
)