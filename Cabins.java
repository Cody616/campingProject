import java.util.ArrayList;

public class Cabins {
    private static Cabins cabins;
	private static ArrayList<Cabin> cabinList;
	
	private Cabins() {
		//just returns an empty arrayList of type item
		cabinList = DataBase.getCabins();
		
		//for userList, it instead makes a call to dataLoader by doing DataLoader.getUsers();
	}
	
	public static Cabins getInstance() {
		if(cabins == null) {
			/*
			 * userList = new ArrayList<User>();
			 * users = new Users();
			 */
			cabinList = new ArrayList<Cabin>();
			cabins = new Cabins();
		}
		
		return cabins;
	}

	public boolean haveCabin(String itemName) {
		return true;
	}
	
	public Cabin getCabin(String cabinID) {
		if(!haveCabin(cabinID)) return null;
		
		return new Cabin(cabinID, "Jim Hart");
	}
}
