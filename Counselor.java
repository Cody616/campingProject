import java.util.ArrayList;
import java.util.UUID;


public class Counselor extends User{
    private ArrayList<EmergencyContacts> emergencyContacts = new ArrayList<EmergencyContacts>();
    private ArrayList<Cabin> cabins;
    private ArrayList<String> allergies = new ArrayList<String>();
   // private Medical medical;

    public Counselor(UUID id, String firstName, String lastName, String userName, int age, String phoneNumber) {
        super(id, firstName, lastName, userName, age, phoneNumber);
        emergencyContacts = new ArrayList<>();
        cabins = new ArrayList<>();
        allergies = new ArrayList<>();


    }

    public void setEmergencyContacts(ArrayList<EmergencyContacts> emergencyContacts) {
        this.emergencyContacts=emergencyContacts;
    }

    public void setAllergies(ArrayList<String> allergies) {
        this.allergies = allergies;
    }


    
    public void setCabins(ArrayList<Cabin> cabins) {
        this.cabins = cabins;
    }

    
   
    public ArrayList<Cabin> getCabins() {
        return this.cabins;
    }

  
    public ArrayList<String> getAllergies() {
        return this.allergies;
    }

    public ArrayList<EmergencyContacts> getEmergencyContacts() {
        return this.emergencyContacts;
    }


    public String toString() {
        String print = super.toString()+"Cabins: " + this.cabins + "\nAllergies: "+
        this.allergies+ "\nEmergency Contacts: "+ this.emergencyContacts;

        return print;
    }
}