package hse.homework;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static hse.homework.Main.*;

public class TestsHW3 {
    @Test
    void printGenderTest(){
        char expected = 'Ж';
        char actual = getGender("Иванова Мария Ивановна");
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void getDateBirthTest1(){
        LocalDate dateBirth = LocalDate.of(2005, 4, 15);
        String expected = "19 лет";
        String actual = getDateBirth(dateBirth);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void getDateBirthTest2(){
        LocalDate dateBirth = LocalDate.of(2005, 12, 15);
        String expected = "18 лет";
        String actual = getDateBirth(dateBirth);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void getInitialsTest(){
        String name = "Агафонов Алексей Львович";
        String expected = "Агафонов А. Л.";
        String actual = getInitials(name);
        Assertions.assertEquals(actual, expected);
    }
}
