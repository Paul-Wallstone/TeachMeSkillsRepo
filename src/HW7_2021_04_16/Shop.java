package HW7_2021_04_16;

import java.util.*;

public class Shop {
    private HashSet<Product> products = new HashSet<>();

    public Shop() {
    }

    public Shop(HashSet<Product> products) {
        this.products = products;
    }

    public HashSet<Product> getProducts() {
        return products;
    }

    public void setProducts(HashSet<Product> products) {
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
    public List returnProductList() {
        List<Product> productList = new ArrayList<>(products);
        return productList;
    }

    //Печатает все объекты
    public void printProducts() {
        Iterator<Product> i = getProducts().iterator();
        while (i.hasNext())
            System.out.println(i.next().toString());

    }

    //удалить товар (метод принимает в качестве параметра id товара и удаляет из списка товар с соответствующим id)
    public void removeProduct(int id) {
        Iterator<Product> i = getProducts().iterator();
        while (i.hasNext()) {
            Product product = i.next();
            if (product.getId() == id) {
                getProducts().remove(product);
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
    public void printSortList(List<Product> products, boolean reverse) {
        if (reverse) {
            Collections.sort(products, Collections.reverseOrder());
        } else {
            Collections.sort(products);
        }
        for (Product p : products) {
            System.out.println(p.toString());
        }
    }

    public void printSortList(List<Product> products, Comparator comparator) {
        Collections.sort(products, comparator);
        for (Product p : products) {
            System.out.println(p.toString());
        }
    }
}
