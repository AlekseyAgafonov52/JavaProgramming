package hse.homework.write;

public class ConsoleSimpleWriter implements SimpleWriter {
    @Override
    public void write(String input) {
        System.out.println("===== Форматированный вывод =====");
        System.out.println(input);
    }
}
