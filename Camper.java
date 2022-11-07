import java.util.ArrayList;
import java.util.UUID;

public class Camper extends User{
    
    private ArrayList<String> allergies = new ArrayList<String>();
    private ArrayList<Medication> medications = new ArrayList<Medication>();
    private ArrayList<EmergencyContact> emergencyContacts = new ArrayList<EmergencyContact>();
    private EmergencyContact pediatrician;

    public Camper(UUID id, String username, String password, 
                String firstName, String lastName, String birthdate,
                int age, Gender gender, String homeAddress, String phoneNumber, String email,
                ArrayList<String> allergies, ArrayList<Medication> medications, 
                ArrayList<EmergencyContact> emergencyContacts, EmergencyContact pediatrician) 
    {

       super(id, username, password, firstName, lastName, birthdate, age, gender, homeAddress, phoneNumber, email);
     
       this.allergies = allergies;
       this.medications = medications;
       this.emergencyContacts = emergencyContacts;
       this.pediatrician = pediatrician;

    }

    public Camper(String username, String password, 
                String firstName, String lastName, String birthdate,
                int age, Gender gender, String homeAddress, String phoneNumber, String email,
                ArrayList<String> allergies, ArrayList<Medication> medications, 
                ArrayList<EmergencyContact> emergencyContacts, EmergencyContact pediatrician) 
    {

       super(username, password, firstName, lastName, birthdate, age, gender, homeAddress, phoneNumber, email);

       this.allergies = allergies;
       this.medications = medications;
       this.emergencyContacts = emergencyContacts;
       this.pediatrician = pediatrician;

    }

////GETTERS AND SETTERS
    public UUID getUUID() {
        return id;
    }
    
    public ArrayList<Medication> getMedications() {
        return medications;
    }
    public void setMedications(ArrayList<Medication> medications) {
        this.medications = medications;
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

///HELPER METHODS
    private String printAllMedications() {
        String temp = new String();
        for (Medication m : medications) {
            temp = temp + m.toString() + "\n";
        }
        return temp;
    }
    private String printEmergencyContacts() {
        String temp = new String();
        for (EmergencyContact c : emergencyContacts) {
            temp = temp + c.toString() + "\n";
        }
        return temp;
    }
    private String printAllergies() {
        String temp = new String();
        for (String a : allergies) {
            temp = temp + a.toString() + "\n";
        }
        return temp;
    }

    //should be session number??
    // public boolean selectSession(Camp camp, Integer weekNumber) 
    // {
    //     //should access the session through the camp object and then gets the week by the inputted index aka weekNumber
    //     if(getSession(camp,weekNumber).isFull())
    //     {
    //         return false;
    //     }
    //     getSession(camp,weekNumber).getCampers().add(this);
    //     return true;
    // }

    // private Session getSession(Camp camp, Integer weekNumber) {
    //     Session session = new Session();

    //     for (HashMap.Entry<Integer, Week> entry : camp.getMasterSchedule().entrySet()) {
    //         Integer weekInt = entry.getKey();
    //         Session thisWeek = entry.getValue();
    //         if (weekNumber - 1 == weekInt) {
    //             session = thisWeek;
    //         }
    //     }
    //     return session;
    // }

    public String toString() {
        return firstName + " " + lastName;
    }
    // when director or user wants to see camper information
    public String toStringFull() {

        String temp = "";

        temp = "\nCamper: " + toString() 
            + "\nDate of Birth: " + birthdate
            + "\nAddress: " + homeAddress 
            + "\nGender: " + super.getGender() 
            + "\nMedications: \n" + printAllMedications()
            + "\nAllergies: \n" + printAllergies() 
            + "\nEmergency Contacts: \n" + printEmergencyContacts() 
            + "\nPediatrician: \n" + pediatrician.toString() + "\n";
        return temp;
    }

}
