package com.hyejeanmoon.democleanarchitecture.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable


/**
 * download履歴
 */

@Entity(tableName = "downloads_table")
data class Downloads constructor(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "downloads_num_id")
    val num_id: Int = 0,

    @ColumnInfo(name = "total")
    @SerializedName("total")
    val total: Int? = 0,

    @Embedded(prefix = "downloads_")
    @SerializedName("historical")
    val historical: Historical? = null
) : Serializable