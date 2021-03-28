package com.example.todo

import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.todo.data.jobs.JobData
import com.example.todo.databinding.ActivityJobBinding
import com.example.todo.ui.StringView
import com.makeramen.roundedimageview.RoundedImageView

class JobActivity : AppCompatActivity() {
    lateinit var binding: ActivityJobBinding

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<JobData>("content")!!

        binding.apply {
            this.jobCompanyLogoFrame.addView(
                object: RoundedImageView(this@JobActivity) {
                    init {
                        mutateBackground(true)
                        background = BitmapDrawable(
                            resources, BitmapFactory.decodeByteArray(
                                data.companyLogo, 0, data.companyLogo.size)
                        )
                        isOval = true
                    }

                    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
                        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
                        setMeasuredDimension(measuredHeight, measuredHeight)
                    }
                }
            )
            this.jobCompanyName.text = data.companyName
            this.jobPositionName.text = data.jobName
            this.scrollable.apply {
                addView(StringView(context, "PROJECT DESCRIPTION", data.projectDescription))
                addView(StringView(context, "REQUIREMENTS", data.requirements))
                addView(StringView(context, "RESPONSIBILITIES", data.responsibilities))
            }
        }
    }
}