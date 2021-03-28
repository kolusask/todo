package com.example.todo.data.jobs

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.todo.R
import java.io.ByteArrayOutputStream

class MockJobDataProvider(val resources: Resources) : JobDataProvider {
    override fun get(): List<JobData> = listOf(
        JobData(
            companyLogo = ByteArrayOutputStream().also {
                BitmapFactory.decodeResource(resources, R.drawable.company_name)
                    .compress(Bitmap.CompressFormat.PNG, 100, it)
            }.toByteArray(),
            companyName = "Druzhka",
            jobName = "Frontent Developer",
            projectDescription = "The Druzhka chain of stores has been operating since " +
                    "2005, and currently more than 200 stores are open in Moscow, the Moscow " +
                    "Region, St. Petersburg, Rostov-on-Don, Ryazan and Yaroslavl. We invite you " +
                    "to join our team",
            requirements = "Experience of at least 3 years in the stack - JavaScript, CSS " +
                    "(with preprocessors), html, gulp/webpack for building;\n" +
                    "Cross-browser adaptive layout;\n" +
                    "Availability of ready-made projects with the ability to demonstrate the " +
                    "source code;\n" +
                    "Experience working in teams.",
            responsibilities = "Layout of a complex website based on layouts;\n" +
                    "Component design;\n" +
                    "Implementation of the frontend, taking into account the speed of " +
                    "rendering/loading pages;\n" +
                    "In our work we use: webpack, gulp, scss, component approach.",
            salary = 3000,
            shortDescription = "Create a website based on an existing layout",
            tags = listOf("HTML", "JAVA SCRIPT", "CSS"),
        ),
        JobData(
            companyLogo = ByteArrayOutputStream().also {
                BitmapFactory.decodeResource(resources, R.drawable.company_name)
                    .compress(Bitmap.CompressFormat.PNG, 100, it)
            }.toByteArray(),
            companyName = "Gridnine Systems",
            jobName = "Frontent Developer",
            shortDescription = "Create a website based on an existing layout",
            tags = listOf("HTML", "JAVA SCRIPT", "CSS")
        )
    )
}