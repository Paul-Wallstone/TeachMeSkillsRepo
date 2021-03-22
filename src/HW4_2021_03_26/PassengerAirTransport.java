package HW4_2021_03_26;

public class PassengerAirTransport extends AirTransport {
    private int numberOfPassengers;
    private boolean isBusinessClass;

    public PassengerAirTransport(int horsePower, int maxSpeed, int weight, String brand, int wingspan, int minLengthRunway, int numberOfPassengers, boolean isBusinessClass) {
        super(horsePower, maxSpeed, weight, brand, wingspan, minLengthRunway);
        this.numberOfPassengers = numberOfPassengers;
        this.isBusinessClass = isBusinessClass;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public boolean isBusinessClass() {
        return isBusinessClass;
    }

    @Override
    public String info() {
        return super.info() + "7)Количество пасажиров - " + getNumberOfPassengers() + "\n8)Наличие бизнес-класса - " + isBusinessClass;
    }

    public void isFull(int passengers) {
        if (getNumberOfPassengers() >= passengers) {
            System.out.println("Самолет загружен");
        } else {
            System.out.println("Вам нужен самолет побольше");
        }
    }
}
