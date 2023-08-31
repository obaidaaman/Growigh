package com.example.growgh.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.growgh.Adapter.VideoAdapter
import com.example.growgh.InterfaceAPI.VideoInterfaceAPI
import com.example.growgh.Model.PexelsVideo
import com.example.growgh.Model.PexelsVideoFile
import com.example.growgh.Model.VideoResponse


import com.example.growgh.R
import com.example.growgh.RetrofitUtil.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ShortsFragment : Fragment() {

    private lateinit var viewPager: ViewPager2

  //  private val pexelsApi = RetrofitInstance.VideoApi

    val category = "YOUR_DESIRED_CATEGORY" // Replace with your desired category
    val perPage = 50 // Adjust as needed
    val page = 1 // Adjust as needed
    val ACCES_TOKKEN : String ="83d98306a1a1d40842aa52f6e2fa1243"

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        // Inflate the layout for this fragment
//
//         val view =inflater.inflate(R.layout.fragment_shorts, container, false)
//        viewPager = view?.findViewById(R.id.shortsPager)!!
//       // fetchRandomVideos()
//        fetchVideosFromApi(category, perPage, page)
//return view
//    }

    private fun getRandomVideos(videos: List<VideoResponse>, count: Int): List<VideoResponse> {
        val shuffledVideos = videos.shuffled()
        return shuffledVideos.take(count)
    }


//    private fun fetchVideosFromApi(category: String, perPage: Int, page: Int) {
//        RetrofitInstance.vimeoApiService.getVideos(category, perPage, page,ACCES_TOKKEN)
//            .enqueue(object : Callback<List<VideoResponse>> {
//                override fun onResponse(call: Call<List<VideoResponse>>, response: Response<List<VideoResponse>>) {
//                    if (response.isSuccessful) {
//                        val videos = response.body()
//                        if (videos != null && videos.isNotEmpty()) {
//                            // Now you have a list of videos from the Vimeo API
//                            val randomVideos = getRandomVideos(videos, 10)
//                            // Create VideoItem objects from randomVideos list
//                            val videoItems = randomVideos.map { video ->
//                                VideoResponse(
//                                   video.id,
//                                     video.videoUrl)
//                            }
//                            // Set up ViewPager2 with the videoItems list
//
//                            val adapter = VideoAdapter(videoItems)
//                            viewPager.adapter = adapter
//                        } else {
//                            // Handle empty response or no videos found
//                        }
//                    } else {
//                        // Handle API error
//                    }
//                }
//
//                override fun onFailure(call: Call<List<VideoResponse>>, t: Throwable) {
//                    // Handle network error
//                }
//            })
//    }





    }

//    private fun setupViewPager(videos: List<PexelsVideoFile>) {
//        val adapter = VideoAdapter(videos as ArrayList<PexelsVideo>)
//        viewPager.adapter = adapter
//    }
//    private fun getRandomQuery(): String {
//        val randomQueries = listOf("nature", "travel", "animals", "food", "sports")
//        return randomQueries.random()
//
//    }


