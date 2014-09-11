package cs414.a1.gazawayj;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ProjectTest {

	@Test
	public void testProj() {
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
				//make sure equals reads bad input correctly
				assertFalse(temp1.equals(temp2));
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
	}

}
