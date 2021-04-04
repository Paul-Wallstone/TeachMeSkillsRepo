package HW6_2021_04_09.collback;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer(new EventTimer());
        timer.timerGo();
    }
}
