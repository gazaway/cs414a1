

import java.util.HashSet;
import java.util.Set;

public class Qualification {

	private String description;
	private Set<Project> projects;
	private Set<Worker> workers;
	
	public Qualification(String desc){
		description = desc;
		projects = new HashSet<Project>();
		workers = new HashSet<Worker>();
	}
	
	public Set<Worker> getWorkers(){
		return workers;
	}
	
	public String toString(){
		return description;
	}
}
