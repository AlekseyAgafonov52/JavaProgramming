package hse.homework;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hse.homework.Main.*;

public class TestsHW3 {
    @Test
    void printGenderTest1(){
        String expected = "Ж";
        String actual = getGender("Иванова Мария Ивановна");
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void printGenderTest2(){
        String expected = "не определён";
        String actual = getGender("");
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void getAgeTest1(){
        Optional<LocalDate> birthDate = Optional.of(LocalDate.of(2005, 4, 15));
        LocalDate currentDate = LocalDate.parse("2024-11-09");
        String expected = "19 лет";
        String actual = getAge(birthDate, currentDate);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void getAgeTest2(){
        Optional<LocalDate> birthDate = Optional.of(LocalDate.of(2005, 12, 15));
        LocalDate currentDate = LocalDate.parse("2024-11-09");
        String expected = "18 лет";
        String actual = getAge(birthDate, currentDate);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void getAgeTest3() {
        Optional<LocalDate> birthDate = Optional.empty();
        LocalDate currentDate = LocalDate.parse("2024-11-09");
        String expected = "не определён";
        String actual = getAge(birthDate, currentDate);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void parseDateTest1() {
        String input = "1.1.1111";
        Optional<LocalDate> expected = Optional.empty();
        Optional<LocalDate> actual = parseBirthDate(input);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void parseDateTest2() {
        String input = "01.11.1111";
        Optional<LocalDate> expected = Optional.of(LocalDate.parse("1111-11-01"));
        Optional<LocalDate> actual = parseBirthDate(input);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void getInitialsTest1(){
        String name = "Агафонов Алексей Львович";
        String expected = "Агафонов А. Л.";
        String actual = getInitials(name);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void getInitialsTest2(){
        String name = "";
        String expected = "";
        String actual = getInitials(name);
        Assertions.assertEquals(actual, expected);
    }
}
