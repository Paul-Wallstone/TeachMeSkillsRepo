package HW5_2021_04_02.hands;

public class SonyHand implements IHand {
    private int price;

    public SonyHand(int price) {
        this.price = price;
    }

    public SonyHand() {
    }

    @Override
    public void upHand() {
        System.out.println("Sony hand move up!");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
