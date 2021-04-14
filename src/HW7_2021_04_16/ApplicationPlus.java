package HW7_2021_04_16;

import java.util.Arrays;
import java.util.HashSet;


public class ApplicationPlus {
    public static void main(String[] args) {

        Shop shop = new Shop(new HashSet<Product>(Arrays.asList(new Product("Milk ", 13),
                new Product("Bread", 10),
                new Product("Bread", 5),
                new Product("Water", 2))));

        ApplicationMenu applicationMenu = new ApplicationMenu(shop);
        applicationMenu.start();
    }
}
