package HW4_2021_03_26;

public class LandTransport extends Transport {
    protected int numberOfWheels;
    protected int fuelConsumption;

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
        return "Характеристики наземного транспорта:\n1)Мощность - " + getHorsePower() + "л.с.\n" +
                "2)Максимальная скорость - " + getMaxSpeed() + "км/ч\n" +
                "3)Масса - " + getWeight() + "кг.\n4)Марка - " + getBrand() + "\n" +
                "5)Количество колес - " + getNumberOfWheels() + "\n6)Расход топлива - " +
                getFuelConsumption() + "л. на 100 км\n";
    }
}
