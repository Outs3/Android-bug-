package com.outs.test.testdialog

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.setPadding

/**
 * author: Outs3
 * e-mail: 3.3nosekai@gmail.com
 * date: 2022/2/14 13:30
 * desc:
 */
private fun newTextView(context: Context) = TextView(context).apply {
    text = "测试弹窗"
    textSize = 17f
    setTypeface(Typeface.DEFAULT, Typeface.BOLD)
    setBackgroundColor(Color.RED)
    setTextColor(Color.WHITE)
    setPadding(30)
}

fun injectBugByWindowManager(context: Context) {
    val view = newTextView(context)
    val layoutParams = WindowManager.LayoutParams(WindowManager.LayoutParams.TYPE_APPLICATION)
    val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    windowManager.addView(view, layoutParams)
    view.postDelayed({ view.visibility = View.GONE }, 2000)
    view.setOnClickListener {
        Toast.makeText(context, "你点击了我，可见度：${it?.visibility}", Toast.LENGTH_LONG).show()
        windowManager.removeView(it)
    }
}