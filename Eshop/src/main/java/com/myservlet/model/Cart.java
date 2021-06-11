package com.myservlet.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> cartList;

    public Cart() {
        this.cartList = new ArrayList<>();
    }

    public List<Product> getCartList() {
        return cartList;
    }

    public void setCartList(List<Product> cartList) {
        this.cartList = cartList;
    }
}
