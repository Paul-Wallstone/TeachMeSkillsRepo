package com.myservlet.command;

import com.myservlet.PagesPathEnum;
import com.myservlet.exceptions.CommandException;
import com.myservlet.model.Category;
import com.myservlet.model.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.myservlet.RequestParamsEnum.CART;
import static com.myservlet.RequestParamsEnum.PRODUCTS;

public class CartPageCommandImpl implements BaseCommand {
    private static List<Product> products = new ArrayList<>();
    private static String lastType;

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        request.setAttribute(CART.getValue(), products);
        return PagesPathEnum.CART_PAGE.getPath();
    }

    public static String getTotalPrice() {
        double result;
        if (getProducts().size() == 0) {
            result = 0;
        } else {
            result = getProducts().stream().mapToDouble(p -> Double.parseDouble(p.getPrice())).sum();
        }
        ;
        return String.format("%.2f", result);
    }

    public static void removeProduct(String id) {
        for (Product product : getProducts()) {
            if (String.valueOf(product.getId()).equals(id)) {
                products.remove(product);
                break;
            }
        }
    }

    public static List<Product> getProducts() {
        return products;
    }

    public static void setLastType(String lastType) {
        CartPageCommandImpl.lastType = lastType;
    }

    public static String getLastType() {
        return lastType;
    }
}
