package HW4_2021_03_26;

public class Transport {
    private int horsePower;
    private int maxSpeed;
    private int weight;
    private String brand;

    public Transport(int horsePower, int maxSpeed, int weight, String brand) {
        this.horsePower = horsePower;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.brand = brand;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getWeight() {
        return weight;
    }

    public String getBrand() {
        return brand;
    }

    public double kwConverter(int horsePower) {
        return horsePower / 07.4;
    }

    public String info() {
        return "Характеристики транспорта:\n1)Мощность - " + getHorsePower() + "л.с.\n" +
                "2)Максимальная скорость - " + getMaxSpeed() + "км/ч\n" +
                "3)Масса - " + getWeight() + "кг.\n4)Марка - " + getBrand() + "\n";
    }
}
