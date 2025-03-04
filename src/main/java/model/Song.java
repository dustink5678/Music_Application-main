package model;

import java.util.ArrayList;

public class Song {
    private String id;
    private String title;
    private ArrayList<ArrayList<Bar>> bars;
    @SuppressWarnings("unused")
    private boolean isPublic;
    private ArrayList<Comment> comments;
    @SuppressWarnings("unused")
    private Tempo tempo;
    private String genre;
    private User artist;
    private ArrayList<Instrument> instruments; // Fixed: Changed Arraylist to ArrayList

    public Song() {
        bars = new ArrayList<>();
        comments = new ArrayList<>();
        instruments = new ArrayList<>();
    }
    
    public Song(String id, String title, ArrayList<ArrayList<Bar>> bars, boolean isPublic, 
               ArrayList<Comment> comments, Tempo tempo, String genre, User artist,
               ArrayList<Instrument> instruments) {
        this.id = id;
        this.title = title;
        this.bars = bars;
        this.isPublic = isPublic;
        this.comments = comments;
        this.tempo = tempo;
        this.genre = genre;
        this.artist = artist;
        this.instruments = instruments;
    }

    public String getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public String getArtistName() {
        return artist != null ? artist.getUsername() : "";
    }
    
    public void newInstrument(ArrayList<ArrayList<Bar>> bars, Instrument instrument) {
        this.bars.addAll(bars);
        this.instruments.add(instrument);
    }

    public void addBar(Bar bar) {
        ArrayList<Bar> barList = new ArrayList<>();
        barList.add(bar);
        this.bars.add(barList);
    }

    public void addComment(User author, String comment) {
        Comment newComment = new Comment(this, comment, author, java.time.LocalDateTime.now());
        comments.add(newComment);
    }

    public ArrayList<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(ArrayList<Instrument> instruments) {
        this.instruments = instruments;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<ArrayList<Bar>> getBars() {
        return bars;
    }

    public void setBars(ArrayList<ArrayList<Bar>> bars) {
        this.bars = bars;
    }
}