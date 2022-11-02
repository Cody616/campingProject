import java.util.ArrayList;

public class Cabin {
    
    private static int cabinNumber;
    //^^when assigning array of cabins, that is when this gets assigned.
    private static int ageMin;
    private static int ageMax;

    private static String counselorUUID;
    // private static String [] camperUUIDs;
    private static ArrayList<String> camperUUIDs = new ArrayList<String>();
    private static Schedule[] weekSchedule = new Schedule[7];


    //^^should be stored in sessions class???? bc the same camp can have multiple schedules??
    //^no. each session would have a cabin associated with it???

    public Cabin(int cabinNumber, int ageMin, int ageMax, String counselorUUID, ArrayList<String> camperUUIDs)
    {
        this.cabinNumber = cabinNumber;
        this.ageMin = ageMin;
        this.ageMax = ageMax;
        this.counselorUUID = counselorUUID;
        this.camperUUIDs = camperUUIDs;
    }

    public static int getCabinNumber() {
        return cabinNumber;
    }

    public static void setCabinNumber(int cabinNumber) {
        Cabin.cabinNumber = cabinNumber;
    }

    public static int getAgeMin() {
        return ageMin;
    }

    public static void setAgeMin(int ageMin) {
        Cabin.ageMin = ageMin;
    }

    public static int getAgeMax() {
        return ageMax;
    }

    public static void setAgeMax(int ageMax) {
        Cabin.ageMax = ageMax;
    }

    public static String getCounselorUUID() {
        return counselorUUID;
    }

    public static void setCounselorUUID(String counselorUUID) {
        Cabin.counselorUUID = counselorUUID;
    }

    /**
     * @param index
     * @return
     */
    public static String getCamperUUID(int index)
    {
        return this.camperUUIDs.get(index);
    }



//SCHEDULE STUFF    
    public static Schedule[] getWeekSchedule() {
        return Session.weekSchedule;
    }

    public static void setWeekSchedule(Schedule[] weekSchedule) {
        Cabin.weekSchedule = weekSchedule;
    }

    public static String getMondaySchedule(Schedule[] weekSchedule)
    {
        return weekSchedule[0].toString();
    }

    public static String getTuesdaySchedule(Schedule[] weekSchedule)
    {
        return weekSchedule[1].toString();
    }
    
    public static String getWednesdaySchedule(Schedule[] weekSchedule)
    {
        return weekSchedule[2].toString();
    }

    public static String getThursdaySchedule(Schedule[] weekSchedule)
    {
        return weekSchedule[3].toString();
    }

    public static String getFridaySchedule(Schedule[] weekSchedule)
    {
        return weekSchedule[4].toString();
    }

    public static String getSaturdaySchedule(Schedule[] weekSchedule)
    {
        return weekSchedule[5].toString();
    }

    public static String getSundaySchedule(Schedule[] weekSchedule)
    {
        return weekSchedule[6].toString();
    }
    
   
}
