package com.example.todo.ui

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.Space
import android.widget.TextView
import com.example.todo.data.profile.ProfileData

class DataSectionListView<T> : LinearLayout {
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, style: Int) :
            super(context, attributeSet, style)
    constructor(context: Context, name: String, list: List<T>, fill: (T) -> View) : super(context) {
        orientation = VERTICAL
        if (list.isNotEmpty()) {
            addView(TextView(context).apply {
                text = name
                textSize = 16.toFloat()
            })
            addView(Space(context).apply { minimumHeight = 50 })
            list.forEach {
                addView(fill(it))
                addView(Space(context).apply { minimumHeight = 50 })
            }
        }
    }
}