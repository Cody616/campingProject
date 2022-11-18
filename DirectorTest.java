/*
 * Troy Grogan Testing
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

//Troy Grogan

import java.util.ArrayList;
import java.util.Date;

public class DirectorTest 
{
    CampFacade facade = new CampFacade();
    CampUI driver = new CampUI(facade);

    String username = "THEcampDirector";
    String password = "yuuup";

    //LOGS THE DIRECTOR INTO THE CAMP FACADE
    int login = facade.login(username, password);
    
    //director value tests
    @Test
    public void testViewDirectorProfile()
    {
        String temp = new String ("\nDirector: Charles Samuels\n" 
                                + "Username: THEcampDirector\n" 
                                + "Date of Birth: 11/04/1989\n" 
                                + "Address: 1101 Dog Court\n");

        assertEquals(temp, facade.viewDirectorProfile());
    }

    @Test
    void testEditDirectorName_IdealInput()
    {
        facade.getCurrentDirector().setFirstName("Charles");
        assertEquals("Charles",facade.getCurrentDirector().getFirstName());
    }
    
    @Test
    void testEditDirectorName_NullInput()
    {
        facade.getCurrentDirector().setFirstName(null);
        assertEquals(null,facade.getCurrentDirector().getFirstName());
    }

    @Test
    void testEditDirectorName_EmptyInput()
    {
        facade.getCurrentDirector().setFirstName("");
        assertEquals("",facade.getCurrentDirector().getFirstName());
    }

    //activities stuff
    @Test
    void testViewActivities_IdealInput()
    {
        String userInput = new String("2023 Summer Camp");
        //String output = facade.getActivities(userInput);
        assertEquals("Activity: Swimming, " + 
                    "Location: Pool, " +
                    "Description: campers will go swimming in our camp's pool\n"  +
                    
                    "Activity: Archery, " + 
                    "Location: Archery range, " + 
                    "Description: campers will practice their archery skills at the camp's Archery range\n",

        facade.getActivities(userInput));
    }

    @Test
    void testViewActivities_MispelledInput()
    {
        String userInput = new String("2023 sumeeer Camp");
        //String output = facade.getActivities(userInput);
        assertEquals("This camp does not exist",facade.getActivities(userInput));
    }

    @Test
    void testViewActivities_EmptyInput()
    {
        String userInput = new String("");
        //String output = facade.getActivities(userInput);
        assertEquals("This camp does not exist",facade.getActivities(userInput));
    }

    @Test
    void testViewActivities_NullInput()
    {
        String userInput = null;
        //String output = facade.getActivities(userInput);
        assertEquals("This camp does not exist",facade.getActivities(userInput));
    }

}