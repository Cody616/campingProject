import java.util.ArrayList;
import java.util.Random;

public class Cabin{
    // private ArrayList<String> schedule = new ArrayList<String>();
    // private ArrayList<Schedule> schedules = new ArrayList<Schedule>();

    //number goes from 1 to 8
    private int cabinNumber;
    //^^do you even need to do this??? it's number is just the position its stored in in the front end's array.
    private ArrayList<String> fakecampers = new ArrayList<String>();

    // private Random rand = new Random(); 

    /*
     * each cabin has 1 counselor and 8 students
     */

    // private ArrayList<Counselors> counselors = new ArrayList<Counselors>();
    // private ArrayList<Campers> camper = new ArrayList<Campers>();

    //, ArrayList<String> fakecampers
    public Cabin(int cabinNumber)
    {
        this.cabinNumber = cabinNumber;
        
        // fakecampers = fakecampers;

        /*
         * 1 cabin contains 1 counselor and 8 campers in total
         */

    }

    public int getCabinNumber() {
		return cabinNumber;
	}

    public ArrayList<String> getFakeCampers()
    {
        return fakecampers;
    }

    /*
     * NEED SETTERS!!
     */

    // public Item(String title, String author) {
	// 	this.title = title;
	// 	this.author = author;
	// }
	
}