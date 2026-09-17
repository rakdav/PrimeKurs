package ru.kbk.primekurs.presentation.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import ru.kbk.primekurs.R
import ru.kbk.primekurs.presentation.auth.components.CustomTextField
import ru.kbk.primekurs.presentation.auth.components.SocialIconButton
import ru.kbk.primekurs.ui.theme.BackgroundWhite
import ru.kbk.primekurs.ui.theme.FacebookBlue
import ru.kbk.primekurs.ui.theme.GaameTimeDarkText
import ru.kbk.primekurs.ui.theme.GaameTimePink
import ru.kbk.primekurs.ui.theme.GoogleRed
import ru.kbk.primekurs.ui.theme.PrimeKursTheme

@Composable
fun LoginScreen()
{
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundWhite)
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = "Gamer Illustration",
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = "Welcome Back!",
            color = GaameTimePink,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Hi, Kindly login to continue battle",
            color = GaameTimeDarkText,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 32.dp)
        )
        CustomTextField(
            value = email,
            onValueChange = { email = it },
            label = "Email",
            keyboardType = KeyboardType.Email
        )
        Spacer(modifier = Modifier.height(16.dp))
        CustomTextField(
            value = password,
            onValueChange = { password = it },
            label = "Password",
            keyboardType = KeyboardType.Password,
            isPassword = true,
            passwordVisible = passwordVisible,
            onVisibilityChange = { passwordVisible = !passwordVisible }
        )
        Text(
            text = "Forgot Password?",
            color = GaameTimeDarkText,
            fontSize = 14.sp,
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 12.dp, bottom = 32.dp)
                .clickable { /* Handle forgot password */ }
        )
        Button(
            onClick = { /* Handle Login */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = GaameTimePink),
            shape = RoundedCornerShape(28.dp) // Закругленные углы
        ) {
            Text(
                text = "Let's Combat!",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Connect With:",
            color = GaameTimePink,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Google+ Icon
            SocialIconButton(color = GoogleRed) {
                // Иконка Google
                Text("G+", color = Color.White, fontWeight = FontWeight.Bold)
            }

            // Facebook Icon
            SocialIconButton(color = FacebookBlue) {
                // Иконка Facebook
                Text("f", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Don't have an account? ",
                color = GaameTimeDarkText,
                fontSize = 14.sp
            )
            Text(
                text = "Create Account",
                color = GaameTimePink,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier.clickable { /* Handle Sign Up */ }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PrimeKursTheme {
        LoginScreen()
    }
}
