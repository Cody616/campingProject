import java.util.ArrayList;
import java.util.UUID;

public class CamperList {
     private ArrayList<Camper> campers;
     private static CamperList camperList;

     private CamperList() {
          campers = DataLoader.loadCampers();
     }

     public static CamperList getInstance() {
          if (camperList == null) {
               camperList = new CamperList();
          }
          return camperList;
     }

     public boolean addCamper(Camper camper) {
          if (camper == null) {
               return false;
          } else {
               campers.add(camper);
               saveCampers();
          }
          return false;
     }

     public Camper getCamperByUUID(UUID uuid) {
          for (Camper c : campers) {

               if (c.getUUID().equals(uuid))
                    return c;
          }
          return null;
     }

     public Camper getCamperByName(String firstName, String lastName)
     {
          for(Camper c: campers)
          {
               if(c.getFirstName().equals(firstName) && c.getLastName().equals(lastName))
               {
                    return c;
               }
          }
          return null;
     }

     public ArrayList<Camper> getCampers() {
          return campers;
     }

     public Camper getCamper() {
          return null;
     }

     public void editCamper() {

     }

     public void saveCampers() {
          DataWriter.saveCampers();
     }
}