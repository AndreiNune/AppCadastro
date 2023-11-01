package com.example.atvnosql

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.atvnosql.ui.theme.AtvNOSQLTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()

        }
    }
}


@Composable
fun App(){
    AtvNOSQLTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column {
                TopBarra()
                SimpleTextFieldSample("Nome:")
                Divider(
                    Modifier.height(20.dp),
                    //modifier = Modifier.background(Color.Transparent)
                )
                SimpleTextFieldSample("Endereço:")
                Divider(
                    Modifier.height(20.dp),
                    //modifier = Modifier.background(Color.Transparent)
                )
                SimpleTextFieldSample("Bairro:")
                Divider(
                    Modifier.height(20.dp),
                    //modifier = Modifier.background(Color.Transparent)
                )
                SimpleTextFieldSample("CEP:")
                Divider(
                    Modifier.height(20.dp),
                    //modifier = Modifier.background(Color.Transparent)
                )
                SimpleTextFieldSample("Cidade:")
                Divider(
                    Modifier.height(20.dp),
                    //modifier = Modifier.background(Color.Transparent)
                )
                SimpleTextFieldSample("Estado:")
                Divider(
                    Modifier.height(20.dp),
                    //modifier = Modifier.background(Color.Transparent)
                )
                SimpleTextFieldSample("Telefone:")
                Divider(
                    Modifier.height(20.dp)
                )
                SimpleTextFieldSample("Celular:")
                Divider(
                    Modifier.height(20.dp),
                    //modifier = Modifier.background(Color.Transparent)
                )
                ButtonSample()
            }
        }
    }
}

@Preview(widthDp = 300, heightDp = 500)
@Composable
fun AppPreview(){
    App()
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTextFieldSample(campo: String) {
    var text by rememberSaveable { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(campo) },
        singleLine = true
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarra() {
    TopAppBar(
        windowInsets = TopAppBarDefaults.windowInsets,
        title = { Text("Cadastro") },
        navigationIcon = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Menu, contentDescription = null)
            }
        },
        actions = {
            // RowScope here, so these icons will be placed horizontally
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Add, contentDescription = "Localized description")
            }
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.AccountBox, contentDescription = "Localized description")
            }
        }
    )
}


@Preview
@Composable
fun SimpleTopAppBarPreview() {
    TopBarra()
}

@Preview
@Composable
fun SimpleTextFieldSamplePreview(){
    SimpleTextFieldSample("Nome:")
    //SimpleTextFieldSample("Seu nome:")
}
@Composable
fun ButtonSample() {
    var button by rememberSaveable { mutableStateOf("") }
    Button(onClick = { /* Do something! */ }) { Text("Cadastrar") }
}
@Preview
@Composable
fun ButtonSamplePreview(){
    ButtonSample()
}