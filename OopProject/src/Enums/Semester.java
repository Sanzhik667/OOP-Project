package Enums ;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
public enum Semester {
    SPRING("SPRING"),
    SUMMER("SUMMER"),
    AUTUMN("AUTUMN");

    private final String description;

    Semester(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    // Определение текущего семестра
    public static Semester getCurrentSemester() {
        int currentMonth = java.time.LocalDate.now().getMonthValue(); // Получаем текущий месяц (1–12)
        if (currentMonth >= 1 && currentMonth <= 5) {
            return SPRING;
        } else if (currentMonth >= 6 && currentMonth <= 8) {
            return SUMMER;
        } else {
            return AUTUMN;
        }
    }
}

