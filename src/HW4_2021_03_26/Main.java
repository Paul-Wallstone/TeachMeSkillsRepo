package HW4_2021_03_26;

public class Main {
    public static void main(String[] args) {
        MilitaryAirTransport militaryAirTransport = new MilitaryAirTransport(3000, 2100, 15,
                "F-16", 25, 1000, 9, true);
        PassengerAirTransport passengerAirTransport = new PassengerAirTransport(5000, 1300, 200,
                "Boeing-747", 120, 1500, 465, true);
        PassengerTransport passengerTransport = new PassengerTransport(220, 230, 3000, "Scania",
                4, 40, "Bus", 25);
        FreightTransport freightTransport = new FreightTransport(1000, 100, 5000, "Volvo",
                4, 50, 2);
        System.out.println(passengerTransport.info());
        System.out.println();
        System.out.println(freightTransport.info());
        System.out.println();
        System.out.println(militaryAirTransport.info());
        System.out.println();
        System.out.println(passengerAirTransport.info() + "\n");
        freightTransport.isFull(1500);
        System.out.println();
        passengerTransport.distanceAndFuelConsumptionCalc(20);
        System.out.println("\n");
        militaryAirTransport.ejection();
        militaryAirTransport.fire();
        System.out.println();
        passengerAirTransport.isFull(600);
    }
}
