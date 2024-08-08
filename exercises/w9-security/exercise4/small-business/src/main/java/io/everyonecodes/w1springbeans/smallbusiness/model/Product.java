package io.everyonecodes.w1springbeans.smallbusiness.model;


import java.util.Objects;

public class Product {
    String id;
    String name;
    String productType;

    public Product() {
    }

    public Product(String name, String productType) {
        this.name = name;
        this.productType = productType;
    }

    public Product(String id, String name, String productType) {
        this.id = id;
        this.name = name;
        this.productType = productType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(productType, product.productType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, productType);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", productType='" + productType + '\'' +
                '}';
    }
}

