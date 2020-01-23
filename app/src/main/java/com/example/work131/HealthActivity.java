package com.example.work131;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class HealthActivity extends AppCompatActivity {
    private static final String TAG = "MyApp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        Button saveButtonHead = (Button) findViewById(R.id.saveButtonHead);
        saveButtonHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,getString(R.string.log_save_h));
                double weightText = 0.0;
                int stepText = 0;
                try{
                    weightText = Double.parseDouble(((EditText)findViewById(R.id.weightText)).getText().toString());
                }
                catch (Exception e){
                    Toast.makeText(HealthActivity.this, getText(R.string.error_weight), LENGTH_LONG).show();
                }
                try{
                    stepText = Integer.parseInt(((EditText)findViewById(R.id.stepText)).getText().toString());
                }
                catch (Exception e){
                    Toast.makeText(HealthActivity.this, getText(R.string.error_step), LENGTH_LONG).show();
                }
                Health.health.add(new Health(weightText, stepText));
                Toast.makeText(HealthActivity.this, getText(R.string.save), LENGTH_LONG).show();
            }
        });
    }
}
