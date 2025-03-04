package model;

public class Viewer {
    @SuppressWarnings("unused")
    private Song currentSong;
    @SuppressWarnings("unused")
    private int currentPosition;
    @SuppressWarnings("unused")
    private boolean isPlaying;

    public void play() {
        isPlaying = true;
    }

    public void pause() {
        isPlaying = false;
    }

    public void seek(int position) {

    }
}
