package com.example.sushanth.personactivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CountryAndState extends AppCompatActivity implements Statefragment.returnstate, Countryfragment.returncountry {
    Button done1, cancel1;
    String state;
    String country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_and_state);
        done1 = (Button) findViewById(R.id.done1);
        cancel1 = (Button) findViewById(R.id.cancel1);
        android.support.v4.app.FragmentManager fragments = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragments.beginTransaction();
        Countryfragment fragment = new Countryfragment();
        fragmentTransaction.replace(R.id.fragmentcontainer, fragment);


        fragmentTransaction.commit();

    }
    public void back1(View Button){
        finish();
    }

    public void done1(View Button){
        Intent toPassBack = getIntent();
        toPassBack.putExtra("Country", country+" and  "+ state);
        setResult(RESULT_OK, toPassBack);
        finish();

    }

    public void printstate(String stater){
        state = stater;
    }
    public void printcountry(String countryr){
        country = countryr;
    }

}
