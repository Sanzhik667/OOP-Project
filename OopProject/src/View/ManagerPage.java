package View;

import System.ProjectSystem;
import Users.User;

import java.util.Scanner;

public class ManagerPage extends ProjectSystem {

    public ManagerPage(User currentUser) {
        super(currentUser);
    }

    @Override
    public void handleUserActions() {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.println("Welcome to the Manager Panel!");
            System.out.println("1. Process Requests");
            System.out.println("2. View All Users");
            System.out.println("3. Manage Employees");
            System.out.println("4. Show News: ");
            System.out.println("5. Add new News: ")
            System.out.println("6. Go Back");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    processRequests();
                    break;
                case 2:
                    viewAllUsers();
                    break;
                case 3:
                    manageEmployees();
                    break;
                case 4:
                	showNews();
                case 5:
                	manageNews(scanner);
                case 6:
                    isRunning = false; // Выход из текущего меню
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } //
    }

    private void processRequests() {
        System.out.println("Processing requests...");
        // Заглушка для обработки запросов
        System.out.println("All pending requests have been processed.");
        goBack();
    }

    private void viewAllUsers() {
        System.out.println("Listing all users...");
        for (User user : usersDatabase.values()) {
            System.out.println(user);
        }
        goBack();
    }

    private void manageEmployees() {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.println("** Manage Employees **");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Go Back");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    removeEmployee();
                    break;
                case 3:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding a new employee...");
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter role: ");
        String role = scanner.nextLine();

        User employee = new User(id, email, password, firstName, lastName, role);
        if (usersDatabase.containsKey(id)) {
            System.out.println("ERROR: This ID already exists!");
        } else {
            usersDatabase.put(id, employee);
            System.out.println("Employee added successfully!");
        }
        goBack();
    }

    private void removeEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee ID to remove: ");
        String id = scanner.nextLine();

        if (usersDatabase.remove(id) != null) {
            System.out.println("Employee removed successfully!");
        } else {
            System.out.println("ERROR: This ID does not exist!");
        }
        goBack();
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
    
    public void manageNews(Scanner scanner) {
		System.out.println("{Add new News}");
		System.out.println("Enter title of the news: ");
		String title = scanner.nextLine();
		System.out.println("Enter content of the news: ");
		String content = scanner.nextLine();
		Data.Newss.add(new News(title, content));
		System.out.println("News added successful!");

    private void goBack() {
        System.out.println("Press Enter to go back...");
        new Scanner(System.in).nextLine();
    }
    
    //
   
}
