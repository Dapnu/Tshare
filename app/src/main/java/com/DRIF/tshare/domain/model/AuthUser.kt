package com.DRIF.tshare.domain.model

data class AuthUser(
    val email: String = "",
    val password: String = "",
    var id: String = "",
    val name: String = "",
    val phoneNumber: String = "",
)
