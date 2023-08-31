package com.example.growgh.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.growgh.Model.ImageData
import com.example.growgh.Model.UnsplashUrls
import com.example.growgh.Model.User
import com.example.growgh.RetrofitUtil.RetrofitInstance
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeedViewModel() : ViewModel() {


private  var  MutableImageLiveData= MutableLiveData<List<ImageData>?>()
    private val auth = FirebaseAuth.getInstance()
    private val db = Firebase.firestore
    private var mutableNameLiveData = MutableLiveData<String>()

    val userLiveData: MutableLiveData<String?> = MutableLiveData()

fun getImages(){
    RetrofitInstance.api.getRandomPhotos(10,  "J4TBFwh75K8mqe4r6ODl2U0L-Dk2AgiXi0Smw-6SDP8").enqueue(object : Callback<List<ImageData>?> {
        override fun onResponse(
            call: Call<List<ImageData>?>,
            response: Response<List<ImageData>?>
        ) {
            if (response.body()!=null){
                val images = response.body()
                MutableImageLiveData.value=images

            }
        }

        override fun onFailure(call: Call<List<ImageData>?>, t: Throwable) {

        }
    })
}
    fun observeImages() : MutableLiveData<List<ImageData>?> {
        return MutableImageLiveData
    }

    fun getUserName(){
        val currentUser = FirebaseAuth.getInstance().currentUser
        val userDocument = FirebaseFirestore.getInstance().collection("users").document(currentUser!!.uid)
        userDocument.get().addOnSuccessListener { docSnapshot ->
            val user = docSnapshot.toObject(User::class.java)
            if (user!= null){
                mutableNameLiveData.postValue(user.name)

            }
        }
    }

    fun observeUserName() : LiveData<String>{
        return mutableNameLiveData
    }
}