package System ;


import java.util.HashMap;
import java.util.Scanner;

import Data.Data;
import Users.User;
import View.ForAdmin.AdminPage;
import View.ForStudent.StudentPage;

public class ProjectSystem extends Data{
	 // Ключ — логин, значение — объект User  
    protected User currentUser; // Логин текущего пользователя
    
    
    public ProjectSystem() {
        this.usersDatabase = new HashMap<>();
        initializeUsers(); // Заполняем базу данными
    }
    
    public ProjectSystem(User currentUser2) {
		// TODO Auto-generated constructor stub
	}

	private void initializeUsers() {
        usersDatabase.put("student1", new User("24B023421", "student1", "pass123", "John", "Doe", "Student"));
        usersDatabase.put("teacher1", new User("24A043234", "teacher1", "teach123", "Alice", "Smith", "Teacher"));
        usersDatabase.put("admin1", new User("24C423531", "admin1", "admin123", "Admin", "User", "Admin"));
    }
    
    // Аутентификация пользователя
    public boolean authenticate(String login, String password) {
        User user = usersDatabase.get(login);
        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            System.out.println("Welcome, " + currentUser.getFirstName() + "!");
            return true;
        }
        System.out.println("Invalid login or password. Try again.");
        return false;
    }

    // Получение роли текущего пользователя
    public String getCurrentUserRole() {
        if (currentUser != null) {
            return currentUser.getRole();
        }
        return null;
    }

    public User getCurrentUser() {
        return currentUser;
    }
    
    public void handleUserActions() {
        String role = getCurrentUserRole();
        if (role == null) {
            System.out.println("No role detected. Logging out...");
            return;
        }

        // Инициализация страницы в зависимости от роли
        switch (role) {
            case "Student":
                StudentPage studentPage = new StudentPage(currentUser);
                studentPage.handleUserActions();
                break;

            case "Teacher":
            	StudentPage studentPage = new StudentPage(currentUser);
                studentPage.handleUserActions();
                break;

            case "Admin":
            	AdminPage adminPage = new AdminPage(currentUser);
                adminPage.runAdminPanel();
            	
                break;

            default:
                System.out.println("Unknown role. Logging out.");
                break;
        }
    }

    // Основной цикл работы системы
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Welcome to the System!");
            System.out.print("Enter login: ");
            String login = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (authenticate(login, password)) {
                handleUserActions();
            } else {
                System.out.println("Login failed.");
            }

            System.out.println("Do you want to exit? (yes/no)");
            String exitInput = scanner.nextLine();
            isRunning = !exitInput.equalsIgnoreCase("yes");
        }

        System.out.println("System shutting down...");
    }
}


//private String currentRole; // Роль текущего пользователя (Student, Teacher, Admin и т.д.)
//private Page currentPage; // Текущая страница
//private boolean isRunning = true; // Указывает, активна ли система
//public System() {
//this.currentPage = new LoginPage(); // Начинаем с логина
//}

//public static void main(String[] args) {
//    System system = new System();
//    system.run();
//}
//public void listAllUsers() {
//    for (User user : usersDatabase.values()) {
//        System.out.println(user);
//    }
//}



