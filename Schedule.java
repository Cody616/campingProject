
import java.util.ArrayList;
import java.util.Collections;

/**
 * Lists the activies a user will participate in
 */
public class Schedule {
   
    private ArrayList<Activity> activities;
    private Activity[] orderedActivities;
    //^^sources the rest of the things that will fill up the schedule from activities object
    private static String[] schedule;


    public Schedule(ArrayList<Activity> activities){ 

        this.activities = activities;
        this.orderedActivities = new Activity[5];
        this.schedule = new String[8];

        //^^stores the randomly generated 
        this.schedule[0] = "8:00 am - 9:00 am Breakfast. \nLocation: Cafeteria";//0
        this.schedule[1]="9:30 am - 11:30 am ";
        this.schedule[2] = "11:45 am - 1:00 pm Lunch. \nLocation: Cafeteria";//2
        this.schedule[3]="2:00 pm - 3:15 pm ";
        this.schedule[4]="3:30 pm - 4:30 pm ";
        this.schedule[5]="4:45 pm - 5:45 pm ";
        this.schedule[6] = "6:00 pm - 7:45 pm Dinner. \nLocation: Cafeteria";//6
        this.schedule[7]="8:00 pm - 9:00 pm";
        this.schedule[8] = "9:30pm Bed.";//8
        //^^schedule constants
    }

    public void addActivity(Activity activity) 
    {
        // System.out.println("Please enter the activity name in which you would like to add.");
        //     String name = input;
        // System.out.println("Please enter the activity name in which you would like to add.");

        //adds activity to arrayList
        this.activities.add(activity);
    }

    public ArrayList<Activity> getActivities() {
        return this.activities;
    }

    public void removeActivity(Activity activity) {

        //searches through activities list, removes if activity matches
        for(int i = 0; i < this.activities.size(); i++) {
            if(this.activities.get(i) == activity) {
                this.activities.remove(i);
            }
        }
    }

    //NEED .RANDOMIZE. ONCE CREATED IN HERE, CAN BE CALLED IN SESSION CLASS
    public void randomizeSchedule()
    {
        Collections.shuffle(activities); 
        // shuffles main activities arraylist

        // for(int i = 0; i < activities.size(); i++)
        // {
        //     orderedActivities[i] = activities.get(i);
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
        for(int i = 0; i < this.activities.size(); i++)
        {
            if(this.activities.get(i).getActivityName().equals(activityHolder.get(i).getActivityName()))
            {
                return true;
            }

        }

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
        for(int i = 1; i < schedule.length;i++)
        {
            if(schedule[i].contains("Breakfast") 
            || schedule[i].contains("Lunch") 
            || schedule[i].contains("Dinner") )
            {
                continue;
            }
            // schedule[i] += orderedActivities[i].toString();

            //appends activities to the end of the schedule string array
            schedule[i] += activities.get(i).toString();

            // font = schedule[i];
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
}
