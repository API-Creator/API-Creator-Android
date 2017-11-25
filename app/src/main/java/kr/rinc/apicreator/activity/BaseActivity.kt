package kr.rinc.apicreator.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kr.rinc.apicreator.util.ActivityUtil

/**
 * Created by young on 2017-10-21/오전 1:38
 * This Project is APICreator
 */
open class BaseActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    ActivityUtil.setStatusBarColor(window, "#F5F5F5")
  }
}