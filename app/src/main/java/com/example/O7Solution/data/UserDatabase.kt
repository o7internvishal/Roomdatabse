package com.example.O7Solution.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.O7Solution.UserDao
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun UserDao(): UserDao


    @OptIn(InternalCoroutinesApi::class)
    companion object {
        @Volatile
        private var INSTACE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase {
            val temInstance = INSTACE
            if (temInstance != null) {
                return temInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "userdatabase"
                ).build()
                INSTACE = instance
                return instance
            }

        }
    }

}