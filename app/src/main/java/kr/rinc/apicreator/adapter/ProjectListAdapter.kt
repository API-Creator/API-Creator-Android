package kr.rinc.apicreator.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recycler_project_list.view.*
import kr.rinc.apicreator.R
import kr.rinc.apicreator.holder.GridViewHolder
import kr.rinc.apicreator.model.getProjectObj
import kr.rinc.apicreator.util.GlideUtil
import kr.rinc.apicreator.util.SharedUtil

/**
 * Created by young on 2017-10-31/오후 7:34
 * This Project is APICreator
 */
class ProjectListAdapter(private val context: Context, private val gson: getProjectObj) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
    val viewHolder: RecyclerView.ViewHolder
    val view = LayoutInflater.from(context).inflate(R.layout.recycler_project_list, parent, false)
    viewHolder = GridViewHolder(view)
    return viewHolder
  }

  override fun getItemCount(): Int = gson.projects.size

  @SuppressLint("SetTextI18n")
  override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
    //todo
    val gridViewHolder = holder as GridViewHolder
    val item = gson.projects[position]
    val itemView = gridViewHolder.itemView
    itemView.projectTitle.text = item.title
    itemView.projectPM.text = "PM By " + item.owner
    Log.d("list: ", item.title)
    //Admin Check
    if (item.idx === SharedUtil.getIdx(context)) {
      GlideUtil.setGliding(context, R.drawable.edit_btn_w, itemView.projectEditImg)
      GlideUtil.setGliding(context, R.drawable.delete_btn_w, itemView.projectDeleteImg)
      itemView.projectAdminView.visibility = View.VISIBLE
      itemView.projectInfoBtn.visibility = View.GONE
    } else {
      GlideUtil.setGliding(context, R.drawable.info_btn_w, itemView.projectInfoImg)
      itemView.projectAdminView.visibility = View.GONE
      itemView.projectInfoBtn.visibility = View.VISIBLE
    }
  }
}