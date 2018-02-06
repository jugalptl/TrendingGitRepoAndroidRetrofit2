package com.example.igroup.trendinggitrepoandroidretrofit2.Fragments;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.igroup.trendinggitrepoandroidretrofit2.Pojo.Item;
import com.example.igroup.trendinggitrepoandroidretrofit2.R;

/**
 * Created by iGroup on 2/5/2018.
 */

public class Fragment_RepoDetail extends Fragment {

    public static final String ITEM_ID = "item_id";
    TextView txt_repo_details;
    Item item;

    public Fragment_RepoDetail()
    {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ITEM_ID)) {
             item = getArguments().getParcelable(ITEM_ID);
            System.out.println("item"+item.toString());
            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(item.getName());
            }


        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (view != null)
        {
        txt_repo_details = (TextView)view.findViewById(R.id.repo_description);

        txt_repo_details.setText("Description: \n\n"+item.getDescription()+"\n\n Language: \n\n"+ item.getLanguage());

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_layout_repo_detail, container, false);

        return rootView;

    }
}
