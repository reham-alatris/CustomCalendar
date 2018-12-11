package com.example.comnatsaudilibraryandroidcalander;

public class DayModel {
    private int dayId;
    private int dayValue;
    private String status;
    private int month_of_day;
    private boolean isSelected;
    private String arabicNo;
    private String week_value_arabic;
    private String week_value_english;
    private int year;


    public DayModel(String week_value_arabic, String week_value_english) {
        this.week_value_arabic = week_value_arabic;
        this.week_value_english = week_value_english;
    }

    public String getWeek_value_arabic() {

        return week_value_arabic;
    }

    public void setWeek_value_arabic(String week_value_arabic) {
        this.week_value_arabic = week_value_arabic;
    }

    public String getWeek_value_english() {
        return week_value_english;
    }

    public void setWeek_value_english(String week_value_english) {
        this.week_value_english = week_value_english;
    }

    public DayModel(int dayId, int dayValue, String status, int month_of_day, String arabicNo) {
        this.dayId = dayId;
        this.dayValue = dayValue;
        this.status = status;
        this.month_of_day = month_of_day;
        this.arabicNo = arabicNo;
    }

    public String getArabicNo() {

        return arabicNo;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getMonth_of_day() {
        return month_of_day;
    }



    public void setStatus(String status) {
        this.status = status;
    }

    public int getDayId() {

        return dayId;
    }

    public int getDayValue() {
        return dayValue;
    }

    public String getStatus() {
        return status;
    }


}
