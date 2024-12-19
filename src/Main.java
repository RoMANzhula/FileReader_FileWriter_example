import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileNameFromReader = "example_C:/fileFrom.txt";
        String fileNameToWriter = "example_C:/fileTo.txt";
        String searchSameWordInFile = "example";

        charFromFistFileToSecondFile(fileNameFromReader, fileNameToWriter);
        copyOnlyEvenCharacters(fileNameFromReader, fileNameToWriter);
        outputTheNumberOfTheSameWord(fileNameFromReader, searchSameWordInFile);
    }

    public static void charFromFistFileToSecondFile(String fileNameFromReader, String fileNameToWriter) throws IOException {

        FileReader fileReader = new FileReader(fileNameFromReader);
        FileWriter fileWriter = new FileWriter(fileNameToWriter);

        while (fileReader.ready()) {
            int containerForChar = fileReader.read();

            fileWriter.write(containerForChar);
        }

        fileReader.close();
        fileWriter.close();
    }

    public static void copyOnlyEvenCharacters(String fileNameFromReader, String fileNameToWriter) {
        try (FileReader fileReader = new FileReader(fileNameFromReader);
        FileWriter fileWriter = new FileWriter(fileNameToWriter)) {

            int counterForWrite = 1;
            while (fileReader.ready()) {
                int containerForChar = fileReader.read();

                if (counterForWrite % 2 == 0) {
                    fileWriter.write(containerForChar);
                }
                counterForWrite++;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void outputTheNumberOfTheSameWord(String fileNameFromReader, String sameWord) { 
        try (FileReader fileReader = new FileReader(fileNameFromReader)) { 
            StringBuilder stringBuilder = new StringBuilder(); 
            int counterForConsoleOutput = 0; 

            while (fileReader.ready()) { 
                stringBuilder.append((char) fileReader.read()); 
            }

            String fromBuilderToString = stringBuilder.toString();

            String[] arrayOfWords = fromBuilderToString.split("[^A-Za-z0-9]");

            for (int i = 0; i < arrayOfWords.length; i++) {
                if (arrayOfWords[i].equals(sameWord)) { 
                    counterForConsoleOutput++; 
                }
            }

            System.out.println("Number of the same words: " + sameWord + "in file = " + counterForConsoleOutput); 

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
