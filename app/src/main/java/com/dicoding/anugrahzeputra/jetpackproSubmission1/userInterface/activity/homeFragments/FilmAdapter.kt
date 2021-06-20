package com.dicoding.anugrahzeputra.jetpackproSubmission1.userInterface.activity.homeFragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.anugrahzeputra.jetpackproSubmission1.databinding.ItemlistRvBinding
import com.dicoding.anugrahzeputra.jetpackproSubmission1.objectModels.FilmModel
import com.dicoding.anugrahzeputra.jetpackproSubmission1.utility.AppHelper.setGlideImage
import java.util.*


class FilmAdapter(private val cb: FilmCallback) :
    RecyclerView.Adapter<FilmAdapter.ListViewHolder>() {
    private val listData = ArrayList<FilmModel>()

    fun setData(data: List<FilmModel>?) {
        if (data == null) return
        listData.clear()
        listData.addAll(data)
    }

    inner class ListViewHolder(private val binding: ItemlistRvBinding ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(film: FilmModel) {
            with(itemView) {
                setGlideImage(context, film.poster, binding.itemImage)
                binding.itemTitle.text = film.name
                binding.itemDescription.text = film.desc

                binding.cardview.setOnClickListener {
                    cb.onItemClicked(film)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder =
        ListViewHolder(
            ItemlistRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listData[position])
    }

}