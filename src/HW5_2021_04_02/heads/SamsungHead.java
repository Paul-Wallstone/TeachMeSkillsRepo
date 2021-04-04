package HW5_2021_04_02.heads;

public class SamsungHead implements IHead {
    private int price;

    public SamsungHead(int price) {
        this.price = price;
    }

    public SamsungHead() {
    }

    @Override
    public void speak() {
        System.out.println("Samsung head speak");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
