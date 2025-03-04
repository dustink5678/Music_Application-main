package javafxbackround.program;
import javafxbackround.music.Music;

public class MusicPlayer {
    public void playSong() {
        try {
            playHappyBirthday();
            Thread.sleep(500);
            playHappyBirthday();
            Thread.sleep(500);
            playHappyBirthdayDear();
            Thread.sleep(500);
            playHappyBirthday();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    private void playHappyBirthday() {
        Music.playNote("C");
        Music.playNote("C");
        Music.playNote("D");
        Music.playNote("C");
        Music.playNote("F");
        Music.playNote("E");
    }

    private void playHappyBirthdayDear() {
        Music.playNote("C");
        Music.playNote("C");
        Music.playNote("G");
        Music.playNote("E");
        Music.playNote("D");
        Music.playNote("C");
    }

    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        player.playSong();
    }
}