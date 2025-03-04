package model;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataLoader extends DataConstants {

    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        
        try {
            System.out.println("Attempting to load users from: " + USER_FILE_NAME);
            System.out.println("Current working directory: " + System.getProperty("user.dir"));

            @SuppressWarnings("ConvertToTryWithResources")

            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray peopleJSON = (JSONArray)parser.parse(reader);
            
            System.out.println("Found " + peopleJSON.size() + " users in JSON file");
            
            for(int i=0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
                String id = (String)personJSON.get(USER_ID);
                String userName = (String)personJSON.get(USER_USER_NAME);
                String email = (String)personJSON.get(USER_EMAIL);
                String password = (String)personJSON.get(USER_PASSWORD);
                LocalDateTime joinDate = LocalDateTime.parse((String)personJSON.get(USER_JOIN_DATE));
                
                // Process favorites list - convert from string IDs to Song objects
                ArrayList<Song> favorites = new ArrayList<>();
                JSONArray favoritesJSON = (JSONArray)personJSON.get(USER_FAVORITES);
                if (favoritesJSON != null) {
                    for (int j = 0; j < favoritesJSON.size(); j++) {
                        String songId = (String)favoritesJSON.get(j);
                        // You'll need to implement a method to lookup Songs by ID
                        Song song = findSongById(songId);
                        if (song != null) {
                            favorites.add(song);
                        }
                    }
                }
                
                String type = (String)personJSON.get(USER_TYPE);
                
                System.out.println("Processing user: " + userName + " of type: " + type);
                
                // Create user based on type
                if (type.equals("Student")) {
                    // Convert lesson IDs to Lesson objects
                    ArrayList<Lesson> enrolledLessons = new ArrayList<>();
                    JSONArray lessonsJSON = (JSONArray)personJSON.get(USER_ENROLLED_LESSONS);
                    if (lessonsJSON != null) {
                        for (int j = 0; j < lessonsJSON.size(); j++) {
                            String lessonId = (String)lessonsJSON.get(j);
                            Lesson lesson = findLessonById(lessonId);
                            if (lesson != null) {
                                enrolledLessons.add(lesson);
                            }
                        }
                    }
                    
                    int skillLevel = ((Long)personJSON.get(USER_SKILL_LEVEL)).intValue();
                    
                    // Convert practice list from string IDs to Song objects
                    ArrayList<Song> practiceList = new ArrayList<>();
                    JSONArray practiceJSON = (JSONArray)personJSON.get(USER_PRACTICE_LIST);
                    if (practiceJSON != null) {
                        for (int j = 0; j < practiceJSON.size(); j++) {
                            String songId = (String)practiceJSON.get(j);
                            Song song = findSongById(songId);
                            if (song != null) {
                                practiceList.add(song);
                            }
                        }
                    }
                    
                    HashMap<String, Integer> progress = new HashMap<>();
                    JSONObject progressJSON = (JSONObject)personJSON.get(USER_PROGRESS);
                    if (progressJSON != null) {
                        for (Object key : progressJSON.keySet()) {
                            String songId = (String)key;
                            int progressValue = ((Long)progressJSON.get(songId)).intValue();
                            progress.put(songId, progressValue);
                        }
                    }
                    
                    // Create Student object with correct parameters
                    users.add(new Student(userName, email, password, joinDate, favorites, id,
                                          enrolledLessons, skillLevel, practiceList, progress));
                    
                } else if (type.equals("Teacher")) {
                    // Convert student IDs to Student objects
                    ArrayList<Student> studentsList = new ArrayList<>();
                    JSONArray studentsJSON = (JSONArray)personJSON.get(USER_STUDENTS);
                    if (studentsJSON != null) {
                        for (int j = 0; j < studentsJSON.size(); j++) {
                            String studentId = (String)studentsJSON.get(j);
                            Student student = findStudentById(studentId); 
                            if (student != null) {
                                studentsList.add(student);
                            }
                        }
                    }
                    
                    // Convert lesson IDs to Lesson objects
                    ArrayList<Lesson> scheduledLessons = new ArrayList<>();
                    JSONArray lessonsJSON = (JSONArray)personJSON.get(USER_SCHEDULED_LESSONS);
                    if (lessonsJSON != null) {
                        for (int j = 0; j < lessonsJSON.size(); j++) {
                            String lessonId = (String)lessonsJSON.get(j);
                            Lesson lesson = findLessonById(lessonId);
                            if (lesson != null) {
                                scheduledLessons.add(lesson);
                            }
                        }
                    }
                    
                    String specialization = (String)personJSON.get(USER_SPECIALIZATION);
                    
                    // Create Teacher object with correct parameters
                    users.add(new Teacher(userName, email, password, joinDate, favorites, id,
                                         studentsList, scheduledLessons, specialization));
                }
            }
            
            reader.close();
            return users;
            
        } catch (IOException e) {
            System.err.println("IO Error: " + e.getMessage());
        } catch (ParseException e) {
            System.err.println("JSON Parse Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected Error: " + e.getMessage());
        }
        
        return users;
    }
    
    // Helper methods to find objects by ID
    private static Song findSongById(String songId) {
        // Implement logic to find Song by ID
        // This is a placeholder - you'll need to implement this
        System.out.println("Looking up Song with ID: " + songId);
        return null; // For now, return null (you should implement proper lookup)
    }
    
    private static Lesson findLessonById(String lessonId) {
        // Implement logic to find Lesson by ID
        // This is a placeholder - you'll need to implement this
        System.out.println("Looking up Lesson with ID: " + lessonId);
        return null; // For now, return null (you should implement proper lookup)
    }
    
    private static Student findStudentById(String studentId) {
        // Implement logic to find Student by ID
        // This is a placeholder - you'll need to implement this
        System.out.println("Looking up Student with ID: " + studentId);
        return null; // For now, return null (you should implement proper lookup)
    }

    public static void main(String[] args) {
        ArrayList<User> users = DataLoader.getUsers();
        System.out.println("Number of users loaded: " + users.size());
        for (User user : users) {
            System.out.println(user.getUsername());
        }
    }
}