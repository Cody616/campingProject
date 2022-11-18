import java.util.ArrayList;
import java.util.UUID;

public class Director extends User{

    private ArrayList<Camp> camps = new ArrayList<Camp>();

    //loads new director
    public Director(String username, String password, String firstName, String lastName, 
    String birthdate, int age, Gender gender, String homeAddress, String phoneNumber, String email, ArrayList<Camp> camps) 
    {
        super(username, password, firstName, lastName, birthdate, age, gender, homeAddress, phoneNumber, email);
        this.camps = camps;
    }

    //loads preexisting Director
    public Director(UUID id, String username, String password, String firstName, String lastName, 
                    String birthdate, int age, Gender gender, String homeAddress, String phoneNumber, String email, ArrayList<Camp> camps) 
    {
        super(id, username, password, firstName, lastName, birthdate, age, gender, homeAddress, phoneNumber, email);
        this.camps = camps;
    }
    
    //GETTERS AND SETTERS
    public ArrayList<Camp> getCamps() {
        return camps;
    }
    public void setCamps(ArrayList<Camp> camps) {
        this.camps = camps;
    }

    //SPECIAL METHODS
    public void addCamp(Camp camp) {
        this.camps.add(camp);
    }

    public String toString() {
        
        String temp = "";

        temp = "\nDirector: " + firstName + " " + lastName + 
            "\nUsername: "+ username + 
            "\nDate of Birth: " + birthdate + 
            "\nAddress: " + homeAddress + "\n";

        return temp;
    }

    //SCHEDULE METHODS
    public String getCabinSchedule(int campNumber, Integer weekNumber, int groupNumber) {
        return camps.get(campNumber).getCampSessions().get(weekNumber).getCabins().get(groupNumber).printWeekSchedule();
     }
  
    public String getWeekSchedule(int campNumber, Integer weekNumber) {
        return camps.get(campNumber).getCampSessions().get(weekNumber).viewAllCabinSchedules();
     }

}
