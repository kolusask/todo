package com.example.todo.ui.jobs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo.R
import com.example.todo.data.jobs.JobDataProvider
import com.example.todo.databinding.FragmentJobsBinding

class JobsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentJobsBinding.inflate(LayoutInflater.from(context)).apply {
        jobsRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,
                false)
        jobsRecycler.adapter = JobsRecyclerAdapter(dataProvider.get())
    }.root

    companion object {
        lateinit var dataProvider: JobDataProvider
    }
}