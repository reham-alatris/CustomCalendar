package com.example.comnatsaudilibraryandroidcalander;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Calendar;

public class PropertySetters {

    private Context context;

    //variable to manage days attributes in DaysAdapter
    private float day_text_size = 0;
    private String day_available_text_color = "";
    private String day_disable_text_color = "";
    private String day_font_path = "";
    //variables to mange MonthsViewPagerAdapter
    private String calendar_background_color;
    private String calendar_header_background_color = "";
    private String calendar_header_title_color;
    private float calendar_header_title_size = 0;
    private int calendar_header_height;
    private String seperatorColor;
    private String weekColor;
    private int calendarContainerHeight;
    private int weekRightPadding;
    private int weekLeftPadding;
    private int daysLeftPadding;
    private int daysRightPadding;
    private String disableWeek;
    private int lineTopMargin;
    private int lintBottomMargin;
    private int lineLeftMargin;
    private int lineRightMargin;

    private String selectedDayColor;
    private boolean setArrowRTL;

    public boolean isSetArrowRTL() {
        return setArrowRTL;
    }

    public void setSetArrowRTL(boolean setArrowRTL) {
        this.setArrowRTL = setArrowRTL;
    }

    public String getSelectedDayColor() {
        return selectedDayColor;
    }

    public void setSelectedDayColor(String selectedDayColor) {
        this.selectedDayColor = selectedDayColor;
    }

    public int getLineTopMargin() {
        return lineTopMargin;
    }

    public void setLineTopMargin(int lineTopMargin) {
        this.lineTopMargin = lineTopMargin;
    }

    public int getLintBottomMargin() {
        return lintBottomMargin;
    }

    public void setLintBottomMargin(int lintBottomMargin) {
        this.lintBottomMargin = lintBottomMargin;
    }

    public int getLineLeftMargin() {
        return lineLeftMargin;
    }

    public void setLineLeftMargin(int lineLeftMargin) {
        this.lineLeftMargin = lineLeftMargin;
    }

    public int getLineRightMargin() {
        return lineRightMargin;
    }

    public void setLineRightMargin(int lineRightMargin) {
        this.lineRightMargin = lineRightMargin;
    }

    public boolean isStSun() {
        return stSun;
    }

    public void setStSun(boolean stSun) {
        this.stSun = stSun;
    }

    public boolean isStMon() {
        return stMon;
    }

    public void setStMon(boolean stMon) {
        this.stMon = stMon;
    }

    public boolean isStTu() {
        return stTu;
    }

    public void setStTu(boolean stTu) {
        this.stTu = stTu;
    }

    public boolean isStWed() {
        return stWed;
    }

    public void setStWed(boolean stWed) {
        this.stWed = stWed;
    }

    public boolean isStThrs() {
        return stThrs;
    }

    public void setStThrs(boolean stThrs) {
        this.stThrs = stThrs;
    }

    public boolean isMonSun() {
        return monSun;
    }

    public void setMonSun(boolean monSun) {
        this.monSun = monSun;
    }

    public boolean isMonTues() {
        return monTues;
    }

    public void setMonTues(boolean monTues) {
        this.monTues = monTues;
    }

    public boolean isMonWend() {
        return monWend;
    }

    public void setMonWend(boolean monWend) {
        this.monWend = monWend;
    }

    public boolean isMonThrs() {
        return monThrs;
    }

    public void setMonThrs(boolean monThrs) {
        this.monThrs = monThrs;
    }

    public boolean isMonFri() {
        return monFri;
    }

    public void setMonFri(boolean monFri) {
        this.monFri = monFri;
    }

    public boolean isTuSun() {
        return tuSun;
    }

    public void setTuSun(boolean tuSun) {
        this.tuSun = tuSun;
    }

    public boolean isTuWend() {
        return tuWend;
    }

    public void setTuWend(boolean tuWend) {
        this.tuWend = tuWend;
    }

    public boolean isTuThrs() {
        return tuThrs;
    }

    public void setTuThrs(boolean tuThrs) {
        this.tuThrs = tuThrs;
    }

    public boolean isTuFri() {
        return tuFri;
    }

    public void setTuFri(boolean tuFri) {
        this.tuFri = tuFri;
    }

    public boolean isWendSun() {
        return wendSun;
    }

    public void setWendSun(boolean wendSun) {
        this.wendSun = wendSun;
    }

    public boolean isWendThrus() {
        return wendThrus;
    }

    public void setWendThrus(boolean wendThrus) {
        this.wendThrus = wendThrus;
    }

    public boolean isWendFriday() {
        return wendFriday;
    }

    public void setWendFriday(boolean wendFriday) {
        this.wendFriday = wendFriday;
    }

    public boolean isThrusSun() {
        return thrusSun;
    }

    public void setThrusSun(boolean thrusSun) {
        this.thrusSun = thrusSun;
    }

    public boolean isThrusFri() {
        return thrusFri;
    }

    public void setThrusFri(boolean thrusFri) {
        this.thrusFri = thrusFri;
    }

    public String getDisableWeek() {
        return disableWeek;
    }

