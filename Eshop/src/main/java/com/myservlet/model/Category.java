package com.myservlet.model;

import java.util.Objects;

public class Category {
    private String name;
    private String imageName;

    public Category(String name, String imageName) {
        this.name = name;
        this.imageName = imageName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return Objects.equals(getName(), category.getName()) && Objects.equals(getImageName(), category.getImageName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getImageName());
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", imagename='" + imageName + '\'' +
                '}';
    }
}
