package System;

public class LanguageChoiceSaver {
    private static int languageChoice = 0;  // 0 означает, что язык еще не выбран

    public static int getLanguageChoice() {
        return languageChoice;
    }

    public static void setLanguageChoice(int choice) {
        languageChoice = choice;  // Сохраняем выбор языка
    }
}


