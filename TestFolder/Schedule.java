
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


/**
 * Lists the activies a user will participate in
 */
public class Schedule {
    
    //point of reference where the activities are added to the 
    //string activity location

    //hashmap of time and activities.
    // private HashMap<String,Activity> activities = new HashMap<>();


    // private ArrayList<String> timeList = new ArrayList<String>();
    private final int TIME_SLOTS = 8;
    private String[] timeList = new String[TIME_SLOTS];

    //now need to assign activities from enum to arrayList
    private ArrayList<Activity> activities = new ArrayList<Activity>();
    private ArrayList<String> activityLocations = new ArrayList<String>();
    private int cabinNumber;
    private int totalActivityAmount;

    //^^sources the rest of the things that will fill up the schedule from activities object
    private static String[] schedule;

    public Schedule(String[] timeList, ArrayList<Activity> activities,  
                    ArrayList<String> activityLocations, int cabinNumber, int totalActivityAmount)
    { 
        this.timeList = timeList;
        this.activities = activities;
        this.activityLocations = activityLocations;
        this.cabinNumber = cabinNumber;
        this.totalActivityAmount = totalActivityAmount;
        //assigns total time slots to schedule
        schedule = new String[totalActivityAmount];






        // this.schedule = new String[8];
        // //^^stores the randomly generated 
        // this.schedule[0] = "8:00 am - 9:00 am Breakfast. \nLocation: Cafeteria";//0
        // this.schedule[1]="9:30 am - 11:30 am ";
        // this.schedule[2] = "11:45 am - 1:00 pm Lunch. \nLocation: Cafeteria";//2
        // this.schedule[3]="2:00 pm - 3:15 pm ";
        // this.schedule[4]="3:30 pm - 4:30 pm ";
        // this.schedule[5]="4:45 pm - 5:45 pm ";
        // this.schedule[6] = "6:00 pm - 7:45 pm Dinner. \nLocation: Cafeteria";//6
        // this.schedule[7]="8:00 pm - 9:00 pm";
        // this.schedule[8] = "9:30pm Bed.";//8
        // //^^schedule constants

    }

    public String[] getTimeList() {
        return timeList;
    }
    public void setTimeList(String[] timeList) {
        this.timeList = timeList;
    }

    public String getTime(int index)
    {
        return this.timeList.get(index);
    }

    public ArrayList<Activity> getActivities()
    {
        return this.activities;
    }

    public void setActivities(ArrayList<Activity> activities)
    {
        for(int i = 0; i < activities.size(); i++)
        {
            //if doesn't have the correct activities
            if(hasActivity(activities.get(i)) == false) 
            {
                break;
            }
            //if on last activity and made it through the check if statement above
            if(i == activities.size() - 1)
            {
                this.activities = activities;
            }
        }
    }
    
    public boolean hasActivity(Activity activity)
    {
        if(activity == Activity.ARCHERY 
        || (activity == Activity.ARTSANDCRAFT) 
        || (activity == Activity.FRISBEEING)
        || (activity == Activity.HORSEBACKRIDING)
        || (activity == Activity.RUNNING)
        || (activity == Activity.SPORTS)
        || (activity == Activity.SWIMMING)
        
        || (activity == Activity.BREAKFAST) 
        || (activity == Activity.LUNCH)
        || (activity == Activity.DINNER))
        {
            return true;
        }
        else{
            return false;
        }

    }
    public Activity getActivity(int index)
    {
        return this.activities.get(index);
    }

    public ArrayList<String> getActivityLocations() {
        return activityLocations;
    }
    public void setActivityLocations(ArrayList<String> activityLocations) {
        this.activityLocations = activityLocations;
    }
    public String getActivityLocation(int index)
    {
        return this.activityLocations.get(index);
    }

    //this is used to keep track of which cabin the schedule is assigned to.
    public int getCabinNumber() {
        return cabinNumber;
    }
    public void setCabinNumber(int cabinNumber) {
        this.cabinNumber = cabinNumber;
    }

