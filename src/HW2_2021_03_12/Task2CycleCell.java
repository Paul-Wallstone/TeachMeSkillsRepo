package HW2_2021_03_12;

public class Task2CycleCell {
    public static void main(String[] args) {

        int cell = 1;

        for (int hour = 3; hour <= 24; hour += 3) {
            cell *= 2;
            System.out.printf("Количество клеток: %d - через %d часов\n", cell, hour);
        }
    }
}


