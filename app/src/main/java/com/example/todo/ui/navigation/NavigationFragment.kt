package com.example.todo.ui.navigation

import android.graphics.BitmapFactory
import android.graphics.BlendMode
import android.graphics.PorterDuff
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.BitmapCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.todo.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class NavigationFragment : Fragment() {
    private lateinit var tabNames : List<String>
    private lateinit var icons : List<Drawable>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        tabNames = listOf<Int>(R.string.title_profile, R.string.title_messages,
                R.string.title_tasks, R.string.title_jobs, R.string.title_progress).map {
            resources.getString(it)
        }
        icons = listOf(
                R.drawable.ic_profile, R.drawable.ic_messages, R.drawable.ic_tasks,
                R.drawable.ic_jobs, R.drawable.ic_progress).map {
            ResourcesCompat.getDrawable(resources, it, null)!!

                }
        return inflater.inflate(
                R.layout.fragment_navigation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val pager = view.findViewById<ViewPager2>(R.id.view_pager)
        pager.adapter = TodoPagerAdapter(this)
        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)
        TabLayoutMediator(tabLayout, pager) { tab, position ->
            tab.text = tabNames[position]
            tab.icon = icons[position]
        }.attach()
    }
}