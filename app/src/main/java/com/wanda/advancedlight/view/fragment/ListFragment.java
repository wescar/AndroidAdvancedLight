package com.wanda.advancedlight.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wanda.advancedlight.R;
import com.wanda.advancedlight.presenter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 2018/7/31.
 */

public class ListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private List<String> mList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_fragment, container, false);
        mRecyclerView  = (RecyclerView)rootView.findViewById(R.id.recyclerView);
        mList.add("1");
        mList.add("2");
        mList.add("3");
        mList.add("3");
        mList.add("3");
        mList.add("3");
        mList.add("4");
        mList.add("4");
        mList.add("4");
        mList.add("4");
        mList.add("4");
        mList.add("4");
        mList.add("4");
        mList.add("4");
        mList.add("4");
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        mRecyclerView.setAdapter(new RecyclerViewAdapter(getActivity(),mList));
    }
}
