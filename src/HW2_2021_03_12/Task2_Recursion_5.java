package HW2_2021_03_12;

public class Task2_Recursion_5 {
    public static void main(String[] args) {
        int number = 1297;
        int m=isNaturalNumber(number, number);
        if (isNaturalNumber(number, number) == 0) {
            System.out.printf("Is number %d simple - YES", number);
        } else System.out.printf("Is number %d simple - NO", number);
    }

    private static int isNaturalNumber(int num, int n) {
        int result = 0;
        if (num == 2)
            return 0;
        if (n == 2)
            return 0;
        if (num % (n - 1) == 0) {
            return 1;
        } else result += isNaturalNumber(num, n - 1);

        if (result == 0)
            return 0;
        else return 1;
    }
}
