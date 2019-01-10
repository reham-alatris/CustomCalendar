package com.example.nat_developer_1.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.comnatsaudilibraryandroidcalander.CustomCalendarView;
import com.example.comnatsaudilibraryandroidcalander.DayClickListner;
import com.example.comnatsaudilibraryandroidcalander.DaysAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CustomCalendarView custom;
    int[] DecDisableDays = new int[]{14, 20, 5, 6};
    List<Integer> offDays = new ArrayList<>();

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(DayClickListner event) {
        Toast.makeText(MainActivity.this, String.valueOf(event.getDayModel().getDayValue()), Toast.LENGTH_LONG).show();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        custom = (CustomCalendarView) findViewById(R.id.custom);
        custom.getPropertySetters().setStFr(true);

        //   custom.getPropertySetters().setSunOff(true);

        custom.getPropertySetters().setSeperatorColor("#FFFFFF");
        custom.getPropertySetters().setCalendarContainerHeight(300);
        custom.getPropertySetters().setWeekColor("#EB943E");
        custom.getPropertySetters().setDaysLeftPadding(50);
        custom.getPropertySetters().setDECdays(DecDisableDays);
        custom.getPropertySetters().setSelectedDayColor("#FFFFFF");
        custom.getPropertySetters().setSetArrowRTL(true);
        custom.montsViewPagerAdapter.notifyDataSetChanged();


    }


}
