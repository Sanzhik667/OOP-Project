package View.ForAdmin ;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import System.ProjectSystem;
import Users.User;

public class AdminPage extends ProjectSystem
{
	
	private Map<String, User> usersDatabase;

	public AdminPage(){
		super();
		this.usersDatabase = new HashMap<>();
	}

	public AdminPage(User currentUser) {
		// TODO Auto-generated constructor stub
	}

	public void runAdminPanel(){
		Scanner scanner = new Scanner(System.in);
		boolean isRunning = true;

		while(isRunning){
			System.out.println("Welcome to Admin panel!");
			System.out.println("1. Add new user");
			System.out.println("2. Remove user");
			System.out.println("3. Update user");
			System.out.println("4. Show News");
			System.out.println("6. Exit");
			System.out.print("Choose one option: ");
			int choice = scanner.nextInt();

			switch(choice){
				case 1:
                    addUser(scanner);
                    break;
                case 2:
                    removeUser(scanner);
                    break;
                case 3:
                    updateUser(scanner);
                    break;
                case 4:
                	showNews();
				case 5: 
					isRunning = false;
					System.out.println("Exiting from admin panel.");
                default:
                    System.out.println("Invalid choice. Try again.");
			}
		}
	}
	
	public void addUser(Scanner scanner) {
		System.out.println("{Add new user}");
		System.out.println("Enter ID: ");
		String id = scanner.nextLine();
		System.out.println("Enter First name: ");
		String firstName = scanner.nextLine();
		System.out.println("Enter Last name: ");
		String lastName = scanner.nextLine();
		System.out.println("Enter email: ");
		String email = scanner.nextLine();
		System.out.println("Enter password: ");
		String password = scanner.nextLine();
		System.out.println("Enter role: ");
		String role = scanner.nextLine();

		User user = new User(id, firstName, lastName, email, password, role);
		if(usersDatabase.containsKey(id)){
			System.out.println("ERROR(this id already exist!)");
		}
		else{
			usersDatabase.put(id, user);
			System.out.println("Addition successful!");
		}
	}
	
	public void removeUser(Scanner scanner) {
		System.out.println("{Remove user}");
		System.out.println("Enter user ID: ");
		String id = scanner.nextLine();

		if(usersDatabase.remove(id) != null){
			System.out.println("The removal was successful!");
		}
		else{
			System.out.println("ERROR(this id does NOT exist!)");
		}
		
	}

	public void updateUser(Scanner scanner) {
		System.out.println("{Update user}");
		System.out.println("Enter user ID: ");
		String id = scanner.nextLine();

		if(!usersDatabase.containsKey(id)){
			System.out.println("ERROR(this id does NOT exist!)");
		}
		System.out.println("Enter new details for user: ");
		System.out.println("Enter new first name: ");
		String firstName = scanner.nextLine();
		System.out.println("Enter new last name: ");
		String lastName = scanner.nextLine();
		System.out.println("Enter new email: ");
		String email = scanner.nextLine();
		System.out.println("Enter new paswword: ");
		String password = scanner.nextLine();
		System.out.println("Enter new role: ");
		String role = scanner.nextLine();

		User updatedUser = new User(id, firstName, lastName, email, password, role);
		usersDatabase.put(id, updatedUser);
		System.out.println("The update was successful!");
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
	
	
	@Override
	public String toString() {
		// TODO implement me
		return "";	
	}
	
	// 
	
}

