package HW6_2021_04_09.exception;

public class Application {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car("Audi", 200_000, 350);
        Car car3 = new Car("Opel", 20_000, 230);

        try {
            car1.start();
            car2.start();
            car3.start();
        } catch (CarException e) {
            System.out.println(e.getMessage());
        }
    }
}