import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoader extends DataConstants{
	
	//returns array list of all users
	//actually is converting from json to arrylist of users

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

	public static ArrayList<Item> getItems() {
		ArrayList<Item> items = new ArrayList<Item>();
		System.out.println();
		System.out.println("IN DATALOADER CLASS");
		System.out.println("new arraylist of type ITEM is created.");

		try {
			//opens file from user_file_name
			FileReader reader = new FileReader(ITEM_FILE_NAME);
			//create json parser
			JSONParser parser = new JSONParser();

			//casts data from json file to array
			JSONArray itemsJSON = (JSONArray)new JSONParser().parse(reader);
			
			//loop through json array
			for(int i=0; i < itemsJSON.size(); i++) {
				//gets json object at the current location
				JSONObject itemJSON = (JSONObject)itemsJSON.get(i);

				//gets each field for the user object and converts to right data type by casting
				UUID id = UUID.fromString((String)itemJSON.get(ITEM_ID));

				String title = (String)itemJSON.get(ITEM_TITLE);
				String author = (String)itemJSON.get(ITEM_AUTHOR);
				
				//finally adds newly created user object to arraylist
				items.add(new Item(title, author));

				// System.out.println("NEW USER IS ADDED FROM READING THE FILE.");
				// System.out.println("users userName: ");

				// System.out.println(items.get(i).getUserName());
				
				// System.out.println(users.get(i).getFirstName());
				// System.out.println(users.get(i).getLastName());
				//System.out.println(users.get(i).toString());
			}
			
			//returns users object which has both its own object properties and and arraylist of users
			return items;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
}