package com.apeman.yruiwidget

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.apemans.quickui.button.SmartButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView(){
        findViewById<SmartButton>(R.id.tvLabelTextIconView).setOnClickListener {
            startActivity(Intent(this, LableTextIconActivity::class.java))
        }
        findViewById<SmartButton>(R.id.tvSmartEditBox).setOnClickListener {
            startActivity(Intent(this, SmartEditBoxActivity::class.java))
        }
        findViewById<SmartButton>(R.id.tvSmartDialog).setOnClickListener {
            startActivity(Intent(this, SmartDialogActivity::class.java))
        }
        findViewById<SmartButton>(R.id.tvSmartButton).setOnClickListener {
            startActivity(Intent(this, SmartButtonActivity::class.java))
        }

        findViewById<SmartButton>(R.id.tvSwitchButton).setOnClickListener {
            startActivity(Intent(this, SwitchButtonActivity::class.java))
        }

    }
}