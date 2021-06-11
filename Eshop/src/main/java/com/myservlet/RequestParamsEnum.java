package com.myservlet;

public enum RequestParamsEnum {

    LOGIN("username"),
    PASSWORD("password"),
    CATEGORY("categories"),
    COMMAND("command"),
    PRODUCTS("products"),
    CART("carts"),
    CARTS_REMOVE("carts_remove"),
    PRODUCT_ID("product_id");

    private final String value;

    RequestParamsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
