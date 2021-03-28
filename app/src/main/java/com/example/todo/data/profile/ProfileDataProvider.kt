package com.example.todo.data.profile

interface ProfileDataProvider {
    fun get(id: String): ProfileData
}