package com.example.work131;

import java.util.ArrayList;

public class Health {
    private double weight;
    private int step;

    public Health(double weight, int step) {
        this.weight = weight;
        this.step = step;
    }
    static ArrayList<Health> health = new ArrayList<Health>();
}
