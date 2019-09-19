package com.hyejeanmoon.democleanarchitecture.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable


/**
 * ユーザーのcover写真
 */

@Entity(tableName = "cover_photo_table")
data class CoverPhoto constructor(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cover_num_id")
    val num_id: Int = 0,

    @ColumnInfo(name = "cover_photo_id")
    @SerializedName("id")
    val id: String? = "",

    @ColumnInfo(name = "width")
    @SerializedName("width")
    val width: Int? = 0,

    @ColumnInfo(name = "height")
    @SerializedName("height")
    val height: Int? = 0,

    @ColumnInfo(name = "color")
    @SerializedName("color")
    val color: String? = "",

    @ColumnInfo(name = "likes")
    @SerializedName("likes")
    val likes: Int? = 0,

    @ColumnInfo(name = "liked_by_user")
    @SerializedName("liked_by_user")
    val likeByUser: Boolean? = false,

    @ColumnInfo(name = "description")
    @SerializedName("description")
    val description: String? = "",

    @Embedded(prefix = "cover_photo_")
    @SerializedName("user")
    val user: User? = null,

    @Embedded(prefix = "cover_photo_")
    @SerializedName("urls")
    val urls: Urls? = null
) : Serializable