package kr.rinc.apicreator.network

import kr.rinc.apicreator.model.Login
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


interface NetworkList {
    @POST("/sign")
    @FormUrlEncoded
    fun login(@Field("id") id: String, @Field("pw") pw: String): Call<Login>
}