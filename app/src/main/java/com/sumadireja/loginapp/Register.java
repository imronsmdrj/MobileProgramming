package com.sumadireja.loginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText userName = (EditText)findViewById(R.id.etUser);
        final EditText pass = (EditText)findViewById(R.id.etPass);
        Button btn = (Button)findViewById(R.id.btnReg);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                String userr = userName.getText().toString();
                String passs = pass.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();

                editor.putString(userr + passs + "data", userr);
                editor.commit();

                Intent i = new Intent(Register.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
}
