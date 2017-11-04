package kr.rinc.apicreator.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * Created by young on 2017-11-05/오전 1:53
 * This Project is APICreator
 */
object SharedUtil {
    val TOKEN = "token"
    fun setToken(ctx: Context, token: String) {
        val editor = getSharedPreferences(ctx).edit()
        editor.putString(TOKEN, token)
        editor.apply()
    }

    fun getToken(ctx: Context): String {
        return getSharedPreferences(ctx).getString(TOKEN, "")
    }

    private fun getSharedPreferences(ctx: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(ctx)
    }
}