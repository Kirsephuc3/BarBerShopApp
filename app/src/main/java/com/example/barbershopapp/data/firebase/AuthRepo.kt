package com.example.barbershopapp.data.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.example.barbershopapp.data.user.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AuthRepo {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val uid: String? = auth.currentUser?.uid
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    init {
        if (!uid.isNullOrEmpty()) {
            getUserData()
        }
    }

    private fun getUserData() {
        uid?.let {
            firestore.collection("users").document(it).addSnapshotListener { snapshot, error ->
                if (error != null) {
                    // Handle error
                    return@addSnapshotListener
                }
                _user.value = snapshot?.toObject(User::class.java)
            }
        }
    }
}
