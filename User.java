import java.util.UUID;

public abstract class User {

	protected UUID id;
    protected String username;
    protected String password;
	protected String firstName;
	protected String lastName;
    protected String birthdate;
	protected int age;
    private Gender gender;
    
    protected String homeAddress;
	protected String phoneNumber;
    protected String email;

    //should user have a string called userType????

   

    
  //private String cabinID;

  //Is a string as for director, if the cabinID is all then the user 
  //will have full access to manipulate the json cabin files.

    //EACH USER SHOULD HAVE A CABIN ID AKA THE USER'S ASSIGNED CABIN NUMBER. 
    //THIS CAN LATER BE USED TO REFER TO THE FRONT END SEPERATE CABINS OBJECT

    
//is missing:
    // private ArrayList<String> allergies = new ArrayList<String>();
    // private Gender gender;
    // private ArrayList<EmergencyContacts> emergencyContacts = new ArrayList<EmergencyContacts>();
    // private ArrayList<Cabin> totalCabins;
    // , ArrayList<Cabin> totalCabins <<-missing
	
	//new account
	public User(String username, String password, 
                String firstName, String lastName, 
                String birthdate, int age, Gender gender, 
                String homeAddress, String phoneNumber, String email) {

		this.id = UUID.randomUUID();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
		this.age = age;
        this.homeAddress = homeAddress;
		this.phoneNumber = phoneNumber;
        this.email = email;

	}
	
	//loaded preexisting user from json
	public User(UUID id, String username, String password, 
                String firstName, String lastName, 
                String birthdate, int age, Gender gender,  
                String homeAddress, String phoneNumber, String email) {

		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
		this.age = age;
        this.homeAddress = homeAddress;
		this.phoneNumber = phoneNumber;
        this.email = email;
	}

    public UUID getUUID() {
        return this.id;
    }
    public void setUUID(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthdate() {
        return this.birthdate;
    }
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getHomeAddress() {
        return this.homeAddress;
    }
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getPhonenumber() {
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
	
}







    //setAllergies is a type of arraylsit string
    //need set allergies, <<arraylist of strings for allergies
    // public void setAllergies(ArrayList<String> allergy)
    // {
    //     //passes a string arraylist of allergies
    //     this.allergies = allergies;
    // }

    // public ArrayList<String> getAllergies()
    // {
    //     // for(int i = 0; i < allergies.size(); i++)
    //     // {
    //     //     System.out.println("Allergy # "  + (i + 1) + ": " + allergies.get(i));
    //     // }

    //     return this.allergies;
    // }

    //needs set gender


    //emergency contacts is its own object
    
    //needs setEmergency contacts
    //should create the arraylist of emergency contacts in here????
    //this feels like the right move

    //^^this is the same thing done for cabins???
    //would also make sense per se but cabins have an arraylist of campers in them along wiht arraylist of schedules
    // public void setEmergencyContacts(EmergencyContacts emergencyContacts)
    // {
        
    // }

    // // returns arraylist of emergency contacts. Or should the emergencyContacts class just do this already??? they kinda do the same thing sooo....
    // public ArrayList<EmergencyContacts> getEmergencyContacts()
    // {
    //     return this.emergencyContacts;
    // }





    //needs setCabin
    //^^how would this work for director??
    //^^userList class
    //^^userList should dictate what the user sees based on the cabin they are assigned to, 
    //unless they are the director which has special roles from the UserList class

    

    /*
     * WHAT THE USER JSON WAS LOOKING LIKE:
     * 
     * [{"firstName":"Tayna","lastName":"Marks","phoneNumber":"803-555-4545", "age": 18, 
"allergies": ["frozen yogurt", "covid"], 
"emergencyContacts": [
    {
        "firstName": "yup",
        "lastName": "forFree",
        "age": 10,
        "phoneNumber": "843-555-5555",
        "email": "yahoo@yahoo.com"
    }
]
}]
     * 
     */
