package com.example.atvnosql

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.atvnosql.db.DBHandler
import com.example.atvnosql.ui.theme.AtvNOSQLTheme
import com.example.atvnosql.ui.theme.PurpleGrey40
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(){
    AtvNOSQLTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            // on below line we are specifying modifier and color for our app
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {

            // on the below line we are specifying the theme as the scaffold.
            Scaffold(

                // in scaffold we are specifying the top bar.
                topBar = {

                    // inside top bar we are specifying background color.
                    TopAppBar(colors = TopAppBarDefaults.centerAlignedTopAppBarColors(),

                        // along with that we are specifying title for our top bar.
                        title = {

                            // in the top bar we are specifying tile as a text
                            Text(
                                // on below line we are specifying
                                // text to display in top app bar.
                                text = "GFG",

                                // on below line we are specifying
                                // modifier to fill max width.
                                modifier = Modifier.fillMaxWidth(),

                                // on below line we are specifying
                                // text alignment.
                                textAlign = TextAlign.Center,

                                // on below line we are specifying
                                // color for our text.
                                color = Color.White
                            )
                        })
                }) {
                // on below line we are calling our method to display UI
                addDataToDatabase(LocalContext.current)
            }
        }
    }
}



// on below line we are creating battery status function.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun addDataToDatabase(
    context: Context
) {

    // on below line creating a variable for battery status
    val cadName = remember {
        mutableStateOf(TextFieldValue())
    }
    val cadEndereco = remember {
        mutableStateOf(TextFieldValue())
    }
    val cadBairro = remember {
        mutableStateOf(TextFieldValue())
    }
    val cadCEP = remember {
        mutableStateOf(TextFieldValue())
    }
    val cadCidade = remember {
        mutableStateOf(TextFieldValue())
    }
    val cadEstado = remember {
        mutableStateOf(TextFieldValue())
    }
    val cadTelefone = remember {
        mutableStateOf(TextFieldValue())
    }
    val cadCelular = remember {
        mutableStateOf(TextFieldValue())
    }


    // on below line we are creating a column,
    Column(
        // on below line we are adding a modifier to it,
        modifier = Modifier
            .fillMaxSize()
            // on below line we are adding a padding.
            .padding(all = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        var dbHandler: DBHandler = DBHandler(context)

        // on below line we are adding a text for heading.
        Text(
            // on below line we are specifying text
            text = "SQlite Database in Android",
            // on below line we are specifying text color, font size and font weight
            color = PurpleGrey40, fontSize = 20.sp, fontWeight = FontWeight.Bold
        )

        // on below line adding a spacer.
        Spacer(modifier = Modifier.height(20.dp))

        // on below line we are creating a text field.
        TextField(
            // on below line we are specifying value for our email text field.
            value = cadName.value,
            // on below line we are adding on value change for text field.
            onValueChange = { cadName.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Enter your name") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = androidx.compose.ui.text.TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we are adding single line to it.
            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(20.dp))

        // on below line we are creating a text field.
        TextField(
            // on below line we are specifying value for our email text field.
            value = cadEndereco.value,
            // on below line we are adding on value change for text field.
            onValueChange = { cadEndereco.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Enter your address") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = androidx.compose.ui.text.TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we are adding single line to it.
            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(20.dp))


        // on below line we are creating a text field.
        TextField(
            // on below line we are specifying value for our email text field.
            value = cadBairro.value,
            // on below line we are adding on value change for text field.
            onValueChange = { cadBairro.value = it },
            // on below line we are adding place holder as text
            placeholder = { Text(text = "Enter your neighborhood") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = androidx.compose.ui.text.TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we are adding single line to it.
            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(20.dp))

        // on below line we are creating a text field.
        TextField(
            // on below line we are specifying value for our email text field.
            value = cadCEP.value,
            // on below line we are adding on value change for text field.
            onValueChange = { cadCEP.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Enter your CEP") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = androidx.compose.ui.text.TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we are adding single line to it.
            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(15.dp))

        TextField(

            value = cadCidade.value,

            onValueChange = { cadCidade.value = it },

            placeholder = { Text(text = "Enter your City") },

            modifier = Modifier
                .fillMaxWidth(),

            textStyle = androidx.compose.ui.text.TextStyle(color = Color.Black, fontSize = 15.sp),

            singleLine = true,
        )

        Spacer(modifier = Modifier.height(15.dp))

        TextField(

            value = cadEstado.value,

            onValueChange = { cadEstado.value = it },

            placeholder = { Text(text = "Enter your State") },

            modifier = Modifier
                .fillMaxWidth(),

            textStyle = androidx.compose.ui.text.TextStyle(color = Color.Black, fontSize = 15.sp),

            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            // on below line we are specifying value for our email text field.
            value = cadTelefone.value,
            // on below line we are adding on value change for text field.
            onValueChange = { cadTelefone.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Enter your  Telephone") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = androidx.compose.ui.text.TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we are adding single line to it.
            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            // on below line we are specifying value for our email text field.
            value = cadCelular.value,
            // on below line we are adding on value change for text field.
            onValueChange = { cadCelular.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Enter your  Cellphone") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = androidx.compose.ui.text.TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we are adding single line to it.
            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(15.dp))


        // on below line creating a button to check battery charging status
        Button(onClick = {
            dbHandler.addNewCadastro(
                cadName.value.text,
                cadEndereco.value.text,
                cadBairro.value.text,
                cadCEP.value.text,
                cadCidade.value.text,
                cadEstado.value.text,
                cadTelefone.value.text,
                cadCelular.value.text,
            )
            Toast.makeText(context, "Data Added to Database", Toast.LENGTH_SHORT).show()
        }) {
            // on below line adding a text for our button.
            Text(text = "Add Data to Database", color = Color.White)
        }

        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(15.dp))

        // on below line creating a button to open view course activity
        Button(onClick = {
            val i = Intent(context, ViewCourses::class.java)
            context.startActivity(i)
        }) {
            // on below line adding a text for our button.
            Text(text = "Data Registration to Database", color = Color.White)
        }
    }
}
@Preview
@Composable
fun AppPreview() {
    App()
}