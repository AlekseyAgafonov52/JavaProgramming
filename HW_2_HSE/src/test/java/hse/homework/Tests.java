package hse.homework;

import org.junit.jupiter.api.Test;

import java.util.*;

import static hse.homework.Main.*;
import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Test
    void fileExistTest() {
        assertTrue(fileExist("src\\test\\resources\\abc.txt"));
    }

    @Test
    void readFileTest() {
        ArrayList<Character> actual = readFile("src\\test\\resources\\abc.txt");
        ArrayList<Character> expected = new ArrayList<>(Arrays.<Character>asList('a', 'b', 'c', 'A', '1', '2', '3'));
        assertArrayEquals(new ArrayList[]{actual}, new ArrayList[]{expected});
    }

    @Test
    void writeInFileTest() {
        Map<Character, Long> test = new HashMap<>();
        test.put('a', 1l);
        writeInFile("src\\test\\resources\\outputTest.txt", test);
        ArrayList<Character> actual = readFile("src\\test\\resources\\outputTest.txt");

        String fileContent = "{a=1}";
        ArrayList<Character> expected = new ArrayList<Character>();
        for (char c : fileContent.toCharArray()) {
            expected.add(c);
        }

        assertArrayEquals(new ArrayList[]{actual}, new ArrayList[]{expected});
    }

    @Test
    void charsOnlyTest() {
        ArrayList<Character> actual = charsOnly(readFile("src\\test\\resources\\abc.txt"));
        ArrayList<Character> expected = new ArrayList<>(Arrays.<Character>asList('a', 'b', 'c', 'A'));
        assertArrayEquals(new ArrayList[]{actual}, new ArrayList[]{expected});
    }
}