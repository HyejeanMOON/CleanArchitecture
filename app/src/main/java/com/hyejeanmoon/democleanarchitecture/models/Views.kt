package com.hyejeanmoon.democleanarchitecture.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable


/**
 * 閲覧情報
 */

@Entity(tableName = "views_table")
data class Views constructor(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "views_num_id")
    val num_id: Int = 0,

    @ColumnInfo(name = "total")
    @SerializedName("total")
    val total: Int? = 0,

    @Embedded(prefix = "views_")
    @SerializedName("historical")
    val historical: Historical? = null
) : Serializable