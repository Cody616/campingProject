import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants{
	
	//returns array list of all users
	//actually is converting from json to arrylist of users

	/*
	 * ALL OF THESE NEED TO BE REDEFINED.
	 */

	public static ArrayList<User> getUsers() {
		ArrayList<User> users = new ArrayList<User>();
		System.out.println();
		System.out.println("IN DATALOADER CLASS");
		System.out.println("new arraylist of type user is created.");

		try {
			//opens file from user_file_name
			FileReader reader = new FileReader(USER_FILE_NAME);
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

	// public static ArrayList<Cabin> getCabins() {
		
	// 	ArrayList<Cabin> cabins = new ArrayList<Cabin>();
	// 	System.out.println();
	// 	System.out.println("IN DATALOADER CLASS");
	// 	System.out.println("new arraylist of type ITEM is created.");

	// 	try {
	// 		//opens file from user_file_name
	// 		FileReader reader = new FileReader(CABIN_FILE_NAME);
	// 		//create json parser
	// 		JSONParser parser = new JSONParser();

	// 		//casts data from json file to array
	// 		JSONArray cabinsJSON = (JSONArray)new JSONParser().parse(reader);
			
	// 		//loop through json array
	// 		for(int i=0; i < cabinsJSON.size(); i++) {
	// 			//gets json object at the current location
	// 			JSONObject cabinJSON = (JSONObject)cabinsJSON.get(i);

	// 			//gets each field for the user object and converts to right data type by casting
	// 			UUID id = UUID.fromString((String)cabinJSON.get(CABIN_ID));

	// 			String title = (String)cabinJSON.get(CABIN_TITLE);
	// 			String author = (String)cabinJSON.get(CABIN_AUTHOR);
				
	// 			//finally adds newly created user object to arraylist
	// 			cabins.add(new Cabin(title, author));

	// 			// System.out.println("NEW USER IS ADDED FROM READING THE FILE.");
	// 			// System.out.println("users userName: ");

	// 			// System.out.println(items.get(i).getUserName());
				
	// 			// System.out.println(users.get(i).getFirstName());
	// 			// System.out.println(users.get(i).getLastName());
	// 			//System.out.println(users.get(i).toString());
	// 		}
			
	// 		//returns users object which has both its own object properties and and arraylist of users
	// 		return cabins;
			
	// 	} catch (Exception e) {
	// 		e.printStackTrace();
	// 	}
		
	// 	return null;
	// }

	// //DIFFERNET TYPES OF USERS:

	// //CAMPERS:
	// /**
    //  * reads campers from camper.json
    //  * 
    //  * @return returns an array list of campers from JSON file
    //  */
    // public static ArrayList<Camper> loadCampers() {
    //     ArrayList<Camper> campers = new ArrayList<Camper>();

    //     try {
    //         FileReader reader = new FileReader(CAMPER_FILE);
    //         JSONArray campersJSON = (JSONArray) new JSONParser().parse(reader);

    //         for (int i = 0; i < campersJSON.size(); i++) {

    //             JSONObject camperJSON = (JSONObject) campersJSON.get(i);

    //             UUID id = UUID.fromString((String) camperJSON.get(ID));
    //             String firstName = (String) camperJSON.get(FIRSTNAME);
    //             String lastName = (String) camperJSON.get(LASTNAME);
    //             String dateOfBirth = (String) camperJSON.get(DOB);
    //             Date dob = convertToDate(dateOfBirth);
    //             String homeAddress = (String) camperJSON.get(HOMEADDRESS);

    //             String genderString = (String) camperJSON.get(GENDER);

    //             Gender gender = gender.valueOf(genderString.toUpperCase());

    //             JSONArray allergiesJson = (JSONArray) camperJSON.get(ALLERGIES);
    //             ArrayList<String> allergies = new ArrayList<String>();
    //             for (int j = 0; j < allergiesJson.size(); j++) {
    //                 String allergy = (String) allergiesJson.get(j);
    //                 allergies.add(allergy);
    //             }

    //             JSONArray medicationsJSON = (JSONArray) camperJSON.get(MEDICATIONS);
    //             ArrayList<Medication> medications = new ArrayList<Medication>();
    //             for (int j = 0; j < medicationsJSON.size(); j++) {
    //                 JSONObject medJSON = (JSONObject) medicationsJSON.get(j);
    //                 String dosage = (String) medJSON.get(DOSAGE);
    //                 String type = (String) medJSON.get(TYPE);
    //                 String time = (String) medJSON.get(TIME);
    //                 medications.add(new Medication(type, dosage, time));
    //             }

    //             JSONArray contactsJSON = (JSONArray) camperJSON.get(CONTACTS);
    //             ArrayList<EmergencyContact> contacts = new ArrayList<Contact>();
    //             for (int j = 0; j < contactsJSON.size(); j++) {
    //                 JSONObject contactJSON = (JSONObject) contactsJSON.get(j);
    //                 String contactFirstName = (String) contactJSON.get(FIRSTNAME);
    //                 String contactLastName = (String) contactJSON.get(LASTNAME);
    //                 String phoneNumber = (String) contactJSON.get(PHONE_NUM);
    //                 String emailAddress = (String) contactJSON.get(EMAIL);
    //                 String relationToPerson = (String) contactJSON.get(CONT_RELATION_TO_PERSON);
    //                 contacts.add(new EmergencyContact(contactFirstName, contactLastName, phoneNumber, emailAddress,
    //                         relationToPerson));
    //             }

    //             JSONObject pediatricianJSON = (JSONObject) camperJSON.get(PEDIATRICIAN);
    //             String pedFirstName = (String) pediatricianJSON.get(FIRSTNAME);
    //             String pedLastName = (String) pediatricianJSON.get(LASTNAME);
    //             String phoneNumber = (String) pediatricianJSON.get(PHONE_NUM);
    //             String email = (String) pediatricianJSON.get(EMAIL);
    //             String relationToPerson = (String) pediatricianJSON.get(CONT_RELATION_TO_PERSON);

    //             EmergencyContact pediatrician = new EmergencyContact(pedFirstName, pedLastName, phoneNumber,
    //                     email, relationToPerson);
    //             campers.add(new Camper(id, firstName, lastName, homeAddress, dob, sex, medications, allergies,
    //                     contacts, pediatrician));
    //         }
    //         return campers;
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     return null;
    // }


}