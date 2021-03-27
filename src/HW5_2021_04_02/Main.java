package HW5_2021_04_02;

import HW5_2021_04_02.hands.SamsungHand;
import HW5_2021_04_02.hands.SonyHand;
import HW5_2021_04_02.hands.ToshibaHand;
import HW5_2021_04_02.heads.SamsungHead;
import HW5_2021_04_02.heads.SonyHead;
import HW5_2021_04_02.heads.ToshibaHead;
import HW5_2021_04_02.legs.SamsungLeg;
import HW5_2021_04_02.legs.SonyLeg;
import HW5_2021_04_02.legs.ToshibaLeg;

public class Main {
    public static void main(String[] args) {
        Robot robot1 = new Robot(new SamsungHead(100), new SonyLeg(50), new ToshibaHand(25));
        Robot robot2 = new Robot(new SonyHead(120), new ToshibaLeg(60), new SamsungHand(20));
        Robot robot3 = new Robot(new ToshibaHead(90), new SamsungLeg(65), new SonyHand(30));
        robot1.action();
        robot2.action();
        robot3.action();
        int maxPrice = Math.max(Math.max(robot1.getPrice(), robot2.getPrice()), robot3.getPrice());
        System.out.println("Max price: " + maxPrice);
    }
}
