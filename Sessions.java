import java.util.ArrayList;

public class Sessions {
    
    private static Sessions sessions;
	private static ArrayList<Session> sessionList;

	//campersList is in usersList????
	
	/*
	 * calls for json to give the arraylist of all data and stores it
	 */
	private Sessions() {
		// assigns the arrayList of user objects from json to user by calling dataLoader class
		System.out.println();
		System.out.println("IN Sessions CLASS");
		System.out.println("USER LIST IS CREATED AND LOADED FROM JSON FILE");

		//what was originally here:
		
        ///NEED TO DO THIS METHOD!!!!!
		// sessionList = DataBase.getUsers();


		System.out.println("DATALOADER IS DONE, SESSIONLIST HAS BEEN ASSIGNED.");
		// System.out.println("arraylist of users size: " + userList.size());
		// System.out.println("1st userName: " + userList.get(0).getUserName());
		//nvm its loading it right >:(
	}
    
	
	public static Sessions getInstance() {
		System.out.println();
		System.out.println("SESSIONS GETINSTANCE METHOD");

		if(sessions == null) {
			System.out.println("IF SESSIONS == NULL");
			//creates a new instance of the users class and userList class.
			//userList is really just an arrayList of type user

			System.out.println("sessionList of new size is created.");
			sessionList = new ArrayList<Session>();
			// System.out.println("");
/////^^THIS WAS THE PROBLEM :) THIS WAS PUT AFTER USERS WAS CREATED, SO THE CURRENT USER WAS BEING ASSIGNED FROM A NULL ARRAYLIST :)////

			System.out.println("CALLS TO THE SESSIONS PRIVATE INSTANTIATERRRR??");
			sessions = new Sessions();
			//added this as it wasn't working whenever there were no users at all.

			System.out.println("SESSIONS AND SESSIONLIST VALUES CREATED.");
		}
		//System.out.println(users.getUser("pls"));
		
		//returns total users/ whole array list???
		return sessions;
	}


	//loops through user array list, takes in the correct username, and then returns true or false if found
	public boolean haveSession(String theme) {
		System.out.println();
		System.out.println("inside SESSION'S object's HAVESESSION method.");
		// System.out.println("Checks if there is a user or not");
		// System.out.println("INPUTTED USERNAME: " + userName);

		// System.out.println("checks if there are any users created within the system.");
		// System.out.println("BEFORE ANUYTHING HAPPENS.");

		// System.out.println("userList size: " + userList.size());
		// System.out.println("1st userName: " + userList.get(0).getUserName());

		if(sessionList == null)
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
		System.out.println("beginning of user in every sessionList forloop");

		for(Session session : sessionList) {
			System.out.println("INSIDE FORLOOP");
			System.out.println("if User in the arraylist is found:");

			if(session.getTheme().equals(theme)) {
				System.out.println("Session found");
				System.out.println(session.toString());
				return true;
			}
		}
		
		return false;
	}
	
	//finds user with username, returns user, null otherwise

    //should get by week??? theme?? theme we're doing theme :)
	public Session getSession(String theme) {
		//System.out.println();
		for(Session session : sessionList) {
			if(session.getTheme().equals(theme)) {
				return session;
			}
		}
		return null;
	}
	

	//returns arraylist of all users
	public ArrayList<Session> getSessions() {
		return sessionList;
	}

	
	public boolean addSession(String theme, ArrayList<Cabin> cabins) {

		// System.out.println("INSIDE ADDUSER METHOD");
		// System.out.println(haveUser(userName));

		//if username already exists
		if(haveSession(theme))
		{
			return false;
		}
		
		sessionList.add(new Session(theme, cabins));
		System.out.println("SESSION WAS ADDED TO ARRAYLIST.");
		return true;
	}

	// public void saveSessions() {
	// 	//calls for datawriter.save
	// 	DataWriter.saveSessions();
	// }
}
