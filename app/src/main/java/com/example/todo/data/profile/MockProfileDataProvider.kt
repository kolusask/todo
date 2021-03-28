package com.example.todo.data.profile

import android.content.res.Resources
import android.graphics.BitmapFactory
import android.provider.ContactsContract
import com.example.todo.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MockProfileDataProvider(private val resources: Resources) : ProfileDataProvider {
    override fun get(id: String): ProfileData {
        val data = ProfileData()

        val yearDataFormat = SimpleDateFormat("yyyy", Locale.US)
        val monthYearFormat = SimpleDateFormat("MMM yyyy", Locale.US)

        data.address = "Vernouille"
        data.avatar = BitmapFactory.decodeResource(resources, R.drawable.avatar)
        data.education = listOf(
            ProfileData.Education("Bachelor European in Graphic Design",
                "School name",
                ProfileData.Term(yearDataFormat.parse("2009")!!,
                    yearDataFormat.parse("2010")),
                "Bagnolet"
            )
        )
        data.email = "yourmail@gmail.com"
        val date = monthYearFormat.parse("Aug 2018")
        data.experience = listOf(
            ProfileData.Experience(
                "Senior UI/UX Product Designer",
                "Enterprise name",
                ProfileData.Term(monthYearFormat.parse("Aug 2018")!!, null),
                "Paris",
                "Directly collaborated with CEO and Product team to prototype, design" +
                        " and deliver the UI and UX experience with a lean design process: " +
                        "research, design, test, and iterate."
            ),
            ProfileData.Experience(
                "UI/UX Product Designer",
                "Enterprise name",
                ProfileData.Term(monthYearFormat.parse("Aug 2013")!!,
                    monthYearFormat.parse("Aug 2018")),
                "Paris",
                "UI/UX Product Designer Enterprise name Aug 2013 - Aug 2018 - 5 years, " +
                        "Paris Lead the UI design with the accountability of the design system, " +
                        "collaborated with product and development teams on core projects to " +
                        "improve product interfaces and experiences."
            )
        )
        data.industrySkills = listOf(
            "Product Design",
            "User Interface",
            "User Experience",
            "Interaction Design",
            "Wireframing",
            "Rapid Prototyping",
            "Design Research"
        )
        data.languages = listOf(
            Locale.GERMANY,
            Locale.US
        )
        data.name = "Anastasia Gisina"
        data.otherSkills = listOf(
            "HTML",
            "CSS",
            "C#",
            "Java"
        )
        data.phoneNumber = "+33 6 33 33 33 33"
        data.position = "Junior Product Designer"
        data.projects = listOf(
            ProfileData.Project(
                "Common Data",
            "A service that provides developers with analytics on datasets and tips " +
                    "for improving data quality. With our service, you can:\n" +
                    "1) Verify the quality of your data\n" +
                    "2) Speed up data processing performed with the help of our recommendations",
                ProfileData.Term(yearDataFormat.parse("2009")!!,
                    yearDataFormat.parse("2009")),
                "Bagnolet"
            )
        )

        return data
    }
}