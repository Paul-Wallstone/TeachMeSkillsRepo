package HW9_2021_05_07.concurrency;

import static java.lang.Thread.sleep;

public class JeweleryStore {

    //    В городе успешно работает ювелирный магазин, куда постоянно приходят клиенты.
//    Условием работы магазина является наличие 4 клиентов.
//    Одновременно в помещении может находиться не более 5 человек (покупателей).
//    Если в магазине становиться меньше 4 покупателей магазин закрывается на перерыв(10 секунд).
//    Каждый покупатель находится в магазине в промежутке от 1 до 8 сек.
    final int CAPACITY = 5;
    private int count = 0;
    
    public synchronized void getIn() {
        while (count >= CAPACITY) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
        System.out.println("Покупатель " + Thread.currentThread().getName() + " зашел");
        count++;
        System.out.println("Покупателей в магазине: " + count);
        if (count == 4) {
            System.out.println("Магазин работает нормально!");
        }
        notify();
    }

    public synchronized void getOut() throws InterruptedException {
        while (count <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
        count--;
        System.out.println("Покупатель " + Thread.currentThread().getName() + " вышел");
        System.out.println("Покупателей в магазине: " + count);
        if (count < 4 && count > 0) {
            System.out.println("В магазине перерыв на 10 секунд");
            sleep(10000);
        }
        notify();
    }
}
