package cs414.a1.gazawayj;


import java.util.HashSet;
import java.util.Set;

public class Qualification {

	private String description;
	private Set<Project> projects;
	private Set<Worker> workers;
	
	public Qualification(String desc){
		description = desc;
		if (desc == null){
			description = "";
		}
		projects = new HashSet<Project>();
		workers = new HashSet<Worker>();
	}
	
	public Set<Worker> getWorkers(){
		return workers;
	}
	
	public void addWorker(Worker w){
		workers.add(w);
	}
	
	public String getDesc(){
		return description;
	}
	
	public String toString(){
		return description;
	}

	public void removeWorker(Worker w) {
		workers.remove(w);
	}
	
	public boolean equals(Object obj){
		return ((((Qualification)obj).description == this.description) && (obj instanceof Qualification));
	}
}
