package HW8_2021_04_23.firsttask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FirstTaskApplication {
    public static void main(String[] args) {
//        В исходном файле находятся слова.
//        Каждое слово располагается на новой строке.
//        После запуска программы должен создаться файл, который будет содержать в себе только палиндромы.
        List<String> words = new ArrayList<String>();
        String line = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(Paths.ORIGIN_FILE_PATH.getPath()));
             FileOutputStream fos = new FileOutputStream(Paths.NEW_FILE_PATH.getPath())) {
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
            String strOutputFromBuffer = "";
            for (String str : words) {
                String strReverse = new StringBuilder(str).reverse().toString();
                if (str.equals(strReverse)) {
                    strOutputFromBuffer += str + "\r\n";
                }
            }
            fos.write(strOutputFromBuffer.getBytes(), 0, strOutputFromBuffer.length());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}