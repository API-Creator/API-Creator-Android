package kr.rinc.apicreator.activity

import android.os.Bundle
import kr.rinc.apicreator.R
import kr.rinc.apicreator.util.ActivityUtil

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ActivityUtil.setStatusBarColor(window,"#00000000")
        changeEditBackground()
        setBtnAction()
    }
    fun changeEditBackground() {

    }
    fun setBtnAction() {

    }

}
