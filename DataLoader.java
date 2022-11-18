import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants{
	
	//LOADS USERS
	public static ArrayList<User> loadUsers() 
	{
		ArrayList<User> users = new ArrayList<User>();
		System.out.println();
		System.out.println("IN DATALOADER CLASS");
		System.out.println("new arraylist of type user is created.");

		try {
			//opens file from user_file_name
			FileReader reader = new FileReader(USER_FILE);
			//create json parser
			JSONParser parser = new JSONParser();

			//casts data from json file to array
			JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
			
			//loop through json array
			for(int i=0; i < peopleJSON.size(); i++) {
				//gets json object at the current location
				JSONObject personJSON = (JSONObject)peopleJSON.get(i);

				//gets each field for the user object and converts to right data type by casting
				UUID id = UUID.fromString((String)personJSON.get(USER_ID));
				String userName = (String)personJSON.get(USER_USER_NAME);
				String firstName = (String)personJSON.get(USER_FIRST_NAME);
				String lastName = (String)personJSON.get(USER_LAST_NAME);
				
				//age is stored as a long?? get's the int value from the string and then converts it???
				int age = ((Long)personJSON.get(USER_AGE)).intValue();
				String phoneNumber = (String)personJSON.get(USER_PHONE_NUMBER);
				
				//finally adds newly created user object to arraylist
				users.add(new User(id, userName, firstName, lastName, age, phoneNumber));
				System.out.println("NEW USER IS ADDED FROM READING THE FILE.");
				System.out.println("users userName: ");
				System.out.println(users.get(i).getUserName());
				
				// System.out.println(users.get(i).getFirstName());
				// System.out.println(users.get(i).getLastName());
				//System.out.println(users.get(i).toString());
			}
			
			//returns users object which has both its own object properties and and arraylist of users
			return users;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	//LOADS DIRECTORS
    public static ArrayList<Director> loadDirectors() {
        ArrayList<Director> directors = new ArrayList<Director>();

        try {
            FileReader reader = new FileReader(DIRECTOR_FILE);
            JSONArray directorsJSON = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < directorsJSON.size(); i++) {
                JSONObject directorJSON = (JSONObject) directorsJSON.get(i);
                UUID id = UUID.fromString((String) directorJSON.get(ID));
                String firstName = (String) directorJSON.get(FIRSTNAME);
                String lastName = (String) directorJSON.get(LASTNAME);
                String dateOfBirth = (String) directorJSON.get(DOB);
                Date dob = convertToDate(dateOfBirth);
                String homeAddress = (String) directorJSON.get(HOMEADDRESS);
                String userName = (String) directorJSON.get(USERNAME);
                String password = (String) directorJSON.get(PASSWORD);
                String email = (String) directorJSON.get(EMAIL);
                LoginInfo directorLogin = new LoginInfo(userName, password);

                JSONArray jsonCalendar = (JSONArray) directorJSON.get(CALENDAR);
                ArrayList<Camp> camps = new ArrayList<Camp>();
                Camp calendar = new Camp();
                for (int j = 0; j < jsonCalendar.size(); j++) {
                    JSONObject calendarJSON = (JSONObject) jsonCalendar.get(j);
                    String campName = (String) calendarJSON.get(NAME);
                    String campDescription = (String) calendarJSON.get(DESCRIPTION);
                    Integer year = ((Long) calendarJSON.get(YEAR)).intValue();
                    JSONArray jsonHash = (JSONArray) calendarJSON.get(CALENDAR_HASH);
                    HashMap<Integer, Week> masterScheduleHash = new HashMap<Integer, Week>();

                    for (int k = 0; k < jsonHash.size(); k++) {
                        JSONObject JSONWeek = (JSONObject) jsonHash.get(k);
                        Integer week_num = ((Long) JSONWeek.get(WEEK_NUM)).intValue();
                        JSONObject weekJSON = (JSONObject) JSONWeek.get(WEEK);
                        String theme = (String) weekJSON.get(THEME);
                        ArrayList<Group> groups = new ArrayList<Group>();
                        JSONArray groupsJSON = (JSONArray) weekJSON.get(GROUPS);
                        for (int l = 0; l < groupsJSON.size(); l++) {
                            JSONObject jsonGroup = (JSONObject) groupsJSON.get(l);
                            UUID groupNum = UUID.fromString((String) jsonGroup.get(GROUP_ID));
                            UUID counselorUUID = UUID.fromString((String) jsonGroup.get(COUNSELOR_ID));
                            Counselor counselor = CounselorList.getInstance().getCounselorByUUID(counselorUUID);
                            ArrayList<Camper> campersList = new ArrayList<Camper>();
                            JSONArray campers = (JSONArray) jsonGroup.get(GROUP_CAMPERS);
                            for (int m = 0; m < campers.size(); m++) {
                                JSONObject camperUUID = (JSONObject) campers.get(m);
                                UUID camperID = UUID.fromString((String) camperUUID.get(ID));
                                Camper camper = CamperList.getInstance().getCamperByUUID(camperID);
                                campersList.add(camper);
                            }
                            Counselor c = CounselorList.getInstance().getCounselorByUUID(counselorUUID);
                            JSONArray group_schedule = (JSONArray) jsonGroup.get(GROUP_SCHEDULE);
                            HashMap<DayOfWeek, ArrayList<Activity>> groupHashMap = new HashMap<DayOfWeek, ArrayList<Activity>>();
                            for (int m = 0; m < group_schedule.size(); m++) {
                                JSONObject scheduleJSON = (JSONObject) group_schedule.get(m);
                                String dayOfWeek = (String) scheduleJSON.get(DAY_OF_WEEK);
                                DayOfWeek day = DayOfWeek.valueOf(dayOfWeek.toUpperCase());
                                JSONArray activitiesJSON = (JSONArray) scheduleJSON.get(DAILY_ACTIVITIES);
                                ArrayList<Activity> dailyActivities = new ArrayList<Activity>();
                                for (int n = 0; n < activitiesJSON.size(); n++) {
                                    JSONObject thisActivity = (JSONObject) activitiesJSON.get(n);
                                    String activityName = (String) thisActivity.get(NAME);
                                    String activityLocaiton = (String) thisActivity.get(LOCATION);
                                    String activityDescription = (String) thisActivity.get(DESCRIPTION);
                                    dailyActivities
                                            .add(new Activity(activityName, activityLocaiton, activityDescription));
                                }
                                groupHashMap.put(day, dailyActivities);
                            }
                            Group g = new Group(groupNum, counselor, campersList, groupHashMap);
                            groups.add(g);

                        }
                        ArrayList<Counselor> week_counselors = new ArrayList<Counselor>();
                        JSONArray counselorsJSON = (JSONArray) weekJSON.get(WEEK_COUNSELORS);
                        for (int l = 0; l < counselorsJSON.size(); l++) {
                            JSONObject counselorJSONID = (JSONObject) counselorsJSON.get(l);
                            UUID counselorID = UUID.fromString((String) counselorJSONID.get(ID));
                            Counselor counselor = CounselorList.getInstance().getCounselorByUUID(counselorID);
                            week_counselors.add(counselor);
                        }
                        ArrayList<Camper> week_campers = new ArrayList<Camper>();
                        JSONArray campersJSON = (JSONArray) weekJSON.get(WEEK_CAMPERS);
                        for (int l = 0; l < campersJSON.size(); l++) {
                            JSONObject camperJSONID = (JSONObject) campersJSON.get(l);
                            UUID camperUUID = UUID.fromString((String) camperJSONID.get(ID));
                            Camper camper = CamperList.getInstance().getCamperByUUID(camperUUID);
                            week_campers.add(camper);
                        }
                        String startDateString = (String) weekJSON.get(START_DATE);
                        Date startDate = convertToDate(startDateString);
                        String endDateString = (String) weekJSON.get(END_DATE);
                        Date endDate = convertToDate(endDateString);
                        String isFullString = (String) weekJSON.get(ISFULL);
                        Boolean isFull = Boolean.valueOf(isFullString);
                        Week week = new Week(theme, groups, week_counselors, week_campers, startDate, endDate, isFull);

                        masterScheduleHash.put(week_num, week);
                    }
                    ArrayList<Activity> activities = new ArrayList<Activity>();
                    JSONArray activitiesJSON = (JSONArray) calendarJSON.get(ALL_ACTIVITIES);
                    for (int l = 0; l < activitiesJSON.size(); l++) {
                        JSONObject activity = (JSONObject) activitiesJSON.get(l);
                        String name = (String) activity.get(NAME);
                        String location = (String) activity.get(LOCATION);
                        String description = (String) activity.get(DESCRIPTION);
                        activities.add(new Activity(name, location, description));
                    }
                    calendar = new Camp(campName, campDescription, masterScheduleHash, activities, year);
                    camps.add(calendar);
                }
                directors.add(new Director(id, firstName, lastName, dob, homeAddress, email, directorLogin, camps));
            }
            return directors;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

	//LOADS CAMPS
	public static ArrayList<Camp> loadCamps() 
	{
		ArrayList<Camp> camps = new ArrayList<Camp>();

		try 
		{
			FileReader reader = new FileReader(CAMP_FILE);
			JSONArray campsJSON = (JSONArray) new JSONParser().parse(reader);

//LOOPS THROUGH CAMP ARRAYLIST
			for (int i = 0; i < campsJSON.size(); i++) 
			{
				//gets the campJSON object
				JSONObject campJSON = (JSONObject) campsJSON.get(i);

				int campYear = (int) ((Long) campJSON.get(CAMP_YEAR)).intValue();
				String campName = (String) campJSON.get(CAMP_NAME);
				String campAddress = (String) campJSON.get(CAMP_ADDRESS);

				int sessionsTotal = (int) ((Long) campJSON.get(CAMP_SESSIONS_TOTAL)).intValue();
				int cabinTotal = (int) ((Long) campJSON.get(CAMP_CABIN_TOTAL)).intValue();

				ArrayList<Session> campSessions = new ArrayList<Session>();
				JSONArray sessionsJSON = (JSONArray) campJSON.get(CAMP_SESSIONS);

//LOOPS THROUGH SESSION ARRAYLIST
				for (int j = 0; j < sessionsTotal; j++) 
				{
					//assigns single session object from json
					JSONObject sessionJSON = (JSONObject) sessionsJSON.get(j);

					int sessionNum = (int) ((Long) sessionJSON.get(SESSION_NUM)).intValue();
					String theme = (String) sessionJSON.get(SESSION_THEME);
					String description = (String) sessionJSON.get(SESSION_DESCRIPTION);
					String startDate = (String) sessionJSON.get(SESSION_STARTDATE);
					String endDate = (String) sessionJSON.get(SESSION_ENDDATE);

					int cabinAmt = (int) ((Long) sessionJSON.get(SESSION_CABINAMT)).intValue();

//LOOPS THROUGH CABINS OF THE PARTICULAR SESSION
					ArrayList<Cabin> cabins = new ArrayList<Cabin>();
					JSONArray cabinsJSON = (JSONArray) sessionJSON.get(SESSION_CABINS);

					for (int l = 0; l < cabinAmt; l++) 
					{
						JSONObject jsonCabin = (JSONObject) cabinsJSON.get(l);

						UUID cabinNum = UUID.fromString((String) jsonCabin.get(CABIN_ID));
	//COUNSELOR STUFF
						UUID counselorUUID;
						Counselor counselor = new Counselor();

						if (jsonCabin.get(COUNSELOR_ID) == null) 
						{
							counselorUUID = null;
							counselor = CounselorList.getInstance().getCounselorByUUID(counselorUUID);
						} 
						else 
						{
							counselorUUID = UUID.fromString((String) jsonGroup.get(COUNSELOR_ID));
							counselor = CounselorList.getInstance().getCounselorByUUID(counselorUUID);
						}
						counselor = CounselorList.getInstance().getCounselorByUUID(counselorUUID);

	//CAMPERS STUFF
						ArrayList<Camper> campersList = new ArrayList<Camper>();
						if (jsonCabin.get(CABIN_CAMPERS) == null) 
						{
							Camper camper = null;
							campersList.add(camper);
						} 
						else 
						{
							JSONArray campers = (JSONArray) jsonCabin.get(CABIN_CAMPERS);
							for (int m = 0; m < campers.size(); m++) {
								JSONObject camperUUID = (JSONObject) campers.get(m);
								UUID camperID = UUID.fromString((String) camperUUID.get(CAMPER_ID));
								Camper camper = CamperList.getInstance().getCamperByUUID(camperID);
								campersList.add(camper);
							}
						}

//SESSION SCHEDULE STUFF
						JSONArray cabin_schedule = (JSONArray) jsonCabin.get(CABIN_SCHEDULE);

						// HashMap<DayOfWeek, ArrayList<Activity>> groupHashMap = new HashMap<DayOfWeek, ArrayList<Activity>>();

						//get cabin schedule


//LOOPS THROUGH EACH CABIN SCHEDULE'S ACTIVITY
						for (int m = 0; m < cabin_schedule.size(); m++) 
						{
							JSONObject scheduleJSON = (JSONObject) group_schedule.get(m);
							String dayOfWeek = (String) scheduleJSON.get(DAY_OF_WEEK);
							DayOfWeek day = DayOfWeek.valueOf(dayOfWeek.toUpperCase());

							JSONArray activitiesJSON = (JSONArray) scheduleJSON.get(DAILY_ACTIVITIES);
							ArrayList<Activity> dailyActivities = new ArrayList<Activity>();
							for (int n = 0; n < activitiesJSON.size(); n++) 
							{
								JSONObject thisActivity = (JSONObject) activitiesJSON.get(n);
								String activityName = (String) thisActivity.get(NAME);
								String activityLocation = (String) thisActivity.get(LOCATION);
								String activityDescription = (String) thisActivity.get(DESCRIPTION);
								dailyActivities.add(new Activity(activityName, activityLocation, activityDescription));
							}
							groupHashMap.put(day, dailyActivities);
						}
						cabins.add(new Cabin(cabinNum, counselor, campersList, groupHashMap));
						//ADDS IT TO THE CABIN ARRAYLIST
					}

//LOOPS THROUGH SESSION COUNSELORS
					ArrayList<Counselor> session_counselors = new ArrayList<Counselor>();
					JSONArray counselorsJSON = (JSONArray) weekJSON.get(WEEK_COUNSELORS);
					for (int l = 0; l < counselorsJSON.size(); l++) {
						JSONObject counselorJSONID = (JSONObject) counselorsJSON.get(l);
						UUID counselorID = UUID.fromString((String) counselorJSONID.get(ID));
						Counselor counselor = CounselorList.getInstance().getCounselorByUUID(counselorID);
						week_counselors.add(counselor);
					}

//LOOPS THROUGH SESSION CAMPERS
					ArrayList<Camper> session_campers = new ArrayList<Camper>();
					JSONArray campersJSON = (JSONArray) sessionJSON.get(WEEK_CAMPERS);
					for (int l = 0; l < campersJSON.size(); l++) 
					{
						JSONObject camperJSONID = (JSONObject) campersJSON.get(l);
						UUID camperUUID = UUID.fromString((String) camperJSONID.get(ID));
						Camper camper = CamperList.getInstance().getCamperByUUID(camperUUID);
						session_campers.add(camper);
					}

					
//ASSIGNS SESSION ACTIVITIES
					ArrayList<Activity> sessionActivities = new ArrayList<Activity>();
					JSONArray activitiesJSON = (JSONArray) campJSON.get(ALL_SESSION_ACTIVITIES);
					for (int l = 0; l < activitiesJSON.size(); l++) 
					{
						JSONObject activity = (JSONObject) activitiesJSON.get(l);
						String name = (String) activity.get(ACTIVITY_NAME);
						String location = (String) activity.get(LOCATION);
						String description = (String) activity.get(DESCRIPTION);

						activities.add(new Activity(name, location, description));
					}
					//ASSIGNS SESSION
					Session session = new Session(theme, groups, week_counselors, week_campers, startDate, endDate, isFull);
				}





				//adds all these variables to the camp
				Camp camp = new Camp(campName, campDescription, masterScheduleHash, activities, year);
				camps.add(camp);
			}

			return camps;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}