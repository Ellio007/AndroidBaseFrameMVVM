package com.quyunshuo.androidbaseframemvvm.common.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.quyunshuo.androidbaseframemvvm.common.bean.User
import com.quyunshuo.androidbaseframemvvm.common.db.dao.UserDao

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        const val DB_NAME = "AppDatabase.db"
    }
}
