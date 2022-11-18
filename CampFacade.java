import java.util.ArrayList;

public class CampFacade {
    //this will manage
  
    private Users users;
   
   
    private CampList campList;

    //different types of users:
    private CamperList camperList;
    private UserList userList;
    private CounselorList counselorList;
    private DirectorList directorList;
    
    
    //currentUser variable keeps track of who is currently logged in
    //current users
    private User currentUser;
    private Counselor currentCounselor;
    private Director currentDirector;

/**
     * Returns the current director that is logged in
     * 
     * @return
     */
    public Director getCurrentDirector() {
        return currentDirector;
    }

    public String viewDirectorProfile() {
        return currentDirector.toString();
    }

    // private Cabins cabins;
    //^^an arraylist of cabins.
    
    //the camp facade does this:
    //gets the singleton class, "sets them up"
    //assigns thier values to respective objects
    public CampFacade() {
        
        campList = CampList.getInstance();

        users = Users.getInstance();
        System.out.println("CAMP FACADE OBJECT IS CREATED.");
        System.out.println();

        //System.out.println(users.getInstance());
    }
    
    //creates a new user account
    public boolean createAccount(String userName, String firstName, String lastName, int age, String phoneNumber)
    {
        //adds user to user array list 
        return users.addUser(userName,  firstName,  lastName,  age,  phoneNumber);
    }

    public boolean createCabin(String title, String author)
    {
        //adds user to user array list 
        //cabins.add
       //  cabins.addItem(title, author);

       //should be this but idk why it's not doing this        

        return cabins.addCabin(title, author);
    }
    
    //if true, currentUser variable gets assigneed

    // public boolean login(String userName, String password) {
    //     //if doesn't have users equals true??? huh lmaoo

    //     //if user has the name but actually doesn't, then retrn false.
    //     // System.out.println();
    //     // System.out.println("In FACADE class, " + "\nchecks if inputted user is stored in database.");
    //     // System.out.println("LOGIN METHOD.");
    //     // System.out.println("i'm gonna print the user's arraylist now :)");
        
    //     // System.out.println();
    //     // System.out.println("MAKES CALL TO USERS CLASS");

    //     if(!users.haveUser(userName))
    //     {
    //         // System.out.println("LOGIN METHOD RETURNS FALSE");
    //         return false;
    //     }

    //     // System.out.println("assigns current instance of user object\n" 
    //     // + " to be recovered by using getUser(userName)");

    //     //assigns current user to be the loaded user from the arraylist of stored users which are actually json files
    //     currentUser = users.getUser(userName);
    //     // System.out.println("RETURNS TRUE");
    //     return true;
    // }

    public int login(String userName, String password) 
    {
        if (directorList.haveDirector(userName, password)) {
            currentDirector = directorList.getDirectorByUserName(userName);
            return 1;
        }
        if (userList.haveUser(userName, password)) {
            currentUser = userList.getUserByUserName(userName);
            // num = 2;
            return 2;
        }
        
        if (counselorList.haveCounselor(userName, password)) {
            currentCounselor = counselorList.getCounselorByUserName(userName);
            return 3;
        }
        return 0;
    }
    
    public User getCurrentUser() {
        return currentUser;
    }
    
    //saves everything done to json
    public void logout() {
        //when the whole application is closed, saves it to the json.

        //reads the json at the very beginning,
        //manipulates data thru arraylist format,
        //saves everything when all said and done
        //SAVES ONE TIME
        // cabins.saveCabins();

        users.saveUsers();
    }

//CABIN METHODS
public boolean findCabin(String cabinName) {
       //writing the items can be done in the data writer
       //loading the items can be done in data loader
       return cabins.haveCabin(cabinName);
   }

public boolean checkout(String cabinName) {
    if(!findCabin(cabinName))return false;
    
    //checkout the cabin
    //need a user then have them checkout an item
    return true;
}

////////////////this section will be the special director methods that will maniupulate the cabins class/////
 

//CAMP STUFF
/**
     * Adds a new Camp to campList
     * 
     * @param name
     * @param desc
     * @param weeks
     * @param year
     */
    public void newCamp(String name, String desc, int year, ArrayList<Activity> activites, 
                        HashMap<Integer, Week> masterSchedule) 
    {
        Camp camp = new Camp(name, desc, masterSchedule, activites, year);
        campList.addCamp(camp);
        campList.saveCamps();
    }

  /**
     * returns all the activities the camp offers
     * 
     * @param campName
     * @return
     */
    public String getActivities(String campName) {
        String campActivities = "";

        //loops through every camp in camp list
        for (Camp camp : campList.getCamps()) 
        {
            //if name entered equals 
            if (camp.getCampName().equals(campName))
            {
                //loops through all sessions
                for(int i = 0; i < camp.getSessionsTotal(); i++)
                {
                    //loops through every session's activities, appends to string.
                    for(int j = 0; j < camp.getCampSession(i).getSessionActivities().size(); j++)
                    {
                        campActivities += camp.getCampSession(i).getSessionActivities().toString() + "\n";
                    }
                     
                }
                return campActivities;  
            }
        }
        return "This camp does not exist";
    }

}