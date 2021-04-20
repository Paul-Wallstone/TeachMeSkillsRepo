package HW7_2021_04_16;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;


public class ApplicationPlus {
    public static void main(String[] args) {

        Shop shop = new Shop(new TreeSet<Product>(Arrays.asList(new Product("Milk ", 13),
                new Product("Bread", 10),
                new Product("Juice", 5),
                new Product("Apple", 7))));

        ApplicationMenu applicationMenu = new ApplicationMenu(shop);
        applicationMenu.start();
    }
}
