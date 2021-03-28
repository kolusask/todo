package com.example.todo.data.tasks

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.todo.R
import java.io.ByteArrayOutputStream
import java.text.SimpleDateFormat
import java.util.*

class MockTaskDataProvider(private val resources: Resources) : TaskDataProvider {
    private val creationDateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.US)
    private val deadlineDateFormat = SimpleDateFormat(
        "MMMM dd, yyyy hh:mm", Locale.US)
    private val commentDateFormat = SimpleDateFormat(
        "dd/MM/yyyy hh:mm", Locale.US
    )
    private fun toByteArray(png: Int) =
        ByteArrayOutputStream().also {
            BitmapFactory.decodeResource(resources, png)
                .compress(Bitmap.CompressFormat.PNG, 100, it)
        }.toByteArray()

    override fun get(): List<TaskData> = listOf(
        TaskData(
            author = "Tom Cruise",
            comments = listOf(
                TaskData.Comment(
                    toByteArray(R.drawable.ilya_ryabukhin_female),
                    "Fine, but please change the color according to the layout",
                    commentDateFormat.parse("02/03/2021 11:48")!!
                ),
                TaskData.Comment(
                    toByteArray(R.drawable.avatar),
                    "Task completed. You can check it",
                    commentDateFormat.parse("02/03/2021 09:21")!!
                )
            ),
            creationDate = creationDateFormat.parse("24.05.2019")!!,
            deadline = deadlineDateFormat.parse("May 26, 2019 6:30 PM")!!,
            picture = toByteArray(R.drawable.tom_cruise),
            priority = TaskData.Priority.HIGH,
            name = "Contact Email not Linked",
            description = "I want to link contact email",
            updateAgeInDays = 1,
            followers = listOf(
                TaskData.Follower(
                    "Manager from company",
                    toByteArray(R.drawable.cvut_logo),
                    "Ilya Ryabukhin",
                    toByteArray(R.drawable.ilya_ryabukhin_female),
                    "Junior Product Designer"
                ),
                TaskData.Follower(
                    "Manager from university",
                    toByteArray(R.drawable.cvut_logo),
                    "Ilya Ryabukhin",
                    toByteArray(R.drawable.ilya_ryabukhin_male),
                    "HTML Teacher"
                )
            )
        ),
        TaskData(
            author = "Matt Damon",
            creationDate = creationDateFormat.parse("24.05.2019")!!,
            deadline = deadlineDateFormat.parse("May 26, 2019 8:00 AM")!!,
            picture = toByteArray(R.drawable.matt_damon),
            priority = TaskData.Priority.LOW,
            name = "Change html component",
            updateAgeInDays = 1
        ),
        TaskData(
            author = "Robert Downey",
            creationDate = creationDateFormat.parse("24.05.2019")!!,
            deadline = deadlineDateFormat.parse("May 26, 2019 07:30 PM")!!,
            picture = toByteArray(R.drawable.robert_downey),
            priority = TaskData.Priority.HIGH,
            name = "Redesign button",
            updateAgeInDays = 1
        ),
        TaskData(
            author = "Christian Bale",
            creationDate = creationDateFormat.parse("24.05.2019")!!,
            deadline = deadlineDateFormat.parse("May 25, 2019 04:00 PM")!!,
            picture = toByteArray(R.drawable.christian_bale),
            priority = TaskData.Priority.NORMAL,
            name = "Payment not going through",
            updateAgeInDays = 2
        ),
        TaskData(
            author = "Henry Cavil",
            creationDate = creationDateFormat.parse("24.05.2019")!!,
            deadline = deadlineDateFormat.parse("May 25, 2019 04:00 PM")!!,
            picture = toByteArray(R.drawable.henry_cavil),
            priority = TaskData.Priority.HIGH,
            name = "Unable to add replies",
            updateAgeInDays = 2
        ),
        TaskData(
            author = "Chris Evans",
            creationDate = creationDateFormat.parse("23.05.2019")!!,
            deadline = deadlineDateFormat.parse("May 25, 2019 02:00 PM")!!,
            picture = toByteArray(R.drawable.chris_evans),
            priority = TaskData.Priority.NORMAL,
            name = "Downtime since last week",
            updateAgeInDays = 3
        ),
        TaskData(
            author = "Sam Smith",
            creationDate = creationDateFormat.parse("22.05.2019")!!,
            deadline = deadlineDateFormat.parse("May 25, 2019 11:30 AM")!!,
            picture = toByteArray(R.drawable.sam_smith),
            priority = TaskData.Priority.LOW,
            name = "Referral Bonus",
            updateAgeInDays = 4
        ),
        TaskData(
            author = "Steve Rogers",
            creationDate = creationDateFormat.parse("21.05.2019")!!,
            deadline = deadlineDateFormat.parse("May 24, 2019 01:00 PM")!!,
            picture = toByteArray(R.drawable.steve_rogers),
            priority = TaskData.Priority.NORMAL,
            name = "Add design kit",
            updateAgeInDays = 6
        )
    )
}