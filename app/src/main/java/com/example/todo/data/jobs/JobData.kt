package com.example.todo.data.jobs

import android.graphics.Bitmap
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class JobData(
    val companyName: String,
    val companyLogo: ByteArray,
    val jobName: String,
    val salary : Int? = null,
    val tags: List<String> = emptyList<String>(),
    val projectDescription: String = "",
    val shortDescription: String = "",
    val responsibilities: String = "",
    val requirements: String = "",
) : Parcelable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as JobData

        if (companyName != other.companyName) return false
        if (!companyLogo.contentEquals(other.companyLogo)) return false
        if (jobName != other.jobName) return false
        if (salary != other.salary) return false
        if (tags != other.tags) return false
        if (projectDescription != other.projectDescription) return false
        if (shortDescription != other.shortDescription) return false
        if (responsibilities != other.responsibilities) return false
        if (requirements != other.requirements) return false

        return true
    }

    override fun hashCode(): Int {
        var result = companyName.hashCode()
        result = 31 * result + companyLogo.contentHashCode()
        result = 31 * result + jobName.hashCode()
        result = 31 * result + (salary ?: 0)
        result = 31 * result + tags.hashCode()
        result = 31 * result + projectDescription.hashCode()
        result = 31 * result + shortDescription.hashCode()
        result = 31 * result + responsibilities.hashCode()
        result = 31 * result + requirements.hashCode()
        return result
    }
}