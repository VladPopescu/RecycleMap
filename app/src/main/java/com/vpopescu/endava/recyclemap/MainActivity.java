package com.vpopescu.endava.recyclemap;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<DataObject> getData = dataSource();
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        CustomPageAdapter mCustomPagerAdapter = new CustomPageAdapter(MainActivity.this, getData);
        viewPager.setAdapter(mCustomPagerAdapter);
    }
    private List<DataObject> dataSource(){
        List<DataObject> data = new ArrayList<DataObject>();

        data.add(new DataObject(R.mipmap.find_recycle_center, "Find recycle centers!", "SADa sjajhjhja jashf vashashfas ashsa hsa hhs aheja"));
        data.add(new DataObject(R.mipmap.collect_waste_from_home, "Collect the waste from my place!","ANVD aASVa AHSFASHJFSA ASHAASA sajhkasfba jaksfbakhsfkafjala"));
        data.add(new DataObject(R.mipmap.add_waste_center, "Add new recycle centers!", "Desrahkfabd sajfksbh bha sh hasab bhkhhkakhkha sadasgae"));

        return data;
    }
}