// Class to represent a Rescue Team
class RescueTeam {
    String teamName;
    int resources;
    static int totalRescueTeams = 0;  // Static variable to keep track of total rescue teams

    // Constructor
    public RescueTeam(String teamName, int resources) {
        this.teamName = teamName;
        this.resources = resources;
        totalRescueTeams++;  // Incrementing the count when a new team is created
    }

    // Method to use resources
    public void useResources(int amount) {
        if (this.resources >= amount) {
            this.resources -= amount;
            System.out.println(this.teamName + " used " + amount + " resources.");
        } else {
            System.out.println(this.teamName + " does not have enough resources!");
        }
    }

    // Method to display team status
    public void displayStatus() {
        System.out.println("Team: " + this.teamName + ", Resources: " + this.resources);
    }

    // Static method to display total rescue teams
    public static void displayTotalRescueTeams() {
        System.out.println("Total Rescue Teams: " + totalRescueTeams);
    }
}

// Class to represent an Affected Area
class AffectedArea {
    String location;
    int victims;
    int damageLevel;
    static int totalAffectedAreas = 0;  // Static variable to keep track of total affected areas

    // Constructor
    public AffectedArea(String location, int victims, int damageLevel) {
        this.location = location;
        this.victims = victims;
        this.damageLevel = damageLevel;
        totalAffectedAreas++;  // Incrementing the count when a new area is created
    }

    // Method to rescue victims
    public void rescueVictims(int count) {
        if (this.victims >= count) {
            this.victims -= count;
            System.out.println(count + " victims have been rescued in " + this.location);
        } else {
            System.out.println("Not enough victims to rescue!");
        }
    }

    // Method to display area status
    public void displayAreaStatus() {
        System.out.println("Location: " + this.location + ", Victims: " + this.victims + ", Damage Level: " + this.damageLevel);
    }

    // Static method to display total affected areas
    public static void displayTotalAffectedAreas() {
        System.out.println("Total Affected Areas: " + totalAffectedAreas);
    }
}

// Main class to run the disaster simulation
public class DisasterSimulation {
    public static void main(String[] args) {
        // Creating an array of RescueTeam objects using dynamic memory allocation
        RescueTeam[] teams = new RescueTeam[3];
        teams[0] = new RescueTeam("Medical Unit", 100);
        teams[1] = new RescueTeam("Fire Brigade", 80);
        teams[2] = new RescueTeam("Search and Rescue", 90);

        // Creating an array of AffectedArea objects using dynamic memory allocation
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

        // Displaying total counts
        RescueTeam.displayTotalRescueTeams();
        AffectedArea.displayTotalAffectedAreas();
    }
}
