package HW1_2021_03_05;

import java.util.Collection;
import java.util.Scanner;


public class Task1_Operators_Console_1 {

    public static void main(String[] args) {
        String aStr;
        String bStr;
        String rStr;
        double a;
        double b;
        double r;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите сторону а:");
            aStr = sc.next();
            System.out.println("Введите сторону b:");
            bStr = sc.next();
            System.out.println("Введите радиус r:");
            rStr = sc.next();
        } while (!isNumber(aStr) || !isNumber(bStr) || !isNumber(rStr));

        a = Double.parseDouble(aStr);
        b = Double.parseDouble(bStr);
        r = Double.parseDouble(rStr);

        double squareRectangle = a * b;
        double squareCircle = Math.PI * Math.pow(r, 2);

        if (isRectangleClosed(a, b, r)) {
            System.out.printf("\nПлощадь прямоугольника =%.2f\n" +
                    "Площадь круга = %.2f\n" +
                    "Отверстие полностью закрыто!", squareRectangle, squareCircle);
        } else {
            System.out.printf("\nПлощадь прямоугольника =%.2f\n" +
                    "Площадь круга = %.2f\n" +
                    "Отверстие не закрыто!", squareRectangle, squareCircle);
        }

    }

    public static boolean isRectangleClosed(double a, double b, double r) {
        double squareRectangle = a * b;
        double squareCircle = Math.PI * Math.pow(r, 2);
        if (squareRectangle < squareCircle)
            return true;
        return false;
    }

    public static boolean isNumber(String num) {
        if (Character.isDigit(num.charAt(0)))
            return true;
        return false;
    }
}
