public class CampFacade {
     //private Items items;
     private Users users;
    
     private User currentUser;

     private Items items;
     //^^should be cabins

     //currentUser variable keeps track of who is currently logged in
     
     public CampFacade() {
         //gets the singleton class, "sets them up"
         //assigns thier values to respective objects
 
         items = Items.getInstance();
         users = Users.getInstance();
         System.out.println("CAMP FACADE OBJECT IS CREATED.");
         System.out.println();
         //System.out.println(users.getInstance());
     }
     
     //creates a new user account
     public boolean createAccount(String userName, String password, String firstName, String lastName, int age, String phoneNumber)
     {
         //adds user to user array list 
         return users.addUser(userName, password, firstName,  lastName,  age,  phoneNumber);
     }

     /*
      * !!!!!!
      */
     public boolean createItem(String title, String author)
     {
         //adds user to user array list 
         return items.addItem(title, author);
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
     
   //item methods aka cabin
   /*
    * !!!!!!
    */
   public boolean findItem(String itemName) {
        //writing the items can be done in the data writer
        //loading the items can be done in data loader
        return items.haveItem(itemName);
    }
 
 

 
 ////////////////this section will be the special director methods that will maniupulate the cabins class/////
     //passes item singleton
    //  public boolean findItem(String itemName) {
    //      //writing the items can be done in the data writer
    //      //loading the items can be done in data loader
    //      return items.haveItem(itemName);
    //  }
     
    //  public boolean checkout(String itemName) {
    //      if(!findItem(itemName))return false;
         
    //      //checkout the item
    //      //need a user then have them checkout an item
    //      return true;
    //  }
     
    //  public boolean rateItem(String itemName, int rating) {
    //      if(!findItem(itemName))return false;
         
    //      if(rating < 0 || rating > 5) return false;
         
    //      return true;
    //  }
     
    //  public boolean payFine(int amount) {
    //      if(amount < 0) return false;
         
    //      return true; 	//successfully paid fine
    //  }
 //////////////////////////////////////////////
 
     
     public void logout() {
         //when the whole application is closed, saves it to the json.
 
         //reads the json at the very beginning,
         //manipulates data thru arraylist format,
         //saves everything when all said and done
         //SAVES ONE TIME
         items.saveItems();
         users.saveUsers();
     }
 }
 

