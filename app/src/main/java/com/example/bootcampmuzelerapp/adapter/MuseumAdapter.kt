package com.example.bootcampmuzelerapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bootcampmuzelerapp.databinding.ItemMuseumBinding
import com.example.bootcampmuzelerapp.model.MuseumData

class MuseumAdapter : RecyclerView.Adapter<MuseumAdapter.MuseumViewHolder>() {

    private val museumList = arrayListOf<MuseumData>()

    inner class MuseumViewHolder(private val itemMuseumBinding: ItemMuseumBinding) :
        RecyclerView.ViewHolder(itemMuseumBinding.root) {
        fun bind(museumData: MuseumData) {
            itemMuseumBinding.museum = museumData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MuseumViewHolder {
        val layout = ItemMuseumBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MuseumViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return museumList.size
    }

    override fun onBindViewHolder(holder: MuseumViewHolder, position: Int) {
        holder.bind(museumList[position])
    }

    fun updateList(newList: List<MuseumData>) {
        museumList.clear()
        museumList.addAll(newList)
        notifyDataSetChanged()
    }
}