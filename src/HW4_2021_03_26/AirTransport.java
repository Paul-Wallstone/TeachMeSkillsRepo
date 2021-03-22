package HW4_2021_03_26;

public class AirTransport extends Transport {
    private int wingspan;
    private int minLengthRunway;

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
        return super.info() + "5)Размах крыльев - " + getWingspan() + "м\n" + "6)Минимальная длина взлетно-посадочной полосы для взлета - " +
                getMinLengthRunway() + "м\n";
    }
}
