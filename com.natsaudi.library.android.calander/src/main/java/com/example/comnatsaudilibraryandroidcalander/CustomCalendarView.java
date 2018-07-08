package com.example.comnatsaudilibraryandroidcalander;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

public class CustomCalendarView extends ViewPager implements MontsViewPagerAdapter.Listener {

    PropertySetters propertySetters;
  public   MontsViewPagerAdapter montsViewPagerAdapter;
    MontsViewPagerAdapter.Listener listener;
    private int displayMonth;


    public PropertySetters getPropertySetters() {
        return propertySetters;
    }


    public CustomCalendarView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        SharedPreferences prefrence = getContext().getSharedPreferences(
                "months", Context.MODE_PRIVATE);
        propertySetters = new PropertySetters(context);
        displayMonth = prefrence.getInt("month", 0);
        montsViewPagerAdapter = new MontsViewPagerAdapter(context, propertySetters);
        montsViewPagerAdapter.setListener(this);
        setAdapter(montsViewPagerAdapter);
        setRotation();
    }


    @Override
    public void nextMonth(int position, String type) {
        if (type.equals("next")) {
            setCurrentItem(position + 1);
        } else {
            setCurrentItem(position - 1);
        }
    }

    public void setInflatedMonths(int inflatedMonthss) {
        clearPreference();
        SharedPreferences prefrence = getContext().getSharedPreferences(
                "months", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefrence.edit();
        editor.putInt("month", inflatedMonthss);
        editor.apply();
        montsViewPagerAdapter.notifyDataSetChanged();

    }

    private void clearPreference() {
        SharedPreferences languague_prefrence = getContext().getSharedPreferences(
                "months", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = languague_prefrence.edit();
        editor.clear();
        editor.apply();
    }

    private boolean setArabic() {
        SharedPreferences languague_prefrence = getContext().getSharedPreferences(
                "lan", Context.MODE_PRIVATE);
        String lan = languague_prefrence.getString("languague", "");
        if (lan.equals("arabic")) {
            return true;
        } else {
            return false;
        }
    }

    private void setRotation() {
        if (setArabic()) {
            if (getPivotY() == 0.0) {
                setRotationY(180);
            } else {
                setRotationY(0);
                setRotationY(180);
            }

        } else {
            setRotationY(0);

        }
    }


}
