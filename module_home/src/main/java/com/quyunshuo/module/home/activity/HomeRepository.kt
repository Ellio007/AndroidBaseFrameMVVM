package com.quyunshuo.module.home.activity

import com.quyunshuo.androidbaseframemvvm.base.mvvm.m.BaseRepository
import com.quyunshuo.androidbaseframemvvm.common.bean.User
import com.quyunshuo.androidbaseframemvvm.common.db.dao.UserDao
import com.quyunshuo.module.home.net.HomeApiService
import javax.inject.Inject

/**
 * 首页M层
 *
 * @author Qu Yunshuo
 * @since 5/25/21 5:42 PM
 */
class HomeRepository @Inject constructor() : BaseRepository() {

    @Inject
    lateinit var mApi: HomeApiService

    @Inject
    lateinit var userDao: UserDao

    /**
     * 模拟获取数据
     */
    fun requestUserList() {
        // 模拟请求之后插入一条数据
        val user = User(0, "tan", "yanhao")
        userDao.insert(user)
    }

    /**
     * 模拟获取数据
     */
    fun getDBUserList() = userDao.getAllUsers()
}