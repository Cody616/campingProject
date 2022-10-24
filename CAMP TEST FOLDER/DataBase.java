import java.util.ArrayList;

public class DataBase {

    public static ArrayList<User> getUsers(){
		ArrayList<User> userList = new ArrayList<User>();
		userList = DataLoader.getUsers();
		return userList;

		/*
		 * what was only here originally:
		 */
		//return new ArrayList<User>();
	}
	
	// public static ArrayList<Item> getItems(){

	// 	return new ArrayList<Item>();
	// }

    public static ArrayList<Cabin> getCabins(){
        return new ArrayList<Cabin>();
    }

	public static ArrayList<Schedule> getSchedules()
	{
		return new ArrayList<Schedule>();
	}
}
