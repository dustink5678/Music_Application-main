import java.util.ArrayList;

public class Bar {
    private TimeSignature timeSignature;
    private KeySignature keySignature;
    private ArrayList<Note> notes;
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
