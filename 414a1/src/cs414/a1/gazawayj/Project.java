package cs414.a1.gazawayj;

import java.util.HashSet;
import java.util.Set;

public class Project {
	
	private String name;
	private Company company;
	private ProjectSize size;
	private ProjectStatus status;
	private Set<Worker> members;
	private Set<Qualification> requirements;
	//TODO
	private Set<Qualification> missingReqs;
	
	//Constructor Overload ..  String n, Set<Worker> ws, Set<Qualification> qs, ProjectSize s
	public Project(String nm, Set<Worker> wrkrs, Set<Qualification> quals, ProjectSize sz, Company comp){
		name = nm;
		members = wrkrs;
		setCompany(comp);
		if (members == null) {
			members = new HashSet<Worker>();
		}
		requirements = quals;
		size = sz;
		// TODO double check on this part, if project status should be 'planned'
		// on construction. Also need to make sure all
		// associations are accounted for (Worker, Qualifications, etc)
		status = ProjectStatus.planned;
		missingReqs = new HashSet<Qualification>();
		//TODO make function to test reqs 
	}
	
	//This method will test if the quals are fulfilled and set to active if it is
	public boolean testQuals(){
		Set<Qualification> temp = new HashSet<Qualification>();
		for(Worker i : members){
			for (Qualification j : i.getQuals()){
				temp.add(j);
			}
		}
		//if all requirements are fulfilled set proj to active
		if (temp.containsAll(requirements) && members.size() > 0){
			setStatus(ProjectStatus.active);
		}
		return temp.containsAll(requirements);
	}
	
	public void setStatus(ProjectStatus ps){
		status = ps;
	}
	
	//Sets the ProjectStatus to finished. Removes the project from each worker's project list. Removes each worker from the project worker list.
	public void finishProject(){
		status = ProjectStatus.finished;
		Worker[] temp = members.toArray(new Worker[members.size()]);
		for (int i = 0; i < members.size(); i++){
			temp[i].removeFromProject(this);
		}
		members.clear();
	}
	
	public void removeMember(Worker w){
		System.out.println(members.remove(w));
	}
	
	
	//Compare the qualifications required by the project and those that are met by the workers who are members of the project. Return
	//the qualifications that are not met. An empty set (not null set) is returned when all the qualification requirements are met.
	public Set<Qualification> missingQualifications(){
		return null;
	}
	
	//If at least one of the missing qualification requirements of a project is satisfied by the worker, then return true, else return false.
	public boolean isHelpful( Worker w){
		return false;
	}
	
	public Set<Worker> getWorkers(){
		return members;
	}
	
	public Set<Qualification> getQuals(){
		return requirements;
	}
	
	public String getProjName(){
		return name;
	}
	
	public ProjectSize getProjSize(){
		return size;
	}
	
	public Company getCompany() {
		return company;
	}
	
	public ProjectStatus getStatus(){
		return status;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public String toString(){
		return name + " : " + members.size() + " : " + status;
	}

	public void addWorker(Worker w) {
		//TODO make sure there are no duplicates
		members.add(w);
	}
	
}

