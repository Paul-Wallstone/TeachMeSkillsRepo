package HW4_2021_03_26;

public class FreightTransport extends LandTransport {
    private int LiftingCapacity;

    public FreightTransport(int horsePower, int maxSpeed, int weight, String brand, int numberOfWheels, int fuelConsumption, int liftingCapacity) {
        super(horsePower, maxSpeed, weight, brand, numberOfWheels, fuelConsumption);
        LiftingCapacity = liftingCapacity;
    }

    public int getLiftingCapacity() {
        return LiftingCapacity;
    }

    @Override
    public String info() {
        return super.info() + "8)Грузоподьемность - " + getLiftingCapacity() + "т.\n" + "9)Мощность - "
                + Math.round(super.kwConverter(super.getHorsePower())) + "кВч.\n";
    }

    public void isFull(int weightKilogram) {
        if (getLiftingCapacity() * 1000 >= weightKilogram) {
            System.out.println("Грузовик загружен");
        } else {
            System.out.println("Вам нужен грузовик побольше");
        }
    }
}
