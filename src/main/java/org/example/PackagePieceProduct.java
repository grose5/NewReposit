package org.example;

import java.util.Objects;
//1.6
public class PackagePieceProduct extends PieceProduct implements IPackedItem{
    private final Package aPackage;
    private final int countProduct;


    public PackagePieceProduct(Package aPackage, String name, String description, double weightPerPiece, int countProduct){
        super(name, description, weightPerPiece);
        this.aPackage = aPackage;
        this.countProduct = countProduct;
    }

    public Package getaPackage(){
        return aPackage;
    }

    public int getCountProduct(){
        return countProduct;
    }

    public double getNetto(){
        return getCountProduct() * getWeightPerPiece();
    }

    public double getBrutto(){
        return getaPackage().getWeight() + getNetto();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PackagePieceProduct that = (PackagePieceProduct) o;
        return countProduct == that.countProduct && Objects.equals(aPackage, that.aPackage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), aPackage, countProduct);
    }

    @Override
    public String toString() {
        return "PackagePieceProduct{" +
                "aPackage=" + aPackage +
                ", countProduct=" + countProduct +
                '}';
    }
}
