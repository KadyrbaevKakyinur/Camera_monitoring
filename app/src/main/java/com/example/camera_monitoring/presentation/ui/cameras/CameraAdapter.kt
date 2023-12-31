package com.example.camera_monitoring.presentation.ui.cameras

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.camera_monitoring.R
import com.example.camera_monitoring.databinding.ItemCameraBinding
import com.example.camera_monitoring.domain.models.CameraModel

open class CameraAdapter : Adapter<CameraAdapter.CameraViewHolder>() {
    private var list = listOf<CameraModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(model: List<CameraModel>) {
        list = model
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CameraViewHolder {
        return CameraViewHolder(
            ItemCameraBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CameraViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class CameraViewHolder(private val binding: ItemCameraBinding) :
        ViewHolder(binding.root) {
        fun onBind(camera: CameraModel) {
            with(binding) {
                tvName.text = camera.name
                Glide.with(ivCamera).load(camera.image.toString()).into(ivCamera)
                ivFavIcon.setOnClickListener {
                    if (camera.isFavourite) {
                        ivFavIcon.setImageResource(R.drawable.icon_star_empty)
                    } else {
                        ivFavIcon.setImageResource(R.drawable.icon_star_full)
                    }
                    camera.isFavourite = !camera.isFavourite
                }
            }
        }
    }
}