package System;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LanguageManager {
    private Map<String, String> messages; // Хранилище текущих переводов
    public LanguageManager() {
        
    }

    
    
   
    public LanguageManager(String language) {
		// TODO Auto-generated constructor stub
	}

	


	public void selectLanguage() {
		Scanner scanner = new Scanner(System.in);
        System.out.println("Choose language / Выберите язык / Тілді таңдаңыз:");
        System.out.println("1. English\n2. Русский\n3. Қазақша");

        int choice = scanner.nextInt();
        LanguageChoiceSaver.setLanguageChoice(choice);
        loadMessages(choice);
    }
	 private void loadMessages(int choice) {
	        switch (choice) {
	            case 1:
	                loadEnglishMessages();
	                break;
	            case 2:
	                loadRussianMessages();
	                break;
	            case 3:
	                loadKazakhMessages();
	                break;
	            default:
	                loadEnglishMessages();
	        }
	    }
	//general
    // Метод для загрузки английских сообщений
    private void loadEnglishMessages() {
        messages = new HashMap<>();
        messages.put("welcome", "Welcome to the System!");
        messages.put("login_prompt", "Enter login:");
        messages.put("password_prompt", "Enter password:");
        messages.put("current_semester", "Current Semester:");
        messages.put("exit_prompt", "Do you want to exit? (yes/no)");
        messages.put("invalid", "Invalid login or password. Try again.");
        
    }

    // Метод для загрузки русских сообщений
    private void loadRussianMessages() {
        messages = new HashMap<>();
        messages.put("welcome", "Добро пожаловать в систему!");
        messages.put("login_prompt", "Введите логин:");
        messages.put("password_prompt", "Введите пароль:");
        messages.put("current_semester", "Текущий семестр:");
        messages.put("exit_prompt", "Хотите выйти? (да/нет)");
        messages.put("invalid", "Неверный логин или пароль. Попробуйте еще раз.");
    }

    // Метод для загрузки казахских сообщений
    private void loadKazakhMessages() {
        messages = new HashMap<>();
        messages.put("welcome", "Жүйеге қош келдіңіз!");
        messages.put("login_prompt", "Логин енгізіңіз:");
        messages.put("password_prompt", "Құпия сөзді енгізіңіз:");
        messages.put("current_semester", "Ағымдағы семестр:");
        messages.put("exit_prompt", "Шығуды қалайсыз ба? (иә/жоқ)");
        messages.put("invalid", "Логин немесе құпия сөз жарамсыз. Қайтадан көріңіз.");
    }

    // Получение перевода по ключу
    public String getMessage(String key) {
        return messages.getOrDefault(key, "Message not found!");
    }
    

    
}
