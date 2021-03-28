package com.example.todo.data.profile

import android.graphics.Bitmap
import java.text.SimpleDateFormat
import java.util.*

import java.util.Locale
//

class ProfileData {
    lateinit var avatar: Bitmap
    lateinit var name: String
    lateinit var position: String
    lateinit var email: String
    lateinit var phoneNumber: String
    lateinit var address: String

    data class Term (
        val start: Date,
        val end: Date?
    ) {
        override fun toString() : String {
            val format = SimpleDateFormat("MMM yyyy", Locale.getDefault())
            return format.format(start) + " - " + if (end == null) "Present" else format.format(end)
        }
    }

    data class Experience (
        val position: String,
        val company: String,
        val term: Term,
        val address: String,
        val description: String
            )
    var experience = emptyList<Experience>()

    data class Education (
        val program: String,
        val school: String,
        val term: Term,
        val address: String
            )
    var education = emptyList<Education>()

    data class Project (
        val name: String,
        val description: String,
        val term: Term?,
        val address: String?
            )
   var projects = emptyList<Project>()

    var industrySkills = emptyList<String>()
    var otherSkills = emptyList<String>()
    var languages = emptyList<Locale>()
}
