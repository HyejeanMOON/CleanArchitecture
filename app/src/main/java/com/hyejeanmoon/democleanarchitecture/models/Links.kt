package com.hyejeanmoon.democleanarchitecture.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable


/**
 * 写真の各種link
 */

@Entity(tableName = "links_table")
data class Links constructor(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "links_num_id")
    val num_id: Int = 0,

    @ColumnInfo(name = "self")
    @SerializedName("self")
    val self: String? = "",

    @ColumnInfo(name = "html")
    @SerializedName("html")
    val html: String? = "",

    @ColumnInfo(name = "download")
    @SerializedName("download")
    val download: String? = "",

    @ColumnInfo(name = "download_location")
    @SerializedName("download_location")
    val downloadLocation: String? = "",

    @ColumnInfo(name = "photos")
    @SerializedName("photos")
    val photos: String? = "",

    @ColumnInfo(name = "likes")
    @SerializedName("likes")
    val likes: String? = "",

    @ColumnInfo(name = "portfolio")
    @SerializedName("portfolio")
    val portfolio: String? = ""
) : Serializable