package hse.homework;

import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static String inputName() {
        System.out.println("Введите ваше ФИО");
        String name;
        Scanner inputName = new Scanner(System.in);
        name = inputName.nextLine();
        return name;
    }

    public static Optional<LocalDate> inputBirthDate() {
        System.out.println("Введите вашу дату рождения, как дд.мм.гггг");
        try (Scanner scanner = new Scanner(System.in)) {
            String dateString = scanner.next();
            return parseBirthDate(dateString);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static Optional<LocalDate> parseBirthDate(String birthDate) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            return Optional.of(LocalDate.parse(birthDate, formatter));
        } catch (DateTimeParseException dtpe) {
            return Optional.empty();
        }
    }

    public static String getInitials(String str) {
        String[] strArr = str.split(" ");
        StringBuilder result = new StringBuilder(strArr[0] + " ");
        for (int i = 1; i < strArr.length; i++) {
            result.append(strArr[i].substring(0, 1).toUpperCase()).append(". ");
        }
        return result.toString().trim();
    }

    public static char getGender(String name) {
        if (name.trim().charAt(name.trim().length()-1) == 'а') {
            return 'Ж';
        }
        else {
            return 'М';
        }
    }

    public static String getAge(Optional<LocalDate> birthDate, LocalDate currentDate) {
        String undefinedAge = "Не определён";
        if (!birthDate.isPresent()) {
            return undefinedAge;
        }
        Period yearsOld = Period.between(birthDate.get(), currentDate);
        int yearsOldInt = yearsOld.getYears();
        if (yearsOldInt < 0) {
            return undefinedAge;
        }
        String yearsOldStr = String.valueOf(yearsOldInt);
        int indLastChar = yearsOldStr.length()-1;
        if (yearsOldStr.charAt(indLastChar) == '1') {
            return yearsOldStr + " год";
        }
        else if (yearsOldStr.charAt(indLastChar) == '2' || yearsOldStr.charAt(indLastChar) == '3' || yearsOldStr.charAt(indLastChar) == '4') {
            return yearsOldStr + " года";
        }
        else {
            return yearsOldStr + " лет";
        }
    }

    public static void main(String[] args) {
        String name = inputName();
        Optional<LocalDate> birthDate = inputBirthDate();
        System.out.println("ФИО с инициалами: " + getInitials(name));
        System.out.println("Пол: " + getGender(name));
        System.out.println("Возраст: " + getAge(birthDate, LocalDate.now()));
    }
}