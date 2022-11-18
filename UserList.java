import java.util.ArrayList;
import java.util.UUID;

public class UserList {

    private ArrayList<User> users;
    private static UserList userList;

	//campersList is in usersList????
	
	/*
	 * calls for json to give the arraylist of all data and stores it
	 */
    private UserList() {
        users = DataLoader.loadUsers();
    }
	
	public static UserList getInstance() {
        if (userList == null) {
            userList = new UserList();
        }
        return userList;
    }

    public boolean addUser(User user) {
        if (user == null) {
            return false;
        } else {
            users.add(user);
            saveUsers();
        }
        return false;
    }

	//loops through user array list, takes in the correct username, 
    //and then returns true or false if found
	public boolean haveUser(String userName, String passWord) 
    {
        for (User user : users) 
        {
            if (user.getUsername().equals(userName)
            && user.getPassword().equals(passWord)) 
            {
                return true;
            }
        }
        return false;
    }

    public User getUserByUUID(UUID uuid) {
        for (User u : users) {
            if (u.getUUID().equals(uuid))
                return u;
        }
        return null;
    }

    //finds user with username, returns user, null otherwise
    public User getUserByUserName(String userName) 
    {
        for (User user : users) 
        {
            if (user.getUsername().equals(userName))
                return user;
        }
        return null;
    }

    //returns arraylist of all users
    public ArrayList<User> getUsers() {
        return users;
    }

    public void saveUsers() {
        DataWriter.saveUsers();
    }
}
