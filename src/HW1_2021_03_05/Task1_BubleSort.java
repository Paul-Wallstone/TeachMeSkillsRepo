package HW1_2021_03_05;

import java.util.Arrays;

public class Task1_BubleSort {
    public static void main(String[] args) {

        int array[] = new int[10];
        for (int i = 0; i < array.length; i++)
            array[i] = (int)(-5 + Math.random() * 10);
        System.out.println(Arrays.toString(array));
        // сортируем элементы
        // внешний цикл прохода
        for (int i = 0; i < array.length - 1; i++) {
            // внутренний цикл прохода
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    int tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(array));

    }
}
