package com.hyejeanmoon.democleanarchitecture.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable


/**
 * ユーザーのlikeリスト
 */

@Entity(tableName = "likes_table")
data class Likes(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "likes_num_id")
    val num_id: Int = 0,

    @ColumnInfo(name = "total")
    @SerializedName("total")
    val total: Int? = 0,

    @Embedded(prefix = "likes_")
    @SerializedName("historical")
    val historical: Historical? = null
) : Serializable