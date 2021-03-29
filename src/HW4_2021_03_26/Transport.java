package HW4_2021_03_26;

public abstract class Transport {
    protected int horsePower;
    protected int maxSpeed;
    protected int weight;
    protected String brand;

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

    protected double kwConverter(int horsePower) {
        return horsePower / 07.4;
    }

    public abstract String info();

}
