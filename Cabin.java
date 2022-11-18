import java.util.ArrayList;
import java.util.UUID;

public class Cabin {

    private UUID id;
    private int cabinNumber;
    private int ageMin;
    private int ageMax;
    private Counselor counselor;
    private ArrayList<Camper> campers = new ArrayList<Camper>();   
    private String[] weekSchedule = new String[7]; 
   
//DECLARING OBJECT
    //new cabin
    public Cabin(int cabinNumber, int ageMin, int ageMax, Counselor counselor, ArrayList<Camper> campers, String[] weekSchedule)
    {
        id = UUID.randomUUID();
        this.cabinNumber = cabinNumber;
        this.ageMin = ageMin;
        this.ageMax = ageMax;

        this.counselor = counselor;
        this.campers = campers;
        this.weekSchedule = weekSchedule;
    }
    //pre existing cabin
    public Cabin(UUID id, int cabinNumber, int ageMin, int ageMax, Counselor counselor, ArrayList<Camper> campers, String[] weekSchedule)
    {
        id = UUID.randomUUID();
        this.cabinNumber = cabinNumber;
        this.ageMin = ageMin;
        this.ageMax = ageMax;

        this.counselor = counselor;
        this.campers = campers;
        this.weekSchedule = weekSchedule;
    }
    public Cabin(UUID id) {
        this.id = id;
        this.counselor = null;
        this.campers = null;
    }
    public Cabin() {
    }

//GETTERS AND SETTERS
    public UUID getUUID() {
        return id;
    }
    public void setUUID(UUID id) {
        this.id = id;
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

    public Counselor getCounselor() {
        return counselor;
    }
    public void setCounselor(Counselor counselor) {
        this.counselor = counselor;
    }

    public ArrayList<Camper> getCampers() {
        return campers;
    }
    public void setCampers(ArrayList<Camper> campers) {
        this.campers = campers;
    }
    
//Counselor/ camper methods
    public Camper getCamper(UUID id) {
        return CamperList.getInstance().getCamperByUUID(id);
    }

    public ArrayList<Camper> getCamperList() {
        return campers;
    }

    public String viewCamperList() {
        String temp = new String();
        for (Camper c : campers) {
            temp = temp + "\n" + c.toString();
        }
        return temp;
    }

    public int getCamperAmount() {
        return campers.size();
    }

//SCHEDULE STUFF
    public String[] getWeekSchedule() {
        return weekSchedule;
    }
    public void setWeekSchedule(String[] weekSchedule) {
        this.weekSchedule = weekSchedule;
    }

    public String printWeekSchedule() {

        String wholeSchedule = "";
        for(int i = 0; i < weekSchedule.length; i++)
        {
            wholeSchedule += weekSchedule[i];
        }

        return wholeSchedule;
    }
    
//GETS INDIVIDUAL DAYS SCHEDULE
    public static String getMondaySchedule(String[] weekSchedule)
    {
        return weekSchedule[0].toString();
    }
    public static String getTuesdaySchedule(String[] weekSchedule)
    {
        return weekSchedule[1].toString();
    }
    public static String getWednesdaySchedule(String[] weekSchedule)
    {
        return weekSchedule[2].toString();
    }
    public static String getThursdaySchedule(String[] weekSchedule)
    {
        return weekSchedule[3].toString();
    }
    public static String getFridaySchedule(String[] weekSchedule)
    {
        return weekSchedule[4].toString();
    }
    public static String getSaturdaySchedule(String[] weekSchedule)
    {
        return weekSchedule[5].toString();
    }
    public static String getSundaySchedule(String[] weekSchedule)
    {
        return weekSchedule[6].toString();
    }

}
