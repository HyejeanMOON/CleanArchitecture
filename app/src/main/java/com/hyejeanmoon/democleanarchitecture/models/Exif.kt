package com.hyejeanmoon.democleanarchitecture.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * 写真のexif情報
 */

@Entity(tableName = "exif_table")
data class Exif constructor(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "exif_num_id")
    val num_id: Int = 0,

    @ColumnInfo(name = "make")
    @SerializedName("make")
    val make: String? = null,

    @ColumnInfo(name = "model")
    @SerializedName("model")
    val model: String? = "",

    @ColumnInfo(name = "exposure_time")
    @SerializedName("exposure_time")
    val exposureTime: String? = "",

    @ColumnInfo(name = "aperture")
    @SerializedName("aperture")
    val aperture: String? = "",

    @ColumnInfo(name = "focal_length")
    @SerializedName("focal_length")
    val focalLength: String? = "",

    @ColumnInfo(name = "iso")
    @SerializedName("iso")
    val iso: String? = ""
) : Serializable