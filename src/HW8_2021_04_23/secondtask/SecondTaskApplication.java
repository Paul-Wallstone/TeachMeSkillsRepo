package HW8_2021_04_23.secondtask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SecondTaskApplication {
    public static void main(String[] args) {
        String line = "";
        try (BufferedReader fileReader = new BufferedReader(new FileReader(Paths.ORIGIN_FILE_PATH.getPath()));
             FileWriter fileWriter = new FileWriter(Paths.NEW_FILE_PATH.getPath())) {
            String[] strings;
            String stringOutPut = "";
            String stringInput = "";
            while ((line = fileReader.readLine()) != null) {
                stringInput += line;
            }
            String regex = "[.!?]";
            strings = stringInput.split(regex);
            for (int i = 0; i < strings.length; i++) {
                if (TextFormater.countWordsInString(strings[i]) ||
                        TextFormater.isStringHasPolindrome(strings[i])) {
                    stringOutPut += strings[i] + ".";
                }
            }
            fileWriter.write(stringOutPut);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
