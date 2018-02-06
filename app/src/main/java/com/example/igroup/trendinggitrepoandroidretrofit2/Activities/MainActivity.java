package com.example.igroup.trendinggitrepoandroidretrofit2.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import android.support.v4.app.Fragment;

import com.example.igroup.trendinggitrepoandroidretrofit2.Adapter.RepositoriesAdapter;
import com.example.igroup.trendinggitrepoandroidretrofit2.Fragments.Fragment_RepoDetail;
import com.example.igroup.trendinggitrepoandroidretrofit2.Pojo.Item;
import com.example.igroup.trendinggitrepoandroidretrofit2.Pojo.Repositories;
import com.example.igroup.trendinggitrepoandroidretrofit2.R;
import com.example.igroup.trendinggitrepoandroidretrofit2.Retrofit.ApiUtils;
import com.example.igroup.trendinggitrepoandroidretrofit2.Retrofit.GitRepositories;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcv_repositories;
    public GitRepositories gitRepositories;
    private RepositoriesAdapter repositoriesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gitRepositories = ApiUtils.getGitRepositories();
        rcv_repositories=(RecyclerView)findViewById(R.id.rcv_repositories);

        repositoriesAdapter = new RepositoriesAdapter(new ArrayList<Item>(0), MainActivity.this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rcv_repositories.setLayoutManager(layoutManager);
        rcv_repositories.setAdapter(repositoriesAdapter);
        rcv_repositories.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcv_repositories.addItemDecoration(itemDecoration);



        loadRepositories();
    }

    private void loadRepositories() {

        gitRepositories.getRepositories().enqueue(new Callback<Repositories>() {
            @Override
            public void onResponse(Call<Repositories> call, Response<Repositories> response) {
                if (response.isSuccessful())
                {
                    repositoriesAdapter.updateRepositories(response.body().getItems());
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

    }
}
