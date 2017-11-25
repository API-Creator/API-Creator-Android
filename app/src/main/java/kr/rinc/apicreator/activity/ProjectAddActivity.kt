package kr.rinc.apicreator.activity

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_project_add.*
import kr.rinc.apicreator.R
import kr.rinc.apicreator.util.GlideUtil

/**
 * Created by geniusk on 2017. 11. 25..
 */

class ProjectAddActivity : BaseActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_project_add)
    setImage()
    setBtnAction()
  }

  private fun setImage() {
    GlideUtil.setGliding(this@ProjectAddActivity, R.drawable.back_btn, back)
  }

  private fun setBtnAction() {
    back.setOnClickListener {
      finish()
    }
  }
}