package com.DRIF.tshare.presentation.login_screen

data class FirebaseSignInState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val isSignedIn: String? = null
)
