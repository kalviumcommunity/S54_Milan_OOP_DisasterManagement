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

// Derived Class: RescueTeam
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
            System.out.println(this.teamName + " does not have enough resources to complete the rescue mission!");
        }
    }

    public void performMission(int resourceUsed, String missionType) {
        if (this.resources >= resourceUsed) {
            useResources(resourceUsed);
            this.missionsCompleted++;
            System.out.println(this.teamName + " completed a " + missionType + " mission. Total missions: " + this.missionsCompleted);
        } else {
            System.out.println("Not enough resources to complete the mission!");
        }
    }
}

// Derived Class: MedicalTeam
class MedicalTeam extends RescueTeam {
    private int patientsTreated;

    public MedicalTeam(String teamName, int resources, int missionsCompleted, int patientsTreated) {
        super(teamName, resources, missionsCompleted);
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

// Class: TeamManager (Applies SRP by managing team operations)
class TeamManager {
    public void allocateResources(Team team, int amount) {
        team.useResources(amount);
    }

    public void displayTeamStatus(Team team) {
        team.displayStatus();
    }
}

// Class: AreaManager (Applies SRP by managing area operations)
class AreaManager {
    public void rescueFromArea(AffectedArea area, int count) {
        area.rescueVictims(count);
    }

    public void displayAreaStatus(AffectedArea area) {
        area.displayAreaStatus();
    }
}

// Main Class: DisasterSimulation
public class DisasterSimulation {
    public static void main(String[] args) {
        // Create Team objects
        RescueTeam fireBrigade = new RescueTeam("Fire Brigade", 100, 5);
        MedicalTeam medicalUnit = new MedicalTeam("Medical Unit", 80, 3, 50);

        // Create AffectedArea objects
        AffectedArea downtown = new AffectedArea("Downtown", 50, 90);
        AffectedArea suburb = new AffectedArea("Suburb", 30, 60);

        // Create managers
        TeamManager teamManager = new TeamManager();
        AreaManager areaManager = new AreaManager();

        // Initial Status
        System.out.println("Initial Team Status:");
        teamManager.displayTeamStatus(fireBrigade);
        teamManager.displayTeamStatus(medicalUnit);

        System.out.println("\nAffected Areas Status:");
        areaManager.displayAreaStatus(downtown);
        areaManager.displayAreaStatus(suburb);

        // Perform actions
        System.out.println("\nPerforming Rescue Missions:");
        teamManager.allocateResources(fireBrigade, 20);
        areaManager.rescueFromArea(downtown, 10);

        System.out.println("\nMedical Team Treating Patients:");
        medicalUnit.treatPatients(15, "critical");

        System.out.println("\nPerforming Overloaded Mission:");
        fireBrigade.performMission(15, "Fire Rescue");

        // Updated Status
        System.out.println("\nUpdated Team Status:");
        teamManager.displayTeamStatus(fireBrigade);
        teamManager.displayTeamStatus(medicalUnit);

        System.out.println("\nUpdated Affected Areas Status:");
        areaManager.displayAreaStatus(downtown);
        areaManager.displayAreaStatus(suburb);
    }
}
