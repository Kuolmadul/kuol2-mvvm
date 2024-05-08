package net.ezra.ui.home






import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.google.api.Context
import hilt_aggregated_deps._dagger_hilt_android_internal_modules_ApplicationContextModule
import kotlinx.coroutines.delay
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_ADD_STUDENTS
import net.ezra.navigation.ROUTE_DASHBOARD
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_SEARCH
import net.ezra.navigation.ROUTE_VIEW_PRODUCTS
import net.ezra.navigation.ROUTE_VIEW_STUDENTS
import net.ezra.navigation.ROUTE_VIEW_PRODUCTS
import net.ezra.navigation.ROUTE_ADD_PRODUCT
import net.ezra.navigation.ROUTE_CONTACT
import net.ezra.navigation.ROUTE_DETAILS
import net.ezra.navigation.ROUTE_MAIN
import net.ezra.navigation.ROUTE_UPDATE_PRODUCTS

data class Screen(val title: String, val icon: Int)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ResourceAsColor")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {

    var isDrawerOpen by remember { mutableStateOf(false) }

    val callLauncher: ManagedActivityResultLauncher<Intent, ActivityResult> =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) { _ ->

        }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {

                    Text(text = "MADUL GLAMOUR",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                    )



                   // Text(text = stringResource(id = R.string.apen))
                },
                navigationIcon = @Composable {
                    if (!isDrawerOpen) {
                        IconButton(onClick = { isDrawerOpen = true }) {
                            Icon(
                                Icons.Default.Menu,
                                contentDescription = "Menu",
                                tint = Color.White
                                )
                        }
                    }
                },

                actions = {
                    IconButton(onClick = {
                        navController.navigate(ROUTE_DASHBOARD) {
                            popUpTo(ROUTE_HOME) { inclusive = true }
                        }

                    }) {
                        Icon(
                            imageVector = Icons.Filled.AccountCircle,
                            contentDescription = null,
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

        content = @Composable {

            Box(

                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        if (isDrawerOpen) {
                            isDrawerOpen = false
                        }
                    }
            ){


                Spacer(modifier = Modifier.height(20.dp))


                LazyColumn {

                    item {


//Column {
//
//    Text(
//        color = Color.White,
//        textAlign=TextAlign.Center,
//        text = "Here Is What We Have!!",
//
//       style = MaterialTheme.typography.headlineLarge,
//
//        modifier = Modifier.padding(bottom = 16.dp)
//
//    )
//}





                        Column {
                            Image(painter = painterResource(id = R.drawable.mb), contentDescription = "",
                                Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop

                            )
                        }


                        Spacer(modifier = Modifier.height(15.dp))


                        Row {
//Button(onClick = {   navController.navigate(ROUTE_LOGIN) {
//    popUpTo(ROUTE_HOME) { inclusive = true }
//} },
//        modifier=Modifier,
//    colors=ButtonDefaults.buttonColors(Color.Transparent)
//    ) {
//
//    Icon(imageVector = Icons.Default.Menu, "",
//
//        modifier= Modifier
//            .background(Color.Black)
//            .size(30.dp)
//
//    )
//
//
//}
//
//                        BottomNavigationItem(icon = {
//                            Icon(imageVector = Icons.Default.Search, "",tint = Color.White)
//                        },
//                            label = { Text(
//                                text = "Find",
//                                color =  Color.White) },
//                            selected = (selectedIndex.value == 2),
//                            onClick = {
//
//                                navController.navigate(ROUTE_ADD_PRODUCT) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//
//                            })
                            Row {


                                androidx.compose.material.IconButton(onClick = {
                                    navController.navigate(ROUTE_VIEW_PRODUCTS) {
                                        popUpTo(ROUTE_HOME) { inclusive = true }
                                    }
                                }) {
                                    Text(text = "All Products", fontFamily = FontFamily.Cursive, fontSize = (20.sp)
                                    )
                                }




                                Spacer(modifier = Modifier.width(70.dp))




                                androidx.compose.material.IconButton(onClick = {
                                    navController.navigate(ROUTE_MAIN) {
                                        popUpTo(ROUTE_HOME) { inclusive = true }
                                    }
                                }) {
                                    Text(text = "Main", fontFamily = FontFamily.Cursive, fontSize = (20.sp)
                                    )
                                }




                                Spacer(modifier = Modifier.width(70.dp))

                                androidx.compose.material.IconButton(onClick = {
                                    navController.navigate(ROUTE_CONTACT) {
                                        popUpTo(ROUTE_HOME) { inclusive = true }
                                    }
                                }) {
                                    Text(text = "About Us", fontFamily = FontFamily.Cursive, fontSize = (20.sp)
                                    )
                                }


                            }


                            Spacer(modifier = Modifier.width(285.dp))





                            Icon(
                                Icons.Rounded.Share,
                                contentDescription = stringResource(id = R.string.shopping_cart_content_desc),
                                modifier = Modifier.size(35.dp),


                                )





                        }

                        Spacer(modifier = Modifier.height(20.dp))










                        Column(modifier=Modifier.fillMaxSize()) {



                            var searchText by remember { mutableStateOf(TextFieldValue()) }

                            TextField(
                                value = searchText,
                                onValueChange = { searchText = it },
                                shape = RoundedCornerShape(25.dp),
                                placeholder = { Text("Search ") },
                                modifier = Modifier.fillMaxWidth(),
                                trailingIcon = {
                                    Icon(imageVector = Icons.Default.Search,
                                        contentDescription = "emailIcon"
                                    ) },

                                )


                        }




                        LazyRow {
                            item {

                                Card(
                                    modifier = Modifier
                                        //.fillMaxSize()
                                        //.fillMaxWidth()
                                        .size(190.dp)
                                        .clip(shape = RectangleShape)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(ROUTE_ABOUT) { inclusive = true }
                                            }
                                        }
                                        .padding(4.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    ),

                                    content = {
//
//                            Icon(imageVector = Icons.Default.Person, "",
//
//                                modifier= Modifier
//                                    .background(Color.Transparent)
//                                    .size(30.dp)
//                                    .clickable {
//                                        navController.navigate(ROUTE_PRODUCTS) {
//                                            popUpTo(ROUTE_HOME) { inclusive = true }
//                                        }
//                                    }
//
//                            )
                                        Column(horizontalAlignment = Alignment.CenterHorizontally) {

                                            AsyncImage(
                                                model = "https://apensoftwares.co.ke/images/media/1669670270logo.png",
                                                contentDescription = "",
                                                modifier = Modifier
                                                // .fillMaxSize()
                                                ,
                                                contentScale = ContentScale.Crop
                                            )

                                            Text(
                                                color = Color.Black,
                                                textAlign = TextAlign.Center,
                                                text = "Flannels",

                                                style = MaterialTheme.typography.headlineLarge,

                                                modifier = Modifier.padding(bottom = 26.dp)

                                            )

                                        }

                                    }
                                )
                                Spacer(modifier = Modifier.width(5.dp))

                                Card(
                                    modifier = Modifier
                                        //.fillMaxSize()
                                        //.fillMaxWidth()
                                        .size(190.dp)
                                        .clip(shape = RectangleShape)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(ROUTE_ABOUT) { inclusive = true }
                                            }
                                        }
                                        .padding(4.dp),

                                    //shape = RoundedCornerShape(100.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    ),

                                    content = {
//                                    Image(
//                                        painter = painterResource(id = R.drawable.logo),
//                                        contentDescription = "",
//                                        modifier = Modifier
//                                            .fillMaxSize(),
//                                        contentScale= ContentScale.Crop
//                                    )
//

                                        AsyncImage(
                                            model = "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxISEhUQEBIWFRUVFRUVFRUXFRUVFRUVFxUXFhUWFhUYHSggGBolGxUVJTEhJSkrLi4uGB8zODMtNygtLisBCgoKDQ0NFQ8NDysZFRkrKy0tLSsrLSs3LSsrKystNysrKysrLS0rLSstLTcrKysrKysrKysrKysrKysrKysrK//AABEIAOEA4QMBIgACEQEDEQH/xAAcAAABBAMBAAAAAAAAAAAAAAAAAQIDBwQFBgj/xABHEAABAwEEBgcEBQsDBAMAAAABAAIRAwQSITEFQVFhcZEGBxMigaHwMlKxwRQjQnKSCFNiY3OCorLR4fEzQ7MVNKPCJCVk/8QAFgEBAQEAAAAAAAAAAAAAAAAAAAEC/8QAFxEBAQEBAAAAAAAAAAAAAAAAAAExEf/aAAwDAQACEQMRAD8A4fsW+63kEooM9xvIKWE4BVEXYN9xvIJOwZ7reQU6RVEPYN91vIJRQb7reQUsIAUEfYN91vII7Bvut/CFNCIVEPYN91vIJewZ7rfwhSwiEEPYM9xvII7BnuN/CFPCQhBA+kwCS1oA1kBa6tpSztwDQ7g0Aeag6T1TLGjLEnjq+a0YA1rNqt4NM0vzQ/h/os+x2mjUwaBOwtAP91yl1S2R91wdMQQZTo7DsG+638IR2Dfdb+EKZItIh7Bvut/CEdg33W8gpkkIIexb7reQR2DfdbyClIQUEXYN91vIJvYt91vIKZIUDGsAyAHDBOhLCSEAhCEAhCED04ITgooSQnQkhUIlCIShEACEIRQhKiECQhKs636NqUbFVtbxcltylOBJfgX7gATB3yoOB0jpA1H3gBAkAZgtB1rBqObm3Dd/Q61kaLuis0VAC0ugg4DEEfGFFbLgcbkgYi6cbpBynWFFRhzYMzOECMN8mcOSYXppGtIg7jQ9V1Sg2q4aywu1FzY84IMb1lrc9TOjqdro2qx1JF5tKo10iWPBcA5o8TxCl0/0UtNlJL2F9PVUYCW/vDNvjzVRoEJySFUNKaQnlIgbCROSFA2EsJUIEQlQgRCWEIHpQkTgVFKkTkkIEQlQgEJV0OgeilS0MFZxuUycDEudGZA1DDNUc8tpo3QFetiG3W+87AeAzK73RvRuhSxDAT7zu87mcvBbXsgBeIwGQQc1ojo1SokFw7R+BlwwHBurxnJanrotV2zMYNbgeULtWMmHe9j/AECrrrjcSxmyTjyWaqpLU3FQKdxkOcduChAQCRokwgp9BsuHEfFBYnU1pI09IU6YMCpepkajDb7eJ7h5r0k5gPivJvQhzhpGyOaDeNpZGoRexwjYTzXrVplByGnehtlrkksuPP2qcNJ4jI8lw+ler+0Mk0XNqjZ7D+RwPNW/XbgCoDTlaFAWvR1an/qUnsj3mkDnksRehatjvAgj+hVb9aehW0n0bTTbAqtLakCBfbBBw1kE/hRHApqekRDUJUQgRCVKqGoTkKByUJqcFGjkhTk0qoEIShQZFgsjq1VlFntPcGjdJz4ASfBXXZLG2nTZTZ7LAGjgGxiq/wCrCwh9ofWP+0zD778Afwh/NWQdaKxzTUVoqBolxgBZJCwtK0b1N3CeSCd1jjvHCdQ+e9cp0+0F9JstRo9oAubxC7SzVL9Jj9rQfGMUMoB3dOvBB5CoxiDr+Ky7JfpOFVkGJbqcAXNIxB3E8lFbLPde9vuuc3k4j5Is1ocDvyGsEe6RrB2KBjqZe93ZsMYuuiTdbnnsG0paTCCNUYkkHDZKno2nB1O7/qEAxsDg4YmTmBhsUlwDLjJx3XvZyGRHBB0HVvSnSdk/aOPKm8xxwXqeiMF5i6rqE6Ts2BwNQndFJ2GWePmvT7RgghcNaQNUlLIpCI4fBUPY1aLpZov6TYn0olwph7P2jRebHHLxW+CjOSDzWU0rbdKNHfR7VWoxgHkt+47vN8iOS1JVZIhEIQCJSSlQKhIhA5OCZKcFFOQiUiASpEqC0+rKzXbI+prqVTyYAB53l0NeoYJGfz1LF6JWfs7BQbETTvni8l/zUlrnMZ/FFTMrB2LcphK7ELU6PtAvEeMawQMj4fBZDrb3C6NZAQZ2hh9Vc9xzm+cjyKy6WDhxWFoM+2D9q6/mIPwWcRiEHlTT1MttVobOVeuP/K4eeS1Vanr9YZ8l0vTajc0hbG//AKax/E4nzmFz9UYetQ4alAliEku/wJ24LIaMjhqO7jlkNajoYM1Y488gccsD6Kc05eHD/G1B3nUpSvaUZh7NGqeHsDHDf5r0e7ALz11DMnSbt1lq/wDJSXoSogSmO6ljanAYLGrEDaUDXVYNw7M/W5HaeeXDWVi3pdGs5BTizuOeG3cNgWhWnW1o+H0rR74dTP7veb8XKvSrT63XtbRo0gJ+sLp92GxHjPkqrciCEJEIhUJEKhUJEKB0pwKjlOBUU9JCSUkohyytG2TtqtOiDF97WzskwSsOVuOiLWm2WcPMDtW/i+z/ABXUVd3YNDQ1kQAANwAgBa+2OaMBLuA+azalnvZuK19ra1uAnwxRXJaUtnZP7UDLPHNusFbqlFRlO7i0kmd0A/NaLpRTa5hDhEgg8Csrq+e42QXjJFRzfANYMEHU6OMVY2tI5Qtk8ZLStqXXsdscAfHD5re1UHmjrMpxpW2AfnZ8XU2EjLMzguUqxH9tWUzGo57V1vWpB0ta/vs2fmqeX6XyXJ1CIyG3VE6zllq4qCZtWaTWwIGO/YJxynkmMO/Lf4YY4k6wks9UBsYgeO2Jw5eKW8Nka8zhie9nqyQWp+T82bdXOsWeOdQYAziO6FfDs1RH5O+NrtR2UWDh3yr3GaBz3ALErWkYgZhS1HA4LS6QqBkyYkhs73G781YJKdVpJvgZ4YXpG0FuLVlstAPdBqAbSx5PAGFjWSsG4Fo4twPitgXFwAbhOvWAqOA60LDNna+njcqXnzgQ0giYOOZHNVYVfHTWw37DaGNGNy9vNwh5x/dVDlEIhEoRAiUShAShCRAicExOBUU9JKRIiHBbPo02bXZx+upHk8E/BapdV1aibfT7t6G1D93uHvfLxRVtWm0YwwSduQ5rWWq0OyIj7uK2lpfiQtJanDXM8lYrkOmbvq+7kTBO7eszq5qB1GpT1tfPg4D5tK13TSoQ2BlhI8Vreh2lOwqu/TAHiDh8VBZrrIYPDBbmzVL9NrtoH91qKFdxEuGYwWboN8sc33XEeBxHzQed+tYxpa14fapn/wAFPHPUuSeRGI5EbMP7rrutuf8Aq9qw10v+GnHzXJavWvxyKgKTBGw4cMRieCa4EDPf4xv81PSGA4DXtH3sic9kKK0esf769aC2fybx9fbD+qpebnf0V7SqP/JsZ37a79GgPOoruqFBi2ly4PrQtl2jTa0w51W9h+gCZ5lq7uo4wQqr60n/AF1Fs5U3GNkuz8vJaR3uh7V2lGnUcIL2NdtxLQTIW3oEjI+OoLn+jOkKNak3sXYAAd4ERAEz5LoKFNwGDmuCKW0NDmuDz3brr2yIM+S85PjVlq4L0lUp3gWu1gggbCIMrzrpOymlVqUjmx7m5RkSAeSJWNKREJUQkolCEAhJCEDJSgpkpwKyp8pJSSklUOBVn9UNBoZXquaPaa1j4F7AS5oOcYskZZKrwVdXV1ZS3R9KR7Ze88C8geQCEbm2uE4zG1aivVblenc5vwK21oLW61rq7DtlVXB9NLU2OzDXSYh2F2BjmCcVoej1K/aaTdrvgCfksjpZbL1dzADDDB3nWeCh6LPi10P2jRzw+aiLhothnJP0b3Kzm6nt8x/aUgMujU3zOv5eaYH95jhm145HAoqgut0n/q9qxmDTGuP9Fkj5rkC6RjhniNuvDeup6z3XtLWwz/vROGpjR5RiuYjDPf5xOec4cFAMBjd5CRrM4A69iiqHD15Y8/BTtyjhhvzjPXmser69b0F1/k3Mwtjt9EeT1clSpjCp/wDJwH1VsP6VIfwu/qrauqwR1jGSp3rEtF62vHuNYzh3bxHNyuGq+BJ8FRPSOvftVd+2q/ycR8lUWL0Rs4FJjaZA7odhF6SASeOK6uy1niW1S5p1PDZDhvwwVd9AKLqlNxnFjoG27GY8Z5Lu7E6pIBe4Df3v7hBtmUwcb7ncDAVL9ZdJ4t1RzmXWuDLhGTmhobeHiCrnFHe5x4x8FXPXHlZw4C9NS6ZJ7vdvTI23eZQqs0ISIhUShCBZSIQgiShRpwKyp8pJSJJQOlX9oukWWWz0WmA2jTnUfYGSoGkJIG0gc16JtDYAbsAHIQqMKrYWkHOdsrXtpwCHArZlhGIPgse1v7pI2FVVR9Ko+lVI1XZ43QsnoRZHVbZSujBh7Rx1AN/uQtJbKxfUe843nuPMlWJ1ZWZrKD6326ryxu5rBJPMnkFEdi9sYc+JxK1Ol9Kmz9iGtDnVqzKQmYAdMuw3DmQtpXtGa0fSK1NpWataXtB7JhcwET9ZEU42G8RzUVQXSC19ra7RU9+vVcN4LzAzyj4Ba9xMec8Rn4plzfj8de1KSYy8to4ZnVsgoHGYiN0ecZeKgqn165qdzMPEiIyAxxMZg5/JY9X16hBdf5OjyWWumD9qk7mHD5K46uCob8ni3Btrr0Sf9SiHDf2bsf516AaQVRgXScwvP2knHtqsmT2j543yvRVrqCCBnC866WcDXqluRqVI4Xyqldn1c6QAimB3muMmfsu9FWfTKo/oZXu2kCYvtc3xwcP5Srl0dUlo2oRs2tVa9dDf+1d+1H/GVZTSq865Kc0aD9QqOb+Jk/8AqhVVykQkRCyiUShAShCEGOnBRpwWWj0iaiURsdA0r9poMGN6tTH8YV/Wt2Ko3oM2dIWYH86DyBPyV31sThnvyVgxwdTlqelVU07LWe0wbhjcYhbhzea5LrHttyzFmuobo4TJ8laKtV09HLB2Fko0yO+GS7aC83iPOPBVd0P0d9ItdNhEtae0f91mMeJgeKui7JWVYopSq267dMhjKVgYcXEVake60wweLpP7itSs8MaSTECSdQC8xdK9Mm12utaDiHvIZ+zb3WDkMeKDWsf6x24TngD8Ujsjw8Rr5ymh3rw9Qkc7A+vnr18EGSQPUeE79qxq7PXrXtUpdjn55yJ26xmkeNZ548/kd6De9WOk/o2k7NUJhpeabvu1AW4+JB8F6kLoyXjenULHhwzaQRuIMr1v0bt30iyUa8yX02k8Yg+asGZWpy9rwYiZG0ERB8VQGmm3bRWbsq1B/GV6AeYCoTpK2LXaB+uqebiVUqPQlW7aKLv1jfMwfirs0S/AKhqb4IcNRB5GVdnR21CrSbUZk4Ajx1cUI6kBcT1t05sQOd2sw8w4fNdnSfIHorlOtNw/6e/e+mAd98HDzUVSkolIkVZOlIkSoFQmoQY8pQVHKUFZaSSiUyUiI6PoEf8A7CzftD/I5XdaI9pUd0AfGkLMT75HNjh81d9Xf4DarFMDpVadalaa1Fs5MeeZAHwKslrs5wVRdY1YutpByaxgbwxJ8yUo6HqosPdrViMy2mDuHed8W8lYriGjeuZ6vrP2VhpTm+88/vEx5Qt8504nJQcN1t6e+j2M0Wn6y0EsA13ImoeUDi8KhvWz0F1XWJ0g+l2yo5pmnT+rp7CGnvO4F047A1cwHbPWzBAz163pHlSRw3RzH+UlQYesswR54oJHHHPXt3g+EnHimu2+fxOXMbVMx+A4YxgNpgYDYI3Icz1v1atqDDqBeguozS/a2E0ScaL4jY12I9b1Qddmz1/k6l3nUjpnsLaaLjDazbu69OHnCD0FXOEKiumIi3WgfrXfJXrUVF9N/wDvrR98fytWkaRXT0RcBZaN0QDTYfLHzVKEq4+hrosNBzjHdI8A4gFCOsssc1zHWuf/AIJw/wByn4CTjzhdRY2SJBHHNaLrJaRo6vgCe54DtGyUFGIlJKREOlEpqFAqEkIQYcpQUyUSo0klEpkolB0nV/TvaQswOp5P4WOcPMBXdUAnHNUF0Y0y2x2hlqewvFMP7oIaSSwtmThrXbDrisp9qz2gcOyP/sFYLFqNBbJVKdNqt611McoHzjzXS2vrfsVzu0a5MYSKYHO8uFttuFasazhAc4EjMgYSOQSi8tCUrtCkz3abByaFzXWp0i+iWU0qboq1pY2Mw37bt0A8yF0tgttM0u0a4Fl28HSIuxmvP/T/AE6bba31QZpt7lPZdGZ8TjwhQc7I1bvXwKHO9fHHjjO9RhxCW8PXwQPn161Tq3p5EgjhPEnCYzOY3SomY+vXoKR2Xgf7xnr1oHWc931qOE7MTnuT3DePHxEnP0QobLrHrZlrCnPqco1Z54AaskEcnh8o5Ygc5UmjLWaFenVGF1wOHnCZGz15DHXyUVVsj1v3+PEoPW1jtba1NlRpkPY1wjeAfmqO6Wvm2Wg/rHfJdl1S6c7ewCmXd+gTTO27mw8pHguH6SvDrVXI/OO8sD8FpGulXT0CrNfYaLSMmkcjHyVKJbTpK0taOytVWkGCGtY4tGJ3QoPSlkZAWs6e0S/R9pABnsy78JDj8F50Z0g0rcqVWWq0mnTcA5/aVIkmAJlZOjekdsqsJqWuu7EiDWqREDAicRxRSpJTJReRD5QmSiUQ9CZKEGFKUFMRKjR8oTJRKBajZBG31rUdv0SGUBWv55NOIIvlueZOBUkrB0lbJp9kSZbUJA1Bpbq8SeaBxsINKlWvS2o99Nw+01zYIBO8ELaArQ2a23aT6RBMvp1GGcGubIMje1x5BbsFBqK9tqi/S7SoGFziad91wknO7ksUEqfSDYqO3wRyUOIzViEKjcFNO5MIQRAkLJe8CI7xLe9I1kZADUFA4LKpVGGndc5zXAy0gAtOGIdkQd4nhrWaqFr4diIIwMYZZnipBaJywz3DHhlkExzWgAiScZwgDZG3WolRO9rjs8Muamst8OnDXrGtYtJ8YLOptcch5Ko3PRHSVpsFY1qbWua9pa9k4EHIwNYKyKlQuJcTJJJJ2k4lauzWVwIJx+QWwKqFla3S9YgADY48oA/mWwK03SDNn73yUV0mjtJdtoWvZGD6yhUbVcBiX0XPBc6M+6YncAtDoI9x33vkFr7BaH0HipBhzXNOJF5j2lrhI3H4LM0GfbAyw+YRW2RKalRCyiU2UKodKEiRQYMolNlEqNHJU2UkoHrVaRpkOvaj8VswVFaqN9sa9SDVtpExAPeMCBm7YN+I5rd2OoS0XhByWnDbpMkhzSC08D/hbOxvmXEy5xvOyzMzMAQdyDH0s3vNO0Ry/wArHY4bSsvStIm67ZgfFYdMDWUSlcRvUboUpaFGTuVQxRqVKz2H7i2PNRTabtSkuxqBCgaFNTeclRPRu7Ph81O2sRlPkoA3WpW1Br85RGRSqSZcIG2YWzLta1LC07Rs1hbGkIEKiSVqdNMvOpjbe4altVDajDScJAJE6jCitNpCrgynHsATxIGCzdCN7hO13wC1tG9UftJzJEjiQt/SYGgNGpFSSiU2USqh0olNlEqB0pUyUqDAQEqFFCRKhAJQhCDB0pmFnWb2RwHwCEIHWr2HcFpqaEIiRqEIVREUN9h/FvzQhFiIKd2aRCgy2Z" +
                                                    "JUqFUFlzW0s+XihCpNSqOrkeB+CEKKwdE/a8PiVnpUIGoCEKoChqVCgVCEIP/Z",
                                            contentDescription = "",
                                            modifier = Modifier,
                                            //.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )

//                            Text(
//                                color = Color.Black,
//                                textAlign=TextAlign.Center,
//                                text = "Blazers",
//
//                                style = MaterialTheme.typography.headlineLarge,
//
//                                modifier = Modifier.padding(bottom = 26.dp)
//
//                            )


                                    }
                                )
                                Spacer(modifier = Modifier.width(10.dp))

                                Card(
                                    modifier = Modifier
                                        //.fillMaxSize()
                                        //.fillMaxWidth()
                                        .size(190.dp)
                                        .clip(shape = RectangleShape)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(ROUTE_ABOUT) { inclusive = true }
                                            }
                                        }
                                        .padding(4.dp),

                                    // shape = RoundedCornerShape(100.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    ),

                                    content = {
//

                                        AsyncImage(
                                            model = "data:image/jpeg;base64,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",
                                            contentDescription = "",
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )

//                                    Image(
//                                        painter = painterResource(id = R.drawable.logo),
//                                        contentDescription = "",
//                                        modifier = Modifier
//                                            .fillMaxSize(),
//                                        contentScale= ContentScale.Crop
//                                    )

//                            Text(
//                                color = Color.Black,
//                                textAlign=TextAlign.Center,
//                                text = "Jackets",
//
//                                style = MaterialTheme.typography.headlineLarge,
//
//                                modifier = Modifier.padding(bottom = 26.dp)
//
//                            )


                                    }
                                )
                                Spacer(modifier = Modifier.width(10.dp))

                                Card(
                                    modifier = Modifier
                                        //.fillMaxSize()
                                        //.fillMaxWidth()
                                        .size(190.dp)
                                        .clip(shape = RectangleShape)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(ROUTE_ABOUT) { inclusive = true }
                                            }
                                        }
                                        .padding(4.dp),

                                    //shape = RoundedCornerShape(100.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    ),

                                    content = {

//
                                        AsyncImage(
                                            model = "data:image/jpeg;base64,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",
                                            contentDescription = "",
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )

//                                    Image(
//                                        painter = painterResource(id = R.drawable.logo),
//                                        contentDescription = "",
//                                        modifier = Modifier
//                                            .fillMaxSize(),
//                                        contentScale= ContentScale.Crop
//                                    )
//
//                            Text(
//                                color = Color.Black,
//                                textAlign=TextAlign.Center,
//                                text = "Trousers",
//
//                                style = MaterialTheme.typography.headlineLarge,
//
//                                modifier = Modifier.padding(bottom = 26.dp)
//
//                            )
//


                                    }
                                )
                                Spacer(modifier = Modifier.width(10.dp))

                                Card(
                                    modifier = Modifier
                                        //.fillMaxSize()
                                        //.fillMaxWidth()
                                        .size(190.dp)
                                        .clip(shape = RectangleShape)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(ROUTE_ABOUT) { inclusive = true }
                                            }
                                        }
                                        .padding(4.dp),

                                    // shape = RoundedCornerShape(100.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    ),

                                    content = {

                                        AsyncImage(
                                            model = "data:image/jpeg;base64,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",
                                            contentDescription = "",
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
//
//                                    Image(
//                                        painter = painterResource(id = R.drawable.logo),
//                                        contentDescription = "",
//                                        modifier = Modifier
//                                            .fillMaxSize(),
//                                        contentScale= ContentScale.Crop
//                                    )
//
//                            Text(
//                                color = Color.Black,
//                                textAlign=TextAlign.Center,
//                                text = "T-Shirts",
//
//                                style = MaterialTheme.typography.headlineLarge,
//
//                                modifier = Modifier.padding(bottom = 26.dp)
//
//                            )


                                    }
                                )
                                Spacer(modifier = Modifier.width(10.dp))

                                Card(
                                    modifier = Modifier
                                        .size(190.dp)
                                        //.fillMaxSize()
                                        //.fillMaxWidth()
                                        .clip(shape = RectangleShape)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(ROUTE_ABOUT) { inclusive = true }
                                            }
                                        }
                                        .padding(4.dp),

                                    // shape = RoundedCornerShape(100.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    ),

                                    content = {
                                        AsyncImage(
                                            model = "data:image/jpeg;base64,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",
                                            contentDescription = "",
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
//
//                                    Image(
//                                        painter = painterResource(id = R.drawable.logo),
//                                        contentDescription = "",
//                                        modifier = Modifier
//                                            .fillMaxSize(),
//                                        contentScale= ContentScale.Crop
//                                    )
//
//                            Text(
//                                color = Color.Black,
//                                textAlign=TextAlign.Center,
//                                text = "Belts",
//
//                                style = MaterialTheme.typography.headlineLarge,
//
//                                modifier = Modifier.padding(bottom = 26.dp)
//
//                            )
//
//

                                    }
                                )
                                Spacer(modifier = Modifier.width(10.dp))

                                Card(
                                    modifier = Modifier
                                        //.fillMaxSize()
                                        //.fillMaxWidth()
                                        .size(190.dp)
                                        .clip(shape = RectangleShape)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(ROUTE_ABOUT) { inclusive = true }
                                            }
                                        }
                                        .padding(4.dp),

                                    //  shape = RoundedCornerShape(100.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    ),

                                    content = {
                                        AsyncImage(
                                            model = "data:image/jpeg;base64,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",
                                            contentDescription = "",
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
//
//
//                                    Image(
//                                        painter = painterResource(id = R.drawable.logo),
//                                        contentDescription = "",
//                                        modifier = Modifier
//                                            .fillMaxSize(),
//                                        contentScale= ContentScale.Crop
//                                    )
//
//                            Text(
//                                color = Color.Black,
//                                textAlign=TextAlign.Center,
//                                text = "Hats",
//
//                                style = MaterialTheme.typography.headlineLarge,
//
//                                modifier = Modifier.padding(bottom = 26.dp)
//
//                            )


                                    }
                                )
                                Spacer(modifier = Modifier.width(10.dp))

                                Card(
                                    modifier = Modifier
                                        //.fillMaxSize()
                                        //.fillMaxWidth()
                                        .size(190.dp)
                                        .clip(shape = RectangleShape)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(ROUTE_ABOUT) { inclusive = true }
                                            }
                                        }
                                        .padding(4.dp),

                                    // shape = RoundedCornerShape(100.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    ),

                                    content = {
                                        AsyncImage(
                                            model = "data:image/jpeg;base64,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",
                                            contentDescription = "",
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
//
//
//                                    Image(
//                                        painter = painterResource(id = R.drawable.logo),
//                                        contentDescription = "",
//                                        modifier = Modifier
//                                            .fillMaxSize(),
//                                        contentScale= ContentScale.Crop
//                                    )

//                            Text(
//                                color = Color.Black,
//                                textAlign=TextAlign.Center,
//                                text = "Shirts",
//
//                                style = MaterialTheme.typography.headlineLarge,
//
//                                modifier = Modifier.padding(bottom = 26.dp)
//
//                            )


                                    }
                                )
                                Spacer(modifier = Modifier.width(10.dp))


                            }


                        }




                        Spacer(modifier = Modifier.height(10.dp))


                        Row(modifier = Modifier.fillMaxSize()) {

                            Column(modifier = Modifier.padding(10.dp)) {
                                Text(text = "Recent", color = Color.Black)
                            }
                            Spacer(modifier = Modifier.width(270.dp))
                            Column {


                                Icon(
                                    Icons.Rounded.ArrowForward,
                                    contentDescription = stringResource(id = R.string.shopping_cart_content_desc),
                                    modifier = Modifier.size(35.dp)
                                )
                            }
                        }



                        LazyRow(
                            modifier = Modifier,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            item {


                                Card(
                                    modifier = Modifier
                                        //.fillMaxSize()
                                        //.fillMaxWidth()
                                        .size(190.dp)
                                        .clip(shape = RectangleShape)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(ROUTE_ABOUT) { inclusive = true }
                                            }
                                        }
                                        .padding(4.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    ),

                                    content = {

                                        AsyncImage(
                                            model = "data:image/jpeg;base64,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",
                                            contentDescription = "",
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
//
//
//                                    Image(
//                                        painter = painterResource(id = R.drawable.logo),
//                                        contentDescription = "",
//                                        modifier = Modifier
//                                            .fillMaxSize(),
//                                        contentScale= ContentScale.Crop
//                                    )
//
//                            Text(
//                                color = Color.Black,
//                                textAlign=TextAlign.Center,
//                                text = "Flannels",
//
//                                style = MaterialTheme.typography.headlineLarge,
//
//                                modifier = Modifier.padding(bottom = 26.dp)
//
//                            )


                                    }
                                )
                                Spacer(modifier = Modifier.width(1.dp))

                                Card(
                                    modifier = Modifier
                                        //.fillMaxSize()
                                        //.fillMaxWidth()
                                        .size(190.dp)
                                        .clip(shape = RectangleShape)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(ROUTE_ABOUT) { inclusive = true }
                                            }
                                        }
                                        .padding(4.dp),

                                    //shape = RoundedCornerShape(100.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    ),

                                    content = {

                                        AsyncImage(
                                            model = "data:image/jpeg;base64,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",
                                            contentDescription = "",
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
//
//
//                                    Image(
//                                        painter = painterResource(id = R.drawable.logo),
//                                        contentDescription = "",
//                                        modifier = Modifier
//                                            .fillMaxSize(),
//                                        contentScale= ContentScale.Crop
//                                    )
//
//                            Text(
//                                color = Color.Black,
//                                textAlign=TextAlign.Center,
//                                text = "Blazers",
//
//                                style = MaterialTheme.typography.headlineLarge,
//
//                                modifier = Modifier.padding(bottom = 26.dp)
//
//                            )


                                    }
                                )
                                Spacer(modifier = Modifier.width(10.dp))

                                Card(
                                    modifier = Modifier
                                        //.fillMaxSize()
                                        //.fillMaxWidth()
                                        .size(190.dp)
                                        .clip(shape = RectangleShape)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(ROUTE_ABOUT) { inclusive = true }
                                            }
                                        }
                                        .padding(4.dp),

                                    // shape = RoundedCornerShape(100.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    ),

                                    content = {
                                        AsyncImage(
                                            model = "data:image/jpeg;base64,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",
                                            contentDescription = "",
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
//
//
//                                    Image(
//                                        painter = painterResource(id = R.drawable.logo),
//                                        contentDescription = "",
//                                        modifier = Modifier
//                                            .fillMaxSize(),
//                                        contentScale= ContentScale.Crop
//                                    )

//                            Text(
//                                color = Color.Black,
//                                textAlign=TextAlign.Center,
//                                text = "Jackets",
//
//                                style = MaterialTheme.typography.headlineLarge,
//
//                                modifier = Modifier.padding(bottom = 26.dp)
//
//                            )


                                    }
                                )
                                Spacer(modifier = Modifier.width(10.dp))

                                Card(
                                    modifier = Modifier
                                        //.fillMaxSize()
                                        //.fillMaxWidth()
                                        .size(190.dp)
                                        .clip(shape = RectangleShape)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(ROUTE_ABOUT) { inclusive = true }
                                            }
                                        }
                                        .padding(4.dp),

                                    //shape = RoundedCornerShape(100.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    ),

                                    content = {
                                        AsyncImage(
                                            model = "data:image/jpeg;base64,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",
                                            contentDescription = "",
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
//
//
//                                    Image(
//                                        painter = painterResource(id = R.drawable.logo),
//                                        contentDescription = "",
//                                        modifier = Modifier
//                                            .fillMaxSize(),
//                                        contentScale= ContentScale.Crop
//                                    )
//
//                            Text(
//                                color = Color.Black,
//                                textAlign=TextAlign.Center,
//                                text = "Trousers",
//
//                                style = MaterialTheme.typography.headlineLarge,
//
//                                modifier = Modifier.padding(bottom = 26.dp)
//
//                            )
//


                                    }
                                )
                                Spacer(modifier = Modifier.width(10.dp))

                                Card(
                                    modifier = Modifier
                                        //.fillMaxSize()
                                        //.fillMaxWidth()
                                        .size(190.dp)
                                        .clip(shape = RectangleShape)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(ROUTE_ABOUT) { inclusive = true }
                                            }
                                        }
                                        .padding(4.dp),

                                    // shape = RoundedCornerShape(100.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    ),

                                    content = {
                                        AsyncImage(
                                            model = "data:image/jpeg;base64,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",
                                            contentDescription = "",
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
//
//
//                                    Image(
//                                        painter = painterResource(id = R.drawable.logo),
//                                        contentDescription = "",
//                                        modifier = Modifier
//                                            .fillMaxSize(),
//                                        contentScale= ContentScale.Crop
//                                    )
////
//                            Text(
//                                color = Color.Black,
//                                textAlign=TextAlign.Center,
//                                text = "T-Shirts",
//
//                                style = MaterialTheme.typography.headlineLarge,
//
//                                modifier = Modifier.padding(bottom = 26.dp)
//
//                            )


                                    }
                                )
                                Spacer(modifier = Modifier.width(10.dp))

                                Card(
                                    modifier = Modifier
                                        //.fillMaxSize()
                                        .size(190.dp)
                                        //.fillMaxWidth()
                                        .clip(shape = RectangleShape)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(ROUTE_ABOUT) { inclusive = true }
                                            }
                                        }
                                        .padding(4.dp),

                                    // shape = RoundedCornerShape(100.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    ),

                                    content = {
                                        AsyncImage(
                                            model = "data:image/jpeg;base64,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",
                                            contentDescription = "",
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
//
//
//                                    Image(
//                                        painter = painterResource(id = R.drawable.logo),
//                                        contentDescription = "",
//                                        modifier = Modifier
//                                            .fillMaxSize(),
//                                        contentScale= ContentScale.Crop
//                                    )
//
//                            Text(
//                                color = Color.Black,
//                                textAlign=TextAlign.Center,
//                                text = "Belts",
//
//                                style = MaterialTheme.typography.headlineLarge,
//
//                                modifier = Modifier.padding(bottom = 26.dp)
//
//                            )
//
//

                                    }
                                )
                                Spacer(modifier = Modifier.width(10.dp))

                                Card(
                                    modifier = Modifier
                                        //.fillMaxSize()
                                        .size(190.dp)
                                        //.fillMaxWidth()
                                        .clip(shape = RectangleShape)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(ROUTE_ABOUT) { inclusive = true }
                                            }
                                        }
                                        .padding(4.dp),

                                    //  shape = RoundedCornerShape(100.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    ),

                                    content = {
                                        AsyncImage(
                                            model = "data:image/jpeg;base64,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",
                                            contentDescription = "",
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
//
//
//                                    Image(
//                                        painter = painterResource(id = R.drawable.logo),
//                                        contentDescription = "",
//                                        modifier = Modifier
//                                            .fillMaxSize(),
//                                        contentScale= ContentScale.Crop
//                                    )
//
//                            Text(
//                                color = Color.Black,
//                                textAlign=TextAlign.Center,
//                                text = "Hats",
//
//                                style = MaterialTheme.typography.headlineLarge,
//
//                                modifier = Modifier.padding(bottom = 26.dp)
//
//                            )


                                    }
                                )
                                Spacer(modifier = Modifier.width(10.dp))

                                Card(
                                    modifier = Modifier
                                        //.fillMaxSize()
                                        //.fillMaxWidth()
                                        .size(190.dp)
                                        .clip(shape = RectangleShape)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(ROUTE_ABOUT) { inclusive = true }
                                            }
                                        }
                                        .padding(4.dp),

                                    // shape = RoundedCornerShape(100.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    ),

                                    content = {
                                        AsyncImage(
                                            model = "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxMTEhUTExMWFRUXFxcXGRgYFxYVFxUYFhgYGBgYGBgYHSggGBolGxUYIjEhJSkrLi4uFx8zODMtNygtLisBCgoKDg0OGhAQGzIlHyItLS0tMCstLS0tKy0tLS0tLS0tLS0tLS0tLSstLS0tLS0tLS0tLS0tLS0tLS0tLS0tLf/AABEIAOEA4QMBIgACEQEDEQH/xAAcAAACAgMBAQAAAAAAAAAAAAAEBQIDAAEGBwj/xABEEAABAgQEAwUFBQYFAgcAAAABAhEAAyExBBJBUQUiYRMycYGRBkKhsfAUUmLB0QcVI3KC4TODkrLxNnNDU6OztMPE/8QAGQEBAAMBAQAAAAAAAAAAAAAAAAECAwQF/8QAIxEAAgICAgIDAQEBAAAAAAAAAAECEQMhEjEEQRMiYVFSMv/aAAwDAQACEQMRAD8AECq1i+UqBc+8RVPpeOF9HrR7D5eIBcQNNnJaA1T284DmLNorGOyZz0EzpusbTNzMdoDXMikzWtSLONmcZUGy0BSjVoumJUQAwDawtlzS1bRd9vuIo4Ozox5IpbIzUgEpNaQtwkwZVIeoJgtK8xgDEJ7Od0VF0t0Zc92jeACkqKTbSDcOCSQ7NaKcaoBSCPAxsnKrxh+kOTWl6Oi9mceETFhQKipBSwLEkqS1dPGK8RgMYhRUqZMSkitEqYWLFop4FKTnUuY+VIGZqUUQC50ADnyENMdLwyQSJ81KibCYCU6FO7Pod4NVs2w/e1e0NeH4mUiSmWhbkC5uTq/WEHF55UTWB52EShPaBalKJDOEj1ywBiMW5qYolu0JSrQBiKRTg8cuXMSUsb0UHBivG41O8UYJ1LCrDSOlLWzlcvtoa4TGTJ5MyYQeZSEJFEpSDUgbk69Isnyy4G0c/gOKFPIQ6QVM1xUmOgwE9KgwLv8ACKzg47Jx5oSVewwTTlD6QamekjrCwlqG0Witozs1GCZ5LC9YYTZDp2pCSQMpfWHeHnkoVSrRnKzaDSVNWJ+Bzsi5iANXfeHaZ5UCiF3D5QCQSA6ia+cdEjCAMRGc1fRrCoUm+wXCTWTUl7NHT/vkiWmWm9BHMSyBMbrDabLzKDBrWicd06IyuLkr9DZpm4jIHyq/F8I3G3BGHys8rl4pREQTOMFZ0swEBzUmNqOTkFgBgXiicqt4qzFmisxRRLSlouMykVxFJEQzRNEJmTFm0QStjG1RJSAYsiGyaZjRvHSs8rMLpjcuS4i3BpL5AHzUYRWS9ospen0DpR2kp9UwXhuGzJqUqCWH3lcqfU38oa8O4PLlAlSipfMcjcvIWOozXDeMEz8TMZsraF1oQG07tR4ReOF+zKfkJf8AKILwiZKFIKs2cF23YIAFXNViLJmLwqh2i5STNAZQIAUCKEGAMRiMxyuFLCknlB5UhQVV7uU3YQp4jhhPAy/4hDkuQyQWHlS25PibzxKSSM8fkOMm37KuN8aQe6GGgd45+fxNSyyfWBcbw9SD94C5Fh56+UMeF4ZLZtqxXgoI1U5ZHopwuFLuanrDfDoy1iUoA6QPiZ7QuzRR4o53Du5Grn5x0HDiEkEm2tWFqH62gHhvD1KWVAXJ6fP6pD1WHyJAOZywrlKD0YWo8bejg6YXxDHgqCQInIgCbLzB00MF4Bbiul442uKPTcnOVsYlNYZomJBAtSsL0EZhF2YGY8Ue0aJ07ApmLyTMuZg7gbx0H2tRAINI5P2glntEnrDuQrkAiGqWiedumugvGzKpUIaYTiYCg9aCFbgobWB5C+Y1cgRSD9F5RvZ2P74G0ajmvtStoyNuTMvjRzLtGT+7FBWNTGY2ZlAi1sycYoghHWMXKfWKzNitZU8LYpFqpXWIrTSBy7xtSjE2yrSLTaJSS9rxXhpS5ighAcnT8z0jruF8HGHKCplzF5g1gkpqctPj1DXi8ItmWSaiB4LgqshmTSZaWcBnWqoFBpUi8NCmXJUlKEs68pUaqU6Mwr4jRtIvmz84agIyqI7zc2ZKgr3g6Qw1bygDiiTlAeoWKgpIZNH5i3uj9DruopHLKbl2axE11Ai2VOVyaBq6uL+bbWWYjmSc6QVsCSRyB8rMSHKmplt0gqarMKe6VDWxOetSQefVjaggKcahT91culTq1QHNCx1qBElShayhXZrIDGkuWC/mABXyfqIFxJKQcvKciEACveURU+BHoT1hrNmBsqqZiQC6q95Sri5KnJ1akBzcMA4SQJaXUS5K1FyHKjoch6kJYNSANzRLm5kmiJdx3XLOzgWa9dVHZgZXDkliQwUWSm1ND0sYGxEuYkBnAmKCiPeahY6PlS/SkWSuODtCpYIyjKHI1YMzaAjXQamIastGTi7Qb9gJ5UqAqpNd0glvGhjJHC5YTmWSoZsp/AR94eLeogRHGEiWk658/V3H6HT+w+N42P4iQzHw8KeX1QQUUi0ss5dsczZyZYNkqT7vuqG7EU2vHOcS4gFKZLBJYgG1tNqNAGJxqlm+gHjv8o1IlE+GoMSZjrh2KVY2tUu39QuPEecHrln3b/OFkiWE93UW2+rw54cohgenxpTxMUnCzXHlcey/BT3oSyhoYPws1yA2sKMdKNToCU5hvsdjE+DTlBQSS+xjinBo9HHkT6DOOTc0xKB4mCkz2S12gPiklpgVq0U51IHjELpFn2xpw/EnP4xVP/hzionvQukTSFBVg8EcZmElJitVI0c3wr+B/wBuG8ahBmMZGhlYNMk6vFmJZSRWoivNA6iSWi6M5IMlrAaJTFwGtBEZJS9zAJvovCw8SEorUEpDkmgEA5SDSOs9l8IUp7ZRYqdKegYgq9Q3gD0i0Y2zOc+KtjbhnDkyEgO6lA5lUFUqHKH+t4qn4kleZNUZRkOhdXOq7Xy1pQ3jOJ4jLLUU8pNTzFN2SDo1daeTxSMTLBSltymhLNc0oBYULOI6UqOFtt2yyaebM7sk2d7nVJeyVm7Fi7RWqYrLlUp/dU6msAom5YAOXp7tWaBZ+IAc/eYEkk6KDMHYMt73aNTpqiFMbZtRfKkbhvQfnEkFGCxBcoIawJINCksQHJCXeznR20oxBObKGyqWkvUgBJBINDV29Y3wpNJtKiaolhsXTp+JXqb3jMapqimUg3Ua5g9cuytN/CACjKzSgEkBytL0JAYl6KOpH53ivsFmXyqoyepGUVBVUgjLWt3i3DKUQQA5CveUxY0ckgUoBqLtrEcZMolCS9UoTQlJNQ9HJBOYt02LwAKtbqzKTXIpgBoGSwPV/ikG0KMZhkFLNzFRUXDOM1Sw6oIbwh4UAEhSiSoZlEhjlBl0AowyqWQ3jA8zDIUGIyl0Io4AIMpOlyCtX+gQAgxXB0Z1BJozjyv6AiBE8NbLV/CvT5x1RwiFWWzqSCxFQez12eb8DGJwcq5L1q6mocpBNWFJqPjtAHMy8EBTwbW77dPnBsqQQ1Gokk7vQhhv+UOFLloTmSEhrWYsLlvGo0ZtKjSZ2Z1e7QeQd/iPjAFWCw5UtWwcehY/L4Q4kSWZ2qfkQB8/+bwHwtkVUWzAh6VLjrU3Gp0pYM5ooFAA0UWtsxc9QS/nAFWHWSuYmhfMGLF8rHuvoArTXrTOwTLKZgsdNntXWJYAh+84HMeYavoLX0p1Z4Hxc5S11ICRpWtC1fFm/tFZwUlTNMeRwdoNxKSsFRBpUQsPMC94dysU8qulISLSQo7GODrTPVTTpr2RMp0itjBuOlAoSYGIg3EVlg6RDZPGgHsUxkVun70ZElaNK4Z5RX+6NlR13ZIMUqw4JpGtmXFnKzeGrI70UI4Mp7x2KsCGgY4ZolMq4v2IcJw0uAakkAecdXPSEpTLBLJADChcMadTA3CcO81z7oJ/IeFSItnzQoODS7uNzv8A3Dimka4Vqzn8h7UQbETQVgvQAEANsUi9/qnKYWYjEuvKzsSMta5qnokOB4c2ogvic0AIJFHFuYANlU6dsrppuW0JRY2YyjraptUuXcB28Hp5xscw0wmNZYsRvysLVsQCb9AYMWhlUFCRRlFmYdNWpQAh+kJ8TMyhKwbcw5g7AO7NsSB1MOUzszBWUpowAooEAkmwNVMSN4AVYVeTErSUk5wFGj1IBNTpVVx8oJ4lLooJbKrLqXASRZKWJsKCB8fI7KfLmscuUIJUBTOFJBL1UDZzsRDQpBTlLkeCdN/V9qQAPLLJVo0w2YMWpRIDG9C5s4tFa8MxBOYkEByczAkZgAXDsHJbTxieDXVcqpAa9XSmgOVIATSYmly1gI2pJqLH4vMLBrGg+tgK+bLWrkdKhIVsXIzMwp5QumSiAAm4Aq+bmVmA0fvTM3kPGGmIBLtQlTgmlTMAuP7/AJxuerMC4djQ6gXzc1qsAmuvmAnzKcEEsSVMHsVnKdD/AOCPNo2jCKynPMyjoxJGVCTegDpHi2xhnJKEIQVVYBtRu9EjMwV8Ds8DpklbkuwDJBo5yKVm6JoKdTAAExSVrAqUuXuWqwqH1aGayhSXSSwBoHFEsSA7AUBud4v7BKSogChCd6OS3pNSf6fONzkkILiwmA1HulvD6qBaAKsIEqSpQsKCyr0GtG2YXN7xNK05A5Byh7EuyevT6vEeEKdBQTW57xNWvmqziwpQ1pC6apSssitVcx5u5e+7fDaAGXDgewBVdQzXegcuHqKP+sQllxpfrvmO7H9RBE9JIADBLgF2onyNapAc6Zq0gKdMH+HLFdSa3JDqrbmDD11AAtw2J7NWV8wN+n9qX6wRxNPKSNBCDKETBzFTggvVswcq6WFP0h/gZiVymubGOXyI7Uju8SdpwOal488wBvaOgkTXw9amOZnyAJi0mhFof8JL4eukZzSo2hJt0wDOIyLPtY+7GRFMm0dCpC37p9IkgzAe6fSPROwQNBEOyRsIsRo88mT5n3T6Rp1EVSRHoCpCPuiFXHJI7M5Uh4PoldnOcMQyJylWZvJiSwNPWKkTCAdrnVw2m5sLv6QTIQfszMylLAqzHvA/CBpbjM+zUfpR2csTHVjX1R52V3NgWJZiCQQSwJD2qzPrSOexkpiUkV3IY3c/zM/w1qYcpxDA8xAzFLU15lMXoW/KlTC7ikt2VXMNfeLu5PWgp+kXMyhM/OgodiLiwZreQ06R0PBHTK5nLOBzH3WDUt3f1tHGysVkWFWb6+tY7Phc7+AgnulVC6gzlQSCfIU384AG44gLSxIAILuT3hTN+EC4/k61t4RijMkVbMnlLgMCmgbVqH1jeKSGY2LsHULzCku9bTFfhqTAHAAO0naOpBob5xUHzUT5QAYgntzRgcqbFsxCg1DzHmTuANbPfOGWuxcvqzAOLWanhEOJJIZetElyBd6EgP3mDAh31ZouxitWYEOzZaXqx+f9iAOFWHWWnXfMaj6+IjUqWFFLkMRXum5FtKbHydojOS6SRU5uhegyg2uaRviE4IQ2Y5mcC2jBIfU/lAFWbOosHYHeqmOUOBWyjTUCxMHqmAEnrmcPbkcu33V3G1YrkYYBKCCGABNGobkF6vV7xpcxhmKSA2Zi7kCoerOZZTXo1IA0ytaVY/6RLV0qyD8YF4liyUFPvrYMNVKvpWlYunLLtdneh2ZzX3gB4FjA2HZWISFM0t1HcqpoXNOWvjABaJYQnKGoggmzqUw1rZhQ/nCzhmZc9awe6kgElkgkuS9tqXrEuPYglaZSaE0bqT9H9YsCVJQJMokO+YipqOZWl29BToBfjpxWoSkKs7ktysoVLChf0ua90TGYmVJlFKQC6ind8oCC43cre+hgkzESUMBzKBZiSo1UKi1st9BC3s8xzL5l1I0AJqQBu5vXu0IgATDqJBWq+ltfow64HPrlLOaP4QoLAuSGB022pU+Hq0E8NVlWMwa9HqGimRXFmuGVTRH2lwzLzDzg3ghIlERfxKWmajlFYW8LSpKFC1THJdxO6uMyOQxuKvtMZE1IraPbc8RzNFhMAz5rAgRFmyiSm40C8KeJcXSkbwDjROSSTVMKMQnPu0V5E8UPiETMOCXAJJBHul2BB8fnCickpSSopc1Ol3JJHhQ3ZjWhhvL4eOylAqYBB2LvVq0Hi0cPxvGkzFy0kkc2YAkDbK+th6dTHfHpHkzdyZCSomUTupSh/UQ0UYnEAock1YNdiGrUXcaeOsUqxvICQ1C+rVcfO8CdtztoXKdgWLH1aJKgWJr5x3HAklODQhQNQqwc8xof9odqPHCpQVLCRqW+vKO9krrlSl6MxBNCLVzABwPUWaAKlTc+ZifdSLgDKlnGWlFKJItyExT7PgFU+ZpmGUMLJcAW2Ap/aLuIIBBYBKlXL0OUDlbLXxAqxfrrgCOQTAGCj3QkAMkvYB7j5UrAE+LkhJ37RKQ2X3S9PL5iNqpKS9CAGbWlAQDYtvsavEeLHmTQVCg9ejAknfop9oImVOWwHwCW1I8A0AUFGSWHIcIGhagS5OYU8Dt0gFGFzuVXVlqQTlBWBp4jaLMSgTCpy4HUhyQVWAr9awWhAdtyRv3uYGn4gPnABEpQdgSnNVgwYC1NGKhVjQCAJiwVgauNQo8lRXWoD7vBBVUl2uNWBLFTg7FP/qODSMkqKXWwJLhIbq5Z6m1/hAA+KmCWLFzZLAl7/L5DeK5KOzyk9+q1GtCdGJ5S5PwEaUgdqAo5yGzd1rAkMagEkB+sBcZxZWvsk6tpUfX5wBSifWZPIduVIqMxOji36A7QZgpyynMcuZRu1Em5Kixa3xPjCycrMpMqWOVFNeZVXPkKf0k6w4mpEsAPmJSwJNQx91qga1s1jAEZeRBdbqVR8zOSba1c1YF62cscxSVqJP8AhoNiQSrqSL15ibC9IKwMg5c5DFSibGgBSgX8VGpP5RvGy6KJOg22Bv4qOsAJ5qQkEChqN1Aggs7ltmGx6RtaWKFGmYhh0/5DQwwuGBXmNsxI6lG3mW0FrwFxpYJABolm6swDeQf0gE6DEYoJdoxCgXAuaxDC1JpYesSUQC9qNSPPemevG32A/YlRkXZzGRa5EcIns65iReKZsp7RbNZ6iJpVEUXTFs3DBmNYXzMIhLnJHRqSDFE1AaK8SeQj41KHZZdUuUg1OlGfq0cpiMCpModokAgd5yo1GaoatXTcufWOw4nzAoCaFlLUaABgGAZy4DUNK7GOJ9qOIMspL1zC/iw1NlA6Xj0TxTjcRiwAUagluooCPgIDkT05kvuAeg3EG4rh4UVKBLuaNRnLVfZoXYjBFNcw+LwAVxCay0rSwaoAsBt6fOOswXEBNCSRUACgqQSw0rZo4VKlsaU1PjSOv4TIGr5WADNrX9LwA7xgBL/eKfQFQvdgVpfw0ivhQbDSlCoyVAbYksw367eBtmGxetiOtCTWgPK+kb4alSJMpISGUlJJJch60BFbpFN3gAOcAqagCoTcs7ZimlDUskkt1oXaN4oGiRyqVy0NXclr3oTu8X4RQZagKJUoDaqlDQN7p11qLRBGFOZKitbjMq9tLEMalL/8wBWiTkZgWB9XfMXF9ST+kXJRUAfy6PflJfr89jBs6UeVRYlJa1NQSA7ChPWp3itCLh2PKn/SXA80n6eAK5cnlBUGFyQ2hAcV1y/HpSufPyhUw2Y5R002qaU0pqYnjcQQnIASavUJZ7uo7OQPCBOKqCk5mZjYWDOx0p6GgteABJToAUoupQUokkkAMSGpqfkLVjm5+L/iKIuomtyAKesPeN4gZQRR0pGj0Ae21vKOWkrZZeAO94TwuSEJKq0d/gdqdPE9I2qUgTAKOSwLihFSHdmargWqTpCrA8TK8oSeajDWliKUMOcHImd1bJYgsCSpgHoKlTOHZ4AYFYSAkjchQGZmrcBrp20DgWCnFlKuZzUsABqAAbjuiCcZjAUrZdXCXzAkZUqJsTWg20BaKJEkEkrIKAKACqgHFxeqQerwBQVBEoBIckDVySaivW3iD0hVj5JTfvKAP1vs/Q+ENDMdRVRkkly1TYZelAfjvC7ipqKu3L6G/wAYAsQHsbCIrmqbKBXeIZwDdvziSpyU3jhfZ6yVLsgyukbgT7anY/GNRNFeS/p9CiWDEVoAiaERi5cQXKSh4GnSiHrSDoqxagEKJ0B+XSC7D6OSdSqnlCiFVLat0L0SWr3tNU2N4clSxqS3iC4TfRwCP7wzn4pKwklLUJsXL1Dh7MLGzwlxylOa31IJuRWtjQV6eUdx5BznEMOpIZAcFOZTEFq0bo4J8CI5ucSb7/RjqMUZxmoAa7AkkAipah1r6wmmYPOpQfLXbrAAeIUnIyaEiOn9mi8kKIOw6tXyalY5GdhCAS9R+Vx4x3PCZAlSkqNHAAcMMxsn0rABY9527zEC42LitC/qfO8zymWkJSRyUDmpDZUmg2NSAw2gcoTlDr2VTme3xv6xL95y+VKQHokAMTrsDoekAXyMLllpSbmqib+mjBy0TWoONqCtXzO4J1DVf+8ZNxgymvKAzAO6r1LUT89tITYrjcsEB75tWuA/xS16ZiIAfSprVJLFzlLUegAexDDzMCrxpSFGlSSGZzQAF9H03AEJkcbSXLjQtS+wFb36ZSLGKMVxYZnNtW1YejA1G/q4DUkhJKiHUoJDWSCkMNXqfgb0ECY3FpzZC4ckVDV6ubm0Ll8Tzy8xpUWNeUOD8/WFuPxvaKcDV/BjAE8aMpy6AsPr0MJp55i0GhalHKkZlnQVMTlcEndolM1CkBRbMQ4HmNaQA79l5iZcrOlDrJ5lAOQBoNQGDxOfjpilNlZKjmJIOV9aWUafG2sNuH8ATIGVMxXMaA5T4aRpPCiiaZmcqLEEFnBNHroWb1gBOnDN3kzlOSaJIfc7gMY3NnzDREkhNAAS72bMXcsCKbQ+xE8h7EuBzWFfu+9Z215aawHMWGKmolw6i3TcuQxKl6WDQALge0yAKTd35gyj1DD0hbxJbHrfQ7V+UGzpykspy7PVwGIPu6A1ATdg7ws4vMzLzOSSKv1qYAITJYAk9Y3MnJJ6RIrBlgNoPKkQ+zuOkcT72enbpUS7STsYyKPs8ZDRNs+hkJjFCMztGRBY0I0pLggilo2tewgRWJW/dgDhOKS1JmlFAWHMXLMzgfD6uvmTCLHViTRw/wAyCD6x0ntVLyntN2c9GY6dHjkOITAtSgAShFCW7pfpZ3VXb0jti7Vnlzjxk0AY7BMVFamSeYBIBcM9zuC9oSY/FhLn3j+InzO/1aH3FMMVKTJauYOpq5QntAKm7KKfqqLiUgX8dOrVeoq/pElQLhGCXPmhIBKbq0AF2fR7R2mL4KVhC5iyQlyEIISkHUA1Jqw/SOP4RxISpzkns2U6R7xZg4tdo6DBccQvMACoq7zFqAM5PzJFyIAd4aWlgEAAHWr1YuSagV3oT0hehMrOqVKSM7FZmEkhnrb3i9BTz1FxHElZhLlJKlqolKQCVKJL20qRXQVq5PUezvsXiRKUqZllLWXUVKzKDWACSzClzvFXJLsvHHKXSKuDezicQlRkzlBYPNLWQoJIDAggDpWto53jvBjh15Z8u9AoOpBP82h6GPQfZj2c+yL7Xtc6spSwTkTUguxUqtOl4cY2UmcCmYgKSbghxHP8tPW0dq8dTjtUzxFfDkLUyE1/C9iWroPreFM1BSrKt/HSPWsR7GLQlScMUhKi+VT0P8w0vTrFWB9h5svmMuRMmkgutSsiQCCyUZS5/EY2WWD9nNLxsidUeW4fMTlT73p/xDbh3Cj2ktJGZ1OoeFS7+Q823jt+J8Mly1Eq7JMxLsEyyohJBAzZQ5BZWw0BtCdfEEk5FlVHdMuWpOboaAkeJa8aGHQ3yChyoSCKMjMq9AGI8G3I6wpm41pnZrssMlW5eozKo3WoDK3eCpeLaW6glGUgpSSFZQGp4kgBhWsKvaKUCgLBfKQSpgS9HzLsO9RCXZvQAyWoS1lEwugsytmsC+h0BbagjcmYqrKBqQzqNaOWBBonwAAqTpVOmBUpJVqAGzOVEgAkJFAXNVq2YCEmJmKlHKo5kGrVKXIG5A2v6QA1n4o91Cwu7lNEpSXJdQ5WZjUk3gUY5JNaq0elRbxrYM0VHGBQuHbUu1zY01eiNYAxUwOSCam9fBq1PjfoIAJx2JSEkVc3NyXodaE6kQoUQbRegDKXA6bl9HiuRLdQEAhotISnegjap5y0DPE1JB0aKFS8xFfARx9npq0V9qqMi/sV7RuItFj6CyVrG1LiAqHMQCWgCwKfSMWikR7basRmKgBL7SSO0kqYOUc3iNf18o88+05pqUMGAUpQy1UBymp1DvTaPWxKjzLinDzJxSwQwukgBwkmihuBUERvhlqjl8mG+RsywWCwM3uqaigLPsR+vQQjxWFE6aZMhKps097L3UDdZPV/WHOIWyVKZwAS33VJ0DdAW/mjsOF8NTgcNmIdajnmqFytVTUtQOwfQRbJPgjLBi+SVHifE/ZrFynUuQoDehfwALtCjDFQUClwRtH0Lg+I4fEKKArMtnyliQN6PSEHtR7GSlOuUjLMu6aBR2IFD43jKPkf6R1S8L/LOR/ZvPUJ6gJJXOKSQokJShAZ79SLbx6/gpOIWk9oUJFKJJV6kgR5v7LpyTQmYoyvdK2qOhHkI73DylqUqWMTyv7yUksNXB1vaKZ41Kzbx5fXh/A5QFhG0EPC1ExKC2dSjuQBGDEsbxhZvxHhO2sVFYhLM4wE6wDiuOgVJYbvQRFk8S7j68kyWUISTNdKlUGXIksTUE0JAYhr1jzz2gRMSskzUgdAk1arZQaVDOYdK4uMTiJYlTOSUFrmKGZi4yhAUkdST0DaxyXtOR2lVZlOaDMdakqUa1s2jVj0MN8FZ5Hk18joskYtADZlTFWc1YUNBUCohn7RTM0uuV2ZgU0erAOVe7YBIhNwEc1UgWrru4a9q/Iwx41jv4RCaBvdsbXyy0jU6+9GhgD8D4ynsghdClxqxB8G9TYaVgbiySqpDDSvjrrV/WFGCllUxCBdSgGGgJvD72jmCwZ20OvWnQDo3jAHPpURGlzCbl+sSTMi/D4bNWw+cQ3RKTbpEJEpa6JFBcm0NMLhQg1q9zGpKSAwDARNZVlLB4wnNvR2Ysajv2QnVJYlo1KUE829BG8LKNSq+0QxWIQALUjP8Nb9sN+1r2jIB/eI3jIjh+Dn+n0MtMQSKxmYmJAtAuWpRFcxIEaVN2jQEGERzQo4zwRGIQy3CkklCkllJP5jp0hwzRpReItros0mtnmPGcJMlBSVVOUkEZmW2wGr0b8mj0eXMRPkuWIUkEPXvf8AIgTiuERNRlWPA7dRCPgaFy0zcKsqTkcy5iRymWSSkVDOkgjLsBF8kuUf0xxY+EqXTOl9lScKSguZallaiACc3dGtgAPQRfx7j+FTMQOZKlkhKikGWVDRaQcwdmcCPPZnteZRIKwtthXzZw/pHJ+3PtQmeUFClZksR+EiEJSlUWtGmWMI3O9noyuCGdMV2rImGoKe6Row95PW/wAosTgJklQTPluNDUBQ6K/KE37N/blGKCcJimE4f4S7Z/wvor5x6lIxDDs5wzo0LOY6+KceJw/M+XI894/xSXIdSJK2YB8isofdbNHHTfa9OYlSvIfTx7F7U8BnzZRTInEyyKyyxCknR7x497QexoljOKAkAgBsiiWyqSfUKdj0aOdePH2dEvMnWkIOKe1M6YT2fKN9YBwuGOIChMmK7UEFIUeVSSwLPZQqYZ43BoDMAAkgnUlIJetjQfCIYzDCZUICUXFsxqdg4DP6VjaMIx6OSeWc/wDphqpWEkS84cq5ks4KlAlxSwyhh1YxymLxYKiyWD7wz4hJRKATqLjR9f08XhT2BU5A3PkAT+UWMxnwTGMb003BqD8CYp4jjioZRuTuzlyPUwMvAlN77ddoiZJEAMeB5ZbrVdm9b36bxZiM89RULPcn8oWBJg3hi2WBoqh/IxErrRaFXsNlcKSKk5iPT0g1EthpE1S2iOWkcrbfZ3Rio9IoSWiaXjAmJCBJXOUWgBeABqzw0UN4mQGpBa6IaT7Ev7vjIbNGRPJkcInuilWrG2JtEFywLxWiaBXSKGxYUtGJVEUre9oiVbQoFqqxTMUBEVzfWB1qeAbMUuOb9seLzcNJTNlqAUZiUEEAhSGKik/6RUVEPlnSOH/ahOaXJl6lSleSEt/9gi0FbM8kqizzzjGNVNWpVUhRJZ3NesKFJaGU1NBAq0x0pVo453LbB5ayCCCQRUEUIIsQdDHrvsb+1PP2cjFpX2hIQJ0tlZyaDtJZ1tUX2jyQpj1H9ifsmmYuZxHEMMPhwrKVd1Swl1Kr7qEn1I2MWKVR69w3iBU/YzULZnCaKQDqqWr8svjFvEMLJxCcs9CUkuyh3VOG1qL2MfM3G/aWZMxq8VIUqUc38MoJSUpFrb3brHo/st+2BK2l8RSUqZvtEpND/wByUL+KQb2gTe9BXtV7AzZIUuUe0lqzPqUBT2SO8Kmt7RxOFmMoAgAoSTlJUOZItlIOoD21j3bATRNlCZhpkuegnvS1OPMAsD0pHIe2nsuZv8RCOznENmAOVVG5gNRv0gQ6Z5PPwwJc6AVOozZSS31WMlOCQaBIBbUukKY2sFN5RZjsNOlKUmagptXQhwo81rjyhZPnEuHu5PX6f4wKl87EpzpJH3n1IFh8GjaylXNq9qsWrrAksB+UGwbd3r5UPrFsvOwZJbWnQPfz9YAhPxIJ84M4NIdRWRQO3UmB8Fw1SlOvlAqzVLadIcikZ5JVo6MOO/s/RYkk3jFGK0qjbxgdJuJAxWVRUubEkWXia5aLQRC8TGMWonVEGgpBTnaMiPbxkRRNnt65rxABorcnpES8VLk5kyICZEFoipLgxKBZMU8DoNYtXM3jQESQULml6p8486/adOCp8mWDVMtRP+YoAf8AtmPSFx497dYjPjZrFwMiHHuhKRm88xVGmNbMsz+pz89b0HrA6otX0ilUbnKSweFXNmIlIDrmKShI3UohIHqY9j/bBj0cO4fhuEYdTEoBmtQqQk3U3/mTMyj/ACneOd/YVwPtuIfaFj+FhUGYVHuhagUoBJswzK/ojkvbzjpxuPxGId0qWQjpLRyobblAPiTArJiECNmMTGGArQXw3iU7DrzyJq5St0KKSfFrjoY9s4N7b4qZwNeMBTNn4aaETQtLiZLKk83K2U5Zgr+A0jwpo9V/Z5KMvgPF5i6IWnIl7FQQ1P6piB5QDQdI/apw6akfaMHMStq5QiYl+hJSfhFOK9vODzKdhPT17OWfhnjyBIjcAj0XE+0/DfdExX+WkN6qhTjfa6Q38KQr+opT/teOQIjRaLqbXRDGqeLLmzkFRATmAyigD0fqWN46AilY47BlpiCbZk/MR2WLNaRzZttHT47+rKFrrGZoiY1njM2MVFJixajFYMSVZFUWyo2lDxPK0GSkWUjcCuY3ChZ7wnSKTcxkZFGamk3iBjIyIBTOvFqbRkZFiPRXPtHh3Fv8Sb/3F/7jGRka4/Zz5+kKlRUqMjI2OdHr37OP+neLf5//AMdEeMRkZAq+ySY2YyMiCV0Sj10f9In/ALn/AOsRkZAtI8hEbMZGRJBJMQXGRkSgyMq48R847KZaNxkYZvRv43sGXGhGRkZI3fZtVoqTGRkWKsKRaJKjIyIBqMjIyJJP/9k=",
                                            contentDescription = "",
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
//
//
//                                    Image(
//                                        painter = painterResource(id = R.drawable.logo),
//                                        contentDescription = "",
//                                        modifier = Modifier
//                                            .fillMaxSize(),
//                                        contentScale= ContentScale.Crop
//                                    )

//                            Text(
//                                color = Color.Black,
//                                textAlign=TextAlign.Center,
//                                text = "Shirts",
//
//                                style = MaterialTheme.typography.headlineLarge,
//
//                                modifier = Modifier.padding(bottom = 26.dp)
//
//                            )


                                    }
                                )
                                Spacer(modifier = Modifier.width(10.dp))


                            }


                        }



                        Spacer(modifier = Modifier.height(10.dp))

                        Row(modifier = Modifier.fillMaxSize()) {

                            Column(modifier = Modifier.padding(10.dp)) {
                                Text(text = "New", color = Color.Black)
                            }
                            Spacer(modifier = Modifier.width(270.dp))
                            Column {


                                Icon(
                                    Icons.Rounded.ArrowForward,
                                    contentDescription = stringResource(id = R.string.shopping_cart_content_desc),
                                    modifier = Modifier.size(35.dp)
                                )
                            }
                        }



                        LazyRow {
                            item {


                                Card(
                                    modifier = Modifier
                                        //.fillMaxSize()
                                        //.fillMaxWidth()
                                        .size(190.dp)
                                        .clip(shape = RectangleShape)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(ROUTE_ABOUT) { inclusive = true }
                                            }
                                        }
                                        .padding(4.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    ),

                                    content = {

                                        AsyncImage(
                                            model = "data:image/jpeg;base64,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",
                                            contentDescription = "",
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
//
//
//                                    Image(
//                                        painter = painterResource(id = R.drawable.logo),
//                                        contentDescription = "",
//                                        modifier = Modifier
//                                            .fillMaxSize(),
//                                        contentScale= ContentScale.Crop
//                                    )
//
//                            Text(
//                                color = Color.Black,
//                                textAlign=TextAlign.Center,
//                                text = "Flannels",
//
//                                style = MaterialTheme.typography.headlineLarge,
//
//                                modifier = Modifier.padding(bottom = 26.dp)
//
//                            )


                                    }
                                )
                                Spacer(modifier = Modifier.width(10.dp))

                                Card(
                                    modifier = Modifier
                                        //.fillMaxSize()
                                        .size(190.dp)
                                        //.fillMaxWidth()
                                        .clip(shape = RectangleShape)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(ROUTE_ABOUT) { inclusive = true }
                                            }
                                        }
                                        .padding(4.dp),

                                    //shape = RoundedCornerShape(100.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    ),

                                    content = {
                                        AsyncImage(
                                            model = "data:image/jpeg;base64,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",
                                            contentDescription = "",
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
//

//
//                                    Image(
//                                        painter = painterResource(id = R.drawable.logo),
//                                        contentDescription = "",
//                                        modifier = Modifier
//                                            .fillMaxSize(),
//                                        contentScale= ContentScale.Crop
//                                    )
//
//                            Text(
//                                color = Color.Black,
//                                textAlign=TextAlign.Center,
//                                text = "Blazers",
//
//                                style = MaterialTheme.typography.headlineLarge,
//
//                                modifier = Modifier.padding(bottom = 26.dp)
//
//                            )


                                    }
                                )
                                Spacer(modifier = Modifier.width(10.dp))

                                Card(
                                    modifier = Modifier
                                        //.fillMaxSize()
                                        //.fillMaxWidth()
                                        .size(190.dp)
                                        .clip(shape = RectangleShape)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(ROUTE_ABOUT) { inclusive = true }
                                            }
                                        }
                                        .padding(4.dp),

                                    // shape = RoundedCornerShape(100.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    ),

                                    content = {

                                        AsyncImage(
                                            model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRnX6sjleICt4tZFzuolv1wVPeFUsBsubgvgA&s",
                                            contentDescription = "",
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
//

//
//                                    Image(
//                                        painter = painterResource(id = R.drawable.logo),
//                                        contentDescription = "",
//                                        modifier = Modifier
//                                            .fillMaxSize(),
//                                        contentScale= ContentScale.Crop
//                                    )

//                            Text(
//                                color = Color.Black,
//                                textAlign=TextAlign.Center,
//                                text = "Jackets",
//
//                                style = MaterialTheme.typography.headlineLarge,
//
//                                modifier = Modifier.padding(bottom = 26.dp)
//
//                            )


                                    }
                                )
                                Spacer(modifier = Modifier.width(10.dp))

                                Card(
                                    modifier = Modifier
                                        //.fillMaxSize()
                                        //.fillMaxWidth()
                                        .size(190.dp)
                                        .clip(shape = RectangleShape)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(ROUTE_ABOUT) { inclusive = true }
                                            }
                                        }
                                        .padding(4.dp),

                                    //shape = RoundedCornerShape(100.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    ),

                                    content = {
                                        AsyncImage(
                                            model = "data:image/jpeg;base64,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",
                                            contentDescription = "",
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
//

//
//                                    Image(
//                                        painter = painterResource(id = R.drawable.logo),
//                                        contentDescription = "",
//                                        modifier = Modifier
//                                            .fillMaxSize(),
//                                        contentScale= ContentScale.Crop
//                                    )
////
//                            Text(
//                                color = Color.Black,
//                                textAlign=TextAlign.Center,
//                                text = "Trousers",
//
//                                style = MaterialTheme.typography.headlineLarge,
//
//                                modifier = Modifier.padding(bottom = 26.dp)
//
//                            )
//


                                    }
                                )
                                Spacer(modifier = Modifier.width(10.dp))

                                Card(
                                    modifier = Modifier
                                        //.fillMaxSize()
                                        //.fillMaxWidth()
                                        .size(190.dp)
                                        .clip(shape = RectangleShape)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(ROUTE_ABOUT) { inclusive = true }
                                            }
                                        }
                                        .padding(4.dp),

                                    // shape = RoundedCornerShape(100.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    ),

                                    content = {

                                        AsyncImage(
                                            model = "data:image/jpeg;base64,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",
                                            contentDescription = "",
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
//
//
//                                    Image(
//                                        painter = painterResource(id = R.drawable.logo),
//                                        contentDescription = "",
//                                        modifier = Modifier
//                                            .fillMaxSize(),
//                                        contentScale= ContentScale.Crop
//                                    )
//
//                            Text(
//                                color = Color.Black,
//                                textAlign=TextAlign.Center,
//                                text = "T-Shirts",
//
//                                style = MaterialTheme.typography.headlineLarge,
//
//                                modifier = Modifier.padding(bottom = 26.dp)
//
//                            )


                                    }
                                )
                                Spacer(modifier = Modifier.width(10.dp))

                                Card(
                                    modifier = Modifier
                                        //.fillMaxSize()
                                        //.fillMaxWidth()
                                        .size(190.dp)
                                        .clip(shape = RectangleShape)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(ROUTE_ABOUT) { inclusive = true }
                                            }
                                        }
                                        .padding(4.dp),

                                    // shape = RoundedCornerShape(100.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    ),

                                    content = {
                                        AsyncImage(
                                            model = "data:image/jpeg;base64,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",
                                            contentDescription = "",
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
//
//
//                                    Image(
//                                        painter = painterResource(id = R.drawable.logo),
//                                        contentDescription = "",
//                                        modifier = Modifier
//                                            .fillMaxSize(),
//                                        contentScale= ContentScale.Crop
//                                    )
////
//                            Text(
//                                color = Color.Black,
//                                textAlign=TextAlign.Center,
//                                text = "Belts",
//
//                                style = MaterialTheme.typography.headlineLarge,
//
//                                modifier = Modifier.padding(bottom = 26.dp)
//
//                            )
//
//

                                    }
                                )
                                Spacer(modifier = Modifier.width(10.dp))

                                Card(
                                    modifier = Modifier
                                        //.fillMaxSize()
                                        //.fillMaxWidth()
                                        .size(190.dp)
                                        .clip(shape = RectangleShape)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(ROUTE_ABOUT) { inclusive = true }
                                            }
                                        }
                                        .padding(4.dp),

                                    //  shape = RoundedCornerShape(100.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    ),

                                    content = {
                                        AsyncImage(
                                            model = "data:image/jpeg;base64,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",
                                            contentDescription = "",
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
//

//
//                                    Image(
//                                        painter = painterResource(id = R.drawable.logo),
//                                        contentDescription = "",
//                                        modifier = Modifier
//                                            .fillMaxSize(),
//                                        contentScale= ContentScale.Crop
//                                    )
////
//                            Text(
//                                color = Color.Black,
//                                textAlign=TextAlign.Center,
//                                text = "Hats",
//
//                                style = MaterialTheme.typography.headlineLarge,
//
//                                modifier = Modifier.padding(bottom = 26.dp)
//
//                            )


                                    }
                                )
                                Spacer(modifier = Modifier.width(10.dp))

                                Card(
                                    modifier = Modifier
                                        //.fillMaxSize()
                                        //.fillMaxWidth()
                                        .size(190.dp)
                                        .clip(shape = RectangleShape)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(ROUTE_ABOUT) { inclusive = true }
                                            }
                                        }
                                        .padding(4.dp),

                                    // shape = RoundedCornerShape(100.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    ),

                                    content = {
                                        AsyncImage(
                                            model = "data:image/jpeg;base64,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",
                                            contentDescription = "",
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
//
//
//                                    Image(
//                                        painter = painterResource(id = R.drawable.logo),
//                                        contentDescription = "",
//                                        modifier = Modifier
//                                            .fillMaxSize(),
//                                        contentScale= ContentScale.Crop
//                                    )

//                            Text(
//                                color = Color.Black,
//                                textAlign=TextAlign.Center,
//                                text = "Shirts",
//
//                                style = MaterialTheme.typography.headlineLarge,
//
//                                modifier = Modifier.padding(bottom = 26.dp)
//
//                            )


                                    }
                                )
                                Spacer(modifier = Modifier.width(10.dp))


                            }


                        }
                        Spacer(modifier = Modifier.height(10.dp))

                        Row(modifier = Modifier.fillMaxSize()) {

                            Column(modifier = Modifier.padding(10.dp)) {
                                Text(text = "Trending", color = Color.Black)
                            }
                            Spacer(modifier = Modifier.width(270.dp))
                            Column {


                                Icon(
                                    Icons.Rounded.ArrowForward,
                                    contentDescription = stringResource(id = R.string.shopping_cart_content_desc),
                                    modifier = Modifier.size(35.dp)
                                )
                            }
                        }


