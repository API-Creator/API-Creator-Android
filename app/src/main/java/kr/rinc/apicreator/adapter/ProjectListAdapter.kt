package kr.rinc.apicreator.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kr.rinc.apicreator.R
import kr.rinc.apicreator.holder.GridViewHolder
import kr.rinc.apicreator.model.Login

/**
 * Created by young on 2017-10-31/오후 7:34
 * This Project is APICreator
 */
class ProjectListAdapter(private val context: Context, private val gson: List<Login>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder: RecyclerView.ViewHolder
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_project_list, parent, false)
        viewHolder = GridViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return gson.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        //todo
    }
}