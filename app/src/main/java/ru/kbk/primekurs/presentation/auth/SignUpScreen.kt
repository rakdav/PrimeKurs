package ru.kbk.primekurs.presentation.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.kbk.primekurs.ui.theme.BackgroundWhite
import ru.kbk.primekurs.ui.theme.GaameTimePink
import ru.kbk.primekurs.ui.theme.PrimeKursTheme
import ru.kbk.primekurs.R
import ru.kbk.primekurs.presentation.auth.components.CustomTextField
import ru.kbk.primekurs.presentation.auth.components.CustomTextFieldRegister
import ru.kbk.primekurs.presentation.auth.components.PhoneNumberTextField
import ru.kbk.primekurs.ui.theme.GaameTimeDarkText

@Composable
fun SignUpScreen() {
    var fullName by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }
    var countryCode by remember { mutableStateOf("+234") }
    var phoneNumber by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundWhite)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.Start // Выравнивание по левому краю для заголовков
    )
    {
        Image(
            painter = painterResource(id = R.drawable.register),
            contentDescription = "Gamer Illustration",
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .padding(bottom = 24.dp),
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center
        )
        Text(
            text = "Create Account",
            color = GaameTimePink,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Hi, kindly fill in the form to proceed combat",
            color = GaameTimeDarkText,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        CustomTextFieldRegister(
            value = fullName,
            onValueChange = { fullName = it },
            label = "Full Name"
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomTextFieldRegister(
            value = userName,
            onValueChange = { userName = it },
            label = "User Name"
        )
        Spacer(modifier = Modifier.height(16.dp))
        PhoneNumberTextField(
            countryCode = countryCode,
            onCountryCodeChange = { countryCode = it },
            phoneNumber = phoneNumber,
            onPhoneNumberChange = { phoneNumber = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomTextFieldRegister(
            value = email,
            onValueChange = { email = it },
            label = "Email",
            keyboardType = KeyboardType.Email
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomTextFieldRegister(
            value = password,
            onValueChange = { password = it },
            label = "Password",
            keyboardType = KeyboardType.Password,
            isPassword = true,
            passwordVisible = passwordVisible,
            onVisibilityChange = { passwordVisible = !passwordVisible }
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomTextFieldRegister(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = "Confirm Password",
            keyboardType = KeyboardType.Password,
            isPassword = true,
            passwordVisible = confirmPasswordVisible,
            onVisibilityChange = { confirmPasswordVisible = !confirmPasswordVisible }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { /* Handle Sign Up */ },
            modifier = Modifier
                .fillMaxWidth(0.7f) // Кнопка немного уже, чем на экране логина
                .height(56.dp)
                .align(Alignment.CenterHorizontally), // Центрируем кнопку
            colors = ButtonDefaults.buttonColors(containerColor = GaameTimePink),
            shape = RoundedCornerShape(28.dp)
        ) {
            Text(
                text = "Create Account",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    PrimeKursTheme {
        SignUpScreen()
    }
}