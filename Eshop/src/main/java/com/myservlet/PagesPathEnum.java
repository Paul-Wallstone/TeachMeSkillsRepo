package com.myservlet;

public enum PagesPathEnum {
    HOME_PAGE("home.jsp"),
    SIGN_IN_PAGE("signin.jsp"),
    PRODUCT_PAGE("product.jsp"),
    CART_PAGE("cart.jsp");

    private final String path;

    PagesPathEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
