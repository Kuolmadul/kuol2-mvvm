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
                        Image(painter = painterResource(id = R.drawable.g2), contentDescription = "",
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


                                        Image(
                                            painter = painterResource(id = R.drawable.logo),
                                            contentDescription = "",
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
                                    Image(
                                        painter = painterResource(id = R.drawable.logo),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale= ContentScale.Crop
                                    )
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
                                    Image(
                                        painter = painterResource(id = R.drawable.logo),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale= ContentScale.Crop
                                    )

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
                                    Image(
                                        painter = painterResource(id = R.drawable.logo),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale= ContentScale.Crop
                                    )
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
                                    Image(
                                        painter = painterResource(id = R.drawable.logo),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale= ContentScale.Crop
                                    )
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
                                    Image(
                                        painter = painterResource(id = R.drawable.logo),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale= ContentScale.Crop
                                    )
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
                                    Image(
                                        painter = painterResource(id = R.drawable.logo),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale= ContentScale.Crop
                                    )
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
                                    Image(
                                        painter = painterResource(id = R.drawable.logo),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale= ContentScale.Crop
                                    )

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

                                    Image(
                                        painter = painterResource(id = R.drawable.logo),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale= ContentScale.Crop
                                    )
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
                                    Image(
                                        painter = painterResource(id = R.drawable.logo),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale= ContentScale.Crop
                                    )
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
                                    Image(
                                        painter = painterResource(id = R.drawable.logo),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale= ContentScale.Crop
                                    )

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
                                    Image(
                                        painter = painterResource(id = R.drawable.logo),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale= ContentScale.Crop
                                    )
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
                                    Image(
                                        painter = painterResource(id = R.drawable.logo),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale= ContentScale.Crop
                                    )
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
                                    Image(
                                        painter = painterResource(id = R.drawable.logo),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale= ContentScale.Crop
                                    )
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
                                    Image(
                                        painter = painterResource(id = R.drawable.logo),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale= ContentScale.Crop
                                    )
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
                                    Image(
                                        painter = painterResource(id = R.drawable.logo),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale= ContentScale.Crop
                                    )

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

                                    Image(
                                        painter = painterResource(id = R.drawable.logo),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale= ContentScale.Crop
                                    )
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
                                    Image(
                                        painter = painterResource(id = R.drawable.logo),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale= ContentScale.Crop
                                    )
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
                                    Image(
                                        painter = painterResource(id = R.drawable.logo),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale= ContentScale.Crop
                                    )

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
                                    Image(
                                        painter = painterResource(id = R.drawable.logo),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale= ContentScale.Crop
                                    )
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
                                    Image(
                                        painter = painterResource(id = R.drawable.logo),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale= ContentScale.Crop
                                    )
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
                                    Image(
                                        painter = painterResource(id = R.drawable.logo),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale= ContentScale.Crop
                                    )
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
                                    Image(
                                        painter = painterResource(id = R.drawable.logo),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale= ContentScale.Crop
                                    )
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
                                    Image(
                                        painter = painterResource(id = R.drawable.logo),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        contentScale= ContentScale.Crop
                                    )

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

