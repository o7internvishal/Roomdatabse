package com.example.O7Solution.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.O7Solution.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {
    private val readAllData:LiveData<List<User>>

    private val repository:UserRepository
    init {
        val UserDao=UserDatabase.getDatabase(application).UserDao()
        repository= UserRepository(UserDao)
        readAllData=repository.readAllData
    }
    fun addUser(user: User){
        viewModelScope.launch (Dispatchers.IO) {
            repository.addUser(user)

        }
    }
}