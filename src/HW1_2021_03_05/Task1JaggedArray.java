package HW1_2021_03_05;

import java.util.Arrays;

public class Task1JaggedArray {
    public static void main(String[] args) {
        int firstSize = (int) (Math.random() * 20);

        System.out.printf("Количество строк:%d \n", firstSize);
        int[][] array = new int[firstSize][];

        for (int i = 0; i < array.length; i++) {
            array[i] = new int[(int) (Math.random() * 20)];
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++)
                array[i][j] = (int) (-5 + Math.random() * 10);
        }
        for (int i = 0; i < array.length; i++)
            System.out.println(Arrays.toString(array[i]));
        System.out.println();
    }

    public String sd(int a, String r) {
        return null;
    }

    public String sd(String a, int r) {
        return null;
    }
}
