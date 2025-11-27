package org.example;

import java.util.Objects;
//1.6
public class PackagePieceProduct {
    private final Package aPackage;
    private final int countProduct;
    private final PieceProduct pieceProduct;

    public PackagePieceProduct(Package aPackage, int countProduct, PieceProduct pieceProduct){
        this.aPackage = aPackage;
        this.countProduct = countProduct;
        this.pieceProduct = pieceProduct;
    }

    public int getCountProduct(){
        return countProduct;
    }

    public double getNetto(){
        return getCountProduct() * pieceProduct.getWeightPerPiece();
    }

    public double getBrutto(){
        return aPackage.getWeight() + getNetto();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PackagePieceProduct that = (PackagePieceProduct) o;
        return countProduct == that.countProduct && Objects.equals(aPackage, that.aPackage) && Objects.equals(pieceProduct, that.pieceProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aPackage, countProduct, pieceProduct);
    }

    @Override
    public String toString() {
        return "PackagePieceProduct{" +
                "product='" + pieceProduct.getName() + "', " +
                "count=" + countProduct + ", " +
                "netto=" + getNetto() + "kg, " +
                "package='" + aPackage.getName() + "'(" + aPackage.getWeight() + "kg)" +
                '}';
    }
}
