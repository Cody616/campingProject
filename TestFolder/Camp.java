import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Camp {
    /*
     * needs name of the camp, 
     * amt of sessions, 
     * and amt of cabins for the camp season
     */

     /*
      * camp facade would jsut have users and camps object????
      * camps object is an arraylist of camp objects
      * currently inside the camp object rn, which will have 9 sessions and 6 cabins as the limit.
      *
      *
      * should ask user for activity info?????<<< this would be info for the session????
      */
     private UUID id;

    


    private int campYear;
    private String campName;
    private String campAddress;
    
   



    private int sessionsAmt;
    


    private int cabinAmt;


    private static Session[] sessions;
    private static Cabin[] cabins;
     //^^these could possibly be done in a cabins/ sessions class maybe..... not there yet :D

    //new Camp
    public Camp(int campYear, String campName, String campAddress, int sessionsAmt, int cabinAmt)
    {
        this.id = UUID.randomUUID();
        this.campName = campName;
        this.campYear = campYear;
        this.sessionsAmt = sessionsAmt;
        this.cabinAmt = cabinAmt;

        //each session has like 9 weeks, but also contains the cabins associated per week.
        this.sessions = new Session[sessionsAmt];;
        this.cabins = new Cabin[cabinAmt];

        //^^knowing this, then i feel like i don't need the cabin array in the camp class.

        //rethinking this immediately yes you do looool 
        //re rethinking this, no. because the camps are associated by the session as that is how the activities are identified. 
        //re re rethinking this^^ while this is true, we still want a cabins arraylist in this object so that the user can interact with the cabin Object properties
        //^^then again???? could just have this be a method of the schedules class

        // this.cabins = new ArrayList<Cabin>();
    }

    //loaded preexisting Camp from json
    public Camp(UUID id, int campYear, String campName, String campAddress, int sessionsAmt, int cabinAmt, Session[] sessions, Cabin[] cabins)
    {
        this.id = id;
        this.campYear = campYear;
        this.campName = campName;
        this.campAddress = campAddress;
    
        //session/ cabin amt
        this.sessionsAmt = sessionsAmt;
        this.cabinAmt = cabinAmt;

        //each session has like 9 weeks, but also contains the cabins associated per week.
        this.sessions = sessions;
        this.cabins = cabins;
    }

     //this is what the director is creating in scenario 1.

     //would have a setSessions method. would loop thru 9 


    // public static int getSessionsLimit() {
    //     return SESSIONS_LIMIT;
    // }
    // public static int getCabinsLimit() {
    //     return CABINS_LIMIT;
    // }
        
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

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

    public int getSessionsAmt() {
        return sessionsAmt;
    }
    public void setSessionsAmt(int sessionsAmt) {
        this.sessionsAmt = sessionsAmt;
    }
    
    public int getCabinAmt() {
        return cabinAmt;
    }
    public void setCabinAmt(int cabinAmt) {
        this.cabinAmt = cabinAmt;
    }

    public static Session[] getSessions() {
        return sessions;
    }
    public static void setSessions(Session[] sessions) {
        Camp.sessions = sessions;
    }

    public static Cabin[] getCabins() {
        return cabins;
    }
    public static void setCabins(Cabin[] cabins) {
        Camp.cabins = cabins;
    }
    


//this could possibly be like a setCamp method.
    public static void main(String[] args)
    {


        // System.exit(0);

        Scanner keyboard = new Scanner(System.in);
      
        System.out.println("Please enter: " +
                            "\n 1. if you would like to create a new camp" +
                            "\n 2. if you would like to visit a previous camp" +
                            "\n 3. if you would like to edit a camp's info");
        
        if(keyboard.nextInt() == 1)
        {
            System.out.println();
            System.out.println("CREATING A CAMP OBJECT.");
            Camp camp = null;
            System.out.println();

            System.out.println("Please enter a year for the camp.");
            camp.setCampName(keyboard.nextLine());
            System.out.println();

            System.out.println("Please enter a name for the camp.");
            camp.setCampName(keyboard.nextLine());
            System.out.println();

            System.out.println("Please enter the address for the camp.");
            camp.setCampAddress(keyboard.nextLine());
            System.out.println();

            System.out.println("Please enter the year for the camp.");
            camp.setCampYear(keyboard.nextInt());
            System.out.println();
            //should check and only store the month whether it is an actual month
            System.out.println("Please enter the amount of sessions you would like to have (The limit is 9)");
            camp.setSessionsAmt(keyboard.nextInt());

            Session[] sessionList = camp.getSessions();
            System.out.println();

            //loops through the array of SESSIONS OBJECTS
            for(int i = 0; i < sessionList.length; i++)
            {
                System.out.println("Please enter the theme of session #: " + (i+1));
                    sessionList[i].setTheme(keyboard.nextLine());
                System.out.println();

                System.out.println("Please enter the description of session #: "+ (i+1));
                sessionList[i].setDescription(keyboard.nextLine());
                System.out.println();
                
                System.out.println("There are a total of 8 time slots in a camp schedule throughout the day.");
                System.out.println("This means that there are only 5 activities open for each day.");
                System.out.println("Please add an activity to session #: " + (i+1) + " (needs a minimum of 5)");
                //sets the size of the array of activities
              
                //ASKS FOR ACTIVITIES
                sessionList[i].setActivitiesSize(5);
                Activity[] activities = new Activity[sessionList[i].getActivitiesSize()];
                //loops
                for(int j = 0; j < 5; j++)
                {
                    System.out.println("Please enter the Activity name.");
                    activities[i].setName(keyboard.nextLine());



                    System.out.println("Please enter the Activity location.");
                    // activities[i].setActivityLocation(keyboard.nextLine());
                    activities[i].setLocation(keyboard.nextLine());



                    int remaining = (j + 1) - 5;
                    System.out.println("Please add another activity to the session. (There are " + remaining + " remaining)");
                }
                boolean checker = true;
                while(checker)
                {
                    System.out.println("Would you like to add any more activities to the session? Enter Yes or No.");

                    if(keyboard.nextLine().equalsIgnoreCase("yes"))
                    {
                        System.out.println("Please enter the Activity name.");
                        // sessionList[i]
                        activities[i].setName(keyboard.nextLine());
                        //needs to add it to the arraylist and then then schedule class 
                        // will handle the assigning to cabins




                        System.out.println("Please enter the Activity location.");
                        activities[i].setLocation(keyboard.nextLine());


                    }
                    
                    if(keyboard.nextLine().equalsIgnoreCase("no"))
                    {
                        checker = false;
                    }

                }
                //sets the arraylist of activities in a sessionobject
                sessionList[i].setActivities(activities);

                
                //REFERENCING CABINS THRU SESSIONS OBJECT NOW
                System.out.println();
                System.out.println("How many cabins would you like to have for the session? (the limit is 9)");
                //in the set cabin method, just have it to where if int cabinSizeint is <=9 && >0
                System.out.println();

                //loops
                System.out.println("Enter the name of the cabin:");

                System.out.println("Enter the lower age limit of the cabin:");

                System.out.println("Enter the upper age limit of the cabin:");

                System.out.println();

            }
           

           

         

            //End message to user.
            System.out.println();
            System.out.println("The schedules have been randomly generated and assigned.");
            System.out.println("There are time conflicts between all the schedules of the cabin.");
            System.out.println();
        }

        if(keyboard.nextInt() < 2)
        {
            System.out.println("greater than 2.");
        }

    }
}
