package com.example.spisokdeljavalect;

import java.util.ArrayList;
import java.util.Random;

public class Database {
    private ArrayList<Note> notes = new ArrayList<>();

    // сингелтон
    public static Database instance = null;

    public static Database getInstance()
    {
        if (instance == null) {
            instance = new Database();
            return instance;
        }
        else
            return instance;
    }
    public void add(Note note)
    {
        notes.add(note);
    }

    public Database() {
        Random random = new Random();
        for (int i=0; i<20; i++)
        {
            Note note = new Note(i, "Note "+i, random.nextInt(3));
            notes.add(note);
        }
    }

    public void remove(int id)
    {
        for (int i=0; i< notes.size(); i++)
        {
            Note note = notes.get(i);
            if (id == note.getId())
                notes.remove(note);
        }
    }

    public ArrayList<Note> getNotes() {
        return new ArrayList<Note>(notes);
    }

}
