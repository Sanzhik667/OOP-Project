package Main;

import System.ProjectSystem;

public class Main {
    public static void main(String[] args) {
        System.out.println("Initializing Project System...");
        
        // Создаем экземпляр системы
        ProjectSystem projectSystem = new ProjectSystem();
        
        // Запускаем основной цикл работы системы
        projectSystem.run();
        
        System.out.println("System terminated. Goodbye!");
    }
}

