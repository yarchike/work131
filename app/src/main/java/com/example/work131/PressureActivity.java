package com.example.work131;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.util.LocaleData;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDateTime;

import static android.widget.Toast.LENGTH_LONG;

public class PressureActivity extends AppCompatActivity {
    private static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);


        Button saveButtonPressure = (Button) findViewById(R.id.saveButtonPressure);
        saveButtonPressure.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Log.i(TAG,getString(R.string.log_save_d));
                int topText = 0;
                int lowerText = 0;
                int pulsetText = 0;
                LocalDateTime data = null;
                try{
                    topText = Integer.parseInt(((EditText)findViewById(R.id.topText)).getText().toString());
                }
                catch (Exception e) {
                    Toast.makeText(PressureActivity.this, getText(R.string.error_top), LENGTH_LONG).show();
                }
                try{
                    lowerText = Integer.parseInt(((EditText)findViewById(R.id.lowerText)).getText().toString());
                }
                catch (Exception e){
                    Toast.makeText(PressureActivity.this, getText(R.string.error_lower), LENGTH_LONG).show();
                }
                try{
                    pulsetText = Integer.parseInt(((EditText)findViewById(R.id.pulsetText)).getText().toString());
                }
                catch (Exception e){
                    Toast.makeText(PressureActivity.this, getText(R.string.error_pulse), LENGTH_LONG).show();
                }
                
                CheckBox checkBox = (CheckBox)findViewById(R.id.tachycardiaBox);
                boolean tachycardiaBox = checkBox.isChecked();
                try{
                    String datas = ((EditText)findViewById(R.id.dateTextPressure)).getText().toString();
                    data = Pressure.dateReturn(datas);
                }
                catch (Exception e){
                   Toast.makeText(PressureActivity.this, getText(R.string.error_data), LENGTH_LONG);
                }
                
                Pressure.pressures.add(new Pressure(topText, lowerText, pulsetText, tachycardiaBox, data));
                Toast.makeText(PressureActivity.this, getText(R.string.save), LENGTH_LONG).show();
            }
        });
    }



}
