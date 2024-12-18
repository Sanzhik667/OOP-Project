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

