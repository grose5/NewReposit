package org.example;

import java.util.Objects;
//1.4
public class PieceProduct extends Product{
    private final double weightPerPiece;

    public PieceProduct(String name, String description, double weightPerPiece){
        super(name,description);
        this.weightPerPiece = weightPerPiece;
    }

    public double getWeightPerPiece(){
        return weightPerPiece;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PieceProduct that = (PieceProduct) o;
        return Double.compare(weightPerPiece, that.weightPerPiece) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weightPerPiece);
    }

    @Override
    public String toString() {
        return "PieceProduct{" +
                "weightPerPiece=" + weightPerPiece +
                '}';
    }
}
