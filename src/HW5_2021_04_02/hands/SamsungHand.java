package HW5_2021_04_02.hands;

public class SamsungHand implements IHand {
    private int price;

    public SamsungHand(int price) {
        this.price = price;
    }

    public SamsungHand() {
    }

    @Override
    public void upHand() {
        System.out.println("Samsung hand move up!");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
