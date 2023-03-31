package com.DRIF.tshare.di

import com.DRIF.tshare.domain.repository.FirebaseRepository
import com.DRIF.tshare.data.FirebaseRepositoryImpl
import com.DRIF.tshare.data.GoogleSignInRepositoryImpl
import com.DRIF.tshare.domain.repository.GoogleSignInRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import dagger.Provides


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

        @Singleton
        @Provides
        fun provideFirebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun providesFirebaseRepository(
        firebaseAuth: FirebaseAuth
    ): FirebaseRepository {
        return FirebaseRepositoryImpl(
            firebaseAuth = firebaseAuth,
        )
    }

    @Provides
    @Singleton
    fun providesGoogleSignInRepository(
        auth: FirebaseAuth,
        fireStore: FirebaseFirestore
    ): GoogleSignInRepository {
        return GoogleSignInRepositoryImpl(
            firebaseAuth = auth,
            fireStore = fireStore
        )
    }
}