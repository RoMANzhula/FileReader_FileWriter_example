import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        charFromFistFileToSecondFile(); //вызываем метод копирования файла
    }

    public static void charFromFistFileToSecondFile() throws IOException { //метод, который копирует символы из одного текстового
        //файла в другой в варианте без блоков try-catch try-with-resource
        String fileNameFromReader = "example_C:/fileFrom.txt"; //создаем строковую переменную - имя файла, из которого будем считывать
        String fileNameToWriter = "example_C:/fileTo.txt"; //создаем строковую переменную - имя файла, в который будем записывать

        FileReader fileReader = new FileReader(fileNameFromReader); //открываем поток для ввода(считывания) символьных(текстовых) данных
        FileWriter fileWriter = new FileWriter(fileNameToWriter); //открываем поток для вывода(записи) символьных(текстовых) данных

        while (fileReader.ready()) { //цикл будет работать пока есть символы для чтения
            int containerForChar = fileReader.read(); //в переменную-контейнер читаем по одному символу (char -> int)

            fileWriter.write(containerForChar); //пишем считанный символ в поток вывода(записи) символов
        }

        fileReader.close(); //очищаем ресурсы, закрываем поток ввода(чтения) символов
        fileWriter.close(); //очищаем ресурсы, закрываем поток вывода(записи) символов
    }
}