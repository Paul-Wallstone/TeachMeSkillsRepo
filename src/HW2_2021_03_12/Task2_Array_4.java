package HW2_2021_03_12;

import java.util.Arrays;
import java.util.Scanner;

public class Task2_Array_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int n = 0;

        do {
            System.out.println("Введите число больше 3:");
            n = sc.nextInt();
            if (n <= 3) {
                System.out.println("Число меньше 3!");
            }
        } while (n <= 3);

        int mas[] = new int[n];

        for (int i = 0; i < mas.length; i++) {
            mas[i] = (int) (Math.random() * (n + 1));
        }
        System.out.println(Arrays.toString(mas));

        int mas2[];
        do {
            if (count == 0)
                for (int i = 0; i < mas.length; i++) {
                    if (mas[i] % 2 == 0)
                        count++;
                }
            else {
                int j = 0;
                mas2 = new int[count];
                for (int i = 0; i < mas.length; i++) {
                    if (mas[i] % 2 == 0) {
                        mas2[j] = mas[i];
                        j++;
                    }
                }
                count = 0;
                System.out.println(Arrays.toString(mas2));
            }
        } while (count != 0);
    }
}
