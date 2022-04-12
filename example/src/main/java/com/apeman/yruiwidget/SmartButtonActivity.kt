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

class SmartButtonActivity: BaseComponentActivity<ActivitySmartButtonBinding>() {
    override fun onViewCreated(savedInstanceState: Bundle?) {
        setToolbar {
            title = resources.getString(R.string.title_smart_button)
            leftIcon(R.drawable.ic_back) {
                finish()
            }
        }
        initView()
    }
    private fun   initView() {
        //初始化
       binding.btnNormal.isEnabled = false


        //edittext输入内容，则支持按钮操作
        binding.edtAccount.addOnTextChanged { it, textChanged ->
            run {
                binding.btnNormal.isEnabled = !TextUtils.isEmpty(textChanged) && !TextUtils.isEmpty( binding.edtPassword.getEditText().text.toString())
                it.setTitleStatus(!TextUtils.isEmpty(textChanged))
                if ( TextUtils.isEmpty(textChanged)){
                    it.showError("请输入账号")
                }
            }
        }

        binding.edtPassword.addOnTextChanged { it, textChanged ->
            run {
                binding.btnNormal.isEnabled = !TextUtils.isEmpty(textChanged) && !TextUtils.isEmpty( binding.edtAccount.getEditText().text.toString())
                it.setTitleStatus(!TextUtils.isEmpty(textChanged))
                if ( TextUtils.isEmpty(textChanged)){
                    it.showError("请输入密码")
                }
            }
        }

        binding.btnNormal.setOnClickListener {
            binding.btnNormal.showLoadingBtn()
            toast("登录成功")
            binding.btnNormal.postDelayed ({   binding.btnNormal.hideLoadingBtn()  },2000)
        }
    }


}