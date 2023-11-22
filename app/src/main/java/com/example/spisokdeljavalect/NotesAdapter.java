package com.example.spisokdeljavalect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder>
{

    private ArrayList<Note> notes = new ArrayList<Note>();
    private OnNoteClickListener onNoteClickListener;
    public void setOnNoteClickListener(OnNoteClickListener onNoteClickListener) {
        this.onNoteClickListener = onNoteClickListener;
    }

    public ArrayList<Note> getNotes() {
        return new ArrayList<Note>(notes);
    }
    public  void setNotes(ArrayList<Note> notes)
    {
        this.notes = notes;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,
                parent, false);

        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NotesViewHolder holder, int position) {
        Note note = notes.get(position);

        holder.textViewNote.setText(note.getText());

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
        int color = ContextCompat.getColor(holder.itemView.getContext(), colorResId);
        holder.textViewNote.setBackgroundColor(color);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onNoteClickListener!=null)
                    onNoteClickListener.onNoteClick(note);
            }
        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    protected class NotesViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewNote;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNote = itemView.findViewById(R.id.textViewNode);
        }
    }

    interface OnNoteClickListener
    {
        void onNoteClick(Note note);
    }
}
