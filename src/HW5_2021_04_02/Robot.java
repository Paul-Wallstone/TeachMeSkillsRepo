package HW5_2021_04_02;

import HW5_2021_04_02.hands.IHand;
import HW5_2021_04_02.heads.IHead;
import HW5_2021_04_02.legs.ILeg;

public class Robot implements IRobot {
    private IHead iHead;
    private ILeg iLeg;
    private IHand iHand;

    public Robot(IHead iHead, ILeg iLeg, IHand iHand) {
        this.iHead = iHead;
        this.iLeg = iLeg;
        this.iHand = iHand;
    }

    public IHead getiHead() {
        return iHead;
    }

    public void setiHead(IHead iHead) {
        this.iHead = iHead;
    }

    public ILeg getiLeg() {
        return iLeg;
    }

    public void setiLeg(ILeg iLeg) {
        this.iLeg = iLeg;
    }

    public IHand getiHand() {
        return iHand;
    }

    public void setiHand(IHand iHand) {
        this.iHand = iHand;
    }

    @Override
    public void action() {
        iHand.upHand();
        iHead.speak();
        iLeg.step();
    }

    @Override
    public int getPrice() {
        return iHand.getPrice() + iHead.getPrice() + iLeg.getPrice();
    }
}
