# bug-report-windowmanager-dialog

反馈一个bug 在项目中使用LoadingDialog时发现的  最初是在小米手机上发现的 小米各个机型都能触发 最近试了下在华为荣耀9X上也能复现 问题也算挺严重的 主要集中在Dialog和WindowManager上

操作步骤：
1. 使用Dialog 展示一段时间后hide掉 或者 直接使用WindowManager.addView(View var1, LayoutParams var2)方法向WindowManager里面添加一个view 展示一段时间后gone掉
2. 在网页端发送一个验证码短信  收到时在顶部弹窗点击复制按钮

结果：
之前被隐藏掉的Dialog/View会被显示出来（由于该Dialog目前的状态其实仍然是隐藏状态，只是Dialog.mWindow.dectorView的visibility状态被修改了 所以按返回键无法隐藏该Dialog 基本等于无法操作App 等于应用卡死（虽然其实没卡死））
