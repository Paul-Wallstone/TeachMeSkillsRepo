package HW8_2021_04_23.fourthtask;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Application {
    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/HW8_2021_04_23/fourthtask/car.dat"))) {
            Car car1 = new Car("BMW", 270, 50000);
            oos.writeObject(car1);
            System.out.println("File has been written");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Car car2 = new Car();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/HW8_2021_04_23/fourthtask/car.dat"))) {

            car2 = ((Car) ois.readObject());
            System.out.println("File has been read");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(car2.toString());
    }
}

