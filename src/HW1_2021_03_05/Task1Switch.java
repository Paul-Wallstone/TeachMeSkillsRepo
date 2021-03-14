package HW1_2021_03_05;

import java.util.Scanner;

public class Task1Switch {
    public static void main(String[] args) {
        String n;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Введите число меньше 10 и больше 0");
            n = sc.next();
        } while (!isNumber(n) || !isCorrect(n));

        switch (Integer.parseInt(n)) {
            case 1:
                System.out.println("Понедельник!");
                break;
            case 2:
                System.out.println("Втоник!");
                break;
            case 3:
                System.out.println("Среда!");
                break;
            case 4:
                System.out.println("Четверг!");
                break;
            case 5:
                System.out.println("Пятница!");
                break;
            case 6:
                System.out.println("Суббота!");
                break;
            case 7:
                System.out.println("Воскресенье!");
                break;
            default:
                System.out.println("Нет такого дня недели!");
        }
    }

    public static boolean isNumber(String num) {
        if (Character.isDigit(num.charAt(0)))
            return true;
        return false;
    }

    public static boolean isCorrect(String num) {
        int num1 = Integer.parseInt(num);
        if (num1 < 10 && num1 > 0)
            return true;
        return false;
    }
}
