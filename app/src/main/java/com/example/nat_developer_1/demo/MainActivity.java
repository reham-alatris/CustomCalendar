package com.example.nat_developer_1.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.comnatsaudilibraryandroidcalander.CustomCalendarView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CustomCalendarView custom;
    int[] DecDisableDays = new int[]{14, 20, 5, 6};
    List<Integer> offDays = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        custom = (CustomCalendarView) findViewById(R.id.custom);
        custom.getPropertySetters().setStFr(true);

        //   custom.getPropertySetters().setSunOff(true);

        custom.getPropertySetters().setSeperatorColor("#FFFFFF");
        custom.getPropertySetters().setCalendarContainerHeight(300);
        custom.getPropertySetters().setWeekColor("#FFFFFF");
        custom.getPropertySetters().setDaysLeftPadding(50);
        custom.getPropertySetters().setDECdays(DecDisableDays);


        custom.montsViewPagerAdapter.notifyDataSetChanged();

    }
}
