package com.example.todo.ui.task

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.data.tasks.TaskData
import com.example.todo.databinding.TaskFollowerBinding
import com.makeramen.roundedimageview.RoundedImageView

class TaskFollowerRecyclerAdapter(private val followers: List<TaskData.Follower>) :
        RecyclerView.Adapter<TaskFollowerRecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: TaskFollowerBinding, private val context: Context) :
            RecyclerView.ViewHolder(binding.root) {
        fun bind(follower: TaskData.Follower, position: Int) {
            binding.apply {
                this.taskFollowerDescription.text = follower.description
                this.taskFollowerLogoFrame.addView(
                    object: RoundedImageView(context) {
                        init {
                            mutateBackground(true)
                            background = BitmapDrawable(
                                resources, BitmapFactory.decodeByteArray(
                                    follower.logo, 0, follower.logo.size
                                )
                            )
                            isOval = true
                        }

                        override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
                            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
                            setMeasuredDimension(measuredHeight, measuredHeight)
                        }
                    }
                )
                this.taskFollowerName.text = follower.name
                this.taskFollowerPhotoFrame.addView(
                    object: RoundedImageView(context) {
                        init {
                            mutateBackground(true)
                            background = BitmapDrawable(
                                resources, BitmapFactory.decodeByteArray(
                                    follower.photo, 0, follower.photo.size
                                )
                            )
                            isOval = true
                        }

                        override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
                            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
                            setMeasuredDimension(measuredHeight, measuredHeight)
                        }
                    }
                )
                this.taskFollowerPosition.text = follower.position
                this.taskFollowerLogoFrame.bringToFront()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TaskFollowerBinding.inflate(inflater, parent, false)
        return ViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(followers[position], position)
    }

    override fun getItemCount(): Int = followers.count()
}