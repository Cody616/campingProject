import java.util.UUID;

public class User {
	private UUID id;
	private String userName;
    private String password;
	private String firstName;
	private String lastName;
	private int age;
	private String phoneNumber;
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
	public User(String userName, String password, String firstName, String lastName, int age, String phoneNumber) {
		this.id = UUID.randomUUID();
		this.userName = userName;
        this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.phoneNumber = phoneNumber;

        //is missing:
         // this.allergies = allergies;
        // this.emergencyContacts = emergencyContacts;
        // this.totalCabins = totalCabins;
	}
	
	//loaded preexisting user from json
	public User(UUID id, String userName, String password, String firstName, String lastName, int age, String phoneNumber) {
		this.id = id;
		this.userName = userName;
        this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}
	
	public UUID getId() {
		return id;
	}
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
	
	public String getUserName() {
		return userName;
	}

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	

	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

    public void setAge(int age)
    {
        this.age = age;
    }
	
	public int getAge() {
		return age;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
