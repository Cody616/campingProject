import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

import java.util.Scanner;

public class Session extends Camp{

    //this is all done when creating a camp object, which will pass down the values to the session/ sessionList class
    //asks user to input length of sessions
    //asks user to input amt of cabins 

    /*
     * each session has a theme, assigned cabins, activities
     * , and 7 days make up a session.
     */

    private int sessionNum;
    private String theme;
    private String description;
    private String startDate;
    private String endDate;
    private int cabinAmt;

    private ArrayList<Cabin> cabins = new ArrayList<Cabin>();
    private ArrayList<Counselor> counselors = new ArrayList<Counselor>();
    private ArrayList<Camper> campers = new ArrayList<Camper>();

    private ArrayList<Activity> sessionActivities = new ArrayList<Activity>();
    private String[] weekSchedule = new String[7]; 
   
    // private final int SCHEDULE_LENGTH = 8;

    // private String[] schedule = new String[SCHEDULE_LENGTH];
    
    //array that stores the entire week's schedule in a session
    //this array would only hold the toString from the schedule array.

    //new session
    public Session(int sessionNum, String theme, String description, String startDate, String endDate, int cabinAmt, ArrayList<Activity> sessionActivities, ArrayList<Cabin> cabins)
    {
        /*
         * prob wont need ArrayList<String> activities maybe possibly
         */
        this.sessionNum = sessionNum;
        this.theme = theme;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cabinAmt = cabinAmt;
        
        this.sessionActivities = sessionActivities;
        this.cabins = cabins;

        // this.isFull = isFull;

        // this.schedule[0] = "8:00 am - 9:00 am: \n\tActivity: Breakfast \n\tLocation: Cafeteria\n";//0
        // this.schedule[1] = "10:00 am - 11:00 am: ";
        // this.schedule[2] = "12:00 am - 1:00 pm: \n\tActivity: Lunch \n\tLocation: Cafeteria\n";//2
        // this.schedule[3] = "2:00 pm - 3:00 pm: ";
        // this.schedule[4] = "4:00 pm - 5:00 pm: ";
        // this.schedule[5] = "6:00 pm - 7:00 pm: \n\tActivity: Dinner \n\tLocation: Cafeteria\n";//6
        // this.schedule[6] = "8:00 pm - 9:00 pm: ";
        // this.schedule[7] = "10:00 pm: Bed.";//8
        
        //^^^^total activities
    }

//////////////GETTERS AND SETTERS////////
    public int getSessionNum() {
        return sessionNum;
    }
    public void setSessionNum(int sessionNum) {
        this.sessionNum = sessionNum;
    }

    public String getTheme()
    {
        return this.theme;
    }
    public void setTheme(String theme)
    {
        this.theme = theme;
    }

    public String getDescription()
    {
        return this.description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getStartDate()
    {
        return this.startDate;
    }
    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public String getEndDate()
    {
        return this.endDate;
    }
    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }

    public int getCabinAmount() 
    {
        return cabinAmt;
    }

    public void setCabinAmount(int cabinAmt) {
        this.cabinAmt = cabinAmt;
    }

//////USER GROUPS GETTERS AND SETTERS

///////////////////CABINS STUFF////////////////////////
    public ArrayList<Cabin> getCabins()
    {
        return this.cabins;
    }
    public void setCabins(ArrayList<Cabin> cabins)
    {
        this.cabins = cabins;
    }

    public ArrayList<Counselor> getCounselors() {
        return this.counselors;
    }
    public void setCounselors(ArrayList<Counselor> counselors) {
        this.counselors = counselors;
    }

    public ArrayList<Camper> getCampers() {
        return this.campers;
    }
    public void setCampers(ArrayList<Camper> campers) {
        this.campers = campers;
    }

    public void addCamper(Camper camper) {
        if (camper != null) {
            campers.add(camper);
        }
    }

