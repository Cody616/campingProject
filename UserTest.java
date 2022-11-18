/*
 * Troy Grogan Testing
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

class UserTest {

    CampFacade facade = new CampFacade();
    CampUI driver = new CampUI(facade);
    
    @Test 
    public void testTest()
    {
        assertEquals(1,1);
    }

    //have user tests
    @Test
    public void testHaveValidUser()
    {
        String username = "leroy";
        String password = "1235";

        boolean result = UserList.getInstance().haveUser(username, password);

        assertEquals(true, result);
    }

    @Test
    public void testHaveInvalidUser()
    {
        String username = "hey";
        String password = "fr";

        boolean result = UserList.getInstance().haveUser(username, password);
        assertEquals(false, result);
    }

    //add user tests
    @Test
    public void testAddDuplicateUser()
    {
        String username = "alexander";
        String password = "here";

        String firstName = "Bob";
        String lastName = "yuj";
        String birthdate = "9/23/04";
        Gender gender = Gender.MALE;
        int age = 18;
        String homeAddress = "44 Lake Drive";
        String phoneNumber = "888-888-8899";
        String email = "bobyuj@email.com";

        User user = new User(username, password, firstName, lastName
        , birthdate, gender, age, homeAddress, phoneNumber, email);
        
        boolean result = UserList.getInstance().addUser(user);

        assertEquals(false, result);
    }

    @Test
    public void testAddDuplicateDifferentUser()
    {
        String username = "hey";
        String password = "fr";

        String firstName = "Bob";
        String lastName = "yujTOO";
        String birthdate = "9/23/04";
        Gender gender = Gender.MALE;
        int age = 18;
        String homeAddress = "44 Lake Drive";
        String phoneNumber = "888-888-8899";
        String email = "bobyuj@email.com";

        User user = new User(username, password, 
        firstName, lastName, birthdate, 
        age, gender, homeAddress, phoneNumber, email); 

        boolean result = UserList.getInstance().addUser(user);
        assertEquals(false, result);
    }

    @Test
    public void testAddnullUser()
    {
        User user = null;

        boolean result = UserList.getInstance().addUser(user);
        
        assertEquals(false, result);
    }

    @Test
    public void testAddValidUser()
    {
        String username = "validUsername";
        String password = "validPassword";

        String firstName = "todd";
        String lastName = "johnson";
        String birthdate = "11/11/03";
        Gender gender = Gender.MALE;
        int age = 19;
        String homeAddress = "45 Ocean Drive";
        String phoneNumber = "777-777-8899";
        String email = "toddjohnson@email.com";

        User user = new User(username, password, firstName, lastName, birthdate, gender, age, homeAddress, phoneNumber, email);

        boolean result = UserList.getInstance().addUser(user);
        assertEquals(true, result);
    }

    @Test
    public void testAddInvalidAddressUser()
    {
        String username = "username";
        String password = "password";

        String firstName = "todd";
        String lastName = "johnson";
        String birthdate = "11/11/03";
        Gender gender = Gender.MALE;
        int age = 19;
        String homeAddress = "THIS IS THE ADDRESS LOL";
        String phoneNumber = "777-777-8899";
        String email = "toddjohnson@email.com";

        User user = new User(username, password, firstName, lastName, 
        birthdate, gender, age, homeAddress, phoneNumber, email);

        boolean result = UserList.getInstance().addUser(user);
        assertEquals(false, result);
    }

    @Test
    public void testAddInvalidLoginUser()
    {
         String username = "";
         String password = "password";
 
         String firstName = "todd";
         String lastName = "johnson";
         String birthdate = "11/11/03";
         Gender gender = Gender.MALE;
         int age = 19;
         String homeAddress = "THIS IS THE ADDRESS LOL";
         String phoneNumber = "777-777-8899";
         String email = "toddjohnson@email.com";
 
         User user = new User(username, password, firstName, lastName, 
         birthdate, gender, age, homeAddress, phoneNumber, email);

        boolean result = UserList.getInstance().addUser(user);
        assertEquals(false, result);
    }

    @Test
    public void testAddInvalidPasswordUser()
    {
        String username = "username";
        String password = "";

        String firstName = "todd";
        String lastName = "johnson";
        String birthdate = "11/11/03";
        Gender gender = Gender.MALE;
        int age = 19;
        String homeAddress = "THIS IS THE ADDRESS LOL";
        String phoneNumber = "777-777-8899";
        String email = "toddjohnson@email.com";

        User user = new User(username, password, firstName, lastName, 
        birthdate, gender, age, homeAddress, phoneNumber, email);

       boolean result = UserList.getInstance().addUser(user);
       assertEquals(false, result);
    }

    //get user tests
    @Test
    public void testGetUsers()
    {
        int num = UserList.getInstance().getUsers().size();

        assertEquals(1,num);
    }

    @Test
    public void testValidGetCamper()
    {
        Camper contains = UserList.getInstance().getUserByUserName("alexander").getCamper("Bob");
        assertEquals("Bob", contains.getFirstName());
    }

    @Test
    public void testInvalidGetCamper()
    {
        Camper contains = UserList.getInstance().getUserByUserName("alexander").getCamper("");
        assertEquals(null, contains);
    }
}