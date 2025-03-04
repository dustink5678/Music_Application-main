import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private ArrayList<Lesson> enrolledLessons;
    private int skillLevel;
    private ArrayList<Song> practiceList;
    private HashMap<Song, Integer> progress;

    public void enrollInLesson(Lesson lesson) {

    }

    public void updateProgress(Song song, int number) {

    }

    public int getSkillLevel() {
        return skillLevel;
    }
}
