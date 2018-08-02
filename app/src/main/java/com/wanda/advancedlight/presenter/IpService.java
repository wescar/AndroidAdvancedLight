package com.wanda.advancedlight.presenter;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by PC on 2018/8/2.
 */

public interface IpService {
    @GET("blog/{id}") //这里的{id} 表示是一个变量
    Call<ResponseBody> getBlog(@Path("id") int id);
}
