package ru.kbk.primekurs.presentation.onboarding

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.kbk.primekurs.domain.model.onboardingPages
import kotlin.time.Duration.Companion.milliseconds

enum class AppScreen {
    SPLASH, ONBOARDING, MAIN
}

class MainViewModel : ViewModel() {

    var currentScreen by mutableStateOf(AppScreen.SPLASH)
        private set

    var currentPageIndex by mutableIntStateOf(0)
        private set

    init {
        viewModelScope.launch {
            delay(3000.milliseconds)
            currentScreen = AppScreen.ONBOARDING
        }
    }

    fun nextPage() {
        if (currentPageIndex < onboardingPages.lastIndex) {
            currentPageIndex++
        } else {
            finishOnboarding()
        }
    }

    fun skipOnboarding() {
        finishOnboarding()
    }

    private fun finishOnboarding() {
        currentScreen = AppScreen.MAIN // Переход на главный экран
    }
}