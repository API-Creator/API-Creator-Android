package kr.rinc.apicreator.util

import android.graphics.Color
import android.view.Window
import android.view.WindowManager

/**
 * Created by young on 2017-10-21/오전 1:40
 * This Project is APICreator
 */
object ActivityUtil {
    @android.annotation.SuppressLint("InlinedApi")
    fun setStatusBarColor(window: Window, colorCode: String) {
        window.run {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                statusBarColor = Color.parseColor(colorCode)
            }
        }
    }
}