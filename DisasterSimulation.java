// Interface: TeamActions (Open/Closed Principle Applied)
interface TeamActions {
    void useResources(int amount);
    void displayStatus();
}

// Abstract Class: Team (Implements the Interface)
abstract class Team implements TeamActions {
    protected String teamName;
    protected int resources;

    public Team(String teamName, int resources) {
        this.teamName = teamName;
        this.resources = resources;
    }

    @Override
    public abstract void useResources(int amount); // Force subclasses to implement

    @Override
    public void displayStatus() {
        System.out.println("Team: " + this.teamName + ", Resources: " + this.resources);
    }
}

// Derived Class 1: RescueTeam
class RescueTeam extends Team {
    private int missionsCompleted;

    public RescueTeam(String teamName, int resources, int missionsCompleted) {
        super(teamName, resources);
        this.missionsCompleted = missionsCompleted;
    }

    @Override
    public void useResources(int amount) {
        if (this.resources >= amount) {
            this.resources -= amount;
            System.out.println(this.teamName + " used " + amount + " resources for rescue missions.");
        } else {
            System.out.println(this.teamName + " does not have enough resources for a rescue mission!");
        }
    }

    public void performMission(int resourceUsed, String missionType) {
        if (this.resources >= resourceUsed) {
            useResources(resourceUsed);
            this.missionsCompleted++;
            System.out.println(this.teamName + " completed a " + missionType + " mission. Total missions: " + this.missionsCompleted);
        } else {
            System.out.println("Not enough resources to perform the mission!");
        }
    }
}

// Derived Class 2: MedicalTeam
class MedicalTeam extends Team {
    private int patientsTreated;

    public MedicalTeam(String teamName, int resources, int patientsTreated) {
        super(teamName, resources);
        this.patientsTreated = patientsTreated;
    }

    @Override
    public void useResources(int amount) {
        if (this.resources >= amount) {
            this.resources -= amount;
            System.out.println(this.teamName + " used " + amount + " resources to treat patients.");
        } else {
            System.out.println(this.teamName + " does not have enough resources to treat patients!");
        }
    }

    public void treatPatients(int patients, String patientType) {
        this.patientsTreated += patients;
        System.out.println(this.teamName + " treated " + patients + " " + patientType + " patients. Total patients treated: " + this.patientsTreated);
    }
}

// New Derived Class: LogisticsTeam (Open/Closed Extension)
class LogisticsTeam extends Team {
    private int suppliesDelivered;

    public LogisticsTeam(String teamName, int resources, int suppliesDelivered) {
        super(teamName, resources);
        this.suppliesDelivered = suppliesDelivered;
    }

    @Override
    public void useResources(int amount) {
        if (this.resources >= amount) {
            this.resources -= amount;
            System.out.println(this.teamName + " used " + amount + " resources to deliver supplies.");
        } else {
            System.out.println(this.teamName + " does not have enough resources to deliver supplies!");
        }
    }

    public void deliverSupplies(int supplies, String location) {
        if (this.resources >= supplies) {
            useResources(supplies);
            this.suppliesDelivered += supplies;
            System.out.println(this.teamName + " delivered " + supplies + " supplies to " + location + ". Total supplies delivered: " + this.suppliesDelivered);
        } else {
            System.out.println("Not enough resources to deliver supplies!");
        }
    }
}

// Class: AffectedArea
class AffectedArea {
    private String location;
    private int victims;
    private int damageLevel;

    public AffectedArea(String location, int victims, int damageLevel) {
        this.location = location;
        this.victims = victims;
        this.damageLevel = damageLevel;
    }

    public void rescueVictims(int count) {
        if (this.victims >= count) {
            this.victims -= count;
            System.out.println(count + " victims have been rescued in " + this.location);
        } else {
            System.out.println("Not enough victims to rescue!");
        }
    }

    public void displayAreaStatus() {
        System.out.println("Location: " + this.location + ", Victims: " + this.victims + ", Damage Level: " + this.damageLevel);
    }
}

// Main Class: DisasterSimulation
public class DisasterSimulation {
    public static void main(String[] args) {
        // Create team objects
        RescueTeam fireBrigade = new RescueTeam("Fire Brigade", 100, 5);
        MedicalTeam medicalUnit = new MedicalTeam("Medical Unit", 80, 50);
        LogisticsTeam supplyUnit = new LogisticsTeam("Supply Unit", 150, 30);

        // Create affected areas
        AffectedArea downtown = new AffectedArea("Downtown", 50, 90);
        AffectedArea suburb = new AffectedArea("Suburb", 30, 60);

        // Display initial statuses
        System.out.println("Initial Team Status:");
        fireBrigade.displayStatus();
        medicalUnit.displayStatus();
        supplyUnit.displayStatus();

        System.out.println("\nAffected Areas Status:");
        downtown.displayAreaStatus();
        suburb.displayAreaStatus();

        // Perform actions
        System.out.println("\nPerforming Rescue Missions:");
        fireBrigade.useResources(20);
        downtown.rescueVictims(10);

        System.out.println("\nMedical Team Treating Patients:");
        medicalUnit.treatPatients(15, "critical");

        System.out.println("\nLogistics Team Delivering Supplies:");
        supplyUnit.deliverSupplies(40, "Downtown");

        // Updated statuses
        System.out.println("\nUpdated Team Status:");
        fireBrigade.displayStatus();
        medicalUnit.displayStatus();
        supplyUnit.displayStatus();

        System.out.println("\nUpdated Affected Areas Status:");
        downtown.displayAreaStatus();
        suburb.displayAreaStatus();
    }
}
