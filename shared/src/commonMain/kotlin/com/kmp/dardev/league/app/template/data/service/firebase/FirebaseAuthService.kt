package com.kmp.dardev.league.app.template.data.service.firebase

import com.kmp.dardev.league.app.template.domain.service.IFirebaseAuthService
import com.kmp.dardev.league.app.template.domain.model.SignInData
import com.kmp.dardev.league.app.template.domain.model.SignUpData
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.auth
import dev.gitlive.firebase.firestore.firestore

class FirebaseAuthService : IFirebaseAuthService {
    private val auth: FirebaseAuth = Firebase.auth
    private val db = Firebase.firestore

    override suspend fun signInFirebaseService(signInData: SignInData) {
        auth.signInWithEmailAndPassword(signInData.email.trim(), signInData.password)
    }

    override suspend fun signUpFirebaseService(signUpData: SignUpData) {
        // To modify add is Private
        val user = hashMapOf(
            "Description" to "",
            "ProfilPicture" to "",
            "Email" to signUpData.email,
        )
        auth.createUserWithEmailAndPassword(signUpData.email.trim(), signUpData.password)
        auth.currentUser?.uid?.let { db.collection("user").document(it).set(user) }
    }
}