package com.apeman.yruiwidget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.apeman.yruiwidget.databinding.ActivitySmartButtonBinding
import com.apeman.yruiwidget.databinding.ActivitySmarteditboxBinding
import com.apemans.quickui.editbox.SmartEditBox
import com.apemans.yruibusiness.base.BaseComponentActivity
import com.apemans.yruibusiness.ui.toolbar.setToolbar

class SmartEditBoxActivity : BaseComponentActivity<ActivitySmarteditboxBinding>() {
    override fun onViewCreated(savedInstanceState: Bundle?) {
        setToolbar {
            title = resources.getString(R.string.title_smart_edittext)
            leftIcon(R.drawable.ic_back) {
                finish()
            }
        }
        initView()
    }

    private fun   initView(){

       binding.edtTitle.setTitle("有标题")

        //4.输入内容，判断空为错误

        binding.edtError.addOnTextChanged { smartEditBox, textChanged ->
            run {
                if (TextUtils.isEmpty(textChanged)) {
                    smartEditBox.showError("不能为空", true)
                }else{
                    smartEditBox.hideTips()
                }
            }
        }

        //5.输入内容，判断不为空则正确
        binding.edtRight.addOnTextChanged { smartEditBox, textChanged ->
            run {
                if (!TextUtils.isEmpty(textChanged)) {
                    smartEditBox.setTitle("正确格式")
                    smartEditBox.setTitleStatus(true)
                }else{
                    smartEditBox.setTitle("消失了",false)
                    smartEditBox.setTitleStatus(false)
                }
            }
        }
    }


}