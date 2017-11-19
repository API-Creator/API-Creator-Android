package kr.rinc.apicreator.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * Created by young on 2017-11-05/오전 1:53
 * This Project is APICreator
 */
object SharedUtil {
  private val TOKEN = "token"
  private val IDX = "idx"

  fun getToken(ctx: Context): String = getSharedPreferences(ctx).getString(TOKEN, "")

  fun setToken(ctx: Context, token: String) {
    val editor = getSharedPreferences(ctx).edit()
    editor.putString(TOKEN, token)
    editor.apply()
  }

  fun getIdx(ctx: Context): String = getSharedPreferences(ctx).getString(IDX, "")

  fun setIdx(ctx: Context, token: String) {
    val editor = getSharedPreferences(ctx).edit()
    editor.putString(IDX, token)
    editor.apply()
  }

  private fun getSharedPreferences(ctx: Context): SharedPreferences {
    return PreferenceManager.getDefaultSharedPreferences(ctx)
  }
}