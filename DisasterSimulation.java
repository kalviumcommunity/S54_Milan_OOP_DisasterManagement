// Class to represent a Rescue Team
class RescueTeam {
    private String teamName;
    private int resources;

    // Default Constructor
    public RescueTeam() {
        this.teamName = "Unknown Team";
        this.resources = 50; // default resources
        System.out.println("Default Constructor called: " + this.teamName);
    }

    // Parameterized Constructor
    public RescueTeam(String teamName, int resources) {
        this.teamName = teamName;
        this.resources = resources;
        System.out.println("Parameterized Constructor called: " + this.teamName);
    }

    // Accessor method
    public String getTeamName() {
        return teamName;
    }

    // Mutator method
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    // Method to display team status
    public void displayStatus() {
        System.out.println("Team: " + this.teamName + ", Resources: " + this.resources);
    }
    
    // Destructor-like behavior (Java doesn't have explicit destructors)
    protected void finalize() throws Throwable {
        System.out.println("Destructor (finalize) called for team: " + this.teamName);
        super.finalize();
    }
}

// Class to represent an Affected Area
class AffectedArea {
    private String location;
    private int victims;

    // Parameterized Constructor
    public AffectedArea(String location, int victims) {
        this.location = location;
        this.victims = victims;
    }

    // Accessor and Mutator methods for encapsulation
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getVictims() {
        return victims;
    }

    public void setVictims(int victims) {
        this.victims = victims;
    }

    // Method to display area status
    public void displayAreaStatus() {
        System.out.println("Location: " + this.location + ", Victims: " + this.victims);
    }
}

// Main class to run the disaster simulation
public class DisasterSimulation {
    public static void main(String[] args) {
        // Using the default constructor
        RescueTeam team1 = new RescueTeam();
        team1.displayStatus();

        // Using the parameterized constructor
        RescueTeam team2 = new RescueTeam("Fire Brigade", 80);
        team2.displayStatus();
        
        // Creating an affected area using the parameterized constructor
        AffectedArea area = new AffectedArea("Downtown", 100);
        area.displayAreaStatus();

        // Destructor will be called automatically by garbage collection when the objects go out of scope.
    }
}
