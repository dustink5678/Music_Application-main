package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import json.simple.JSONArray;
import json.simple.JSONObject;

public class DataWriter extends DataConstants {
	
	public static void saveUsers() {
		User users = User.getInstance();
		ArrayList<User> userList = users.getUser();
		
		JSONArray jsonUsers = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< userList.size(); i++) {
			jsonUsers.add(getUserJSON(userList.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(USER_TEMP_FILE_NAME)) {
 
            file.write(jsonUsers.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getUserJSON(User user) {
		JSONObject userDetails = new JSONObject();
		userDetails.put(USER_ID, user.getId().toString());
		userDetails.put(USER_USER_NAME, user.getUserName());
		userDetails.put(USER_EMAIL, user.getEmail());
		userDetails.put(USER_PASSWORD, user.getPassword());
		userDetails.put(USER_JOIN_DATE, user.getJoinDate());
		
		// Handle favorites array
		JSONArray favoritesArray = new JSONArray();
		ArrayList<String> favorites = user.getFavorites();
		if (favorites != null) {
			for (String favorite : favorites) {
				favoritesArray.add(favorite);
			}
		}
		userDetails.put(USER_FAVORITES, favoritesArray);
		
		// Handle user type and type-specific fields
		userDetails.put(USER_TYPE, user.getType());
		
		if (user.getType().equals("Student")) {
			// Add student-specific fields
			JSONArray enrolledLessons = new JSONArray();
			ArrayList<String> lessons = user.getEnrolledLessons();
			if (lessons != null) {
				for (String lesson : lessons) {
					enrolledLessons.add(lesson);
				}
			}
			userDetails.put(USER_ENROLLED_LESSONS, enrolledLessons);
			userDetails.put(USER_SKILL_LEVEL, user.getSkillLevel());
			
			// Handle practice list
			JSONArray practiceList = new JSONArray();
			ArrayList<String> practices = user.getPracticeList();
			if (practices != null) {
				for (String practice : practices) {
					practiceList.add(practice);
				}
			}
			userDetails.put(USER_PRACTICE_LIST, practiceList);
			
			// Handle progress object
			JSONObject progressObj = new JSONObject();
			if (user.getProgress() != null) {
				for (String key : user.getProgress().keySet()) {
					progressObj.put(key, user.getProgress().get(key));
				}
			}
			userDetails.put(USER_PROGRESS, progressObj);
		} 
		else if (user.getType().equals("Teacher")) {
			// Add teacher-specific fields
			JSONArray studentsArray = new JSONArray();
			ArrayList<String> students = user.getStudents();
			if (students != null) {
				for (String student : students) {
					studentsArray.add(student);
				}
			}
			userDetails.put(USER_STUDENTS, studentsArray);
			
			JSONArray scheduledLessons = new JSONArray();
			ArrayList<String> lessons = user.getScheduledLessons();
			if (lessons != null) {
				for (String lesson : lessons) {
					scheduledLessons.add(lesson);
				}
			}
			userDetails.put(USER_SCHEDULED_LESSONS, scheduledLessons);
			userDetails.put(USER_SPECIALIZATION, user.getSpecialization());
		}
        
        return userDetails;
	}

	public static void main(String[] args){
		DataWriter.saveUsers();
	}
}