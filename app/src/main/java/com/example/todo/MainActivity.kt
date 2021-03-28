package com.example.todo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.todo.data.jobs.MockJobDataProvider
import com.example.todo.data.profile.MockProfileDataProvider
import com.example.todo.data.tasks.MockTaskDataProvider
import com.example.todo.databinding.TaskBinding
import com.example.todo.ui.jobs.JobsFragment
import com.example.todo.ui.profile.ProfileFragment
import com.example.todo.ui.tasks.TasksFragment
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ProfileFragment.dataProvider = MockProfileDataProvider(resources)
        TasksFragment.dataProvider = MockTaskDataProvider(resources)
        JobsFragment.dataProvider = MockJobDataProvider(resources)
    }
}