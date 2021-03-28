package com.example.todo.ui.tasks

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R
import com.example.todo.TaskActivity
import com.example.todo.data.tasks.TaskData
import com.example.todo.databinding.TaskBinding
import com.example.todo.ui.TagView
import com.makeramen.roundedimageview.RoundedImageView
import java.text.SimpleDateFormat
import java.util.*

class TasksRecyclerAdapter(private val tasksList: List<TaskData>) :
    RecyclerView.Adapter<TasksRecyclerAdapter.ViewHolder>() {

    class ViewHolder(private val binding: TaskBinding,
                     private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        private val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        private val timeFormat = SimpleDateFormat("KK:mm a", Locale.getDefault())
        fun bind(taskData: TaskData) {
            binding.apply {
                val color = when(taskData.priority) {
                    TaskData.Priority.LOW -> R.color.priority_low
                    TaskData.Priority.HIGH -> R.color.priority_high
                    TaskData.Priority.NORMAL -> R.color.priority_normal
                }
                priorityFrame.addView(TagView(taskData.priority.string, color, context))
                taskAgeInDays.text =
                    "Updated ${taskData.updateAgeInDays} ${if (taskData.updateAgeInDays == 1) "day" else "days"} ago"
                taskAuthor.text = taskData.author
                taskCreationDate.text = dateFormat.format(taskData.creationDate)
                taskDeadlineDate.text = dateFormat.format(taskData.deadline)
                taskDeadlineTime.text = timeFormat.format(taskData.deadline)
                taskPictureFrame.addView(object : RoundedImageView(context) {
                    val drawable = BitmapDrawable(resources, BitmapFactory.decodeByteArray(
                        taskData.picture,0, taskData.picture.size))
                    init {
                        mutateBackground(true)
                        background = drawable
                        isOval = true
                    }

                    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
                        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
                        setMeasuredDimension(measuredHeight, measuredHeight)
                    }
                })
                taskRowName.text = taskData.name
                taskClickableLayout.setOnClickListener {
                    val intent = Intent(context, TaskActivity::class.java).apply {
                        putExtra("content", taskData)
                    }
                    context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = TaskBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tasksList[position])
    }

    override fun getItemCount(): Int = tasksList.count()
}