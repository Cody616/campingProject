import java.util.Scanner;
import java.util.ArrayList;

public class CampUI {
    private static final String WELCOME_MESSAGE = "Welcome to our Camp Management App.";
	private String[] startMainMenu = {"Register", "Login"};
	private String[] mainMenuOptions = {"Create Account", "Login","Create Item","Find Item"
	,"Checkout Item","Rate an Item","Pay a Fine","Logout"};

	private String[] registerOptions = {"Register as a Camp Director", "Register as a Camp Counselor", "Register as a Parent", "Register as a Camper"};
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

	  //register child = 4 options of user
	  //login wil do uuid and do campter front end of screen
	  //end of day both are prompted to same front end screen


	  /*
	   * first screen
	   * if click register
	   * System.out.println("***** Registration *****");
	   * System.out.println("1. Register as a Camp Director");
	   * System.out.println("2. Register as a Camp Counselor");
	   * System.out.println("3. Register as a Camp Parent");
	   * System.out.println("4. Register as a Camper");
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * 
	   * scanrio 1: camp admin
	   * after login- identifies user
	   * System.out.println("**** Admin Options ****")
	   * System.out.println("1. View Cabins")
	   * if they select yes
	   * prints
	   * System.out.println("****View Cabins*****")
	   * System.out.println("method showing the themes of the cabin")
	   * System.out.println("Then show the cabins with the differeing age groups")
	   * then print out the cabin that are randomly generated and all cabins having one common time for lunch. 
	   * no activity shall have the same actviity twice in a day
	   * show session 2's schedule for cabin 2 and 5 (rockstars for 9/10 and 15/16 year olds.)
	   * 
	   * 
	   * 
	   * scenario 2: parent
	   * chooses to log in to existing account
	   * System.out.println("1. View Cabins");
	   * if viewed first cabin
	   * System.out.println("***CABINS***");
	   * System.out.println("Cabin 1: 7 and 8 year olds");
	   * System.out.println("Cabin 1: 9 and 10 year olds");
	   * System.out.println("Cabin 1: 11 and 12 year olds");
	   * System.out.println("Cabin 1: 13 and 14 year olds");
	   * System.out.println("Cabin 1: 15 and 16 year olds");
	   * System.out.println("Cabin 1: 17 and 18 year olds");
	   * 
	   * 
	   * 
	   * 
	   * 
	   * scanario 3: parent registering her child
	   * after registering process
	   * add
	   * System.out.println("Allergies: ");
	   * System.out.println("Other Allergy Notes: ");
	   * System.out.println("Emergency Contacts: ")
	   * System.out.println("Other Medical Information: ")
	   * System.out.println("Extra Information: ")
	   * Enroll her as same session for brother
	   * 
	   * scenario 4: restart program for existing user
	   * re run program and show that json files and info is saved
	   * System.out.println("1. View Cabins ");
	   * System.out.println("view roster of cabins ");
	   * System.out.println("method to print cabins and the variables")
	   * 
	   * 
	   * 
	   * 
	   * 
	   */

	private Scanner scanner;
	private CampFacade campFacade;
	
	CampUI(){
		scanner = new Scanner(System.in);
		campFacade = new CampFacade();
	}
	
