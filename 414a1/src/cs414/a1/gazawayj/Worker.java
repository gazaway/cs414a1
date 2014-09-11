package cs414.a1.gazawayj;
import java.util.HashSet;
import java.util.Set;

public class Worker {
	
	private String nickName;
	private int salary;
	private Company employer;
	private Set<Project> projects;
	private Set<Qualification> qualifications;
	private final int OVERLOADED_HOURS = 4;
	
	//Constructor override .. String nn, Set<Qualification> qs
	public Worker(String nn, Set<Qualification> qs, Company empl){
		nickName = nn;
		qualifications = qs;
		if (qs == null){
			qualifications = new HashSet<Qualification>();
		}
		employer = empl;
		salary = 0;
		projects = new HashSet<Project>();
		qualifications = new HashSet<Qualification>();
	}
	
	//Constructor override .. String nn, Set<Qualification> qs
	public Worker(String nn, Set<Qualification> qs){
		nickName = nn;
		qualifications = qs;
		if (qs == null){
			qualifications = new HashSet<Qualification>();
		}
		salary = 0;
		projects = new HashSet<Project>();
	}

	public Set<Qualification> getQuals(){
		return qualifications;
	}
	
	private int[] checkLoad(){
		int big = 0;
		int mid = 0;
		for (Project i : this.getProjects()){
			if ((i.getProjSize() == ProjectSize.large) && (i.getStatus() == ProjectStatus.active)){
				big++;
			}
			else if ((i.getProjSize() == ProjectSize.medium) && (i.getStatus() == ProjectStatus.active)){
				mid++;
			}
		}
		int[] temp = {big, mid};
		return temp;
	}
	
	//Returns true when a worker is overloaded, false otherwise. A constraint for the entire system is that no worker
	//should be overloaded. To determine overloading, consider all the active projects the worker is involved in. If
	//  1*number_of_big_projects + 2*number_of_medium projects is greater than 4, then the worker is overloaded.
	public boolean isOverLoaded(){
		int[] temp = checkLoad();
		int big = temp[0];
		int mid = temp[1];
		return ((1*big + 2*mid) > OVERLOADED_HOURS);
	}
	
	public void removeFromProject(Project proj){
		projects.remove(proj);
	}
	
	public Set<Project> getProjects(){
		return projects;
	}
	
	public String toString(){
		return nickName + " : " + projects.size() + " : " + qualifications.size() + " : " + salary;
	}

	public boolean canHandle(Project p) {
		int[] temp = checkLoad();
		if (p.getProjSize() == ProjectSize.large){
			temp[0]++;
		} 
		else if (p.getProjSize() == ProjectSize.medium){
			temp[1]++;
		}
		return ((1*temp[0] + 2*temp[1]) < OVERLOADED_HOURS);
	}

	public void addProject(Project p) {
		projects.add(p);
	}
	
	public boolean equals(Object obj){
		return ((((Worker)obj).nickName == this.nickName) && (obj instanceof Worker));
	}
	
	public int hashCode() {
		int hash = 3;
		hash = 7 * hash + this.nickName.hashCode();
		return hash;
	}
}
