package com.example.growgh.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.growgh.Model.ImageData
import com.example.growgh.R

class ImageAdapter(private val photos: List<ImageData>?) :
    RecyclerView.Adapter<ImageAdapter.PhotoViewHolder>() {
    class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imgPost)
        val imageLike : ImageView = itemView.findViewById(R.id.imgLikes)
        val numberLikes : TextView = itemView.findViewById(R.id.noLikes)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.feed_card_layout, parent, false)
        return PhotoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return photos!!.size
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photoPosition = photos?.get(position)
        Glide.with(holder.itemView.context).load(photoPosition?.urls?.regular).centerCrop()
            .into(holder.image)

        holder.imageLike.setOnClickListener {
            Glide.with(holder.itemView.context).load(R.drawable.heart).centerCrop()
                .into(holder.imageLike)
            holder.numberLikes.setOnClickListener {
                var count =0
                count+=1
            }
        }


    }
}