package com.example.igroup.trendinggitrepoandroidretrofit2.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by iGroup on 2/2/2018.
 */

public class RepositoriesAdapter extends RecyclerView.Adapter<RepositoriesAdapter.ViewHolder> {
    @Override
    public RepositoriesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RepositoriesAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
