package com.hyejeanmoon.democleanarchitecture.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable


/**
 * 写真を取った場所情報
 */

@Entity(tableName = "position_table")
data class Position constructor(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val num_id: Int = 0,

    @ColumnInfo(name = "latitude")
    @SerializedName("latitude")
    val latitude: Double? = 0 as Double,

    @ColumnInfo(name = "longitude")
    @SerializedName("longitude")
    val longitude: Double? = 0 as Double
) : Serializable