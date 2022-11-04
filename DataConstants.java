import java.util.UUID;

public abstract class DataConstants {
	//USER OBJECT
	protected static final String USER_FILE_NAME = "Users.json";
	protected static final String USER_ID = "id";
	protected static final String USER_USER_NAME = "userName";
	protected static final String USER_FIRST_NAME = "firstName";
	protected static final String USER_LAST_NAME = "lastName";
	protected static final String USER_AGE = "age";
	protected static final String USER_PHONE_NUMBER = "phoneNumber";

    //do these ones later they the complicated ones.
    // protected static final String USER_ALLERGIES = "allergies";
    // protected static final String USER_EMERGENCY_CONTACTS = "emergencyContacts";

	//CABINS OBJECT FOR REFERENCE
	protected static final String CABIN_FILE_NAME = "Cabins.json";
	protected static final String CABIN_ID = "id";
	protected static final String CABIN_TITLE = "cabinTitle";
	protected static final String CABIN_AGE_MAX = "maxAge";
	protected static final String CABIN_AGE_MIN = "ageMin";
	protected static final int CAMPER_AMOUNT = 0; 
	protected static final String CABIN_AUTHOR = "cabinAuthor";//?
	


	//Schedule constants.
	protected static final String SCHEDULE_FILE_NAME = "Schedules.json";

	//CAMPERS GUARDIAN OBJECT.
	protected static final String CAMPER_GUARDIAN_USERNAME = "userName";
	protected static final String CAMPER_GUARDIAN_PASSWORD = "password";
	protected static final String CAMPER_GUARDIAN_FIRST_NAME = "firstName";
	protected static final String CAMPER_GUARDIAN_LAST_NAME = "lastName";
	protected static final String CAMPER_GUARDIAN_ID = "id";
	protected static final String CAMPER_GUARDIAN_AGE = "age";
	protected static final String CAMPER_GUARDIAN_PHONE_NUMBER = "phoneNumber";
	protected static final String CAMPER_GUARDIAN_FILE_NAME= "camperGuardian.json";
	protected static final String CAMPER_GUARDIAN_REG_CAMPER = "regCampers";

	//CAMPERS OBJECT
	protected static final String CAMPERS_FILE_NAME = "Campers.json";
	protected static final String CAMPERS_FIRST_NAME = "firstName";
	protected static final String CAMPERS_LAST_NAME = "lastName";
	protected static final String CAMPERS_ID = "id";
	protected static final String CAMPERS_AGE ="AGE"; //age is a string but they will input a number.
	protected static final String CAMPERS_EC = "EC";

	//CAMP DIRECTOR OBJECT.
	protected static final String CAMP_DIRECTOR_FILE_NAME = "Campdirector.json";
	protected static final String CAMP_DIRECTOR_FIRST_NAME = "firstName";
	protected static final String CAMP_DIRECTOR_LAST_NAME = "lastName";
	protected static final String CAMP_DIRECTOR_ID = "id";
	protected static final String CAMP_DIRECTOR_AGE = "age";
	protected static final String CAMP_DIRECTOR_USER_NAME = "userName";
	protected static final String CAMP_DIRECTOR_PASSWORD = "password";
	protected static final String CAMP_DIRECTOR_PHONE_NUMBER = "phoneNumber";

	//EMERGENCY CONTACTS OBJECT.
	protected static final String EMERGNCY_CONTACT_FIRST_NAME = "firstName";
	protected static final String EMERGNCY_CONTACT_LAST_NAME = "lastName";
	protected static final int EMERGNCY_CONTACT_AGE = 0;
	protected static final String EMERGNCY_CONTACT_PHONE_NUMBER = "phoneNumber";
	protected static final String EMERGNCY_CONTACT_EMAIL = "email";
	protected static final String EMERGNCY_CONTACT_FILE_NAME = "EmergencyContacts.json";

	//SCHEDULE OBJECT
	protected static final UUID SCHEDULE_ID = "id";




	

}