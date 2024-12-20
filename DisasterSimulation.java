// Abstract Base Class: Team
abstract class Team {
    protected String teamName;
    protected int resources;

    // Constructor
    public Team(String teamName, int resources) {
        this.teamName = teamName;
        this.resources = resources;
    }

    // Abstract Method to use resources (Virtual Function)
    public abstract void useResources(int amount);

    // Method to display team status
    public void displayStatus() {
        System.out.println("Team: " + this.teamName + ", Resources: " + this.resources);
    }
}

// Derived Class 1: RescueTeam (Single Inheritance)
class RescueTeam extends Team {
    private int missionsCompleted;

    // Constructor
    public RescueTeam(String teamName, int resources, int missionsCompleted) {
        super(teamName, resources); // Call the constructor of the base class
        this.missionsCompleted = missionsCompleted;
    }

    // Overriding the useResources method (Virtual Function)
    @Override
    public void useResources(int amount) {
        // Custom behavior for RescueTeam
        if (this.resources >= amount) {
            this.resources -= amount;
            System.out.println(this.teamName + " used " + amount + " resources for rescue missions.");
        } else {
            System.out.println(this.teamName + " does not have enough resources to complete the rescue mission!");
        }
    }

    // Method to perform a rescue mission with additional parameters (Function Overloading)
    public void performMission(int resourceUsed, String missionType) {
        if (this.resources >= resourceUsed) {
            useResources(resourceUsed); // Use the overridden method
            this.missionsCompleted++;
            System.out.println(this.teamName + " completed a " + missionType + " mission. Total missions: " + this.missionsCompleted);
        } else {
            System.out.println("Not enough resources to complete the mission!");
        }
    }
}

// Derived Class 2: MedicalTeam (Multilevel Inheritance)
class MedicalTeam extends Team {
    private int patientsTreated;

    // Constructor
    public MedicalTeam(String teamName, int resources, int patientsTreated) {
        super(teamName, resources); // Call the constructor of Team
        this.patientsTreated = patientsTreated;
    }

    // Overriding the useResources method (Virtual Function)
    @Override
    public void useResources(int amount) {
        // Custom behavior for MedicalTeam
        if (this.resources >= amount) {
            this.resources -= amount;
            System.out.println(this.teamName + " used " + amount + " resources to treat patients.");
        } else {
            System.out.println(this.teamName + " does not have enough resources to treat patients!");
        }
    }

    // Method to treat patients (Function Overloading)
    public void treatPatients(int patients, String patientType) {
        this.patientsTreated += patients;
        System.out.println(this.teamName + " treated " + patients + " " + patientType + " patients. Total patients treated: " + this.patientsTreated);
    }
}

// Class: AffectedArea
class AffectedArea {
    private String location;
    private int victims;
    private int damageLevel;

    // Constructor
    public AffectedArea(String location, int victims, int damageLevel) {
        this.location = location;
        this.victims = victims;
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

// Main Class: DisasterSimulation
public class DisasterSimulation {
    public static void main(String[] args) {
        // Create objects for Rescue Teams
        RescueTeam fireBrigade = new RescueTeam("Fire Brigade", 100, 5);
        MedicalTeam medicalUnit = new MedicalTeam("Medical Unit", 80, 50);

        // Create objects for Affected Areas
        AffectedArea downtown = new AffectedArea("Downtown", 50, 90);
        AffectedArea suburb = new AffectedArea("Suburb", 30, 60);

        // Display initial status
        System.out.println("Initial Team Status:");
        fireBrigade.displayStatus();
        medicalUnit.displayStatus();

        System.out.println("\nAffected Areas Status:");
        downtown.displayAreaStatus();
        suburb.displayAreaStatus();

        // Perform actions (Demonstrating Polymorphism)
        System.out.println("\nPerforming Rescue Missions:");
        fireBrigade.useResources(20); // Fire Brigade uses resources
        downtown.rescueVictims(10);

        System.out.println("\nMedical Team Treating Patients:");
        medicalUnit.treatPatients(15, "critical"); // Medical Team treats critical patients

        // Perform Rescue Team mission with function overloading
        fireBrigade.performMission(15, "Fire Rescue");

        // Display updated status
        System.out.println("\nUpdated Team Status:");
        fireBrigade.displayStatus();
        medicalUnit.displayStatus();

        System.out.println("\nUpdated Affected Areas Status:");
        downtown.displayAreaStatus();
        suburb.displayAreaStatus();
    }
}
