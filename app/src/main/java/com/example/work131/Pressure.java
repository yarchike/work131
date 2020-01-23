package com.example.work131;


import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Pressure {
    private int top;
    private int lower;
    private int pulse;
    private boolean tachycardia;
    private LocalDateTime data;

    static ArrayList<Pressure> pressures = new ArrayList<>();


    public Pressure(int top, int lower, int pulse, boolean tachycardia, LocalDateTime data) {
        this.top = top;
        this.lower = lower;
        this.pulse = pulse;
        this.tachycardia = tachycardia;
        this.data = data;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    static public LocalDateTime dateReturn(String datas){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/LL/yyyy HH:mm");
        LocalDateTime data = LocalDateTime.parse(datas, formatter);
        return data;
    }
}