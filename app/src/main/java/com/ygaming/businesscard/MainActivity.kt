package com.ygaming.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ygaming.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardScreen()
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen() {
    HeadSection(androidColor = Color(0xFF3ddc84))
    ContactSection(androidColor = Color(0xFF3ddc84))
}

@Composable
fun HeadSection(androidColor: Color) {
    val image = painterResource(id = R.drawable.android_logo)
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(bottom = 100.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = "Android Logo",
            modifier = Modifier
                .height(128.dp)
                .background(Color.DarkGray)
        )
        Text(
            text = stringResource(R.string.name_text),
            fontSize = 50.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier.padding(top = 12.dp)
        )
        Text(
            text = stringResource(R.string.job_title_text),
            color = androidColor,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 12.dp)
        )
    }
}

@Composable
fun ContactSection(androidColor: Color) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Column {
            ContactInfo(
                icon = Icons.Rounded.Call,
                description = "Phone Number",
                tint = androidColor,
                text = stringResource(R.string.phone_number_text)
            )
            ContactInfo(
                icon = Icons.Rounded.Share,
                description = "Username",
                tint = androidColor,
                text = stringResource(R.string.username_text)
            )
            ContactInfo(
                icon = Icons.Rounded.Email,
                description = "Email",
                tint = androidColor,
                text = stringResource(R.string.email_text)
            )
        }
    }
}

@Composable
fun ContactInfo(icon: ImageVector, description: String, tint: Color, text: String) {
    Row(
        modifier = Modifier.padding(top = 12.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = description,
            tint = tint
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 12.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardScreen()
    }
}