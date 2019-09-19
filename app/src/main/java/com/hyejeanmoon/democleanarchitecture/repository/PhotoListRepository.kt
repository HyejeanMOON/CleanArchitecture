package com.hyejeanmoon.democleanarchitecture.repository

import com.hyejeanmoon.democleanarchitecture.models.Photo
import com.hyejeanmoon.democleanarchitecture.network.Unsplash
import com.hyejeanmoon.democleanarchitecture.network.UnsplashAPI
import javax.inject.Inject

/**
 * unsplashのinstanceとphotoを取る為のinject
 */
class PhotoListRepository @Inject constructor() {

    private var client = Unsplash().retrofit.create(UnsplashAPI::class.java)

    //retrofitにkotlin corountinesを使う為にsuspen関数を作成
    suspend fun getPhoto(page: Int, perPage: Int, orderBy: String): List<Photo> {
        return client.getPhotoList(page, perPage, orderBy)
    }


}