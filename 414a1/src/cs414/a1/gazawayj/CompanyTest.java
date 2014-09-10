package cs414.a1.gazawayj;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class CompanyTest {

	/*@Test
	public void test() {
		Company comp = new Company("Jim");
		Qualification one = new Qualification("Manager");
		Set<Qualification> qual = new HashSet<Qualification>();
		qual.add(one);
		Worker jan = comp.createWorker("Jan", qual);
		Worker tim = comp.createWorker("Tim", qual);
		Set<Worker> workers = new HashSet<Worker>();
		workers.add(tim);
		Project jims = comp.createProject("Jim's Project", workers, qual, ProjectSize.large);
		Worker bob = comp.createWorker("Bob", qual);
		jims.addWorker(bob);
		jims.addWorker(tim);
		comp.hire(bob);
		jims.setStatus(ProjectStatus.active);
		Project another = comp.createProject("Bob's Project", workers, qual, ProjectSize.small);
		for (Project i : comp.getProjects()){
			System.out.println(i.toString());
			for (Worker j : i.getWorkers()){
				System.out.println('\t'+j.toString());
			}
		}
		System.out.println("_______________________________");
		comp.fire(bob);
		comp.hire(jan);
		another.addWorker(jan);
		another.testQuals();
		for (Project i : comp.getProjects()){
			System.out.println(i.toString());
			for (Worker j : i.getWorkers()){
				System.out.println('\t'+j.toString());
			}
		}*/
	@Test
	public void test() {
		Company comp = new Company("Jim");
		Company temp = new Company("Tim");
	}
}
