package cs414.a1.gazawayj;

import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class ProjectTest {
	
	@Test
	public void testProj() {
		//setup enviro
		setupTestEnviroment();
		//test missingQualifications
		testMiss();
		//test isHelpful
		testHelp();
	}

	@Test
	public void testHelp() {
		
	}

	//Tests missing qualifications
	public void testMiss(){
		miss.add(qual2);
		miss.add(qual3);
		miss.add(qual4);
		//both sets are subsets of eachother, meaning that they contain the same elements
		assertTrue(miss.containsAll(proj1.missingQualifications()));
		assertTrue(proj1.missingQualifications().containsAll(miss));
	}
	
	//Simply sets up the test enviroment
	public void setupTestEnviroment() {
		miss = new HashSet<Qualification>();
		qual1 = new Qualification("Heroe");
		qual2 = new Qualification("Noble");
		qual3 = new Qualification("Valiant");
		qual4 = new Qualification("asdt");
		set1 = new HashSet<Qualification>();
		set2 = new HashSet<Qualification>();
		set3 = new HashSet<Qualification>();
		set1.add(qual1);
		set2.add(qual1);
		set2.add(qual2);
		set3.add(qual1);
		set3.add(qual2);
		set3.add(qual3);
		set3.add(qual4);
		temp1 = new Worker("One", set1);
		temp2 = new Worker("Two", set1);
		//Have to make Worker sets
		ws1 = new HashSet<Worker>();
		ws2 = new HashSet<Worker>();
		ws1.add(temp1);
		ws2.add(temp1);
		ws2.add(temp2);
		//Have to make some projects to test overloaded   String n, Set<Worker> ws, Set<Qualification> qs, ProjectSize s
		proj1 = new Project("Project1", ws1, set3, ProjectSize.large, null);
		proj2 = new Project("Project2", ws2, set3, ProjectSize.medium, null);
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
