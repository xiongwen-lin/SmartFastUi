package com.apeman.yruiwidget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.apeman.yruiwidget.databinding.ActivitySmartButtonBinding
import com.apemans.quickui.button.SmartButton
import com.apemans.quickui.editbox.SmartEditBox
import com.apemans.yruibusiness.base.BaseComponentActivity
import com.apemans.yruibusiness.ui.toolbar.setToolbar
import com.dylanc.longan.toast
import kotlin.concurrent.thread

class SwitchButtonActivity:  AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_switch_button)

    }


}