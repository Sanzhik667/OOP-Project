package Users;

import java.util.HashMap;
import java.util.Vector;

import Data.Course;
import Enums.Faculty;
import Enums.Id;
import wsp.Mark;
import wsp.Transcript;

public class Student extends User{
	private static final long serialVersionUID = 6860660265750071533L;
	private HashMap<Course,Teacher> teachers;
	private Faculty faculty;
	private Transcript transcript;
	protected int age;
	protected int phoneNumber;
	Vector<Course> course = new Vector<Course>();
	Vector<Mark> mark;
	Data data = Data.getInstance();
	
	public Student() {}
	public Student(String login,String password,String firstName, String lastName,int age,int phoneNumber,Vector<Mark> mark) {
		super(login,password,firstName,lastName);
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.mark = mark;
	}
	
	public Student(Id id, String firstName, String lastName, String email, String password) {
        super();
    }

   
}
