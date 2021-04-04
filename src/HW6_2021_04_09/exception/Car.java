package HW6_2021_04_09.exception;

import java.util.Random;

public class Car {
    private String brand;
    private int price;
    private int speed;

    {
        speed = 300;
        brand = "BMW";
        price = 50_000;
    }

    public Car(String brand, int price, int speed) {
        this.brand = brand;
        this.price = price;
        this.speed = speed;
    }

    public Car() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", speed=" + speed +
                '}';
    }

    public void start() throws CarException {
        Random random = new Random();
        if (random.nextInt(21) % 2 != 0) {
            System.out.println("Car " + this.getBrand() + " engine starts work!");
        } else {
            throw new CarException("Engine is not start!");
        }
    }

}
