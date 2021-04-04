package HW5_2021_04_02.legs;

public class SonyLeg implements ILeg{
    private int price;

    public SonyLeg(int price) {
        this.price = price;
    }

    public SonyLeg() {
    }

    @Override
    public void step() {
        System.out.println("Sony leg make step");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
