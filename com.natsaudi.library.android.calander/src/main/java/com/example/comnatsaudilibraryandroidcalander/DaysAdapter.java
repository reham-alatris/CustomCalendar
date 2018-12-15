package com.example.comnatsaudilibraryandroidcalander;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.Calendar;

public class DaysAdapter extends RecyclerView.Adapter<DaysAdapter.MyViewHolder> {
    private Context mContext;
    private java.util.List<DayModel> List;
    Typeface typeface;
    String fontPath = "roboto_regular.ttf";
    PropertySetters propertySetters;
    Calendar c;
    int currentMonth, currentDay, row_index;

    public DaysAdapter() {
    }

    boolean isClicked = false;
    public dayListener dayListener;

    public void setDayListener(DaysAdapter.dayListener dayListener) {
        this.dayListener = dayListener;
    }

    public DaysAdapter(Context mContext, java.util.List<DayModel> words, PropertySetters propertySetters) {
        this.mContext = mContext;
        List = words;
        this.propertySetters = propertySetters;

    }

    @Override
    public DaysAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.day_layout, parent, false);

        return new DaysAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final DaysAdapter.MyViewHolder holder, final int position) {


        //binding data to the dayModel first

        final DayModel dayModel = List.get(position);
        setRotation(holder.day_value);


        if (setArabic()) {
            holder.day_value.setText(String.valueOf(dayModel.getArabicNo()));
//            holder.day_value.setRotationY(180);

        } else {

            holder.day_value.setText(String.valueOf(dayModel.getDayValue()));
//            holder.day_value.setRotationY(0);
        }


        //disable previous days of current month

        c = Calendar.getInstance();
        currentMonth = c.get(Calendar.MONTH) + 1;
        currentDay = c.get(Calendar.DAY_OF_MONTH);
        Log.v("current day", String.valueOf(currentDay));

        if (dayModel.getMonth_of_day() == currentMonth) {
            if (dayModel.getDayValue() < currentDay) {
                dayModel.setStatus("occupied");
            }
        }


      /*setting design properties to days
        using getter method from property class instance
       */


        if (propertySetters.getDay_text_size() == 0.0) {
            holder.day_value.setTextSize(15);

        } else {
            holder.day_value.setTextSize(propertySetters.getDay_text_size());

        }

        Log.e("text size from adapter", String.valueOf((propertySetters.getDay_text_size())));


        if (!propertySetters.getDay_font_path().isEmpty()) {
            Log.e("day font", "null font");
            typeface = Typeface.createFromAsset(mContext.getAssets(), propertySetters.getDay_font_path());
            holder.day_value.setTypeface(typeface);
        }


        //handling day status of days

        if (dayModel.getStatus().equals("occupied")) {

            if (propertySetters.getDay_disable_text_color().isEmpty()) {
                holder.day_value.setTextColor(Color.parseColor("#EBECEC"));

            } else {
                holder.day_value.setTextColor(Color.parseColor(propertySetters.getDay_disable_text_color()));

            }

        } else {
            holder.day_value.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int color_day = 0;
                    isClicked = true;
                    color_day = dayModel.getDayValue();
                    propertySetters.setSelectedDay(color_day);
                    propertySetters.setSelectedMonth(dayModel.getMonth_of_day());
                    dayModel.setSelected(true);
                    row_index = position;
            //        dayListener.getDate(String.valueOf(dayModel.getMonth_of_day()));
                    Log.v("selected day on click", String.valueOf(propertySetters.getSelectedDate()));

                    EventBus.getDefault().post(new DayClickListner(dayModel));

                    notifyDataSetChanged();
                }
            });
            if (position == row_index && isClicked) {
                holder.day_value.setTextColor(Color.parseColor(propertySetters.getSelectedDayColor()));


            } else {
                if (propertySetters.getDay_available_text_color().isEmpty()) {
                    holder.day_value.setTextColor(Color.parseColor("#9B9D9F"));
                } else {
                    holder.day_value.setTextColor(Color.parseColor(propertySetters.getDay_available_text_color()));
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return List.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView day_value;

        public MyViewHolder(View view) {
            super(view);
            day_value = itemView.findViewById(R.id.day_value_natsaudi);
        }
    }

    public boolean setArabic() {
        SharedPreferences languague_prefrence = mContext.getSharedPreferences(
                "lan", Context.MODE_PRIVATE);
        String lan = languague_prefrence.getString("languague", "");
        if (lan.equals("arabic")) {
            return true;
        } else {
            return false;
        }
    }

    public void setRotation(View view) {
        if (setArabic()) {
            if (view.getPivotY() == 0.0) {
                view.setRotationY(180);
            } else {
                view.setRotationY(0);
                view.setRotationY(180);
            }

        } else {
            view.setRotationY(0);
        }
    }

    public interface dayListener {
        public void getDate(String date);
    }

}