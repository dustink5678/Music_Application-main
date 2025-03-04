package model;


public abstract class DataConstants {
	protected static final String USER_FILE_NAME = "json/users.json";

    protected static final String USER_ID = "id";
    protected static final String USER_USER_NAME = "userName";
    protected static final String USER_EMAIL = "email";
    protected static final String USER_PASSWORD = "password";
    protected static final String USER_JOIN_DATE = "joinDate";
    protected static final String USER_FAVORITES = "favorites";
    protected static final String USER_TYPE = "type";


     // Student specific keys
     protected static final String USER_ENROLLED_LESSONS = "enrolledLessons";
     protected static final String USER_SKILL_LEVEL = "skillLevel";
     protected static final String USER_PRACTICE_LIST = "practiceList";
     protected static final String USER_PROGRESS = "progress";
     
     // Teacher specific keys
     protected static final String USER_STUDENTS = "students";
     protected static final String USER_SCHEDULED_LESSONS = "scheduledLessons";
     protected static final String USER_SPECIALIZATION = "specialization";
}