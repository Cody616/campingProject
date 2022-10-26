import java.util.Scanner;
public class CampUI()
    {
        private static final String WELCOME_MESSAGE = "Welcome to our camp!";
        private String[] mainMenuOPtions = {"Create Account", "Login", }
        private Scanner scan //= new Scanner (System.in);
        
        CampUI()
        {
            scan = new Scanner(System.in);
            camp = new Camp();
        }

        public void run()
        {
            System.out.println("WELCOME_MESSAGE");
            while(true)
            {
                displayMainMenu();

                int userCommand = getUserCommand(mainMenuOPtions.length);
            }
        }

        public class printUserInitial() 
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("******* Main Menu *******");
            System.out.println("View Schedule");
            System.out.println("1. Register Child");
            System.out.println("3. Remove Child");
            System.out.println("4. Logout");
        }

        public class registerChild()
        {
            System.out.println("Register Child");
            System.out.println("Please be prepared to enter the following: ");
            System.out.println("Childs name, Childs age, Childs gender,\nChilds allergies, Childs Emergency contacts.")
        }

        public class viewSchedule()
        {
            System.out.println("****** View Schedule ******** ");
            System.out.println(" is in cabin : ");
            System.out.print("Schedule: ");
            System.out.println("7:00am-7:45am Breakfast.");
            System.out.println("\t8:00am-8:30am");
        }
        public class printDirectorInitlal()
        {
            System.out.println("******* Camp Director *******");
            System.out.println("1. Remove Child");
            System.out.println("Remove Counselor");
            System.out.println("3. View Cabins");
            System.out.println("4. View emergency contacts");
        }
        public class printViewCabin()
        {
            System.out.println("*****View Cabins *****");
            System.out.println("Counselor- ");
            System.out.println("Campers- ");
            System.out.println("Schedule: ");
        }
        public class printRemoveChild()
        {
            System.out.println("***** Remove Camper *****");
            System.out.println("Please enter the name of the camper that \nis being removed: ");
            System.out.println("Please enter the reason for their removal: ");
            System.out.println(" has been removed");
        }
        public class printEmergencyContacts()
        {
            System.out.println("***** VIew Emergency COntacts ****");
            System.out.println("Enter the name of a child: ");
            System.out.println(" emergency contacts name-");
        }
    }
)