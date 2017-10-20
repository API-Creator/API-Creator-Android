package kr.rinc.apicreator.util

import android.content.Context
import android.widget.Toast

/**
 * Created by young on 2017-10-21/오전 2:27
 * This Project is APICreator
 */
object ToastUtil {
    fun showToast(context: Context, text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
}