package kr.rinc.apicreator.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by young on 2017-10-30/오후 11:20
 * This Project is APICreator
 */
object GlideUtil {
    fun setGliding(context: Context, img: Int, view: ImageView) {
        Glide.with(context).load(img).into(view)
    }
}