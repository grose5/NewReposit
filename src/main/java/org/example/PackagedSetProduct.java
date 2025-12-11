package org.example;

import java.util.Arrays;
import java.util.Objects;

public class PackagedSetProduct implements IPackedItem{
    private final Package aPackage;
    private final IPackedItem[] items;

    public PackagedSetProduct(Package aPackage, IPackedItem[] items){
        if (aPackage == null) {
            throw new IllegalArgumentException("Упаковка не может быть null");
        }
        if (items == null) {
            throw new IllegalArgumentException("Массив не может быть null");
        }
        this.aPackage = aPackage;
        this.items = new IPackedItem[items.length];
        for(int i = 0; i < items.length; i++){
            this.items[i] = items[i];
        }
    }

    @Override
    public double getBrutto() {
        return getNetto() + aPackage.getWeight();
    }

    public Package getaPackage(){
        return aPackage;
    }

    public IPackedItem[] getItems(){
        return items;
    }

    @Override
    public String getName() {
        return aPackage.getName();
    }

    @Override
    public double getNetto() {
        double net = 0.0;
        for (IPackedItem item : items) {
            if (item != null) {
                net += item.getBrutto();
            }
        }
        return net;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PackagedSetProduct that = (PackagedSetProduct) o;
        return Objects.equals(aPackage, that.aPackage) && Objects.deepEquals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aPackage, Arrays.hashCode(items));
    }

    @Override
    public String toString() {
        return "PackagedSetProduct{" +
                "aPackage=" + aPackage +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}
