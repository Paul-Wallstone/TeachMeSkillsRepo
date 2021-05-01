package HW8_2021_04_23.thirdtask;

import HW8_2021_04_23.secondtask.TextFormater;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        String line = "";
        try (BufferedReader blackList = new BufferedReader(new FileReader(Paths.ORIGIN_FILE_PATH.getPath()));
             BufferedReader censoredText = new BufferedReader(new FileReader(Paths.NEW_FILE_PATH.getPath()))) {
            String[] strings;
            String blackString = "";
            String censoredString = "";

            while ((line = blackList.readLine()) != null) {
                blackString += line+"\r\n";
            }
            while ((line = censoredText.readLine()) != null) {
                censoredString += line;
            }
            CensureClass.startCensored(blackString, censoredString);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
