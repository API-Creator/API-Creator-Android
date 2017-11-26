package kr.rinc.apicreator.network


import android.annotation.SuppressLint
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@SuppressLint("StaticFieldLeak")
object RetroInit {
  val networkList: NetworkList
  private val SERVER_URL: String = "http://api.rinc.kr"

  init {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    val client = OkHttpClient.Builder().addNetworkInterceptor(interceptor).build()
    val gson = GsonBuilder()
        .setLenient()
        .create()
    val retrofit = Retrofit.Builder()
        .baseUrl(SERVER_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    networkList = retrofit.create(NetworkList::class.java)
  }
}