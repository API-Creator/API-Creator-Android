package kr.rinc.apicreator.activity

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kr.rinc.apicreator.R
import kr.rinc.apicreator.model.Login
import kr.rinc.apicreator.network.RincRetroInit
import kr.rinc.apicreator.util.ActivityUtil
import kr.rinc.apicreator.util.IntentUtil
import kr.rinc.apicreator.util.SharedUtil
import kr.rinc.apicreator.util.ToastUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ActivityUtil.setStatusBarColor(window, "#F5F5F5")
        changeEditBackground()
        setBtnAction()
    }

    private fun changeEditBackground() {
        idEdit.setOnFocusChangeListener { _, b ->
            if (b) {
                idEdit.setBackgroundResource(R.drawable.button_radius_100dp_on)
                idEdit.setHintTextColor(Color.parseColor("#101015"))
                idEdit.setTextColor(Color.parseColor("#101015"))
                pwEdit.setBackgroundResource(R.drawable.button_radius_100dp_off)
                pwEdit.setHintTextColor(Color.parseColor("#acacac"))
                pwEdit.setTextColor(Color.parseColor("#acacac"))
            }
        }
        pwEdit.setOnFocusChangeListener { _, b ->
            if (b) {
                idEdit.setBackgroundResource(R.drawable.button_radius_100dp_off)
                idEdit.setHintTextColor(Color.parseColor("#acacac"))
                idEdit.setTextColor(Color.parseColor("#acacac"))
                pwEdit.setBackgroundResource(R.drawable.button_radius_100dp_on)
                pwEdit.setHintTextColor(Color.parseColor("#101015"))
                pwEdit.setTextColor(Color.parseColor("#101015"))
            }
        }
    }

    private fun setBtnAction() {
        loginBtn.setOnClickListener {
            RincRetroInit.networkList.login(
                    idEdit.text.toString(),
                    pwEdit.text.toString())
                    .enqueue(object : Callback<Login> {
                        override fun onFailure(call: Call<Login>?, t: Throwable?) {
                            ToastUtil.showToast(this@LoginActivity, "서버 오류")
                        }

                        override fun onResponse(call: Call<Login>?, response: Response<Login>?) {
                            if (response!!.isSuccessful) {
                                response.body()!!.run {
                                    ToastUtil.showToast(this@LoginActivity, status.message)
                                    if (status.success === "true") {
                                        SharedUtil.setToken(this@LoginActivity, token)
                                        IntentUtil.newAct(this@LoginActivity, ProjectListActivity::class.java)
                                    }
                                }
                            } else {
                                Log.d("respoinse", response.body()!!.toString())
                                ToastUtil.showToast(this@LoginActivity, "클라이언트 오류")
                            }
                        }

                    })
        }
    }

}
