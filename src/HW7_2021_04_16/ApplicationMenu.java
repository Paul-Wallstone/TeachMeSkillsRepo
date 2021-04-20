package HW7_2021_04_16;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationMenu {
    private static Shop shop;

    public ApplicationMenu(Shop shop) {
        this.shop = shop;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        int i = 0;
        while (!exit) {
            System.out.println("Выберите действие:\n" +
                    "(1)Вывод всех товаров.\n" +
                    "(2)Добавление товара.\n" +
                    "(3)Удаление товара.\n" +
                    "(4)Редактирование товара.\n" +
                    "(5)Выход.\n");

            try {
                i = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("введена не цифра!");
                scanner.nextLine();
            }

            switch (i) {
                case 1:
                    printSortMethod(scanner);
                    break;
                case 2:
                    try {
                        addProduct(scanner);
                    } catch (ProductException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    deleteProduct(scanner);
                    break;
                case 4:
                    try {
                        editProduct(scanner);
                    } catch (ProductException e) {
                        e.getMessage();
                    }
                    break;
                case 5:
                    exit = true;
                    break;
                default:
            }
        }
    }

    private static void printSortMethod(Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            int i = 0;
            System.out.println("\nСортировать:\n(1)по цене(возрастание)\n" +
                    "(2)по цене(убывание)\n" +
                    "(3)по добавлению(сначала новые, потом более старые)\n" +
                    "(4)по наименованию товара\n" +
                    "(5)выход");

            try {
                i = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("введена не цифра!");
                scanner.nextLine();
            }

            switch (i) {
                case 1:
                    shop.printSortList(shop.returnProductList(), false);
                    break;
                case 2:
                    shop.printSortList(shop.returnProductList(), true);
                    break;
                case 3:
                    ProductIdComparator productIdComparator = new ProductIdComparator();
                    shop.printSortList(shop.returnProductList(), productIdComparator);
                    break;
                case 4:
                    ProductTitleComparator productTitleComparator = new ProductTitleComparator();
                    shop.printSortList(shop.returnProductList(), productTitleComparator);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
            }
        }
    }

    private static void addProduct(Scanner scanner) throws ProductException {
        String title;
        int price = 0;
        boolean add = false;
        System.out.println("\nВвести из консоли 2 параметра (название, цена)");
        System.out.println("Введите название:");
        scanner.nextLine();
        title = scanner.nextLine();
        System.out.println("Введите цену:");
        try {
            price = scanner.nextInt();
            add = true;
        } catch (InputMismatchException e) {
            System.out.println("введена не цифра!");
            scanner.nextLine();
        }
        if (add) {
            shop.addProduct(new Product(title, price));
            System.out.println("Объект добавлен!");
        } else {
            System.out.println("Объект не добавлен!");
        }
    }

    private static void editProduct(Scanner scanner) throws ProductException {
        int id = 0;
        String title = "";
        int price = 0;
        boolean isEditable = false;
        System.out.println("\nВвести из консоли 3 параметра (id,название, цена)");
        System.out.println("Введите id:");
        scanner.nextLine();
        try {
            id = scanner.nextInt();
            System.out.println("Введите название:");
            scanner.nextLine();
            title = scanner.nextLine();
            System.out.println("Введите цену:");
            price = scanner.nextInt();
            isEditable = true;
        } catch (InputMismatchException e) {
            System.out.println("введена не цифра!");
            scanner.nextLine();
        }
        if (isEditable) {
            shop.editProduct(id, title, price);
            System.out.println("Объект изменен!");
        } else {
            System.out.println("Объект не изменен!");
        }
    }

    private static void deleteProduct(Scanner scanner) {
        System.out.println("\nВведите id товара, который нужно удалить:");
        shop.removeProduct(scanner.nextInt());
        System.out.println("Объект удален!");
    }
}
