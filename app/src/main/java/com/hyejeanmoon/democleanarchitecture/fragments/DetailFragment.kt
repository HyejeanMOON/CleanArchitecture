package com.hyejeanmoon.democleanarchitecture.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hyejeanmoon.democleanarchitecture.R
import com.hyejeanmoon.democleanarchitecture.databinding.FragmentDetailBinding
import com.hyejeanmoon.democleanarchitecture.models.Photo
import com.hyejeanmoon.democleanarchitecture.viewmodels.DetailViewModel

/**
 * 詳細画像表示画面
 */
class DetailFragment : Fragment() {

    lateinit var fragmentDetailBinding: FragmentDetailBinding
    lateinit var photo: Photo

    //detailViewModelの初期化
    private val detailViewModel: DetailViewModel by lazy {
        ViewModelProvider(this).get(DetailViewModel::class.java)
    }

    companion object {
        const val DETAIL_KEY = "detail_photo"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        fragmentDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        val bundle: Bundle? = arguments
        if (bundle?.getSerializable(DETAIL_KEY) != null) {
            //TopFragmentから送ったデータを受け取る
            
            photo = bundle.getSerializable(DETAIL_KEY) as Photo
        }

        return fragmentDetailBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        fragmentDetailBinding.lifecycleOwner = this
        fragmentDetailBinding.viewmodel = detailViewModel

        //photoデータをdetailViewModelに送り、bindingされる
        detailViewModel.start(photo)
    }


}