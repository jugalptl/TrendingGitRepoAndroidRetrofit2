package com.example.igroup.trendinggitrepoandroidretrofit2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.igroup.trendinggitrepoandroidretrofit2.Activities.MainActivity;
import com.example.igroup.trendinggitrepoandroidretrofit2.Activities.RepoDetailActivity;
import com.example.igroup.trendinggitrepoandroidretrofit2.Fragments.Fragment_RepoDetail;
import com.example.igroup.trendinggitrepoandroidretrofit2.Pojo.Item;

import java.util.List;

/**
 * Created by iGroup on 2/5/2018.
 */

public class RepositoriesAdapter extends RecyclerView.Adapter<RepositoriesAdapter.ViewHolder> {

    private List<Item> items ;
    private MainActivity context;


    public RepositoriesAdapter(List<Item> repos, MainActivity cntxt)//,PostItemListener itemListener)
    {
            items = repos;
            context=cntxt;
    }
    @Override
    public RepositoriesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RepositoriesAdapter.ViewHolder holder, int position) {

        final Item item = items.get(position);
        TextView txt_repo_name = holder.txt_repo_name;
        txt_repo_name.setText(item.getName());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(context,item.getFullName(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, RepoDetailActivity.class);
                intent.putExtra(Fragment_RepoDetail.ITEM_ID, item);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void updateRepositories(List<Item> repos)
    {
        items = repos;
        notifyDataSetChanged();
    }

    private Item getRepo(int adapterposition)
    {
        return items.get(adapterposition);
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener

    {
        public View view;
        public TextView txt_repo_name;
        private Context contxt;



        public ViewHolder(View itemView)
        {   super(itemView);
            view = itemView;
            txt_repo_name = (TextView) itemView.findViewById(android.R.id.text1);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            Item item = getRepo(getAdapterPosition());
            notifyDataSetChanged();
        }
    }


}