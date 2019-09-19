package com.hyejeanmoon.democleanarchitecture.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hyejeanmoon.democleanarchitecture.models.Photo

/**
 * detail画面のviewModel
 */
class DetailViewModel(application: Application) : AndroidViewModel(application) {

    private val _photoDetail = MutableLiveData<Photo>()
    val photoDetail: LiveData<Photo>
        get() = _photoDetail

    fun start(photo: Photo) {
        _photoDetail.value = photo
    }

}