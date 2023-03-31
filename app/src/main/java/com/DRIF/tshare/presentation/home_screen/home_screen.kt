package com.DRIF.tshare.presentation.home_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.focus.FocusRequester

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.DRIF.tshare.R
import com.DRIF.tshare.ui.theme.*


@Composable
fun Home_Screen() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()){

        Box(
            modifier = Modifier
                .background(Color(0xFF3C4535))
                .fillMaxWidth()
                .height(220.dp)
        ) {

        }

        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.vector_atas),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.requiredSize(250.dp)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Box(modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp), contentAlignment = Alignment.BottomEnd) {
            Image(
                painter = painterResource(id = R.drawable.vector_bawah),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.requiredSize(250.dp)
            )
        }
    }
    Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp)) {
        Column(modifier = Modifier.fillMaxHeight()){
            Text(
                text = "Halo, Fathur",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            )
            Row(modifier = Modifier.padding(vertical = 8.dp)){
                Icon(
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = "",
                    tint = Color(0xFFE5E5E5),
                    modifier = Modifier
                        .size(12.dp)
                )
                Text(
                    text = "2000 poin",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
    }
    Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp)) {
        Box(
            modifier = Modifier
                .background(Color(0xFF3C4535))
                .fillMaxWidth()
                .height(220.dp)
        ) {

        }
    }
}