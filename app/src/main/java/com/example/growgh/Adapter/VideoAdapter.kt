package com.example.growgh.Adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.ProgressBar
import android.widget.VideoView
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter
import androidx.recyclerview.widget.RecyclerView
import com.example.growgh.Model.PexelsVideo
import com.example.growgh.Model.PexelsVideoFile
import com.example.growgh.Model.VideoResponse

import com.example.growgh.R

  class VideoAdapter(private val arrVideo: List<VideoResponse>) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {
      private var exoPlayer: ExoPlayer? = null
   // var arrVideoModel : ArrayList<PexelsVideo> = arrVideo as ArrayList<PexelsVideo>
     class VideoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        var videoView : VideoView = itemView.findViewById(R.id.ViewVideo)

         val progressBar = itemView.findViewById<ProgressBar>(R.id.progressBar)

       fun bindVideo(video : VideoResponse){
          videoView.setVideoPath(video.videoUrl)
           videoView.start()
       }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_container_view,parent,false))
    }

    override fun getItemCount(): Int {
        return  arrVideo.size
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
      val currentItem= arrVideo[position]
        holder.bindVideo(currentItem)
//        currentItem.
//
//        val videoUri = Uri.parse()
//        holder.videoView.setVideoURI(videoUri)


        val mediaController = MediaController(holder.itemView.context)
        holder.videoView.setMediaController(mediaController)
        mediaController.setAnchorView(holder.videoView)

        holder.videoView.setOnPreparedListener { mediaPlayer ->

            mediaPlayer.isLooping = true
            holder.videoView.start()
        }

    }


}