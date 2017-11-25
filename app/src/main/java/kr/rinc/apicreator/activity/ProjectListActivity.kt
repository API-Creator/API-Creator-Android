package kr.rinc.apicreator.activity

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_project_list.*
import kr.rinc.apicreator.R
import kr.rinc.apicreator.adapter.ProjectListAdapter
import kr.rinc.apicreator.model.getProjectObj
import kr.rinc.apicreator.network.RetroInit
import kr.rinc.apicreator.util.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by young on 2017-10-30/오후 11:15
 * This Project is APICreator
 */
class ProjectListActivity : BaseActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_project_list)
    setImage()
    setBtnAction()
    getProjectList()
    projectAddImg.setOnClickListener {
      IntentUtil.moveAct(this, ProjectAddActivity::class.java)
    }
    search.setOnClickListener {
      ToastUtil.showToast(this@ProjectListActivity, "asdf")
    }
  }

  private fun getProjectList() {
    //SharedUtil.getToken(this@ProjectListActivity)
    RetroInit.networkList.getProjects("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZHgiOjMsImlkIjoiVGVzdEFjY291bnQiLCJuaWNrIjoiVEVTVCIsInJhbmsiOjMsImlhdCI6MTUwOTk4MjA1OX0.ca4huaT_iV9eWoLOlg5MmSjQRqxJExGCfR-IPsIB8ig").enqueue(object : Callback<getProjectObj> {
      override fun onResponse(call: Call<getProjectObj>?, response: Response<getProjectObj>?) {
        if (response!!.isSuccessful) {
          ToastUtil.showToast(this@ProjectListActivity, "Success!")
          response.code()
          response.body().run {
            Log.d("list", this!!.status)
            Log.d("list response", projects[0].title)
            val layoutManager = GridLayoutManager(this@ProjectListActivity, 1)
            layoutManager.orientation = GridLayoutManager.VERTICAL
            recycler.layoutManager = layoutManager
            recycler.adapter = ProjectListAdapter(this@ProjectListActivity, response.body()!!)
          }
        } else {
          ToastUtil.showToast(this@ProjectListActivity, "Client Error!")
        }
      }

      override fun onFailure(call: Call<getProjectObj>?, t: Throwable?) {
        ToastUtil.showToast(this@ProjectListActivity, "서버와 연결에 실패했습니다")
        t!!.printStackTrace()
      }

    })
  }

  private fun setImage() {
    GlideUtil.setGliding(this, R.drawable.logo_icon_only, logo)
    GlideUtil.setGliding(this, R.drawable.project_create_icon, projectAddImg)
    GlideUtil.setGliding(this, R.drawable.profile_img, profile)
    GlideUtil.setGliding(this, R.drawable.search_icon, search)
  }

  private fun setBtnAction() {

  }
}