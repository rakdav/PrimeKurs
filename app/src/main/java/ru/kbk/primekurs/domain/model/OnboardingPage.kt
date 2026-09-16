package ru.kbk.primekurs.domain.model

import ru.kbk.primekurs.R

data class OnboardingPage(
    val title: String,
    val description: String,
    val imageRes: Int, // Ссылка на drawable ресурс
    val isLastPage: Boolean = false
)

val onboardingPages = listOf(
    OnboardingPage(
        title = "Get Paid! Playing Video Game",
        description = "Earn points and real cash when you win a battle with no delay in cashing out.",
        imageRes = R.drawable.ic_onboarding_1, // Замените на ваши картинки
        isLastPage = false
    ),
    OnboardingPage(
        title = "Schedule Games With Friends",
        description = "Easily create an upcoming event and get ready for battle. Yeah! real combat feels.",
        imageRes = R.drawable.ic_onboarding_2,
        isLastPage = false
    ),
    OnboardingPage(
        title = "Text, Audio and Video Chat",
        description = "Intuitive real-time experience in mobile. Chat with fellow gamers before and after combat.",
        imageRes = R.drawable.ic_onboarding_3,
        isLastPage = true
    )
)