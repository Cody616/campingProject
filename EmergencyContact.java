public class EmergencyContact {
    
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String relationToUser;

    public EmergencyContact(String firstName, String lastName, String phoneNumber, String email, String relationToUser)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.relationToUser = relationToUser;
    }

    public EmergencyContact()
    {

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

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getRelationToUser() {
        return relationToUser;
    }
    public void setRelationToUser(String relationToUser) {
        this.relationToUser = relationToUser;
    }

    public String toString()
    {
        return "Name: " + firstName + " " + lastName 
        + "\nPhone Number: " + phoneNumber 
        + "\nEmail: " + email 
        + "\nRelation: " + relationToUser;
    }
}
