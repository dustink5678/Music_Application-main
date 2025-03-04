package model;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataLoader extends DataConstants {

    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        
        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray peopleJSON = (JSONArray)parser.parse(reader);
            
            for(int i=0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
                UUID id = UUID.fromString((String)personJSON.get(USER_ID));
                String userName = (String)personJSON.get(USER_USER_NAME);
                String email = (String)personJSON.get(USER_EMAIL);
                String password = (String)personJSON.get(USER_PASSWORD);
                LocalDateTime joinDate = LocalDateTime.parse((String)personJSON.get(USER_JOIN_DATE));
                
                // Process favorites list
                ArrayList<String> favorites = new ArrayList<>();
                JSONArray favoritesJSON = (JSONArray)personJSON.get(USER_FAVORITES);
                if (favoritesJSON != null) {
                    for (int j = 0; j < favoritesJSON.size(); j++) {
                        favorites.add((String)favoritesJSON.get(j));
                    }
                }
                
                String type = (String)personJSON.get(USER_TYPE);
                
                // Create user based on type
                if (type.equals("Student")) {
                    // Handle student-specific fields
                    ArrayList<String> enrolledLessons = new ArrayList<>();
                    JSONArray lessonsJSON = (JSONArray)personJSON.get(USER_ENROLLED_LESSONS);
                    if (lessonsJSON != null) {
                        for (int j = 0; j < lessonsJSON.size(); j++) {
                            enrolledLessons.add((String)lessonsJSON.get(j));
                        }
                    }
                    
                    int skillLevel = ((Long)personJSON.get(USER_SKILL_LEVEL)).intValue();
                    
                    ArrayList<String> practiceList = new ArrayList<>();
                    JSONArray practiceJSON = (JSONArray)personJSON.get(USER_PRACTICE_LIST);
                    if (practiceJSON != null) {
                        for (int j = 0; j < practiceJSON.size(); j++) {
                            practiceList.add((String)practiceJSON.get(j));
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
                    
                    // Create Student object - make sure to modify this to match your Student constructor
                    // users.add(new Student(id, userName, email, password, joinDate, favorites, enrolledLessons, skillLevel, practiceList, progress));
                    
                } else if (type.equals("Teacher")) {
                    // Handle teacher-specific fields
                    ArrayList<String> students = new ArrayList<>();
                    JSONArray studentsJSON = (JSONArray)personJSON.get(USER_STUDENTS);
                    if (studentsJSON != null) {
                        for (int j = 0; j < studentsJSON.size(); j++) {
                            students.add((String)studentsJSON.get(j));
                        }
                    }
                    
                    ArrayList<String> scheduledLessons = new ArrayList<>();
                    JSONArray lessonsJSON = (JSONArray)personJSON.get(USER_SCHEDULED_LESSONS);
                    if (lessonsJSON != null) {
                        for (int j = 0; j < lessonsJSON.size(); j++) {
                            scheduledLessons.add((String)lessonsJSON.get(j));
                        }
                    }
                    
                    String specialization = (String)personJSON.get(USER_SPECIALIZATION);
                    
                    // Create Teacher object - make sure to modify this to match your Teacher constructor
                    // users.add(new Teacher(id, userName, email, password, joinDate, favorites, students, scheduledLessons, specialization));
                }
            }
            
            return users;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        
        return users;
    }

    public static void main(String[] args) {
        ArrayList<User> users = DataLoader.getUsers();
        System.out.println("Number of users loaded: " + users.size());
        for (User user : users) {
            System.out.println(user.getUsername());
        }
    }
}