import java.util.ArrayList;
import java.util.Scanner;

public class Camp {

    private int campYear;
    private String campName;
    private String campAddress;

    private int sessionsTotal;
    private int cabinTotal;
    private ArrayList<Session> campSessions = new ArrayList<Session>();

    //sessions holds the info for the cabins like the schedules.
   
    
    /*
     * basic constructor
     */
    public Camp(int campYear, String campName, String campAddress, int sessionsTotal, int cabinTotal,ArrayList<Session> campSessions)
    {
        this.campYear = campYear;
        this.campName = campName;
        this.campAddress = campAddress;
        this.sessionsTotal = sessionsTotal;
        this.cabinTotal = cabinTotal;
        this.campSessions = campSessions;
        //^^this is also known as the master schedule as it has access to all schedules
    }

    /**
     * An empty constructor, useful for creating a new instance of camp where attributes are unknown
     * 
     * singleton camp object
     */
    public Camp() {
    }

    //GETTERS AND SETTERS
    public int getCampYear() {
        return campYear;
    }
    public void setCampYear(int campYear) {
        this.campYear = campYear;
    }

    public String getCampName() {
        return campName;
    }
    public void setCampName(String campName) {
        this.campName = campName;
    }

    public String getCampAddress() {
        return campAddress;
    }
    public void setCampAddress(String campAddress) {
        this.campAddress = campAddress;
    }

    //SESSIONS STUFF
    public int getSessionsTotal() {
        return sessionsTotal;
    }
    public void setSessionsTotal(int sessionsTotal) {
        this.sessionsTotal = sessionsTotal;
    }
    
    //might not need this getter and setter
    public int getCabinTotal() {
        return cabinTotal;
    }
    public void setCabinTotal(int cabinTotal) {
        this.cabinTotal = cabinTotal;
    }

    public ArrayList<Session> getCampSessions() {
        return campSessions;
    }
    public void setCampSessions(ArrayList<Session> campSessions) {
        this.campSessions = campSessions;
    }
 
    public Session getCampSession(int sessionNumber) 
    {
        return campSessions.get(sessionNumber);
    }

    //OTHER METHODS
    public void printAllSchedules()
    {
        //loops through all campSessions
        for (int i = 0; i < campSessions.size(); i++) {

            // campSessions.get(i).

            System.out.println(campSessions.get(i).getTheme());
        }
    }

    public String toString() {
        return "Camp Year: " + this.campYear 
            + "\nCamp Name: " + this.campName  
            + "\nCamp Address: " + this.campAddress;
    }









//this could possibly be like a setCamp method.
    // public static void main(String[] args)
    // {
    //     Scanner keyboard = new Scanner(System.in);
      
    //     System.out.println("Please enter: " +
    //                         "\n 1. if you would like to create a new camp" +
    //                         "\n 2. if you would like to visit a previous camp" +
    //                         "\n 3. if you would like to edit a camp's info");
        
    //     if(keyboard.nextInt() == 1)
    //     {
    //         System.out.println();
    //         System.out.println("CREATING A CAMP OBJECT.");
    //         Camp camp = null;
    //         System.out.println();

    //         System.out.println("Please enter a year for the camp.");
    //         camp.setCampYear(keyboard.nextLine());
    //         System.out.println();

    //         System.out.println("Please enter a name for the camp.");
    //         camp.setCampName(keyboard.nextLine());
    //         System.out.println();

    //         System.out.println("Please enter the address for the camp.");
    //         camp.setCampAddress(keyboard.nextLine());
    //         System.out.println();

    //         System.out.println("Please enter the year for the camp.");
    //         camp.setCampYear(keyboard.nextLine());
    //         System.out.println();
    //         //should check and only store the month whether it is an actual month
    //         System.out.println("Please enter the amount of sessions you would like to have (The limit is 9)");

    //         camp.setSessionsAmt(keyboard.nextInt());
    //         // Session[] sessionList = new Session[camp.getSessionsAmt()];

    //         ArrayList<Session> campSessions = new ArrayList<Session>();

    //         //creates session arrayList to assign to camp object.

    //         System.out.println();


    //         //loops through the array of SESSIONS OBJECTS
    //         //should call the createSessions method. this will loop through sessions array list and ask info recursevly <<not even spelled right lol
    //         for(int i = 0; i < camp.getSessionsAmt(); i++)
    //         {
    //             System.out.println("Please enter the theme of session #: " + (i+1));
    //                 // sessionList[i].setTheme(keyboard.nextLine());
    //                 campSessions.get(i).setTheme(keyboard.nextLine());
    //             System.out.println();

    //             System.out.println("Please enter the description of session #: "+ (i+1));
    //             // sessionList[i].setDescription(keyboard.nextLine());
    //             campSessions.get(i).setDescription(keyboard.nextLine());
    //             System.out.println();
                
    //             System.out.println("There are a total of 8 time slots in a camp schedule throughout the day.");
    //             System.out.println("This means that there are only 5 activities open for each day.");
    //             System.out.println("Please add an activity to session #: " + (i+1) + " (needs a minimum of 5)");
    //             //sets the size of the array of activities
              
    //             //ASKS FOR ACTIVITIES
    //             // sessionList[i].setActivitiesSize(5);

    //             // Activity[] activities = new Activity[sessionList[i].getActivitiesSize()];
    //             // //loops
    //             // for(int j = 0; j < 5; j++)
    //             // {
    //             //     System.out.println("Please enter the Activity name.");
    //             //     activities[i].setName(keyboard.nextLine());

    //             //     System.out.println("Please enter the Activity location.");
    //             //     // activities[i].setActivityLocation(keyboard.nextLine());
    //             //     activities[i].setLocation(keyboard.nextLine());


    //             //     int remaining = (j + 1) - 5;
    //             //     System.out.println("Please add another activity to the session. (There are " + remaining + " remaining)");
    //             // }
    //             // boolean checker = true;
    //             // while(checker)
    //             // {
    //             //     System.out.println("Would you like to add any more activities to the session? Enter Yes or No.");

    //             //     if(keyboard.nextLine().equalsIgnoreCase("yes"))
    //             //     {
    //             //         System.out.println("Please enter the Activity name.");
                      
    //             //         activities[i].setName(keyboard.nextLine());
                       
    //             //         System.out.println("Please enter the Activity location.");
    //             //         activities[i].setLocation(keyboard.nextLine());
    //             //     }
                    
    //             //     if(keyboard.nextLine().equalsIgnoreCase("no"))
    //             //     {
    //             //         checker = false;
    //             //     }

    //             // }
    //             //sets the arraylist of activities in a sessionobject
    //             // sessionList[i].setActivities(activities);
    //             //^^^^!!!!!!!
                
    //             //REFERENCING CABINS THRU SESSIONS OBJECT NOW
    //             System.out.println();
    //             System.out.println("How many cabins would you like to have for the session? (the limit is 9)");
    //             System.out.println();
    //             //in the set cabin method, just have it to where if int cabinSizeint is <=9 && >0


    //             //loops
    //             // System.out.println("Enter the name of the cabin #: ");

    //             // System.out.println("Enter the lower age limit of the cabin:");

    //             // System.out.println("Enter the upper age limit of the cabin:");

    //             // System.out.println();

    //         }
           

           

    //         //End message to user.
    //         System.out.println();
    //         System.out.println("The schedules have been randomly generated and assigned.");

    //         System.out.println("There are time conflicts between all the schedules of the cabin.");
    //         System.out.println();
    //     }

    //     if(keyboard.nextInt() < 2)
    //     {
    //         System.out.println("greater than 2.");
    //     }

    // }

}
