package HW1_2021_03_05;

import java.util.Arrays;

public class Task1_JaggedArray_7 {
    public static void main(String[] args) {
        int firstSize = (int) (Math.random() * 20);
        int secondSize = (int) (Math.random() * 20);
        System.out.printf("Количество строк:%d \nКоличество столбцов:%d\n",firstSize,secondSize);
        int[][] array = new int[firstSize][secondSize];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++)
                array[i][j] = (int) (-100 + Math.random() * 100);
        }
        for (int i = 0; i < array.length; i++)
            System.out.println(Arrays.toString(array[i]));
        System.out.println();
    }
}
