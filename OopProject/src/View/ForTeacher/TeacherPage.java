package View.ForTeacher ;

import java.util.Scanner;

import System.ProjectSystem;
import Users.User;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class TeacherPage extends ProjectSystem {

    public TeacherPage(User currentUser) {
        super(currentUser);
    }

    @Override
    public void handleUserActions() {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.println("Welcome to the Teacher Panel!");
            System.out.println("1. Manage Courses");
            System.out.println("2. Assign Grades");
            System.out.println("3. View Students");
            System.out.println("4. Show News: ");
            System.out.println("5. Go Back");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manageCourses();
                    break;
                case 2:
                    assignGrades();
                    break;
                case 3:
                    viewStudents();
                    break;
                case 4:
                	showNews();
                case 5:
                    isRunning = false; // Exit the loop to go back
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void manageCourses() {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.println("** Manage Courses **");
            System.out.println("1. List All Courses");
            System.out.println("2. Add New Course");
            System.out.println("3. Remove Course");
            System.out.println("4. Go Back");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listAllCourses();
                    break;
                case 2:
                    addNewCourse();
                    break;
                case 3:
                    removeCourse();
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void listAllCourses() {
        System.out.println("Listing all courses...");
        // Здесь можно реализовать вывод списка курсов из базы данных
        System.out.println("1. Introduction to Programming");
        System.out.println("2. Data Structures");
        System.out.println("3. Algorithms");
        goBack();
    }

    private void addNewCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding a new course...");
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.println("Course \"" + courseName + "\" has been added successfully!");
        goBack();
    }

    private void removeCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the course to remove: ");
        String courseName = scanner.nextLine();
        System.out.println("Course \"" + courseName + "\" has been removed successfully!");
        goBack();
    }

    private void assignGrades() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();
        System.out.println("Grade \"" + grade + "\" assigned to " + studentName + " for the course \"" + courseName + "\".");
        goBack();
    }

    private void viewStudents() {
        System.out.println("Listing all students...");
        // Здесь можно добавить логику для вывода списка студентов
        System.out.println("1. John Doe");
        System.out.println("2. Alice Johnson");
        System.out.println("3. Bob Smith");
        goBack();
    }

    private void goBack() {
        System.out.println("Press Enter to go back...");
        new Scanner(System.in).nextLine();
    }
    
    public void showNews() {
		if(Data.Newss.isEmpty()){
			System.out.println("There is no news.");
		}
		else {
			System.out.println("Latest news: ");
			for(News news : Data.Newss) {
				System.out.println(news);
			}
		}
	}
}