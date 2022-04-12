package com.apemans.quickui.button

import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import com.apemans.quickui.R
import com.apemans.quickui.editbox.SmartEditBox

/***********************************************************
 * @Author:dongbeihu
 * @Date: 2022/3/23-10:55
 * @Description: 规范项目通用button(如提交、注册、下一步)
 *
 *
 ***********************************************************/

class SmartButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr){
    private  var smartButton: AppCompatButton
    private  var ivLoading: ImageView

    private var onClickListener: ((smartButton:View) -> Unit)? = null
    private var btnLoadingAnimator: ObjectAnimator? = null
    private var smartButtonTxt:String = "" //存放动画时候，按钮文本

    init {
        val rootView =
            LayoutInflater.from(context).inflate(R.layout.layout_button_normal, this, true)
        smartButton = rootView.findViewById(R.id.btnNormalView)
        ivLoading = rootView.findViewById(R.id.ivLoading)

        if (attrs != null) {
            val attr = context.obtainStyledAttributes(attrs, R.styleable.CustomerAttrs)
            if (attr.hasValue(R.styleable.CustomerAttrs_text)) {
                smartButtonTxt = attr.getString(R.styleable.CustomerAttrs_text).toString()
                smartButton.text = smartButtonTxt
            }
        }

        setBtnSignInAnimator()
        smartButton.setOnClickListener {
            onClickListener?.invoke(it)
        }
    }

    /**
     * 设置是否支持操作（自动字体、按钮颜色变化）
     */
    override fun setEnabled(enabled :Boolean){
        smartButton.isEnabled = enabled
    }

    /**
     * 设置按钮文字
     */
    fun setText( text:CharSequence){
        smartButton.text  = text
    }

    private fun setBtnSignInAnimator() {
        btnLoadingAnimator = ObjectAnimator.ofFloat(ivLoading, "Rotation", 0f, 360f)
        btnLoadingAnimator?.duration = 2000
        btnLoadingAnimator?.repeatCount = -1
    }

    /**
     * 点击加载按钮动画
     */
    fun showLoadingBtn() {
        smartButton.text = ""
        btnLoadingAnimator?.start()
        ivLoading.visibility = View.VISIBLE
        smartButton.isClickable = false  //避免重复点击
    }
    /**
     * 点击按钮动画消失
     */
    fun hideLoadingBtn() {
        smartButton.text = smartButtonTxt
        btnLoadingAnimator?.pause()
        ivLoading.visibility = View.GONE
        smartButton.isClickable = true
    }

    fun setOnClickListener(onClickListenerNow: ((smartButton:View) -> Unit)? = null) {
        this.onClickListener = onClickListenerNow
    }
}




