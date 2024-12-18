package System ;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Enums.Semester;
import Users.User;
import View.AdminPage;
import View.StudentPage;
import View.TeacherPage;

public class ProjectSystem extends Serializator{
	 // Ключ — логин, значение — объект User  
    protected User currentUser; // Логин текущего пользователя
    private Map<String, String> messages; // Карта сообщений
    private LanguageManager languageManager;
   

    public ProjectSystem() {
        // Инициализация LanguageManager в конструкторе
        languageManager = new LanguageManager();
        this.usersDatabase = new HashMap<>();
        initializeUsers(); // Заполняем базу данными
    }

    

    
    public ProjectSystem(User currentUser) {
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
            System.out.println(languageManager.getMessage("welcome") + currentUser.getFirstName() + "!");
            return true;
        }
        System.out.println(languageManager.getMessage("invalid"));
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
            	TeacherPage teacherPage = new TeacherPage(currentUser);
                teacherPage.handleUserActions();
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

      
        languageManager.selectLanguage(); // Выбор языка

        while (isRunning) {
            System.out.println(languageManager.getMessage("welcome"));
            System.out.println(languageManager.getMessage("current_semester") 
                               + " " + Semester.getCurrentSemester().getDescription());
            
            System.out.print(languageManager.getMessage("login_prompt"));
            String login = scanner.nextLine();
            System.out.print(languageManager.getMessage("password_prompt"));
            String password = scanner.nextLine();

            if (authenticate(login, password)) {
                handleUserActions();
            } 

            System.out.println(languageManager.getMessage("exit_prompt"));
            String exitInput = scanner.nextLine();
            isRunning = !exitInput.equalsIgnoreCase("yes") && !exitInput.equalsIgnoreCase("иә") && !exitInput.equalsIgnoreCase("да");
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



