package com.hyejeanmoon.democleanarchitecture.recyclerAdapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hyejeanmoon.democleanarchitecture.R
import com.hyejeanmoon.democleanarchitecture.databinding.PhotoItemBinding
import com.hyejeanmoon.democleanarchitecture.fragments.DetailFragment
import com.hyejeanmoon.democleanarchitecture.models.Photo

/**
 * top画面のrecyclerView用のadapter
 */
class PhotoListAdapter :
    ListAdapter<Photo, PhotoListAdapter.PhotoViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val inflater = LayoutInflater.from((parent.context))
        val binding: PhotoItemBinding =
            DataBindingUtil.inflate(inflater, R.layout.photo_item, parent, false)
        return PhotoViewHolder(binding)

    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.binding.photo = getItem(position)
        holder.binding.cardViewPhotoItem.setOnClickListener {
            val bundle = Bundle()
            //photoをパラメーターとしてDetailFragmentに送る
            bundle.putSerializable(
                DetailFragment.DETAIL_KEY,
                getItem(position)
            )
            Navigation.findNavController(holder.binding.cardViewPhotoItem)
                .navigate(R.id.detailFragment, bundle)
        }
        holder.binding.executePendingBindings()
    }

    class DiffCallback : DiffUtil.ItemCallback<Photo>() {
        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem === newItem
        }
    }

    class PhotoViewHolder(var binding: PhotoItemBinding) : RecyclerView.ViewHolder(binding.root)

}
