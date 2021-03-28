package com.example.todo.ui.jobs

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.JobActivity
import com.example.todo.R
import com.example.todo.data.jobs.JobData
import com.example.todo.databinding.JobBinding
import com.example.todo.ui.TagView

class JobsRecyclerAdapter(private val jobData: List<JobData>) :
        RecyclerView.Adapter<JobsRecyclerAdapter.ViewHolder>() {
    class ViewHolder(private val binding: JobBinding, val context: Context) : RecyclerView.ViewHolder(binding.root) {
        private fun setOrHide(textView: TextView, text: String) {
            if (text.isEmpty())
                textView.visibility = TextView.GONE
            else
                textView.text = text
        }

        fun bind(job: JobData) {
            setOrHide(binding.jobCompanyName, job.companyName)
            setOrHide(binding.jobDescription, job.shortDescription)
            setOrHide(binding.jobName, job.jobName)
            setOrHide(binding.jobSalary,
                    if (job.salary == null) "" else job.salary.toString() + "$")
            val tagColors = listOf(R.color.priority_high, R.color.priority_low,
                    R.color.priority_normal)
            job.tags.forEachIndexed { index: Int, tag: String ->
                binding.jobTags.addView(TagView(tag, tagColors[index], context))
            }
            binding.jobClickableLayout.setOnClickListener {
                val intent = Intent(context, JobActivity::class.java).apply {
                    putExtra("content", job)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(JobBinding.inflate(LayoutInflater.from(parent.context), parent, false),
                parent.context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(jobData[position])
    }

    override fun getItemCount() = jobData.count()
}