import java.util.ArrayList;
import java.util.UUID;

public class Counselor extends User{

    private ArrayList<String> allergies = new ArrayList<String>();
    private ArrayList<EmergencyContact> emergencyContacts = new ArrayList<EmergencyContact>();
    private EmergencyContact pediatrician;

    //pre existing counselor
    public Counselor(UUID id, String username, String password, 
                String firstName, String lastName, String birthdate,
                int age, Gender gender, String homeAddress, String phoneNumber, String email,
                ArrayList<String> allergies, ArrayList<EmergencyContact> emergencyContacts, EmergencyContact pediatrician) 
    {

       super(id, username, password, firstName, lastName, birthdate, age, gender, homeAddress, phoneNumber, email);
     
       this.allergies = allergies;
       this.emergencyContacts = emergencyContacts;
       this.pediatrician = pediatrician;

    }

    //new Counselor
    public Counselor(String username, String password, 
                String firstName, String lastName, String birthdate,
                int age, Gender gender, String homeAddress, String phoneNumber, String email,
                ArrayList<String> allergies, ArrayList<EmergencyContact> emergencyContacts, EmergencyContact pediatrician) 
    {

       super(username, password, firstName, lastName, birthdate, age, gender, homeAddress, phoneNumber, email);
     
       this.allergies = allergies;
       this.emergencyContacts = emergencyContacts;
       this.pediatrician = pediatrician;

    }

    // public Counselor() {

    // }
    //^^need to make singleton of counselor

    ////GETTERS AND SETTERS
    public UUID getUUID() {
        return id;
    }
    
    public ArrayList<String> getAllergies() {
        return allergies;
    }
    public void setAllergies(ArrayList<String> allergies) {
        this.allergies = allergies;
    }

    public ArrayList<EmergencyContact> getEmergencyContacts() {
        return emergencyContacts;
    }
    public void setEmergencyContacts(ArrayList<EmergencyContact> emergencyContacts) {
        this.emergencyContacts = emergencyContacts;
    }

    public EmergencyContact getPediatrician() {
        return pediatrician;
    }
    public void setPediatrician(EmergencyContact pediatrician) {
    this.pediatrician = pediatrician;
}

    //COUNSELOR METHODS
    public String viewCampers(Cabin cabin) 
    {
        String temp = new String();
        for (int i = 0; i < cabin.getCamperList().size(); i++) {
            temp = temp + "\n" + cabin.getCamperList().get(i).getFirstName() + " "
                    + cabin.getCamperList().get(i).getLastName();
        }
        return temp;
    }

    public String viewWeekSchedule(Camp camp, int weekNumber) {

        for (Cabin c : camp.getCampSessions().get(weekNumber).getCabins()) 
        {
            if (c.getCounselor().getFirstName().equals(firstName) 
            && c.getCounselor().getLastName().equals(lastName)) {
                return c.printWeekSchedule();
            }
        }
        return "You are not apart of a group";
    }

    public String toString() {
        String temp = new String();
        temp = "\nCounselor:  " + firstName + " " + lastName 
                + "\nUsername: " + username
                + "\nDate of Birth: " + birthdate
                + "\nAddress: " + homeAddress + "\nEmail: " + email
                + "\nPhone Number: " + phoneNumber + "\nEmergency Contacts: \n" + printEmergencyContacts()
                + "\nPediatrician: \n" + pediatrician + "\n";
        return temp;

        //^^originally had Date of Birth: + formatDate(birthdate)
    }

    //EXTRA METHODS
    private String printEmergencyContacts() {
        String temp = new String();
        for (EmergencyContact c : emergencyContacts) {
            temp = temp + c.toString() + "\n";
        }
        return temp;
    }

    public void selectSession(Camp camp, int sessionNumber) 
    {
        //fetches the session based off the inputted camp and sessionNumber
        //gets the sessions counselors and then adds the current counselor into the counselor arrayList
        getSession(camp, sessionNumber).getCounselors().add(this);
    }

    private Session getSession(Camp camp, int sessionNumber) 
    {
        Session session = camp.getCampSession(sessionNumber);
        return session;
    }
   
}
