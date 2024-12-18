package Data ;

import java.io.Serializable;

import Enums.CourseType;
import Enums.Faculty;
import Enums.Semester;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Course implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String courseName;
	public Faculty school;
	public CourseType courseType;
	public String courseId;
	public int yearOfStudy;
	public Semester semester;
//	public Vector enrolledStudents;
//	public vector teachers;
	public Course(String courseName, Faculty school, CourseType courseType, String courseId, int yearOfStudy, Semester semester){
		this.courseName = courseName;
		this.school = school;
		this.courseType = courseType;
		this.courseId = courseId;
		this.yearOfStudy = yearOfStudy;
		this.semester = semester;
	}
	
	public Course(){
		
	}
	
	

	
}

