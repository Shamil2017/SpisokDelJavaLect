package com.example.spisokdeljavalect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

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

    private ArrayList<Note> notes = new ArrayList<Note>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        Random rand = new Random();
        for (int i=0; i<20; i++) {
            Note note = new Note(i, "Note "+i, rand.nextInt(3));
            notes.add(note);
        }
        showNotes();
    }

    private  void initViews()
    {
        linearLayoutNotes = findViewById(R.id.linearLayoutNotes);
        buttonAdd = findViewById(R.id.buttonAddNode);
    }

    private  void showNotes()
    {
        for (Note note: notes)
        {
            View view = getLayoutInflater().inflate(R.layout.note_item,
                    linearLayoutNotes, false);
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