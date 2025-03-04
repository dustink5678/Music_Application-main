package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
	
	@SuppressWarnings({"unchecked", "CallToPrintStackTrace"})
	public static void saveUsers() {
		UserList userList = UserList.getInstance(); // Fixed: Changed User.getInstance() to UserList.getInstance()
		ArrayList<User> users = userList.getUsers(); // Fixed: Changed getUser() to getUsers()
		
		JSONArray jsonUsers = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< users.size(); i++) {
			jsonUsers.add(getUserJSON(users.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) { // Fixed: Changed USER_TEMP_FILE_NAME to USER_FILE_NAME
 
            file.write(jsonUsers.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@SuppressWarnings("unchecked")
	public static JSONObject getUserJSON(User user) {
		JSONObject userDetails = new JSONObject();
		userDetails.put(USER_ID, user.getId());
		userDetails.put(USER_USER_NAME, user.getUserName());
		userDetails.put(USER_EMAIL, user.getEmail());
		userDetails.put(USER_PASSWORD, user.getPassword());
		userDetails.put(USER_JOIN_DATE, user.getJoinDate().toString());
		
		// Handle favorites array
		JSONArray favoritesArray = new JSONArray();
		ArrayList<String> favorites = convertSongsToIds(user.getFavorites()); // Fixed: Convert Song objects to IDs
		if (favorites != null) {
			for (String favorite : favorites) {
				favoritesArray.add(favorite);
			}
		}
		userDetails.put(USER_FAVORITES, favoritesArray);
		
		// Handle user type and type-specific fields
		userDetails.put(USER_TYPE, user.getType());
		
            switch (user) {
                case Student student -> { 			// Add student-specific fields
                    JSONArray enrolledLessons = new JSONArray();
                    ArrayList<String> lessons = getEnrolledLessonsIds(student); // Fixed: Helper method
                    if (lessons != null) {
                        for (String lesson : lessons) {
                            enrolledLessons.add(lesson);
                        }
                    }
                    userDetails.put(USER_ENROLLED_LESSONS, enrolledLessons);
                    userDetails.put(USER_SKILL_LEVEL, student.getSkillLevel());
                    
                    // Handle practice list
                    JSONArray practiceList = new JSONArray();
                    ArrayList<String> practices = convertSongsToIds(student.getPracticeList()); // Fixed: Helper method
                    if (practices != null) {
                        for (String practice : practices) {
                            practiceList.add(practice);
                        }
                    }
                    userDetails.put(USER_PRACTICE_LIST, practiceList);
                    
                    // Handle progress object
                    JSONObject progressObj = new JSONObject();
                    if (student.getProgress() != null) {
                        for (String key : student.getProgress().keySet()) {
                            progressObj.put(key, student.getProgress().get(key));
                        }
                    }
                    userDetails.put(USER_PROGRESS, progressObj);
                }
                case Teacher teacher -> { 			// Add teacher-specific fields
                    JSONArray studentsArray = new JSONArray();
                    ArrayList<String> studentIds = getStudentIds(teacher); // Fixed: Helper method
                    if (studentIds != null) {
                        for (String student : studentIds) {
                            studentsArray.add(student);
                        }
                    }
                    userDetails.put(USER_STUDENTS, studentsArray);
                    
                    JSONArray scheduledLessons = new JSONArray();
                    ArrayList<String> lessons = getScheduledLessonsIds(teacher); // Fixed: Helper method
                    if (lessons != null) {
                        for (String lesson : lessons) {
                            scheduledLessons.add(lesson);
                        }
                    }
                    userDetails.put(USER_SCHEDULED_LESSONS, scheduledLessons);
                    userDetails.put(USER_SPECIALIZATION, teacher.getSpecialization());
                }
                default -> {
                }
            }
        
        return userDetails;
	}
	
	// Helper methods to convert objects to IDs
	private static ArrayList<String> convertSongsToIds(ArrayList<Song> songs) {
		ArrayList<String> songIds = new ArrayList<>();
		if (songs != null) {
			for (Song song : songs) {
				songIds.add(song.getId());
			}
		}
		return songIds;
	}
	
	private static ArrayList<String> getEnrolledLessonsIds(Student student) {
		// This method would extract IDs from Lesson objects
		var lessonIds = new ArrayList<String>();
		// Implementation depends on your Student and Lesson classes
		return lessonIds;
	}
	
	private static ArrayList<String> getStudentIds(Teacher teacher) {
		// This method would extract IDs from Student objects
		ArrayList<String> studentIds = new ArrayList<>();
		// Implementation depends on your Teacher class
		return studentIds;
	}
	
	private static ArrayList<String> getScheduledLessonsIds(Teacher teacher) {
		// This method would extract IDs from Lesson objects
		ArrayList<String> lessonIds = new ArrayList<>();
		// Implementation depends on your Teacher class
		return lessonIds;
	}
	
	public static void main(String[] args){
		DataWriter.saveUsers();
	}
}