import java.util.UUID;
import java.util.ArrayList;

public class Camper extends User
{
    private ArrayList<String> emergencyNotes =  new ArrayList<String>();
    private ArrayList<EmergencyContact> emergencyContacts = new ArrayList<EmergencyContact>();
    private int foo = 0;

    public Camper(String firstName, String lastName, String birthDate, String address, UUID id)
    {
        super(firstName, lastName, birthDate, address, id);
        this.authBehavior = new PriorityBehavior(username, password, phone, email);
        
    }

//     public Camper(String firstName, String lastName, String birthDate, String address,ArrayList<String> medNotes, ArrayList<EmergencyContact> ems) {
//         super(firstName, lastName, birthDate, address,UUID.randomUUID());
//         this.authBehavior = new NoPriorityBehavior();
//         this.medicalNotes = medNotes;
//         this.emergencyContacts = ems;
//     }

//     public Camper(String firstName, String lastName, String birthDate, String address, UUID id, boolean isCoordinator,ArrayList<EmergencyContact> emergencyContacts, ArrayList<String> medNotes){
//         super(firstName, lastName, birthDate, address,id);
//         this.isCoordinator = isCoordinator;
//         this.medicalNotes = medNotes;
//         this.emergencyContacts = emergencyContacts;
//         this.authBehavior = new NoPriorityBehavior();
//     }

//     public Camper(String firstName, String lastName, String birthDate, String address, UUID id, boolean isCoordinator,ArrayList<EmergencyContact> emergencyContacts, ArrayList<String> medNotes,AuthBehavior auth){
//         super(firstName, lastName, birthDate, address,id);
//         this.isCoordinator = isCoordinator;
//         this.medicalNotes = medNotes;
//         this.emergencyContacts = emergencyContacts;
//         this.authBehavior = auth;
//     }

//     public Camper(String firstName, String lastName, String birthDate, String address, boolean isCoordinator,ArrayList<EmergencyContact> emergencyContacts, ArrayList<String> medNotes){
//         super(firstName, lastName, birthDate, address,UUID.randomUUID());
//         this.isCoordinator = isCoordinator;
//         this.medicalNotes = medNotes;
//         this.emergencyContacts = emergencyContacts;
//     }

//     public ArrayList<String> getMedicalNotes(){
//         return this.medicalNotes;
//     }

//     public ArrayList<EmergencyContact> getEmergencyContacts(){
//         return this.emergencyContacts;
//     }

//     public void viewEmergencyContacts(){
//         for (User emergencyContact: this.emergencyContacts) {
//             System.out.println(emergencyContact) ;
//         }
//     }

//     public boolean getIsCoordinator(){
//         return this.isCoordinator;
//     }

//     public String toString(){
//         String div = "------------\n";
//         String out = div;
//         out += (isCoordinator) ? "Coordinator\n":"Camper\n";
//         out += super.toString() + " | Age: " + this.getAgeInt() + "\n";
//         if(this.emergencyContacts != null){
//             out += "Emergency Contacts: \n";
//             for (User user : emergencyContacts) {
//                 out += person.toString()+"\n";
//             }
//         }
//         if(this.medicalNotes != null){
//             out += "Medical Notes:\n";
//             for(String note: medicalNotes){
//                 out += note +"\n";
//             }
//         }
//         out += "Auth Information:\n";
//         out += this.authBehavior.toString() +"\n";
//         out += div;
//         return out;
//     }

//     public String getPersonType(){
//         return "Camper";
//     }

// }