	public void run() {
		System.out.println(WELCOME_MESSAGE);
		
		//Loop as long as we want to keep interacting with the library
		while(true) {
			displayMainMenu();
			
			int userCommand = getUserCommand(mainMenuOptions.length);

			// int userCommand = getUserCommand(registerOptions.length);
			
			if(userCommand == -1) {
				System.out.println("Not a valid command");
				continue;
			}
			
			//if they picked the last option then log them out

			if(userCommand == registerOptions.length-1)
			{
				campFacade.logout();
				break;
			}

		
		//actually runs the commands
			switch(userCommand)
			{
				// System.out.println("INSIDE SWITCH STATEMENT");
				case(0):

				int userCommand2 = getUserCommand(registerOptions.length);
			
				if(userCommand2 == -1) {
					System.out.println("Not a valid command");
					continue;
				}
				
				//if they picked the last option then log them out
				if(userCommand2 == startMainMenu.length-1)
				{
					campFacade.logout();
					break;
				}
				if(userCommand2 == mainMenuOptions.length -1) {
					campFacade.logout();
					break;
				}

				displayRegisterOptions();
				// getUserCommand2(userCommand);

				// getUserCommand(userCommand2);

					//getUserCommand;	

					switch(userCommand2)
					{
						case(0):
						System.out.println("You are registering as a Camp Director");
						getUserCommand(userCommand2);
					// getField(userCommand);
							// createAccount();
							break;
						case(1):
							System.out.println("You are registering as a Camp Counselor");
							// createAccount();
							break;
						case(2):
							System.out.println("You are registering as a Parent");
							// createAccount();
							break;
						case(3):
							System.out.println("You are registering as a Camper");
							// createAccount();
							break;
						}
				case(1):
					login();
					break;
			} 




			// {
				
					
					// createAccount();
				// break;

// 

				// case(1):
				// //calls the login function
				//  //System.out.println("LOGIN");
				// 	login();
				// 	break;

					
				// case(2):
				// // System.out.println("create item");
				// 	createItem();
				// 	break;
				// case(3):
				// // System.out.println("find item");
				// 	findItem();
				// 	break;
				// case(4):
				//  System.out.println("checkout item");
				// 	// checkoutItem();
				// 	break;
				// case(5):
				//  System.out.println("rate item");
				// 	// rateItem();
				// 	break;
				// case(6):
				//  System.out.println("pay fine");
				// 	// payFine();
				// 	break;
			// }

		}
		System.out.println("Good bye, and have a nice day");
	}
	
//methods that print messages to the user along with referneces the library objecti

	private void displayMainMenu() {
		System.out.println("\n************ Main Menu *************");
		for(int i=0; i< startMainMenu.length; i++) {
			System.out.println((i+1) + ". " + startMainMenu[i]);
		}
		System.out.println("\n");
	}

	private void displayRegisterOptions() {
		System.out.println("\n************ Register *************");
		for(int i=0; i< registerOptions.length; i++) {
			System.out.println("[" + (i+1) + "] " + registerOptions[i]);
		}
		System.out.println("\n");
	}

	// 	private void //displayRegisterOptions() {
	// 	System.out.println("\n************ Register *************");
	// 	for(int i=0; i< registerOptions.length; i++) {
	// 		System.out.println((i+1) + ". " + registerOptions[i]);
	// 	}
	// 	System.out.println("\n");
	// }

	// private void //whatever just copy above but need to make private string arrays for list() {
	// 	System.out.println("\n************ Register *************");
	// 	for(int i=0; i< registerOptions.length; i++) {
	// 		System.out.println((i+1) + ". " + registerOptions[i]);
	// 	}
	// 	System.out.println("\n");
	// }
	
	//get the users command number, if it's not valid, return -1


	private int getUserCommand(int numCommands) {
		System.out.print("What would you like to do?: ");

		String input = scanner.nextLine();

		System.out.println("INPUT: " + input);
		int command = Integer.parseInt(input) - 1;
		
		if(command >= 0 && command <= numCommands -1) return command;
		
		return -1;
	}

	// private int getUserCommand2(int numCommands) {
	// 	System.out.print("What would you like to do?: ");
		
	// 	String input2 = scanner.nextLine();
	// 	int command = Integer.parseInt(input2) - 1;
		
	// 	if(command >= 0 && command <= numCommands -1) return command;
		
	// 	return -1;
	// }
	
	private void createAccount() {
		String userName = getField("Username");
		String password = getField("Password");
		String firstName = getField("First Name");
		String lastName = getField("Last Name");
		int age = Integer.parseInt(getField("Age"));
		String phoneNumber = getField("Phone Number");
		
		//tells you whether or not it actually worked
		//if returns true, ...
		if(campFacade.createAccount(userName, password, firstName, lastName, age, phoneNumber)) {
			System.out.println("You have successfully created an account");
		} else {
			System.out.println("Sorry an account with that username already exists");
		}
	}

