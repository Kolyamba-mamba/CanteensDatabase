package com.example.canteen.Entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = Canteen::class, parentColumns = ["Id"],
  childColumns = ["Canteen_Id"])])
data class Cook(
  @PrimaryKey(autoGenerate = true) val Id: Int? = null,
  val FullName: String,
  val Category: Int?,
  val Canteen_Id: Int
)