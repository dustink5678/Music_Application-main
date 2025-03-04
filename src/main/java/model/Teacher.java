package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Teacher extends User {
    private ArrayList<Student> students;
    private ArrayList<Lesson> scheduledLessons;
    private String specialization;

    public Teacher(String username, String email, String password, LocalDateTime joinDate, 
                  ArrayList<Song> favorites, String UUID, ArrayList<Student> students,
                  ArrayList<Lesson> scheduledLessons, String specialization) {
        super(username, email, password, joinDate, favorites, UUID);
        this.students = students;
        this.scheduledLessons = scheduledLessons;
        this.specialization = specialization;
    }
    
    @Override
    public String getType() {
        return "Teacher";
    }

    public boolean addStudent(String username) {
        // Look up student in UserList and add to students list
        UserList userList = UserList.getInstance();
        User user = userList.getUser(username);
        
        if (user instanceof Student) {
            if (students == null) {
                students = new ArrayList<>();
            }
            students.add((Student) user);
            return true;
        }
        return false;
    }

    public void scheduleLesson(Lesson lesson) {
        if (scheduledLessons == null) {
            scheduledLessons = new ArrayList<>();
        }
        scheduledLessons.add(lesson);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Lesson> getScheduledLessons() {
        return scheduledLessons;
    }

    public String getSpecialization() {
        return specialization;
    }
}