package com.example.canteen.Entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = Canteen::class, parentColumns = ["Id"],
  childColumns = ["Canteen_Id"])])
data class CanteenWorker(
  @PrimaryKey(autoGenerate = true) val Id: Int? = null,
  val FullName: String,
  val Canteen_Id: Int
)