    public void setDisableWeek(String disableWeek) {
        this.disableWeek = disableWeek;
    }

    public int getWeekRightPadding() {
        return weekRightPadding;
    }

    public void setWeekRightPadding(int weekRightPadding) {
        this.weekRightPadding = weekRightPadding;
    }

    public int getWeekLeftPadding() {
        return weekLeftPadding;
    }

    public void setWeekLeftPadding(int weekLeftPadding) {
        this.weekLeftPadding = weekLeftPadding;
    }

    public int getDaysLeftPadding() {
        return daysLeftPadding;
    }

    public void setDaysLeftPadding(int daysLeftPadding) {
        this.daysLeftPadding = daysLeftPadding;
    }

    public int getDaysRightPadding() {
        return daysRightPadding;
    }

    public void setDaysRightPadding(int daysRightPadding) {
        this.daysRightPadding = daysRightPadding;
    }

    public int getCalendarContainerHeight() {
        return calendarContainerHeight;
    }

    public void setCalendarContainerHeight(int calendarContainerHeight) {
        this.calendarContainerHeight = calendarContainerHeight;
    }

    public String getWeekColor() {
        return weekColor;
    }

    public void setWeekColor(String weekColor) {
        this.weekColor = weekColor;
    }

    public String getSeperatorColor() {
        return seperatorColor;
    }

    public void setSeperatorColor(String seperatorColor) {
        this.seperatorColor = seperatorColor;
    }

    //disable array of days for each month of year
    private int[] JANdays;
    private int[] FEBdays;
    private int[] MARday;
    private int[] APRdays;
    private int[] MAYdays;
    private int[] JUNdays;
    private int[] JULdays;
    private int[] AUGdays;
    private int[] SEPdays;
    private int[] OCTdays;
    private int[] NOVdays;
    private int[] DECdays;
    //getting selected date
    private int selectedDay;
    private int selectedMonth;
    //no of inflated months;
    private int inflatedMonths;
    private int year;
    boolean satOff;
    boolean sunOff;
    boolean monOff;
    boolean tuesOff;
    boolean wendOff;
    boolean thOff;
    boolean friOff;

    boolean stFr;
    boolean stSun;
    boolean stMon;
    boolean stTu;
    boolean stWed;
    boolean stThrs;

    ///mon
    boolean monSun;
    boolean monTues;
    boolean monWend;
    boolean monThrs;
    boolean monFri;

    //tuesday

    boolean tuSun;
    boolean tuWend;
    boolean tuThrs;
    boolean tuFri;


    //wend

    boolean wendSun;
    boolean wendThrus;
    boolean wendFriday;

    //thrus

    boolean thrusSun;
    boolean thrusFri;

    boolean sunFri;

    public boolean isSunFri() {
        return sunFri;
    }

    public void setSunFri(boolean sunFri) {
        this.sunFri = sunFri;
    }

    public boolean isStFr() {
        return stFr;
    }

    public void setStFr(boolean stFr) {
        this.stFr = stFr;
    }

    public boolean isSatOff() {
        return satOff;
    }

    public void setSatOff(boolean satOff) {
        this.satOff = satOff;
    }

    public boolean isSunOff() {
        return sunOff;
    }

    public void setSunOff(boolean sunOff) {
        this.sunOff = sunOff;
    }

    public boolean isMonOff() {
        return monOff;
    }

    public void setMonOff(boolean monOff) {
        this.monOff = monOff;
    }

    public boolean isTuesOff() {
        return tuesOff;
    }

    public void setTuesOff(boolean tuesOff) {
        this.tuesOff = tuesOff;
    }

    public boolean isWendOff() {
        return wendOff;
    }

    public void setWendOff(boolean wendOff) {
        this.wendOff = wendOff;
    }

    public boolean isThOff() {
        return thOff;
    }

    public void setThOff(boolean thOff) {
        this.thOff = thOff;
    }

    public boolean isFriOff() {
        return friOff;
    }

