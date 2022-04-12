package com.apeman.yruiwidget

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewTreeLifecycleOwner
import com.apeman.yruiwidget.databinding.ActivityLabelTextBinding
import com.apemans.yruibusiness.base.BaseComponentActivity
import com.apemans.yruibusiness.ui.toolbar.setToolbar
import com.dylanc.longan.lifecycleOwner
import com.dylanc.longan.toast

class LableTextIconActivity:BaseComponentActivity<ActivityLabelTextBinding>(){
    override fun onViewCreated(savedInstanceState: Bundle?) {
        setToolbar {
            title = resources.getString(R.string.title_label_text)
            leftIcon(R.drawable.ic_back) {
                finish()
            }
        }
        setupUI()
    }

    private fun setupUI() {
        with(binding) {
            labelTextDetailIconView.setupConfigure(lifecycleOwner)
            labelTextDetailSelectionView.setupConfigure(lifecycleOwner)
            labelTextDetailSwitchBtnView.setupConfigure(lifecycleOwner)
            labelTextIconView.setupConfigure(lifecycleOwner)
            labelTextInfoIconView.setupConfigure(lifecycleOwner)
            labelTextSelectionView.setupConfigure(lifecycleOwner)
            labelTextSwitchBtnView.setupConfigure(lifecycleOwner)

            labelTextIconView.updateUiState {
                it?.apply {
                    text = "标题"
                }
            }
            labelTextDetailIconView.updateUiState {
                it?.apply {
                    text = "正标题"
                    detailText = "副标题"
                    subTextColor = R.color.theme_sub_text_color
                    leftIconVisibility = View.VISIBLE

                }
            }
            labelTextInfoIconView.updateUiState {
                it?.apply {
                    text = "正标题"
                    subText = "副文"
                }
            }

            labelTextSwitchBtnView.updateUiState {
                it?.apply {
                    text ="标题"
                }
            }
            labelTextDetailSwitchBtnView.updateUiState {
                it?.apply {
                    text = "正标题"
                    detailText = "副标题"
                    switchOn = true
                }
            }
            labelTextSelectionView.updateUiState {
                it?.apply {
                    text = "正标题"
                    selection1 = "selection1"
                    selection2 = "selection2"
                    selection3 = "selection3"
                }
            }
            labelTextDetailSelectionView.updateUiState {
                it?.apply {
                    text = "正标题"
                    detailText = "副标题"
                    selection1 = "selection1"
                    selection2 = "selection2"
                    selection3 = "selection3"
                }
            }
        }
    }


}