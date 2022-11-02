import java.util.Random;

public class Activity {

    private String activityName;
    private String location;


    // private String startTime;
    // private String endTime;
    // private static final Random RANDOM = new Random();


    public Activity(String activityName, String location) {

        this.activityName = activityName;
        this.location = location;
        // this.startTime = startTime;
        // this.endTime = endTime;

    }

    public Activity(){}

    public String getActivityName()
    {
        return this.activityName;
    }

    public void setActivityName(String activityName)
    {
        this.activityName = activityName;
    }

    public String getLocation()
    {
        return this.location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }
    
    public String toString() {
        return this.activityName  + " \nLocation: " + location + "\n";
    }
}

