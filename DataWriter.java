import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
	//USERS
	public static void saveUsers() {

		//creates a users object and gets it's current instance.
		//this is the class that has mulitple users already in it.

		//access the singleton/ access the instance, gets all users from it aka gets the arrayList of all users 
		Users users = Users.getInstance();

		//Data writer loads users into local arraylist of type User

		//needs to convert user arraylist to a json array type, this is what this is doing
		ArrayList<User> userList = users.getUsers();
		JSONArray jsonUsers = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< userList.size(); i++) {
			//converts to a json object, adds it to the json array
			jsonUsers.add(getUserJSON(userList.get(i)));
		}
		
		//Writes JSON file
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
			//opens json array, writes to file.
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getUserJSON(User user) {
		//gets the user's data and converts it to a JSONobject
		JSONObject userDetails = new JSONObject();
		//puts in each property of the json and its related value
		userDetails.put(USER_ID, user.getId().toString());
		//^^uuid gets stored as a string
		userDetails.put(USER_USER_NAME, user.getUserName());
		userDetails.put(USER_FIRST_NAME, user.getFirstName());
		userDetails.put(USER_LAST_NAME, user.getLastName());

		userDetails.put(USER_AGE, user.getAge());
		//age gets stored as a long????

		userDetails.put(USER_PHONE_NUMBER, user.getPhoneNumber());
        
        return userDetails;
	}

	//CABINS
	public static void saveCabins() {

		//creates a users object and gets it's current instance.
		//this is the class that has mulitple users already in it.

		//access the singleton/ access the instance, gets all users from it aka gets the arrayList of all users 
		Cabins cabins = Cabins.getInstance();

		//Data writer loads users into local arraylist of type User

		//needs to convert user arraylist to a json array type, this is what this is doing
		ArrayList<Cabin> cabinsList = cabins.getCabins();
		JSONArray jsonItems = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< cabinsList.size(); i++) {
			//converts to a json object, adds it to the json array
			jsonItems.add(getCabinJSON(cabinsList.get(i)));
		}
		
		//Writes JSON file
        try (FileWriter file = new FileWriter(CABIN_FILE_NAME)) {
			//opens json array, writes to file.
            file.write(jsonItems.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public static JSONObject getCabinJSON(Cabin cabin) {
		//gets the user's data and converts it to a JSONobject
		JSONObject cabinDetails = new JSONObject();

		//puts in each property of the json and its related value
		cabinDetails.put(CABIN_ID, cabin.getId().toString());
		//^^uuid gets stored as a string
		cabinDetails.put(CABIN_TITLE, cabin.getTitle());
		cabinDetails.put(CABIN_AUTHOR, cabin.getAuthor());
        
        return cabinDetails;
	}

	//CAMPERS
	/**
     * saveCampers- saves all campers to camper.json
     */
    public static void saveCampers() {
        CamperList campers = CamperList.getInstance();
        ArrayList<Camper> camperList = campers.getCampers();
        JSONArray jsonCampers = new JSONArray();
        // creates JSON Objects for campers
        for (int i = 0; i < camperList.size(); i++) {
            jsonCampers.add(getCamperJSON(camperList.get(i)));
        }
        // writes JSON file
        try (FileWriter file = new FileWriter(CAMPER_FILE)) {
            file.write(jsonCampers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	  /**
     * Helper method for saveCampers- gets individual camper's information and
     * writes it to JSON file
     * 
     * @param camper the camper that will be written to JSON file
     * @return return a JSONObject of the camper that can be inputted to JSON file
     */
    public static JSONObject getCamperJSON(Camper camper) {
        JSONObject camperDetails = new JSONObject();
        camperDetails.put(ID, camper.getUUID().toString());
        camperDetails.put(FIRSTNAME, camper.getFirstName());
        camperDetails.put(LASTNAME, camper.getLastName());
        camperDetails.put(HOMEADDRESS, camper.getHomeAddress());
        camperDetails.put(DOB, convertDateToString(camper.getDateOfBirth()));
        Sex sex = camper.getSex();
        String gender = sex.toString();
        camperDetails.put(GENDER, gender);
        JSONArray allergiesJSON = new JSONArray();
        for (int i = 0; i < camper.getAllergies().size(); i++) {
            String allergy = camper.getAllergies().get(i);
            allergiesJSON.add(allergy);
        }
        camperDetails.put(ALLERGIES, allergiesJSON);
        JSONArray medicationsJSON = new JSONArray();
        for (int i = 0; i < camper.getMedications().size(); i++) {
            JSONObject medJSON = new JSONObject();
            String dosage = camper.getMedications().get(i).getDose();
            medJSON.put(DOSAGE, dosage);
            String type = camper.getMedications().get(i).getType();
            medJSON.put(TYPE, type);
            String time = camper.getMedications().get(i).getTime();
            medJSON.put(TIME, time);
            medicationsJSON.add(medJSON);
        }
        camperDetails.put(MEDICATIONS, medicationsJSON);
        JSONArray contactsJSON = new JSONArray();
        for (int i = 0; i < camper.getEmergencyContacts().size(); i++) {
            JSONObject contactObj = new JSONObject();
            String firstName = camper.getEmergencyContacts().get(i).getFirstName();
            contactObj.put(FIRSTNAME, firstName);
            String lastName = camper.getEmergencyContacts().get(i).getLastName();
            contactObj.put(LASTNAME, lastName);
            String phoneNumber = camper.getEmergencyContacts().get(i).getPhoneNumber();
            contactObj.put(PHONE_NUM, phoneNumber);
            String email = camper.getEmergencyContacts().get(i).getEmailAddress();
            contactObj.put(EMAIL, email);
            String relationtoPerson = camper.getEmergencyContacts().get(i).getRelationToPerson();
            contactObj.put(CONT_RELATION_TO_PERSON, relationtoPerson);
            contactsJSON.add(contactObj);
        }
        camperDetails.put(CONTACTS, contactsJSON);
        JSONObject pediatricianJSON = new JSONObject();
        String firstName = camper.getPediatrician().getFirstName();
        String lastName = camper.getPediatrician().getLastName();
        String phoneNumber = camper.getPediatrician().getPhoneNumber();
        String email = camper.getPediatrician().getEmailAddress();
        String relationToPerson = camper.getPediatrician().getRelationToPerson();
        pediatricianJSON.put(FIRSTNAME, firstName);
        pediatricianJSON.put(LASTNAME, lastName);
        pediatricianJSON.put(PHONE_NUM, phoneNumber);
        pediatricianJSON.put(EMAIL, email);
        pediatricianJSON.put(CONT_RELATION_TO_PERSON, relationToPerson);
        camperDetails.put(PEDIATRICIAN, pediatricianJSON);

        return camperDetails;
    }


}