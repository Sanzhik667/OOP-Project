package Data;

import Enums.OrganizationName;
import Users.Student;

import java.io.*;
import java.util.*;

public class Organizations implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String FILE_PATH = "organizations.ser";

    private OrganizationName organizationName;
    private Set<String> members; // Хранит ID студентов
    private Set<String> leaders; // Хранит ID лидеров (максимум 2)

    public Organizations(OrganizationName organizationName) {
        this.organizationName = organizationName;
        this.members = new HashSet<>();
        this.leaders = new HashSet<>();
    }

    public OrganizationName getOrganizationName() {
        return organizationName;
    }

    public boolean addMember(Student student) {
        if (members.add(student.getId())) {
            System.out.println(student.getFirstName() + " joined " + organizationName);
            return true;
        } else {
            System.out.println("Student is already a member of " + organizationName);
            return false;
        }
    }

    public boolean removeMember(Student student) {
        if (members.remove(student.getId())) {
            leaders.remove(student.getId()); // Удаляем из лидеров, если студент был лидером
            System.out.println(student.getFirstName() + " left " + organizationName);
            return true;
        } else {
            System.out.println("Student is not a member of " + organizationName);
            return false;
        }
    }

    public boolean addLeader(Student student) {
        if (!members.contains(student.getId())) {
            System.out.println("Student must be a member before becoming a leader.");
            return false;
        }
        if (leaders.size() >= 2) {
            System.out.println("Error: An organization cannot have more than two leaders.");
            return false;
        }
        if (leaders.add(student.getId())) {
            System.out.println(student.getFirstName() + " is now a leader of " + organizationName);
            return true;
        } else {
            System.out.println("Student is already a leader of " + organizationName);
            return false;
        }
    }

    // Сохранение организаций в файл
    public static void saveOrganizations(List<Organizations> organizations) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(organizations);
            System.out.println("Organizations saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Загрузка организаций из файла
    public static List<Organizations> loadOrganizations() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Organizations>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existing organizations found. Initializing new list.");
            return new ArrayList<>();
        }
    }

    @Override
    public String toString() {
        return "Organization: " + organizationName + "\nMembers: " + members + "\nLeaders: " + leaders;
    }
}
