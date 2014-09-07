package cs414.a1.gazawayj;
import java.util.HashSet;
import java.util.Set;

public class Company {
	
	private String name;
	private Set<Worker> workers;
	private Set<Project> projects;
	private Set<Worker> employees;
	
	public Company(String name_){
		name = name_;
		workers = new HashSet<Worker>();
		projects = new HashSet<Project>();
		employees = new HashSet<Worker>();
	}
	
	public Company(){
		name = "";
		workers = new HashSet<Worker>();
		projects = new HashSet<Project>();
		employees = new HashSet<Worker>();
	}
	//
	
	//Only non-employees can be hired. Is also added to all small projects that were planned or suspended because some qualifications
	//required in the project could not be previously satisfied, but can be partially or completely satisfied by this worker. If the
	//worker completely satisfies the remaining requirements, that project is marked active (i.e., the project is started). Otherwise,
	//the project remains planned or suspended.
	public void hire( Worker w){
		//TODO
		workers.add(w);
	}
	
	//Only employees can be fired. Remove the worker from the workers role of the company. If the worker was a member of any project, 
	//then delete the worker from that project. If the qualification requirements of that project are no longer met, that project is 
	//marked suspended. The worker is also removed from the list of workers for each of the qualifications this worker had.
	public void fire( Worker w){
		//TODO
		workers.remove(w);
	}
	
	//A planned or suspended project may be started as long as the project's qualification requirements are all satisfied. This project
	//is now in active status. Otherwise, the project remains planned or suspended (i.e., as it was before the method was called).
	public void start( Project p){
		if (p.getStatus() == ProjectStatus.suspended || p.getStatus() == ProjectStatus.planned){
			//returns true if quals are fulfilled, else false
			if (p.areQualsOkay()){
				p.setStatus(ProjectStatus.active);
			}
		}	
	}
	
	//An active project is marked finished. The project no longer has any workers as members. A suspended or planned project remains as it was.
	public void finish( Project p){
		if (p.getStatus() != ProjectStatus.suspended && p.getStatus() != ProjectStatus.planned){
			p.finishProject();
		}
	}
	
	//Creates a new worker with the given nn as nickname, and the set of qualifications. This worker is added to the list of workers. For each
	//qualification in the set qs, this method makes sure that the worker is added to the list of workers matching that qualification.
	public Worker createWorker( String nn, Set<Qualification> qs){
		//TODO add worker to quals in qs.
		Worker temp = new Worker(nn, qs, this);
		workers.add(temp);
		return temp;
	}
	
	//A new project is created and is entered in the list of projects carried out by the company. For each worker in ws, add the worker to the
	//members list of the project. For each qualification in qs, add the qualification in the qualification requirements list of the project. 
	//The project is marked as planned. The name and size of the project are also set. Only employees can be members of a project.
	public Project createProject( String n, Set<Worker> ws, Set<Qualification> qs, ProjectSize s){
		//TODO
		return new Project(n, ws, qs, s, this);
	}
	
	public String getName(){
		return name;
	}
	
	public Set<Worker> getWorkers(){
		return workers;
	}
	
	public Set<Project> getProjects(){
		return projects;
	}
	
	public String toString(){
		return name + " : " + workers.size() + " : " + projects.size();
	}
}
