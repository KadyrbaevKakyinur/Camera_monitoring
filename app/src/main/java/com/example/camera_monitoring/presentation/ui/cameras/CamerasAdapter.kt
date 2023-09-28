package com.example.camera_monitoring.presentation.ui.cameras

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.camera_monitoring.R
import com.example.camera_monitoring.data.model.Camera
import com.example.camera_monitoring.databinding.ItemCameraBinding

class CamerasAdapter : Adapter<CamerasAdapter.CameraViewHolder>() {

    private val list = arrayListOf(
        Camera(
            1, "Камера 1", "https://serverspace.ru/wp-content/uploads/2019/06/backup-i-snapshot.png"
        ), Camera(
            2, "Камера 2", "https://serverspace.ru/wp-content/uploads/2019/06/backup-i-snapshot.png"
        ), Camera(
            3, "Камера 3", "https://serverspace.ru/wp-content/uploads/2019/06/backup-i-snapshot.png"
        ), Camera(
            4, "Камера 4", "https://serverspace.ru/wp-content/uploads/2019/06/backup-i-snapshot.png"
        )
    )

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
        fun onBind(camera: Camera) {
            with(binding) {
                tvName.text = camera.name
                Glide.with(ivCamera).load(camera.image).into(ivCamera)
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