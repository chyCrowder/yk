package com.example.a90575.categorydemo.view.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.a90575.categorydemo.R;
import com.example.a90575.categorydemo.view.fragments.LeftFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.left_frame,new LeftFragment()).commit();
    }
}
