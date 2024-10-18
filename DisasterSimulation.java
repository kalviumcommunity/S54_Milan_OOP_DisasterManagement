// Class to represent a Rescue Team
class RescueTeam {
    private String teamName;  // Encapsulated field (private)
    private int resources;    // Encapsulated field (private)

    // Constructor
    public RescueTeam(String teamName, int resources) {
        this.teamName = teamName;
        this.resources = resources;
    }

    // Accessor (Getter) for teamName
    public String getTeamName() {
        return teamName;
    }

    // Mutator (Setter) for teamName
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    // Accessor (Getter) for resources
    public int getResources() {
        return resources;
    }

    // Mutator (Setter) for resources
    public void setResources(int resources) {
        this.resources = resources;
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
}

// Class to represent an Affected Area
class AffectedArea {
    private String location;     // Encapsulated field (private)
    private int victims;         // Encapsulated field (private)
    private int damageLevel;     // Encapsulated field (private)

    // Constructor
    public AffectedArea(String location, int victims, int damageLevel) {
        this.location = location;
        this.victims = victims;
        this.damageLevel = damageLevel;
    }

    // Accessor (Getter) for location
    public String getLocation() {
        return location;
    }

    // Mutator (Setter) for location
    public void setLocation(String location) {
        this.location = location;
    }

    // Accessor (Getter) for victims
    public int getVictims() {
        return victims;
    }

    // Mutator (Setter) for victims
    public void setVictims(int victims) {
        this.victims = victims;
    }

    // Accessor (Getter) for damageLevel
    public int getDamageLevel() {
        return damageLevel;
    }

    // Mutator (Setter) for damageLevel
    public void setDamageLevel(int damageLevel) {
        this.damageLevel = damageLevel;
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

        // Demonstrating Encapsulation - Changing values via setters
        teams[1].setTeamName("Fire Rescue Unit");
        teams[1].setResources(70);
        areas[1].setLocation("Countryside");
        areas[1].setVictims(20);

        // Displaying the updated values using accessors (getters)
        System.out.println("\nUpdated Team and Area Information:");
        System.out.println("Team: " + teams[1].getTeamName() + ", Resources: " + teams[1].getResources());
        System.out.println("Location: " + areas[1].getLocation() + ", Victims: " + areas[1].getVictims());
    }
}
