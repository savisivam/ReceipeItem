package com.example.receipeitem

import android.telecom.Call
import okhttp3.ResponseBody
import retrofit2.http.GET

interface ApiClient {                         //http://192.168.1.88:5005/
    @GET("api/v1/compare/list/categories?api_key=66g87FrMlv0eOx1z2G5FsGnkl1s29NEGUNm&page=1")
    fun getdata(): retrofit2.Call<ResponseBody>
}