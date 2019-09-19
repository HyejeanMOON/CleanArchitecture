package com.hyejeanmoon.democleanarchitecture.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable


/**
 * ユーザーの場所情報
 */

@Entity(tableName = "location_table")
data class Location constructor(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "location_num_id")
    val num_id: Int = 0,

    @ColumnInfo(name = "city")
    @SerializedName("city")
    val city: String? = "",

    @ColumnInfo(name = "country")
    @SerializedName("country")
    val country: String? = "",

    @Embedded(prefix = "location_")
    @SerializedName("position")
    val position: Position? = null
) : Serializable