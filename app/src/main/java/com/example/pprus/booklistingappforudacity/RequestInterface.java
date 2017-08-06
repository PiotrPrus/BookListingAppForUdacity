package com.example.pprus.booklistingappforudacity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Piotr Prus on 01.08.2017.
 */

public interface RequestInterface {

    @GET("volumes")
    Call<JSONResponse> getJSON(@Query("q") String id);
}
