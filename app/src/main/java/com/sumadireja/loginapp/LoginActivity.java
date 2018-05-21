package com.sumadireja.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    public SharedPreferences predata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText et1 = (EditText)findViewById(R.id.etUname);
        final EditText et2 = (EditText)findViewById(R.id.etPasswd);

        Button btnReg = (Button)findViewById(R.id.btnRegis);
        Button btnLog = (Button)findViewById(R.id.btnLogin);

        predata = getSharedPreferences("datapreferance", MODE_PRIVATE);

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = et1.getText().toString();
                String pass = et2.getText().toString();

                SharedPreferences preferences = predata;

                String details = preferences.getString(user + pass + "data", "Username or password is Incorrect.");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("hasil", details);
                editor.commit();

                Intent i = new Intent(LoginActivity.this, Hasil.class);
                startActivity(i);
            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, Register.class);
                startActivity(i);
            }
        });
    }
}
