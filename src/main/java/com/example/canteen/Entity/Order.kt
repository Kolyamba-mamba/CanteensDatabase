package com.example.canteen.Entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys =
[ForeignKey(entity = CanteenWorker::class, parentColumns = ["Id"], childColumns = ["CanteenWorker_Id"]),
  ForeignKey(entity = Courier::class, parentColumns = ["Id"], childColumns = ["Courier_Id"]),
  ForeignKey(entity = Client::class, parentColumns = ["Id"], childColumns = ["Client_Id"])])
data class Order (
  @PrimaryKey(autoGenerate = true) val Id: Int? = null,
  val OrderTime: String,
  val QuantityDish: Int? = null,
  val Status: String? = null,
  val AmountPayable: Int? = null,
  val CanteenWorker_Id: Int? = null,
  val Courier_Id: Int? = null,
  val Client_Id: Int? = null
)