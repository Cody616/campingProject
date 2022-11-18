import java.util.ArrayList;
import java.util.UUID;

public class CampList {
    
    private ArrayList<Camp> camps = new ArrayList<Camp>();
    private static CampList campList;

    private CampList() {
        camps = DataLoader.loadCamps();
    }

    public static CampList getInstance() {
        if (campList == null) {
            campList = new CampList();
        }
        return campList;
    }

    public boolean addCamp(Camp camp) 
    {
        if (camps == null) {
            return false;
        } 

        camps.add(camp);
        return true;
    }

    public Camp getCampByName(String name) 
    {
        for (Camp camp : camps) {
            if (camp.getCampName().equals(name)) {
                return camp;
            }
        }
        return null;
    }

    public Cabin getCabinByUUID(UUID id) {
        for (Camp camp : camps) 
        {
            for(Session session : camp.getCampSessions())
            {
                for (Cabin cabin : session.getCabins()) 
                {
                    if (cabin.getId().equals(id)) {
                        return cabin;
                    }
                }
            }
        }
        return null;
    }

    public ArrayList<Camp> getCamps() {
        return camps;
    }

    public void saveCamps() {
        DataWriter.saveCamps();
    }

    public String toString() {
        String allCamps = "";
        for (Camp camp : camps) {
            allCamps += camp + "\n";
        }
        return allCamps;
    }

}
