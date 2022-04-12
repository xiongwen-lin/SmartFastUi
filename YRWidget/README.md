```
    UI快速开发工具库
```

##### [![Join the chat at https://gitter.im/alibaba/ARouter](https://badges.gitter.im/alibaba/ARouter.svg)](https://gitlab.apeman.com.cn/sz/app/android/pro/FastUIComponent) [![Hex.pm](https://img.shields.io/hexpm/l/plug.svg)](https://www.apache.org/licenses/LICENSE-2.0)

---

#### 最新版本

模块|FastUIComponent
---|---
最新版本|1.0.0

#### Demo展示：
https://www.pgyer.com/YRWidget
![enter image description here](https://www.pgyer.com/app/qrcode/YRWidget)

##### [Demo 仓库（develop分支)](https://gitlab.apeman.com.cn/sz/app/android/pro/FastUIProject)
<!-- 、[Demo Gif](https://raw.githubusercontent.com/alibaba/ARouter/master/demo/arouter-demo.gif) -->

##### SuperToolbar 导航栏
##### MultiType -- 使用集成： 'com.drakeet.multitype:multitype:4.3.0' https://github.com/drakeet/MultiType
##### MultiTypeKTX 使用参考：https://github.com/DylanCaiCoding/MultiTypeKTX
##### SwitchButton https://github.com/zcweng/SwitchButton
##### stateLayout https://github.com/liangjingkanji/StateLayout

#### 一、功能介绍
1. **支持常用控件封装**
2. **项目采用kotlin语言开发**


#### 二、典型应用
1. app开发需要使用常用控件

#### 三、基础功能
1. 添加依赖和配置
    ```
    dependencies {
        // 导入依赖
        implementation ("com.apemans:YRWidget:+")
    }
    ```

2. 初始化SDK

   注意： Application下配置labelText全局属性：
    ```
     private fun initThemeConfigure() {
        GlobalLabelTextConfigure.apply {
            textColor = R.color.theme_text_color
            subTextColor = R.color.theme_sub_text_color
            detailTextColor =  R.color.theme_sub_text_color
            selectionOnColor = R.color.theme_color
            selectionOffColor = R.color.theme_sub_text_color
        }

    }

    ```

3. 控件使用示例

--------------------------------------------------------------- 3.1按钮SmartButton----------------------------------

 xml布局:


      <com.apemans.quickui.button.SmartButton
            android:id="@+id/btnNormal"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:text="next"
            />

    使用参考
      1.1 初始化不可点击
             btnNormal.isEnabled = false
      1.2 点击动画，展示加载
             btnNormal.setOnClickListener {
                  btnNormal.showLoadingBtn()
              }
      1.3 动画消失
             btnNormal.hideLoadingBtn()

 按钮使用的背景色：button_normal_state_list
    注意 text：不是~~android:text~~，而是 *** app:text***





----------------------------------------------------------- 3.2文本标签LabelText控件---------------------------------


    1）文本标签控件
    ``` xml
    <com.osiao.quickui.label.LabelTextDetailSelectionView
        android:id="@+id/ltTe"
        android:layout_width="@dimen/dp_0"
        android:layout_height="wrap_content"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        />
    ``` xml
    ```
    请先通过GlobalLabelTextConfigure配置全局样式属性
    ```
    ``` kotlin
    /**
     * 文本标签控件有等，使用方法一致。
     * LabelTextConfigure 控件配置数据模型
     * text 主文本 适用所有控件
     * subText 副文本 适用LabelTextInfoIconView控件
     * detailText 详细文本 适用LabelTextDetailIconView、LabelTextDetailSwitchBtnView、LabelTextDetailSelectionView控件
     * textColor 主文本字体颜色 适用所有控件
     * leftIconRes 文本标签开始图标 适用LabelTextIconView、LabelTextInfoIconView、LabelTextDetailIconView控件
     * leftIconVisibility 文本标签开始图标显示 适用LabelTextIconView、LabelTextInfoIconView、LabelTextDetailIconView控件
     * rightIconRes 文本标签末尾图标 适用LabelTextIconView、LabelTextInfoIconView、LabelTextDetailIconView控件
     * rightIconVisibility 文本标签末尾图标显示 适用LabelTextIconView、LabelTextInfoIconView、LabelTextDetailIconView控件
     * switchOn 文本标签开关按钮状态 适用LabelTextSwitchBtnView、LabelTextDetailSwitchBtnView控件
     * selection1 文本标签单选或多选按钮文本（空间排序从左到右） 适用LabelTextSelectionView、LabelTextDetailSelectionView控件
     * selection2
     * selection3
     * selectionOnColor 文本标签单选或多选按钮文本选中颜色 适用LabelTextSelectionView、LabelTextDetailSelectionView控件
     * selectionOffColor 文本标签单选或多选按钮文本未选中颜色 适用LabelTextSelectionView、LabelTextDetailSelectionView控件
     * selectionIndex 文本标签单选或多选按钮文本选中索引 适用LabelTextSelectionView、LabelTextDetailSelectionView控件
     * 下面以LabelTextDetailSelectionView作为使用示例
     */
    var bingdingltTe : LabelTextDetailSelectionView
    //在获取实例后，立即调用setupConfigure，否则更新uiState时，页面无法更新
    bindingltTe.setupConfigure(this)
    bindingltTe.updateUiState {
        it?.apply {
            text = "666"
            subText = "777"
            detailText = "dddddddddd"
            //textColor = R.color.theme_sub_text_color
            //leftIconRes = 0
            //leftIconVisibility = View.VISIBLE
            //rightIconRes = R.drawable.ic_back
            //rightIconVisibility = View.VISIBLE
            switchOn = false
            selection1 = "ir"
            selection2 = "off"
            //selection3 = "auto"
            selectionIndex = LABEL_SELECTION_2
        }
    }
    //控件监听器
    bindingltTe.mListener = { switchOn ->
        YRLog.d { "-->> debug test label switch on $switchOn" }
    }
    ```
    2）ShapeViewButton Simple、SuperToolbar Simple
    ``` xml
    // 1. 请求全球服务器时间接口调用示例
    <com.hjq.shape.view.ShapeTextView
        android:id="@+id/btnDone"
        style="@style/theme_shape_button_style"
        android:layout_width="0dp"
        android:layout_marginStart="@dimen/dp_60"
        android:layout_marginEnd="@dimen/dp_60"
        android:text="@string/ez_flash"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="@+id/guideline0" />

    <com.osiao.quickui.SuperToolbar
        android:id="@+id/superToolbar"
        android:layout_width="match_parent"
        android:layout_height="@dimen/theme_toolbar_height"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:superToolbar_bottomLineColor="@color/theme_line_color"
        app:superToolbar_navIcon="@drawable/ic_back"
        app:superToolbar_showBottomLine="true"
        app:superToolbar_title="@string/about"
        app:superToolbar_titleSize="?theme_text_size"
        app:superToolbar_titleTextColor="?theme_text_color" />
    ```

---------------------------------------SmartDialog对话框--------------------------------------

   快速集成：


       ```
     SmartDialog.build(supportFragmentManager)
                //.setHeadImageUrl(R.drawable.common_ic_default_preview) //顶部状态图标
                //.setCenterImage(R.drawable.common_ic_default_preview)//中间插画
                //.showEditBox(true,showKeyboard = true, "Set Params")//输入框
                //.showRemind(true,"别再弹窗了")     //复选框
                .setTitle("对话框标题")
                .setContentText(resources.getString(R.string.feedback_confirm_feedback))
                .setPositiveTextName(resources.getString(R.string.confirm))
                .setNegativeTextName(resources.getString(R.string.cancel))
                .setOnPositive {
                    it.dismiss()
                }.setOnNegative {
                    it.dismiss()
                }.show()
```

详细集成：


```kotlin

        //显示在view底部+显示提示
        SmartDialog.build(childFragmentManager) {
                width = requireContext().screenWidthPx - DisplayHelper.dpToPx(20) * 2
                offsetY = -DisplayHelper.getStatusBarHeight()
                //unLeak = true
        }.setThemeStyle(DialogStyle.IOS_STYLE)
        .showRemind(true)
        .setTitle("Lorem ipsum")
        .setContentText(getString(R.string.lorem))
        .setHeadImage(R.drawable.ic_congrts)
        .setPositiveTextName("i know")
        .setOnPositive {
            it.dismissAllowingStateLoss()
        }
        .setOnRemindEvent {
            Log.i("Dialog", "checked = $it")
        }.showOnView(
            binding.btnStyleViewBottom,
            DialogGravity.CENTER_BOTTOM,
            R.style.ScaleOverShootEnterExitAnimationX50Y0
        )

        //不再提示
        SmartDialog.build(childFragmentManager) {
                    //设置横纵向占满
                    //isFullHorizontal = true
            }
             .setThemeStyle(DialogStyle.IOS_STYLE)
             .showRemind(true)
             .setTitle("Lorem ipsum")
             .setContentText(getString(R.string.lorem))
             .setHeadImage(R.drawable.ic_congrts)
             .setPositiveTextName("i know")
             .setOnPositive {
                 it.dismissAllowingStateLoss()
             }
             .setOnRemindEvent {
                Log.i("Dialog", "checked = $it")
             }
             .addShowOnDialogShow {
                Toast.makeText(requireContext(), "Show", Toast.LENGTH_SHORT).show()
             }
             .addShowOnDialogDismiss {
                Toast.makeText(requireContext(), "Dismiss", Toast.LENGTH_SHORT).show()
             }
             .show()
        //标题+子标题
        SmartDialog.build(childFragmentManager)
                .setThemeStyle(DialogStyle.IOS_STYLE)
                .setTitle("Lorem ipsum")
                .setContentText(getString(R.string.lorem))
                //.setHeadImage(R.drawable.ic_congrts)
                .setPositiveTextName("save")
                .setNegativeTextName("cancel")
                .setOnPositive {
                    it.dismissAllowingStateLoss()
                }
                .setOnNegative {
                    it.dismissAllowingStateLoss()
                }
                .showOnWindow(
                    childFragmentManager,
                    DialogGravity.CENTER_TOP,
                    R.style.AlphaEnterExitAnimation
                )

        //选择菜单
         val dataItems = mutableListOf<SmartSelectDialog.Item>()
                    val item01 = SmartSelectDialog.Item("Item 下拉菜单")
                    val item02 = SmartSelectDialog.Item("Item 下拉菜单")
                    val item03 = SmartSelectDialog.Item("Item 下拉菜单")
                    val item04 = SmartSelectDialog.Item("Item 下拉菜单")
                    val item05 = SmartSelectDialog.Item("Item 下拉菜单")
                    val item06 = SmartSelectDialog.Item("Item 下拉菜单")
                    val item07 = SmartSelectDialog.Item("Item 下拉菜单")
                    val item08 = SmartSelectDialog.Item("Item 下拉菜单")
                    val item09 = SmartSelectDialog.Item("Item 下拉菜单")
                    val item10 = SmartSelectDialog.Item("Item 下拉菜单")
                    dataItems.add(item01)
                    dataItems.add(item02)
                    dataItems.add(item03)
                    dataItems.add(item04)
                    dataItems.add(item05)
                    dataItems.add(item06)
                    dataItems.add(item07)
                    dataItems.add(item08)
                    dataItems.add(item09)
                    dataItems.add(item10)

                    SmartSelectDialog.build(childFragmentManager) {
                        width = requireContext().screenWidthPx - DisplayHelper.dpToPx(20) * 2
                        offsetY = -DisplayHelper.getStatusBarHeight()
                    }
                        .setItemData(dataItems)
                        .setItemTextColor(R.color.black)
                        .setItemTextFocusColor(R.color.purple_500)
                        .showFocusChoose(true)
                        .showFocusItemPosition(1)
                        .showItemSize(5)
                        .setItemNameGravity(Gravity.CENTER or Gravity.CENTER_VERTICAL)
                        .setOnSelectItem { position, item ->

                        }
                        .setCanAbleDismiss(true)
                        .showOnView(
                            binding.btnStyle05,
                            DialogGravity.CENTER_BOTTOM
                        )
         //or
         val dataItems = mutableListOf<SmartSelectDialog.Item>()
                     val item01 = SmartSelectDialog.Item("Item 01", R.drawable.ic_congrts)
                     val item02 = SmartSelectDialog.Item("Item 02", R.drawable.ic_congrts)
                     val item03 = SmartSelectDialog.Item("Item 03", R.drawable.ic_congrts)
                     val item04 = SmartSelectDialog.Item("Item 04", R.drawable.ic_congrts)
                     val item05 = SmartSelectDialog.Item("Item 05", R.drawable.ic_congrts)
                     val item06 = SmartSelectDialog.Item("Item 06", R.drawable.ic_congrts)
                     dataItems.add(item01)
                     dataItems.add(item02)
                     dataItems.add(item03)
                     dataItems.add(item04)
                     dataItems.add(item05)
                     dataItems.add(item06)
                     SmartSelectDialog.build(childFragmentManager) {
                         width = requireContext().screenWidthPx - DisplayHelper.dpToPx(20) * 2
                         //offsetY = -DisplayHelper.getStatusBarHeight()
                     }
                         .setItemData(dataItems)
                         .setItemTextColor(R.color.black)
                         .setItemTextFocusColor(R.color.purple_500)
                         .showFocusChoose(true)
                         .showFocusItemPosition(1)
                         .setItemNameGravity(Gravity.CENTER or Gravity.CENTER_VERTICAL)
                         .setOnSelectItem { position, item ->

                         }
                         //.setTitle("Please select your sex like") //显示Title
                         //.setHeadImage(R.drawable.ic_congrts) //显示Header标题
                         .setCanAbleDismiss(true)
                         //.show()
                         .show(childFragmentManager, "select")



         //头像选择
          AvatarSelectDialog().configTextValues(
                         "take a photo",
                         "from album",
                         "cancel"
                     )
                         .show(requireContext(), childFragmentManager, cancel = {

                         }, takePhoto = {

                         }, select = {

                         })

          //顶部弹出提示
          SmartDialog.build(childFragmentManager) {
                          //设置竖直方向的margin
                          verticalMargin = dp2px(requireContext(), 10).toFloat()
                      }
                          .setContentText(getString(R.string.lorem))
                          .setHeadImage(R.drawable.ic_pop_prompt)
                          .setNegativeTextName("i know")
                          .setOnNegative {
                              it.dismissAllowingStateLoss()
                          }
                          .show(DialogGravity.CENTER_TOP)

          //固件升级
          SmartDialog.build(childFragmentManager)
                          .showRemind(true)
                          .setHeadImage(R.drawable.illus_upgrade_illus)
                          .setTitle("New version: 1.4.2")
                          .setContentText(getString(R.string.lorem))
                          .setPositiveTextName("Upgrade")
                          .setNegativeTextName("Cancel")
                          .setOnPositive {
                              it.dismissAllowingStateLoss()
                          }
                          .setOnNegative {
                              it.dismissAllowingStateLoss()
                          }
                          .show()

          //带输入框的Dialog
          SmartDialog.build(childFragmentManager)
                          .setTitle("Name the group")
                          .showEditBox(show = true, showKeyboard = true, "Light group name")
                          .setPositiveTextName("Save")
                          .setNegativeTextName("Cancel")
                          .setOnPositive {
                              //it.dismissAllowingStateLoss()
                              //it.getEditBox()?.startShakeAnimation()
                              val text = it.getEditBox().getText()
                              Log.i("InputText", text)
                              it.getEditBox().showTips("Hello Tips")
                          }
                          .addEditBoxInputChangeListener { smartEditBox, textChanged ->
                              if (textChanged == "Hello") {
                                  smartEditBox.showError("Please input correct", true)
                              }
                          }
                          .setOnNegative {
                              it.dismiss()
                          }
                          .addShowOnDialogShow {
                              Toast.makeText(requireContext(), "Show", Toast.LENGTH_SHORT).show()
                          }
                          .addShowOnDialogDismiss {
                              Toast.makeText(requireContext(), "Dismiss", Toast.LENGTH_SHORT).show()
                          }
                          .show()
```



  四. 添加混淆规则(如果使用了Proguard)
    ```
   无
    ```


#### 五、其他

1. 沟通和交流

    1. 维护：独角鲸 : 邮箱：zhengruidong@apemans.com  东北虎 : 邮箱：wumaojie@apemans.com