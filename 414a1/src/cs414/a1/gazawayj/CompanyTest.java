package cs414.a1.gazawayj;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class CompanyTest {

	@Test
	public void testComp() {
		//setup enviro
		temp3 = setupTestEnviroment();
		//test tostring
		testString();
		//test hire
		testHire();
		//test fire
		testFire();
		//test start
		testStart(temp3);
		//testFinish
		testFinish();
	}
	
	//test finish method
	public void testFinish() {
		//finish project and make sure status is correct
		Project[] temp = comp.getProjects().toArray(new Project[comp.getProjects().size()]);
		comp.finish(temp[0]);
		assertTrue(temp[0].getStatus().toString().equals("suspended"));
	}

	public void testStart(Worker temp3) {
		Project[] temp = comp.getProjects().toArray(new Project[comp.getProjects().size()]);
		assertTrue(temp[0].getStatus() == ProjectStatus.suspended);
		comp.hire(temp3);
		comp.start(temp[0]);
		temp = comp.getProjects().toArray(new Project[comp.getProjects().size()]);
		//assertTrue(temp[0].getStatus() == ProjectStatus.active);
	}

	public void testFire() {
		//fire the company's only employee
		comp.fire(temp1);
		//Assert that the company shows as having no employees
		assertTrue(comp.toString().equals("Company One : 0 : 3"));
	}

	public void testHire() {
		//hire a worker and check tostring again
		comp.hire(temp1);
		assertTrue(comp.toString().equals("Company One : 1 : 3"));
		ws2.add(temp2);
		//Assert the worker list contains only the worker not hired by the company yet.
		assertTrue(comp.getWorkers().containsAll(ws2));
	}

	//test the company to string
	public void testString() {
		//assert tostring is correct string
		assertTrue(comp.toString().equals("Company One : 0 : 3"));
	}

	//Simply sets up the test enviroment
	public Worker setupTestEnviroment() {
		comp = new Company("Company One");
		miss = new HashSet<Qualification>();
		qual1 = new Qualification("Heroe");
		qual2 = new Qualification("Noble");
		qual3 = new Qualification("Valiant");
		qual4 = new Qualification("asdt");
		set1 = new HashSet<Qualification>();
		set2 = new HashSet<Qualification>();
		set3 = new HashSet<Qualification>();
		set4 = new HashSet<Qualification>();
		set1.add(qual1);
		set2.add(qual1);
		set2.add(qual2);
		set3.add(qual1);
		set3.add(qual2);
		set3.add(qual3);
		set3.add(qual4);
		set4.add(qual3);
		set4.add(qual4);
		set4.add(qual1);
		set4.add(qual2);
		temp1 = comp.createWorker("One", set1);
		temp2 = comp.createWorker("Two", set1);
		temp3 = comp.createWorker("Three", set4);
		//Have to make Worker sets
		ws1 = new HashSet<Worker>();
		ws2 = new HashSet<Worker>();
		ws1.add(temp1);
		proj1 = comp.createProject("proj1", ws1, set3, ProjectSize.small);
		proj2 = comp.createProject("Proj 2", ws1, set2, ProjectSize.small);
		proj3 = comp.createProject("Project 3", ws1, set1, ProjectSize.small);
		return temp3;
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
	Set<Qualification> set4;
	Worker temp1;
	Worker temp2;
	Worker temp3;
	Project proj1;
	Project proj2;
	Project proj3;
	Project proj4;
	Set<Qualification> miss;
	Company comp;
}