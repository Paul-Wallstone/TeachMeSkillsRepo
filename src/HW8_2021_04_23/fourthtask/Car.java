package HW8_2021_04_23.fourthtask;

import java.io.Serializable;

public class Car implements Serializable {
    private String Brand;
    private int speed;
    private int price;

    public Car(String brand, int speed, int price) {
        Brand = brand;
        this.speed = speed;
        this.price = price;
    }

    public Car() {
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Brand='" + Brand + '\'' +
                ", speed=" + speed +
                ", price=" + price +
                '}';
    }
}
