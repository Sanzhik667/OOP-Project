package View.ForStudent;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

import Data.Organizations;
import Data.Data;
import Enums.OrganizationName;
import System.ProjectSystem;
import Users.Student;
import Users.User;
import Users.News;

import java.util.List;
import java.util.Scanner;

public class StudentPage extends ProjectSystem {

    private Student currentStudent;
    private List<Organizations> organizationsList;

    public StudentPage(User currentUser) {
        super(currentUser);
        this.currentStudent = (Student) currentUser;
        this.organizationsList = Organizations.loadOrganizations();
    }

    @Override
    public void handleUserActions() {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.println("1. View Courses");
            System.out.println("2. View Transcript");
            System.out.println("3. Manage Organizations");
            System.out.println("4. Show News");
            System.out.println("5. Go Back");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewCourses();
                    break;
                case 2:
                    viewTranscript();
                    break;
                case 3:
                    manageOrganizations();
                    break;
                case 4:
                    showNews();
                    break;
                case 5:
                    isRunning = false; // Выход из текущего меню
                    goBack();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void goBack() {
        // TODO Auto-generated method stub
    }

    private void viewCourses() {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.println("** View Courses **");
            System.out.println("1. List All Courses");
            System.out.println("2. Search for a Course");
            System.out.println("3. Back");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listAllCourses();
                    break;
                case 2:
                    searchForCourse();
                    break;
                case 3:
                    isRunning = false; // Возврат в основное меню
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void listAllCourses() {
        System.out.println("Displaying all courses...");
        // Здесь можно реализовать логику вывода списка курсов из базы данных.
        System.out.println("1. Programming Basics");
        System.out.println("2. Data Structures");
        System.out.println("3. Algorithms");
        System.out.println("Press Enter to go back...");
        new Scanner(System.in).nextLine(); // Ждём нажатия Enter, чтобы вернуться
    }

    private void searchForCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter course name to search: ");
        String courseName = scanner.nextLine();
        // Здесь можно реализовать логику поиска курсов в базе данных.
        System.out.println("Searching for course: " + courseName);
        System.out.println("No results found. (Stub)");
        System.out.println("Press Enter to go back...");
        scanner.nextLine(); // Ждём нажатия Enter, чтобы вернуться
    }

    private void viewTranscript() {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.println("** View Transcript **");
            System.out.println("1. Show Grades");
            System.out.println("2. Download Transcript");
            System.out.println("3. Back");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showGrades();
                    break;
                case 2:
                    isRunning = false; // Возврат в основное меню
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void showGrades() {
        System.out.println("Displaying grades...");
        // Здесь можно реализовать вывод оценок студента из базы данных.
        System.out.println("Math: A");
        System.out.println("Programming: B+");
        System.out.println("Data Structures: A-");
        System.out.println("Press Enter to go back...");
        new Scanner(System.in).nextLine(); // Ждём нажатия Enter, чтобы вернуться
    }

    public void showNews() {
        if (Data.Newss.isEmpty()) {
            System.out.println("There is no news.");
        } else {
            System.out.println("Latest news: ");
            for (News news : Data.Newss) {
                System.out.println(news);
            }
        }
    }

    // Методы для управления организациями
    private void manageOrganizations() {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.println("** Manage Organizations **");
            System.out.println("1. Join Organization");
            System.out.println("2. Leave Organization");
            System.out.println("3. Become Organization Leader");
            System.out.println("4. View My Organizations");
            System.out.println("5. Back");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    joinOrganization(scanner);
                    break;
                case 2:
                    leaveOrganization(scanner);
                    break;
                case 3:
                    becomeLeader(scanner);
                    break;
                case 4:
                    viewMyOrganizations();
                    break;
                case 5:
                    isRunning = false; // Возврат в основное меню
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void joinOrganization(Scanner scanner) {
        System.out.println("Available Organizations:");
        for (OrganizationName name : OrganizationName.values()) {
            System.out.println("- " + name);
        }
        System.out.print("Enter the organization name to join: ");
        String orgName = scanner.nextLine().toUpperCase();

        try {
            OrganizationName organizationName = OrganizationName.valueOf(orgName);
            Organizations org = findOrganizationByName(organizationName);
            currentStudent.joinOrganization(org);
            Organizations.saveOrganizations(organizationsList);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid organization name.");
        }
    }

    private void leaveOrganization(Scanner scanner) {
        System.out.print("Enter the organization name to leave: ");
        String orgName = scanner.nextLine().toUpperCase();

        try {
            OrganizationName organizationName = OrganizationName.valueOf(orgName);
            Organizations org = findOrganizationByName(organizationName);
            currentStudent.leaveOrganization(org);
            Organizations.saveOrganizations(organizationsList);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid organization name.");
        }
    }

    private void becomeLeader(Scanner scanner) {
        System.out.print("Enter the organization name to become a leader: ");
        String orgName = scanner.nextLine().toUpperCase();

        try {
            OrganizationName organizationName = OrganizationName.valueOf(orgName);
            Organizations org = findOrganizationByName(organizationName);
            currentStudent.becomeLeader(org);
            Organizations.saveOrganizations(organizationsList);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid organization name.");
        }
    }

    private void viewMyOrganizations() {
        System.out.println("Your Organizations:");
        for (OrganizationName orgName : currentStudent.getOrganizations()) {
            System.out.println("- " + orgName);
        }
    }

    private Organizations findOrganizationByName(OrganizationName name) {
        for (Organizations org : organizationsList) {
            if (org.getOrganizationName() == name) {
                return org;
            }
        }
        Organizations newOrg = new Organizations(name);
        organizationsList.add(newOrg);
        return newOrg;
    }
}
