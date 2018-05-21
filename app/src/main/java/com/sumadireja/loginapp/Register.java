package com.sumadireja.loginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity {

    public SharedPreferences predata;
    TextView tVTampilData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        predata = getSharedPreferences("datapreferance", MODE_PRIVATE);
        Button btn = (Button) findViewById(R.id.btnReg);

    }
            public void alibaba(View view) {

                final EditText userName = (EditText) findViewById(R.id.etUser);
                final EditText pass = (EditText) findViewById(R.id.etPass);
                String userr = userName.getText().toString();
                String passs = pass.getText().toString();

                SharedPreferences.Editor editor = predata.edit();

                editor.putString("nama",userr);
                editor.commit();


            }

            public void backtologin (View view){
                final EditText userName = (EditText) findViewById(R.id.etUser);
                final EditText pass = (EditText) findViewById(R.id.etPass);
                String userr = userName.getText().toString();
                String passs = pass.getText().toString();

                SharedPreferences.Editor editor = predata.edit();

                editor.putString(userr + passs + "data", userr);
                editor.commit();

                Intent i = new Intent(Register.this, LoginActivity.class);
                startActivity(i);
            }

    public void tampilData(View view) {
        String username = predata.getString("nama", "data tidak ada broo");
        tVTampilData = (TextView) findViewById(R.id.TVUser);
        tVTampilData.setText(username);
    }

    public void simpanData(View view){
        SharedPreferences.Editor editor = predata.edit();
        final EditText userName = (EditText)findViewById(R.id.etUser);
        String getNama = userName.getText().toString();
        editor.putString("nama",getNama);
        editor.commit();

    }
}
