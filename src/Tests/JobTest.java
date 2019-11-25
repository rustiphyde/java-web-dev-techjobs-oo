package Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job job_one;
    Job job_two;

    @Before
    public void createJobObjects(){
        job_one = new Job();
        job_two = new Job();
    }

    @Test
    public void testSettingJobId(){
    assertTrue(!job_one.equals(job_two));
    assertTrue(job_two.getId() - job_one.getId() == 1);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job_three = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));

        assertTrue( job_three.getName() != null && job_three.getName() == "Product Tester");
        assertTrue( job_three.getEmployer() instanceof Employer && job_three.getEmployer().getValue() == "ACME");
        assertTrue( job_three.getLocation() instanceof Location && job_three.getLocation().getValue() == "Desert");
        assertTrue( job_three.getPositionType() instanceof PositionType && job_three.getPositionType().getValue() == "Quality Control");
        assertTrue(job_three.getCoreCompetency() instanceof CoreCompetency && job_three.getCoreCompetency().getValue() == "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job job_four = new Job("Equality Tester", new Employer("Test Employer"), new Location("Test Location"), new PositionType("Test Type"), new CoreCompetency("Testing Things"));
        Job job_five = new Job("Equality Tester", new Employer("Test Employer"), new Location("Test Location"), new PositionType("Test Type"), new CoreCompetency("Testing Things"));
        assertFalse(job_four.equals(job_five));
    }

    @Test
    public void testWhitespace(){
        Job job_six = new Job( "Namefield", new Employer("Empfield"), new Location("Locfield"), new PositionType("PTfield"), new CoreCompetency("CCfield"));
        assertTrue(job_six.toString().startsWith(" "));
        assertTrue(job_six.toString().endsWith(" "));
    }

    @Test
    public void testFieldPopulation(){
        Job job_seven = new Job( "Namefield", new Employer("Empfield"), new Location("Locfield"), new PositionType("PTfield"), new CoreCompetency("CCfield"));
        String[] sA = job_seven.toString().split("\n");
        assertEquals( "Name: Namefield", sA[2]);
        assertEquals("Employer: Empfield", sA[3]);
        assertEquals( "Location: Locfield", sA[4]);
        assertEquals("Position Type: PTfield", sA[5] );
        assertEquals("Core Competency: CCfield", sA[6] );
    }

    @Test
    public void testDataNotAvailable(){
        Job job_eight = new Job( "", new Employer("Empfield"), new Location("Locfield"), new PositionType("PTfield"), new CoreCompetency("CCfield"));
        String[] sA = job_eight.toString().split("\n");
        assertEquals("Name: Data not available", sA[2]);

    }
}


