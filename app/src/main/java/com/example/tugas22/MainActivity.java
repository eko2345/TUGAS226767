package com.example.tugas22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText user, number;
    Button btnSend;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    public static final String session      =   "session";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user    = findViewById(R.id.et_name);
        number  = findViewById(R.id.et_number);
        btnSend = findViewById(R.id.btn_send);

        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_send:
                pref        =   getSharedPreferences(session, MODE_PRIVATE);
                editor      = pref.edit();
                editor.putString("getname", user.getText().toString());
                editor.putInt("getnumber", Integer.parseInt(number.getText().toString()));
                editor.apply();

                Intent moveActivity     =   new Intent(MainActivity.this, SecondActivity.class);
                startActivity(moveActivity);
                break;
        }
    }
}