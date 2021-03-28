package com.example.todo.ui.navigation

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.todo.ui.jobs.JobsFragment
import com.example.todo.ui.messages.MessagesFragment
import com.example.todo.ui.profile.ProfileFragment
import com.example.todo.ui.progress.ProgressFragment
import com.example.todo.ui.tasks.TasksFragment
import java.security.InvalidParameterException

class TodoPagerAdapter(fragment: Fragment) :
        FragmentStateAdapter(fragment) {
    override fun getItemCount() = 5

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> ProfileFragment()
        1 -> MessagesFragment()
        2 -> TasksFragment()
        3 -> JobsFragment()
        4 -> ProgressFragment()
        else -> throw InvalidParameterException("No position $position")
    }
}