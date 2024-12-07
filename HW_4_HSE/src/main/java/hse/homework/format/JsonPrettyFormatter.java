package hse.homework.format;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonPrettyFormatter implements Formatter {
    @Override
    public String format(String input) {
        String output;
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(input);
            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
            output = writer.writeValueAsString(jsonNode);
        } catch (Exception e) {
            System.out.println("Ошибка при обработке JSON: " + e.getMessage());
            throw new IllegalStateException(e.getMessage());
        }
        return output;
    }
}
