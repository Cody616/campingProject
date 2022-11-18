import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

    //USERS
    // public static void saveUsers() {

    //     //creates a users object and gets it's current instance.
    //     //this is the class that has mulitple users already in it.

    //     //access the singleton/ access the instance, gets all users from it aka gets the arrayList of all users 
    //     Users users = Users.getInstance();

    //     //Data writer loads users into local arraylist of type User

    //     //needs to convert user arraylist to a json array type, this is what this is doing
    //     ArrayList<User> userList = users.getUsers();
    //     JSONArray jsonUsers = new JSONArray();
        
    //     //creating all the json objects
    //     for(int i=0; i< userList.size(); i++) {
    //         //converts to a json object, adds it to the json array
    //         jsonUsers.add(getUserJSON(userList.get(i)));
    //     }
        
    //     //Writes JSON file
    //     try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
    //         //opens json array, writes to file.
    //         file.write(jsonUsers.toJSONString());
    //         file.flush();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    // public static JSONObject getUserJSON(User user) {
    //     //gets the user's data and converts it to a JSONobject
    //     JSONObject userDetails = new JSONObject();
    //     //puts in each property of the json and its related value
    //     userDetails.put(USER_ID, user.getId().toString());
    //     //^^uuid gets stored as a string
    //     userDetails.put(USER_USER_NAME, user.getUserName());
    //     userDetails.put(USER_FIRST_NAME, user.getFirstName());
    //     userDetails.put(USER_LAST_NAME, user.getLastName());

    //     userDetails.put(USER_AGE, user.getAge());
    //     //age gets stored as a long????

    //     userDetails.put(USER_PHONE_NUMBER, user.getPhoneNumber());
        
    //     return userDetails;
    // }

    //CAMPERS
    /**
     * saveCampers- saves all campers to camper.json
     */
    // public static void saveCampers() {
    //     CamperList campers = CamperList.getInstance();
    //     ArrayList<Camper> camperList = campers.getCampers();
    //     JSONArray jsonCampers = new JSONArray();
    //     // creates JSON Objects for campers
    //     for (int i = 0; i < camperList.size(); i++) {
    //         jsonCampers.add(getCamperJSON(camperList.get(i)));
    //     }
    //     // writes JSON file
    //     try (FileWriter file = new FileWriter(CAMPER_FILE)) {
    //         file.write(jsonCampers.toJSONString());
    //         file.flush();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    /**
     * Helper method for saveCampers- 
     * 
     * gets individual camper's information and
     * writes it to JSON file
     * 
     * @param camper the camper that will be written to JSON file
     * @return return a JSONObject of the camper that can be inputted to JSON file
     */
    // public static JSONObject getCamperJSON(Camper camper) 
    // {
    //     JSONObject camperDetails = new JSONObject();
    //     camperDetails.put(CABIN_ID, camper.getUUID().toString());
    //     camperDetails.put(FIRSTNAME, camper.getFirstName());
    //     camperDetails.put(LASTNAME, camper.getLastName());
    //     camperDetails.put(HOMEADDRESS, camper.getHomeAddress());
    //     camperDetails.put(DOB, convertDateToString(camper.getDateOfBirth()));

    //     Sex sex = camper.getSex();
    //     String gender = sex.toString();
    //     camperDetails.put(GENDER, gender);

    //     JSONArray allergiesJSON = new JSONArray();
    //     for (int i = 0; i < camper.getAllergies().size(); i++) {
    //         String allergy = camper.getAllergies().get(i);
    //         allergiesJSON.add(allergy);
    //     }
    //     camperDetails.put(ALLERGIES, allergiesJSON);

    //     JSONArray medicationsJSON = new JSONArray();
    //     for (int i = 0; i < camper.getMedications().size(); i++) {
    //         JSONObject medJSON = new JSONObject();
    //         String dosage = camper.getMedications().get(i).getDose();
    //         medJSON.put(DOSAGE, dosage);
    //         String type = camper.getMedications().get(i).getType();
    //         medJSON.put(TYPE, type);
    //         String time = camper.getMedications().get(i).getTime();
    //         medJSON.put(TIME, time);
    //         medicationsJSON.add(medJSON);
    //     }
    //     camperDetails.put(MEDICATIONS, medicationsJSON);

    //     JSONArray contactsJSON = new JSONArray();
    //     for (int i = 0; i < camper.getEmergencyContacts().size(); i++) {
    //         JSONObject contactObj = new JSONObject();
    //         String firstName = camper.getEmergencyContacts().get(i).getFirstName();
    //         contactObj.put(FIRSTNAME, firstName);
    //         String lastName = camper.getEmergencyContacts().get(i).getLastName();
    //         contactObj.put(LASTNAME, lastName);
    //         String phoneNumber = camper.getEmergencyContacts().get(i).getPhoneNumber();
    //         contactObj.put(PHONE_NUM, phoneNumber);
    //         String email = camper.getEmergencyContacts().get(i).getEmailAddress();
    //         contactObj.put(EMAIL, email);
    //         String relationtoPerson = camper.getEmergencyContacts().get(i).getRelationToPerson();
    //         contactObj.put(CONT_RELATION_TO_PERSON, relationtoPerson);
    //         contactsJSON.add(contactObj);
    //     }
    //     camperDetails.put(CONTACTS, contactsJSON);

    //     JSONObject pediatricianJSON = new JSONObject();
    //     String firstName = camper.getPediatrician().getFirstName();
    //     String lastName = camper.getPediatrician().getLastName();
    //     String phoneNumber = camper.getPediatrician().getPhoneNumber();
    //     String email = camper.getPediatrician().getEmailAddress();
    //     String relationToPerson = camper.getPediatrician().getRelationToPerson();
    //     pediatricianJSON.put(FIRSTNAME, firstName);
    //     pediatricianJSON.put(LASTNAME, lastName);
    //     pediatricianJSON.put(PHONE_NUM, phoneNumber);
    //     pediatricianJSON.put(EMAIL, email);
    //     pediatricianJSON.put(CONT_RELATION_TO_PERSON, relationToPerson);
    //     camperDetails.put(PEDIATRICIAN, pediatricianJSON);

    //     return camperDetails;
    // }



    //CAMPS
    /*
     * writes camps to camp.json
     */
    public static void saveCamps() {

        CampList camps = CampList.getInstance();
        //gets the instance of type CampList

        ArrayList<Camp> campList = camps.getCamps();
        //array list of camp objects

        JSONArray jsonCamps = new JSONArray();
        //array of json camps

        for (int i = 0; i < campList.size(); i++) 
        {
            //adds the converted camp JSONObject
            jsonCamps.add(getCampJSON(campList.get(i)));
        }

        //writes it to the file
        try (FileWriter file = new FileWriter(CAMP_FILE)) 
        {
            file.write(jsonCamps.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * converts camp object to JSONObject
     * 
     * @param camp camp that will be converted
     * @return return JSONObject that will be added to camp.json
     */
    private static Object getCampJSON(Camp camp) 
    {
        JSONObject campDetails = new JSONObject();
        
        campDetails.put(CAMP_YEAR, camp.getCampYear());
        campDetails.put(CAMP_NAME, camp.getCampName());
        campDetails.put(CAMP_ADDRESS, camp.getCampAddress());

        campDetails.put(CAMP_SESSIONS_TOTAL, camp.getSessionsTotal());
        campDetails.put(CAMP_CABIN_TOTAL, camp.getCabinTotal());

        //creates an array for the master schedule aka array of campSessions

        //aka master schedule
        // JSONArray campSessionsJSON = new JSONArray();

//LOOPS THROUGH ALL THE SESSIONS IN A CAMP OBJECT
        for (Session session : camp.getCampSessions()) 
        {
            // JSONObject calHashObj = new JSONObject();
            // Integer num = entry.getKey();
            // calHashObj.put(WEEK_NUM, num);

            JSONObject sessionObj = new JSONObject();

//ASSIGNS MAIN SESSION PARAMETER VALUES
            sessionObj.put(SESSION_NUM, session.getSessionNum());
            sessionObj.put(SESSION_THEME, session.getTheme());
            sessionObj.put(SESSION_DESCRIPTION, session.getDescription());

            //ASSIGNS THE START DATE AND END DATE OF THE SESSION
            sessionObj.put(SESSION_STARTDATE, session.getStartDate());
            sessionObj.put(SESSION_ENDDATE, session.getEndDate());

            sessionObj.put(SESSION_CABINAMT, session.getCabinAmount());

            

//THEN CREATES A CABINS ARRAY
            JSONArray cabinsArray = new JSONArray();

//LOOPS THROUGH EVERY CABIN IN SESSION
            for (int i = 0; i < session.getCabinAmount(); i++) 
            {
                //creates a new cabin json object
                JSONObject cabinObj = new JSONObject();
                
//ASSIGNS CABIN ID
                //toString is at the end as it converts the id to a toString
                cabinObj.put(CABIN_ID, session.getCabins().get(i).getUUID().toString());

//ASSIGNS THE COUNSELOR ID FROM CABIN OBJECT
                if (session.getCabins().get(i).getCounselor() == null) 
                {
                    cabinObj.put(COUNSELOR_ID, null);
                } 
                else 
                {
                    cabinObj.put(COUNSELOR_ID, session.getCabins().get(i).getCounselor().getUUID().toString());
                }

//ASSINGS CAMPERS ID FROM CABIN OBJECT
                JSONArray campersArr = new JSONArray();
//if camper arraylist is null
                if (session.getCabins().get(i).getCampers() == null) 
                {
                    JSONObject camperObj = new JSONObject();
//ASSIGNS ALL CAMPER IDS TO JSON
                    camperObj.put(CAMPER_ID, null);
                    campersArr.add(camperObj);
                } 
                else 
                {
                //if cabin isnt null, loops through the cabin's camper array list
                    for (int j = 0; j < session.getCabins().get(i).getCampers().size(); j++) 
                    {
                        JSONObject camperObj = new JSONObject();
                        String id = session.getCabins().get(i).getCampers().get(j).getUUID().toString();

//ASSIGNS ALL CAMPER IDS TO JSON CAMPERS ARRAY
                        camperObj.put(CAMPER_ID, id);
                        campersArr.add(camperObj);
                    }
                }
//ADDS THE CABIN CAMPERS TO THE CABIN OBJECT
                cabinObj.put(CABIN_CAMPERS, campersArr);

//LOOPS THROUGH ARRAY OF CABINS TO GET THEIR SCHEDULES
                for(int k = 0; k < session.getCabins().size(); k++)
                {
                    //creates a week schedule array object
                    JSONArray cabinWeekSchedule = new JSONArray();
                    //adds the current cabin schedule object
                    cabinObj.put(CABIN_SCHEDULE, cabinWeekSchedule);
                    cabinsArray.add(cabinObj);
                }
            }
            //in the session object, assigns the cabin Array to the session object in json
            sessionObj.put(SESSION_CABINS, cabinsArray);

//ASSIGNS ALL COUNSELORS TO THE SESSION'S ARRAY 
            JSONArray sessionCounselorArr = new JSONArray();
            for (int i = 0; i < session.getCounselors().size(); i++) 
            {
                JSONObject counselorObj = new JSONObject();
                counselorObj.put(COUNSELOR_ID, session.getCounselors().get(i).getUUID().toString());
                sessionCounselorArr.add(counselorObj);
            }

//ASSIGNS TOTAL COUNSELORS TO THE SESSION COUNSELOR ARRAY
            sessionObj.put(SESSION_COUNSELORS, sessionCounselorArr);

//ASSIGNS ALL CAMPERS TO THE SESSION'S ARRAY 
            JSONArray sessionCampersArr = new JSONArray();
            for (int i = 0; i < session.getCampers().size(); i++) 
            {
                JSONObject camperObj = new JSONObject();
                camperObj.put(CAMPER_ID, session.getCampers().get(i).getUUID().toString());
                sessionCampersArr.add(camperObj);
            }
//ASSIGNS TOTAL CAMPERS TO THE SESSION CAMPERS ARRAY
            sessionObj.put(SESSION_CAMPERS, sessionCampersArr);

//ASSIGNS THE SESSION'S TOTAL ACTIVITIES
            JSONArray allActivitiesArray = new JSONArray();
            //loops through the session camp activities arrayList
            for (int i = 0; i < session.getSessionActivities().size(); i++) 
            {
                JSONObject activityObj = (JSONObject) new JSONObject();
                activityObj.put(SESSION_ACTIVITY_NAME, session.getSessionActivities().get(i).getName());
                activityObj.put(SESSION_ACTIVITY_LOCATION, session.getSessionActivities().get(i).getLocation());
                allActivitiesArray.add(activityObj);
            }
            
//ASSIGNS THE TOTAL ACTIVITIES TO THE CAMP OBJECT
            campDetails.put(ALL_SESSION_ACTIVITIES, allActivitiesArray);

        }//end of forloop of sessions
        return campDetails;
    }

}