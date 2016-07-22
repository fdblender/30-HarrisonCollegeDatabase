package UnitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import customTools.CourseDB;
import model.Henrollment;

public class EnrollmentTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		long eid = 3L;
		Henrollment enrollment = CourseDB.getEnrollment(eid);
		System.out.println(enrollment.getGrade());
		
	}

}
