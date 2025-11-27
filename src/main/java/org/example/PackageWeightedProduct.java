package org.example;

import java.util.Objects;
//1.5
public class PackageWeightedProduct{
    private final Package aPackage;
    private final WeightedProduct weightedProduct;
    private final double countKilo;

    public PackageWeightedProduct(Package aPackage, WeightedProduct weightedProduct, double countKilo){
        this.aPackage = aPackage;
        this.weightedProduct = weightedProduct;
        this.countKilo = countKilo;
    }

    public Package getaPackage(){
        return aPackage;
    }

    public WeightedProduct getWeightedProduct(){
        return weightedProduct;
    }

    public double getCountKilo(){
        return countKilo;
    }

    public double getNetto(){
        return getCountKilo();
    }

    public double getBrutto(){
        return getCountKilo() + aPackage.getWeight();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PackageWeightedProduct that = (PackageWeightedProduct) o;
        return Double.compare(countKilo, that.countKilo) == 0 && Objects.equals(aPackage, that.aPackage) && Objects.equals(weightedProduct, that.weightedProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aPackage, weightedProduct, countKilo);
    }

    @Override
    public String toString() {
        return getaPackage() + ", " + getWeightedProduct() + ", countKilo=" + getCountKilo();
    }
}
