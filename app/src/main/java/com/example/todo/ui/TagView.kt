package com.example.todo.ui

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.example.todo.R
import com.example.todo.data.tasks.TaskData

class TagView : androidx.appcompat.widget.AppCompatTextView {
    constructor(text: String, color: Int, context: Context) : super(context) {
        val drawable = ResourcesCompat.getDrawable(resources, R.drawable.ic_background_shape,
            null)!!.mutate()
        DrawableCompat.setTint(drawable, resources.getColor(color))
        background = drawable
        setTextColor(Color.WHITE)
        gravity = Gravity.CENTER
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 10.toFloat())
        this.text = text
    }
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, style: Int) :
            super(context, attributeSet, style)
}