    public int getTotalActivityAmount() {
        return totalActivityAmount;
    }
    public void setTotalActivityAmount(int totalActivityAmount) {
        this.totalActivityAmount = totalActivityAmount;
    }
   






    //NEED .RANDOMIZE. ONCE CREATED IN HERE, CAN BE CALLED IN SESSION CLASS
    public void randomizeSchedule()
    {
        // Collections.shuffle(activities); 


        // shuffles main activities arraylist

        for(int i = 0; i < activities.size(); i++)
        {
          if(activities.contains("BREAKFAST") || activities.contains("LUNCH") 
            ||activities.contains("DINNER") )
            {
                continue;
            }

        }
        
        //calls schedule.randomize method. << we're in schedule dumm
        //should loop through arraylist of activities.
    }

    //^^needs way to check if schedule repeats in different cabins
    public boolean equals(Schedule schedule)   
    {  
        if (schedule == null)   
            return false;  
        
        ArrayList<Activity> activityHolder = schedule.getActivities();
        //loops through activities, if the index of one list equals the same activity in the other, return true

        //loops thru activity arraylist and inputted activity arrayList and 
        // for(int i = 0; i < this.activities.size(); i++)
        // {
        //     if(this.activities.get(i).getActivityName().equals(activityHolder.get(i).getActivityName()))
        //     {
        //         return true;
        //     }

        // }

       return false;
    }  

    //checks if schedule has been assigned to the same schedule twice
    public boolean repeats(Schedule schedule)
    {
        if (schedule == null)   
            return false;  

        ArrayList<Activity> activityHolder = schedule.getActivities();

        for(int i = 0; i < this.activities.size(); i++)
        {
            if(activityHolder.get(i).equals(this.activities.get(i)))
            {
                return true;
            }
            //^^should be comparing the array of length 5

            // String previousValue = this.activities.get(i).getActivityName();

            // if(this.activities.get(i).getActivityName().equals(activityHolder.get(i).getActivityName()))
            // {
            //     return true;
            // }

        }
        
        return false;
    }

    //goes through activities and makes sure that cabin is not going to have the same activity during the same day
    public void assignSchedule()
    {
        //goes through total timeSlots, and assigns total schedule to a string???
       for(int i = 0; i < timeList.length; i++)
       {
        //should go through activities arraylist, and assign it to 
            if(activities.contains("BREAKFAST") || activities.contains("LUNCH") 
            ||activities.contains("DINNER") )
            {
                continue;
            }
       }

    }

    //needs to just loop through array and print it's values
    public String toString(){

        String font = "";
        // String schedule = "Schedule: ";

        //created it in a way to where only 5 spots are available each day
        //means 5 diff activities per day 

        // for(int i = 1; i < schedule.length;i++)
        // {

        //     // if(i == 5)//reaches last activity before dinner
        //     // {
        //     //     schedule[i] += activities.get(i).toString();
        //     //     // font = schedule[i] + "\n";

        //     //     font = schedule[i];
        //     //     System.out.println("i++");
        //     //     i++;
        //     //     continue;
        //     //     //^^hopefully jumps it to 7
        //     // }
        //     // schedule[i] += activities.get(i).toString();
        //     // font = schedule[i];

        //     if(schedule[i].contains("Breakfast") 
        //     || schedule[i].contains("Lunch") 
        //     || schedule[i].contains("Dinner") )
        //     {
        //         continue;
        //     }
        //     else if(activities.get(i) != null)
        //     {
        //         schedule[i] += activities.get(i).toString();
        //         font = schedule[i];
        //     }
        // }

        return font;
    }
    


    public static void main(String[] args) {

		System.out.println("Creating schedule.");
        // Schedule schedule = new Schedule(timeList, activities, activityLocations, cabinNumber, totalActivityAmount);

        Schedule schedule = null;

        // System.out.println("Setting up a schedule object.");

	}
}
