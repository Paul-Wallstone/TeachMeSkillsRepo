package com.myservlet.command;

import com.myservlet.PagesPathEnum;
import com.myservlet.exceptions.CommandException;
import com.myservlet.model.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.myservlet.RequestParamsEnum.PRODUCTS;

public class ProductPageCommandImpl implements BaseCommand {
    private static List<Product> products = new ArrayList<>();
    private List<Product> productsFiltered;

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        if (products.size() == 0) {
            Product bmw = new Product("X1", "bmwx.jpg", "бла бла бла", "Cars", "35000");
            Product audi = new Product("Q3", "audiq.jpg", "бла бла бла", "Cars", "37000");
            Product kia = new Product("RIO", "rio.jpg", "бла бла бла", "Cars", "15000");

            Product apple = new Product("Apple 12", "apple1.jpg", "бла бла бла", "Mobile phones", "1000");
            Product sony = new Product("Sony P", "sony1.jpg", "бла бла бла", "Mobile phones", "1000");
            Product samsung = new Product("Samsung P", "samsung1.jpg", "бла бла бла", "Mobile phones", "1000");

            Product canonFt = new Product("Canon", "canonFt1.jpg", "бла бла бла", "Cameras", "1000");
            Product nikonFt = new Product("Nikon", "nikonFt1.jpg", "бла бла бла", "Cameras", "1000");
            Product sonyFt = new Product("Sony Ph", "sonyFt1.jpg", "бла бла бла", "Cameras", "1000");

            Product LGF = new Product("LG", "LGF1.jpg", "бла бла бла", "Fridges", "1000");
            Product samsungF = new Product("Samsung F", "sumsungF1.jpg", "бла бла бла", "Fridges", "1000");
            Product atlant = new Product("Atlant", "atlantF1.jpg", "бла бла бла", "Fridges", "1000");

            Product hp = new Product("HP", "HPN1.jpg", "бла бла бла", "Laptops", "1000");
            Product appleN = new Product("Apple N", "appleN1.jpg", "бла бла бла", "Laptops", "1000");
            Product lenovoN = new Product("Lenovo", "lenovoN1.jpg", "бла бла бла", "Laptops", "1000");

            Product navitel = new Product("Navitel", "navitel1.jpeg", "бла бла бла", "GPS Navigators", "1000");
            Product garmin = new Product("Garmin", "garmin1.jpeg", "бла бла бла", "GPS Navigators", "1000");
            Product roadmax = new Product("Roadmax", "roadmax1.jpeg", "бла бла бла", "GPS Navigators", "1000");

            products.addAll(Arrays.asList(appleN, lenovoN, bmw, audi, kia, apple, sony, canonFt, nikonFt, sonyFt, atlant, hp, navitel, roadmax, garmin, samsung, samsungF, LGF));
        }
        String t = request.getParameter("type");
        if (t != null) {
            productsFiltered = products.stream().filter(p -> (p.getType().equals(t))).collect(Collectors.toList());
        } else {
            String f = CartPageCommandImpl.getLastType();
            productsFiltered = products.stream().filter(p -> (p.getType().equals(f))).collect(Collectors.toList());
        }
        request.setAttribute(PRODUCTS.getValue(), productsFiltered);
        return PagesPathEnum.PRODUCT_PAGE.getPath();
    }

    public static List<Product> getProducts() {
        return products;
    }
}
