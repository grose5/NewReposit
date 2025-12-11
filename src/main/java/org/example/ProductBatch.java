package org.example;

import java.util.Arrays;
import java.util.Objects;

public class ProductBatch {
    private final IPackedItem[] products;
    private final String description;

    public ProductBatch(IPackedItem[] products, String description){
        this.description = description;
        this.products = products;
    }

    public IPackedItem[] getProducts(){
        return products;
    }

    public String getDescription(){
        return description;
    }

    public double getAllWeight(){
        double weight = 0;
        for(IPackedItem product : products){
            if(product != null){
                weight += product.getBrutto();
            }
        }
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductBatch that = (ProductBatch) o;
        return Objects.deepEquals(products, that.products) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(products), description);
    }

    @Override
    public String toString() {
        return "ProductBatch{" +
                "products=" + Arrays.toString(products) +
                ", description='" + getDescription() + '\'' +
                '}';
    }
}
