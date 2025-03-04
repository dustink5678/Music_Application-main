package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Student extends User {
    private ArrayList<Lesson> enrolledLessons;
    private final int skillLevel;
    private final ArrayList<Song> practiceList;
    private HashMap<String, Integer> progress; // Using String (song ID) as key

    public Student(String username, String email, String password, LocalDateTime joinDate, 
                  ArrayList<Song> favorites, String UUID, ArrayList<Lesson> enrolledLessons, 
                  int skillLevel, ArrayList<Song> practiceList, HashMap<String, Integer> progress) {
        super(username, email, password, joinDate, favorites, UUID);
        this.enrolledLessons = enrolledLessons;
        this.skillLevel = skillLevel;
        this.practiceList = practiceList;
        this.progress = progress;
    }
    
    @Override
    public String getType() {
        return "Student";
    }

    public ArrayList<Lesson> getEnrolledLessons() {
        return enrolledLessons;
    }

    public ArrayList<Song> getPracticeList() {
        return practiceList;
    }

    public HashMap<String, Integer> getProgress() {
        return progress;
    }

    public void enrollInLesson(Lesson lesson) {
        if (enrolledLessons == null) {
            enrolledLessons = new ArrayList<>();
        }
        enrolledLessons.add(lesson);
    }

    public void updateProgress(Song song, int value) {
        if (progress == null) {
            progress = new HashMap<>();
        }
        progress.put(song.getId(), value);
    }

    public int getSkillLevel() {
        return skillLevel;
    }
}