package kr.rinc.apicreator.activity

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_project_list.*
import kr.rinc.apicreator.R
import kr.rinc.apicreator.util.GlideUtil

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
    }

    private fun getProjectList() {

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