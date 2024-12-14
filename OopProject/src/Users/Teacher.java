package Users;

import Enums.Title;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Teacher extends Employee
{
	private Title title;

	public Teacher(String firstName, String lastName, String email, String password, Title title) {
        super(firstName, lastName, email, password);
        this.title = title;
        // Устанавливаем флаг Researcher для профессора
        if (title == Title.PROFESSOR) {
            setResearcherStatus(true);
        }
    }

    public boolean isProfessor() {
        return title == Title.PROFESSOR;
    }
	
	
	
	public Teacher(){
		super();
	}

	
	
	
	
	
//	public void sendComplaints() {
//		// TODO implement me	
//	}
//
//	public void putMarks() {
//		// TODO implement me	
//	}
//
//	public void sendMessageToEmployee() {
//		// TODO implement me	
//	}
//
//	public void manageCourse() {
//		// TODO implement me	
//	}
	
}

