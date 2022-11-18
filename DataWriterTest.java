/*
 * Cody Tang Testing
 */
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataWRiterTest
{
    private ArrayList<User> users = DataLoader.loadUsers();
    private ArrayList<Camp> cabins = DataLoader.loadCabinss();
    private ArrayList<Camper> campers = DataLoader.loadCampers();

    public void setup()
    {
        users.clear();
        DataWriter.saveUsers();
        cabins.clear();
        DataWriter.saveCabins();
        campers.clear();
        DataWriter.saveCampers();

        //6th box
        void testWritingOneCamper() 
        {
            ArrayList<Contacts> contacts = new ArrayList<Contacts>();
            contacts.add(new Contacts("csce247", "portia", "093", "bob123@gmail.com", "mom"));

            ArrayList<Medication> medications = new ArrayList<Medication>();
            medications.add(new Medication("nyquil", "dayquil",));

            ArrayList<String> allergies = new ArrayList<String>();
            allergies.add(new String("trees"));

            campers.add(new Camper("bob", "tim" "zest@gmail.com", "90900000"));
            assertEquals("bob", campers.get(0).getFirstName());
        }

        void testWritingOneCounselor() 
        {
            ArrayList<Contacts> contacts = new ArrayList<Contacts>();
            contacts.add(new Contacts("camps292", "cody", "9228229384", "bob00223@gmail.com"));

            ArrayList<Medication> medications = new ArrayList<Medication>();
            medications.add(new Medication("tylenol", "ibuprofen",));

            ArrayList<String> allergies = new ArrayList<String>();
            allergies.add(new String("nuts"));

            counselor.add(new Camper("billyb", "nhm", "panda2@gmail.com", "8437210000"));
            assertEquals("bob", counselor.get(0).getFirstName());
        }

        void writeNullCounselor() 
        {
            counselors.add(new Counselor(null, null, null, null, null, null, null, null, null));
            assertEquals(null, counselors.get(0).getFirstName());
        }

        void testWritingCamperNull() 
        {
            campers.add(new Camper(null, null, null, null, null, null, null, null, null));
            assertEquals(null, campers.get(0).getFirstNames());
        }

        //7th box
        void writeOneUser()
        {
            users.add(new User("Elon", "Musk",new LoginInfo("Elon", "Musk"), campers));
            assertEquals("lebron", users.get(0).getUserLogin().getUserName());
        }

        void writeEmptyUser() {
            users.add(new User("", "", null, "", null, null));
            assertEquals("", users.get(0).getLastName());
        }
        
        //8th box
        void writeNullUser() {
            users.add(new User(null, null, null, null, null, null));
            assertEquals(null, users.get(0).getCampers());
        }

    }
    
}