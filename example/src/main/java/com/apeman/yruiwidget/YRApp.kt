package com.apeman.yruiwidget

import android.app.Application
import com.apemans.quickui.label.GlobalLabelTextConfigure

import java.io.File

/***********************************************************
 * 作者: zhengruidong@apemans.com
 * 日期: 2021/12/28 3:53 下午
 * 说明:
 *
 * 备注:
 *
 ***********************************************************/
class YRApp : Application() {

    override fun onCreate() {
        try {
            super.onCreate()
        } catch (e: Exception) {
        }
        instance = this

        initThemeConfigure()
    }



    /**
     * 初始化Logger
     * 1、调用YRApiManager.init()接口，初始化配置，具体配置参数如下。
     */
   /* private fun initYRLogger() {
        *//**
         * 初始化日志设置
         * LoganConfig 配置参数
         * cachePath mmap缓存路径
         * logFilePath file文件路径
         * maxFileSize 删除文件最大值
         * day 删除天数
         * encryptKey 128位ase加密Key
         * encryptIv 128位aes加密IV
         * debug 是否为debug模式, true 表示使用调试模式，日志输出到控制台。false表示关闭调试模式，日志输出到文件中
         *//*
        var cachePath = getFilesDir().getAbsolutePath()
        var logFilePath =
            getExternalFilesDir(null)!!.getAbsolutePath() + File.separator + "osaio";
        var maxFileSize = 10 * 1024 * 1024L
        YRLogManager.init(true) {
            it.setCachePath(cachePath)
                .setPath(logFilePath)
                .setMaxFile(maxFileSize)
                .setDay(10)
                .setEncryptKey16("0123456789012345".encodeToByteArray())
                .setEncryptIV16("0123456789012345".encodeToByteArray())
        }
    }*/




    private fun initThemeConfigure() {
        GlobalLabelTextConfigure.apply {
            textColor = R.color.theme_text_color
            subTextColor = R.color.theme_sub_text_color
            detailTextColor =  R.color.theme_sub_text_color
            selectionOnColor = R.color.theme_color
            selectionOffColor = R.color.theme_sub_text_color
        }

    }

    companion object {
        lateinit var instance: YRApp
        val isDebugMode = false
    }
}