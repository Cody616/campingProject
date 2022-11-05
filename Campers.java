import java.util.ArrayList;
import java.util.UUID;

public class Campers extends User{
    public Gender gender;
    private ArrayList<EmergencyContacts> emergencyContacts = new ArrayList<EmergencyContacts>();
    public ArrayList<Cabin> cabin = new ArrayList<Cabin>();
    private ArrayList<String> allergies = new ArrayList<String>();


    public Campers(UUID id, String firstName, String lastName, String userName, int age, String phoneNumber) {
        super(id, firstName, lastName, userName, age, phoneNumber);
        
    }

    public void setEmergencyContacts(ArrayList<EmergencyContacts> emergencyContacts) {
        this.emergencyContacts=emergencyContacts;
    }

    public void setCabin(ArrayList<Cabin> cabin) {
        this.cabin = cabin;
    }

    public ArrayList<Cabin> setCabin() {
        return this.cabin;
    }

    public ArrayList<EmergencyContacts> getEmergencyContacts() {
        return this.emergencyContacts;
    }

    public void setAllergies(ArrayList<String> allergies) {
        this.allergies = allergies;
    }

    public ArrayList<String> getAllergies() {
        return this.allergies;
    }
  
    public void viewScedule(){

    }

    public void contactCounselor(){
        
    }

    public String toString() {
        String print = super.toString() + "\nCabin: " + this.cabin + "Allergies: " + this.allergies + 
        "\nEmergency Contacts: " + this.emergencyContacts;
        return print;
    }
    
}
