package hse.homework;

import hse.homework.format.Formatter;
import hse.homework.format.JsonCsvFormatter;
import hse.homework.format.JsonPrettyFormatter;
import hse.homework.write.ConsoleSimpleWriter;
import hse.homework.write.FileSimpleWriter;
import hse.homework.write.SimpleWriter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

        URL QueryUrl;
        String response;
        Formatter formatter;
        SimpleWriter simpleWriter;
        String outputFormat;
        String outputWriter;

        if (args.length == 0) {
            outputFormat = "json";
            outputWriter = "console";
        }
        else {
            outputFormat = args[0];
            outputWriter = args[1];
        }

        try {
            QueryUrl = new URL("https://fake-json-api.mock.beeceptor.com/users");
            response = executeHttpQuery(QueryUrl);
        }
        catch (Exception e) {
            throw new RuntimeException("Ошибка при выполнении HTTP запроса");
        }

        switch (outputFormat) {
            case "json":
                formatter = new JsonPrettyFormatter();
                break;
            case "csv":
                formatter = new JsonCsvFormatter();
                break;
            default:
                throw new IllegalStateException("Неверный формат: " + outputFormat);
        }

        switch (outputWriter) {
            case "console":
                simpleWriter = new ConsoleSimpleWriter();
                break;
            case "file":
                simpleWriter = new FileSimpleWriter();
                break;
            default:
                throw new IllegalStateException("Неверный формат вывода: " + outputWriter);
        }

        String formattedResponse = formatter.format(response);
        simpleWriter.write(formattedResponse);
    }

    public static String executeHttpQuery(URL http) throws Exception {
        HttpURLConnection httpCon = (HttpURLConnection) http.openConnection();

        int responseStatus = httpCon.getResponseCode();

        long len = httpCon.getContentLengthLong();

        if (len == -1) {
            System.out.println("Длина содержимого недоступна.");
        }
        else {
            System.out.println("Длина содержимого: " + len);
        }

        if (responseStatus == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            return response.toString();
        }
        else {
            throw new RuntimeException("Запрос вернул некорректный статус: " + responseStatus);
        }
    }
}
