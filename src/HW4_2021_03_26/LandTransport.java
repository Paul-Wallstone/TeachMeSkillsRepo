package HW4_2021_03_26;

public class LandTransport extends Transport {
    private int numberOfWheels;
    private int fuelConsumption;

    public LandTransport(int horsePower, int maxSpeed, int weight, String brand, int numberOfWheels, int fuelConsumption) {
        super(horsePower, maxSpeed, weight, brand);
        this.numberOfWheels = numberOfWheels;
        this.fuelConsumption = fuelConsumption;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public String info() {
        return super.info() + "5)Количество колес - " + getNumberOfWheels() + "\n6)Расход топлива - " + getFuelConsumption() + "л. на 100 км\n";
    }
}
