public class Medication {
    
    private String name;   
    private String time;
    private String dose;
 
    public Medication(String name, String time, String dose) {
        this.name = name;
        this.dose = dose;
        this.time = time;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public String getDose() {
        return dose;
    }
    public void setDose(String dose) {
        this.dose = dose;
    }

    public String toString() {
        return "Medication Name: " + name +
                "\nTime to take it at: " + time +
                "\nDosage Amount: " + dose;
                
    }
}
