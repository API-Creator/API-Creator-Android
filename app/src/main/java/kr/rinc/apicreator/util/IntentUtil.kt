package kr.rinc.apicreator.util

import android.content.Intent
import kr.rinc.apicreator.activity.BaseActivity

/**
 * Created by young on 2017-10-30/오후 11:26
 * This Project is APICreator
 */
object IntentUtil {
  //기존의 액티비티를 보존하고 이동
  fun moveAct(activity: BaseActivity, cls: Class<*>) {
    activity.startActivity(Intent(activity, cls))
  }

  //기존의 액티비티를 제거하고 새로 띄운다
  fun newAct(activity: BaseActivity, cls: Class<*>) {
    activity.finish()
    activity.startActivity(Intent(activity, cls))
  }
}