package HW5_2021_04_02.heads;

public class SonyHead implements IHead {
    private int price;

    public SonyHead(int price) {
        this.price = price;
    }

    public SonyHead() {
    }

    @Override
    public void speak() {
        System.out.println("Sony head speak");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
