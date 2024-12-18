<<<<<<< HEAD
package Users;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import Enums.Id;
import Enums.OrganizationName;
import Data.Course;
import Data.Organizations;
import Enums.Faculty;
import wsp.Mark;
import wsp.Transcript;

public class Student extends User {
    private static final long serialVersionUID = 6860660265750071533L;

    private HashMap<Course, Teacher> teachers;
    private Faculty faculty;
    private Transcript transcript;
    protected int age;
    protected int phoneNumber;
    private Vector<Course> courses = new Vector<>();
    private Vector<Mark> marks = new Vector<>();
    private Vector<OrganizationName> organizations;

    public Student() {
        super();
        this.organizations = new Vector<>();
    }

    public Student(String login, String password, String firstName, String lastName, int age, int phoneNumber, Vector<Mark> marks) {
        super();
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.marks = marks;
        this.organizations = new Vector<>();
    }

    public Student(Id id, String firstName, String lastName, String email, String password) {
        super();
        this.organizations = new Vector<>();
    }

    public Vector<OrganizationName> getOrganizations() {
        return organizations;
    }

    // Добавление студента в организацию
    public void joinOrganization(Organizations org) {
        if (org.addMember(this)) {
            organizations.add(org.getOrganizationName());
        }
    }

    // Удаление студента из организации
    public void leaveOrganization(Organizations org) {
        if (org.removeMember(this)) {
            organizations.remove(org.getOrganizationName());
        }
    }

    // Назначение студента лидером организации
    public void becomeLeader(Organizations org) {
        if (org.addLeader(this)) {
            organizations.add(org.getOrganizationName());
        }
    }

    // Остальные методы твоего класса остаются без изменений
}
=======
package Users;

import java.io.Serializable;

import Enums.Faculty;

public class Student extends User implements Serializable {
    private static final long serialVersionUID = 6860660265750071533L;

    private Faculty faculty;
    protected int age;
    protected int phoneNumber;

    // Конструктор для класса Student
    public Student(String id, String email, String password, String firstName, String lastName, String role,
                   Faculty faculty, int age, int phoneNumber) {
        super(id, email, password, firstName, lastName, role); // Вызов конструктора родителя
        this.faculty = faculty;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    // Геттеры и сеттеры для новых полей
    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Переопределение метода toString() для удобного отображения данных студента
    @Override
    public String toString() {
        return "Student{" +
                "ID='" + getId() + '\'' +
                ", FirstName='" + getFirstName() + '\'' +
                ", LastName='" + getLastName() + '\'' +
                ", Email='" + getEmail() + '\'' +
                ", Role='" + getRole() + '\'' +
                ", Faculty=" + faculty +
                ", Age=" + age +
                ", PhoneNumber=" + phoneNumber +
                '}';
    }
}

>>>>>>> branch 'master' of https://github.com/Sanzhik667/OOP-Project.git
