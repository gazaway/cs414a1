package cs414.a1.gazawayj;

import java.util.HashSet;
import java.util.Set;

public class Worker {
	
	private String nickName;
	private int salary;
	private Company employer;
	private Set<Project> projects;
	private Set<Qualification> qualifications;
	
	//Constructor override .. String nn, Set<Qualification> qs
	public Worker(String nn, Set<Qualification> qs, Company empl){
		nickName = nn;
		qualifications = qs;
		employer = empl;
		//TODO double check on this part to make sure salary should, in fact, be $0 on worker construction
		salary = 0;
		projects = new HashSet<Project>();
		qualifications = new HashSet<Qualification>();
	}
	
	//Returns true when a worker is overloaded, false otherwise. A constraint for the entire system is that no worker
	//should be overloaded. To determine overloading, consider all the active projects the worker is involved in. If
	//  1*number_of_big_projects + 2*number_of_medium projects is greater than 4, then the worker is overloaded.
	public boolean isOverLoaded(){
		return false;
	}
	
	public String toString(){
		return nickName + " : " + projects.size() + " : " + qualifications.size() + " : " + salary;
	}
}