    public void setFriOff(boolean friOff) {
        this.friOff = friOff;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getInflatedMonths() {
        return inflatedMonths;
    }

    public void setInflatedMonths(int inflatedMonths) {
        this.inflatedMonths = inflatedMonths;
    }

    public PropertySetters(Context context) {
        this.context = context;
    }


    public int getSelectedMonth() {
        return selectedMonth;
    }

    public void setSelectedMonth(int selectedMonth) {
        this.selectedMonth = selectedMonth;
    }

    public int getSelectedDay() {
        return selectedDay;
    }

    public void setSelectedDay(int selectedDay) {
        this.selectedDay = selectedDay;
    }


    public int[] getFEBdays() {
        return FEBdays;
    }

    public void setFEBdays(int[] FEBdays) {
        this.FEBdays = FEBdays;
    }

    public int[] getMARday() {
        return MARday;
    }

    public void setMARday(int[] MARday) {
        this.MARday = MARday;
    }

    public int[] getAPRdays() {
        return APRdays;
    }

    public void setAPRdays(int[] APRdays) {
        this.APRdays = APRdays;
    }

    public int[] getMAYdays() {
        return MAYdays;
    }

    public void setMAYdays(int[] MAYdays) {
        this.MAYdays = MAYdays;
    }

    public int[] getJUNdays() {
        return JUNdays;
    }

    public void setJUNdays(int[] JUNdays) {
        this.JUNdays = JUNdays;
    }

    public int[] getJULdays() {
        return JULdays;
    }

    public void setJULdays(int[] JULdays) {
        this.JULdays = JULdays;
    }

    public int[] getAUGdays() {
        return AUGdays;
    }

    public void setAUGdays(int[] AUGdays) {
        this.AUGdays = AUGdays;
    }

    public int[] getSEPdays() {
        return SEPdays;
    }

    public void setSEPdays(int[] SEPdays) {
        this.SEPdays = SEPdays;
    }

    public int[] getOCTdays() {
        return OCTdays;
    }

    public void setOCTdays(int[] OCTdays) {
        this.OCTdays = OCTdays;
    }

    public int[] getNOVdays() {
        return NOVdays;
    }

    public void setNOVdays(int[] NOVdays) {
        this.NOVdays = NOVdays;
    }

    public int[] getDECdays() {
        return DECdays;
    }

    public void setDECdays(int[] DECdays) {
        this.DECdays = DECdays;
    }

    public void setCalendar_header_height(int calendar_header_height) {
        this.calendar_header_height = calendar_header_height;
    }

    public int[] getJANdays() {
        return JANdays;
    }

    public void setJANdays(int[] JANdays) {
        this.JANdays = JANdays;
    }

    public int getCalendar_header_height() {

        return calendar_header_height;

    }

    public void setCalendar_header_title_size(float calendar_header_title_size) {
        this.calendar_header_title_size = calendar_header_title_size;
    }

    public float getCalendar_header_title_size() {

        return calendar_header_title_size;
    }

    public void setCalendar_header_background_color(String calendar_header_background_color) {
        this.calendar_header_background_color = calendar_header_background_color;
    }

    public void setCalendar_header_title_color(String calendar_header_title_color) {
        this.calendar_header_title_color = calendar_header_title_color;
    }

    public String getCalendar_header_title_color() {

        return calendar_header_title_color;
    }

    public String getCalendar_header_background_color() {

        return calendar_header_background_color;
    }


    public void setCalendar_background_color(String calendar_background_color) {
        this.calendar_background_color = calendar_background_color;
    }

    public String getCalendar_background_color() {
        return calendar_background_color;
    }


    public void setDay_font_path(String day_font_path) {
        this.day_font_path = day_font_path;
    }

    public String getDay_font_path() {

        return day_font_path;
    }

    public void setDay_available_text_color(String day_available_text_color) {
        this.day_available_text_color = day_available_text_color;
    }

    public String getDay_available_text_color() {
        return day_available_text_color;
    }

    public void setDay_text_size(float day_text_size) {
        this.day_text_size = day_text_size;
    }

    public void setDay_disable_text_color(String day_disable_text_color) {
        this.day_disable_text_color = day_disable_text_color;
    }

    public String getDay_disable_text_color() {

        return day_disable_text_color;
    }

    public float getDay_text_size() {

        return day_text_size;
    }

    public String getSelectedDate() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        String date = "";
        int day = getSelectedDay();
        int current_day = c.get(Calendar.DAY_OF_MONTH);
        int current_month = c.get(Calendar.MONTH);
        String double_digit_day = "";
        if (day == 0) {
            if (current_day < 10) {
                double_digit_day = "0" + String.valueOf(current_day);
            } else {
                double_digit_day = String.valueOf(current_day);
            }

        } else {
            if (day < 10) {
                double_digit_day = "0" + String.valueOf(day);
            } else {
                double_digit_day = String.valueOf(day);
            }
        }

        int month = getSelectedMonth();
        String double_digit_month = "";

        if (month == 0) {
            if (current_month < 10) {
                double_digit_month = "0" + current_month;
            } else {
                double_digit_month = String.valueOf(current_month);
            }
        } else {

            if (month < 10) {
                double_digit_month = "0" + month;
            } else {
                double_digit_month = String.valueOf(month);
            }
        }

        date = String.valueOf(year) + "-" + double_digit_month + "-" + double_digit_day;

        return date;
    }

    public void setArabicSupport(boolean check) {
        if (check) {
            clearPreference();
            SharedPreferences languague_prefrence = context.getSharedPreferences(
                    "lan", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = languague_prefrence.edit();
            editor.putString("languague", "arabic");
            editor.apply();
        } else {

            clearPreference();
            SharedPreferences languague_prefrence = context.getSharedPreferences(
                    "lan", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = languague_prefrence.edit();
            editor.putString("languague", "english");
            editor.apply();
        }
    }

    public void clearPreference() {
        SharedPreferences languague_prefrence = context.getSharedPreferences(
                "lan", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = languague_prefrence.edit();
        editor.clear();
        editor.apply();

    }

    private int getMonths() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH);
        int inflatedFraments = 12 - currentMonth;
        return inflatedFraments;

    }
}
