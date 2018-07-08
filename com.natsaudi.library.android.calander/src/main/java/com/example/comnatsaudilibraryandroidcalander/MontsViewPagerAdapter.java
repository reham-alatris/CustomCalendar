package com.example.comnatsaudilibraryandroidcalander;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MontsViewPagerAdapter extends PagerAdapter {
    Context mContext;
    LayoutInflater mLayoutInflater;
    RecyclerView recyclerView;
    public DaysAdapter daysAdapter;
    private List<DayModel> dayModelList;
    private TextView monthName;
    String sMonthName;
    Typeface typeface;
    String fontPath = "roboto_regular.ttf";
    PropertySetters propertySetters;
    LinearLayout root_container_layout, calendar_header;
    int[] disableDays;
    ImageView next, previous;
    private Listener mListener;
    public ArrayList<String> arabicDays = new ArrayList<>();
    RecyclerView WeekrecyclerView;
    public WeekAdapter weekAdapter;
    private List<DayModel> weekModelList;


    public void setListener(Listener listener) {
        mListener = listener;
    }


    public MontsViewPagerAdapter(Context mContext, PropertySetters propertySetters) {
        this.mContext = mContext;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.propertySetters = propertySetters;
    }

    private int getInflatedFragments() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH);
        int inflatedFraments = 12 - currentMonth;
        return inflatedFraments;
    }

    @Override

    public int getCount() {
        if (propertySetters.getInflatedMonths() == 0) {
            return getInflatedFragments();
        } else {

            if (propertySetters.getInflatedMonths() > getInflatedFragments()) {
                try {
                    throw new CustomException("inflated months can't be more than the current year left months");
                } catch (CustomException e) {
                    e.printStackTrace();
                }
                return 0;

            }
            return propertySetters.getInflatedMonths();

        }

    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((FrameLayout) object);
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        final View itemView = mLayoutInflater.inflate(R.layout.fragment_month, container, false);

        //initialize views

        root_container_layout = (LinearLayout) itemView.findViewById(R.id.root_container_layout_natsaudi);
        calendar_header = (LinearLayout) itemView.findViewById(R.id.calendar_header_natsaudi);
        monthName = (TextView) itemView.findViewById(R.id.month_natsaudi);
        dayModelList = new ArrayList<>();
        weekModelList = new ArrayList<>();
        recyclerView = (RecyclerView) itemView.findViewById(R.id.days_recycler_view_natsaudi);
        next = (ImageView) itemView.findViewById(R.id.next_arrow_natsaudi);
        previous = (ImageView) itemView.findViewById(R.id.previous_arrow_natsaudi);
        WeekrecyclerView = (RecyclerView) itemView.findViewById(R.id.week_recycler_view_natsaudi);


        //setRotation of views
        setRotation(monthName);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.nextMonth(position, "next");

            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.nextMonth(position, "previous");
            }
        });


        //setting recycler view adapter and layout manger

        daysAdapter = new DaysAdapter(mContext, dayModelList, propertySetters);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(mContext, 7);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(daysAdapter);

        weekAdapter = new WeekAdapter(mContext, weekModelList, propertySetters);
        RecyclerView.LayoutManager wLayoutManager = new GridLayoutManager(mContext, 7);

        WeekrecyclerView.setLayoutManager(wLayoutManager);
        WeekrecyclerView.setAdapter(weekAdapter);
        getWeekList();

        //filling  days list from calendar class

        //checking for arabic support

        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, getDays(position) - 1);
        int daysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        getArabicDays();
        for (int i = 1; i <= daysInMonth; i++) {
            dayModelList.add(new DayModel(1, i, "test", getDays(position), arabicDays.get(i - 1)));
            daysAdapter.notifyDataSetChanged();
        }


        if (setArabic()) {
            monthName.setText(getsMonthNameA(position));


        } else {
            monthName.setText(getsMonthNameE(position).toUpperCase());


        }

        /*setting disable days in each month
         */

        int[] disableDays = getDisableDays(getDays(position), position);

        if (disableDays != null) {

            for (int disableDay : disableDays) {
                for (DayModel dayModel : dayModelList) {
                    if (dayModel.getDayValue() == disableDay) {
                        dayModel.setStatus("occupied");
                    }
                }
            }
        }


        /*
        setting calendar design attributes from property  setters class

         */

        if (propertySetters.getCalendar_background_color() == null || propertySetters.getCalendar_background_color().isEmpty()) {
            root_container_layout.setBackgroundColor(Color.parseColor("#FFFFFF"));
        } else {
            root_container_layout.setBackgroundColor(Color.parseColor(propertySetters.getCalendar_background_color()));
        }

        if (propertySetters.getCalendar_header_background_color() == null || propertySetters.getCalendar_header_background_color().isEmpty()) {
            calendar_header.setBackgroundColor(Color.parseColor("#EB943E"));
        } else {
            calendar_header.setBackgroundColor(Color.parseColor(propertySetters.getCalendar_header_background_color()));

        }

        if (propertySetters.getCalendar_header_title_color() == null || propertySetters.getCalendar_header_title_color().isEmpty()) {
            monthName.setTextColor(Color.parseColor("#FFFFFF"));

        } else {
            monthName.setTextColor(Color.parseColor(propertySetters.getCalendar_header_title_color()));

        }

        if (propertySetters.getCalendar_header_title_size() == 0) {
            monthName.setTextSize(15);

        } else {
            monthName.setTextSize(propertySetters.getCalendar_header_title_size());

        }


        if (propertySetters.getCalendar_header_height() == 0) {
            int dimensionInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 42, mContext.getResources().getDisplayMetrics());

            calendar_header.getLayoutParams().height = dimensionInDp;
            calendar_header.requestLayout();

        } else {
            int dimensionInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, propertySetters.getCalendar_header_height(), mContext.getResources().getDisplayMetrics());
            calendar_header.getLayoutParams().height = dimensionInDp;
            calendar_header.requestLayout();


        }

        if (!propertySetters.getDay_font_path().isEmpty()) {
            typeface = Typeface.createFromAsset(mContext.getAssets(), fontPath);
            monthName.setTypeface(typeface);
        }


        container.addView(itemView);
        return itemView;
    }

    private int getDays(int monthPosition) {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH);
        int startMonth = currentMonth + 1;
        int monthNo = startMonth + monthPosition;
        return monthNo;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((FrameLayout) object);
    }

    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    private String getsMonthNameE(int position) {
        switch (getDays(position)) {
            case 1:
                sMonthName = "January";
                break;
            case 2:
                sMonthName = "February";
                break;

            case 3:
                sMonthName = "March";
                break;

            case 4:
                sMonthName = "April";
                break;

            case 5:
                sMonthName = "May";
                break;

            case 6:
                sMonthName = "June";
                break;

            case 7:
                sMonthName = "July";
                break;

            case 8:
                sMonthName = "August";
                break;

            case 9:
                sMonthName = "September";
                break;

            case 10:
                sMonthName = "October";
                break;


            case 11:
                sMonthName = "November";
                break;

            case 12:
                sMonthName = "December";
                break;


        }


        return sMonthName;
    }

    private int[] getDisableDays(int month, int position) {
        month = getDays(position);
        int[] disable_days_array = new int[0];
        switch (month) {
            case 1:
                disable_days_array = propertySetters.getJANdays();
                break;

            case 2:
                disable_days_array = propertySetters.getFEBdays();
                break;

            case 3:
                disable_days_array = propertySetters.getMARday();
                break;

            case 4:
                disable_days_array = propertySetters.getAPRdays();
                break;

            case 5:
                disable_days_array = propertySetters.getMAYdays();
                break;

            case 6:
                disable_days_array = propertySetters.getJUNdays();
                break;

            case 7:
                disable_days_array = propertySetters.getJULdays();
                break;

            case 8:
                disable_days_array = propertySetters.getAUGdays();
                break;

            case 9:
                disable_days_array = propertySetters.getSEPdays();
                break;

            case 10:
                disable_days_array = propertySetters.getOCTdays();
                break;

            case 11:
                disable_days_array = propertySetters.getNOVdays();
                break;

            case 12:
                disable_days_array = propertySetters.getDECdays();
                break;

        }

        return disable_days_array;

    }


    interface Listener {
        public void nextMonth(int position, String type);

    }


    public void getArabicDays() {
        arabicDays.add("١");
        arabicDays.add("٢ ");
        arabicDays.add("٣");
        arabicDays.add("٤");
        arabicDays.add("٥ ");
        arabicDays.add("٦");
        arabicDays.add("٧");
        arabicDays.add("٨");
        arabicDays.add("٩ ");
        arabicDays.add("١٠");
        arabicDays.add("١١");
        arabicDays.add("١٢");
        arabicDays.add("١٣");
        arabicDays.add("١٤");
        arabicDays.add("١٥");
        arabicDays.add("١٦");
        arabicDays.add("١٧");
        arabicDays.add("١٨");
        arabicDays.add("١٩");
        arabicDays.add("٢٠");
        arabicDays.add("٢١");
        arabicDays.add("٢٢");
        arabicDays.add("٢٣");
        arabicDays.add("٢٤");
        arabicDays.add("٢٥");
        arabicDays.add("٢٦");
        arabicDays.add("٢٧");
        arabicDays.add("٢٨");
        arabicDays.add("٢٩");
        arabicDays.add("٣٠");
        arabicDays.add("٣١");


    }

    private String getsMonthNameA(int position) {
        switch (getDays(position)) {
            case 1:
                sMonthName = "يناير";
                break;
            case 2:
                sMonthName = "فبراير";
                break;

            case 3:
                sMonthName = "مارس";
                break;

            case 4:
                sMonthName = "أبريل";
                break;

            case 5:
                sMonthName = "مايو";
                break;

            case 6:
                sMonthName = "يونيو";
                break;

            case 7:
                sMonthName = "يوليو";
                break;

            case 8:
                sMonthName = "أغسطس";
                break;

            case 9:
                sMonthName = "ستمبر";
                break;

            case 10:
                sMonthName = "اكتوبر";
                break;


            case 11:
                sMonthName = "نوفمبر";
                break;

            case 12:
                sMonthName = "ديسمبر";
                break;


        }


        return sMonthName;
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

    public void getWeekList() {
        weekModelList.add(new DayModel("س", "s"));
        weekModelList.add(new DayModel("ح", "s"));
        weekModelList.add(new DayModel("ث", "m"));
        weekModelList.add(new DayModel("ث", "t"));
        weekModelList.add(new DayModel("أ", "w"));
        weekModelList.add(new DayModel("خ", "t"));
        weekModelList.add(new DayModel("ج", "f"));
        weekAdapter.notifyDataSetChanged();

    }
}
