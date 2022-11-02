import java.util.Scanner;

/*
 * should be camp.run
 * 
 * option to create camp
 * 
 * user enters data for a camp????
 * 
 * 
 * 
 * 
 */



 /*
  * login

	create new user


	1) camper?
	2) counselor?
	3) director?
		^^will have the role to manipulate everything.
		


	4) parent of a camper?


  *
  *
 /*
     * ^^should have view cabin schedule method, 
     * 
     * for login, it should ask for a password??? 
     * 
     * for creating account, should ask the user what role it would like to be????
     * Can choose to be a director, counselor, or camper????
     * 
     * 
     * this entire system should be a data base of total users along with their data
     * 
     * //would store each in a array as we would want the fixed length.
     * AND the 8 total cabins and 10 schedules <<each would be their own object.
     * 
     * 
     * ~schedules~
     * would be stored in array of type schedules of size 10.
     * the 10 schedules would represent the 10 weeks. 
     * 
     * would ask the user whenever wanting to view thier schedules to input 
     * which week they would like to view the schedule for.
     * 
     * director should have the ability to modify the schedules(aka call the schedules.randomize function)
     * 
     */


     /*
      * Director UI: 

      removeCamper();
      addCamper();
      removeCounselor();
      addCounselor();

      viewTotalCampers();
      viewTotalCounselors();

      viewTotalCabins();
      //^^would the whole system of user be dependent on their cabin type???
    //^^would basically be being able to use the cabin object

      //director makes the above logic not work
      */

public class CampUI {
    private static final String WELCOME_MESSAGE = "Welcome to our Camp Management App.";

    private String[] mainMenuOptions = {"Create Account", "Login", "Logout"};

    // private String[] mainMenuOptions = {"Create Account", "Login"};
	// private String[] campAdimOptions = {"Create Cabin","Find Cabin","Checkout Cabin","Logout"};

	private Scanner scanner;
	private CampFacade campFacade;
	
	CampUI(){
		scanner = new Scanner(System.in);
		// campFacade = new CampFacade();
	}
	
	public void run() {
		System.out.println(WELCOME_MESSAGE);
		
		//Loop as long as we want to keep interacting with the library
		while(true) 
        {
			displayMainMenu();
			
			int userCommand = getUserCommand(mainMenuOptions.length);
			
			if(userCommand == -1) {
				System.out.println("Not a valid command");
				continue;
			}
			
			//if they picked the last option then log them out
			if(userCommand == mainMenuOptions.length -1) {
				// campFacade.logout();
				break;
			}
		//^^could possibly put this in a method....
		

		//actually runs the commands
			switch(userCommand) {
				case(0):
                System.out.println("Create Account.");
					// createAccount();
					break;
				case(1):
				//calls the login function
				System.out.println("Login");
					// login();
					break;
			}
		}

		System.out.println("Good bye, and have a nice day");
	}
	
//methods that print messages to the user along with referneces the library objecti

///////METHODS FOR PRINTING MESSAGES/ INTERACTING WITH USER.////
	private void displayMainMenu() {
		System.out.println("\n************ Main Menu *************");
		for(int i=0; i< mainMenuOptions.length; i++) {
			System.out.println((i+1) + ". " + mainMenuOptions[i]);
		}
		System.out.println("\n");
	}
	
	//get the users command number, if it's not valid, return -1
	private int getUserCommand(int numCommands) {
		System.out.print("What would you like to do?: ");
		
		String input = scanner.nextLine();
		int command = Integer.parseInt(input) - 1;
		
		if(command >= 0 && command <= numCommands -1) return command;
		
		return -1;
	}
	
    //asks for prompt, then prints the prompt and then returns the inputted input from the user as a string
	private String getField(String prompt) {
		System.out.print(prompt + ": ");
		return scanner.nextLine();
	}

/////////LOGGING IN/ ACCOUNT STUFF//////////

	private void createAccount() {
		String userName = getField("Username");
		String firstName = getField("First Name");
		String lastName = getField("Last Name");
		int age = Integer.parseInt(getField("Age"));
		String phoneNumber = getField("Phone Number");
		
		//tells you whether or not it actually worked
		//if returns true, ...
		if(campFacade.createAccount(userName, firstName, lastName, age, phoneNumber)) {
			System.out.println("You have successfully created an account");
		} else {
			System.out.println("Sorry an account with that username already exists");
		}
	}

	private void login() {
		//asks for user name.
		String userName = getField("Username");

		// System.out.println("if library login method equals true");

		//if login was successful
		if(campFacade.login(userName)) {
			System.out.println("creates a new instance of user");
			User currentUser = campFacade.getCurrentUser();
			System.out.println("Welcome " + currentUser.getFirstName() + " " + currentUser.getLastName() + "!");
		} else {
			System.out.println("Sorry, invalid username ");
		}
	}




////////CABIN METHODS/////////////
	
	// private void createCabin() {
	// 	String title = getField("Title");
	// 	String author = getField("Author");

	// 	//tells you whether or not it actually worked
	// 	//if returns true, ...
	// 	if(campFacade.createCabin(title, author)) {
	// 		System.out.println("You have successfully created a Cabin.");
	// 	} else {
	// 		System.out.println("Sorry an item with that title already exists");
	// 	}
	// }


	// private String getUserCabin() {
	// 	System.out.print("Enter Cabin Name: ");
		
	// 	while(true) {

	// 		String cabinTitle = scanner.nextLine().trim().toLowerCase();
	// 		System.out.println("CABIN NAME ENTERD: " + cabinTitle);

			
	// 		if(!cabinTitle.contentEquals(""))
	// 		{
	// 			return cabinTitle;
	// 		} 
			
	// 		System.out.println("You need to actually enter content");
	// 		System.out.print("Would you like to enter item again (y) or return to main menu (n): ");

	// 		String command = scanner.nextLine().trim().toLowerCase();

	// 		if(command == "n")
	// 		{
	// 			return null;
	// 		} 
	// 	}
	// }

	// private void findCabin() {
	// 	System.out.println("\n-----Searching the Database of Cabins-----");

	// 	String cabin = getUserCabin();//calls method above
		
	// 	if(cabin == null)return;
		
	// 	if(!campFacade.findCabin(cabin)) {
	// 		System.out.println("Sorry we couldn't find your Cabin\n");
	// 		return;
	// 	}
		
	// 	System.out.println("YAY your item is in the Database of Cabins\n");		
	// }
	

	
    public static void main(String[] args) {
		CampUI libraryInterface = new CampUI();
		libraryInterface.run();
	}

}

