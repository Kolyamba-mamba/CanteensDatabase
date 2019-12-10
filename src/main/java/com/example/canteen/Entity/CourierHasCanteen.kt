package com.example.canteen.Entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Courier_has_Canteen", foreignKeys =
[ForeignKey(entity = Canteen::class, parentColumns = ["Id"], childColumns = ["Canteen_Id"]),
  ForeignKey(entity = Courier::class, parentColumns = ["Id"], childColumns = ["Courier_Id"])])
data class CourierHasCanteen (
  @PrimaryKey(autoGenerate = true)
  val Id: Int,
  val Courier_Id: Int,
  val Canteen_Id: Int
)