package cs414.a1.gazawayj;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runners.JUnit4;

public class QualificationTest {

	@Test
	public void testQual() {
		//Construct two Quals
		Qualification qual1 = new Qualification("Test");
		Qualification qual2 = new Qualification("TestAgain");
		// Assert that qual1 is an instance of Qual
		assertTrue(qual1 instanceof Qualification);
		//Test equals method
		testEquals(qual1, qual2);
		//Test toString
		testString(qual1);
	}
	
	public void testEquals(Qualification qual1, Qualification qual2){
		// Assert that equals reads bad input correctly
		assertFalse(qual1.equals(qual2));
		// Change qual2 "into" qual1
		qual2 = new Qualification("Test");
		// Assert that quals reads good input correctly
		assertTrue(qual1.equals(qual2));
	}
	
	public void testString(Qualification qual1){
		assertTrue(qual1.toString().equals("Test"));
	}
}
