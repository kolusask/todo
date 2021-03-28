package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo.data.tasks.TaskData
import com.example.todo.databinding.ActivityTaskBinding
import com.example.todo.ui.task.TaskCommentRecyclerAdapter
import com.example.todo.ui.task.TaskFollowerRecyclerAdapter
import com.example.todo.ui.tasks.TasksFragment
import java.security.InvalidParameterException
import java.text.SimpleDateFormat
import java.util.*

class TaskActivity : AppCompatActivity() {
    lateinit var binding: ActivityTaskBinding

    val dateFormat = SimpleDateFormat("MMM dd", Locale.US)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val data = intent.getParcelableExtra<TaskData>("content")!!
        binding.apply {
            this.taskDate.text = dateFormat.format(data.creationDate)
            this.taskDescription.text = data.description
            this.taskName.text = data.name
            this.taskFollowersRecycler.apply {
                layoutManager = GridLayoutManager(context, 1, GridLayoutManager.VERTICAL,
                    false)
                adapter = TaskFollowerRecyclerAdapter(data.followers)
            }
            this.taskCommentsRecycler.apply {
                layoutManager = GridLayoutManager(context, 1, GridLayoutManager.VERTICAL,
                    false)
                adapter = TaskCommentRecyclerAdapter(data.comments)
            }
        }
    }
}