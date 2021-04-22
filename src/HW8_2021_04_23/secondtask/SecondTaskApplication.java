package HW8_2021_04_23.secondtask;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SecondTaskApplication {
    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("src/HW8_2021_04_23/secondtask/SecondTaskFile.txt");
             FileWriter fileWriter = new FileWriter("src/HW8_2021_04_23/secondtask/SecondTaskFile_New.txt")) {
            String[] strings;
            String stringOutPut = "";
            String stringInput = "";
            int c;
            while ((c = fileReader.read()) != -1) {
                stringInput += (char) c;
            }
            String regex = "[.!?]";
            strings = stringInput.split(regex);
            for (int i = 0; i < strings.length; i++) {
                if (TextFormater.countWordsInString(strings[i]) >= 3 &&
                        TextFormater.countWordsInString(strings[i]) <= 5 ||
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
