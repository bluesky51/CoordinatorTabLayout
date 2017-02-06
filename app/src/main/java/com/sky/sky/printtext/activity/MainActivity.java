package com.sky.sky.printtext.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;

import com.sky.sky.printtext.R;
import com.sky.sky.printtext.adapter.TabAdapter;
import com.sky.sky.printtext.fragment.ContentFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;

    String[] titles = new String[]{"我的", "收藏", "历史"};


   CollapsingToolbarLayout toolbarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_scrollview);
        toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbarLayout);

        toolbarLayout.setTitle("昵称");
        toolbarLayout.setExpandedTitleColor(Color.BLUE);
        toolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        toolbarLayout.setExpandedTitleGravity(Gravity.CENTER|Gravity.BOTTOM);

        viewPager = (ViewPager) findViewById(R.id.vp);
        tabLayout = (TabLayout) findViewById(R.id.tabLeyout);
        tabLayout.setTabTextColors(Color.BLACK,Color.BLUE);
        tabLayout.setBackgroundColor(getResources().getColor(android.R.color.white));


        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {

            ContentFragment contentFragment = new ContentFragment();
            Bundle b = new Bundle();
            b.putInt("pos", i);
            contentFragment.setArguments(b);
            fragments.add(contentFragment);

        }

        viewPager.setAdapter(new TabAdapter(getSupportFragmentManager(),
                fragments, titles));
        tabLayout.setupWithViewPager(viewPager);

    }
}
