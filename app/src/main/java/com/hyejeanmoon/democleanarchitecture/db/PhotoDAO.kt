package com.hyejeanmoon.democleanarchitecture.db

import androidx.room.*
import com.hyejeanmoon.democleanarchitecture.models.Photo

/**
 * photo_tableにアクセス用DAO
 */
@Dao
interface PhotoDAO {

    @Query("select * from photo_table")
    suspend fun getAll(): List<Photo>

    @Insert
    suspend fun insert(photos: List<Photo>)

    @Delete
    suspend fun clear(photos: List<Photo>)

    @Query("select count(*) from photo_table")
    suspend fun getCount(): Int

    @Transaction
    suspend fun deleteAndInsertAllInTransaction(photos: List<Photo>) {
        val originalPhotos = getAll()
        clear(originalPhotos)
        insert(photos)
    }

}