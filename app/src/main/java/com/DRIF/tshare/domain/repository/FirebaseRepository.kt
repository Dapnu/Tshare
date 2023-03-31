package com.DRIF.tshare.domain.repository

import com.DRIF.tshare.domain.model.AuthUser
import kotlinx.coroutines.flow.Flow
import com.google.firebase.auth.AuthResult
import com.DRIF.tshare.util.Resource
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseUser


interface FirebaseRepository {
    fun firebaseSignIn(user: AuthUser): Flow<Resource<String>>
    fun firebaseSignUp(user: AuthUser): Flow<Resource<String>>
    fun currentUserExist(): Flow<Boolean>
    fun signOut()
    fun currentUser(): FirebaseUser?
    fun userLogOut()
}