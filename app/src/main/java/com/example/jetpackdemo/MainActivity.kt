package com.example.jetpackdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackdemo.ui.theme.JetpackDemoTheme
import com.example.jetpackdemo.view.ViewPagerSlider
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyContent()
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MyContent() {
    JetpackDemoTheme {
        // A surface container using the 'background' color from the theme
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            ViewPagerSlider()
            LoginButtons()
        }


    }
}
@Composable
fun LoginButtons(){
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(bottom = 12.dp)
    ) {
        GoogleSignIn()
        Text(
            text = "or",
            style = TextStyle(
                color = colorResource(id = R.color.grey_medium4),
            ),
            modifier = Modifier.padding(top = 10.dp)
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(bottom = 10.dp)
        ) {
            EmailLogin()
            Spacer(modifier = Modifier.width(18.dp))
            FBLogin()
        }
        TermsText()
    }
}

@Composable
fun GoogleSignIn() {
    Button(
        onClick = {/*TODO*/ },
        modifier = Modifier
            .height(48.dp)
            .padding(horizontal = 26.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.adda_blue)),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_group_91),
                contentDescription = "google sign in",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(id = R.string.login_with_google),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center
            )
        }

    }
}

@Composable
fun EmailLogin() {

    OutlinedButton(
        onClick = { /*TODO*/ },
        modifier = Modifier.padding(6.dp),
        shape = RoundedCornerShape(6.dp),
        border = BorderStroke(
            width = 1.dp,
            color = colorResource(id = R.color.grey_medium2)
        )
    )
    {
        Text(
            text = "Email/Mobile",
            style = TextStyle(
                color = Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            ),
            modifier = Modifier.padding(horizontal = 18.dp, vertical = 6.dp)
        )
    }


}

@Composable
fun FBLogin() {

    OutlinedButton(
        onClick = { /*TODO*/ },
        modifier = Modifier.padding(6.dp),
        shape = RoundedCornerShape(6.dp),
        border = BorderStroke(
            width = 1.dp,
            color = colorResource(id = R.color.grey_medium2)
        ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(horizontal = 18.dp, vertical = 3.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_login_fb_1),
                contentDescription = "fb login",
                tint = colorResource(id = R.color.fb_color)
            )
            Text(
                text = "Facebook",
                style = TextStyle(
                    color = Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                ),
            )
        }


    }
}

@Composable
fun TermsText() {
    Row(
        modifier = Modifier.padding(top = 5.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "By continuing you agree with our",
            style = TextStyle(
                fontSize = 12.sp,
                color = colorResource(id = R.color.textColorGray)
            )
        )
        Text(text = "terms and conditions",
            style = TextStyle(
                fontSize = 12.sp,
                color = colorResource(id = R.color.privacy_color)
            ),
            modifier = Modifier
                .clickable { /*TODO*/ }
                .padding(start = 5.dp)
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyContent()
}