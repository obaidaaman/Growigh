package com.example.growgh.Activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.growgh.Adapter.ImageAdapter
import com.example.growgh.Model.ImageData
import com.example.growgh.RetrofitUtil.RetrofitInstance
import com.example.growgh.databinding.ActivityFeedsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeedsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFeedsBinding

    val clientID = "J4TBFwh75K8mqe4r6ODl2U0L-Dk2AgiXi0Smw-6SDP8"

    var imageadapter = ImageAdapter(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFeedsBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.feedsRecyclerView.layoutManager = LinearLayoutManager(this)

        binding.feedsRecyclerView.adapter = imageadapter

        binding.recylerRefresh.setOnRefreshListener {

            loadImages()

        }

        loadImages()

    }

    private fun loadImages() {

        RetrofitInstance.api.getRandomPhotos(10, clientID)
            .enqueue(object : Callback<List<ImageData>?> {

                override fun onResponse(
                    call: Call<List<ImageData>?>,
                    response: Response<List<ImageData>?>
                ) {

                    if (response.isSuccessful) {

                        val images = response.body()

                        if (images != null) {

                            imageadapter = ImageAdapter(images)
                            binding.feedsRecyclerView.adapter = imageadapter
                            imageadapter.notifyDataSetChanged()

                        }
                    }

                    binding.recylerRefresh.isRefreshing = false

                }


                override fun onFailure(call: Call<List<ImageData>?>, t: Throwable) {
                    Toast.makeText(this@FeedsActivity, "", Toast.LENGTH_SHORT).show()

                    binding.recylerRefresh.isRefreshing = false

                }

            })

    }
}