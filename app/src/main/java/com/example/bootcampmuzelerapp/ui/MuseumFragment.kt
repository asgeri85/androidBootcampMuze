package com.example.bootcampmuzelerapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bootcampmuzelerapp.R
import com.example.bootcampmuzelerapp.adapter.MuseumAdapter
import com.example.bootcampmuzelerapp.api.ApiUtils
import com.example.bootcampmuzelerapp.databinding.FragmentMuseumBinding
import com.example.bootcampmuzelerapp.model.MuseumResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MuseumFragment : Fragment() {
    private var _binding: FragmentMuseumBinding? = null
    private val binding get() = _binding!!
    private val args: MuseumFragmentArgs by navArgs()
    private val museumAdapter = MuseumAdapter()
    private val api = ApiUtils.getMuseumApi()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMuseumBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textView2.text = args.cityData.sehir
        setRecycler()
        getMuseumData()
    }

    private fun getMuseumData() {
        api.getAllMuseum(args.cityData.slug).enqueue(object : Callback<MuseumResponse> {
            override fun onResponse(
                call: Call<MuseumResponse>,
                response: Response<MuseumResponse>
            ) {
                if (response.isSuccessful) {
                    if (response.body()?.status == "success") {
                        response.body()?.let {
                            museumAdapter.updateList(it.data)
                            Log.e("gelenData", it.data.toString())
                        }

                    }
                }
            }

            override fun onFailure(call: Call<MuseumResponse>, t: Throwable) {

            }

        })
    }

    private fun setRecycler() {
        with(binding.rvMuseum) {
            layoutManager = LinearLayoutManager(context)
            adapter = museumAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}