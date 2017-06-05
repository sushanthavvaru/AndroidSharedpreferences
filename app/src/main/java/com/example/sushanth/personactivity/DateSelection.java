package com.example.sushanth.personactivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

public class DateSelection extends AppCompatActivity {
    DatePicker datepick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_selection);
        datepick = (DatePicker) findViewById(R.id.datePicker4);


    }
    public void back(View button) {
        finish();
    }
    public void saveDate(View v)
    {
        int day=datepick.getDayOfMonth();
        int month=datepick.getMonth() + 1;
        int year= datepick.getYear();
        System.out.println(month+"/"+day+"/"+year);
        Intent toPassBack = getIntent();
        toPassBack.putExtra("date", month+"/"+day+"/"+year);
        setResult(RESULT_OK, toPassBack);
        finish();

    }
}
