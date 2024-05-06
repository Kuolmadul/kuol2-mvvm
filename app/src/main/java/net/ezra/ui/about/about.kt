package net.ezra.ui.about

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_ADD_PRODUCT
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_VIEW_PRODUCTS


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AboutScreen(navController: NavHostController) {



    Scaffold(
//            topBar = {
//                TopAppBar(
//                    title = {
//                        Text(text = "Top App Bar")
//                    },
////                    navigationIcon = {
////                        IconButton(onClick = {}) {
////                            Icon(Icons.Filled.ArrowBack, "backIcon")
////                        }
////                    },
//                   // backgroundColor = MaterialTheme.colors.primary,
//                    //contentColor = Color.White,
//                   // elevation = 10.dp
//                )
//            },
        content = {




//    Box {
//        Image(painter = painterResource(id = R.drawable.g2),
//            contentDescription = "Logo",
//            modifier = Modifier
//                .fillMaxSize(),
//            contentScale= ContentScale.Crop
//        )
//    }



            LazyColumn {




                item {


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
                    IconButton(onClick = { navController.navigate(ROUTE_ADD_PRODUCT) {
                    popUpTo(ROUTE_ABOUT) { inclusive = true }
                         }}) {
Text(text = "View Products")
                                 }


                        Icon(
                            Icons.Rounded.Menu,
                            contentDescription = stringResource(id = R.string.shopping_cart_content_desc),
                            modifier = Modifier.size(35.dp),

                            )


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







                    Row(modifier=Modifier.fillMaxSize()) {

                        Column (modifier=Modifier.padding(10.dp)){
                            Text(text = "Popular",color= Color.Black)
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

                    Spacer(modifier = Modifier.height(20.dp))









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

                                        AsyncImage(model = "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD" +
                                                "/2wCEAAkGBxMSEhUTExMVFRUXGBcaGBgYGB0aFxgbGBcdGh8YFRgeHSggGBolHRoYIjEh" +
                                                "JSkrLi4uHSAzODMtNygtLisBCgoKDg0OGhAQFy0lHR8rLS0tLS0tLS0tLS0tLS0tLSstLS" +
                                                "0tLS0tLS0tLS0rLS0tLS0tLS0tLS0rLS0tLS0tN//AABEIANQA7gMBIgACEQEDEQH/xAAcAAABBQEBAQAA" +
                                                "AAAAAAAAAAAGAgMEBQcBAAj/xAA+EAABAgQEAwYFAgUDAwUAAAABAhEAAyExBAUSQVFhcQYTIjKBkUKh" +
                                                "scHwUtEHFGJy4RUjgpLS8RYkM7LC/8QAGQEAAgMBAAAAAAAAAAAAAAAAAQMAAgQF/8QAIhEAAgICAwEBAAMBA" +
                                                "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" +
                                                "jkeiwTyrxxS3ePR6IQXItHBc+n0Mcj0QCHRc/m0eT5h+bR6PRUIhfm/O" +
                                                "MNi4/Pij0egoI5LPlhKzb83j0eggP/Z", contentDescription = "",
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )

                                        Text(
                                            color = Color.Black,
                                            textAlign=TextAlign.Center,
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

                                    AsyncImage(model = "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxISEhUQEBIWFRUVFRUVFRUXFRUVFRUVFxUXFhUWFhUYHSggGBolGxUVJTEhJSkrLi4uGB8zODMtNygtLisBCgoKDQ0NFQ8NDysZFRkrKy0tLSsrLSs3LSsrKystNysrKysrLS0rLSstLTcrKysrKysrKysrKysrKysrKysrK//AABEIAOEA4QMBIgACEQEDEQH/xAAcAAABBAMBAAAAAAAAAAAAAAAAAQIDBwQFBgj/xABHEAABAwEEBgcEBQsDBAMAAAABAAIRAwQSITEFQVFhcZEGBxMigaHwMlKxwRQjQnKSCFNiY3OCorLR4fEzQ7MVNKPCJCVk/8QAFgEBAQEAAAAAAAAAAAAAAAAAAAEC/8QAFxEBAQEBAAAAAAAAAAAAAAAAAAExEf/aAAwDAQACEQMRAD8A4fsW+63kEooM9xvIKWE4BVEXYN9xvIJOwZ7reQU6RVEPYN91vIJRQb7reQUsIAUEfYN91vII7Bvut/CFNCIVEPYN91vIJewZ7rfwhSwiEEPYM9xvII7BnuN/CFPCQhBA+kwCS1oA1kBa6tpSztwDQ7g0Aeag6T1TLGjLEnjq+a0YA1rNqt4NM0vzQ/h/os+x2mjUwaBOwtAP91yl1S2R91wdMQQZTo7DsG+638IR2Dfdb+EKZItIh7Bvut/CEdg33W8gpkkIIexb7reQR2DfdbyClIQUEXYN91vIJvYt91vIKZIUDGsAyAHDBOhLCSEAhCEAhCED04ITgooSQnQkhUIlCIShEACEIRQhKiECQhKs636NqUbFVtbxcltylOBJfgX7gATB3yoOB0jpA1H3gBAkAZgtB1rBqObm3Dd/Q61kaLuis0VAC0ugg4DEEfGFFbLgcbkgYi6cbpBynWFFRhzYMzOECMN8mcOSYXppGtIg7jQ9V1Sg2q4aywu1FzY84IMb1lrc9TOjqdro2qx1JF5tKo10iWPBcA5o8TxCl0/0UtNlJL2F9PVUYCW/vDNvjzVRoEJySFUNKaQnlIgbCROSFA2EsJUIEQlQgRCWEIHpQkTgVFKkTkkIEQlQgEJV0OgeilS0MFZxuUycDEudGZA1DDNUc8tpo3QFetiG3W+87AeAzK73RvRuhSxDAT7zu87mcvBbXsgBeIwGQQc1ojo1SokFw7R+BlwwHBurxnJanrotV2zMYNbgeULtWMmHe9j/AECrrrjcSxmyTjyWaqpLU3FQKdxkOcduChAQCRokwgp9BsuHEfFBYnU1pI09IU6YMCpepkajDb7eJ7h5r0k5gPivJvQhzhpGyOaDeNpZGoRexwjYTzXrVplByGnehtlrkksuPP2qcNJ4jI8lw+ler+0Mk0XNqjZ7D+RwPNW/XbgCoDTlaFAWvR1an/qUnsj3mkDnksRehatjvAgj+hVb9aehW0n0bTTbAqtLakCBfbBBw1kE/hRHApqekRDUJUQgRCVKqGoTkKByUJqcFGjkhTk0qoEIShQZFgsjq1VlFntPcGjdJz4ASfBXXZLG2nTZTZ7LAGjgGxiq/wCrCwh9ofWP+0zD778Afwh/NWQdaKxzTUVoqBolxgBZJCwtK0b1N3CeSCd1jjvHCdQ+e9cp0+0F9JstRo9oAubxC7SzVL9Jj9rQfGMUMoB3dOvBB5CoxiDr+Ky7JfpOFVkGJbqcAXNIxB3E8lFbLPde9vuuc3k4j5Is1ocDvyGsEe6RrB2KBjqZe93ZsMYuuiTdbnnsG0paTCCNUYkkHDZKno2nB1O7/qEAxsDg4YmTmBhsUlwDLjJx3XvZyGRHBB0HVvSnSdk/aOPKm8xxwXqeiMF5i6rqE6Ts2BwNQndFJ2GWePmvT7RgghcNaQNUlLIpCI4fBUPY1aLpZov6TYn0olwph7P2jRebHHLxW+CjOSDzWU0rbdKNHfR7VWoxgHkt+47vN8iOS1JVZIhEIQCJSSlQKhIhA5OCZKcFFOQiUiASpEqC0+rKzXbI+prqVTyYAB53l0NeoYJGfz1LF6JWfs7BQbETTvni8l/zUlrnMZ/FFTMrB2LcphK7ELU6PtAvEeMawQMj4fBZDrb3C6NZAQZ2hh9Vc9xzm+cjyKy6WDhxWFoM+2D9q6/mIPwWcRiEHlTT1MttVobOVeuP/K4eeS1Vanr9YZ8l0vTajc0hbG//AKax/E4nzmFz9UYetQ4alAliEku/wJ24LIaMjhqO7jlkNajoYM1Y488gccsD6Kc05eHD/G1B3nUpSvaUZh7NGqeHsDHDf5r0e7ALz11DMnSbt1lq/wDJSXoSogSmO6ljanAYLGrEDaUDXVYNw7M/W5HaeeXDWVi3pdGs5BTizuOeG3cNgWhWnW1o+H0rR74dTP7veb8XKvSrT63XtbRo0gJ+sLp92GxHjPkqrciCEJEIhUJEKhUJEKB0pwKjlOBUU9JCSUkohyytG2TtqtOiDF97WzskwSsOVuOiLWm2WcPMDtW/i+z/ABXUVd3YNDQ1kQAANwAgBa+2OaMBLuA+azalnvZuK19ra1uAnwxRXJaUtnZP7UDLPHNusFbqlFRlO7i0kmd0A/NaLpRTa5hDhEgg8Csrq+e42QXjJFRzfANYMEHU6OMVY2tI5Qtk8ZLStqXXsdscAfHD5re1UHmjrMpxpW2AfnZ8XU2EjLMzguUqxH9tWUzGo57V1vWpB0ta/vs2fmqeX6XyXJ1CIyG3VE6zllq4qCZtWaTWwIGO/YJxynkmMO/Lf4YY4k6wks9UBsYgeO2Jw5eKW8Nka8zhie9nqyQWp+T82bdXOsWeOdQYAziO6FfDs1RH5O+NrtR2UWDh3yr3GaBz3ALErWkYgZhS1HA4LS6QqBkyYkhs73G781YJKdVpJvgZ4YXpG0FuLVlstAPdBqAbSx5PAGFjWSsG4Fo4twPitgXFwAbhOvWAqOA60LDNna+njcqXnzgQ0giYOOZHNVYVfHTWw37DaGNGNy9vNwh5x/dVDlEIhEoRAiUShAShCRAicExOBUU9JKRIiHBbPo02bXZx+upHk8E/BapdV1aibfT7t6G1D93uHvfLxRVtWm0YwwSduQ5rWWq0OyIj7uK2lpfiQtJanDXM8lYrkOmbvq+7kTBO7eszq5qB1GpT1tfPg4D5tK13TSoQ2BlhI8Vreh2lOwqu/TAHiDh8VBZrrIYPDBbmzVL9NrtoH91qKFdxEuGYwWboN8sc33XEeBxHzQed+tYxpa14fapn/wAFPHPUuSeRGI5EbMP7rrutuf8Aq9qw10v+GnHzXJavWvxyKgKTBGw4cMRieCa4EDPf4xv81PSGA4DXtH3sic9kKK0esf769aC2fybx9fbD+qpebnf0V7SqP/JsZ37a79GgPOoruqFBi2ly4PrQtl2jTa0w51W9h+gCZ5lq7uo4wQqr60n/AF1Fs5U3GNkuz8vJaR3uh7V2lGnUcIL2NdtxLQTIW3oEjI+OoLn+jOkKNak3sXYAAd4ERAEz5LoKFNwGDmuCKW0NDmuDz3brr2yIM+S85PjVlq4L0lUp3gWu1gggbCIMrzrpOymlVqUjmx7m5RkSAeSJWNKREJUQkolCEAhJCEDJSgpkpwKyp8pJSSklUOBVn9UNBoZXquaPaa1j4F7AS5oOcYskZZKrwVdXV1ZS3R9KR7Ze88C8geQCEbm2uE4zG1aivVblenc5vwK21oLW61rq7DtlVXB9NLU2OzDXSYh2F2BjmCcVoej1K/aaTdrvgCfksjpZbL1dzADDDB3nWeCh6LPi10P2jRzw+aiLhothnJP0b3Kzm6nt8x/aUgMujU3zOv5eaYH95jhm145HAoqgut0n/q9qxmDTGuP9Fkj5rkC6RjhniNuvDeup6z3XtLWwz/vROGpjR5RiuYjDPf5xOec4cFAMBjd5CRrM4A69iiqHD15Y8/BTtyjhhvzjPXmser69b0F1/k3Mwtjt9EeT1clSpjCp/wDJwH1VsP6VIfwu/qrauqwR1jGSp3rEtF62vHuNYzh3bxHNyuGq+BJ8FRPSOvftVd+2q/ycR8lUWL0Rs4FJjaZA7odhF6SASeOK6uy1niW1S5p1PDZDhvwwVd9AKLqlNxnFjoG27GY8Z5Lu7E6pIBe4Df3v7hBtmUwcb7ncDAVL9ZdJ4t1RzmXWuDLhGTmhobeHiCrnFHe5x4x8FXPXHlZw4C9NS6ZJ7vdvTI23eZQqs0ISIhUShCBZSIQgiShRpwKyp8pJSJJQOlX9oukWWWz0WmA2jTnUfYGSoGkJIG0gc16JtDYAbsAHIQqMKrYWkHOdsrXtpwCHArZlhGIPgse1v7pI2FVVR9Ko+lVI1XZ43QsnoRZHVbZSujBh7Rx1AN/uQtJbKxfUe843nuPMlWJ1ZWZrKD6326ryxu5rBJPMnkFEdi9sYc+JxK1Ol9Kmz9iGtDnVqzKQmYAdMuw3DmQtpXtGa0fSK1NpWataXtB7JhcwET9ZEU42G8RzUVQXSC19ra7RU9+vVcN4LzAzyj4Ba9xMec8Rn4plzfj8de1KSYy8to4ZnVsgoHGYiN0ecZeKgqn165qdzMPEiIyAxxMZg5/JY9X16hBdf5OjyWWumD9qk7mHD5K46uCob8ni3Btrr0Sf9SiHDf2bsf516AaQVRgXScwvP2knHtqsmT2j543yvRVrqCCBnC866WcDXqluRqVI4Xyqldn1c6QAimB3muMmfsu9FWfTKo/oZXu2kCYvtc3xwcP5Srl0dUlo2oRs2tVa9dDf+1d+1H/GVZTSq865Kc0aD9QqOb+Jk/8AqhVVykQkRCyiUShAShCEGOnBRpwWWj0iaiURsdA0r9poMGN6tTH8YV/Wt2Ko3oM2dIWYH86DyBPyV31sThnvyVgxwdTlqelVU07LWe0wbhjcYhbhzea5LrHttyzFmuobo4TJ8laKtV09HLB2Fko0yO+GS7aC83iPOPBVd0P0d9ItdNhEtae0f91mMeJgeKui7JWVYopSq267dMhjKVgYcXEVake60wweLpP7itSs8MaSTECSdQC8xdK9Mm12utaDiHvIZ+zb3WDkMeKDWsf6x24TngD8Ujsjw8Rr5ymh3rw9Qkc7A+vnr18EGSQPUeE79qxq7PXrXtUpdjn55yJ26xmkeNZ548/kd6De9WOk/o2k7NUJhpeabvu1AW4+JB8F6kLoyXjenULHhwzaQRuIMr1v0bt30iyUa8yX02k8Yg+asGZWpy9rwYiZG0ERB8VQGmm3bRWbsq1B/GV6AeYCoTpK2LXaB+uqebiVUqPQlW7aKLv1jfMwfirs0S/AKhqb4IcNRB5GVdnR21CrSbUZk4Ajx1cUI6kBcT1t05sQOd2sw8w4fNdnSfIHorlOtNw/6e/e+mAd98HDzUVSkolIkVZOlIkSoFQmoQY8pQVHKUFZaSSiUyUiI6PoEf8A7CzftD/I5XdaI9pUd0AfGkLMT75HNjh81d9Xf4DarFMDpVadalaa1Fs5MeeZAHwKslrs5wVRdY1YutpByaxgbwxJ8yUo6HqosPdrViMy2mDuHed8W8lYriGjeuZ6vrP2VhpTm+88/vEx5Qt8504nJQcN1t6e+j2M0Wn6y0EsA13ImoeUDi8KhvWz0F1XWJ0g+l2yo5pmnT+rp7CGnvO4F047A1cwHbPWzBAz163pHlSRw3RzH+UlQYesswR54oJHHHPXt3g+EnHimu2+fxOXMbVMx+A4YxgNpgYDYI3Icz1v1atqDDqBeguozS/a2E0ScaL4jY12I9b1Qddmz1/k6l3nUjpnsLaaLjDazbu69OHnCD0FXOEKiumIi3WgfrXfJXrUVF9N/wDvrR98fytWkaRXT0RcBZaN0QDTYfLHzVKEq4+hrosNBzjHdI8A4gFCOsssc1zHWuf/AIJw/wByn4CTjzhdRY2SJBHHNaLrJaRo6vgCe54DtGyUFGIlJKREOlEpqFAqEkIQYcpQUyUSo0klEpkolB0nV/TvaQswOp5P4WOcPMBXdUAnHNUF0Y0y2x2hlqewvFMP7oIaSSwtmThrXbDrisp9qz2gcOyP/sFYLFqNBbJVKdNqt611McoHzjzXS2vrfsVzu0a5MYSKYHO8uFttuFasazhAc4EjMgYSOQSi8tCUrtCkz3abByaFzXWp0i+iWU0qboq1pY2Mw37bt0A8yF0tgttM0u0a4Fl28HSIuxmvP/T/AE6bba31QZpt7lPZdGZ8TjwhQc7I1bvXwKHO9fHHjjO9RhxCW8PXwQPn161Tq3p5EgjhPEnCYzOY3SomY+vXoKR2Xgf7xnr1oHWc931qOE7MTnuT3DePHxEnP0QobLrHrZlrCnPqco1Z54AaskEcnh8o5Ygc5UmjLWaFenVGF1wOHnCZGz15DHXyUVVsj1v3+PEoPW1jtba1NlRpkPY1wjeAfmqO6Wvm2Wg/rHfJdl1S6c7ewCmXd+gTTO27mw8pHguH6SvDrVXI/OO8sD8FpGulXT0CrNfYaLSMmkcjHyVKJbTpK0taOytVWkGCGtY4tGJ3QoPSlkZAWs6e0S/R9pABnsy78JDj8F50Z0g0rcqVWWq0mnTcA5/aVIkmAJlZOjekdsqsJqWuu7EiDWqREDAicRxRSpJTJReRD5QmSiUQ9CZKEGFKUFMRKjR8oTJRKBajZBG31rUdv0SGUBWv55NOIIvlueZOBUkrB0lbJp9kSZbUJA1Bpbq8SeaBxsINKlWvS2o99Nw+01zYIBO8ELaArQ2a23aT6RBMvp1GGcGubIMje1x5BbsFBqK9tqi/S7SoGFziad91wknO7ksUEqfSDYqO3wRyUOIzViEKjcFNO5MIQRAkLJe8CI7xLe9I1kZADUFA4LKpVGGndc5zXAy0gAtOGIdkQd4nhrWaqFr4diIIwMYZZnipBaJywz3DHhlkExzWgAiScZwgDZG3WolRO9rjs8Muamst8OnDXrGtYtJ8YLOptcch5Ko3PRHSVpsFY1qbWua9pa9k4EHIwNYKyKlQuJcTJJJJ2k4lauzWVwIJx+QWwKqFla3S9YgADY48oA/mWwK03SDNn73yUV0mjtJdtoWvZGD6yhUbVcBiX0XPBc6M+6YncAtDoI9x33vkFr7BaH0HipBhzXNOJF5j2lrhI3H4LM0GfbAyw+YRW2RKalRCyiU2UKodKEiRQYMolNlEqNHJU2UkoHrVaRpkOvaj8VswVFaqN9sa9SDVtpExAPeMCBm7YN+I5rd2OoS0XhByWnDbpMkhzSC08D/hbOxvmXEy5xvOyzMzMAQdyDH0s3vNO0Ry/wArHY4bSsvStIm67ZgfFYdMDWUSlcRvUboUpaFGTuVQxRqVKz2H7i2PNRTabtSkuxqBCgaFNTeclRPRu7Ph81O2sRlPkoA3WpW1Br85RGRSqSZcIG2YWzLta1LC07Rs1hbGkIEKiSVqdNMvOpjbe4altVDajDScJAJE6jCitNpCrgynHsATxIGCzdCN7hO13wC1tG9UftJzJEjiQt/SYGgNGpFSSiU2USqh0olNlEqB0pUyUqDAQEqFFCRKhAJQhCDB0pmFnWb2RwHwCEIHWr2HcFpqaEIiRqEIVREUN9h/FvzQhFiIKd2aRCgy2Z" +
                                            "JUqFUFlzW0s+XihCpNSqOrkeB+CEKKwdE/a8PiVnpUIGoCEKoChqVCgVCEIP/Z", contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxSize(),
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

                                    AsyncImage(model = "data:image/jpeg;base64,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" , contentDescription = "",
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
                                    AsyncImage(model = "" , contentDescription = "",
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

                                    AsyncImage(model = "" , contentDescription = "",
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
                                    AsyncImage(model = "" , contentDescription = "",
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
                                    AsyncImage(model = "" , contentDescription = "",
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
                                    AsyncImage(model = "" , contentDescription = "",
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

                    Row(modifier=Modifier.fillMaxSize()) {

                        Column (modifier=Modifier.padding(10.dp)){
                            Text(text = "Recent",color= Color.Black)
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



                    LazyRow(modifier=Modifier,
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

                                    AsyncImage(model = "" , contentDescription = "",
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

                                    AsyncImage(model = "" , contentDescription = "",
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
                                    AsyncImage(model = "" , contentDescription = "",
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
                                    AsyncImage(model = "" , contentDescription = "",
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
                                    AsyncImage(model = "" , contentDescription = "",
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
                                    AsyncImage(model = "" , contentDescription = "",
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
                                    AsyncImage(model = "" , contentDescription = "",
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
                                    AsyncImage(model = "" , contentDescription = "",
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

                    Row(modifier=Modifier.fillMaxSize()) {

                        Column (modifier=Modifier.padding(10.dp)){
                            Text(text = "New",color= Color.Black)
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

                                    AsyncImage(model = "" , contentDescription = "",
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
                                    AsyncImage(model = "" , contentDescription = "",
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

                                    AsyncImage(model = "" , contentDescription = "",
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
                                    AsyncImage(model = "" , contentDescription = "",
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

                                    AsyncImage(model = "" , contentDescription = "",
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
                                    AsyncImage(model = "" , contentDescription = "",
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
                                    AsyncImage(model = "" , contentDescription = "",
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
                                    AsyncImage(model = "" , contentDescription = "",
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

                    Row(modifier=Modifier.fillMaxSize()) {

                        Column (modifier=Modifier.padding(10.dp)){
                            Text(text = "Trending",color= Color.Black)
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









                }




//Spacer(modifier = Modifier.height(20.dp))
















//
//        item {
//
//
//
//
//
//                Column(modifier=Modifier
//                    .fillMaxSize()
//
//
//                ) {
//
//
//                    Card(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            //.fillMaxWidth()
//                            .clickable {
//                                navController.navigate(ROUTE_PRODUCTS) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            }
//                            .padding(16.dp),
//
//                        shape = RoundedCornerShape(16.dp),
//                        colors = CardDefaults.cardColors(
//                            containerColor = MaterialTheme.colorScheme.primaryContainer,
//                        ),
//
//                        content = {
//
//                            Column (modifier=Modifier,
//                                horizontalAlignment = Alignment.CenterHorizontally){
//
//
//                            Image(
//                                painter = painterResource(id = R.drawable.flannel),
//                                contentDescription = "",
//                                modifier = Modifier
//                                    .fillMaxSize(),
//                                contentScale= ContentScale.Crop
//                            )
//
//                            Column (modifier=Modifier,
//                            horizontalAlignment = Alignment.CenterHorizontally
//                            ) {
//
//                                Text(
//                                    color = Color.Black,
//                                    textAlign = TextAlign.Center,
//                                    text = "Flannels",
//
//                                    style = MaterialTheme.typography.headlineLarge,
//
//                                    modifier = Modifier.padding(bottom = 26.dp)
//
//                                )
//
//                            }
//
//                            }
//
//
//                        }
//                    )
//                    Spacer(modifier = Modifier.height(3.dp))
//
//
//                    Card(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            //.fillMaxWidth()
//                            .clickable {
//                                navController.navigate(ROUTE_PRODUCTS) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            }
//                            .padding(16.dp),
//
//                        shape = RoundedCornerShape(16.dp),
//                        colors = CardDefaults.cardColors(
//                            containerColor = MaterialTheme.colorScheme.primaryContainer,
//                        ),
//
//                        content = {
//
//                            Column (modifier=Modifier,
//                                horizontalAlignment = Alignment.CenterHorizontally) {
//
//
//                                Image(
//                                    painter = painterResource(id = R.drawable.blazer3),
//                                    contentDescription = "",
//                                    modifier = Modifier
//                                        .fillMaxSize(),
//                                    contentScale = ContentScale.Crop
//                                )
//
//                                Text(
//                                    color = Color.Black,
//                                    textAlign = TextAlign.Center,
//                                    text = "Blazers",
//
//                                    style = MaterialTheme.typography.headlineLarge,
//
//                                    modifier = Modifier.padding(bottom = 26.dp)
//
//                                )
//                            }
//
//
//                        }
//                    )
//
//
//
//
//                    Spacer(modifier = Modifier.height(10.dp))
//
//
//
//                    Card(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            //.fillMaxWidth()
//                            .clickable {
//                                navController.navigate(ROUTE_PRODUCTS) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            }
//                            .padding(16.dp),
//
//                        shape = RoundedCornerShape(16.dp),
//                        colors = CardDefaults.cardColors(
//                            containerColor = MaterialTheme.colorScheme.primaryContainer,
//                        ),
//
//                        content = {
//
//
//                            Column (modifier=Modifier,
//                                horizontalAlignment = Alignment.CenterHorizontally) {
//
//
//                                Image(
//                                    painter = painterResource(id = R.drawable.jacket1),
//                                    contentDescription = "",
//                                    modifier = Modifier
//                                        .fillMaxSize(),
//                                    contentScale = ContentScale.Crop
//                                )
//
//                                Text(
//                                    color = Color.Black,
//                                    textAlign = TextAlign.Center,
//                                    text = "Jackets",
//
//                                    style = MaterialTheme.typography.headlineLarge,
//
//                                    modifier = Modifier.padding(bottom = 26.dp)
//
//                                )
//                            }
//
//
//                        }
//                    )
//
//
//
//
//                    Spacer(modifier = Modifier.height(10.dp))
//
//
//
//                    Card(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            //.fillMaxWidth()
//                            .clickable {
//                                navController.navigate(ROUTE_PRODUCTS) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            }
//                            .padding(16.dp),
//
//                        shape = RoundedCornerShape(16.dp),
//                        colors = CardDefaults.cardColors(
//                            containerColor = MaterialTheme.colorScheme.primaryContainer,
//                        ),
//
//                        content = {
//
//
//                            Column (modifier=Modifier,
//                                horizontalAlignment = Alignment.CenterHorizontally) {
//
//
//                                Image(
//                                    painter = painterResource(id = R.drawable.trouser2),
//                                    contentDescription = "",
//                                    modifier = Modifier
//                                        .fillMaxSize(),
//                                    contentScale = ContentScale.Crop
//                                )
//
//                                Text(
//                                    color = Color.Black,
//                                    textAlign = TextAlign.Center,
//                                    text = "Trousers",
//
//                                    style = MaterialTheme.typography.headlineLarge,
//
//                                    modifier = Modifier.padding(bottom = 26.dp)
//
//                                )
//
//                            }
//
//                        }
//                    )
//
//
//
//                    Spacer(modifier = Modifier.height(10.dp))
//
//
//
//                    Card(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            //.fillMaxWidth()
//                            .clickable {
//                                navController.navigate(ROUTE_PRODUCTS) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            }
//                            .padding(16.dp),
//
//                        shape = RoundedCornerShape(16.dp),
//                        colors = CardDefaults.cardColors(
//                            containerColor = MaterialTheme.colorScheme.primaryContainer,
//                        ),
//
//                        content = {
//
//
//                            Column (modifier=Modifier,
//                                horizontalAlignment = Alignment.CenterHorizontally) {
//
//
//                                Image(
//                                    painter = painterResource(id = R.drawable.tshirt2),
//                                    contentDescription = "",
//                                    modifier = Modifier
//                                        .fillMaxSize(),
//                                    contentScale = ContentScale.Crop
//                                )
//
//                                Text(
//                                    color = Color.Black,
//                                    textAlign = TextAlign.Center,
//                                    text = "T-Shirts",
//
//                                    style = MaterialTheme.typography.headlineLarge,
//
//                                    modifier = Modifier.padding(bottom = 26.dp)
//
//                                )
//                            }
//
//
//                        }
//                    )
//
//
//
//
//                    Spacer(modifier = Modifier.height(10.dp))
//
//
//
//                    Card(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            //.fillMaxWidth()
//                            .clickable {
//                                navController.navigate(ROUTE_PRODUCTS) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            }
//                            .padding(16.dp),
//
//                        shape = RoundedCornerShape(16.dp),
//                        colors = CardDefaults.cardColors(
//                            containerColor = MaterialTheme.colorScheme.primaryContainer,
//                        ),
//
//                        content = {
//
//
//                            Column (modifier=Modifier,
//                                horizontalAlignment = Alignment.CenterHorizontally) {
//
//
//                                Image(
//                                    painter = painterResource(id = R.drawable.belts),
//                                    contentDescription = "",
//                                    modifier = Modifier
//                                        .fillMaxSize(),
//                                    contentScale = ContentScale.Crop
//                                )
//
//                                Text(
//                                    color = Color.Black,
//                                    textAlign = TextAlign.Center,
//                                    text = "Belts",
//
//                                    style = MaterialTheme.typography.headlineLarge,
//
//                                    modifier = Modifier.padding(bottom = 26.dp)
//
//                                )
//                            }
//
//
//                        }
//                    )
//
//
//                    Spacer(modifier = Modifier.height(10.dp))
//
//
//
//                    Card(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            //.fillMaxWidth()
//                            .clickable {
//                                navController.navigate(ROUTE_PRODUCTS) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            }
//                            .padding(16.dp),
//
//                        shape = RoundedCornerShape(16.dp),
//                        colors = CardDefaults.cardColors(
//                            containerColor = MaterialTheme.colorScheme.primaryContainer,
//                        ),
//
//                        content = {
//
//
//                            Column (modifier=Modifier,
//                                horizontalAlignment = Alignment.CenterHorizontally) {
//
//
//                                Image(
//                                    painter = painterResource(id = R.drawable.hats),
//                                    contentDescription = "",
//                                    modifier = Modifier
//                                        .fillMaxSize(),
//                                    contentScale = ContentScale.Crop
//                                )
//
//                                Text(
//                                    color = Color.Black,
//                                    textAlign = TextAlign.Center,
//                                    text = "Hats",
//
//                                    style = MaterialTheme.typography.headlineLarge,
//
//                                    modifier = Modifier.padding(bottom = 26.dp)
//
//                                )
//
//                            }
//
//                        }
//                    )
//
//
//                    Spacer(modifier = Modifier.height(10.dp))
//
//
//
//                    Card(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            //.fillMaxWidth()
//                            .clickable {
//                                navController.navigate(ROUTE_PRODUCTS) {
//                                    popUpTo(ROUTE_HOME) { inclusive = true }
//                                }
//                            }
//                            .padding(16.dp),
//
//                        shape = RoundedCornerShape(16.dp),
//                        colors = CardDefaults.cardColors(
//                            containerColor = MaterialTheme.colorScheme.primaryContainer,
//                        ),
//
//                        content = {
//
//
//                            Column (modifier=Modifier,
//                                horizontalAlignment = Alignment.CenterHorizontally) {
//
//
//                                Image(
//                                    painter = painterResource(id = R.drawable.f3),
//                                    contentDescription = "",
//                                    modifier = Modifier
//                                        .fillMaxSize(),
//                                    contentScale = ContentScale.Crop
//                                )
//
//                                Text(
//                                    color = Color.Black,
//                                    textAlign = TextAlign.Center,
//                                    text = "Shirts",
//
//                                    style = MaterialTheme.typography.headlineLarge,
//
//                                    modifier = Modifier.padding(bottom = 26.dp)
//
//                                )
//                            }
//
//
//                        }
//                    )
//
//
//
//
//
//
//
//
//
//
//
//                }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//        }
            }






        },
        bottomBar = { net.ezra.ui.home.BottomBar(navController) }
    )














//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .wrapContentHeight()
//            .padding(10.dp)
//            .padding(top = 10.dp)
//
//    ){
//        Text(
//            modifier = Modifier
//                .clickable {
//                    navController.navigate(ROUTE_HOME) {
//                        popUpTo(ROUTE_PRODUCTS) { inclusive = true }
//                    }
//                },
//            text = "Go home", color = Color(0xff23D342)
//        )
//
//        Image(
//            painter = painterResource(id = R.drawable.logo),
//            contentDescription =null,
//
//            colorFilter = ColorFilter.tint(Color.Green)
//
//        )
//
//
//
//
//    }












}





@Composable
fun BottomBar(navController: NavHostController) {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(elevation = 10.dp, backgroundColor = Color.Transparent) {
        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Home,"",

                modifier= Modifier
                    .background(Color.Transparent)
                    .shadow(10.dp)
                    .size(30.dp)
                    .clip(RoundedCornerShape(30.dp))
            )
        },
            label = { Text(text = "Home", color = Color.White) }, selected = (selectedIndex.value == 0), onClick = {

                navController.navigate(ROUTE_HOME) {
                    popUpTo(ROUTE_ABOUT) { inclusive = true }
                }
            })



        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Favorite,"",

                modifier= Modifier
                    .background(Color.Transparent)
                    .size(30.dp)
            )
        },
            label = { Text(text = "Favorite", color = Color.White) }, selected = (selectedIndex.value == 1), onClick = {
                navController.navigate(ROUTE_HOME) {
                    popUpTo(ROUTE_ABOUT) { inclusive = true }
                }

            })



        BottomNavigationItem(icon = {



            Icon(imageVector = Icons.Default.ShoppingCart, "",

                modifier= Modifier
                    .background(Color.Transparent)
                    .clip(RoundedCornerShape(50.dp))
                    .size(30.dp)
            )
        },
            label = { Text(text = "Cart", color = Color.White) }, selected = (selectedIndex.value == 2), onClick = {
                navController.navigate(ROUTE_HOME) {
                    popUpTo(ROUTE_ABOUT) { inclusive = true }
                }
            })






        BottomNavigationItem(icon = {
//            Icon(
//                imageVector = Icons.Filled.AccountCircle,
//                contentDescription = "Account Icon"
//            )


            Icon(imageVector = Icons.Default.Person, "",

                modifier= Modifier
                    .background(Color.Transparent)
                    .size(30.dp)

            )
        },
            label = { Text(text = "Profile", color = Color.White) }, selected = (selectedIndex.value == 2), onClick = {
                navController.navigate(ROUTE_LOGIN) {
                    popUpTo(ROUTE_HOME) { inclusive = true }
                }
            }
        )















    }
}












//
//    Column {
//        Text(text = "about")
//
//        Text(text = stringResource(id = R.string.apen))
//
//        Text(
//            modifier = Modifier
//
//                .clickable {
//                    navController.navigate(ROUTE_HOME) {
//                        popUpTo(ROUTE_ABOUT) { inclusive = true }
//                    }
//                },
//            text = "Home",
//            textAlign = TextAlign.Center,
//            color = MaterialTheme.colorScheme.onSurface
//        )
//    }



@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    AboutScreen(rememberNavController())
}

