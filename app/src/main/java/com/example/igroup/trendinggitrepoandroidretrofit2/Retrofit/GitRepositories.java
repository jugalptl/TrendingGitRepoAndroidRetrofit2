package com.example.igroup.trendinggitrepoandroidretrofit2.Retrofit;

import com.example.igroup.trendinggitrepoandroidretrofit2.Pojo.Repositories;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by iGroup on 2/2/2018.
 */

public interface GitRepositories {
    @GET("repositories?q=stars:%3E=500%20fork:true%20language:android&sort=stars&order=desc")
    Call<Repositories> getRepositories();
    /*@GET("/repositories?sort=stars&order=desc")
    Call<Repositories> getRepositories(@Query(""));
    */
}
