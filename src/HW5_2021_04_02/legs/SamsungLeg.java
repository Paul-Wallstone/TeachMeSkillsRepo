package HW5_2021_04_02.legs;

public class SamsungLeg implements ILeg {
    private int price;

    public SamsungLeg() {
    }

    public SamsungLeg(int price) {
        this.price = price;
    }

    @Override
    public void step() {
        System.out.println("Samsung leg make step");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
