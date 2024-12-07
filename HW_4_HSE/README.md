Программа выполняет http запрос по адресу: адрес
Вывод ответа возможен в виде файла и в консоль, в форматах json и csv.
Тип вывода и формат задаются через параметры.
Допустимые форматы: json, csv.
Допустимые типы вывода: file, console.
Пример запуска:
java -jar .\HW_4_HSE-1.0-SNAPSHOT-jar-with-dependencies.jar json console
java -jar .\HW_4_HSE-1.0-SNAPSHOT-jar-with-dependencies.jar csv console
java -jar .\HW_4_HSE-1.0-SNAPSHOT-jar-with-dependencies.jar json file
java -jar .\HW_4_HSE-1.0-SNAPSHOT-jar-with-dependencies.jar csv file
При выборе вывода в файл происходит запись или перезапись файла http_formatted_response.txt в текущей директории.
