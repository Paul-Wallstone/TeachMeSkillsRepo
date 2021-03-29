package HW4_2021_03_26;

public class AirTransport extends Transport {
    protected int wingspan;
    protected int minLengthRunway;

    public AirTransport(int horsePower, int maxSpeed, int weight, String brand, int wingspan, int minLengthRunway) {
        super(horsePower, maxSpeed, weight, brand);
        this.wingspan = wingspan;
        this.minLengthRunway = minLengthRunway;
    }

    public int getWingspan() {
        return wingspan;
    }

    public int getMinLengthRunway() {
        return minLengthRunway;
    }

    @Override
    public String info() {
        return "Характеристики воздушного транспорта:\n1)Мощность - " + getHorsePower() + "л.с.\n" +
                "2)Максимальная скорость - " + getMaxSpeed() + "км/ч\n" +
                "3)Масса - " + getWeight() + "кг.\n4)Марка - " + getBrand() + "\n" +
                "5)Размах крыльев - " + getWingspan() + "м\n" +
                "6)Минимальная длина взлетно-посадочной полосы для взлета - " +
                getMinLengthRunway() + "м\n";
    }
}
