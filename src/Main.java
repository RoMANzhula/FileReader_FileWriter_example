import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileNameFromReader = "example_C:/fileFrom.txt"; //создаем строковую переменную - имя файла, из которого будем считывать
        String fileNameToWriter = "example_C:/fileTo.txt"; //создаем строковую переменную - имя файла, в который будем записывать

        charFromFistFileToSecondFile(fileNameFromReader, fileNameToWriter); //вызываем метод копирования из файла в файл
        copyOnlyEvenCharacters(fileNameFromReader, fileNameToWriter); //вызываем метод для копирования четных символов из файла в файл
    }

    public static void charFromFistFileToSecondFile(String fileNameFromReader, String fileNameToWriter) throws IOException { //метод, который копирует символы из одного текстового
        //файла в другой (в варианте без блоков try-catch try-with-resource)

        FileReader fileReader = new FileReader(fileNameFromReader); //открываем поток для ввода(считывания) символьных(текстовых) данных
        FileWriter fileWriter = new FileWriter(fileNameToWriter); //открываем поток для вывода(записи) символьных(текстовых) данных

        while (fileReader.ready()) { //цикл будет работать пока есть символы для чтения
            int containerForChar = fileReader.read(); //в переменную-контейнер читаем по одному символу (char -> int)

            fileWriter.write(containerForChar); //пишем считанный символ в поток вывода(записи) символов
        }

        fileReader.close(); //очищаем ресурсы, закрываем поток ввода(чтения) символов
        fileWriter.close(); //очищаем ресурсы, закрываем поток вывода(записи) символов
    }

    public static void copyOnlyEvenCharacters(String fileNameFromReader, String fileNameToWriter) {
        try (FileReader fileReader = new FileReader(fileNameFromReader); //открываем поток для ввода(считывания) символьных(текстовых) данных
        FileWriter fileWriter = new FileWriter(fileNameToWriter)) {//открываем поток для вывода(записи) символьных(текстовых) данных

            int counterForWrite = 1; //создаем переменную-счетчик символов для записи (отсчет начинаем с 1)
            while (fileReader.ready()) { //цикл будет работать пока есть символы для чтения
                int containerForChar = fileReader.read(); //в переменную-контейнер читаем по одному символу (char -> int)

                if (counterForWrite % 2 == 0) { //если счетчик символов для записи будет четным (остаток от деления дает 0)
                    fileWriter.write(containerForChar); //пишем считанный символ в поток вывода(записи) символов
                }
                counterForWrite++; //увеличиваем счетчик символов для записи

            }

        } catch (IOException e) { //ловим исключения входных/выходных потоков
            e.printStackTrace(); //пишем исключение в стек
        }
    }
}