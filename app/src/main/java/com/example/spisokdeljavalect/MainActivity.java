package com.example.spisokdeljavalect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private LinearLayout linearLayoutNotes;
    private FloatingActionButton buttonAdd;

    private Database database =  Database.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AddNoteActivity.newIntent(MainActivity.this);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        showNotes();
    }
    private  void initViews()
    {
        linearLayoutNotes = findViewById(R.id.linearLayoutNotes);
        buttonAdd = findViewById(R.id.buttonAddNode);
    }

    private  void showNotes()
    {
        linearLayoutNotes.removeAllViews();
        for (Note note: database.getInstance().getNotes())
        {
            View view = getLayoutInflater().inflate(R.layout.note_item,
                    linearLayoutNotes, false);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    database.remove(note.getId());
                    showNotes();
                }
            });
            TextView textView = view.findViewById(R.id.textViewNode);
            textView.setText(note.getText());

            int colorResId;
            switch (note.getPriority())
            {
                case 0:
                    colorResId = android.R.color.holo_green_light;
                    break;
                case 1:
                    colorResId = android.R.color.holo_orange_dark;
                    break;
                default:
                    colorResId = android.R.color.holo_red_dark;
                    break;
            }
            int color = ContextCompat.getColor(this, colorResId);
            textView.setBackgroundColor(color);
            linearLayoutNotes.addView(view);
        }
    }
}