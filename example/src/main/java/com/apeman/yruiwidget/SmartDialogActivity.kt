package com.apeman.yruiwidget

import android.os.Bundle
import com.apeman.yruiwidget.databinding.ActivitySmartDialogBinding
import com.apemans.quickui.superdialog.AvatarSelectDialog
import com.apemans.quickui.superdialog.SmartDialog
import com.apemans.yruibusiness.base.BaseComponentActivity
import com.apemans.yruibusiness.ui.toolbar.setToolbar

class SmartDialogActivity:BaseComponentActivity<ActivitySmartDialogBinding>(){
    override fun onViewCreated(savedInstanceState: Bundle?) {
        setToolbar {
            title = resources.getString(R.string.title_smart_dialog)
            leftIcon(R.drawable.ic_back) {
                finish()
            }
        }
        initDialog()
    }

    private   fun  initDialog(){
         binding.btHeaderDialog.setOnClickListener {
           //  AvatarSelectDialog
         }
        binding.btSmartDialog.setOnClickListener {
            SmartDialog.build(supportFragmentManager)
                .setTitle("对话框标题")
                .setContentText("副本内容")
                .setPositiveTextName(resources.getString(R.string.confirm))
                .setNegativeTextName(resources.getString(R.string.cancel))
                .setOnPositive {
                    it.dismiss()
                }.setOnNegative {
                    it.dismiss()
                }.show()
        }
        binding.btSmartDialogSingle.setOnClickListener {
            SmartDialog.build(supportFragmentManager)
                .setTitle("对话框标题")
                .setContentText("setOnPositive()")
                .setPositiveTextName(resources.getString(R.string.confirm))
                .setOnPositive {
                    it.dismiss()
                }.show()
        }

        binding.btSmartDialogIcon.setOnClickListener {
            SmartDialog.build(supportFragmentManager)
                .setHeadImage(R.drawable.common_ic_pop_prompt)
                .setTitle("对话框标题")
                .setContentText(".setHeadImage设置头部图标")
                .setPositiveTextName(resources.getString(R.string.confirm))
                .setNegativeTextName(resources.getString(R.string.cancel))
                .setOnPositive {
                    it.dismiss()
                }.setOnNegative {
                    it.dismiss()
                }.show()
        }


        binding.btSmartDialogCheckBox.setOnClickListener {
            SmartDialog.build(supportFragmentManager)
                .setTitle("对话框标题")
                .setContentText(".showRemind() 复选框")
                .showRemind(true,"别再弹窗了")
                .setPositiveTextName(resources.getString(R.string.confirm))
                .setNegativeTextName(resources.getString(R.string.cancel))
                .setOnPositive {
                    it.dismiss()
                }.setOnNegative {
                    it.dismiss()
                }.show()
        }
        binding.btSmartDialogEdt.setOnClickListener {
            SmartDialog.build(supportFragmentManager)
                .setTitle("对话框标题")
               // .showEditBox(true,showKeyboard = true, "Set Params","0-200C") //支持右边输入框
                .showEditBox(true,showKeyboard = true, "Set Params")
                .setContentText(".showEditBox()输入框")
                .setPositiveTextName(resources.getString(R.string.confirm))
                .setNegativeTextName(resources.getString(R.string.cancel))
                .setOnPositive {
                    it.dismiss()
                }.setOnNegative {
                    it.dismiss()
                }.show()
        }

        binding.btSmartDialogPic.setOnClickListener {
            SmartDialog.build(supportFragmentManager)
                //.setHeadImageUrl(R.drawable.common_ic_default_preview) //顶部状态图标
                .setCenterImage(R.drawable.common_ic_default_preview)//中间插画
                //.showEditBox(true,showKeyboard = true, "Set Params")//输入框
                //.showRemind(true,"别再弹窗了")     //复选框
                .setTitle("对话框标题")
                .setContentText("setCenterImage()中间插画")
                .setPositiveTextName(resources.getString(R.string.confirm))
                .setNegativeTextName(resources.getString(R.string.cancel))
                .addEditBoxInputChangeListener { smartEditBox, textChanged ->
                    if (textChanged == "") {
                        smartEditBox.showError("Please input correct", true)
                    }
                }
                .setOnPositive {
                    it.dismiss()
                }.setOnNegative {
                    it.dismiss()
                }.show()
        }

    }


}