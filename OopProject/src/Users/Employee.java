package Users;

public class Employee extends User{

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(String firstName, String lastName, String email, String password) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void applyForResearcher() {
	    setResearcherStatus(true);
	    // Логика проверки или подачи заявки 
	}
}
