package com.example.todo.ui.profile

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import com.example.todo.data.profile.ProfileData
import com.example.todo.databinding.ProfileHeaderBinding

class HeaderView(data: ProfileData, context: Context) :
        FrameLayout(context) {
    constructor(context: Context, attributeSet: AttributeSet) :
            this(ProfileData(), context)
    constructor(context: Context, attributeSet: AttributeSet, style: Int) :
            this(ProfileData(), context)
    init {
        addView(ProfileHeaderBinding.inflate(LayoutInflater.from(context)).apply {
            textAddress.text = data.address
            avatarLayout.addView(ImageView(context).apply { setImageBitmap(data.avatar) })
            textEmail.text = data.email
            textName.text = data.name
            textPhoneNumber.text = data.phoneNumber
            textPosition.text = data.position
        }.root)
    }
}