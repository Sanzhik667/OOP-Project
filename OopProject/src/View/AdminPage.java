package View ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import System.LanguageChoiceSaver;
import Users.User;

public class AdminPage implements Serializable {
	private static final long serialVersionUID = 1L;
	private Map<String, String> messages = new HashMap<>();
    private Map<String, User> usersDatabase = new HashMap<>();
    private final String FILE_NAME = "adminPage.dat"; 

    
    // Конструктор по умолчанию
    public AdminPage() {
        this.usersDatabase = new HashMap<>();
        loadState();
       
         
    }
    
    
    public AdminPage(User currentUser) {
		// TODO Auto-generated constructor stub
	}
    
    public void choosenLanguage() {
    	
    	
        switch (LanguageChoiceSaver.getLanguageChoice()) {
            case 1:
                loadEnglishMessages();
                break;
            case 2:
                loadRussianMessages();
                break;
            case 3:
                loadKazakhMessages();
                break;
          
        }
    }
    public String getMessage(String key) {
        return messages.getOrDefault(key, "Message not found!");
    }
    public void runAdminPanel() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        choosenLanguage(); // Установка языка
        while (isRunning) {
            System.out.println(getMessage("admin_panel_title") + ":");
            System.out.println("1. " + getMessage("add_user"));
            System.out.println("2. " + getMessage("remove_user"));
            System.out.println("3. " + getMessage("update_user"));
            System.out.println("4. " + getMessage("display_users"));
            System.out.println("5. " + getMessage("exit"));
            System.out.print(getMessage("choose_option"));

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
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
                    displayUsers(); // Отображение всех пользователей из файла
                    break;
                case 5:
                    isRunning = false;
                    System.out.println(getMessage("exiting_panel"));
                    break;
                default:
                    System.out.println(getMessage("invalid_choice"));
            }
        }
    }


	
   

    public void saveState() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(this);
            System.out.println(getMessage("state_saved_successfully"));
        } catch (IOException e) {
            System.out.println(getMessage("error_saving_state") + ": " + e.getMessage());
        }
    }

    public void loadState() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            AdminPage loaded = (AdminPage) ois.readObject();
            this.messages = loaded.messages;
            this.usersDatabase = loaded.usersDatabase;
            System.out.println(getMessage("state_loaded_successfully"));
        } catch (FileNotFoundException e) {
            System.out.println(getMessage("state_file_not_found"));
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(getMessage("error_loading_state") + ": " + e.getMessage());
        }
    }

    // Добавление нового пользователя
    public void addUser(Scanner scanner) {
        System.out.println(getMessage("add_user"));
        System.out.print(getMessage("enter_id"));
        String id = scanner.nextLine();

        System.out.print(getMessage("enter_first_name"));
        String firstName = scanner.nextLine();

        System.out.print(getMessage("enter_last_name"));
        String lastName = scanner.nextLine();

        System.out.print(getMessage("enter_email"));
        String email = scanner.nextLine();

        System.out.print(getMessage("enter_password"));
        String password = scanner.nextLine();

        System.out.print(getMessage("enter_role"));
        String role = scanner.nextLine();

        User user = new User(id, firstName, lastName, email, password, role);

        if (usersDatabase.containsKey(id)) {
            System.out.println(getMessage("error_user_exists"));
        } else {
            usersDatabase.put(id, user);
            saveState(); // Сохранение состояния после добавления пользователя
            System.out.println(getMessage("user_added_successfully"));
        }
    }
 // Удаление пользователя
    public void removeUser(Scanner scanner) {
        System.out.println(getMessage("remove_user"));
        System.out.print(getMessage("enter_id"));
        String id = scanner.nextLine();

        if (usersDatabase.containsKey(id)) {
            usersDatabase.remove(id);
            saveState(); // Сохранение состояния после удаления
            System.out.println(getMessage("user_removed_successfully"));
        } else {
            System.out.println(getMessage("error_user_not_found"));
        }
    }

    // Обновление информации пользователя
    public void updateUser(Scanner scanner) {
        System.out.println(getMessage("update_user"));
        System.out.print(getMessage("enter_id"));
        String id = scanner.nextLine();

        if (!usersDatabase.containsKey(id)) {
            System.out.println(getMessage("error_user_not_found"));
            return;
        }

        User user = usersDatabase.get(id);

        System.out.print(getMessage("enter_first_name") + " (" + user.getFirstName() + "): ");
        String firstName = scanner.nextLine();
        System.out.print(getMessage("enter_last_name") + " (" + user.getLastName() + "): ");
        String lastName = scanner.nextLine();
        System.out.print(getMessage("enter_email") + " (" + user.getEmail() + "): ");
        String email = scanner.nextLine();
        System.out.print(getMessage("enter_password") + " (" + user.getPassword() + "): ");
        String password = scanner.nextLine();
        System.out.print(getMessage("enter_role") + " (" + user.getRole() + "): ");
        String role = scanner.nextLine();

        if (!firstName.isEmpty()) {
			user.setFirstName(firstName);
		}
        if (!lastName.isEmpty()) {
			user.setLastName(lastName);
		}
        if (!email.isEmpty()) {
			user.setEmail(email);
		}
        if (!password.isEmpty()) {
			user.setPassword(password);
		}
        if (!role.isEmpty()) {
			user.setRole(role);
		}

        usersDatabase.put(id, user);
        saveState(); // Сохранение состояния после обновления
        System.out.println(getMessage("user_updated_successfully"));
    }

    // Отображение всех пользователей
    public void displayUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            AdminPage loaded = (AdminPage) ois.readObject();
            if (loaded.usersDatabase.isEmpty()) {
                System.out.println(getMessage("error_user_not_found"));
            } else {
                System.out.println(getMessage("display_users"));
                for (User user : loaded.usersDatabase.values()) {
                    System.out.println(user);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(getMessage("error_file_not_found"));
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(getMessage("error_reading_file") + ": " + e.getMessage());
        }
    }




  

    @Override
    public String toString() {
        return "AdminPage{usersDatabase=" + usersDatabase + '}';
    }
    
    
    
    
    
    
    
    //language
    private void loadEnglishMessages() {
        messages = new HashMap<>();
        messages.put("admin_panel_title", "Admin Panel");
        messages.put("add_user", "Add new user");
        messages.put("enter_id", "Enter ID: ");
        messages.put("enter_first_name", "Enter First name: ");
        messages.put("enter_last_name", "Enter Last name: ");
        messages.put("enter_email", "Enter email: ");
        messages.put("enter_password", "Enter password: ");
        messages.put("enter_role", "Enter role: ");
        messages.put("remove_user", "Remove user");
        messages.put("update_user", "Update user");
        messages.put("display_users", "Display all users");
        messages.put("exit", "Exit");
        messages.put("choose_option", "Choose an option: ");
        messages.put("exiting_panel", "Exiting from admin panel.");
        messages.put("invalid_choice", "Invalid choice. Try again.");
        messages.put("user_added_successfully", "User added successfully.");
        messages.put("error_user_exists", "Error: User with this ID already exists.");
        messages.put("error_user_not_found", "Error: User not found.");
        messages.put("user_removed_successfully", "User removed successfully.");
        messages.put("user_updated_successfully", "User updated successfully.");
        messages.put("state_saved_successfully", "State saved successfully.");
        messages.put("error_saving_state", "Error saving state");
        messages.put("state_loaded_successfully", "State loaded successfully.");
        messages.put("state_file_not_found", "State file not found. Starting with a new instance.");
        messages.put("error_loading_state", "Error loading state");
        messages.put("error_file_not_found", "Error: File not found. No users to display.");
        messages.put("error_reading_file", "Error reading file");

    }

    private void loadRussianMessages() {
        messages = new HashMap<>();
        messages.put("admin_panel_title", "Панель администратора");
        messages.put("add_user", "Добавить нового пользователя");
        messages.put("enter_id", "Введите ID: ");
        messages.put("enter_first_name", "Введите имя: ");
        messages.put("enter_last_name", "Введите фамилию: ");
        messages.put("enter_email", "Введите email: ");
        messages.put("enter_password", "Введите пароль: ");
        messages.put("enter_role", "Введите роль: ");
        messages.put("remove_user", "Удалить пользователя");
        messages.put("update_user", "Обновить пользователя");
        messages.put("display_users", "Показать всех пользователей");
        messages.put("exit", "Выйти");
        messages.put("choose_option", "Выберите опцию: ");
        messages.put("exiting_panel", "Выход из панели администратора.");
        messages.put("invalid_choice", "Неверный выбор. Попробуйте снова.");
        messages.put("user_added_successfully", "Пользователь успешно добавлен.");
        messages.put("error_user_exists", "Ошибка: Пользователь с таким ID уже существует.");
        messages.put("error_user_not_found", "Ошибка: Пользователь не найден.");
        messages.put("user_removed_successfully", "Пользователь успешно удалён.");
        messages.put("user_updated_successfully", "Информация о пользователе обновлена.");
        messages.put("state_saved_successfully", "Состояние успешно сохранено.");
        messages.put("error_saving_state", "Ошибка сохранения состояния");
        messages.put("state_loaded_successfully", "Состояние успешно загружено.");
        messages.put("state_file_not_found", "Файл состояния не найден. Создан новый экземпляр.");
        messages.put("error_loading_state", "Ошибка загрузки состояния");
        messages.put("error_file_not_found", "Ошибка: Файл не найден. Пользователей для отображения нет.");
        messages.put("error_reading_file", "Ошибка чтения файла");
    }

    private void loadKazakhMessages() {
        messages = new HashMap<>();
        messages.put("admin_panel_title", "Әкімші панелі");
        messages.put("add_user", "Жаңа пайдаланушы қосу");
        messages.put("enter_id", "ID енгізіңіз: ");
        messages.put("enter_first_name", "Аты-жөнін енгізіңіз: ");
        messages.put("enter_last_name", "Тегін енгізіңіз: ");
        messages.put("enter_email", "Электрондық пошта енгізіңіз: ");
        messages.put("enter_password", "Құпиясөз енгізіңіз: ");
        messages.put("enter_role", "Рөлін енгізіңіз: ");
        messages.put("remove_user", "Пайдаланушыны жою");
        messages.put("update_user", "Пайдаланушыны жаңарту");
        messages.put("display_users", "Барлық пайдаланушыларды көрсету");
        messages.put("exit", "Шығу");
        messages.put("choose_option", "Таңдауды енгізіңіз: ");
        messages.put("exiting_panel", "Әкімші панелінен шығу.");
        messages.put("invalid_choice", "Қате таңдау. Қайтадан көріңіз.");
        messages.put("user_added_successfully", "Пайдаланушы сәтті қосылды.");
        messages.put("error_user_exists", "Қате: Мұндай ID бар пайдаланушы қазірдің өзінде бар.");
        messages.put("error_user_not_found", "Қате: Пайдаланушы табылмады.");
        messages.put("user_removed_successfully", "Пайдаланушы сәтті жойылды.");
        messages.put("user_updated_successfully", "Пайдаланушы ақпараты жаңартылды.");
        messages.put("state_saved_successfully", "Сәтті сақталды.");
        messages.put("error_saving_state", "Сақтау қателігі");
        messages.put("state_loaded_successfully", "Мемлекет сәтті жүктелді.");
        messages.put("state_file_not_found", "Файл табылмады. Жаңа нұсқа жасалды.");
        messages.put("error_loading_state", "Жүктеу қателігі");
        messages.put("error_file_not_found", "Қате: Файл табылмады. Көрсетуге пайдаланушылар жоқ.");
        messages.put("error_reading_file", "Файлды оқу қатесі");
    }


}


