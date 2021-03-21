package HW3_2021_03_19;

import java.util.Scanner;
import java.util.SortedMap;

public class Computer {
    private String cpuType;
    private int ramVolume;
    private int ssdVolume;
    public static boolean isBroken = false;

    public Computer(String cpuType, int ramVolume, int ssdVolume) {
        this.cpuType = cpuType;
        this.ramVolume = ramVolume;
        this.ssdVolume = ssdVolume;
    }

    public String getCpuType() {
        return cpuType;
    }

    public void setCpuType(String cpuType) {
        this.cpuType = cpuType;
    }

    public int getRamVolume() {
        return ramVolume;
    }

    public void setRamVolume(int ramVolume) {
        this.ramVolume = ramVolume;
    }

    public int getSsdVolume() {
        return ssdVolume;
    }

    public void setSsdVolume(int ssdVolume) {
        this.ssdVolume = ssdVolume;
    }


    public void printPC() {
        System.out.println("Computer{" +
                "Тип процессора='" + cpuType + '\'' +
                ", Объем ОЗУ=" + ramVolume + " Gb" +
                ", Объем жесткого диска=" + ssdVolume + " Gb" +
                '}');

    }

    public void onPC() {
        Scanner sc = new Scanner(System.in);
        int numRandom = (int) (Math.random() * 2);
        System.out.println("Введите 0 или 1, чтобы включить компьютер!");
        int numUser = sc.nextInt();
        if (numRandom == numUser && isBroken == false) {
            System.out.println("PC on!");
        } else {
            System.out.println("PC broken!");
            isBroken = true;
        }

    }

    public void offPC() {
        Scanner sc = new Scanner(System.in);
        int numRandom = (int) (Math.random() * 2);
        System.out.println("Введите 0 или 1, чтобы выключить компьютер!");
        int numUser = sc.nextInt();
        if (numRandom == numUser && isBroken == false) {
            System.out.println("PC off!");
        } else {
            System.out.println("PC broken!");
            isBroken = true;
        }
    }
}
