package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
/*    private static Job testJob;
    @Before
    public void setup () {
        testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }*/

    @Test
    public void testSettingJobId () {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields () {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJob.getEmployer() instanceof Employer);
        assertEquals(testJob.getEmployer().toString(), "ACME");

        assertTrue(testJob.getLocation() instanceof Location);
        assertEquals(testJob.getLocation().toString(), "Desert");

        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertEquals(testJob.getPositionType().toString(), "Quality control");

        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(testJob.getCoreCompetency().toString(), "Persistence");

        assertTrue(testJob.getName() instanceof String);
        assertEquals(testJob.getName(), "Product tester");
    }

    @Test
    public void testJobsForEquality () {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job sameJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(testJob == sameJob);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine () {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String sample = testJob.toString();
        //assertTrue startsWith, endsWith("\n")
        assertEquals(sample.charAt(0), '\n');
        assertEquals(sample.charAt(sample.length() - 1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData () {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String sample = testJob.toString();
        //assertTrue(sample.contains("ID: " + testJob.getId() + "\n"));
        //assertEquals(sample.contains("ID: " + testJob.getId() + "\n"), true);
        assertEquals("\nID: " + testJob.getId() + "\n" + "Name: " + testJob.getName() + "\n" + "Employer: " + testJob.getEmployer().getValue() + "\n" + "Location: " + testJob.getLocation().getValue() + "\n" + "Position Type: " + testJob.getPositionType().getValue() + "\n" + "Core Competency: " + testJob.getCoreCompetency().getValue() + "\n", sample);
    }

    @Test
    public void testToStringHandlesEmptyField () {
        Job swissJob = new Job("Product manager", new Employer(""), new Location("Lucerne"), new PositionType(""), new CoreCompetency("Polyglot"));
        String sample = swissJob.toString();

        //Matches anything that starts with a ": " and ends with "\n"
        Pattern pattern = Pattern.compile("(?<=: ).+?(?=\n)");
        Matcher matcher = pattern.matcher(sample);

        LinkedList<String> list = new LinkedList<String>();

        // Loop through and find all matches and store them into the List
        while(matcher.find()) {
            list.add(matcher.group());
        }

        // Print out the contents of this List
        //  for(String match : list) {
        //      System.out.println(match);
        //  }

        if (swissJob.getName() == "") {
            assertEquals(list.get(1), "Data not available");
        }
        if (swissJob.getEmployer().getValue() == "") {
            assertEquals(list.get(2), "Data not available");
        }
        if (swissJob.getLocation().getValue() == "") {
            assertEquals(list.get(3), "Data not available");
        }
        if (swissJob.getPositionType().getValue() == "") {
            assertEquals(list.get(4), "Data not available");
        }
        if (swissJob.getCoreCompetency().getValue() == "") {
            assertEquals(list.get(5), "Data not available");
        }
    }

    @Test
    public void testForEmptyJobObject () {
        Job nothingBurger = new Job();

        assertEquals(nothingBurger.toString(), "OOPS! This job does not seem to exist.");
    }
}
