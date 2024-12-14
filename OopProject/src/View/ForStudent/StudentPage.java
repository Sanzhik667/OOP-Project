package View.ForStudent ;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

import java.util.Scanner;

import System.ProjectSystem;
import Users.User;

public class StudentPage extends ProjectSystem {

    public StudentPage(User currentUser) {
        super(currentUser);
    }

    @Override
    public void handleUserActions() {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            
            System.out.println("1. View Courses");
            System.out.println("2. View Transcript");
            System.out.println("3. Go Back");
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

    
}
