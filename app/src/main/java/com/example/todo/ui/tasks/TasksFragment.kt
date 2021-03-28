package com.example.todo.ui.tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.todo.R
import com.example.todo.data.tasks.TaskDataProvider
import com.example.todo.databinding.FragmentTasksBinding

class TasksFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentTasksBinding.inflate(LayoutInflater.from(context)).apply {
            tasksRecycler.layoutManager = GridLayoutManager(context, 1, GridLayoutManager.VERTICAL, false)
            tasksRecycler.adapter = TasksRecyclerAdapter(dataProvider.get())
        }.root
    }

    companion object {
        lateinit var dataProvider : TaskDataProvider
    }
}