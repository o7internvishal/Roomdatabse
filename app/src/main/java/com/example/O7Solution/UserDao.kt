package com.example.O7Solution

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.O7Solution.data.User
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun adduser(user: User)
   @Query( "SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>
}