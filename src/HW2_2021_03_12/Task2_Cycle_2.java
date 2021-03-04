package HW2_2021_03_12;

public class Task2_Cycle_2 {
    public static void main(String[] args) {
        int hour =3;
        while (hour<=24)  {

            System.out.printf("Количество клеток: %d - через %d часов\n",divideCell(1, hour),hour);
            hour+=3;
        }
    }

    private static int divideCell(int cell, int hour) {
        for (int i = 0; i < hour; i += 3) {
            cell *= 2;
        }
        return cell;
    }
}
