import java.util.ArrayList;

public class EmergencyContacts {
    // private static EmergencyContacts people = null;
	// private static ArrayList<EmergencyContacts> personList = new ArrayList<>();

    private String firstName;
	private String lastName;
	private String phoneNumber;
    private int age;
    private String email;

    /*
     * contains: 
     * 
     * EmergencyContact(String firstName, String lastName, int age, string phoneNumber, String email)
     * 
     * 
     * 
     * need the object to return an array list of emergencyContacts objects.
     * 
     * 
     * copy her one example named people. wanna return an arraylist of emergency contact objects, either of size 1 or 10?? idk
     * 
     */

    public EmergencyContacts(String firstName, String lastName, int age, String phoneNumber, String email)
    {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
	}

}