//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .clickable {
//                        if (isDrawerOpen) {
//                            isDrawerOpen = false
//                        }
//                    }
//            ) {
//
////
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(Color(0xff9AEDC9)),
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//
//
//                    Text(
//                        text = stringResource(id = R.string.developer),
//                        fontSize = 20.sp,
//                    )
//
//                    Spacer(modifier = Modifier.height(15.dp))
//
//
//                    Text(
//                        text = stringResource(id = R.string.call),
//                        fontSize = 20.sp,
//                        modifier = Modifier
//                            .padding(16.dp)
//                            .clickable {
//
//                                val intent = Intent(Intent.ACTION_DIAL)
//                                intent.data = Uri.parse("tel:+254769184414")
//
//                                callLauncher.launch(intent)
//                            }
//                    )
//
//                    Text(
//                        modifier = Modifier
//
//                            .clickable {
//                                navController.navigate(ROUTE_LOGIN) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            },
//                        text = "Login Here",
//                        textAlign = TextAlign.Center,
//                        fontSize = 20.sp,
//                        color = MaterialTheme.colorScheme.onSurface
//                    )
//
//                    Spacer(modifier = Modifier.height(15.dp))
//
//                    Text(
//                        modifier = Modifier
//
//                            .clickable {
//                                navController.navigate(ROUTE_ADD_STUDENTS) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            },
//                        text = "Add Customer",
//                        textAlign = TextAlign.Center,
//                        fontSize = 20.sp,
//                        color = MaterialTheme.colorScheme.onSurface
//                    )
//
//
//
//
//                    Spacer(modifier = Modifier.height(15.dp))
//
//                    Text(
//                        text = "You're welcome",
//                        fontSize = 30.sp,
//                        color = Color.White
//                    )
//
//
//
//                }
//
//            }
                    }}

            }


        },

        bottomBar = { BottomBar(navController = navController) }







    )

    AnimatedDrawer(
        isOpen = isDrawerOpen,
        onClose = { isDrawerOpen = false }
    )
}

