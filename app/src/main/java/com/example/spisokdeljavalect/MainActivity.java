package com.example.spisokdeljavalect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private LinearLayout linearLayoutNotes;
    private FloatingActionButton buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private  void initViews()
    {
        linearLayoutNotes = findViewById(R.id.linearLayoutNotes);
        buttonAdd = findViewById(R.id.buttonAddNode);
    }
}