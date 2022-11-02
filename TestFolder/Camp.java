import java.util.ArrayList;
import java.util.UUID;

public class Camp {
    /*
     * needs name of the camp, 
     * amt of sessions, 
     * and amt of cabins for the camp season
     */

     /*
      * camp facade would jsut have users and camps object????
      * camps object is an arraylist of camp objects
      * currently inside the camp object rn, which will have 9 sessions and 6 cabins as the limit.
      *
      *
      * should ask user for activity info?????<<< this would be info for the session????
      */
     private UUID id;
     private int campYear;
     private String campName;
     private static final int SESSIONS_LIMIT = 9;
     private static final int CABINS_LIMIT = 6;

    private static ArrayList<Session> sessions;
    private static ArrayList<Cabin> cabins;
     //^^these could possibly be done in a cabins/ sessions class maybe..... not there yet :D



    //new Camp
    public Camp(String campName, int campYear, ArrayList<Session> sessions, ArrayList<Cabin> cabins)
    {
        this.id = UUID.randomUUID();
        this.campName = campName;
        this.campYear = campYear;

        //each session has like 9 weeks, but also contains the cabins associated per week.
        this.sessions = new ArrayList<Session>();

        //^^knowing this, then i feel like i don't need the cabin array in the camp class.

        //rethinking this immediately yes you do looool 
        //re rethinking this, no. because the camps are associated by the session as that is how the activities are identified. 
        //re re rethinking this^^ while this is true, we still want a cabins arraylist in this object so that the user can interact with the cabin Object properties
        //^^then again???? could just have this be a method of the schedules class

        // this.cabins = new ArrayList<Cabin>();
    }

    //loaded preexisting Camp from json
    public Camp(UUID id, String campName, ArrayList<Session> sessions)
    {
        this.id = id;
        this.sessions = new ArrayList<Session>();
        // this.cabins = new ArrayList<Cabin>();
    }




     //this is what the director is creating in scenario 1.

     //would have a setSessions method. would loop thru 9 


    // public static int getSessionsLimit() {
    //     return SESSIONS_LIMIT;
    // }
    // public static int getCabinsLimit() {
    //     return CABINS_LIMIT;
    // }


    public static ArrayList<Session> getSessions() {
        return sessions;
    }

    public static void setSessions(ArrayList<Session> sessions) {
        Camp.sessions = sessions;
    }

    public static ArrayList<Cabin> getCabins() {
        return cabins;
    }

    public static void setCabins(ArrayList<Cabin> cabins) {
        Camp.cabins = cabins;
    }

}
