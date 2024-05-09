package net.ezra.ui.contact


import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_CONTACT
import net.ezra.navigation.ROUTE_HOME
import net.ezra.ui.theme.AppTheme



@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactScreen(navController: NavHostController) {

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
                        Icon(
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
                    .fillMaxSize()
                    .background(Color(0xff53adf2)),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                Text(text = " CONTACT ", color = Color.Black, fontFamily = FontFamily.Cursive, fontWeight = FontWeight.Bold  , fontSize = (25.sp))
                Spacer(modifier = Modifier.height(7.dp))
                Text(text = "Holla us through our Email address (madulboutique@gmail.com)")
                Spacer(modifier = Modifier.height(40.dp))
                Text(text = "Or call our hotline number 071111111112")
                Spacer(modifier = Modifier.height(40.dp))
                Text(text = "Address: 123 Main street,Cityville,State,ZIP code")
                Spacer(modifier = Modifier.height(40.dp))
                Text(text = "Store Hours:Monday-Friday:9:00AM-8:00PM,Saturday: 10:00 AM-6:00PM")
                Spacer(modifier = Modifier.height(80.dp))
                Text(text = "Social Media Handles:")
                Spacer(modifier = Modifier.height(40.dp))
                Text(text = "Twitter: @madulboutique")
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Facebook: @madulboutiqueHQ")
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Instagram: @madulboutique")










            }

        })


}
























@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    ContactScreen(rememberNavController())
}
