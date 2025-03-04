package model;

import java.util.ArrayList;

public class Bar {
    @SuppressWarnings("unused")
    private final TimeSignature timeSignature;
    @SuppressWarnings("unused")
    private final KeySignature keySignature;
    @SuppressWarnings("unused")
    private ArrayList<Note> notes;
    @SuppressWarnings("unused")
    private ArrayList<Rest> rests;

    public Bar(TimeSignature timeSignature, KeySignature keySignature) {
        this.timeSignature = timeSignature;
        this.keySignature = keySignature;
    }

    public void addNote(Note note) {

    }

    public void removeNote(double position) {

    }

    public void addRest(Rest rest) {

    }

}
