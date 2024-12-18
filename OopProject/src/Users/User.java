package Users;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

import Users.Researcher.ResearchPaper;
import Users.Researcher.Researcher;

public class User implements Researcher, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
    private String role;
	private boolean isResearcher;  

	public User(String id, String email, String password, String firstName, String lastName, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }
	
	
	
    public void applyForResearcher() {
        this.isResearcher = true;
        System.out.println(firstName + " is now a Researcher!");
    }
    public boolean isResearcher() {
        return isResearcher;
    }

	public void setResearcherStatus(boolean status) { 
		this.isResearcher = status; 
	}
	
	public boolean getResearcherStatus() { return isResearcher; }

	public User() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printPapers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void conductResearch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void publishPaper(ResearchPaper paper) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ResearchPaper> getResearchPapers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printPapers(Comparator<ResearchPaper> comparator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int calculateHIndex() {
		// TODO Auto-generated method stub
		return 0;
	}
	public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }
 // Сеттеры
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + firstName + " " + lastName + ", Role: " + role;
    }
}
