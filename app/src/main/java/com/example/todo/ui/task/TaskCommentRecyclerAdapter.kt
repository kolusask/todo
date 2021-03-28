package com.example.todo.ui.task

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.data.tasks.TaskData
import com.example.todo.databinding.TaskCommentBinding
import com.makeramen.roundedimageview.RoundedImageView
import java.text.SimpleDateFormat
import java.util.*

class TaskCommentRecyclerAdapter(private val comments: List<TaskData.Comment>) :
        RecyclerView.Adapter<TaskCommentRecyclerAdapter.ViewHolder>() {
    class ViewHolder(private val binding: TaskCommentBinding, private val context: Context) :
            RecyclerView.ViewHolder(binding.root) {
        private val commentDateFormat = SimpleDateFormat(
            "dd/MM/yyyy hh:mm", Locale.US
        )
        fun bind(comment: TaskData.Comment) {
            binding.apply {
                this.taskCommentPictureFrame.addView(
                    object: RoundedImageView(context) {
                        init {
                            mutateBackground(true)
                            background = BitmapDrawable(
                                resources, BitmapFactory.decodeByteArray(
                                    comment.photo, 0, comment.photo.count())
                            )
                            isOval = true
                            layoutParams = ViewGroup.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.MATCH_PARENT)
                        }

                        override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
                            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
                            setMeasuredDimension(measuredHeight, measuredHeight)
                        }
                    }
                )
                this.taskCommentText.text = comment.text
                this.taskCommentTime.text = commentDateFormat.format(comment.time)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = TaskCommentBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(comments[position])
    }

    override fun getItemCount(): Int = comments.count()
}