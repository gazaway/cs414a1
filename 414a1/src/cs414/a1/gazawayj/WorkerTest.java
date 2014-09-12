package cs414.a1.gazawayj;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class WorkerTest {

	@Test
	public void testWorker() {
		setupTestEnviroment();
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
		assertTrue(temp1.toString().equals("One : 4 : 1 : 0"));
	}
	

	//Simply sets up the test enviroment
	public void setupTestEnviroment() {
		miss = new HashSet<Qualification>();
		qual1 = new Qualification("Heroe");
		qual2 = new Qualification("Noble");
		qual3 = new Qualification("Valiant");
		qual4 = new Qualification("asdt");
		quals = new Qualification("12345");
		set1 = new HashSet<Qualification>();
		set2 = new HashSet<Qualification>();
		set3 = new HashSet<Qualification>();
		set1.add(qual1);
		set2.add(qual1);
		set2.add(qual2);
		temp1 = new Worker("One", set1);
		temp2 = new Worker("Two", set2);
		//Have to make Worker sets
		ws1 = new HashSet<Worker>();
		ws2 = new HashSet<Worker>();
		ws1.add(temp1);
		ws2.add(temp1);
		ws2.add(temp2);
		//Have to make some projects to test overloaded   String n, Set<Worker> ws, Set<Qualification> qs, ProjectSize s
		proj1 = new Project("Project1", ws1, set2, ProjectSize.large, null);
		proj2 = new Project("Project2", ws2, set2, ProjectSize.medium, null);
		proj3 = new Project("Project3", ws1, set2, ProjectSize.large, null);
		//Proj4 has need quals: noble, valiant. Gets: noble
		proj4 = new Project("Project4", ws1, set2, ProjectSize.large, null);
		proj1.setStatus(ProjectStatus.active);
		proj2.setStatus(ProjectStatus.active);
		proj3.setStatus(ProjectStatus.active);
		proj4.setStatus(ProjectStatus.active);
	}

	//Needed variables
	Set<Worker> ws1;
	Set<Worker> ws2;
	Qualification qual1;
	Qualification qual2;
	Qualification qual3;
	Qualification qual4;
	Qualification quals;
	Set<Qualification> set1;
	Set<Qualification> set2;
	Set<Qualification> set3;
	Worker temp1;
	Worker temp2;
	Project proj1;
	Project proj2;
	Project proj3;
	Project proj4;
	Set<Qualification> miss;
}
