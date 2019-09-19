package com.hyejeanmoon.democleanarchitecture.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 *　個人ユーザーの写真collections
 */

@Entity(tableName = "collection_table")
data class Collections constructor(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "collection_num_id")
    val num_id: Int = 0,

    @ColumnInfo(name = "collection_id")
    @SerializedName("id")
    val id: String? = "",

    @ColumnInfo(name = "title")
    @SerializedName("title")
    val title: String? = "",

    @ColumnInfo(name = "description")
    @SerializedName("description")
    val description: String? = "",

    @ColumnInfo(name = "published_at")
    @SerializedName("published_at")
    val publishedAt: String? = "",

    @ColumnInfo(name = "updated_at")
    @SerializedName("updated_at")
    val updatedAt: String? = "",

    @ColumnInfo(name = "curated")
    @SerializedName("curated")
    val curated: String? = "",

    @ColumnInfo(name = "total_photos")
    @SerializedName("total_photos")
    val totalPhotos: String? = "",

    @ColumnInfo(name = "private")
    @SerializedName("private")
    val private: String? = "",

    @ColumnInfo(name = "share_key")
    @SerializedName("share_key")
    val shareKey: String? = "",

    @Embedded(prefix = "collections_")
    @SerializedName("cover_photo")
    val coverPhoto: CoverPhoto? = null,

    @Embedded(prefix = "collections_")
    @SerializedName("user")
    val user: User? = null,

    @Embedded(prefix = "collections_")
    @SerializedName("links")
    val links: Links? = null

) : Serializable