	//this would be like a createCabin method.
	private void createItem() {
		String title = getField("Title");
		String author = getField("Author");

		//tells you whether or not it actually worked
		//if returns true, ...
		if(campFacade.createItem(title, author)) {
			System.out.println("You have successfully created an item.");
		} else {
			System.out.println("Sorry an item with that title already exists");
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
	
	//asks for prompt, then prints the prompt and then returns the inputted input from the user as a string
	private String getField(String prompt) {
		System.out.print(prompt + ": ");
		return scanner.nextLine();
	}

//ITEM METHODS//////

//the main method that is used in all other methods below
//basically gets current instance 
	private String getUserItem() {
		System.out.print("Enter Item Name: ");
		
		while(true) {

			String itemTitle = scanner.nextLine().trim().toLowerCase();
			System.out.println("ITEM ENTERD: " + itemTitle);

			
			if(!itemTitle.contentEquals(""))
			{
				return itemTitle;
			} 
			
			System.out.println("You need to actually enter content");
			System.out.print("Would you like to enter item again (y) or return to main menu (n): ");

			String command = scanner.nextLine().trim().toLowerCase();

			if(command == "n")
			{
				return null;
			} 
		}
	}

	private void findItem() {
		System.out.println("\n-----Searching the Library-----");

		String item = getUserItem();//calls method above
		
		if(item == null)return;
		
		if(!campFacade.findItem(item)) {
			System.out.println("Sorry we couldn't find your item\n");
			return;
		}
		
		System.out.println("YAY your item is in the library\n");		
	}
	


	
    public static void main(String[] args) {
		CampUI libraryInterface = new CampUI();
		libraryInterface.run();
	}



	










///////need cabin methods!!//////////////////
//cabin.getSchedule???

























///////////////////ITEM METHODS////////////////////////
	// private void findItem() {
	// 	System.out.println("\n-----Searching the Library-----");
	// 	String item = getUserItem();
		
	// 	if(item == null)return;
		
	// 	if(!campFacade.findItem(item)) {
	// 		System.out.println("Sorry we couldn't find your item\n");
	// 		return;
	// 	}
		
	// 	System.out.println("YAY your item is in the library\n");		
	// }
	
	// private void checkoutItem() {
	// 	System.out.println("\n-----Checking out an item-----");
	// 	String item = getUserItem();
		
	// 	if(item == null)return;
		
	// 	if(!campFacade.checkout(item)) {
	// 		System.out.println("Sorry we couldn't checkout your item\n");
	// 		return;
	// 	}
	// 	System.out.println("Your item was successfully checked out\n");
	// }
	
	// private void rateItem() {
	// 	System.out.println("\n-----Searching the Library-----");
	// 	String item = getUserItem();
		
	// 	if(item == null)return;
		
	// 	//get rating
	// 	System.out.print("Enter rating: ");
	// 	int rating = Integer.parseInt(scanner.nextLine());
		
	// 	if(rating < 0 || rating > 5) {
	// 		System.out.println("Not a valid rating\n");
	// 		return;
	// 	}
		
	// 	if(!campFacade.rateItem(item, rating)) {
	// 		System.out.println("Sorry we couldn't rate your item\n");
	// 		return;
	// 	}
		
	// 	System.out.println("Item was successfully rated\n");
	// }
	
	// private void payFine() {
	// 	System.out.println("-----Paying a fine-----");
		
	// 	//get amount
	// 	System.out.print("Enter amount: ");
	// 	int amount = Integer.parseInt(scanner.nextLine());
		
	// 	if(amount < 0) {
	// 		System.out.println("Not a valid amount\n");
	// 		return;
	// 	}
		
	// 	if(!campFacade.payFine(amount)) {
	// 		System.out.println("Sorry, you were not able to pay this fine.\n");
	// 		return;
	// 	}
		
	// 	System.out.println("Fine paid\n");
	// }
	
	// private String getUserItem() {
	// 	System.out.print("Enter Item Name: ");
		
	// 	while(true) {
	// 		String itemName = scanner.nextLine().trim().toLowerCase();
		
	// 		if(!itemName.contentEquals("")) return itemName;
			
	// 		System.out.println("You need to actually enter content");
	// 		System.out.print("Would you like to enter item again (y) or return to main menu (n): ");
	// 		String command = scanner.nextLine().trim().toLowerCase();
	// 		if(command == "n") return null;
	// 	}
	// }
///////////////END OF ITEM METHODS///////////////////////
}

