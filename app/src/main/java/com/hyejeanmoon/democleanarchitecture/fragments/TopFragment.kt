package com.hyejeanmoon.democleanarchitecture.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hyejeanmoon.democleanarchitecture.R
import com.hyejeanmoon.democleanarchitecture.dagger2.DaggerTopFragmentComponent
import com.hyejeanmoon.democleanarchitecture.databinding.FragmentTopBinding
import com.hyejeanmoon.democleanarchitecture.models.Photo
import com.hyejeanmoon.democleanarchitecture.recyclerAdapter.PhotoListAdapter
import com.hyejeanmoon.democleanarchitecture.repository.PhotoListRepository
import com.hyejeanmoon.democleanarchitecture.viewmodels.TopViewModel
import javax.inject.Inject

/**
 * top画面
 */
class TopFragment : Fragment() {

    lateinit var topBinding: FragmentTopBinding
    lateinit var photoListAdapter: PhotoListAdapter

    @Inject
    lateinit var photoListRepository: PhotoListRepository


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        topBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_top, container, false)
        return topBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //build and inject the component(PhotoListRepository)
        DaggerTopFragmentComponent.builder().build().inject(this)

        val topViewModel: TopViewModel = ViewModelProvider(this).get(TopViewModel::class.java)

        //pass a PhotoListRepository instance to TopViewModel and then access network to get a list of photos by PhotoListRepository
        topViewModel.photoListRepository = photoListRepository

        //topBindingにパラメーターを設定
        topBinding.topViewModel = topViewModel

        //RecyclerViewにlayoutManagerを設定する
        topBinding.recyclerViewFragmentTop.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        //adapterを設定し、RecyclerViewに渡す
        photoListAdapter = PhotoListAdapter()
        topBinding.recyclerViewFragmentTop.adapter = photoListAdapter

        //livedataの変更がある際、RecyclerViewのデータを更新する
        subscribeUI(topViewModel)

    }


    private fun subscribeUI(viewModel: TopViewModel) {
        viewModel.liveDataViewModel.observe(this, Observer<List<Photo>> { value ->
            value.let {
                photoListAdapter.submitList(it)
                topBinding.executePendingBindings()
            }
        })
    }


}