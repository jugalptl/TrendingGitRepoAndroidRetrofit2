package com.example.igroup.trendinggitrepoandroidretrofit2.Retrofit;

/**
 * Created by iGroup on 2/2/2018.
 */

public class ApiUtils {
    public static final String BASE_URL="https://api.github.com/search/";
    public static GitRepositories getGitRepositories(){
        return RetrofitClient.getClient(BASE_URL).create(GitRepositories.class);
    }
}
