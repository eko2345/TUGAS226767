package com.example.tugas22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.Key;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView result;
    Button btnGetData, btnClearData;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    String getName;
    int getNumber;


    public static final String session      =   "session";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        result      =   findViewById(R.id.tv_result);
        btnGetData  =   findViewById(R.id.btn_get_data);
        btnClearData=   findViewById(R.id.btn_clear);
    }
    void getData(){
        pref          =   getSharedPreferences(session, MODE_PRIVATE);
        getName       =   pref.getString ( "getname",  "NOT FOUND");
        getNumber     =   pref.getInt ("getnumber",  0);

        result.setText("Result : "+getName+ "And Number" +getNumber);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_get_data:
                getData();

                break;

            case R.id.btn_clear:
                editor      =   pref.edit();
                editor.remove("getname");
                editor.remove("getnumber");
                //editor.clear();
                editor.commit();
                getData();
                break;
        }
    }
}