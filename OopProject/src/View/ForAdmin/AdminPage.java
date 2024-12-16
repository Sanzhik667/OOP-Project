package View.ForAdmin ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import System.ProjectSystem;
import Users.User;

public class AdminPage extends ProjectSystem {
    private Map<String, User> usersDatabase;
    private final String FILE_PATH = "usersDatabase.ser"; // Файл для хранения пользователей

    public AdminPage() {
        super();
        this.usersDatabase = new HashMap<>();
        loadUsers(); // Загрузка данных при инициализации
    }

    public AdminPage(User currentUser) {
        this();
    }

    public void runAdminPanel() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Welcome to Admin panel!");
            System.out.println("1. Add new user");
            System.out.println("2. Remove user");
            System.out.println("3. Update user");
            System.out.println("4. Display all users");
            System.out.println("5. Exit");
            System.out.print("Choose one option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

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
                    displayUsers();
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("Exiting from admin panel.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public void addUser(Scanner scanner) {
        System.out.println("{Add new user}");
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        if (usersDatabase.containsKey(id)) {
            System.out.println("ERROR (this ID already exists!)");
            return;
        }

        System.out.print("Enter First name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter role: ");
        String role = scanner.nextLine();

        User user = new User(id, firstName, lastName, email, password, role);
        usersDatabase.put(id, user);
        saveUsers(); // Сохранение в файл
        System.out.println("Addition successful!");
    }

    public void removeUser(Scanner scanner) {
        System.out.println("{Remove user}");
        System.out.print("Enter user ID: ");
        String id = scanner.nextLine();

        if (usersDatabase.remove(id) != null) {
            saveUsers(); // Сохранение изменений
            System.out.println("The removal was successful!");
        } else {
            System.out.println("ERROR (this ID does NOT exist!)");
        }
    }

    public void updateUser(Scanner scanner) {
        System.out.println("{Update user}");
        System.out.print("Enter user ID: ");
        String id = scanner.nextLine();

        if (!usersDatabase.containsKey(id)) {
            System.out.println("ERROR (this ID does NOT exist!)");
            return;
        }

        System.out.println("Enter new details for user:");
        System.out.print("Enter new first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter new last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        System.out.print("Enter new password: ");
        String password = scanner.nextLine();
        System.out.print("Enter new role: ");
        String role = scanner.nextLine();

        User updatedUser = new User(id, firstName, lastName, email, password, role);
        usersDatabase.put(id, updatedUser);
        saveUsers(); // Сохранение изменений
        System.out.println("The update was successful!");
    }

    public void displayUsers() {
        System.out.println("{Display all users}");
        if (usersDatabase.isEmpty()) {
            System.out.println("No users available.");
        } else {
            for (User user : usersDatabase.values()) {
                System.out.println(user);
            }
        }
    }

    private void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(usersDatabase);
        } catch (IOException e) {
            System.out.println("ERROR: Failed to save users to file.");
            e.printStackTrace();
        }
    }

    private void loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            usersDatabase = (Map<String, User>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Файл ещё не создан - игнорируем
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("ERROR: Failed to load users from file.");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "AdminPage{usersDatabase=" + usersDatabase + '}';
    }
}

