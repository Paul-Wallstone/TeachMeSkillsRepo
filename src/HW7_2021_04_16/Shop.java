package HW7_2021_04_16;

import java.util.*;

public class Shop {
    private TreeSet<Product> products = new TreeSet<>();

    public Shop() {
    }

    public Shop(TreeSet<Product> products) {
        this.products = products;
    }

    public TreeSet<Product> getProducts() {
        return products;
    }

    public void setProducts(TreeSet<Product> products) {
        this.products = products;
    }


    //добавить товар (принимает в качестве параметра объект товара и добавляет его в список товаров магазина).
// При попытке добавить товар с уже существующим id в списке, вставка производится не должна.
    public void addProduct(Product p) throws ProductException {
        if (!products.contains(p)) {
            this.products.add(p);
        } else {
            throw new ProductException("Product " + p.getTitle() + " ID = " + p.getId() + " Price = "
                    + p.getPrice() + " with such id has been already existed!");
        }
    }

    //получить все товары (метод возвращает список всех товаров в магазине)
    public TreeSet<Product> returnProductList() {
        return products;
    }

    //Печатает все объекты
    public void printProducts() {
        for (Product p : products) {
            System.out.println(p.toString());
        }
    }

    //удалить товар (метод принимает в качестве параметра id товара и удаляет из списка товар с соответствующим id)
    public void removeProduct(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                getProducts().remove(p);
                System.out.println("Удаление прошло успешно!");
                break;
            }
        }
    }

    //редактировать товар (находим товар по его id, изменяем его параметры и сохраняем).
    public void editProduct(int id, String title, int price) throws ProductException {
        Iterator<Product> i = getProducts().iterator();
        while (i.hasNext()) {
            Product product = i.next();
            if (product.getId() == id) {
                product.setTitle(title);
                product.setPrice(price);
                System.out.println("Продукт изменен!");
                break;
            } else if (!i.hasNext()) {
                throw new ProductException("Product with ID " + id + " is not exist!");
            }
        }
    }

    public void editProduct(int id, String title) throws ProductException {
        Iterator<Product> i = getProducts().iterator();
        while (i.hasNext()) {
            Product product = i.next();
            if (product.getId() == id) {
                product.setTitle(title);
                System.out.println("Продукт изменен!");
                break;
            } else if (!i.hasNext()) {
                throw new ProductException("Product with ID " + id + " is not exist!");
            }
        }
    }

    public void editProduct(int id, int price) throws ProductException {
        Iterator<Product> i = getProducts().iterator();
        while (i.hasNext()) {
            Product product = i.next();
            if (product.getId() == id) {
                product.setPrice(price);
                System.out.println("Продукт изменен!");
                break;
            } else if (!i.hasNext()) {
                throw new ProductException("Product with ID " + id + " is not exist!");
            }
        }
    }

    // Выводит отсортированный лист
    public void printSortList(TreeSet<Product> products, boolean reverse) {
        if (reverse) {
            for (Product p : products.descendingSet()) {
                System.out.println(p.toString());
            }
        } else
            for (Product p : products) {
                System.out.println(p.toString());
            }
    }

    public void printSortList(TreeSet<Product> products, Comparator comparator) {
        TreeSet<Product> set = new TreeSet<>(comparator);
        set.addAll(products);
        for (Product p : set) {
            System.out.println(p.toString());
        }
    }
}
