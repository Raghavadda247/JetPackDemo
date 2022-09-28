package com.example.jetpackdemo.view

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackdemo.MyContent
import com.example.jetpackdemo.imgList
import com.google.accompanist.pager.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

@ExperimentalPagerApi
@Composable
fun ViewPagerSlider() {
    val pagerState = rememberPagerState(
        pageCount = imgList.size,
        initialPage = 2
    )
    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(2000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount),
                animationSpec = tween(600)
            )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .padding(0.dp)
        ) { page ->
            val imgsrc = imgList[page]
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxHeight(.75f)
            ) {
                Column() {
                    Image(
                        painter = painterResource(
                            id = imgsrc.image
                        ),
                        contentDescription = "Image",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                            .weight(0.70f))

                    Text(
                        text = imgsrc.heading,
                        style = MaterialTheme.typography.h6,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    )

                    Text(
                        text = imgsrc.text,
                        style = MaterialTheme.typography.body1,
                        color = Color.Black,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(10.dp)
                    )
                    HorizontalPagerIndicator(
                        pagerState = pagerState,modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(16.dp)
                    )


                }


            }
        }

    }

}

@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ViewPagerSlider()
}
