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
