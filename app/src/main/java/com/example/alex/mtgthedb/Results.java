package com.example.alex.mtgthedb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Browse browse = new Browse();

        browse.printFoundCards();
    }
}
