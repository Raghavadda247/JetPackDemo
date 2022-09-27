package com.example.jetpackdemo

import android.media.Image
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

data class Data(val image: Int,val heading: String,val text:String)

val imgList = listOf<Data>(
    Data(R.drawable.top_1,"Largest Learning Destination","10+ crore students learning and sharing community"),
    Data(R.drawable.top_2,"Highest Succes Numbers","1 Lakh+ government job selection"),
    Data(R.drawable.top_3,"Unmatched Tests &  video classes","10,000+ test, 5000+ hours of recorded and Live sessions"),
    Data(R.drawable.top_4,"Stay Ahead Of the Pack","Latest Exam notifications, job alerts and current affairs")

)
