package com.hyejeanmoon.democleanarchitecture.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable


/**
 * 統計情報
 */

@Entity(tableName = "statistics_table")
data class Statistics constructor(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "statistics_num_id")
    val num_id: Int = 0,

    @ColumnInfo(name = "username")
    @SerializedName("username")
    val username: String? = "",

    @Embedded(prefix = "statistics_")
    @SerializedName("downloads")
    val downloads: Downloads? = null,

    @Embedded(prefix = "statistics_")
    @SerializedName("views")
    val views: Views? = null,

    @Embedded(prefix = "statistics_")
    @SerializedName("likes")
    val likes: Likes? = null
) : Serializable