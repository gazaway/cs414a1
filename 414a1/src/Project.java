
import java.util.HashSet;
import java.util.Set;

public class Project {
	
	private String name;
	private Company company;
	private ProjectSize size;
	private ProjectStatus status;
	private Set<Worker> members;
	private Set<Qualification> requirements;
	
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


	public void setCompany(Company company) {
		this.company = company;
	}


	public String toString(){
		return name + " : " + members.size() + " : " + status;
	}
	
}

