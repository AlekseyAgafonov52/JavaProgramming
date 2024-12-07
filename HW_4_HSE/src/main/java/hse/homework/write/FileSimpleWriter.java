package hse.homework.write;

import java.io.*;

public class FileSimpleWriter implements SimpleWriter {
    @Override
    public void write(String input) {
        String fileName = "./http_formatted_response.txt";
        File file = new File(fileName);

        if (file.exists()) {
            file.delete();
        }

        try (PrintStream out = new PrintStream(new FileOutputStream(fileName))) {
            out.print(input);
        }
        catch (Exception e) {
            throw new RuntimeException("Ошибка записи файла");
        }
    }
}
