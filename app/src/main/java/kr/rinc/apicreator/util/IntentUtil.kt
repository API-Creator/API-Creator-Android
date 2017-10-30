package kr.rinc.apicreator.util

import android.content.Intent
import kr.rinc.apicreator.activity.BaseActivity

/**
 * Created by young on 2017-10-30/오후 11:26
 * This Project is APICreator
 */
object IntentUtil {
    fun moveAct(activity: BaseActivity, cls: Class<*>) {
        activity.startActivity(Intent(activity, cls))
    }

    fun newAct(activity: BaseActivity, cls: Class<*>) {
        activity.finish()
        activity.startActivity(Intent(activity, cls))
    }
}