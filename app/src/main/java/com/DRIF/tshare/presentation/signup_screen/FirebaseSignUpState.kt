package com.DRIF.tshare.presentation.signup_screen

data class FirebaseSignUpState(
    var isLoading: Boolean = false,
    var isSignedUp: String? = null,
    val error: String? = null
)
