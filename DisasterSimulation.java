// Class to represent a Rescue Team
class RescueTeam {
    private String teamName;  // Private variables, hidden from external access
    private int resources;    // Private variable for abstraction

    // Constructor
    public RescueTeam(String teamName, int resources) {
        this.teamName = teamName;
        this.resources = resources;
    }

    // Public method to use resources (abstracts the internal resources usage logic)
    public void useResources(int amount) {
        if (this.resources >= amount) {
            this.resources -= amount;
            System.out.println(this.teamName + " used " + amount + " resources.");
        } else {
            System.out.println(this.teamName + " does not have enough resources!");
        }
    }

    // Public method to display team status
    public void displayStatus() {
        System.out.println("Team: " + this.teamName + ", Resources: " + this.resources);
    }
}

// Class to represent an Affected Area
class AffectedArea {
    private String location;  // Private data members for abstraction
    private int victims;
    private int damageLevel;

    // Constructor
    public AffectedArea(String location, int victims, int damageLevel) {
        this.location = location;
        this.victims = victims;
        this.damageLevel = damageLevel;
    }

    // Public method to rescue victims
    public void rescueVictims(int count) {
        if (this.victims >= count) {
            this.victims -= count;
            System.out.println(count + " victims have been rescued in " + this.location);
        } else {
            System.out.println("Not enough victims to rescue!");
        }
    }

    // Public method to display area status
    public void displayAreaStatus() {
        System.out.println("Location: " + this.location + ", Victims: " + this.victims + ", Damage Level: " + this.damageLevel);
    }
}

// Main class to run the disaster simulation
public class DisasterSimulation {
    public static void main(String[] args) {
        // Creating an array of RescueTeam objects
        RescueTeam[] teams = new RescueTeam[3];
        teams[0] = new RescueTeam("Medical Unit", 100);
        teams[1] = new RescueTeam("Fire Brigade", 80);
        teams[2] = new RescueTeam("Search and Rescue", 90);

        // Creating an array of AffectedArea objects
        AffectedArea[] areas = new AffectedArea[2];
        areas[0] = new AffectedArea("Downtown", 50, 80);
        areas[1] = new AffectedArea("Suburb", 30, 60);

        // Displaying status of all teams
        System.out.println("Rescue Teams Status:");
        for (RescueTeam team : teams) {
            team.displayStatus();
        }

        // Displaying status of all areas
        System.out.println("\nAffected Areas Status:");
        for (AffectedArea area : areas) {
            area.displayAreaStatus();
        }

        // Performing rescue operations
        teams[0].useResources(20);
        areas[0].rescueVictims(10);

        // Displaying updated status
        System.out.println("\nUpdated Status:");
        teams[0].displayStatus();
        areas[0].displayAreaStatus();
    }
}
