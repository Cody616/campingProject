import java.util.UUID;

public class Cabin {

	private UUID id;
	private String title;
	private String author;
	
	//new Item
	public Cabin(String title, String author) {
		this.id = UUID.randomUUID();
		this.title = title;
		this.author = author;
	}

	//loads preexisting item from json
	public Cabin(UUID id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
	}

	public UUID getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}

}