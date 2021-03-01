package HW1_2021_03_05;

import java.util.Arrays;
import java.util.Scanner;

public class Task1_2DArray_6 {
    public static void main(String[] args) {

        int firstSize;
        int secondSize;

        do {
            System.out.println("Введите количество строк массива");
            Scanner sc = new Scanner(System.in);
            firstSize = sc.nextInt();
            System.out.println("Введите количество столбцов массива");
            secondSize = sc.nextInt();
        } while (!(firstSize>0)||!(secondSize>0));


        int[][] array = new int[firstSize][secondSize];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++)
                array[i][j] = (int) (-100 + Math.random() * 100);
        }
        for (int i = 0; i < array.length; i++)
            System.out.println(Arrays.toString(array[i]));
        System.out.println();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] % 2 == 0) {
                    System.out.print(0);
                } else
                    System.out.print(1);
            }
            System.out.println();
        }

    }

}
