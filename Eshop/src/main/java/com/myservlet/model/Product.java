package com.myservlet.model;

import java.util.Objects;

public class Product {
    private String name;
    private String imageName;
    private String description;
    private String type;
    private String price;
    private int id;
    private static int idCount = 0;

    public Product(String name, String imageName, String description, String type, String price) {
        this.name = name;
        this.imageName = imageName;
        this.description = description;
        this.type = type;
        this.price = price;
        this.id = idCount++;
    }

    public int getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getName(), product.getName()) && Objects.equals(getImageName(), product.getImageName()) && Objects.equals(getDescription(), product.getDescription()) && Objects.equals(getType(), product.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getImageName(), getDescription(), getType());
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", imageName='" + imageName + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
