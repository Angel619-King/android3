package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pantalla()
        }

    }
}

@Composable

fun Pantalla(){
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        TituloUno()
        //Spacer(modifier = Modifier.height(20.dp))
        //miimagen()
        Spacer(modifier = Modifier.height(20.dp))
        //boton()
        Pantalla2()
        Spacer(modifier = Modifier.height(20.dp))
        //boton()


    }
}
@Preview(showSystemUi = true)
@Composable
fun Vista(){
    Pantalla()
}

@Composable
fun TituloUno(){
    Text(text = "App KRONNO",
        color = Color.Red,
        fontSize = 30.sp,
        letterSpacing = 10.sp,
        textAlign = TextAlign.Center
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pantalla2() {
    var phoneValue by remember { mutableStateOf("") }
    var phoneValue2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf(0f) }

    TextField(
        value = phoneValue,
        onValueChange = { phoneValue = it },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        label = { Text("Numero 1") }
    )
    Spacer(modifier = Modifier.height(20.dp))
    TextField(
        value = phoneValue2,
        onValueChange = { phoneValue2 = it },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        label = { Text("Numero 2") }
    )
    Spacer(modifier = Modifier.height(20.dp))
    val context = LocalContext.current
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Button(
            onClick = {
                val num1 = phoneValue.toFloatOrNull() ?: 0f
                val num2 = phoneValue2.toFloatOrNull() ?: 0f
                result = num1 + num2
            },
            modifier = Modifier.weight(1f).padding(4.dp)
        ) {
            Text(text = "+")
        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                val num1 = phoneValue.toFloatOrNull() ?: 0f
                val num2 = phoneValue2.toFloatOrNull() ?: 0f
                result = num1 - num2
            },
            modifier = Modifier.weight(1f).padding(4.dp)
        ) {
            Text(text = "-")
        }
        Button(
            onClick = {
                val num1 = phoneValue.toFloatOrNull() ?: 0f
                val num2 = phoneValue2.toFloatOrNull() ?: 0f
                result = num1 * num2
            },
            modifier = Modifier.weight(1f).padding(4.dp)
        ) {
            Text(text = "*")
        }
        Button(
            onClick = {
                val num1 = phoneValue.toFloatOrNull() ?: 0f
                val num2 = phoneValue2.toFloatOrNull() ?: 0f
                result = num1 / num2
            },
            modifier = Modifier.weight(1f).padding(4.dp)
        ) {
            Text(text = "/")
        }

    }
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        text = "Resultado: $result",
        color = Color.Black,
        fontSize = 20.sp,
        textAlign = TextAlign.Center
    )
}
