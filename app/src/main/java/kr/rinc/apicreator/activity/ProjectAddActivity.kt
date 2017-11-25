package kr.rinc.apicreator.activity

import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_project_add.*
import kr.rinc.apicreator.R
import kr.rinc.apicreator.model.Status
import kr.rinc.apicreator.network.RetroInit
import kr.rinc.apicreator.util.GlideUtil
import kr.rinc.apicreator.util.ToastMessageList
import kr.rinc.apicreator.util.ToastUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
    projectAddBtn.setOnClickListener {
      RetroInit.networkList.addProject(
          "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZHgiOjMsImlkIjoiVGVzdEFjY291bnQiLCJuaWNrIjoiVEVTVCIsInJhbmsiOjMsImlhdCI6MTUwOTk4MjA1OX0.ca4huaT_iV9eWoLOlg5MmSjQRqxJExGCfR-IPsIB8ig",
          projectDomain.text.toString(),
          projectTitle.text.toString(),
          projectDescription.text.toString(),
          projectInvited.text.toString())
          .enqueue(object : Callback<Status> {
            override fun onResponse(call: Call<Status>?, response: Response<Status>?) {
              if (response!!.isSuccessful) {
                response.body()!!.apply {
                  Log.d("status : ", status)
                  if (status === "complate") {
                    ToastUtil.showToast(this@ProjectAddActivity, ToastMessageList.ProjectAddSuccess)
                  }
                }
              } else {
                ToastUtil.showToast(this@ProjectAddActivity, ToastMessageList.RetrofitClientError)
              }
            }

            override fun onFailure(call: Call<Status>?, t: Throwable?) {
              t!!.printStackTrace()
              ToastUtil.showToast(this@ProjectAddActivity, ToastMessageList.RetrofitServerError)
            }

          })
    }
  }
}