package com.example.spisokdeljavalect;

public class Note {

        private int id;
        private String text;
        private int priority;

        public void setId(int id) {
            this.id = id;
        }

        public void setText(String text) {
            this.text = text;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public Note(int id, String text, int priority) {
            this.id = id;
            this.text = text;
            this.priority = priority;
        }

        public int getId() {
            return id;
        }

        public String getText() {
            return text;
        }

        public int getPriority() {
            return priority;
        }

}
