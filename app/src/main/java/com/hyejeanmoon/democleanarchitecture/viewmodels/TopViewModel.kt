package com.hyejeanmoon.democleanarchitecture.viewmodels

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.hyejeanmoon.democleanarchitecture.db.PhotoDatabase
import com.hyejeanmoon.democleanarchitecture.models.Photo
import com.hyejeanmoon.democleanarchitecture.repository.PhotoListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

/**
 * Top画面のviewModel
 */
class TopViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {

    var liveDataViewModel: MutableLiveData<List<Photo>> = MutableLiveData()
    private var count = 1


    @Inject
    lateinit var photoListRepository: PhotoListRepository

    lateinit var photoDatabase: PhotoDatabase

    //crate a new job to run by kotlin coroutines
    private val viewModelJob = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + viewModelJob


    //viewModelJob must to be canceled, in order to let lifecycle of coroutines same with viewModel's
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private fun fetchNewPhotoFromServer(order_by: String, context: Context) {

        //流れ：
        //1.データベースにあるデータをクリアする
        //2.サーバから新しいデータを取る
        //3.データベースに新しいデータを書き込む
        //4.データベースから先ほど書き込んだデータを取る
        //5.取ったデータをlivedataに渡し、uiを更新するようにする
        try {
            launch {
                val retrievedPhotoList = photoListRepository.getPhoto(count, 40, order_by)

                //　TODO　!!の使用は禁止、daggerを利用してください
                photoDatabase = PhotoDatabase.getInstance(context)!!

                //既存のデータベースを削除し、新しいデータを入れます
                photoDatabase.getPhotoDao().deleteAndInsertAllInTransaction(retrievedPhotoList)

                //get data from the database again and then notify livedata to update ui
                val photos = photoDatabase.getPhotoDao().getAll()

                //変更したデータをlivedataを通知し、uiを更新する
                liveDataViewModel.value = photos

                count++
            }

        } catch (e: Exception) {
            Log.d("TopViewModel, fetchNewPhotoFromServer ", e.toString())
        }

    }

    fun click() {
        //getをクリックする際、新しい画像を表示
        Log.d("topViewModel", "click")
        fetchNewPhotoFromServer("latest", getApplication())
    }

}