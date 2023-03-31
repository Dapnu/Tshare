package com.DRIF.tshare.data

import com.DRIF.tshare.domain.model.AuthUser
import com.DRIF.tshare.domain.repository.GoogleSignInRepository
import com.DRIF.tshare.util.Resource
import com.DRIF.tshare.util.Constant.USER_COLLECTION
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class GoogleSignInRepositoryImpl @Inject constructor(
    private val fireStore: FirebaseFirestore,
    private val firebaseAuth: FirebaseAuth,
) : GoogleSignInRepository {

    private fun FirebaseUser.toUser() = mapOf(
        "displayName" to displayName,
        "email" to email,
        "photoUrl" to photoUrl?.toString(),
        "createDate" to FieldValue.serverTimestamp()
    )

    override fun signInWithCredential(
        credentials: AuthCredential,
        user: AuthUser
    ): Flow<Resource<AuthResult>> {
        return flow {
            emit(Resource.Loading())
            val result = firebaseAuth.signInWithCredential(credentials).await()
            val userUid = result.user?.uid
            fireStore.collection(USER_COLLECTION).document(userUid!!).set(
                addUserToFireStore()
            )
            emit(Resource.Success(result))
        }.catch {
            emit(Resource.Error(it.message.toString()))
        }
    }


    override suspend fun addUserToFireStore() {
        firebaseAuth.currentUser?.apply {
            val user = toUser()
            fireStore.collection(USER_COLLECTION).document(uid).set(user).await()
        }
    }


}