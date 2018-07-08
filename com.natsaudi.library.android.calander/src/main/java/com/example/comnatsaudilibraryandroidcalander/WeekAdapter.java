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

public class WeekAdapter extends RecyclerView.Adapter<WeekAdapter.MyViewHolder> {
    private Context mContext;
    private java.util.List<DayModel> List;
    Typeface typeface;
    String fontPath = "roboto_regular.ttf";
    PropertySetters propertySetters;


    public WeekAdapter(Context mContext, java.util.List<DayModel> words, PropertySetters propertySetters) {
        this.mContext = mContext;
        List = words;
        this.propertySetters = propertySetters;

    }

    @Override
    public WeekAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.day_layout, parent, false);

        return new WeekAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final WeekAdapter.MyViewHolder holder, final int position) {


        final DayModel dayModel = List.get(position);
        setRotation(holder.day_value);


        if (setArabic()) {
            holder.day_value.setText(String.valueOf(dayModel.getWeek_value_arabic()));

        } else {

            holder.day_value.setText(String.valueOf(dayModel.getWeek_value_english()));
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


        if (propertySetters.getDay_available_text_color().isEmpty()) {
            holder.day_value.setTextColor(Color.parseColor("#9B9D9F"));
        } else {
            holder.day_value.setTextColor(Color.parseColor(propertySetters.getDay_available_text_color()));
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
}