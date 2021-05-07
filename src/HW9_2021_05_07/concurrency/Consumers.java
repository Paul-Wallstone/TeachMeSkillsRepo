package HW9_2021_05_07.concurrency;

import java.util.Random;

import static java.lang.Thread.sleep;

public class Consumers implements Runnable {
    private JeweleryStore jeweleryStore;

    public Consumers(JeweleryStore jeweleryStore) {
        this.jeweleryStore = jeweleryStore;
    }

    @Override
    public void run() {
        jeweleryStore.getIn();
        Random random = new Random();
        int sleep = (random.nextInt(8) + 1);
        System.out.println("Клиент " + Thread.currentThread().getName() + " находится в магазине " + sleep
                + " секунд");
        try {
            Thread.sleep(sleep * 1000);
            jeweleryStore.getOut();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