@Composable
fun AnimatedDrawer(isOpen: Boolean, onClose: () -> Unit) {
    val drawerWidth = remember { Animatable(if (isOpen) 250f else 0f) }

    LaunchedEffect(isOpen) {
        drawerWidth.animateTo(if (isOpen) 250f else 0f, animationSpec = tween(durationMillis = 300))
    }

    @Composable
    fun SocialMediaIcon() {

    }
    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .width(drawerWidth.value.dp)
            ,
        color=Color.White,
       // color = Color.LightGray,
//        elevation = 16.dp
    ) {






        val mContext = LocalContext.current
       val  navController: NavHostController
        Column {
//            Text(
//                text = "Drawer Item 1"
//
//            )
//            Text(
//                text = "Drawer Item 2"
//            )
//            Text(
//                text = "Drawer Item 3",
//                modifier = Modifier.clickable {  }
//            )




            Spacer(modifier = Modifier.height(16.dp))






            OutlinedButton(
                onClick = {

                    val simToolKitLaunchIntent =
                        mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                    simToolKitLaunchIntent?.let { mContext.startActivity(it) }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp),
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(2.dp, Color.Red)
            ) {
                Icon(imageVector = Icons.Default.Send,"",tint = Color.White)
                Text(text = "Mpesa", color = Color.Black)

            }
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedButton(
                onClick = {

                    val cameraIntent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    if (cameraIntent.resolveActivity(mContext.packageManager)!=null){
                        mContext.startActivity(cameraIntent)
                    }else{
                        println("Camera app is not available")
                    }


                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp),
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(2.dp, Color.Red)
            ) {
                Icon(imageVector = Icons.Default.AddCircle,"",tint = Color.White)
                Text(text = "Camera", color = Color.Black)

            }
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedButton(
                onClick = {

                    val smsIntent=Intent(Intent.ACTION_SENDTO)
                    smsIntent.data="smsto:0769184414".toUri()
                    smsIntent.putExtra("sms_body","Hello Madul,how was your day?")
                    mContext.startActivity(smsIntent)


                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp),
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(2.dp, Color.Red)
            ) {

                Icon(imageVector = Icons.Default.MailOutline,"",tint = Color.Black)
                //Text(text = "Sms", color = Color.Black)

            }
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedButton(
                onClick = {

                    val callIntent=Intent(Intent.ACTION_DIAL)
                    callIntent.data="tel:0769184414".toUri()
                    mContext.startActivity(callIntent)

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp),
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(2.dp, Color.Red)
            ) {

                Icon(imageVector = Icons.Default.Call,"",tint = Color.Black)
                //Text(text = "Call", color = Color.Black)

            }
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedButton(
                onClick = {

                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("maxkuol38@gmail.com"))
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Welcome to the Business email address")
                    mContext.startActivity(shareIntent)



                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp),
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(2.dp, Color.Red)
            ) {

                Icon(imageVector = Icons.Default.Email,"",tint = Color.Black)
                //Text(text = "email", color = Color.Black)

            }
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedButton(
                onClick = {
                    val shareIntent=Intent(Intent.ACTION_SEND)
                    shareIntent.type="text/plain"
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this is a cool content")
                    mContext.startActivity(Intent.createChooser(shareIntent, "Share"))

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp),
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(2.dp, Color.Red)
            ) {

                Icon(imageVector = Icons.Default.Share,"",tint = Color.Black)
                //Text(text = "Share", color = Color.Black)

            }
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = stringResource(id = R.string.developer))



            @Composable
            fun SocialMediaIcons() {
//                Row {
//                    SocialMediaIcon(Icons.Default.Facebook, "https://www.facebook.com/")
//                    SocialMediaIcon(Icons.Default.Twitter, "https://twitter.com/")
//                    SocialMediaIcon(Icons.Default.Instagram, "https://www.instagram.com/")
//                    SocialMediaIcon(Icons.Default.YouTube, "https://www.youtube.com/")
//                }
            }

            @Composable
            fun SocialMediaIcon(icon: ImageVector, url: String) {
                Icon(
                    icon,
                    contentDescription = null, // Pass null if content description is not needed
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            // Handle click by opening the URL in a browser
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                            // startActivity(intent)
                        }
                )
            }



