package org.example;

import java.util.Objects;
//1.1
public class Package {
    private final String name;
    private final double weight;


    public Package(String name, double weight){
        this.name = name;
        this.weight = weight;
    }

    public String getName(){
        return name;
    }

    public double getWeight(){
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Package aPackage = (Package) o;
        return weight == aPackage.weight && Objects.equals(name, aPackage.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight);
    }

    @Override
    public String toString() {
        return "Package{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
