package Users ;

import Enums.Faculty;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class GraduateStudent extends Student
{
	private static final long serialVersionUID = 1L;
	public GraduateStudent(String id, String email, String password, String firstName, String lastName, String role,
            Faculty faculty, int age, int phoneNumber) {
 super(id, email, password, firstName, lastName, role, faculty, age, phoneNumber); // Вызов конструктора родителя

}
	@Override
	public boolean isResearcher() {
	        return true;  // Магистранты всегда исследователи
	}
//	public DegreeType DegreeType;
//	public Teacher superviser;
//	public ResearchProject diplome;
//	public  attribute;
//	
//	public GraduateStudent(){
//		super();
//	}
//
//	public DegreeType getDegreeType() {
//		// TODO implement me
//		return DegreeType.PHD;	
//	}
//	
//	public Teacher getsuperviser() {
//		// TODO implement me
//		return null;	
//	}
	
}

