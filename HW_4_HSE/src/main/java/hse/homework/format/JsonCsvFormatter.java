package hse.homework.format;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class JsonCsvFormatter implements Formatter {
    @Override
    public String format(String input) {
        OutputStream output = new ByteArrayOutputStream();
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(input);
            CsvSchema.Builder csvSchemaBuilder = CsvSchema.builder();
            JsonNode firstObject = jsonNode.elements().next();
            firstObject.fieldNames().forEachRemaining(fieldName -> {csvSchemaBuilder.addColumn(fieldName);} );
            CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();

            CsvMapper csvMapper = new CsvMapper();
            csvMapper.writerFor(JsonNode.class)
                    .with(csvSchema)
                    .writeValue(output, jsonNode);
        } catch (Exception e) {
            System.out.println("Ошибка при обработке JSON: " + e.getMessage());
            throw new IllegalStateException(e.getMessage());
        }
        return output.toString();
    }

}
