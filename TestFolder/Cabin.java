import java.util.ArrayList;

public class Cabin {

    private int cabinNumber;
    //^^when assigning array of cabins, that is when this gets assigned.
    private int ageMin;
    private int ageMax;

    private String counselorUUID;
    private ArrayList<String> camperUUIDs;
    private Schedule[] weekSchedule = new Schedule[7];

    //^^should be stored in sessions class???? bc the same camp can have multiple schedules??
    //^no. each session would have a cabin associated with it???

    public Cabin(int cabinNumber, int ageMin, int ageMax, String counselorUUID, String[] camperUUIDs)
    {
        this.cabinNumber = cabinNumber;
        this.ageMin = ageMin;
        this.ageMax = ageMax;
        this.counselorUUID = counselorUUID;
        this.camperUUIDs = camperUUIDs;
    }

    public int getCabinNumber() {
        return cabinNumber;
    }
    public void setCabinNumber(int cabinNumber) {
        this.cabinNumber = cabinNumber;
    }

    public int getAgeMin() {
        return ageMin;
    }
    public void setAgeMin(int ageMin) {
        this.ageMin = ageMin;
    }

    public int getAgeMax() {
        return ageMax;
    }
    public void setAgeMax(int ageMax) {
        this.ageMax = ageMax;
    }

    public String getCounselorUUID() {
        return counselorUUID;
    }
    public void setCounselorUUID(String counselorUUID) {
        this.counselorUUID = counselorUUID;
    }

    public ArrayList<String> getCamperUUIDs() {
        return camperUUIDs;
    }
    public void setCamperUUIDs(ArrayList<String> camperUUIDs) {
        this.camperUUIDs = camperUUIDs;
    }

    public int getCamperAmount() {
        return camperUUIDs.size();
    }



//SCHEDULE STUFF
    public Schedule[] getWeekSchedule() {
        return weekSchedule;
    }
    public void setWeekSchedule(Schedule[] weekSchedule) {
        this.weekSchedule = weekSchedule;
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
