package com.example.aa.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.commonlib.annotation.aspectj.Permission;

public class MainActivity extends AppCompatActivity {

    @Override
    @Permission("test")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
