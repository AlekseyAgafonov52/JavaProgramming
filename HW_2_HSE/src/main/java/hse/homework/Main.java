package hse.homework;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.Character.isLetter;

public class Main {
    public static boolean fileExist(String fileName){
        File f = new File(fileName);
        return f.exists() && !f.isDirectory();
    }

    public static String inputFileName(String s) {
        String fileName = "";
        Scanner input = new Scanner(System.in);
        System.out.println(s);
        fileName = input.nextLine();
        return fileName;
    }

    public static ArrayList<Character> readFile(String fileName) {
        ArrayList<Character> res = new ArrayList<>();
        try (FileReader fr = new FileReader(fileName)) {
            int c;
            while ((c = fr.read()) != -1) res.add((char) c);
        } catch (IOException e) {
            System.out.println("I/O Error" + e);
        }
        return res;
    }

    public static void writeInFile(String fileName, Map<Character, Long> resultMap) {
        String res = resultMap.toString();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(res);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<Character, Long> countAggregate(ArrayList<Character> input) {
        return input.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static ArrayList<Character> charsOnly(ArrayList<Character> input) {
        ArrayList<Character> result = new ArrayList<Character>();
        for (char currentSymbol : input) {
            if (isLetter(currentSymbol)) {
                result.add(currentSymbol);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String fileName = inputFileName("В каком файле подсчитать все буквы?");
        boolean fe = fileExist(fileName);
        if (!fe) {
            System.exit(1);
        }
        ArrayList<Character> chars = readFile(fileName);
        chars = charsOnly(chars);
        String fileNameResult = inputFileName("В какой файл вывести результат?");
        writeInFile(fileNameResult, countAggregate(chars));
    }
}
