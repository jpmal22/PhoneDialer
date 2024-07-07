package com.example.phonedialer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.net.URI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //Activity data members, initialising buttons and text view
    private Button backspace, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnstar, btn0, btnhash, call;
    private TextView pNumber;

    //method to set intent and start activity
    void makephonecall(){
        //creating a string from pNumber for the intent
        String number = pNumber.getText().toString();
        Intent callintent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
        startActivity(callintent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //runtime permissions
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.CALL_PHONE}, 0);
        }

        //setting layout
        setContentView(R.layout.activity_main);

        //using findViewByID for each button to return a View in the current layout
        backspace = findViewById(R.id.backspace);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnstar = findViewById(R.id.btnstar);
        btn0 = findViewById(R.id.btn0);
        btnhash = findViewById(R.id.btnhash);
        call = findViewById(R.id.call);
        pNumber = findViewById(R.id.pNumber);


        //adding onClickListeners to each button
        //passing the activity using this to avoid duplication of code
        //Main Activity implements View.OnClickListener interface
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnstar.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnhash.setOnClickListener(this);
        backspace.setOnClickListener(this);
        call.setOnClickListener(this);

    }

    //implementing onClick method
    //method uses switch statement to determine which button was clicked
    //when a button is clicked, pNumber textview is amended according to each button using setText
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                pNumber.setText(pNumber.getText().toString() + "1");
                break;
            case R.id.btn2:
                pNumber.setText(pNumber.getText().toString() + "2");
                break;
            case R.id.btn3:
                pNumber.setText(pNumber.getText().toString() + "3");
                break;
            case R.id.btn4:
                pNumber.setText(pNumber.getText().toString() + "4");
                break;
            case R.id.btn5:
                pNumber.setText(pNumber.getText().toString() + "5");
                break;
            case R.id.btn6:
                pNumber.setText(pNumber.getText().toString() + "6");
                break;
            case R.id.btn7:
                pNumber.setText(pNumber.getText().toString() + "7");
                break;
            case R.id.btn8:
                pNumber.setText(pNumber.getText().toString() + "8");
                break;
            case R.id.btn9:
                pNumber.setText(pNumber.getText().toString() + "9");
                break;
            case R.id.btnstar:
                pNumber.setText(pNumber.getText().toString() + "*");
                break;
            case R.id.btn0:
                pNumber.setText(pNumber.getText().toString() + "0");
                break;
            case R.id.btnhash:
                pNumber.setText(pNumber.getText().toString() + "#");
                break;
            case R.id.backspace:
                //creating a string of numbers from the textview
                String number = pNumber.getText().toString();
                //getting length of the string
                int numlength = number.length();
                //if the length is not greater than 0 then the text view is empty
                //only works if there is at least 1 character in the text view
                //sets the new pNumber to the string number minus the length of 1 to
                if (numlength > 0) {
                    pNumber.setText(number.substring(0, numlength - 1));
                }
                break;
            case R.id.call:
                //calls method with intent and startActivity
                makephonecall();
                break;
        }
    }
}