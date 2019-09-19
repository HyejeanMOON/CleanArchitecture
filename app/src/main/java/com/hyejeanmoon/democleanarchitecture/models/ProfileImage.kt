package com.hyejeanmoon.democleanarchitecture.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable


/**
 * ユーザーのprofile写真
 */

@Entity(tableName = "profile_image_table")
data class ProfileImage constructor(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "profile_image_num_id")
    val num_id: Int = 0,

    @ColumnInfo(name = "small")
    @SerializedName("small")
    val small: String? = "",

    @ColumnInfo(name = "medium")
    @SerializedName("medium")
    val medium: String? = "",

    @ColumnInfo(name = "large")
    @SerializedName("large")
    val large: String? = ""
) : Serializable