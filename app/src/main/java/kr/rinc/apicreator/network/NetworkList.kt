package kr.rinc.apicreator.network

import kr.rinc.apicreator.model.Status
import kr.rinc.apicreator.model.getProjectObj
import retrofit2.Call
import retrofit2.http.*


interface NetworkList {
  @POST("/a.php")
  @FormUrlEncoded
  fun getProjects(@Field("token") token: String, @Field("token2") test: String = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZHgiOjMsImlkIjoiVGVzdEFjY291bnQiLCJuaWNrIjoiVEVTVCIsInJhbmsiOjMsImlhdCI6MTUwOTk4MjA1OX0.ca4huaT_iV9eWoLOlg5MmSjQRqxJExGCfR-IPsIB8ig"): Call<getProjectObj>

  @POST("/addProject.php")
  @FormUrlEncoded
  fun addProject(@Field("token") token: String,
                 @Field("url") url: String,
                 @Field("title") title: String,
                 @Field("description") description: String,
                 @Field("invited") invited: String): Call<Status>
}