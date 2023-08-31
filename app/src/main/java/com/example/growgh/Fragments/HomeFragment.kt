package com.example.growgh.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.growgh.Activities.UploadImagesActivity
import com.example.growgh.Adapter.ImageAdapter
import com.example.growgh.Model.ImageData
import com.example.growgh.Model.User
import com.example.growgh.RetrofitUtil.RetrofitInstance
import com.example.growgh.ViewModel.FeedViewModel
import com.example.growgh.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private var isScrolling = false
    var lastVisibleItemPosition = 0
    private lateinit var FeedMVVM : FeedViewModel
    private lateinit var firebaseAuth: FirebaseAuth

    val clientID = "J4TBFwh75K8mqe4r6ODl2U0L-Dk2AgiXi0Smw-6SDP8"

    private lateinit var _binding: FragmentHomeBinding
    private val binding get() = _binding

    var imageadapter = ImageAdapter(emptyList())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


firebaseAuth= FirebaseAuth.getInstance()



        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

FeedMVVM =ViewModelProvider(this)[FeedViewModel::class.java]

      FeedMVVM.getUserName()

        observeName()

        binding.feedsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        binding.feedsRecyclerView.adapter = imageadapter

        binding.feedsRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){


            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                isScrolling = newState == RecyclerView.SCROLL_STATE_IDLE
                if (isScrolling) {
               binding.btnUploadImage.show()
                } else {
                    // If scrolling hasn't stopped, remove any existing callbacks to prevent showing the FloatingActionButton prematurely
                    binding.btnUploadImage.hide()
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy>0){
                    val layoutManager = recyclerView.layoutManager
                    if (layoutManager is LinearLayoutManager) {
                        lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()
                    }

                    if (lastVisibleItemPosition < layoutManager!!.itemCount - 1) {
                        binding.btnUploadImage.hide()
                    }
                }
            }
        })


        binding.btnUploadImage.setOnClickListener {
            startActivity(Intent(requireContext(),UploadImagesActivity::class.java))


        }



        FeedMVVM.getImages()
        binding.recylerRefresh.setOnRefreshListener {

            observeRandomImages()

        }

      observeRandomImages()
        return binding.root
//

    }

    private fun observeName() {
        FeedMVVM.observeUserName().observe(viewLifecycleOwner){name ->
            binding.txtGreetingName.text=name.toString()
        }
    }

//

  private fun observeRandomImages(){
      FeedMVVM.observeImages().observe(viewLifecycleOwner
      ) {image ->
      imageadapter= ImageAdapter(image)
          binding.feedsRecyclerView.adapter=imageadapter
          imageadapter.notifyDataSetChanged()
      }
      binding.recylerRefresh.isRefreshing = false
  }




    }
