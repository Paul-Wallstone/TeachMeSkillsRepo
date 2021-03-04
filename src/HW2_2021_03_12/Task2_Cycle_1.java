package HW2_2021_03_12;

public class Task2_Cycle_1 {
    public static void main(String[] args) {
        double initialDistance = 1000.0;

        System.out.println(Math.round(training(initialDistance, 7)));

    }

    private static double training(double distance, int days) {
        for (int i = 0; i < days; i++) {
            distance *= 1.1;
        }
        return distance;
    }
}
