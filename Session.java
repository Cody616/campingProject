import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;


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
    private ArrayList<Cabin> cabins;//these cabins are the ones stored in the camp object system.
    // private Activities sessionActivities; //<<<will need to randomize this and assign the activities to the schedule of the session
    private ArrayList<Activity> activities;

    private String startDate;
    private String endDate;
    
    // private ArrayList<String> activities;
    // private Activities activities;

    

    //array that stores the entire week's schedule in a session
    private Schedule[] weekSchedule = new Schedule[7];
    //^^EACH SESSION LASTS ONE WEEK.

    private Schedule schedule;
    //^^hashmap????? 
   

    //needs activities and an array of strings in order to represent the 7 days????

    //^^reference cabinList class????


    //new session
    public Session(String theme, String description, ArrayList<Cabin> cabins, String startDate, String endDate, ArrayList<String> activities)
    {
        /*
         * prob wont need ArrayList<String> activities maybe possibly
         */
        this.id = UUID.randomUUID();
        this.theme = theme;
        this.description = description;
        this.cabins = cabins;
        // this.startDate = startDate;
        // this.endDate = endDate;

        this.activities = new ArrayList<Activity>();
        //^^^^total activities
    }
    
    //prexisting session
    public Session(UUID id, String theme, String description, ArrayList<Cabin> cabins, String startDate, String endDate, ArrayList<Activity> activities)
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

    public ArrayList<Cabin> getCabins()
    {
        return this.cabins;
    }

    public void setCabins(ArrayList<Cabin> cabins)
    {
        this.cabins = cabins;
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

    public void randomizeSchedule()
    {
        //calls schedule.randomize method.
    }

    /*
     * assigns schedule to each cabin object.
     */
    public void assignSchedule()
    {
        //^^when assigning, should call schedule methods like equals
        // and repeats so that all the cabins can get assigned correctly.

        
        //should loop thru all cabins
        //add 


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

   

    
}
