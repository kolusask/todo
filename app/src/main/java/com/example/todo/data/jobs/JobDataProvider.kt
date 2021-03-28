package com.example.todo.data.jobs
interface JobDataProvider {

    fun get(): List<JobData>
}