import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

import java.util.Scanner;


// public getStartDate(){
//     return this.startDate;
// }

// public getEndDate(){
//     return this.endDate;
// }

public class Session {

    //this is all done when creating a camp object, which will pass down the values to the session/ sessionList class
    //asks user to input length of sessions
    //asks user to input amt of cabins 

    /*
     * each session has a theme, assigned cabins, activities
     * , and 7 days make up a session.
     */

    private UUID id;
    private String theme;
    private String description;
   
    private int cabinsSize;
    private Cabin[] cabins = new Cabin[cabinsSize];
    // private ArrayList<Cabin> cabins;//these cabins are the ones stored in the camp object system.
    private ArrayList<Activity> sessionTotalActivities; //<<<will need to randomize this and assign the activities to the schedule of the session

    private int activitiesSize;
    private Activity[] activities = new Activity[activitiesSize];

    private String startDate;
    private String endDate;
    
    // private ArrayList<String> activities;
    // private Activities activities;

    //array that stores the entire week's schedule in a session
    private Schedule[] weekSchedule = new Schedule[7];
    //^^EACH SESSION LASTS ONE WEEK.

    // private Schedule schedule;
    //^^hashmap????? 
   
    //new session
    public Session(String theme, String description, Cabin[] cabins, String startDate, String endDate, Activity[] activities)
    {
        /*
         * prob wont need ArrayList<String> activities maybe possibly
         */
        this.id = UUID.randomUUID();
        this.theme = theme;
        this.description = description;
        this.cabins = cabins;
        this.activities = activities;

        // this.startDate = startDate;
        // this.endDate = endDate;

        
        //^^^^total activities
    }
    
    public Schedule[] getWeekSchedule() {
        return weekSchedule;
    }
    public void setWeekSchedule(Schedule[] weekSchedule) {
        this.weekSchedule = weekSchedule;
    }

    //prexisting session
    public Session(UUID id, String theme, String description, Cabin[] cabins, String startDate, String endDate, Activity[] activities)
    {
        this.id = id;
        this.theme = theme;
        this.description = description;
        this.cabins = cabins;

        this.startDate = startDate;
        this.endDate = endDate;
        this.activities = activities;
        //^^^^total activities
    }

/////////SESSION ONLY VARIABLES//////
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


//////////////CABINS STUFF///////////
    public Cabin[] getCabins()
    {
        return this.cabins;
    }
    public void setCabins(Cabin[] cabins)
    {
        this.cabins = cabins;
    }

    public int getCabinSize()
    {
        return this.cabinsSize;
    }
    public void setCabinsSize(int cabinsSize)
    {
        if(cabinsSize > 6 || cabinsSize == 0)
        {
            System.out.println("You inputted either a too big or small amount.");
        }
        else
        {
            this.cabinsSize = cabinsSize;
        }

    }

///////////////////////ACTIVITIES///////////////////////////
    public Activity[] getActivities()
    {
        return this.activities;
    }
    public void setActivities(Activity[] activities)
    {
        this.activities = activities;
    }

    public int getActivitiesSize()
    {
        return this.activitiesSize;
    }
    public void setActivitiesSize(int activitiesSize)
    {
        this.activitiesSize = activitiesSize;
    }




//would add activity to activity arrayList
//, and then assign that to the Schedule object.
    public void addActivity(Activity activity) 
    {
        //would call schedule.addActivity

        // System.out.println("Please enter the activity name in which you would like to add.");
        //     String name = input;
        // System.out.println("Please enter the activity name in which you would like to add.");

        // this.activities.add(activity);
    }

    //removes activity from activity arrayList??????
    public void removeActivity(Activity activity) {

         //would call schedule.removeActivity


        //searches through activities list, removes if activity matches

        // for(int i = 0; i < this.activities.size(); i++) {

        //     if(this.activities.get(i) == activity) {
        //         this.activities.remove(i);
        //     }
        // }
    }






/////////////////////////SCHEDULE////////////////////////////


    public void randomizeSchedule()
    {
        //calls schedule.randomize method.
    }

    /*
     * assigns schedule to each cabin object.
     */
    public void assignSchedule()
    {
        for(int i = 0; i < cabins.length; i++)
        {
            cabins[i].setWeekSchedule(weekSchedule);
        }


        //^^when assigning, should call schedule methods like equals
        // and repeats so that all the cabins can get assigned correctly.


        //would assign this:
        // System.out.println(weekSchedule[0]);

        //should loop thru all cabins
        //check if there are any conflicts between the times. 


        //loops through all cabins
        // for(int j = 0; j < cabins.size(); j++)
        // {
        //     System.out.println("Please fill out the follwing Schedule information for cabin #: " + (j+1));
        //     //for every day, it assigns the cabin that schedule
        //     for(int i = 0; i < weekSchedule.length; i++)
        //     {

        //     }
        // }
        
    }

    /**
     * get the ArrayList<Schedule>
     * @return get the ArrayList<Schedule>
     */
    public ArrayList<Schedule> getSchedules(){
        return this.schedules;
    }
























    /*
     * FRONT END TEST.
     * 
     * 
     */
//    public static void main(String[] args)
//    {
//     Scanner keyboard = new Scanner(System.in);

//     System.out.println();
//     System.out.println("Creating new session.");
//     Session session = null;

//     System.out.println("Please enter the Theme of the session.");
//         session.setTheme(keyboard.nextLine());

//     System.out.println("Please enter the Description of the session.");
//         session.setDescription(keyboard.nextLine());
    
//     System.out.println("Please enter the amount of Cabins you would like to make.");
//     System.out.println("There is a limit to 6 cabins per each session.");
//     session.setCabinsSize(keyboard.nextInt());

//     //needs like if(getCabin is false) or something
//     Cabin[] cabinsss = session.getCabins();  

//     System.out.println("Setting up information for each cabin.");

//     for(int i = 0; i < cabinsss.length; i++)
//     {
//         //sets the cabin number associated with the cabin
//         cabinsss[i].setCabinNumber(i+1);

//         System.out.println("Please enter the Minimum age of Cabin #: " + i+1);
//         cabinsss[i].setAgeMin(keyboard.nextInt());

//         System.out.println("Please enter the Maximum age of Cabin #: " + i+1);
//         cabinsss[i].setAgeMax(keyboard.nextInt());

//         cabinsss[i].setCounselorUUID(null);
//         // cabinsss[i].set
        
//     }
   

  // } 
  
}