//
//            Text(text = "Already have an account",
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold,
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .fillMaxWidth()
////                    .clickable {navController.navigate(ROUTE_LOGIN) {
////                        popUpTo(ROUTE_HOME) { inclusive = true }
////                    } }
//                    .clickable {  mContext.startActivity(Intent(mContext, ROUTE_LOGIN::class.java)) }
//            )


        }




    }



//            IconButton(onClick = {  }) {
//
//
//                Icon(
//                    Icons.Rounded.Share,
//                    contentDescription = stringResource(id = R.string.shopping_cart_content_desc),
//                    modifier = Modifier.size(35.dp)
//                )
//            }



        }






@Composable
fun BottomBar(navController: NavHostController) {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(
        elevation = 10.dp,
        backgroundColor = Color(0xFF006492)


    ) {

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Home,"", tint = Color.White)
        },
            label = { Text(text = "Home",color =  Color.White) }, selected = (selectedIndex.value == 0), onClick = {

                navController.navigate(ROUTE_HOME) {
                    popUpTo(ROUTE_HOME) { inclusive = true }
                }

            })


//
//        BottomNavigationItem(icon = {
//            Icon(imageVector = Icons.Default.ShoppingCart, "",tint = Color.White)
//        },
//            label = { Text(
//                text = "Products",
//                color =  Color.White) },
//            selected = (selectedIndex.value == 2),
//            onClick = {
//
//                navController.navigate(ROUTE_ABOUT) {
//                    popUpTo(ROUTE_HOME) { inclusive = true }
//                }
//
//            })




        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Search, "",tint = Color.White)
        },
            label = { Text(
                text = "Customer",
                color =  Color.White) },
            selected = (selectedIndex.value == 2),
            onClick = {

                navController.navigate(ROUTE_SEARCH) {
                    popUpTo(ROUTE_HOME) { inclusive = true }
                }

            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.AddCircle, "",tint = Color.White)
        },
            label = { Text(
                text = "Add Prod",
                color =  Color.White) },
            selected = (selectedIndex.value == 2),
            onClick = {

                navController.navigate(ROUTE_ADD_PRODUCT) {
                    popUpTo(ROUTE_HOME) { inclusive = true }
                }

            })


        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.AccountCircle,"",tint = Color.White)
        },
            label = { Text(text = "Login",color =  Color.White) }, selected = (selectedIndex.value == 1), onClick = {
                navController.navigate(ROUTE_LOGIN) {
                    popUpTo(ROUTE_HOME) { inclusive = true }
                }


            })

            }

}


































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

        androidx.compose.material.Text(
            text = "WELCOME TO MADUL GLAMOUR",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()

        )

        Spacer(modifier = Modifier.height(5.dp))

        androidx.compose.material.Text(
            color = Color.Cyan,
            textAlign = TextAlign.Center,
            text = "Home where you meet a taste of your own fashion and passion",

            style = androidx.compose.material.MaterialTheme.typography.h5,

            modifier = Modifier.padding(bottom = 16.dp)

        )


        Spacer(modifier = Modifier.height(5.dp))



        androidx.compose.material.Button(
            onClick = {
                navController.navigate(ROUTE_HOME) {
                    popUpTo(ROUTE_MAIN) { inclusive = true }
                }
            },
            modifier = Modifier
                .fillMaxSize(),
            colors = ButtonDefaults.buttonColors(Color.White)
        ) {
            androidx.compose.material.Text(text = "Get started",)


            Spacer(modifier = Modifier.width(60.dp))


            androidx.compose.material.Icon(
                imageVector = Icons.Default.ArrowForward, "",
                modifier = Modifier
                    .background(Color.Transparent)
                    .size(30.dp),

                )


        }




    }




    LazyRow {
        item {




            Spacer(modifier = Modifier.width(5.dp))

            Card(
                modifier = Modifier

                    .size(190.dp)
                    .clip(shape = RectangleShape)
                    .clickable {
                        navController.navigate(ROUTE_VIEW_PRODUCTS) {
                            popUpTo(ROUTE_HOME) { inclusive = true }
                        }
                    }
                    .padding(4.dp),

                //shape = RoundedCornerShape(100.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                ),

                content = {
//                                    Image(
//                                        painter = painterResource(id = R.drawable.logo),
//                                        contentDescription = "",
//                                        modifier = Modifier
//                                            .fillMaxSize(),
//                                        contentScale= ContentScale.Crop
//                                    )
//

                    ImageSlideshow(imageList = images, modifier = Modifier.size(300.dp)
                        .fillMaxSize(),
                        //contentScale= ContentScale.Crop

                    )

                }
            )
            Spacer(modifier = Modifier.width(10.dp))







     }


    }
}