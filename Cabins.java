import java.util.ArrayList;

//items are the cabins class
//this gave me the idea.
/*
 * build the director class first which has access to everything along with the ui
 * then do all the other types of user, but they would only have access to certain information bc they are limited to one cabin
 */
public class Cabins {

	private static Cabins cabins;
	private static ArrayList<Cabin> cabinList;

	//A CABIN SHOULD SET THE SCHEDULE AS IT IS THE OBJECT THAT HOLDS THE SCHEDULE???
	
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

	public boolean haveCabin(String cabinName) {
		// System.out.println("INSIDE HAVETIME METHOD");
		// System.out.println("itemTitle: " + itemTitle);

		if(cabinList == null)
		{
			System.out.println("RETURNS FALSE");
			return false;
		}
		
		//loops thru entire items list, compares title to entered string
		for(Cabin cabin : cabinList) {
			// System.out.println("FORLOOPP????");
			// System.out.println("INSIDE FORLOOP");
			// System.out.println("if User in the arraylist is found:");

			if(cabin.getTitle().equals(cabinName)) {

				System.out.println("Cabin found");
				System.out.println(cabin.toString());

				return true;
			}
		}
		return false;
	}
	
	public Cabin getCabin(String cabinTitle) {

		// if(!haveItem(itemName)) return null;
		
		// return new Item(itemName, "Jim Hart");

		for(Cabin item: cabinList)
		{
			if(item.getTitle().equals(cabinTitle))
			{
				return item;
			}
		}

		return null;
	}

	public boolean addCabin(String title, String author) {

		// System.out.println("INSIDE ADDUSER METHOD");
		// System.out.println(haveUser(userName));

		//if username already exists
		if(haveCabin(title))
		{
			return false;
		}
		
		//adds to item arraylist
		cabinList.add(new Cabin(title, author));
		System.out.println("CABIN WAS ADDED.");
		return true;
	}

	public ArrayList<Cabin> getCabins() {
		return cabinList;
	}
	
	public void saveCabins() {
		//calls for datawriter.save
		DataWriter.saveCabins();
	}

}


// private static Cabins cabins;
// private static ArrayList<Cabin> cabinList;

// private Cabins() {
// 	//just returns an empty arrayList of type item
// 	cabinList = DataBase.getCabins();
	
// 	//for userList, it instead makes a call to dataLoader by doing DataLoader.getUsers();
// }

// public static Cabins getInstance() {
// 	if(cabins == null) {
// 		/*
// 		 * userList = new ArrayList<User>();
// 		 * users = new Users();
// 		 */
// 		cabinList = new ArrayList<Cabin>();
// 		cabins = new Cabins();
// 	}
	
// 	return cabins;
// }

// public boolean haveCabin(String itemName) {
// 	return true;
// }

// public Cabin getCabin(String cabinID) {
// 	if(!haveCabin(cabinID)) return null;
	
// 	return new Cabin(cabinID, "Jim Hart");
// }


