package com.example.todo.ui.profile

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.Space
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.todo.data.profile.ProfileData
import com.example.todo.data.profile.ProfileDataProvider
import com.example.todo.databinding.ProfileEducationBinding
import com.example.todo.databinding.ProfileExperienceBinding
import com.example.todo.databinding.ProfileProjectsBinding
import com.example.todo.ui.DataSectionListView
import com.example.todo.ui.StringView
import java.util.*

fun countryCodeToEmojiFlag(countryCode: String): String {
    return countryCode
        .toUpperCase(Locale.US)
        .map { char ->
            Character.codePointAt("$char", 0) - 0x41 + 0x1F1E6
        }
        .map { codePoint ->
            Character.toChars(codePoint)
        }
        .joinToString(separator = "") { charArray ->
            String(charArray)
        }
}

fun String.toFlagEmoji(): String {
    // 1. It first checks if the string consists of only 2 characters: ISO 3166-1 alpha-2 two-letter country codes (https://en.wikipedia.org/wiki/Regional_Indicator_Symbol).
    if (this.length != 2) {
        return this
    }

    val countryCodeCaps = this.toUpperCase() // upper case is important because we are calculating offset
    val firstLetter = Character.codePointAt(countryCodeCaps, 0) - 0x41 + 0x1F1E6
    val secondLetter = Character.codePointAt(countryCodeCaps, 1) - 0x41 + 0x1F1E6

    // 2. It then checks if both characters are alphabet
    if (!countryCodeCaps[0].isLetter() || !countryCodeCaps[1].isLetter()) {
        return this
    }

    return String(Character.toChars(firstLetter)) + String(Character.toChars(secondLetter))
}

class ProfileFragment : Fragment() {
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val data = dataProvider.get("")

        val linearLayout = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            addView(HeaderView(data, requireContext()))
            addView(Space(context).apply { minimumHeight = 50 })
            addView(DataSectionListView<ProfileData.Experience>(
                context, "EXPERIENCE",
                data.experience
            ) {
                ProfileExperienceBinding.inflate(LayoutInflater.from(context)).apply {
                    this.company.text = it.company
                    this.description.text = it.description
                    this.position.text = it.position
                    this.profileExperienceTermAndAddress.text = "${it.term}, ${it.address}"
                }.root
            })
            addView(DataSectionListView<ProfileData.Education>(
                context, "EDUCATION",
                data.education
            ) {
                ProfileEducationBinding.inflate(LayoutInflater.from(context)).apply {
                    this.profileEducationTermAndAddress.text = "${it.term}, ${it.address}"
                    this.program.text = it.program
                    this.school.text = it.school
                }.root
            })
            addView(DataSectionListView<ProfileData.Project>(
                context, "PROJECTS",
                data.projects
            ) {
                ProfileProjectsBinding.inflate(LayoutInflater.from(context)).apply {
                    this.description.text = it.description
                    this.name.text = it.name
                    this.profileProjectTermAndAddress.text = "${it.term}, ${it.address}"
                }.root
            })
            addView(StringView(context, "INDUSTRY SKILLS",
                data.industrySkills.joinToString(separator = "\n")))
            addView(StringView(context, "OTHER SKILLS",
                data.otherSkills.joinToString(separator = "\n")))
            addView(StringView(context, "LANGUAGES", data.languages.map {
                countryCodeToEmojiFlag(it.country)
            }.joinToString(separator = "\n")))
        }
        val marginLayoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
        )
        val margins = requireContext().resources.displayMetrics.density.toInt() * 20
        marginLayoutParams.setMargins(margins, margins, margins, margins)
        return ScrollView(context).apply {
            addView(linearLayout, marginLayoutParams)
        }
    }

    companion object {
        lateinit var dataProvider: ProfileDataProvider
    }

}