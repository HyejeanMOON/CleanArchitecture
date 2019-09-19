package com.hyejeanmoon.democleanarchitecture.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * 写真に関する全ての情報
 */
@Entity(tableName = "photo_table")
data class Photo constructor(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val num_id: Int = 0,

    @ColumnInfo(name = "photo_id")
    @SerializedName("id")
    val id: String? = "",

    @ColumnInfo(name = "created_at")
    @SerializedName("created_at")
    val createdAt: String? = "",

    @ColumnInfo(name = "updated_at")
    @SerializedName("updated_at")
    val updatedAt: String? = "",

    @ColumnInfo(name = "width")
    @SerializedName("width")
    val width: String? = "",

    @ColumnInfo(name = "height")
    @SerializedName("height")
    val height: String? = "",

    @ColumnInfo(name = "color")
    @SerializedName("color")
    val color: String? = "",

    @ColumnInfo(name = "downloads")
    @SerializedName("downloads")
    val downloads: Int? = 0,

    @ColumnInfo(name = "likes")
    @SerializedName("likes")
    val likes: Int? = 0,

    @ColumnInfo(name = "liked_by_user")
    @SerializedName("liked_by_user")
    val likedByUser: Boolean? = false,

    @ColumnInfo(name = "description")
    @SerializedName("description")
    val description: String? = "",

    @Embedded(prefix = "photo_")
    @SerializedName("exif")
    val exif: Exif? = null,

    @Embedded(prefix = "photo_")
    @SerializedName("links")
    val links: Links? = null,

    @Embedded(prefix = "photo_")
    @SerializedName("location")
    val location: Location? = null,

    //@Embedded(prefix = "photo_")
    //@SerializedName("tags")
    //val tags:List<Tags>?=null,

    @Embedded(prefix = "photo_")
    @SerializedName("urls")
    val urls: Urls? = null,

    @Embedded(prefix = "photo_")
    @SerializedName("user")
    val user: User? = null

    //@Embedded(prefix = "photo_")
    //@SerializedName("current_user_collections")
    //val currentUserCollections: CurrentUserCollections?=null
) : java.io.Serializable