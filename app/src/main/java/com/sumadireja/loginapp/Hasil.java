package com.sumadireja.loginapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Hasil extends AppCompatActivity {

    public SharedPreferences predata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil);
        predata = getSharedPreferences("datapreferance", MODE_PRIVATE);

//        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        String hasil = predata.getString("hasil", "");

        TextView hsl = (TextView)findViewById(R.id.tvHasil);
        hsl.setText(hasil);
    }
}
