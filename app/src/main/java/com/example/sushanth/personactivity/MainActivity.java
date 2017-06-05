package com.example.sushanth.personactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText user_fname, user_lname, user_age, user_email, user_phone;
    TextView displaydate, placeselected;
    Button user_done;
    String prefName = "MyPref";
    SharedPreferences sharedPreferences;
    private static final int INTENT_EXAMPLE_REQUEST = 123;
    private static final int INTENT_EXAMPLE_REQUEST1 = 1234;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user_fname = (EditText) findViewById(R.id.user_fname);
        user_lname = (EditText) findViewById(R.id.user_lname);
        user_age = (EditText) findViewById(R.id.user_age);
        user_email = (EditText) findViewById(R.id.user_email);
        user_phone = (EditText) findViewById(R.id.user_phone);
        displaydate = (TextView) findViewById(R.id.displaydate);
        placeselected = (TextView) findViewById(R.id.placeselected);
        user_done = (Button) findViewById(R.id.user_done);

        sharedPreferences = getSharedPreferences(prefName, MODE_PRIVATE);
        user_fname.setText(sharedPreferences.getString("firstname" , ""));
        user_lname.setText(sharedPreferences.getString("lastname" , ""));
        user_age.setText(sharedPreferences.getString("age" , ""));
        user_email.setText(sharedPreferences.getString("email" , ""));
        user_phone.setText(sharedPreferences.getString("phone" , ""));
        displaydate.setText(sharedPreferences.getString("date" , ""));
        placeselected.setText(sharedPreferences.getString("place" , ""));


    }
    public void done(View Button){
        sharedPreferences = getSharedPreferences(prefName,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("firstname",user_fname.getText().toString());
        editor.putString("lastname",user_lname.getText().toString());
        editor.putString("age",user_age.getText().toString());
        editor.putString("email",user_email.getText().toString());
        editor.putString("phone",user_phone.getText().toString());
        editor.putString("date",displaydate.getText().toString());
        editor.putString("place",placeselected.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data is Saved", Toast.LENGTH_SHORT).show();



    }


    public void go(View Button){
        Intent go = new Intent(this, DateSelection.class);
        startActivityForResult(go, INTENT_EXAMPLE_REQUEST);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == INTENT_EXAMPLE_REQUEST) {
            switch (resultCode) {
                case RESULT_OK:
                    String editedAge = data.getStringExtra("date");
                    displaydate.setText(editedAge);
                    Toast.makeText(this, "Date is set", Toast.LENGTH_SHORT).show();
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "Date is not set", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
        if (requestCode == INTENT_EXAMPLE_REQUEST1) {
            switch (resultCode) {
                case RESULT_OK:
                    String getcountryandstate = data.getStringExtra("Country");
                    placeselected.setText(getcountryandstate);
                    Toast.makeText(this, "Place is set", Toast.LENGTH_SHORT).show();
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "Place is not set", Toast.LENGTH_SHORT).show();
                    break;
            }
        }


    }

    public void go1(View Button){
        Intent go1 = new Intent(this, CountryAndState.class);
        startActivityForResult(go1,INTENT_EXAMPLE_REQUEST1);
    }

}
