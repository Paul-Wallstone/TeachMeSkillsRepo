package com.myservlet;

public enum CommandsEnum {
    HOME_PAGE_COMMAND("start_page"),
    SIGN_IN_COMMAND("sign-in"),
    PRODUCT_PAGE_COMMAND("start_product_page"),
    CART_PAGE_COMMAND("start_cart_page"),
    ADD_PRODUCT_TO_CART("add-product-to-cart"),
    REMOVE_PRODUCT_FROM_CART("remove-product-from-cart");

    private String command;

    CommandsEnum(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
