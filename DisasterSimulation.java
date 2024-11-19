// Base Class: Team
class Team {
    protected String teamName;
    protected int resources;

    // Constructor
    public Team(String teamName, int resources) {
        this.teamName = teamName;
        this.resources = resources;
    }

    // Method to display team status
    public void displayStatus() {
        System.out.println("Team: " + this.teamName + ", Resources: " + this.resources);
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
}

// Derived Class 1: RescueTeam (Single Inheritance)
class RescueTeam extends Team {
    private int missionsCompleted;

    // Constructor
    public RescueTeam(String teamName, int resources, int missionsCompleted) {
        super(teamName, resources); // Call the constructor of the base class
        this.missionsCompleted = missionsCompleted;
    }

    // Method to perform a rescue mission
    public void performMission(int resourceUsed) {
        if (this.resources >= resourceUsed) {
            useResources(resourceUsed);
            this.missionsCompleted++;
            System.out.println(this.teamName + " completed a mission. Total missions: " + this.missionsCompleted);
        } else {
            System.out.println("Not enough resources to complete the mission!");
        }
    }
}

// Derived Class 2: MedicalTeam (Multilevel Inheritance)
class MedicalTeam extends RescueTeam {
    private int patientsTreated;

    // Constructor
    public MedicalTeam(String teamName, int resources, int missionsCompleted, int patientsTreated) {
        super(teamName, resources, missionsCompleted); // Call the constructor of RescueTeam
        this.patientsTreated = patientsTreated;
    }

    // Method to treat patients
    public void treatPatients(int patients) {
        this.patientsTreated += patients;
        System.out.println(this.teamName + " treated " + patients + " patients. Total patients treated: " + this.patientsTreated);
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
        MedicalTeam medicalUnit = new MedicalTeam("Medical Unit", 80, 3, 50);

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

        // Perform actions
        System.out.println("\nPerforming Rescue Missions:");
        fireBrigade.performMission(20); // Fire Brigade performs a rescue mission
        downtown.rescueVictims(10);

        System.out.println("\nMedical Team Treating Patients:");
        medicalUnit.treatPatients(15);

        // Display updated status
        System.out.println("\nUpdated Team Status:");
        fireBrigade.displayStatus();
        medicalUnit.displayStatus();

        System.out.println("\nUpdated Affected Areas Status:");
        downtown.displayAreaStatus();
        suburb.displayAreaStatus();
    }
}
