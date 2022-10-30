import java.util.ArrayList;

public class Director extends User{

public Director(String firstName, String lastName, String phoneNumber
, int age, ArrayList<String> allergies, Gender gender
, ArrayList<EmergencyContacts> emergencyContacts
 , ArrayList<Cabin> totalCabins)
{
     super(firstName, lastName, phoneNumber, age, allergies, gender, emergencyContacts, totalCabins);
}




/*
 * director should have access to all cabins
 * 
 * cabin should be the reference point for every user
 * , except for the director, which has access to all cabins
 */



    // private addCounselor()
    // {
    //     return"";
    // }
    // private removeCounselor()
    // {
    //     return "";
    // }
    // private addCamper()
    // {
    //        return "";
    // }
    // private removeCamper()
    // {
    //     return "";
    // }
    //^^all of these would mess with the total cabin arraylist
    //should the cabin object have these methods within it?? private methods??

}


