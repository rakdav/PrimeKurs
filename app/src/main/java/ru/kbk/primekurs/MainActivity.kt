package ru.kbk.primekurs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.kbk.primekurs.domain.model.onboardingPages
import ru.kbk.primekurs.presentation.auth.LoginScreen
import ru.kbk.primekurs.presentation.onboarding.AppScreen
import ru.kbk.primekurs.ui.theme.PrimeKursTheme
import ru.kbk.primekurs.presentation.onboarding.MainViewModel
import ru.kbk.primekurs.presentation.onboarding.OnboardingScreen
import ru.kbk.primekurs.presentation.onboarding.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrimeKursTheme {
                val viewModel: MainViewModel = viewModel()
                when (viewModel.currentScreen) {
                    AppScreen.SPLASH -> {
                        SplashScreen()
                    }
                    AppScreen.ONBOARDING -> {
                        OnboardingScreen(
                            pages = onboardingPages,
                            currentPage = viewModel.currentPageIndex,
                            onNextClick = { viewModel.nextPage() },
                            onSkipClick = { viewModel.skipOnboarding() }
                        )
                    }
                    AppScreen.MAIN -> {
                        // Ваш основной экран приложения
                        LoginScreen()
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PrimeKursTheme {

    }
}