package com.example.spisokdeljavalect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

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
    private RecyclerView recycleViewNotes;


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
        recycleViewNotes = findViewById(R.id.recycleViewNotes);
        buttonAdd = findViewById(R.id.buttonAddNode);
    }

    private  void showNotes()
    {
        linearLayoutNotes.removeAllViews();
        for (Note note: database.getInstance().getNotes())
        {

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    database.remove(note.getId());
                    showNotes();
                }
            });

            linearLayoutNotes.addView(view);
        }
    }
}