package com.example.O7Solution.data

import androidx.lifecycle.LiveData
import com.example.O7Solution.UserDao

class UserRepository(private val userDao: UserDao) {
    val readAllData:LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.adduser(user)
    }
    suspend fun deleteUser(user: User){

    }
    fun getData(): LiveData<List<User>> {
        return readAllData
    }
}