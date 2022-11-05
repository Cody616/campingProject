import java.util.ArrayList;
import java.util.UUID;

public class User {
	private UUID id;
	private String userName;
	private String firstName;
	private String lastName;
	private int age;
    public Gender gender;
	private String phoneNumber;
 	
	//loaded preexisting user from json
	public User(UUID id, String firstName, String lastName, String userName, int age, String phoneNumber) {
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}
	
	public UUID getId() {
		return id;
	}
	
	public String getUserName() {
		return userName;
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



   


 
 






    

   

