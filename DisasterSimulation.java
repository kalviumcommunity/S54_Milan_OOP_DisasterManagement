// Class to represent a Rescue Team
class RescueTeam {
    String teamName;
    int resources; // Resources like fuel, medical supplies

    // Constructor
    public RescueTeam(String name, int resources) {
        this.teamName = name;
        this.resources = resources;
    }

    // Method to use resources
    public void useResources(int amount) {
        if (resources >= amount) {
            resources -= amount;
            System.out.println(teamName + " used " + amount + " resources.");
        } else {
            System.out.println(teamName + " does not have enough resources!");
        }
    }

    // Method to display team status
    public void displayStatus() {
        System.out.println("Team: " + teamName + ", Resources: " + resources);
    }
}

// Class to represent an Affected Area
class AffectedArea {
    String location;
    int victims;
    int damageLevel;

    // Constructor
    public AffectedArea(String location, int victims, int damageLevel) {
        this.location = location;
        this.victims = victims;
        this.damageLevel = damageLevel;
    }

    // Method to reduce the number of victims
    public void rescueVictims(int count) {
        if (victims >= count) {
            victims -= count;
            System.out.println(count + " victims have been rescued.");
        } else {
            System.out.println("Not enough victims to rescue!");
        }
    }

    // Method to display the area's status
    public void displayAreaStatus() {
        System.out.println("Location: " + location + ", Victims: " + victims + ", Damage Level: " + damageLevel);
    }
}

// Main class to run the disaster simulation
public class DisasterSimulation {
    public static void main(String[] args) {
        // Creating a rescue team object
        RescueTeam medicalTeam = new RescueTeam("Medical Unit", 100);

        // Creating an affected area object
        AffectedArea area1 = new AffectedArea("Downtown", 50, 80);

        // Displaying initial status
        medicalTeam.displayStatus();
        area1.displayAreaStatus();

        // Using resources and rescuing victims
        medicalTeam.useResources(20);
        area1.rescueVictims(10);

        // Displaying updated status
        medicalTeam.displayStatus();
        area1.displayAreaStatus();
    }
}
