package HW1_2021_03_05;

import java.util.*;

public class Task1Array {
    public static void main(String[] args) {
        // через коллекцию ArraList
        List<Double> arrayList = new ArrayList<>(10);
        //Через обычный массив
        double sum = 0;
        double multiply = 1;
        double array[] = new double[10];
        Random random = new Random();
        System.out.println("1 способ\n");
        //первый способ
        //добавляем элементы
        for (int i = 0; i < 10; i++)
            arrayList.add(-5 + Math.random() * 10);

        System.out.println(arrayList.toString());

        // сортируем элементы
        Collections.sort(arrayList);

        for (double box : arrayList) {
            if (box > Collections.min(arrayList) && box < Collections.max(arrayList)) {
                if (box < 0)
                    sum += box;
                multiply *= box;
            }

        }
        System.out.println(sum);
        System.out.println(multiply);
        System.out.println(arrayList.toString());

        sum = 0;
        multiply = 1;

        System.out.println("\n2 способ\n");

        //Второй способ
        for (int i = 0; i < array.length; i++)
            array[i] = (-5 + Math.random() * 10);
        System.out.println(Arrays.toString(array));
        // сортируем элементы
        for (int i = 0; i < array.length; i++) {
            double min = array[i];
            int min_i = i;
            for (int j = i + 1; j < array.length; j++) {
                //Если находим, запоминаем его индекс
                if (array[j] < min) {
                    min = array[j];
                    min_i = j;
                }
            }
            array[min_i] = array[i];
            array[i] = min;
        }

        for (int i = 1; i < array.length - 1; i++) {

            if (array[i] < 0)
                sum += array[i];
            multiply *= array[i];

        }


        System.out.println(sum);
        System.out.println(multiply);
        System.out.println(Arrays.toString(array));

    }
}
