package com.example.todo.ui

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.Space
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.example.todo.R

class StringView : LinearLayout {
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    constructor(context: Context, name: String, content: String) : super(context) {
        orientation = VERTICAL
        id = View.generateViewId()

        if (content.isNotEmpty()) {
            addView(TextView(context).apply {
                text = name
                textSize = 16.toFloat()
            })
            addView(Space(context).apply { minimumHeight = 50 })
            val linearLayout = LinearLayout(context).apply {
                orientation = VERTICAL
                id = View.generateViewId()
                addView(TextView(context).apply { text = content })
            }
            val frame = FrameLayout(context).apply {
                background = ResourcesCompat.getDrawable(resources, R.drawable.ic_background_shape, null)
                val params = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT)
                val margin = context.resources.displayMetrics.density.toInt() * 20
                params.setMargins(margin, margin, margin, margin)
                addView(linearLayout, params)
            }
            addView(frame)
            addView(Space(context).apply { minimumHeight = 50 })
        }
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, style: Int) :
            super(context, attributeSet, style)

}