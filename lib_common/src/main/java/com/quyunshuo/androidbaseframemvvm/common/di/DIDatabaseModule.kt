package com.quyunshuo.androidbaseframemvvm.common.di

import androidx.room.Room
import com.quyunshuo.androidbaseframemvvm.base.BaseApplication
import com.quyunshuo.androidbaseframemvvm.common.db.AppDatabase
import com.quyunshuo.androidbaseframemvvm.common.db.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * 全局作用域的数据库的依赖注入模块
 *
 * @author Qu Yunshuo
 * @since 6/4/21 8:58 AM
 */
@Module
@InstallIn(SingletonComponent::class)
class DIDatabaseModule {

    /**
     * [AppDatabase]依赖提供方法
     *
     * @return AppDatabase
     */
    @Singleton
    @Provides
    fun provideAppDatabase(): AppDatabase {
        return Room.databaseBuilder(
            BaseApplication.context,
            AppDatabase::class.java,
            AppDatabase.DB_NAME
        ).build()
    }

    /**
     * 项目UserDao依赖提供方法
     *
     * @param appDatabase 数据库实例化对象
     * @return Retrofit
     */
    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }
}