/*
 * Cody Tang Testing
 */
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Testing Camp Fascade

public class CampFacadeTest
{
    CampFacade facade;

    public void setup()
    {
        this.facade = new CampFacade();
    }

    void validCounselorLogin()
    {
        String user = new userName("cody", "tang");
        if(currentUser.equals(User))
        {
            assertEquals(userName.login);//supposed to be able to run even tho we didnt implement this option ?
        }
    }
    void validUserLogin()
    {
        String user = new userName("bob", "jones");
        if(currentUser.equals(User))
        {
            assertEquals(userName.login);//supposed to be able to run even tho we didnt implement this option ?
        }
    }
    void validDirectorLogin()
    {
        String user = new userName("peanut", "butter");
        if(currentUser.equals(User))
        {
            assertEquals(userName.login);//supposed to be able to run even tho we didnt implement this option ?
        }
    }
    void invalidLogin()
    {
        String user = new userName("blue", "bottle");
        if(!currentUser.equals(User))
        {
            assertEquals(userName.login);
        }
    }
    void vaildUserCreateAccount()
    {
        String userName = "jolly123";
        String firstName = "jolly";
        String lastName = "rancher";
        int age = 21;
        String phoneNumber = "832";

        ArrayList<User> users = new ArrayList<>();
        facade.addUser("Jill123", "Jilly", "Rancher", "21", "832");
        assertEquals(facade.Login(users()));
    }
    void validDirectorCreateAccount()
    {
        String userName = "jolly123";
        String firstName = "jolly";
        String lastName = "rancher";
        int age = 11;
        String phoneNumber = "02";

        ArrayList<User> users = new ArrayList<>();
        facade.addUser("Jjolly123", "Joll", "Rancher", "11", "02");
        assertEquals(facade.Login(users()));
    }

    void validCounselorCreateAccount()
    {
        String userName = "jolly123";
        String firstName = "jolly";
        String lastName = "rancher";
        int age = 01;
        String phoneNumber = "8321234567";
    
        ArrayList<User> users = new ArrayList<>();
        facade.addUser("jolly123", "jilly", "rancher", "01", "8321234567");
        assertEquals(facade.Login(users));
    }

    //1st box
    void nullCreateAccount()
    {
        facade.addUser(null,null,null,null,null)
        {
            assertEquals(facade.Login(users));
        }
    }

    //2nd box
    void gettingCabin()
    {
        String cabinName = "boss";
        assertNotNull(cabinName());
    }
    
}