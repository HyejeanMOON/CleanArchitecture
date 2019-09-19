package com.hyejeanmoon.democleanarchitecture.network

import com.hyejeanmoon.democleanarchitecture.models.Photo
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * retrofitの通信api
 */
interface UnsplashAPI {

    //get a list of photos from server
    //param: page:1 per_page:10 order_by:latest, oldest, popular
    @GET("/photos")
    suspend fun getPhotoList(
        @Query("page") page: Int
        , @Query("per_page") per_page: Int
        , @Query("order_by") order_by: String
    ): List<Photo>


}