    public void addCounselor(Counselor counselor) {
        if (counselor != null) {
            counselors.add(counselor);
        }
    }

    //with parameter of arrayList of campers
    public boolean containsCamper(ArrayList<Camper> userCampers) {
        for (Camper c : campers) {
            for (int i = 0; i < userCampers.size(); i++) {
                if (c.getFirstName().equals(userCampers.get(i).getFirstName())
                        && c.getLastName().equals(userCampers.get(i).getLastName()))
                    return true;
            }
        }
        return false;
    }

    //with first and last name as the parameters
    public boolean containsCamper(String firstName, String lastName) {
        for (Camper c : campers) {
            if (c.getFirstName().equals(firstName)
                    && c.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }

    public void generateCabins(ArrayList<Cabin> cabins, int minAge, int maxAge)
    {
        for (int i = 0; i < cabinAmt; i++) {

            /*
             * !!!!!!!!!!!!!!!!!!!!!! CABIN ASSIGNMENT STILL NEEDS TO BE DONE!!!!
             */

            cabins.add(new Cabin(UUID.randomUUID()));

            System.out.println("Please enter the Minimum age of Cabin #: " + (i+1));
            cabins.get(i).setAgeMin(minAge);

            System.out.println("Please enter the Maximum age of Cabin #: " + (i+1));
            cabins.get(i).setAgeMax(maxAge);

            //other cabin stuff
        }
    }


    //generates schedules from inputted ArrayList of activity and then assigns them to the cabins
    public void generateSchedules(ArrayList<Activity> activities) 
    {
        //firstly generates cabins
        //loops through and creates the amount of cabins the user entered. cabins and adds them to the cabin arrayList

        //loops through the inputted cabin amount and assigns each cabin a uuid

        //then asks the user for the minimum and maximum age???
        for (int i = 0; i < cabinAmt; i++) 
        {

            cabins.add(new Cabin(UUID.randomUUID()));

            // System.out.println("Please enter the Minimum age of Cabin #: " + (i+1));
            // cabins.get(i).setAgeMin(i);

            // System.out.println("Please enter the Maximum age of Cabin #: " + (i+1));
            // cabins.get(i).setAgeMax(i);

            //other cabin stuff....
        }
        //^^maybe ask for the cabin amt first, then pass it thru the method

        Random rand = new Random();

        //loops through the cabin's size and assigns the week schedule to each cabin
        for (int c = 0; c < cabins.size(); c++) 
        {
            //loops through the days of the week
            String[] weekSchedule = new String[7];
            for (int d = 0; d < 7; d++) {

                // creates a list of groupActivities of 8 :O same as mine
                //so basically a complete schedule aka String[] schedule

                // ArrayList<Activity> groupActivities = new ArrayList<Activity>(8);
                //^^schedule
               
                //creates and assigns values to the schedule array.

                //creates a new schedule for each day.
                String[] schedule = new String[8];
                schedule[0] = "8:00 am - 9:00 am: \n\tActivity: Breakfast \n\tLocation: Cafeteria\n";//0
                schedule[1] = "10:00 am - 11:00 am: ";
                schedule[2] = "12:00 am - 1:00 pm: \n\tActivity: Lunch \n\tLocation: Cafeteria\n";//2
                schedule[3] = "2:00 pm - 3:00 pm: ";
                schedule[4] = "4:00 pm - 5:00 pm: ";
                schedule[5] = "6:00 pm - 7:00 pm: \n\tActivity: Dinner \n\tLocation: Cafeteria\n";//6
                schedule[6] = "8:00 pm - 9:00 pm: ";
                schedule[7] = "10:00 pm: Bed.";//8

                //assigns the schedule array
                for (int i = 0; i < 8; i++) 
                {
                    if(schedule[i].contains("Breakfast")
                    || schedule[i].contains("Lunch")
                    || schedule[i].contains("Dinner")
                    || schedule[i].contains("Bed"))
                    {
                        // System.out.println(schedule[i].toString());
                        continue;
                    }
                    else
                    {
                        int randomIndex = rand.nextInt(activities.size()); 
                        //assigns first activity from arraylist to end of schedule string.
                        schedule[i] += activities.get(randomIndex).toString();
                        // System.out.println(schedule[i].toString());
                    }

                }

                // assigns whole schedule to one string based off day
                String temp = "";
                //if Monday
                if(d == 0)
                {
                    temp = convertScheduleArrayToString(schedule, "Monday");
                }
                //if Tuesday
                if(d == 1)
                {
                    temp = convertScheduleArrayToString(schedule, "Tuesday");
                }
                //if Wednesday
                if(d == 2)
                {
                    temp = convertScheduleArrayToString(schedule, "Wednesday");
                }
                //if Thursday
                if(d == 3)
                {
                    temp = convertScheduleArrayToString(schedule, "Thursday");
                }
                //if Friday
                if(d == 4)
                {
                    temp = convertScheduleArrayToString(schedule, "Friday");
                }
                //if Saturday
                if(d == 5)
                {
                    temp = convertScheduleArrayToString(schedule, "Saturday");
                }
                //if Sunday
                if(d == 6)
                {
                    temp = convertScheduleArrayToString(schedule, "Sunday");
                }

                //assigns individual schedule to weekSchedule array.
                weekSchedule[d] = temp + "\n";
                // System.out.println("week schedule day#: " + d);
                //System.out.println(weekSchedule[d]);
            }

            //assigns cabin number to cabin
            cabins.get(c).setCabinNumber(c + 1);
            //should set the week schedule.
            cabins.get(c).setWeekSchedule(weekSchedule);
        }

    }

    //method that converts string[] schedule to a single string
    public String convertScheduleArrayToString(String[] schedule, String day)
    {
        String temp = "\t\t\t" + day + "'s Schedule\n" ;

        //loops through array, and then appends each string to the end of the string???

        //loops through entered schedule and assigns it to one string
        for(int i = 0; i < schedule.length; i++)
        {
            temp += schedule[i].toString() + "\n";
        }

        // returns single string value
        return temp;
    }

    public String viewAllCabinSchedules() 
    {
        String temp = "";
        //loops through all cabins
        for (Cabin c : cabins) {
            temp += "\tCabin: " + c.getCabinNumber() 
            + "\nSchedule: " + c.printWeekSchedule() + "\n";
        }
        return temp;
    }   

///////////////////////ACTIVITIES///////////////////////////
    public ArrayList<Activity> getSessionActivities()
    {
        return this.sessionActivities;
    }

    public void setSessionActivities(ArrayList<Activity> sessionActivities)
    {
        this.sessionActivities = sessionActivities;
    }

//would add activity to activity arrayList
//, and then assign that to the Schedule object.
    public void addActivity(Activity activity) 
    {
        sessionActivities.add(activity);
    }

    //removes activity from activity arrayList??????
    public void removeActivity(Activity activity) {
        //searches through activities list, removes if activity matches
        for(int i = 0; i < this.sessionActivities.size(); i++) {

            if(this.sessionActivities.get(i) == activity) {
                this.sessionActivities.remove(i);
            }
        }
    }

/////////////////////////SCHEDULE////////////////////////////
//SCHEDULE STUFF    
    public String[] getWeekSchedule() {
        return this.weekSchedule;
    }
    public void setWeekSchedule(String[] weekSchedule) {
        this.weekSchedule = weekSchedule;
    }




/////////////////////////FRONT END/////////////////////////
public static void main(String[] args)
{
     Scanner keyboard = new Scanner(System.in);
     /*
      * needs to create one session, which asks for the user to add activities to the schedule.
      * 
      * an activity has a name and location.
      * 
      * it then should randomly assign schedule from populated activity arrayList to a schedule object, which then gets assigned to the schedule array of 7. 
      * This is used to represent a week amount worth of stuff. This array of schedules should then get assigned to a cabin object.
      * 
      */
    System.out.println();
    System.out.println("Creating a Session Object.");
    // Session session = null;
    System.out.println("Please enter the theme for the Session.");
    String theme = "theme";
    // String theme = keyboard.nextLine();


    System.out.println("Please enter the description for the Session.");
    String description = "description";
    // String description = keyboard.nextLine();


    System.out.println("Please enter the session start date. (MM/DD/YY)");
    // String startDate = keyboard.nextLine();
    String startDate = "startDate";


    System.out.println("Please enter the session end date. (MM/DD/YY)");
    // String endDate = keyboard.nextLine();
    String endDate = "endDate";
   

    // Session session = new Session(theme, description, cabins, startDate, endDate, sessionActivities);
    
    ArrayList<Activity> inputtedActivities = new ArrayList<Activity>();

    int num = 1;
    //loops through 4 times to add to an arrayList of type Activity
    for(int i = 4; i > 0; i--)
    {    
        System.out.println("Please input at least 4 activities. \nYou have a remaining of "+ i + " activities that are left to be added.");
        System.out.println("Please enter the name of the activity.");
       
        String name = "name #: " + num;
        // System.out.println("Please enter the location of the activity.");

        String location = "location #: " + num;
       
        Activity activity = new Activity(name, location);
        //adds activity to arrayList.
        inputtedActivities.add(activity);

        // System.out.println(inputtedActivities.get(num - 1).toString());
        num++;

        // System.out.println();
    } 

///////////////////ADDING MORE ACTIVITIES SECTION/////////////////////////////
    System.out.println("Would you like to enter more activities to the session? Enter yes or no.");
    String input = keyboard.nextLine();

    boolean checker = true;
    while(checker == true)
    {   
        if(input.equalsIgnoreCase("yes"))
        {
            boolean checker2 = true;
            while(checker2 == true)
            {
                System.out.println("Please enter the name of the activity.");
                String name = keyboard.nextLine();

                System.out.println("Please enter the location of the activity.");
                String location = keyboard.nextLine();

                //assigns variables to Activity object
                Activity activity = new Activity(name, location);
                //adds activity to arrayList.
                inputtedActivities.add(activity);

                System.out.println("Would you like to add another activity? Enter yes or no.");

                input = keyboard.nextLine();
                if(input.equalsIgnoreCase("yes"))
                {
                    continue;
                }
                if(input.equalsIgnoreCase("no"))
                {
                    checker2 = false;
                }
            }
        } 
        if(input.equalsIgnoreCase("no"))
        {
            checker = false;
        }
    }
/////////////////////////////////////////////////////////////////////////////////
    System.out.println("Activities have been assigned.");

    //would ask for cabin info after the info above in the real program, but going to print out the methods of the session class now

    System.out.println("Please enter the amount of cabins you would like to have. The limit is 6.");
    int cabinSize = keyboard.nextInt();
    if(cabinSize > 6 || cabinSize == 0)
    {
        System.out.println("Please enter a value again.");
        cabinSize = keyboard.nextInt();
    }

    ArrayList<Cabin> cabins = new ArrayList<Cabin>();
    Session session = new Session(1, theme, description, startDate, endDate, cabinSize, inputtedActivities, cabins);

    System.out.println("SESSION HAS BEEN CREATED.");
    System.out.println("calling generateSchedules method now");

    // System.out.println();
    // System.out.println("PRINTS ALL ACTIVITIES FROM SESSION OBJECT");
    // for(int i = 0; i < session.getSessionActivities().size(); i++)
    // {
    //     System.out.println(session.getSessionActivities().get(i).toString());
    // }
    // System.out.println();

    // System.exit(0);

    // creates schedule
    // session.createSchedule();
    //^^this method is called for in assignWeekSchedule.

    //assigns the schedules to the cabins
    session.generateSchedules(inputtedActivities);
}
  
}



