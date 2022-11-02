import java.util.Scanner;

public class CampUI {
    private static final String WELCOME_MESSAGE = "Welcome to our Camp Management App.";
	//private String[] mainMenuOptions = {"Create Account", "Login","Create Cabin","Find Cabin"
	//,"Checkout Cabin","Logout"};
	private String [] mainMenuOptions = {"Register", "Login", "View Camps", "Exit"};

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


    
	private Scanner scanner;
	private CampFacade campFacade;

	Scanner input = new Scanner(System.in);
	
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
				case(1):
					createAccount();
					break;
				case(2):
				//calls the login function
				// System.out.println("LOGIN");
					login();
					break;
				case(3):
				// System.out.println("create item");
					createCabin();
					break;
				case(4):
				//exit();

			}
		}
		System.out.println("Good bye, and have a nice day");
	}
	
//methods that print messages to the user along with referneces the library objecti

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
	
private String[] accOptions = {"Guardian", "Coordinator", "Camp Admin", "Exit"};

	private void createAccount() {
		User user = null;
		System.out.println("Registering as a: ");
		System.out.println("1. Guardian");
		System.out.println("2. Coordinator");
		System.out.println("3. Camp Admin");
		System.out.println("4. Exit");

		

		int response = getUserCommand(accOptions.length);




		switch(response) {
			case(1):
				createAccountGuardian();
				break;
			case(2):
			//calls the login function
			// System.out.println("LOGIN");
				login();
				break;
			case(3):
			// System.out.println("create item");
				createCabin();
				break;
			case(4):
			//exit();
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

    public String promptForStringResponse(){
        System.out.print("> ");
        String response = input.nextLine();
        response = response.trim();
        return response;
    }

	public String createPassword(){
        String password = "";
        boolean isPasswordMatch = false;
        while(!isPasswordMatch){
            System.out.println("Create your password: ");
            String pass1 = promptForStringResponse();
            System.out.println("Enter your password again: ");
            password = promptForStringResponse();
            isPasswordMatch = (pass1.equals(password));
            if(!isPasswordMatch){
                System.out.println("Passwords didn't match. Try again.");
            }
        }
        return password;
    }
    


	public String promptForPhone(){
        // to do: perform checks here
        System.out.println("Enter the phone number [XXX-XXX-XXXX]: ");
        return promptForStringResponse();
    }
	public String promptForBirthDate(){
        // to do: perform checks here
        System.out.println("Enter the birth date [YYYY-MM-DD]: ");
        return promptForStringResponse();
    }
	public String promptForAddress(){
        System.out.println("Enter the address: ");
        return promptForStringResponse();
    }
    
    public String promptForEmail(){
        // to do: perform checks here
        System.out.println("Enter the email: ");
        return promptForStringResponse();
    }

	private void createAccountGuardian()
	{
		System.out.println("Enter your first name: ");
        String firstName = promptForStringResponse();
        System.out.println("Enter your last name: ");
        String lastName= promptForStringResponse();
        System.out.println("Create your username: ");
        String username= promptForStringResponse();
        String password = createPassword();
        String birthDate = promptForBirthDate();
        String phone = promptForPhone();
        String email = promptForEmail();
        String address = promptForAddress();
	}
	//this would be like a createCabin method.
	private void createCabin() {
		String title = getField("Title");
		String author = getField("Author");

		//tells you whether or not it actually worked
		//if returns true, ...
		if(campFacade.createCabin(title, author)) {
			System.out.println("You have successfully created a Cabin.");
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
	private String getUserCabin() {
		System.out.print("Enter Cabin Name: ");
		
		while(true) {

			String cabinTitle = scanner.nextLine().trim().toLowerCase();
			System.out.println("CABIN NAME ENTERD: " + cabinTitle);

			
			if(!cabinTitle.contentEquals(""))
			{
				return cabinTitle;
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

	private void findCabin() {
		System.out.println("\n-----Searching the Library-----");

		String cabin = getUserCabin();//calls method above
		
		if(cabin == null)return;
		
		if(!campFacade.findCabin(cabin)) {
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

private void checkoutCabin() {
	System.out.println("\n-----Checking out an item-----");
	// String cabin = getUserItem();
	String cabin = getUserCabin();
	
	if(cabin == null)return;
	
	if(!campFacade.checkout(cabin)) {
		System.out.println("Sorry we couldn't checkout your item\n");
		return;
	}
	System.out.println("Your item was successfully checked out\n");
}
























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

