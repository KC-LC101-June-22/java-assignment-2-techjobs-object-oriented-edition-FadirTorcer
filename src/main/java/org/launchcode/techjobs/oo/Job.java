package org.launchcode.techjobs.oo;

import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job () {
        id = nextId;
        nextId++;
    }

    public Job (String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String toString () {
        String nameX = this.name;
        String employerX = this.employer.getValue();
        String locationX = this.location.getValue();
        String positionX = this.positionType.getValue();
        String competencyX = this.coreCompetency.getValue();

        if (nameX == "") { nameX = "Data not available"; }
        if (employerX == "") { employerX = "Data not available"; }
        if (locationX == "") { locationX = "Data not available"; }
        if (positionX == "") { positionX = "Data not available"; }
        if (competencyX == "") { competencyX = "Data not available"; }

        //-<[BONUS]>- if all but ID are empty, return "OOPS! This job does not seem to exist."

        return "\n" +
                "ID: " + this.id + "\n" +
                "Name: " + nameX + "\n" +
                "Employer: " + employerX + "\n" +
                "Location: " + locationX + "\n" +
                "Position Type: " + positionX + "\n" +
                "Core Competency: " + competencyX + "\n";
    }
}
