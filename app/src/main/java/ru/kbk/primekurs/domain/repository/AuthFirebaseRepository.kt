package ru.kbk.primekurs.domain.repository

import kotlinx.coroutines.tasks.await
import ru.kbk.primekurs.domain.FirebaseModule
import ru.kbk.primekurs.domain.model.User

class AuthFirebaseRepository
{
    private val auth = FirebaseModule.auth
    private val firestore= FirebaseModule.firestore
    suspend fun Register(
        email: String,
        password: String,
        userName: String,
        fullName: String,
        phone: String
        ): Result<User> {
        return try {
            val result=auth.createUserWithEmailAndPassword(email,password).await()
            val uid=result.user?.uid?:throw Exception("UID null")
            val user= User(uid = uid,email=email, userName = userName, fullName = fullName, phone = phone)
            firestore.collection("persons").document(uid).set(user).await()
            Result.success(user)
        }
        catch (e: Exception){
            Result.failure(e)
        }
    }
    suspend fun Login(email: String,password: String): Result<User>{
        return try {
            val result=auth.signInWithEmailAndPassword(email,password).await()
            val uid=result.user?.uid?:throw Exception("UID null")
            val snapshot=firestore.collection("persons").document(uid).get().await()
            val user=snapshot.toObject(User::class.java)?:throw Exception("User not found")
            Result.success(user)
        }
        catch (e: Exception){
            Result.failure(e)
        }
    }
    fun Logout(){
        auth.signOut()
    }
}