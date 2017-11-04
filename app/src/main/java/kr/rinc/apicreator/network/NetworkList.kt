package kr.rinc.apicreator.network

import kr.rinc.apicreator.model.Login
import kr.rinc.apicreator.model.getProject
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface NetworkList {
    @POST("/getProjects.php")
    @FormUrlEncoded
    fun getProjects(@Field("token") token: String): Call<List<getProject>>
}