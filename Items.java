import java.util.ArrayList;
import java.util.UUID;

//this would be like pulling up the cabins

//items are the cabins class
//this gave me the idea.
/*
 * build the director class first which has access to everything along with the ui
 * then do all the other types of user, but they would only have access to certain information bc they are limited to one cabin
 */
public class Items {
	private static Items items;
	private static ArrayList<Item> itemList;
	
	private Items() {
		//just returns an empty arrayList of type item
		itemList = DataBase.getItems();
		//for userList, it instead makes a call to dataLoader by doing DataLoader.getUsers();
	}
	
	public static Items getInstance() {
		if(items == null) {
			/*
			 * userList = new ArrayList<User>();
			 * users = new Users();
			 */
			itemList = new ArrayList<Item>();
			items = new Items();
		}
		
		return items;
	}

	public boolean haveItem(String itemTitle) {
		// System.out.println("INSIDE HAVETIME METHOD");
		// System.out.println("itemTitle: " + itemTitle);

		if(itemList == null)
		{
			System.out.println("RETURNS FALSE");
			return false;
		}
		
		//loops thru entire items list, compares title to entered string
		for(Item item : itemList) {
			System.out.println("FORLOOPP????");
			System.out.println("INSIDE FORLOOP");
			System.out.println("if User in the arraylist is found:");

			if(item.getTitle().equals(itemTitle)) {

				System.out.println("Item found");
				System.out.println(item.toString());

				return true;
			}
		}
		return false;
	}
	
	public Item getItem(String itemTitle) {

		// if(!haveItem(itemName)) return null;
		
		// return new Item(itemName, "Jim Hart");

		for(Item item: itemList)
		{
			if(item.getTitle().equals(itemTitle))
			{
				return item;
			}
		}

		return null;
	}

	public ArrayList<Item> getItems() {
		return itemList;
	}

	public boolean addItem(String title, String author) {

		// System.out.println("INSIDE ADDUSER METHOD");
		// System.out.println(haveUser(userName));

		//if username already exists
		if(haveItem(title))
		{
			return false;
		}
		
		//adds to item arraylist
		itemList.add(new Item(title, author));

		return true;
	}
	
	public void saveItems() {
		//calls for datawriter.save
		DataWriter.saveItems();
	}
}