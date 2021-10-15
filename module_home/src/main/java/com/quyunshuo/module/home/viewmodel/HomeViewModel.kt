package com.quyunshuo.module.home.viewmodel

import android.util.Log
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.quyunshuo.androidbaseframemvvm.base.mvvm.vm.BaseViewModel
import com.quyunshuo.module.home.activity.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * 首页的VM层
 *
 * @property mRepository HomeRepository 仓库层 通过Hilt注入
 *
 * @author Qu Yunshuo
 * @since 5/25/21 5:41 PM
 */
@HiltViewModel
class HomeViewModel @Inject constructor(private val mRepository: HomeRepository) : BaseViewModel() {

//    val data = MutableLiveData<String>()

    fun requestUserList() {
        viewModelScope.launch(Dispatchers.IO) {
            mRepository.requestUserList()
        }
    }

    /**
     * 模拟获取数据
     */
    fun getUserList() = liveData {
        mRepository.getDBUserList()
            .catch { Log.d("qqq", "getData: $it") }
            .collect {
                if (it != null) {
                    emit(it)
                }
            }
    }
}