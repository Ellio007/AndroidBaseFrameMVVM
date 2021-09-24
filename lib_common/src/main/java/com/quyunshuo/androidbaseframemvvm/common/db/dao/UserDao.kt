package com.quyunshuo.androidbaseframemvvm.common.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.quyunshuo.androidbaseframemvvm.common.bean.User
import kotlinx.coroutines.flow.Flow

@Dao
abstract class UserDao : BaseDao<User>() {
    @Query("SELECT * FROM User")
    abstract fun getAllUsers(): Flow<List<User>?>
}
