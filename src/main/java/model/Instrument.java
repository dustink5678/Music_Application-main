package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Instrument {
    private ArrayList<Character> noteNames;
    public HashMap<String, ArrayList<Character>> instrument; // Fixed: changed noteNames to ArrayList<Character>
    private String name;
    private String type;
    private String tuning;
    private int difficulty;
    private String key;

    public Instrument() {
        noteNames = new ArrayList<>();
        instrument = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getTuning() {
        return tuning;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getKey() {
        return key;
    }

    public void setTuning(String tuning) {
        this.tuning = tuning;
    }

    public void setInstrument(Instrument instrument) {
        // Implementation to set instrument details
    }
}