package com.sky.sky.printtext.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sky.sky.printtext.R;
import com.sky.sky.printtext.activity.DetailActivity;
import com.sky.sky.printtext.adapter.RecyclerViewAdapter;
import com.sky.sky.printtext.callback.OnClickListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends Fragment {
    RecyclerView recyclerView;
    int position;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        position = getArguments().getInt("pos");
    }

    public ContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            stringList.add("====" + i + "=====");
        }
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(stringList, getActivity());
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(new OnClickListener() {
            @Override
            public void onClickListener(int pos) {
                Log.e("======", position + "======" + pos);
                String str = "";
                switch (position) {
                    case 0:
                        str = "您点击了我的页面的第" + pos + "条数据";
                        break;
                    case 1:
                        str = "您点击了历史页面的第" + pos + "条数据";
                        break;
                    case 2:
                        str = "您点击了收藏页面的第" + pos + "条数据";
                        break;
                }
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("str", str);
                startActivity(intent);

            }
        });
        return view;
    }

}
