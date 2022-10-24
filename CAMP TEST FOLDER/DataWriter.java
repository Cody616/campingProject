	
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
	
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
}