package org.example;

import java.util.Objects;
//1.5
public class PackageWeightedProduct extends WeightedProduct implements IPackedItem {
    private final Package aPackage;
    private final double countKilo;

    public PackageWeightedProduct(Package aPackage, String name, String description, double countKilo){
        super(name,description);
        this.aPackage = aPackage;
        this.countKilo = countKilo;

    }

    public Package getaPackage(){
        return aPackage;
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
        if (!super.equals(o)) return false;
        PackageWeightedProduct that = (PackageWeightedProduct) o;
        return Double.compare(countKilo, that.countKilo) == 0 && Objects.equals(aPackage, that.aPackage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), aPackage, countKilo);
    }

    @Override
    public String toString() {
        return "PackageWeightedProduct{" +
                "aPackage=" + aPackage +
                ", countKilo=" + countKilo +
                '}';
    }
}
