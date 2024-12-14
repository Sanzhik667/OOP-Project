package Users;

import java.util.Comparator;
import java.util.List;

import Users.Researcher.ResearchPaper;
import Users.Researcher.Researcher;

public class User implements Researcher{
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

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + firstName + " " + lastName + ", Role: " + role;
    }
}
