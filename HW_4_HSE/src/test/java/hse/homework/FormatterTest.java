package hse.homework;

import hse.homework.format.Formatter;
import hse.homework.format.JsonCsvFormatter;
import hse.homework.format.JsonPrettyFormatter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormatterTest {
    @Test
    public void jsonCSVFormatterTest() {
        String inputJson = "[{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Adrien Runte\",\n" +
                "    \"company\": \"Hegmann LLC\"\n" +
                "}]";

        Formatter formatter = new JsonCsvFormatter();

        String response = formatter.format(inputJson);
        String expected = "id,name,company\n" +
                "1,\"Adrien Runte\",\"Hegmann LLC\"\n";
        assertEquals(expected, response);
    }

    @Test
    public void jsonPrettyFormatterTest() {
        String inputJson = "[{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Adrien Runte\",\n" +
                "    \"company\": \"Hegmann LLC\"\n" +
                "}]";

        Formatter formatter = new JsonPrettyFormatter();

        String response = formatter.format(inputJson);
        String expected = "[ {\r\n" +
                "  \"id\" : 1,\r\n" +
                "  \"name\" : \"Adrien Runte\",\r\n" +
                "  \"company\" : \"Hegmann LLC\"\r\n" +
                "} ]";
        assertEquals(expected, response);
    }
}
