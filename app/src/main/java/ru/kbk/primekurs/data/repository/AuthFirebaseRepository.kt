package ru.kbk.primekurs.data.repository

import kotlinx.coroutines.tasks.await
import ru.kbk.primekurs.data.FirebaseModule
import ru.kbk.primekurs.data.model.User

class AuthFirebaseRepository
{
    private val auth = FirebaseModule.auth
    private val firestore= FirebaseModule.firestore
    suspend fun Register(
        email: String,
        password: String,
        name: String,
        role: String="person"
        ): Result<User> {
        return try {
            val result=auth.createUserWithEmailAndPassword(email,password).await()
            val uid=result.user?.uid?:throw Exception("UID null")
            val user= User(uid = uid,email=email,name=name, role = role)
            firestore.collection("persons").document(uid).set(user).await()
            Result.success(user)
        }
        catch (e: Exception){
            Result.failure(e)
        }
    }
    suspend fun login(email: String,password: String): Result<User>{
        return try {
            val result=auth.signInWithEmailAndPassword(email,password).await()
            val uid=result.user?.uid?:throw Exception("UID null")
            val snapshot=firestore.collection("persons").document(uid).get().await()
            var user=snapshot.toObject(User::class.java)?:throw Exception("User not found")
            Result.success(user)
        }
        catch (e: Exception){
            Result.failure(e)
        }
    }
    fun logout(){
        auth.signOut()
    }
}