package HW4_2021_03_26;

public class PassengerTransport extends LandTransport {
    private String bоdyType;
    private int numOfPassengers;

    public PassengerTransport(int horsePower, int maxSpeed, int weight, String brand, int numberOfWheels, int fuelConsumption, String bоdy, int numOfPassengers) {
        super(horsePower, maxSpeed, weight, brand, numberOfWheels, fuelConsumption);
        this.bоdyType = bоdy;
        this.numOfPassengers = numOfPassengers;
    }

    public String getBоdyType() {
        return bоdyType;
    }

    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    @Override
    public String info() {
        return super.info() + "8)Тип кузова - " + getBrand() + "\n9)Количество пассажиров - " + getNumOfPassengers();
    }

    public void distanceAndFuelConsumptionCalc(int time) {
        int maxDistance = super.getMaxSpeed() * time;
        double consumption = maxDistance / 100 * super.getFuelConsumption();
        System.out.printf("За время %d ч, автомобиль %s, двигаясь с максимальной скоростью %d км/ч проедет " +
                        "%d км и израсходует %5.2f литров топлива.", time, super.getBrand(), super.getMaxSpeed(),
                maxDistance, consumption);
    }
}
