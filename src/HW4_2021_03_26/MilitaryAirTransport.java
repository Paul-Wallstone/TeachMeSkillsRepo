package HW4_2021_03_26;

public class MilitaryAirTransport extends AirTransport {
    private int numberOfRocket;
    private boolean IsEjectionSystem;

    public MilitaryAirTransport(int horsePower, int maxSpeed, int weight, String brand, int wingspan, int minLengthRunway, int numberOfRocket, boolean isEjectionSystem) {
        super(horsePower, maxSpeed, weight, brand, wingspan, minLengthRunway);
        this.numberOfRocket = numberOfRocket;
        IsEjectionSystem = isEjectionSystem;
    }

    public int getNumberOfRocket() {
        return numberOfRocket;
    }

    public boolean isEjectionSystem() {
        return IsEjectionSystem;
    }

    public void setNumberOfRocket(int numberOfRocket) {
        this.numberOfRocket = numberOfRocket;
    }

    @Override
    public String info() {
        return super.info() + "7)Количество ракет на борту - " + getNumberOfRocket() +
                "\n8)Наличие системы катапультирования - " + isEjectionSystem();
    }

    public void fire() {
        if (getNumberOfRocket() > 0) {
            System.out.println("Ракета пошла");
            setNumberOfRocket(getNumberOfRocket() - 1);
        } else {
            System.out.println("Боеприпасы отсутствуют");
        }
    }

    public void ejection() {
        if (isEjectionSystem()) {
            System.out.println("Катапультирование прошло успешно");
        } else {
            System.out.println("У Вас нет такой системы");
        }
    }
}

