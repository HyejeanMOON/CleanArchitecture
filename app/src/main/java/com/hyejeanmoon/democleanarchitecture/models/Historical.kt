package com.hyejeanmoon.democleanarchitecture.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * 写真の履歴
 */

@Entity(tableName = "historical_table")
data class Historical constructor(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "historical_num_id")
    val num_id: Int = 0,

    @ColumnInfo(name = "change")
    @SerializedName("change")
    val change: Int? = 0,

    @ColumnInfo(name = "average")
    @SerializedName("average")
    val average: Int? = 0,

    @ColumnInfo(name = "resolution")
    @SerializedName("resolution")
    val resolution: String? = "",

    @ColumnInfo(name = "quantity")
    @SerializedName("quantity")
    val quantity: String? = "",

    @Embedded(prefix = "historical_")
    @SerializedName("values")
    val values: List<Values>? = null
) : java.io.Serializable