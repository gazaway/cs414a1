package cs414.a1.gazawayj;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class WorkerTest {

	@Test
	public void testWorker() {
		//Construct some quals -- already been tested in testing suite
		Qualification qual1 = new Qualification("Heroe");
		Qualification qual2 = new Qualification("Noble");
		Qualification qual3 = new Qualification("Valiant");
		Set<Qualification> set1 = new HashSet<Qualification>();
		set1.add(qual1);
		set1.add(qual2);
		Set<Qualification> set2 = new HashSet<Qualification>();
		set2.add(qual2);
		set2.add(qual3);
		Worker temp1 = new Worker("One", set1);
		Worker temp2 = new Worker("Two", set2);
		//Have to make Worker sets
		Set<Worker> ws1 = new HashSet<Worker>();
		Set<Worker> ws2 = new HashSet<Worker>();
		ws1.add(temp1);
		ws2.add(temp1);
		ws2.add(temp2);
		//Have to make some projects to test overloaded   String n, Set<Worker> ws, Set<Qualification> qs, ProjectSize s
		Project proj1 = new Project("Project1", ws2, set2, ProjectSize.large, null);
		Project proj2 = new Project("Project2", ws2, set2, ProjectSize.medium, null);
		Project proj3 = new Project("Project3", ws1, set2, ProjectSize.large, null);
		Project proj4 = new Project("Project4", ws1, set2, ProjectSize.large, null);
		proj1.setStatus(ProjectStatus.active);
		proj2.setStatus(ProjectStatus.active);
		proj3.setStatus(ProjectStatus.active);
		proj4.setStatus(ProjectStatus.active);
		//Test Overload
		testOverload(temp1, temp2);
		//Test Equals
		testEquals(temp1, temp2, set1);
		// Assert that the toString method works
		testString(temp1);
	}
	
	public void testOverload(Worker temp1, Worker temp2){
		//Assert that temp1 is overloaded & temp2 isn't
		assertTrue(temp1.isOverLoaded());
		assertFalse(temp2.isOverLoaded());
	}
	
	public void testEquals(Worker temp1, Worker temp2, Set<Qualification> set1){
		//Make sure equals behaves as should with bad input
		assertFalse(temp1.equals(temp2));
		temp2 = new Worker("One", set1);
		// Assert that equals works with correct input
		assertTrue(temp1.equals(temp2));
	}
	
	public void testString(Worker temp1){
		assertTrue(temp1.toString().equals("One : 4 : 2 : 0"));
	}
}
