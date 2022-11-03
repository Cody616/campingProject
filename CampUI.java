import java.util.Scanner;

public class CampUI {
    private static final String WELCOME_MESSAGE = "Welcome to our Camp Management App.";
	private String[] mainMenuOptions = {"Register", "Login","View Camp Sites","Logout"};

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

	private Scanner scanner;
	private CampFacade campFacade;
	
	CampUI(){
		scanner = new Scanner(System.in);
		campFacade = new CampFacade();
	}
	
	public void run() {
		System.out.println(WELCOME_MESSAGE);
		boolean run = true;
		//Loop as long as we want to keep interacting with the library
		while(run) {
			displayMainMenu();
			
			int userCommand = getUserCommand(mainMenuOptions.length);
			
			if(userCommand == -1) {
				System.out.println("Not a valid command");
				continue;
			}
			
			//if they picked the last option then log them out
			if(userCommand == mainMenuOptions.length -1) {
				campFacade.logout();
				break;
			}
		
		//actually runs the commands
			switch(userCommand) {
				case(0)://click register
                displayRegOptions();
                findUserType();//finds type user and creates acc
                    switch(userCommand)
                    {
                        case(0)://parent
                        break;
                        case(1)://camp counselor
                        break;
                        case(2)://camp admin
                        displayAdminOptions();
                        break;
                    }
					//displayRegOptions();//asks what kind of user
					// findUserType();//finds type user and creates acc
					//displayAdminOptions();
					//testVar = false;
					//createdesired
					//createAccount();
					//System.out.println("hip");
					break;
				case(1)://login
				//calls the login function
				// System.out.println("LOGIN");
					login();
					break;
				case(2)://view camp sites
				// System.out.println("create item");
					//createItem();
					break;
				case(3)://logout
				// System.out.println("find item");
					System.out.println("Goodbye");
                    System.exit(0);
					break;
				
			}
		}
		System.out.println("Good bye, and have a nice day");
	}
	
//methods that print messages to the user along with referneces the library objecti

	private void getAdminOption()
	{
		int userCommand = getUserCommand(regOptions.length);
			switch(userCommand)
				  {
					case(0):
					System.out.println("Viewing Camp Site");
					createAccount();
					break;
					case(1):
					System.out.println("Editing Camp Site");
					createAccount();
					break;
					case(2):
					System.out.println("Create New Camp");
					createAccount();
					//System.out.println("hi");
					break;
					case(3):
					System.out.println("Exiting.");
					break;
				  }
	}


	private void findUserType()
	{
		boolean run = true;
		//while(run) 
		//{
			int userCommand = getUserCommand(regOptions.length);
			switch(userCommand)
				  {
					case(0):
					System.out.println("Registering as a Parent");
					createAccount();
					break;
					case(1):
					System.out.println("Registering as a Camp Counselor");
					createAccount();
					break;
					case(2):
					System.out.println("Registering as a Camp Admin");
					createAccount();
					System.out.println("hi");
					break;
				  }
		}
		
        /* boutta add a bunch of methods that are gonna be utilized later for displaying 
         * 
         * 
         */
        //starting w parent ui
        private String [] parentOp = {"Childs", "Cabins", "Cabin Info", "Exit"};
        private void displayParentOptions() {
            System.out.println("\n************ Parent *************");
            for(int i=0; i< parentOp.length; i++) {
                System.out.println((i+1) + ". " + parentOp[i]);
            }
            System.out.println("\n");
        }
        private String [] childInfoMenu = {"View Children", "Add Child", "Remove Child", "Exit"};
        private void displayChildInfoOptions() {
            System.out.println("\n************ Child Info *************");
            for(int i=0; i< childInfoMenu.length; i++) {
                System.out.println((i+1) + ". " + [i]);
            }childInfoMenu
            System.out.println("\n");
        }
        private String [] cabinOp = {"View Cabins", "Add Child to Cabin", "Exit"};
        private void displayParentCabinOptions() {
            System.out.println("\n************ Parent *************");
            for(int i=0; i< cabinOp.length; i++) {
                System.out.println((i+1) + ". " + cabinOp[i]);
            }
            System.out.println("\n");
        }
        private String [] testdontknow = {"Childs", "Cabins", "Cabin Info", "Exit"};
        private void displayTestDontKnow() {
            System.out.println("\n************ Parent *************");
            for(int i=0; i< testdontknow.length; i++) {
                System.out.println((i+1) + ". " + testdontknow[i]);
            }
            System.out.println("\n");
        }
        //--------------parent ui side


	private void displayMainMenu() {
		System.out.println("\n************ Main Menu *************");
		for(int i=0; i< mainMenuOptions.length; i++) {
			System.out.println((i+1) + ". " + mainMenuOptions[i]);
		}
		System.out.println("\n");
	}
	
	private String[] adminOptions = {"View Camp Site", "Edit Camp Site", "Create New Camp", "Exit"};
	private void displayAdminOptions()
	{
		//System.out.println("\n************ Register *************");
		System.out.println("What would you like to do?\n");
		for(int i=0; i< adminOptions.length; i++) {
			System.out.println((i+1) + ". " + adminOptions[i]);
		}
		System.out.println("\n");
	}


	private String[] regOptions = {"Parent", "Camp Counselor", "Camp Admin"};
	private void displayRegOptions() {
		System.out.println("\n************ Register *************");
		System.out.println("What would you like to register as?\n");
		for(int i=0; i< regOptions.length; i++) {
			System.out.println((i+1) + ". " + regOptions[i]);
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