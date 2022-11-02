public class CampFacade {
    //this will manage
  
    private Users users;
    //an arraylist of users
   
    private User currentUser;

    private Cabins cabins;
    //^^an arraylist of cabins.

    //currentUser variable keeps track of who is currently logged in
    
    //the camp facade does this:
    //gets the singleton class, "sets them up"
    //assigns thier values to respective objects
    public CampFacade() {
        
        cabins = Cabins.getInstance();
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

    /*
     * !!!!!!
     */
    public boolean createCabin(String title, String author)
    {
        //adds user to user array list 
        //cabins.add
       //  cabins.addItem(title, author);

       //should be this but idk why it's not doing this        

        return cabins.addCabin(title, author);
    }
    
    //if true, currentUser variable gets assigneed

    public boolean login(String userName) {
        //if doesn't have users equals true??? huh lmaoo

        //if user has the name but actually doesn't, then retrn false.
        System.out.println();
        System.out.println("In FACADE class, " + "\nchecks if inputted user is stored in database.");
        System.out.println("LOGIN METHOD.");
        System.out.println("i'm gonna print the user's arraylist now :)");
        

        System.out.println();
        System.out.println("MAKES CALL TO USERS CLASS");

        if(!users.haveUser(userName))
        {
            System.out.println("LOGIN METHOD RETURNS FALSE");
            return false;
        }

        // System.out.println("assigns current instance of user object\n" 
        // + " to be recovered by using getUser(userName)");

        //assigns current user to be the loaded user from the arraylist of stored users which are actually json files
        currentUser = users.getUser(userName);
        System.out.println("RETURNS TRUE");
        return true;
    }
    
    public User getCurrentUser() {
        return currentUser;
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
    

//saves everything done to json
    public void logout() {
        //when the whole application is closed, saves it to the json.

        //reads the json at the very beginning,
        //manipulates data thru arraylist format,
        //saves everything when all said and done
        //SAVES ONE TIME
        cabins.saveCabins();
        users.saveUsers();
    }

}