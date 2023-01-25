package com.example.O7Solution

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.O7Solution.data.User
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun adduser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
   suspend fun deleteUser(user: User)

    @Query( "SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>

}