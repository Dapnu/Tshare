package com.DRIF.tshare.data

import android.util.Log
import com.DRIF.tshare.domain.model.AuthUser
import com.DRIF.tshare.domain.repository.FirebaseRepository
import com.DRIF.tshare.util.Resource
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class FirebaseRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : FirebaseRepository {
    override fun firebaseSignIn(user: AuthUser): Flow<Resource<String>> = callbackFlow {
        trySend(Resource.Loading())
        firebaseAuth.signInWithEmailAndPassword(user.email, user.password).addOnSuccessListener {
            trySend(Resource.Success("Login Successful"))
        }.addOnFailureListener {
            trySend(Resource.Error(it.message.toString()))
        }
        awaitClose {
            close()
        }
    }

    override fun firebaseSignUp(user: AuthUser): Flow<Resource<String>> = callbackFlow {
        trySend(Resource.Loading())
        firebaseAuth.createUserWithEmailAndPassword(user.email, user.password)
            .addOnSuccessListener {
                val userUid = it.user?.uid
                trySend(Resource.Success("Signup Successful"))
            }.addOnFailureListener {
                trySend(Resource.Error(it.message.toString()))
            }
        awaitClose {
            close()
        }
    }


    override fun currentUserExist(): Flow<Boolean> {
        return flow {
            emit(firebaseAuth.currentUser != null)
        }
    }

    override fun signOut() {
        firebaseAuth.signOut()
    }

    override fun currentUser(): FirebaseUser? {
        return firebaseAuth.currentUser
    }

    override fun userLogOut() {
        return firebaseAuth.signOut()
    }

}