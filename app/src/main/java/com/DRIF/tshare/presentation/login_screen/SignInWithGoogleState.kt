package com.DRIF.tshare.presentation.login_screen

import com.google.firebase.auth.AuthResult

data class SignInWithGoogleState(
    val isLoading: Boolean? = false,
    val success: AuthResult? = null,
    val error: String? = null
)
