package com.hyejeanmoon.democleanarchitecture.bindingAdapter

import androidx.databinding.BindingAdapter
import com.facebook.drawee.view.SimpleDraweeView

/**
 * frescoで画像を表示する用のadapter
 */
class BindingAdapter {

    //frescoで画像を表示
    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun SimpleDraweeView.loadImage(url: String) {
            setImageURI(url)
        }
    }
}