package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {
    @Test
    public void test1(){
        Package p1 = new Package("Картонная коробка", 1.0);
        assertEquals("Картонная коробка", p1.getName());
        assertEquals(1.0, p1.getWeight(), 0.0001);
        assertTrue(Double.compare(1.0, p1.getWeight()) == 0);//или же так
    }

    @Test
    public void test2(){
        Package p1 = new Package("Картонная коробка", 1.0);
        Package p2 = new Package("Картонная коробка", 1.0);
        Package p3 = new Package("Металлический сейф", 250.0);
        assertTrue(p1.equals(p2));
        assertEquals(p1.hashCode(), p2.hashCode());
        assertFalse(p1.equals(p3));
        assertFalse(p1.equals(null));
        assertFalse(p1.equals("что-то"));
    }

    @Test
    public void test3(){
        Package p1 = new Package("Картонная коробка", 1.0);
        String res = "Package{name='Картонная коробка', weight=1.0}";
        assertEquals(res, p1.toString());
    }

    @Test
    public void test4(){
        Product p1 = new Product("Чак-чак", "Вкусный");
        assertEquals("Чак-чак", p1.getName());
        assertEquals("Вкусный", p1.getDescription());
    }

    @Test
    public void test5(){
        Product p1 = new Product("Чак-чак", "Вкусный");
        Product p2 = new Product("Чак-чак", "Вкусный");
        Product p3 = new Product("Мороженое", "Со сгущенкой");
        assertTrue(p1.equals(p2));
        assertEquals(p1.hashCode(), p2.hashCode());
        assertFalse(p1.equals(p3));
    }

    @Test
    public void test6(){
        Product p1 = new Product("Чай", "Зеленый");
        assertEquals("Product{name='Чай', description='Зеленый'}", p1.toString());
    }

    @Test
    public void test7(){
        WeightedProduct w1 = new WeightedProduct("Чай", "Зеленый");
        assertEquals("Чай", w1.getName());
        assertEquals("Зеленый", w1.getDescription());
    }

    @Test
    public void test8(){
        WeightedProduct w1 = new WeightedProduct("Чай", "Зеленый");
        WeightedProduct w2 = new WeightedProduct("Чай", "Зеленый");
        WeightedProduct w3 = new WeightedProduct("Сок", "Апельсиновый");
        assertTrue(w1.equals(w2));
        assertFalse(w1.equals(w3));
    }

    @Test
    public void test9(){
        PieceProduct pp1 = new PieceProduct("Стол","Деревянный", 33.5);
        PieceProduct pp2 = new PieceProduct("Стол","Деревянный", 33.5);
        PieceProduct pp3 = new PieceProduct("Стул","Удобный", 5.5);

        assertTrue(pp1.equals(pp2));
        assertEquals(pp1.hashCode(), pp2.hashCode());
        assertFalse(pp1.equals(pp3));
    }

    @Test
    public void test10(){
        PieceProduct pp1 = new PieceProduct("Учебник","Мат анализ", 1.2);
        assertTrue(Double.compare(1.2, pp1.getWeightPerPiece()) == 0);
    }

    @Test
    public void test11(){
        Package p1 = new Package("Картонная коробка", 1.0);
        WeightedProduct w1 = new WeightedProduct("Книжки", "Мат анализ");
        PackageWeightedProduct pwp1 = new PackageWeightedProduct(p1, w1, 4.0);

        assertEquals(p1, pwp1.getaPackage());
        assertEquals(w1, pwp1.getWeightedProduct());
        assertTrue(Double.compare(4.0, pwp1.getCountKilo()) == 0);
    }

    @Test
    public void test12(){
        Package p1 = new Package("Картонная коробка", 1.0);
        WeightedProduct w1 = new WeightedProduct("Книжки", "Мат анализ");
        PackageWeightedProduct pwp1 = new PackageWeightedProduct(p1, w1, 4.0);

        assertTrue(Double.compare(4.0, pwp1.getNetto()) == 0);
        assertTrue(Double.compare(4.0 + 1.0, pwp1.getBrutto()) == 0);
    }

    @Test
    public void test13(){
        Package p1 = new Package("Картонная коробка", 1.0);
        WeightedProduct w1 = new WeightedProduct("Книжки", "Мат анализ");
        PackageWeightedProduct pwp1 = new PackageWeightedProduct(p1, w1, 4.0);
        PackageWeightedProduct pwp2 = new PackageWeightedProduct(p1, w1, 4.0);

        assertTrue(pwp1.equals(pwp2));
        assertEquals(pwp1.hashCode(), pwp2.hashCode());
    }

    @Test
    public void test14(){
        Package p1 = new Package("Картонная коробка", 1.0);
        WeightedProduct w1 = new WeightedProduct("Книжки", "Мат анализ");
        PackageWeightedProduct pwp1 = new PackageWeightedProduct(p1, w1, 4.0);
        String res = "Package{name='Картонная коробка', weight=1.0}, " +
                "Product{name='Книжки', description='Мат анализ'}, countKilo=4.";
        assertEquals(res,pwp1.toString());
    }


}
