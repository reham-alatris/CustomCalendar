package com.example.comnatsaudilibraryandroidcalander;

public class DayClickListner {
    public DayClickListner(DayModel dayModel) {
        this.dayModel = dayModel;
    }

    private DayModel dayModel;

    public DayModel getDayModel() {
        return dayModel;
    }

    public void setDayModel(DayModel dayModel) {
        this.dayModel = dayModel;
    }
}
