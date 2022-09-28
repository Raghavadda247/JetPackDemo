package com.example.jetpackdemo

import android.graphics.drawable.BitmapDrawable
import android.media.Image
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.res.ResourcesCompat
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
                .fillMaxSize()
        ) {
            ViewPagerSlider()
            GoogleSignIn()
            Text(text = "or", modifier = Modifier.align(CenterHorizontally))
            EmailButtons()
            TermsText()
        }


    }
}

@Composable
fun EmailButtons() {

    val mainButtonColor = ButtonDefaults.buttonColors(
        backgroundColor = Color.White,
        contentColor = Color.Gray
    )

    Row(
        modifier = Modifier
            .padding(40.dp, 10.dp, 30.dp, 10.dp)
    ) {
        Button(
            onClick = { /*TODO*/ },
            colors = mainButtonColor,
        ) {
            Text(text = "Email/Mobile")
        }
        Spacer(modifier = Modifier.padding(0.dp, 0.dp, 40.dp, 10.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = mainButtonColor
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_login_fb_1),
                modifier = Modifier
                    .size(20.dp),
                contentDescription = "drawable icons",
                tint = Color.Unspecified
            )
            Text(text = "Facebook")

        }
    }


}

@Composable
fun GoogleSignIn() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .padding(30.dp, 0.dp, 30.dp, 10.dp)
            .fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_login_google),
            modifier = Modifier
                .size(30.dp)
                .background(Color.White, shape = CircleShape)
                .padding(4.dp),
            contentDescription = "drawable icons",
            tint = Color.Unspecified
        )
        Text(text = "  Continue with google")
    }
}

@Composable
fun TermsText() {
    Row(
        modifier = Modifier.padding(3.dp)
    ) {
        Text(text = "By continuing you agree with our ")
        Text(text = "terms and conditions", modifier = Modifier
            .clickable { }
            .padding(0.dp, 0.dp, 0.dp, 5.dp)
            .align(Alignment.Bottom), color = Color.Blue)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyContent()
}