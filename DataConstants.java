public abstract class DataConstants {
	//USER OBJECT
	protected static final String USER_FILE = "JSON/Users.json";
	protected static final String USER_ID = "id";
	protected static final String USER_USER_NAME = "userName";
	protected static final String USER_FIRST_NAME = "firstName";
	protected static final String USER_LAST_NAME = "lastName";
	protected static final String USER_AGE = "age";
	protected static final String USER_PHONE_NUMBER = "phoneNumber";

    //CAMP OBJECT
	protected static final String CAMP_FILE = "JSON/camp.json";
    protected static final String CAMP_YEAR = "camp_year";
	protected static final String CAMP_NAME = "camp_name";
	protected static final String CAMP_ADDRESS = "camp_address";

	protected static final String CAMP_SESSIONS_TOTAL = "camp_sessions_total";
   	protected static final String CAMP_SESSIONS = "camp_sessions";
	
	protected static final String CAMP_CABIN_TOTAL = "camp_cabin_total";

	//SESSION OBJECT
	protected static final String SESSION_NUM = "session_number";
	protected static final String SESSION_THEME = "session_theme";
	protected static final String SESSION_DESCRIPTION = "session_description";

	protected static final String SESSION_STARTDATE = "session_startdate";
	protected static final String SESSION_ENDDATE = "session_enddate";

	protected static final String SESSION_CABINAMT = "session_cabinamt";

	//arraylists of the total cabins, counselors, and campers
	protected static final String SESSION_CABINS = "session_cabins";
	protected static final String SESSION_COUNSELORS = "session_counselors";
	protected static final String SESSION_CAMPERS = "session_campers";

	//ACTIVITY OBJECT
	protected static final String SESSION_ACTIVITY_NAME = "session_activity_name";
	protected static final String SESSION_ACTIVITY_LOCATION = "session_activity_location";
	protected static final String ALL_SESSION_ACTIVITIES = "all_session_activities";

	//COUNSELOR
	protected static final String COUNSELOR_FILE = "JSON/counselor.json";
	protected static final String CABIN_COUNSELOR = "cabin_counselor";
    protected static final String COUNSELOR_ID = "counselorUUID";

	//CAMPERS
	protected static final String CAMPER_FILE = "JSON/camper.json";
    protected static final String CABIN_CAMPERS = "cabin_campers";
	protected static final String CAMPER_ID = "counselorUUID";
    
	//CABINS OBJECT FOR REFERENCE
	protected static final String CABIN_FILE_NAME = "JSON/Cabins.json";
	protected static final String CABIN_ID = "cabinUUID";
	//would be a string array
	protected static final String CABIN_SCHEDULE = "cabin_schedule";

}