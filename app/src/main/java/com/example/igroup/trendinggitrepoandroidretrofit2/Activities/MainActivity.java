package com.example.igroup.trendinggitrepoandroidretrofit2.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.igroup.trendinggitrepoandroidretrofit2.R;
import com.example.igroup.trendinggitrepoandroidretrofit2.Retrofit.ApiUtils;
import com.example.igroup.trendinggitrepoandroidretrofit2.Retrofit.GitRepositories;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcv_repositories;
    private GitRepositories gitRepositories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gitRepositories = ApiUtils.getGitRepositories();
        rcv_repositories=(RecyclerView)findViewById(R.id.rcv_repositories);
    }
}
