public class Activity {
    
    private String name;
    private String location;

    public Activity(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String toString() {
        return "\n\tActivity: " + this.name + "\n\tLocation: " + this.location + "\n";
    }

}
