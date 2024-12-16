package Data;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Vector;

import Users.Admin;
import Users.Employee;
import Users.Manager;
import Users.Student;
import Users.Teacher;


public class Data implements Serializable{
	
    private static final long serialVersionUID = -3687448572749462892L;
	private static  Data Instance = new Data();
	
	private Data(){}
	
	public static Data getInstance() {
		return Instance;
	}
	
	
	
	public static HashSet<Employee> Employees = new HashSet<Employee>();
	public static HashSet<Admin> Admins = new HashSet<Admin>();
	public static HashSet<Manager> Managers = new HashSet<Manager>();
	public static HashSet<Teacher> Teachers = new HashSet<Teacher>();	
	public static HashSet<Student> Students = new HashSet<Student>();	
	public static Vector<Course> Courses = new Vector<Course>();	
	

	
	
	public  void serAll() throws IOException {
		serializeAdmin();
		serializeManager();
		serializeTeacher();
		serializeStudent();
		serializeCourses();

	}	
	
	public void desAll() throws ClassNotFoundException, IOException {
		deserializeAdmin();
		deserializeManager();
	
		deserializeTeacher();
		deserializeStudent();
		deserializeCourses();
	}
	
	
	
/*SERIALIZATION*/	
	/*USERS*/
	public void serializeAdmin() throws IOException {
		FileOutputStream fos = new FileOutputStream("admins");
		ObjectOutputStream admin = new ObjectOutputStream(fos);
		admin.writeObject(Admins);
		admin.flush();
		admin.close();
	}
	public void serializeManager() throws IOException {
		FileOutputStream fos = new FileOutputStream("managers");
		ObjectOutputStream manager = new ObjectOutputStream(fos);
		manager.writeObject(Managers);
		manager.flush();
		manager.close();
	}
	
	public void serializeTeacher() throws IOException {
		FileOutputStream fos = new FileOutputStream("teachers");
		ObjectOutputStream teacher = new ObjectOutputStream(fos);
		teacher.writeObject(Teachers);
		teacher.flush();
		teacher.close();
	}
	public  void serializeStudent() throws IOException {
		FileOutputStream fos = new FileOutputStream("students");
		ObjectOutputStream student = new ObjectOutputStream(fos);
		student.writeObject(Students);
		student.flush();
		student.close();
	}
	
	/*OTHER*/
	public void serializeCourses() throws IOException {
		FileOutputStream fos = new FileOutputStream("courses");
		ObjectOutputStream course = new ObjectOutputStream(fos);
		course.writeObject(Courses);
		course.flush();
		course.close();
	}
	
	
	
/*DESERIALIZATION*/
	/*USERS*/
	public HashSet<Admin> deserializeAdmin() throws IOException, ClassNotFoundException {
		try {
		FileInputStream fis = new FileInputStream("admins");
		ObjectInputStream admin = new ObjectInputStream(fis);
		Admins= (HashSet<Admin>)admin.readObject();
		admin.close();
		fis.close();
		}
		catch(EOFException e) {}
		return Admins;
	}
	public HashSet<Manager> deserializeManager() throws ClassNotFoundException, IOException {
		try {
		FileInputStream fis = new FileInputStream("managers");
		ObjectInputStream manager = new ObjectInputStream(fis);
		Managers = (HashSet<Manager>)manager.readObject();
		manager.close();
		fis.close();
		}
		catch(EOFException e) {}
		return Managers;
	}
	
	
	public HashSet<Teacher> deserializeTeacher() throws ClassNotFoundException, IOException {
		try {
		FileInputStream fis = new FileInputStream("teachers");
		ObjectInputStream teacher = new ObjectInputStream(fis);
		Teachers = (HashSet<Teacher>)teacher.readObject();
		teacher.close();
		fis.close();
		}
		catch(EOFException e) {}
		return Teachers;
	}

	public  HashSet<Student> deserializeStudent() throws IOException, ClassNotFoundException {
		try {
		FileInputStream fis = new FileInputStream("students");
		ObjectInputStream student  = new ObjectInputStream(fis);
		Students = (HashSet<Student>)student.readObject();
		student.close();
		fis.close();
		}
		catch(EOFException e) {}
		return Students;
	}
	
	
	/*OTHER*/	
	public Vector<Course> deserializeCourses() throws ClassNotFoundException, IOException {
		try {
		FileInputStream fis = new FileInputStream("courses");
		ObjectInputStream course = new ObjectInputStream(fis);
		Courses = (Vector<Course>)course.readObject();
		course.close();
		}
		catch(EOFException e) {}
		return Courses;
	}	
	
	
	
	public static Admin admin = new Admin();
	public static Manager manager = new Manager();
	public static Teacher teacher = new Teacher();
	public static Student student = new Student();

	public static Course course = new Course();
	
	
}

