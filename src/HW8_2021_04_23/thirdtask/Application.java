package HW8_2021_04_23.thirdtask;

import HW8_2021_04_23.secondtask.TextFormater;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        try (FileReader blackList = new FileReader("src/HW8_2021_04_23/thirdtask/BlackList.txt");
             FileReader censoredText = new FileReader("src/HW8_2021_04_23/thirdtask/censoredText.txt")) {
            String[] strings;
            String blackString = "";
            String censoredString = "";
            int c;
            while ((c = blackList.read()) != -1) {
                blackString += (char) c;
            }
            while ((c = censoredText.read()) != -1) {
                censoredString += (char) c;
            }
            CensureClass.startCensored(blackString, censoredString);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
