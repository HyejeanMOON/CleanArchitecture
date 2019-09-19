package com.hyejeanmoon.democleanarchitecture.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable


/**
 * ユーザー情報
 */

@Entity(tableName = "user_table")
data class User(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_num_id")
    val num_id: Int = 0,

    @ColumnInfo(name = "user_id")
    @SerializedName("id")
    val id: String? = "",

    @ColumnInfo(name = "update_at")
    @SerializedName("updated_at")
    val updatedAt: String? = "",

    @ColumnInfo(name = "username")
    @SerializedName("username")
    val username: String? = "",

    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name: String? = "",

    @ColumnInfo(name = "portfolio_url")
    @SerializedName("portfolio_url")
    val portfolioUrl: String? = "",

    @ColumnInfo(name = "bio")
    @SerializedName("bio")
    val bio: String? = "",

    @ColumnInfo(name = "location")
    @SerializedName("location")
    val location: String? = "",

    @ColumnInfo(name = "total_likes")
    @SerializedName("total_likes")
    val totalLikes: Int? = 0,

    @ColumnInfo(name = "total_photos")
    @SerializedName("total_photos")
    val totalPhotos: Int? = 0,

    @ColumnInfo(name = "total_collections")
    @SerializedName("total_collections")
    val totalCollections: Int? = 0,

    @Embedded(prefix = "user_")
    @SerializedName("links")
    val links: Links? = null,

    @Embedded(prefix = "user_")
    @SerializedName("profile_image")
    val profileImage: ProfileImage? = null,

    @ColumnInfo(name = "instagram_username")
    @SerializedName("instagram_username")
    val instagramUsername: String? = "",

    @ColumnInfo(name = "twitter_username")
    @SerializedName("twitter_username")
    val twitterUsername: String? = ""

) : Serializable