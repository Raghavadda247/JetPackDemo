package com.example.jetpackdemo

import android.media.Image
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

data class Data(val image: Int,val heading: Int,val text:Int)

val imgList = listOf<Data>(
    Data(R.drawable.top_1,R.string.onboarding_title1,R.string.caption1),
    Data(R.drawable.top_2,R.string.onboarding_title2,R.string.caption2),
    Data(R.drawable.top_3,R.string.onboarding_title3,R.string.caption3),
    Data(R.drawable.top_4,R.string.onboarding_title4,R.string.caption4)

)
