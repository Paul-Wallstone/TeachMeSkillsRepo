package HW5_2021_04_02.heads;

public class ToshibaHead implements IHead {
    private int price;

    public ToshibaHead(int price) {
        this.price = price;
    }

    public ToshibaHead() {
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
