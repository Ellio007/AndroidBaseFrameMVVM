package com.quyunshuo.androidbaseframemvvm.common.constant

/**
 * @Author: QuYunShuo
 * @Time: 2020/8/28
 * @Class: RoutePath
 * @Remark: 路由地址
 */
object RouteUrl {
    /**
     * 首页模块
     */
    object Home {
        private const val HOME_PATH = "/home/"

        /**
         * 首页
         */
        const val ViewPager = HOME_PATH + "HomeFragment"

        /**
         * 首页Fragment
         */
        const val InternalPager = HOME_PATH + "InternalPager"

        /**
         * 第二个界面
         */
        const val Second = HOME_PATH + "Second"

        /**
         * 第二个界面
         */
        const val HomeFragment = HOME_PATH + "HomeFragment"
    }
}