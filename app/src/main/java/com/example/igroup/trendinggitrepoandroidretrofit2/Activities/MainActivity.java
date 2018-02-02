package com.example.igroup.trendinggitrepoandroidretrofit2.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.igroup.trendinggitrepoandroidretrofit2.Pojo.Repositories;
import com.example.igroup.trendinggitrepoandroidretrofit2.R;
import com.example.igroup.trendinggitrepoandroidretrofit2.Retrofit.ApiUtils;
import com.example.igroup.trendinggitrepoandroidretrofit2.Retrofit.GitRepositories;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcv_repositories;
    public GitRepositories gitRepositories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gitRepositories = ApiUtils.getGitRepositories();
        rcv_repositories=(RecyclerView)findViewById(R.id.rcv_repositories);

        gitRepositories.getRepositories().enqueue(new Callback<Repositories>() {
            @Override
            public void onResponse(Call<Repositories> call, Response<Repositories> response) {
                if (response.isSuccessful())
                {
                    System.out.println(response.toString()+"-->"+response.body().getItems().get(0).getFullName());
                }
                else
                {
                    System.out.println("Error code:"+response.code());
                }
            }

            @Override
            public void onFailure(Call<Repositories> call, Throwable t) {
                System.out.println("Error loading from API"+t.toString());
            }
        });

        loadRepositories();
    }

    private void loadRepositories() {

    }
}
