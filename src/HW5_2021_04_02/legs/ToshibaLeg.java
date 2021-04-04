package HW5_2021_04_02.legs;

public class ToshibaLeg implements ILeg {
    private int price;

    public ToshibaLeg(int price) {
        this.price = price;
    }

    public ToshibaLeg() {
    }

    @Override
    public void step() {
        System.out.println("Toshiba leg make step");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
