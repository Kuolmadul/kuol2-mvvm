package net.ezra.ui.contact


import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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



@Composable
fun ContactScreen(navController: NavHostController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ){


        Text(text = "This is the contact screen", color = Color.Black, fontFamily = FontFamily.Cursive, fontWeight = FontWeight.Bold  , fontSize = (25.sp))
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


        Text(
            modifier = Modifier
                .padding(70.dp)

                .clickable {
                    navController.navigate(ROUTE_HOME) {
                        popUpTo(ROUTE_CONTACT) { inclusive = true }
                    }
                },
            text = "Back to homepage", fontFamily = FontFamily.Cursive, fontSize = (20.sp)
        )







    }

}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    ContactScreen(rememberNavController())
}