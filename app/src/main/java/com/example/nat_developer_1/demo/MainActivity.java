package com.example.nat_developer_1.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.comnatsaudilibraryandroidcalander.CustomCalendarView;

public class MainActivity extends AppCompatActivity {
    private CustomCalendarView custom;
    int []DecDisableDays=new int[]{3,4,5,6};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        custom = (CustomCalendarView) findViewById(R.id.custom);
//        custom.getPropertySetters().setInflatedMonths(3);
//        custom.montsViewPagerAdapter.notifyDataSetChanged();
//        custom.getPropertySetters().setArabicSupport(false);
//        custom.setRotationY(0);
//        custom.getPropertySetters().setCalendar_header_title_size(20);
//        custom.getPropertySetters().setCalendar_header_height(40);
//        custom.getPropertySetters().setDECdays(DecDisableDays);




    }
}
