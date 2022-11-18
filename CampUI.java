import java.util.ArrayList;
import java.util.Scanner;




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
	
	CampUI(CampFacade facade){
		scanner = new Scanner(System.in);
		campFacade = facade;
	}
	
	public void run() {

		System.out.println(WELCOME_MESSAGE);
		
		//Loop as long as we want to keep interacting with the library
		while(true) 
        {
			//prints out the main menu
			displayMainMenu();
			//stores the user's command as an integer
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
			switch(userCommand) 
			{
				case(0):
                System.out.println("Create Account.");
					// createAccount();
					break;
				case(1):
				//calls the login function
				System.out.println("Login");
					// login();
					//^^login should call individual user type screens???
					break;
			}
		}
		System.out.println("Good bye, and have a nice day");
	}
	
//methods that print messages to the user along with referneces the library objecti

///////METHODS FOR PRINTING MESSAGES/ INTERACTING WITH USER.////
	private void displayMainMenu() 
	{
		System.out.println("\n************ Main Menu *************");
		for(int i=0; i< mainMenuOptions.length; i++) {
			System.out.println((i+1) + ". " + mainMenuOptions[i]);
		}
		System.out.println("\n");
	}
	
	//get the users command number, if it's not valid, return -1
	private int getUserCommand(int numCommands) 
	{
		System.out.print("What would you like to do?: ");
		
		String input = scanner.nextLine();
		int command = Integer.parseInt(input) - 1;
		
		if(command >= 0 && command <= numCommands -1) return command;
		
		return -1;
	}
	
    //asks for prompt, then prints the prompt and then returns the inputted input from the user as a string
	private String getField(String prompt) 
	{
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

	//my old original login method
	// private void login() {
	// 	//asks for user name.
	// 	String userName = getField("Username");

	// 	// System.out.println("if library login method equals true");

	// 	//if login was successful
	// 	if(campFacade.login(userName)) {
	// 		System.out.println("creates a new instance of user");
	// 		User currentUser = campFacade.getCurrentUser();
	// 		System.out.println("Welcome " + currentUser.getFirstName() + " " + currentUser.getLastName() + "!");
	// 	} else {
	// 		System.out.println("Sorry, invalid username ");
	// 	}
	// 
	// }

//NEWLY ADDED METHODS ;)

//creating the director is done through this login function.
 	/**
     * Logs someone in if their credentials match the database
     */
    private void login() {

        String userName = get("Username");
        String password = get("Password");
        // LoginInfo loginInfo = new LoginInfo(userName, password);
        

        boolean loginChecker = campFacade.login(userName, password);
		//my version^^

		int loginnum = campFacade.login(userName, password);
		
        if (loginnum == 1) {
            directorScreen();
        } else if (loginnum == 2) 
		{
            userScreen();
        } else if (loginnum == 3) 
		{
            counselorScreen();
        } else
		{
			System.out.println("Username and Password are not valid");
		}

    }

	/**
     * Formats questions and returns teh users answer
     * 
     * @param prompt
     * @return users input
     */
    private String get(String prompt) 
	{
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

	
//the meat of it:

  /**
     * Welcomes the user once they sign in with their first and last name
     */
    private void welcomeDirectorScreen() {
        System.out.println("\nWelcome Back, " 
		+ campFacade.getCurrentDirector().getFirstName() + " "
                + campFacade.getCurrentDirector().getLastName() + "!");
    }

	/**
     * The screen directors see when the login
     */
    private void directorScreen() {
		//prints back basic info of the returning director
        welcomeDirectorScreen();
        boolean run = true;
        while (run) {
			//prints the director's options
            directorOptions();

            int option = scanner.nextInt();
            scanner.nextLine();
            clear();

            switch (option) {
                case 1: // View My Profile
                    System.out.println(campFacade.viewDirectorProfile());
                    break;
                case 2: // Edit My (director) Profile
                    editDirector();
                    break;
                case 3: // Create new camp
                    createCamp();
                    break;
                case 4: // View Activities
                    System.out.println("What camp would you like to see?");
                    System.out.println(campFacade.getActivities(scanner.nextLine()));
                    break;
                case 5: // Edit Activities
                    changeActivites();
                    break;
                case 6: // View All counselors
                    System.out.println(campFacade.getCounselors());

                    break;
                case 7: // View a Counselors Information
                    String firstName = get("Counselor's First Name");
                    String lastName = get("Counselor's Last Name");
                    System.out.println(campFacade.getCounselorList().getCounselorByName(firstName, lastName));
                    break;
                case 8: // Remove Counselor
                    String campName = get("Camp");
                    String counselorname = get("Counselor First Name");
                    String counselorlname = get("Counselor Last Name");
                    campFacade.removeCounselor(counselorname, counselorlname, campFacade.getCampList().getCamp(campName));
                    break;
                case 9: // View All Campers
                    System.out.println(campFacade.getCampers());
                    break;
                case 10: // View A Camper
                    String camperName = get("Camper's First Name");
                    String camperlName = get("Camper's Last Name");
                    System.out.println(campFacade.getCamperList().getCamperByName(camperName, camperlName));

                case 11: // Remove Camper
                    String campname = get("Camp");
                    String campername = get("Camper First Name");
                    String camperlname = get("Camper Last Name");
                    campFacade.removeCamper(campername, camperlname, campFacade.getCampList().getCamp(campname));
                    break;
                case 12: // View Schedule
                    String camp = get("Camp");
                    int week = Integer.parseInt(get("Week Number"));
                    int group = Integer.parseInt(get("Group Number"));
                    System.out.println(campFacade.getSchedule(camp, week, group));
                    break;
                case 13: // Logout
                    run = false;
					//^^should call logout method which saves everything.
                    break;
                default:
                    System.out.println("Please enter a valid number");
                    break;
            }
            // pause();
        }
    }

    /**
     * options on the directors homepage
     */
    private void directorOptions() {
        System.out.println(
                "1. View My Profile\n"+
				"2. Edit My Profile\n"+
				"3. Create New Camp\n"+ 
				"4. View Activities\n"+ 
				"5. Edit Activites\n"+ 
				"6. View All Counselors\n"+
                "7. View a Counselors Information\n"+ 
				"8. Remove Counselor\n"+
				"9. View All Campers\n"+
				"10. View a Campers Information\n"+
				"11. Remove Camper\n"+
				"12. View Schedules\n"+
                "13. Logout");
    }

	/**
     * Prints out activities for a certain camp
     */
    private void activites() 
    {
        System.out.println("Which camp's activities would you like to see?");
        System.out.println(facade.getCamps());
        System.out.println(facade.getActivities(scan.nextLine()));
    }

    /**
     * Prints out the available weeks for a certain camp
     */
    private void weeks() 
    {
        System.out.println("Which camps sessions would you like to see?");
        System.out.println(facade.getCamps());
        String camp = scan.nextLine();

        int i = 1;
        for (Week week : facade.getWeeks(camp)) {
            System.out.println("Week " + i + ": " + week);
            i++;
        }
    }

	/**
     * prompts dircetor for new camp information
     */
    private void createCamp() {

        int year = Integer.parseInt(get("Year of Camp"));
        String name = get("Name of Camp");
        String description = get("Short Description of Camp");
        String weekString = get("Number of Weeks");
        int weeknum = Integer.parseInt(weekString);

        HashMap<Integer, Week> weeks = new HashMap<Integer, Week>();

        for (int i = 1; i <= weeknum; i++) {
            System.out.println("Week " + i + ": ");

            Date startDate = formatDate(get("Start Date(MM/DD/YYYY)"));
            Date endDate = formatDate(get("End Date(MM/DD/YYYY)"));

            String theme = get("Theme");
            Week week = new Week(theme, startDate, endDate, false);
            Integer num = Integer.valueOf(i);
            weeks.put(num, week);
        }

        ArrayList<Activity> activities = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {
            System.out.println("Activity " + i);
            String activityName = get("Name");
            String activityDesc = get("Description");
            String location = get("Location");
            Activity activity = new Activity(activityName, location, activityDesc);
            activities.add(activity);
        }

        campFacade.newCamp(name, description, year, activities, weeks);

        /*
         * for (int i = 0; i < weeknum; i++) {
         * facade.generateSchedules(name, i, activities);
         * }
         */
        campFacade.generateSchedulesCamp(name, activities);

    }

    /**
     * Changes activities for a given camp
     */
    private void changeActivites() 
	{
        String camp = get("Which Camp would you like to change the activities for");
        boolean run = true;
        while (run) {

            System.out.println("Would you like to: \n " 
			+ "1. Edit Current Activites \n " 
			+ "2. Delete Current Activites\n " 
			+ "3. Add New Activities \n " 
			+ "4. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    editActivities(camp);
                    break;
                case 2:
                    deleteActivity(camp);
                    break;
                case 3:
                    addActivity(camp);
                    break;
                case 4:
                    run = false;
                    break;
                default:
                    System.out.println("Please enter a valid number");
            }
        }
    }

    /**
     * edits particular activities
     * 
     * @param camp
     */
    private void editActivities(String camp) {
        System.out.println("Which Activity would you like to edit?");
        int i = 1;
        for (Activity activity : campFacade.getCampList().getCamp(camp).getActivitiesArrayList()) {
            System.out.println(i + ". " + activity);
            i++;
        }
        int num = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.println("New Activity");
        String activityName = get("Name");
        String activityDesc = get("Description");
        String location = get("Location");
        Activity activity = new Activity(activityName, location, activityDesc);

		//assigns activity to the campList class
        campFacade.getCampList().getCamp(camp).getActivitiesArrayList().set(num, activity);
    }

    /**
     * deletes a particular activity
     * 
     * @param camp
     */
    private void deleteActivity(String camp) {
        System.out.println("Which Activity would you like to delete?");
        int i = 1;
        for (Activity activity : campFacade.getCampList().getCamp(camp).getActivitiesArrayList()) {
            System.out.println(i + ". " + activity);
            i++;
        }
    	campFacade.getCampList().getCamp(camp).getActivitiesArrayList().remove(scanner.nextInt() - 1);
        scanner.nextLine();
    }

    /**
     * adds an activity to a camp
     * 
     * @param camp
     */
    private void addActivity(String camp) 
	{
        System.out.println("New Activity");
        String activityName = get("Name");
        String activityDesc = get("Description");
        String location = get("Location");
        Activity activity = new Activity(activityName, location, activityDesc);
        campFacade.getCampList().getCamp(camp).getActivitiesArrayList().add(activity);
    }

	
	
    public static void main(String[] args) {
		CampUI libraryInterface = new CampUI();
		libraryInterface.run();
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
	
}

