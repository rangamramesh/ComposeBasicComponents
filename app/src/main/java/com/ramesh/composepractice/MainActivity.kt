package com.ramesh.composepractice

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ramesh.composepractice.learnnavigationComponent.DisplayNavComponent
import com.ramesh.composepractice.ui.theme.ComposePracticeTheme
import com.ramesh.composepractice.ui.theme.Green

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            ComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val list = ArrayList<String>()
                    for (i in 0..50) {
                        list.add("List Item $i")
                    }
                    DisplayNavComponent()
                }
            }
        }
    }
}

@Composable
fun TextAndModifiers() {
    val context = LocalContext.current
    Text(text = stringResource(id = R.string.hello_text),
        color = Color.Green,
        fontSize = 32.sp,
        fontFamily = FontFamily.Serif,
        modifier = Modifier
            .padding(10.dp)
            .background(color = Color.Blue)
            .clickable {
                Toast
                    .makeText(context, "Clicked", Toast.LENGTH_SHORT)
                    .show()
            }
    )
}

@Composable
fun RowAndColumn() {
    Column {
        Text(text = "Column 1")
        Text(text = "Column 2")
        Text(text = "Column 3")
    }
//    Row {
//        Text(text = "Row 1")
//        Text(text = "Row 2")
//        Text(text = "Row 3")
//    }
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Blue),
//        contentAlignment = Alignment.Center
//    ) {
//        Box(
//            modifier = Modifier
//                .height(300.dp)
//                .width(300.dp)
//                .background(Color.Yellow),
//            contentAlignment = Alignment.Center
//        ) {
//            Text(text = "Hello Box", textAlign = TextAlign.Center)
//        }
//    }
}

@Composable
fun LearnAlignmentsAndArrangements() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.background(Color.Yellow)
    ) {
        Text(text = "Row Alignment and arrangement")
    }

//    Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
//        Text(text = "Alignment and arrangement")
//    }

//    Box (contentAlignment = Alignment.BottomCenter, modifier = Modifier.background(Color.Yellow)){
//        //If we add alignment for child views, it will fallow child alignments.
//        Text(text = "Box have only alignments", modifier = Modifier.align(Alignment.Center))
//    }

//    Box(modifier = Modifier.padding(20.dp)) {
//        Text(text = "Top Start", modifier = Modifier.align(Alignment.TopStart))
//        Text(text = "Top Center", modifier = Modifier.align(Alignment.TopCenter))
//        Text(text = "Top End", modifier = Modifier.align(Alignment.TopEnd))
//        Text(text = "Center Start", modifier = Modifier.align(Alignment.CenterStart))
//        Text(text = "Center Center", modifier = Modifier.align(Alignment.Center))
//        Text(text = "Center End", modifier = Modifier.align(Alignment.CenterEnd))
//        Text(text = "Bottom Start", modifier = Modifier.align(Alignment.BottomStart))
//        Text(text = "Bottom Center", modifier = Modifier.align(Alignment.BottomCenter))
//        Text(text = "Bottom End", modifier = Modifier.align(Alignment.BottomEnd))
//    }
}


@Composable
fun LearnButton() {
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show() },
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors()
        ) {
            Text(text = "I am Button, Click on Me")
        }
    }
}

@Composable
fun LearnImage() {
    val context = LocalContext.current
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(Color.Blue)
            .clickable {
                Toast
                    .makeText(context, "Image Clicked", Toast.LENGTH_SHORT)
                    .show()
            }) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Sample"
        )
    }
}

@Composable
fun LearnState() {
//    var age = 0
    var age by remember {
        mutableStateOf(0)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            age++
        }) {
            Text(text = "I am $age years old", fontSize = 30.sp)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearnTopAppBar() {
    val context = LocalContext.current
    TopAppBar(
        title = { Text(text = "Whatsapp") },
        navigationIcon = {
            IconButton(onClick = {
                Toast.makeText(
                    context,
                    "Navigation icon Clicked",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Navigation Icon"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Green, titleContentColor = Color.White,
            navigationIconContentColor = Color.White
        ),
        actions = {
            IconButton(onClick = {
                Toast.makeText(
                    context,
                    "Profile",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Profile",
                    tint = Color.White
                )
            }
            IconButton(onClick = {
                Toast.makeText(
                    context,
                    "Search",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Profile",
                    tint = Color.White
                )
            }
            IconButton(onClick = {
                Toast.makeText(
                    context,
                    "Menu",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Profile",
                    tint = Color.White
                )
            }
        }
    )
}

@Preview
@Composable
fun SeeMyView() {
    LearnTopAppBar()
}