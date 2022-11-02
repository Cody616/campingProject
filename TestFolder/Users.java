import java.util.ArrayList;

public class Users {

	private static Users users;
	private static ArrayList<User> userList;

	//campersList is in usersList????
	
	
	/*
	 * calls for json to give the arraylist of all data and stores it
	 */
	private Users() {
		// assigns the arrayList of user objects from json to user by calling dataLoader class
		System.out.println();
		System.out.println("IN USERS CLASS");
		System.out.println("USER LIST IS CREATED AND LOADED FROM JSON FILE");

		//what was originally here:
		// userList = DataLoader.getUsers();
		userList = DataBase.getUsers();


		//^^this is the problem??. yes it isss :)))
		System.out.println("DATALOADER IS DONE, USERLIST HAS BEEN ASSIGNED.");
		// System.out.println("arraylist of users size: " + userList.size());
		// System.out.println("1st userName: " + userList.get(0).getUserName());
		//nvm its loading it right >:(
	}
	
	public static Users getInstance() {
		System.out.println();
		System.out.println("USERS GETINSTANCE METHOD");

		if(users == null) {
			System.out.println("IF USERS == NULL");
			//creates a new instance of the users class and userList class.
			//userList is really just an arrayList of type user

			System.out.println("userList of new size is created.");
			userList = new ArrayList<User>();
			// System.out.println("");
/////^^THIS WAS THE PROBLEM :) THIS WAS PUT AFTER USERS WAS CREATED, SO THE CURRENT USER WAS BEING ASSIGNED FROM A NULL ARRAYLIST :)////

			System.out.println("CALLS TO THE USERS PRIVATE INSTANTIATERRRR??");
			users = new Users();
			//added this as it wasn't working whenever there were no users at all.

			System.out.println("USERS AND USERLIST VALUES CREATED.");
		}
		//System.out.println(users.getUser("pls"));
		
		//returns total users/ whole array list???
		return users;
	}

	//loops through user array list, takes in the correct username, and then returns true or false if found
	public boolean haveUser(String userName) {
        
		System.out.println();
		System.out.println("inside USERS object's HAVEUSER method.");
		// System.out.println("Checks if there is a user or not");
		// System.out.println("INPUTTED USERNAME: " + userName);

		// System.out.println("checks if there are any users created within the system.");
		// System.out.println("BEFORE ANUYTHING HAPPENS.");

		// System.out.println("userList size: " + userList.size());
		// System.out.println("1st userName: " + userList.get(0).getUserName());

		if(userList == null)
		{
			System.out.println("RETURNS FALSE");
			return false;
		}
		
		// System.out.println();
		// System.out.println("userList isnt NULL!!");



		// System.out.println("USERNAME: ");
		// System.out.println("firstUser userName: \n"+ userList.get(0).getUserName());
		// for(int i = 0; i < userList.size(); i++)
		// {
		// 	System.out.println(userList.get(i).getUserName());
		// }
		
		System.out.println();
		System.out.println("beginning of user in every userList forloop");

		for(User user : userList) {
			System.out.println("INSIDE FORLOOP");
			System.out.println("if User in the arraylist is found:");
			if(user.getUserName().equals(userName)) {
				System.out.println("User found");
				System.out.println(user.toString());
				return true;
			}
		}
		
		return false;
	}
	
	//finds user with username, returns user, null otherwise
	public User getUser(String userName) {
		//System.out.println();
		for(User user : userList) {
			if(user.getUserName().equals(userName)) {
				return user;
			}
		}
		
		return null;
	}
	
	//returns arraylist of all users
	public ArrayList<User> getUsers() {
		return userList;
	}
	
	public boolean addUser(String userName, String firstName, String lastName, int age, String phoneNumber) {

		// System.out.println("INSIDE ADDUSER METHOD");
		// System.out.println(haveUser(userName));

		//if username already exists
		if(haveUser(userName))
		{
			return false;
		}

		// if(userList.size() == 0)
		// {

		// }
		
		userList.add(new User(userName, firstName, lastName, age, phoneNumber));
		System.out.println("USER WAS ADDED.");
		return true;
	}
	
	public void saveUsers() {
		//calls for datawriter.save
		DataWriter.saveUsers();
	}
}
