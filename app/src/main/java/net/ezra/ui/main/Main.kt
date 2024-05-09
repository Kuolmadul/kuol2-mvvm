package net.ezra.ui.main
import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.ezra.R
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_MAIN

@Composable
fun ImageSlideshow(imageList: List<Int>, modifier: Modifier = Modifier) {
    var currentImageIndex by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000) // Change image every 3 seconds
            currentImageIndex = (currentImageIndex + 1) % imageList.size
        }
    }

    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = imageList[currentImageIndex]),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageSlideshowDemo(navController:NavHostController) {


    val images = listOf(
        R.drawable.mb1,
        R.drawable.mb2,
        R.drawable.mb3
        // Add more images here
    )



    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    androidx.compose.material.Text(text = "About Us",fontSize = 30.sp, color = Color.White,fontFamily = FontFamily.Cursive,)
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(ROUTE_HOME)
                    }) {
                        androidx.compose.material3.Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            "backIcon",
                            tint = Color.White
                        )
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF006492),
                    titleContentColor = Color.White,

                    )

            )
        },
        content = {
            Column(
                modifier = Modifier
                   // .fillMaxSize()
                    .background(Color(0xff53adf2)),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {


LazyColumn {
    item {


                Column(
                   // modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    androidx.compose.material3.Text(
                        text = " CONTACT ",
                        color = Color.Black,
                        fontFamily = FontFamily.Cursive,
                        fontWeight = FontWeight.Bold,
                        fontSize = (25.sp)
                    )


                    Spacer(modifier = Modifier.height(5.dp))


                    ImageSlideshow(imageList = images, modifier = Modifier.size(300.dp))



                    Spacer(modifier = Modifier.height(5.dp))





                    Spacer(modifier = Modifier.height(7.dp))
                    androidx.compose.material3.Text(text = "Holla us through our Email address (madulglamour@gmail.com)")
                    Spacer(modifier = Modifier.height(40.dp))
                    androidx.compose.material3.Text(text = "Or call our hotline number 071111111112")
                    Spacer(modifier = Modifier.height(40.dp))
                    androidx.compose.material3.Text(text = "Address: 123 Main street,Cityville,State,ZIP code")
                    Spacer(modifier = Modifier.height(40.dp))
                    androidx.compose.material3.Text(text = "Store Hours:Monday-Friday:9:00AM-8:00PM,Saturday: 10:00 AM-6:00PM")
                    Spacer(modifier = Modifier.height(80.dp))
                    androidx.compose.material3.Text(text = "Social Media Handles:")
                    Spacer(modifier = Modifier.height(40.dp))
                    androidx.compose.material3.Text(text = "Twitter: @madulglamour")
                    Spacer(modifier = Modifier.height(20.dp))
                    androidx.compose.material3.Text(text = "Facebook: @madulglamourHQ")
                    Spacer(modifier = Modifier.height(20.dp))
                    androidx.compose.material3.Text(text = "Instagram: @madulglamour")


                }
    }
}

            }

        })




        }


