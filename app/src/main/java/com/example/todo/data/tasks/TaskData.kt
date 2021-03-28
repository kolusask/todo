package com.example.todo.data.tasks

import android.graphics.Bitmap
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class TaskData(
    val author: String,
    val comments: List<Comment> = emptyList<Comment>(),
    val creationDate: Date,
    val deadline: Date,
    val description: String = "",
    val followers: List<Follower> = emptyList<Follower>(),
    val name: String,
    val picture: ByteArray,
    val priority: Priority,
    val updateAgeInDays: Int = 0
    ): Parcelable {
    @Parcelize
    data class Follower(
            val description: String,
            val logo: ByteArray,
            val name: String,
            val photo: ByteArray,
            val position: String
    ) : Parcelable {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Follower

            if (description != other.description) return false
            if (!logo.contentEquals(other.logo)) return false
            if (name != other.name) return false
            if (!photo.contentEquals(other.photo)) return false
            if (position != other.position) return false

            return true
        }

        override fun hashCode(): Int {
            var result = description.hashCode()
            result = 31 * result + logo.contentHashCode()
            result = 31 * result + name.hashCode()
            result = 31 * result + photo.contentHashCode()
            result = 31 * result + position.hashCode()
            return result
        }
    }

    @Parcelize
    data class Comment(
            val photo: ByteArray,
            val text: String,
            val time: Date
    ): Parcelable {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Comment

            if (!photo.contentEquals(other.photo)) return false
            if (text != other.text) return false
            if (time != other.time) return false

            return true
        }

        override fun hashCode(): Int {
            var result = photo.contentHashCode()
            result = 31 * result + text.hashCode()
            result = 31 * result + time.hashCode()
            return result
        }
    }

    enum class Priority(val string: String) {
        LOW("LOW"),
        HIGH("HIGH"),
        NORMAL("NORMAL")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TaskData

        if (author != other.author) return false
        if (comments != other.comments) return false
        if (creationDate != other.creationDate) return false
        if (deadline != other.deadline) return false
        if (description != other.description) return false
        if (followers != other.followers) return false
        if (name != other.name) return false
        if (!picture.contentEquals(other.picture)) return false
        if (priority != other.priority) return false
        if (updateAgeInDays != other.updateAgeInDays) return false

        return true
    }

    override fun hashCode(): Int {
        var result = author.hashCode()
        result = 31 * result + comments.hashCode()
        result = 31 * result + creationDate.hashCode()
        result = 31 * result + deadline.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + followers.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + picture.contentHashCode()
        result = 31 * result + priority.hashCode()
        result = 31 * result + updateAgeInDays
        return result
    }
}