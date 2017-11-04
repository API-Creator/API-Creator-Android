package kr.rinc.apicreator.activity

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_project_list.*
import kr.rinc.apicreator.R
import kr.rinc.apicreator.adapter.ProjectListAdapter
import kr.rinc.apicreator.model.getProject
import kr.rinc.apicreator.network.RetroInit
import kr.rinc.apicreator.util.GlideUtil
import kr.rinc.apicreator.util.SharedUtil
import kr.rinc.apicreator.util.ToastUtil
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
    }

    private fun getProjectList() {
        RetroInit.networkList.getProjects(SharedUtil.getToken(this@ProjectListActivity)).enqueue(object : Callback<List<getProject>> {
            override fun onResponse(call: Call<List<getProject>>?, response: Response<List<getProject>>?) {
                if (response!!.isSuccessful) {
                    ToastUtil.showToast(this@ProjectListActivity, "Success!")
                    response.body().run {
                        Log.d("list response", title.toString())
                        val layoutManager = GridLayoutManager(this@ProjectListActivity, 1)
                        layoutManager.orientation = GridLayoutManager.VERTICAL
                        recycler.layoutManager = layoutManager
                        recycler.adapter = ProjectListAdapter(this@ProjectListActivity, response.body()!!)

                    }
                } else {
                    ToastUtil.showToast(this@ProjectListActivity, "Client Error!")
                }
            }

            override fun onFailure(call: Call<List<getProject>>?, t: Throwable?) {
                ToastUtil.showToast(this@ProjectListActivity, "서버와 연결에 실패했습니다")
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