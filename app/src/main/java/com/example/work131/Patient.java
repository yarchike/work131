package com.example.work131;


import java.util.ArrayList;

public class Patient {
    private String fio;
    private int age;

    public Patient(String fio, int age) {
        this.fio = fio;
        this.age = age;
    }
    static ArrayList<Patient> patients = new ArrayList<Patient>();

}
