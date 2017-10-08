package com.vpopescu.endava.recyclemap;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.vpopescu.endava.recyclemap.adapter.CustomPageAdapter;
import com.vpopescu.endava.recyclemap.model.DataObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private Button slidePageButton;
    private int dotsCount=3;
    private ImageView[] dots;
    LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<DataObject> getData = dataSource();
        CustomPageAdapter mCustomPagerAdapter = new CustomPageAdapter(MainActivity.this, getData);
        slidePageButton = (Button) findViewById(R.id.buttonSlidePage);
        drawPageSelectionIndicators(0);


        viewPager = (ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(mCustomPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                drawPageSelectionIndicators(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        slidePageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawPageSelectionIndicators(viewPager.getNextFocusRightId());
            }
        });

    }


    private List<DataObject> dataSource(){
        List<DataObject> data = new ArrayList<DataObject>();

        data.add(new DataObject(R.mipmap.find_recycle_center, "Find recycle centers!", "SADa sjajhjhja jashf vashashfas ashsa hsa hhs aheja"));
        data.add(new DataObject(R.mipmap.collect_waste_from_home, "Collect the waste from my place!","ANVD aASVa AHSFASHJFSA ASHAASA sajhkasfba jaksfbakhsfkafjala"));
        data.add(new DataObject(R.mipmap.add_waste_center, "Add new recycle centers!", "Desrahkfabd sajfksbh bha sh hasab bhkhhkakhkha sadasgae"));

        return data;
    }

    private void drawPageSelectionIndicators(int mPosition){
        if(linearLayout!=null) {
            linearLayout.removeAllViews();
        }
        linearLayout=(LinearLayout)findViewById(R.id.viewPagerCountDots);
        dots = new ImageView[dotsCount];
        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(getApplicationContext());
            if(i==mPosition)
                dots[i].setImageDrawable(getResources().getDrawable(R.drawable.item_selected));
            else
                dots[i].setImageDrawable(getResources().getDrawable(R.drawable.item_unselected));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);
            linearLayout.addView(dots[i], params);
        }
    }
}