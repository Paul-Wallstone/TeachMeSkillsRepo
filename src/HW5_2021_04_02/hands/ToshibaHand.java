package HW5_2021_04_02.hands;

public class ToshibaHand implements IHand {
    private int price;

    public ToshibaHand(int price) {
        this.price = price;
    }

    public ToshibaHand() {
    }

    @Override
    public void upHand() {
        System.out.println("Toshiba hand move up!");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
