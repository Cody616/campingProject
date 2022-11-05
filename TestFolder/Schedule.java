
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 * Lists the activies a user will participate in
 */
public class Schedule {

    //point of reference where the activities are added to the 
    //string activity location

    //hashmap of time and activities.
    // private HashMap<String,Activity> activities = new HashMap<>();

    // private ArrayList<String> timeList = new ArrayList<String>();
    private final int SCHEDULE_LENGTH = 8;
    // private String[] timeList = new String[7];

    //now need to assign activities from enum to arrayList
    private ArrayList<Activity> activities = new ArrayList<Activity>();
    private ArrayList<String> activityLocations = new ArrayList<String>();
    
    private int[] openTimeSlotsIndexes = new int[4];
    private String[] schedule = new String[SCHEDULE_LENGTH];

    private int cabinNumber;
    // private int totalActivityAmount;

    //^^sources the rest of the things that will fill up the schedule from activities object

    public Schedule(ArrayList<Activity> activities,  
                    ArrayList<String> activityLocations, 
                    int cabinNumber)
    { 
        // this.timeList = timeList;
        this.activities = activities;
        this.activityLocations = activityLocations;
        this.cabinNumber = cabinNumber;
        // this.totalActivityAmount = totalActivityAmount;


        //assigns total time slots to schedule

        // this.schedule = new String[8];
        // //^^stores the randomly generated 
        this.schedule[0] = "8:00 am - 9:00 am, Breakfast. \nLocation: Cafeteria";//0
        this.schedule[1] = "10:00 am - 11:00 am, ";
        this.schedule[2] = "12:00 am - 1:00 pm, Lunch. \nLocation: Cafeteria";//2
        this.schedule[3] = "2:00 pm - 3:00 pm, ";
        this.schedule[4] = "4:00 pm - 5:00 pm, ";
        this.schedule[5] = "6:00 pm - 7:00 pm, Dinner. \nLocation: Cafeteria";//6
        this.schedule[6] = "8:00 pm - 9:00 pm, ";
        this.schedule[7] = "10:00 pm Bed.";//8
        //1,3,4,6
        //^^schedule constants
    }


    public int getOpenTimeSlotsIndexes(int index) {
        return openTimeSlotsIndexes[index];
    }
    public void setOpenTimeSlotIndexes() {
        //all starting times for the open timeslots
        //1,3,4,6
       openTimeSlotsIndexes[0] = 1;
       openTimeSlotsIndexes[1] = 3;
       openTimeSlotsIndexes[2] = 4;
       openTimeSlotsIndexes[3] = 6;
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
        || (activity == Activity.SWIMMING))
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

    public void setActivityLocation(int index, String location)
    {
        this.activityLocations.add(index, location);
    }

    //this is used to keep track of which cabin the schedule is assigned to.
    public int getCabinNumber() {
        return cabinNumber;
    }
    public void setCabinNumber(int cabinNumber) {
        this.cabinNumber = cabinNumber;
    }
   
    //NEED .RANDOMIZE. ONCE CREATED IN HERE, CAN BE CALLED IN SESSION CLASS
    public void randomizeSchedule()
    {
        Collections.shuffle(activities); 

        // shuffles main activities arraylist

        // for(int i = 0; i < activities.size(); i++)
        // {

        //   if(activities.contains("BREAKFAST") || activities.contains("LUNCH") 
        //     ||activities.contains("DINNER") )
        //     {
        //         continue;
        //     }

        // }
        
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

    //checks if activity has been assigned to the same spot twice
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
         //only loops through openTimeSlotsIndexes array 
         //1,3,4,6
         for(int i = 0; i < openTimeSlotsIndexes.length; i++)
         {
            //  activities[i]
            //assigns the activities only to the open timeslots
            schedule[openTimeSlotsIndexes[i]] += activities.get(i) 
            + "\nLocation: " + activityLocations.get(i);

            // schedule[openTimeSlotsIndexes[i]] += " ";
            // openTimeSlotsIndexes[i]

         }
    }

    //needs to just loop through array and print it's values
    public String toString()
    {
        String font = "\tCamp #: " + getCabinNumber() + "'s Schedule";

        for(int i = 0; i < schedule.length; i++)
        {
            font += schedule[i] + "\n";
        }
        return font; 
    }
    

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

		System.out.println("Creating schedule.");
        // Schedule schedule = new Schedule(timeList, activities, activityLocations, cabinNumber, totalActivityAmount);
      
        Schedule schedule;

        System.out.println("Please enter the cabin number associated with this schedule.");
        int cabinNum = keyboard.nextInt();

        System.out.println("There are a total of 4 different activities assigned to each camp each day.");
            for(int i = 0; i < 4; i++)
            {
                System.out.println("Please enter the Location for activity #: " + (i+1));
                schedule.setActivityLocation(i, keyboard.nextLine());
            }

        schedule.assignSchedule();

        System.out.println("Printing schedule:");
        System.out.println(schedule.toString());
        



        // activities;
        // activityLocations;

        // Schedule scheduleTwo = null;

        // ^^if the first schedule has repeating info that the second schedule has, then???
	}
}
