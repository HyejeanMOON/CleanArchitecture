package com.hyejeanmoon.democleanarchitecture.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * 写真各サイズのlink
 */

@Entity(tableName = "urls_table")
data class Urls constructor(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "urls_num_id")
    val num_id: Int = 0,

    @ColumnInfo(name = "url")
    @SerializedName("url")
    val url: String? = "",

    @ColumnInfo(name = "raw")
    @SerializedName("raw")
    val raw: String? = "",

    @ColumnInfo(name = "full")
    @SerializedName("full")
    val full: String? = "",

    @ColumnInfo(name = "regular")
    @SerializedName("regular")
    val regular: String? = "",

    @ColumnInfo(name = "small")
    @SerializedName("small")
    val small: String? = "",

    @ColumnInfo(name = "thumb")
    @SerializedName("thumb")
    val thumb: String? = ""
) : Serializable