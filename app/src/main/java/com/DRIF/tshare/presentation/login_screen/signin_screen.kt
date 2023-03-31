package com.DRIF.tshare.presentation.login_screen

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.DRIF.tshare.R
import com.DRIF.tshare.ui.theme.*

@Composable
fun cobalogin() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordOpen by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.vector_atas),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.requiredSize(250.dp)
        )
    }

    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomEnd) {
        Image(
            painter = painterResource(id = R.drawable.vector_bawah),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.requiredSize(250.dp)
        )
    }
    Box(
        modifier = Modifier
            .padding(top = 200.dp)
            .padding(horizontal = 40.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Selamat Datang!",
                fontSize = 28.sp,
                color = Color(0xFF386A20),
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Left,
                fontWeight = FontWeight.Bold,
                fontFamily = Poppins
            )

            Divider(
                color = Color(0xFFA1AF98),
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)) {
                OutlinedTextField(
                    value = email, onValueChange = {
                        email = it
                    },
                    label = {
                        Text(text = "Email Address", color = Color(0xFF386A20))
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .padding(top = 10.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFF386A20),
                        unfocusedBorderColor = Color(0xFF9BD87E),
                        textColor = Color(0xFF386A20),
                        cursorColor = Color(0xFF386A20)

                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType =
                        KeyboardType.Email
                    ),
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_email),
                            contentDescription = "",
                            tint = Color(0xFF386A20),
                            modifier = Modifier.size(24.dp)
                        )
                    }
                )

                OutlinedTextField(
                    value = password, onValueChange = {
                        password = it
                    },
                    label = {
                        Text(text = "Password", color = Color(0xFF386A20))
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .padding(top = 10.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFF386A20),
                        unfocusedBorderColor = Color(0xFF9BD87E),
                        textColor = Color(0xFF386A20),
                        cursorColor = Color(0xFF386A20)
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    singleLine = true,
                    visualTransformation = if (!isPasswordOpen) PasswordVisualTransformation() else VisualTransformation.None,
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_password),
                            contentDescription = "",
                            tint = Color(0xFF386A20),
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = { isPasswordOpen = !isPasswordOpen }) {
                            if (!isPasswordOpen) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_eye_open),
                                    contentDescription = "",
                                    tint = Color(0xFF386A20),
                                    modifier = Modifier.size(24.dp)
                                )
                            } else {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_eye_close),
                                    contentDescription = "",
                                    tint = Color(0xFF386A20),
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }
                    }
                )

                Text(
                    text = "Lupa kata sandi?",
                    color = Color(0xFF6E7E62),
                    fontFamily = Poppins,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Right,
                )

                OutlinedButton(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .padding(top = 20.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = Color.Transparent,
                        contentColor = Color(0xFF386A20)
                    ),
                    contentPadding = PaddingValues(vertical = 14.dp),
                    shape = RoundedCornerShape(20.dp),
                    border = BorderStroke(1.dp, Color(0xFF386A20)),
                ) {

                    Text(text = "Login", fontFamily = Poppins)
                }

                Text(
                    text = "Atau",
                    color = Color(0xFF6E7E62),
                    fontFamily = Poppins,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                )

                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFF386A20)
                    ),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .fillMaxWidth()
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_google),
                            contentDescription = "",
                            tint = Color.Unspecified,
                            modifier = Modifier.size(26.dp)
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Text(text = "Continue with Google", color = Color.White, fontSize = 16.sp)
                    }
                }
            }


        }
    }
}