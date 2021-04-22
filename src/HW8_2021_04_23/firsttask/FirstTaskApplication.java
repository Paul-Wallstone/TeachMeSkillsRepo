package HW8_2021_04_23.firsttask;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class FirstTaskApplication {
    public static void main(String[] args) {
//        В исходном файле находятся слова.
//        Каждое слово располагается на новой строке.
//        После запуска программы должен создаться файл, который будет содержать в себе только палиндромы.
        try (FileInputStream fis = new FileInputStream("src/HW8_2021_04_23/firsttask/InputOutputStreamFile.txt");
             FileOutputStream fos = new FileOutputStream("src/HW8_2021_04_23/firsttask/InputOutputStreamFileNew.txt")) {
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer, 0, buffer.length);
            String strOutputFromBuffer = "";
            String strInputFromBuffer = "";
            for (int i = 0; i < buffer.length; i++) {
                strInputFromBuffer += (char) buffer[i];
            }
            String[] strArray = strInputFromBuffer.split("\r\n");
            for (String str : strArray) {
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