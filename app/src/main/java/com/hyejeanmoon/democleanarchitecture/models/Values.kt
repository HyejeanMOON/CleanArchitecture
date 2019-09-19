package com.hyejeanmoon.democleanarchitecture.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable


/**
 * 日付の情報
 */

@Entity(tableName = "values_tables")
data class Values constructor(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "values_num_id")
    val num_id: Int = 0,

    @ColumnInfo(name = "date")
    @SerializedName("date")
    val date: String? = "",

    @ColumnInfo(name = "value")
    @SerializedName("value")
    val value: Int? = 0
) : Serializable