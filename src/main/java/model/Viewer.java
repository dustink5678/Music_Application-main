public class Viewer {
    private Song currentSong;
    private int currentPosition;
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
