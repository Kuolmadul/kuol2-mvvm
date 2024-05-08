package net.ezra.ui.main
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
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


@Composable
fun ImageSlideshowDemo(navController:NavHostController) {
    val images = listOf(
        R.drawable.mb1,
        R.drawable.mb2,
        R.drawable.mb3
        // Add more images here
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


//
//        Text(
//            text = "Image Slideshow",
//            style = MaterialTheme.typography.h5,
//            color = Color.Black
//        )
        Spacer(modifier = Modifier.height(5.dp))
        ImageSlideshow(imageList = images, modifier = Modifier.size(300.dp))

        Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "WELCOME TO MADUL GLAMOUR",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()

            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                color = Color.Cyan,
                textAlign = TextAlign.Center,
                text = "Home where you meet a taste of your own fashion and passion",

                style = MaterialTheme.typography.h5,

                modifier = Modifier.padding(bottom = 16.dp)

            )


            Spacer(modifier = Modifier.height(5.dp))



            Button(
                onClick = {
                    navController.navigate(ROUTE_HOME) {
                        popUpTo(ROUTE_MAIN) { inclusive = true }
                    }
                },
                modifier = Modifier
                    .fillMaxSize(),
                colors = ButtonDefaults.buttonColors(Color.White)
            ) {
                Text(text = "Get started",)


                Spacer(modifier = Modifier.width(60.dp))


                Icon(
                    imageVector = Icons.Default.ArrowForward, "",
                    modifier = Modifier
                        .background(Color.Transparent)
                        .size(30.dp),

                )


            }




    }





}

