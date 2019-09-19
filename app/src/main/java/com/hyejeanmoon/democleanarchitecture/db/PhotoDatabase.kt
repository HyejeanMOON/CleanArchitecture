package com.hyejeanmoon.democleanarchitecture.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hyejeanmoon.democleanarchitecture.models.Photo

/**
 * RoomDatabaseをsingletonで作成するクラス
 */
@Database(entities = [(Photo::class)], version = 1)
abstract class PhotoDatabase : RoomDatabase() {

    companion object {

        private var INSTANCE: PhotoDatabase? = null

        fun getInstance(context: Context): PhotoDatabase? {
            if (INSTANCE == null) {

                INSTANCE = Room
                    .databaseBuilder(context, PhotoDatabase::class.java, "photo_database.db")
                    .build()

            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

    abstract fun getPhotoDao(): PhotoDAO

}