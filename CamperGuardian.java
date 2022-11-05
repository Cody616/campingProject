import java.util.ArrayList;
import java.util.UUID;

public class CamperGuardian extends User{

    private ArrayList<String> campers = new ArrayList<String>();

    public CamperGuardian(UUID id, String firstName, String lastName, String userName, int age, String phoneNumber) {
        super(id, firstName, lastName, userName, age, phoneNumber);
        campers = new ArrayList<>();
    
    }

    public void setCampers(ArrayList<String> campers) {
        this.campers=campers;
    }

    public ArrayList<String> getCampers() {
        return this.campers;
    }

    public String toString() {
        String print = super.toString() + "\nCampers: " +
        this.campers;
        return print;
    }





}