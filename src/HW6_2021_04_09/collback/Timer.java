package HW6_2021_04_09.collback;

public class Timer {
    ITimer iTimer;

    public Timer(ITimer iTimer) {
        this.iTimer = iTimer;
    }

    public void timerGo() throws InterruptedException {
        while (true) {
            iTimer.callTimeMessage(10);
        }
    }
}
