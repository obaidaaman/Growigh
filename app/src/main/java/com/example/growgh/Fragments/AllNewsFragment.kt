package com.example.growgh.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.growgh.R
import com.example.growgh.RetrofitUtil.RetrofitInstance
import com.example.growgh.ViewModel.NewsViewModel


class AllNewsFragment : Fragment() {

    private lateinit var NewsMVVM : NewsViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_news, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NewsMVVM =ViewModelProvider(this)[NewsViewModel::class.java]

        NewsMVVM.fetchNews("in",10,RetrofitInstance.BASE_URL_NEWS)
        NewsMVVM.observeNewsData().observe(viewLifecycleOwner){

        }
    }

}