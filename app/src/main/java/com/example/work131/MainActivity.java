package com.example.work131;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.*;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button pressureButton = (Button) findViewById(R.id.pressureButton);
        pressureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,getString(R.string.log_d));
                Intent intent = new Intent(MainActivity.this, PressureActivity.class);
                startActivity(intent);
            }
        });

        Button healthButton = (Button) findViewById(R.id.healthButton);
        healthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,getString(R.string.log_h));
                Intent intent = new Intent(MainActivity.this, HealthActivity.class);
                startActivity(intent);
            }
        });

        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i(TAG,getString(R.string.log_save_p));
                String fio = ((EditText)findViewById(R.id.fioText)).getText().toString();
                int ageText = 0;
                try{
                    ageText =  Integer.parseInt(((EditText)findViewById(R.id.ageText)).getText().toString());
                    Patient.patients.add(new Patient(fio, ageText));
                    Toast.makeText(MainActivity.this, getText(R.string.save), LENGTH_LONG).show();
                }
                catch (Exception ex){
                    Toast.makeText(MainActivity.this, getText(R.string.error_age), LENGTH_LONG).show();

                }
                Patient.patients.add(new Patient(fio,ageText));


            }
        });
    }
}
