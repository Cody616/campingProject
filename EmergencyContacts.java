import java.util.ArrayList;

public class EmergencyContacts {
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String email;
    
    
        public EmergencyContacts(String firstName, String lastName, int age, String phoneNumber, String email)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.email = email;
        } 

        public void setFName(String firstName) {
            this.firstName=firstName;
        }

        public void setLName(String lastName) {
            this.lastName=lastName;
        }

        public void setPhoneNum(String phoneNumber){
            this.phoneNumber = phoneNumber;

        }

        public void setEmail(String email) {
            this.email=email;
        }
        
        public String getFname() {
            return this.firstName;
        }

        public String getLName() {
            return this.lastName;
        }

        public String getPhonenum(){
            return this.phoneNumber;
        }

        public String getEmail() {
            return this.email;
        }

        public String toString() {
            String print = "First Name: " + this.firstName +
            "\nLast Name: " + this.lastName+ "\nPhone Number: " +
            this.phoneNumber + "\nEmail: " + this.email;

            return print;
        }

}

