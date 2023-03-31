package com.DRIF.tshare.domain.repository

import com.DRIF.tshare.domain.model.AuthUser
import com.DRIF.tshare.util.Resource
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

interface GoogleSignInRepository {

    suspend fun addUserToFireStore()

    fun signInWithCredential(
        credentials: AuthCredential,
        user: AuthUser
    ): Flow<Resource<AuthResult>>
}