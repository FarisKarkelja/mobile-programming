package com.example.mobile_programming.model.di

import com.example.mobile_programming.model.repository.auth.AuthRepository
import com.example.mobile_programming.model.repository.auth.AuthRepositoryImpl
import com.example.mobile_programming.model.repository.review.ReviewRepository
import com.example.mobile_programming.model.repository.review.ReviewRepositoryImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {
    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun provideFirebaseFirestore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Provides
    @Singleton
    fun provideAuthRepository(firebaseAuth: FirebaseAuth): AuthRepository {
        return AuthRepositoryImpl(firebaseAuth)
    }

    @Provides
    @Singleton
    fun provideReviewRepository(firestore: FirebaseFirestore): ReviewRepository {
        return ReviewRepositoryImpl(firestore)
    }
}