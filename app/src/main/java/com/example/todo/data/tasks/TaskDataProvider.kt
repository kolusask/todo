package com.example.todo.data.tasks

interface TaskDataProvider {
    fun get(): List<TaskData>
}