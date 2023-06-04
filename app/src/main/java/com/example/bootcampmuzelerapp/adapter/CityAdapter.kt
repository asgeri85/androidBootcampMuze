package com.example.bootcampmuzelerapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.bootcampmuzelerapp.databinding.ItemCityBinding
import com.example.bootcampmuzelerapp.model.CityData
import com.example.bootcampmuzelerapp.ui.CityFragmentDirections

class CityAdapter : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    private val cityList = arrayListOf<CityData>()

    inner class CityViewHolder(private val itemCityBinding: ItemCityBinding) :
        RecyclerView.ViewHolder(itemCityBinding.root) {
        fun bind(cityData: CityData) {
            itemCityBinding.city = cityData

            itemCityBinding.cardCity.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(CityFragmentDirections.actionCityFragmentToMuseumFragment(cityData))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val layout = ItemCityBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CityViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return cityList.size
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(cityList[position])
    }

    fun updateList(newList: List<CityData>) {
        cityList.clear()
        cityList.addAll(newList)
        notifyDataSetChanged()
    }
}