package HW9_2021_05_07.concurrency;

public class Application {
    public static void main(String[] args) {
        JeweleryStore jeweleryStore = new JeweleryStore();
        int i = 1;
        while (i != 10) {
            i++;
            new Thread(new Consumers(jeweleryStore), i + "").start();
        }
    }
}
