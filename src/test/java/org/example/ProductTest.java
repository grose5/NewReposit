package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void test1() {
        Package p1 = new Package("Картонная коробка", 1.0);
        assertEquals("Картонная коробка", p1.getName());
        assertEquals(1.0, p1.getWeight(), 0.0001);
        assertEquals(0, Double.compare(1.0, p1.getWeight()));
    }

    @Test
    public void test2() {
        Package p1 = new Package("Картонная коробка", 1.0);
        Package p2 = new Package("Картонная коробка", 1.0);
        Package p3 = new Package("Металлический сейф", 250.0);
        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
        assertNotEquals(p1, p3);
        assertFalse(p1.equals(null));
    }

    @Test
    public void test3() {
        Package p1 = new Package("Картонная коробка", 1.0);
        String res = "Package{name='Картонная коробка', weight=1.0}";
        assertEquals(res, p1.toString());
    }

    @Test
    public void test4() {
        Product p1 = new Product("Чак-чак", "Вкусный");
        assertEquals("Чак-чак", p1.getName());
        assertEquals("Вкусный", p1.getDescription());
    }

    @Test
    public void test5() {
        Product p1 = new Product("Чак-чак", "Вкусный");
        Product p2 = new Product("Чак-чак", "Вкусный");
        Product p3 = new Product("Мороженое", "Со сгущенкой");
        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
        assertNotEquals(p1, p3);
    }

    @Test
    public void test6() {
        Product p1 = new Product("Чай", "Зеленый");
        assertEquals("Product{name='Чай', description='Зеленый'}", p1.toString());
    }

    @Test
    public void test7() {
        WeightedProduct w1 = new WeightedProduct("Чай", "Зеленый");
        assertEquals("Чай", w1.getName());
        assertEquals("Зеленый", w1.getDescription());
    }

    @Test
    public void test8() {
        WeightedProduct w1 = new WeightedProduct("Чай", "Зеленый");
        WeightedProduct w2 = new WeightedProduct("Чай", "Зеленый");
        WeightedProduct w3 = new WeightedProduct("Сок", "Апельсиновый");
        assertEquals(w1, w2);
        assertNotEquals(w1, w3);
    }

    @Test
    public void test9() {
        PieceProduct pp1 = new PieceProduct("Стол", "Деревянный", 33.5);
        PieceProduct pp2 = new PieceProduct("Стол", "Деревянный", 33.5);
        PieceProduct pp3 = new PieceProduct("Стул", "Удобный", 5.5);
        assertEquals(pp1, pp2);
        assertEquals(pp1.hashCode(), pp2.hashCode());
        assertNotEquals(pp1, pp3);
    }

    @Test
    public void test10() {
        PieceProduct pp1 = new PieceProduct("Учебник", "Мат анализ", 1.2);
        assertEquals(0, Double.compare(1.2, pp1.getWeightPerPiece()));
    }

    @Test
    public void test11() {
        Package p1 = new Package("Картонная коробка", 1.0);
        PackageWeightedProduct pwp1 = new PackageWeightedProduct(p1, "Книжки", "Мат анализ", 4.0);
        assertEquals(p1, pwp1.getaPackage());
        assertEquals("Книжки", pwp1.getName());
        assertEquals("Мат анализ", pwp1.getDescription());
        assertEquals(0, Double.compare(4.0, pwp1.getCountKilo()));
    }

    @Test
    public void test12() {
        Package p1 = new Package("Картонная коробка", 1.0);
        PackageWeightedProduct pwp1 = new PackageWeightedProduct(p1, "Книжки", "Мат анализ", 4.0);
        assertEquals(0, Double.compare(4.0, pwp1.getNetto()));
        assertEquals(0, Double.compare(5.0, pwp1.getBrutto())); // 4 + 1
    }

    @Test
    public void test13() {
        Package p1 = new Package("Картонная коробка", 1.0);
        PackageWeightedProduct pwp1 = new PackageWeightedProduct(p1, "Книжки", "Мат анализ", 4.0);
        PackageWeightedProduct pwp2 = new PackageWeightedProduct(p1, "Книжки", "Мат анализ", 4.0);
        assertEquals(pwp1,pwp2);
        assertEquals(pwp1.hashCode(), pwp2.hashCode());
    }

    @Test
    public void test14() {
        Package p1 = new Package("Картонная коробка", 1.0);
        PackageWeightedProduct pwp1 = new PackageWeightedProduct(p1, "Книжки", "Мат анализ", 4.0);
        String res = "PackageWeightedProduct{aPackage=Package{name='Картонная коробка', weight=1.0}, countKilo=4.0}";
        assertEquals(res, pwp1.toString());
    }

    @Test
    public void test15() {
        Package p1 = new Package("Картонная коробка", 1.0);
        PackagePieceProduct ppp1 = new PackagePieceProduct(p1, "Книжка", "Алгеом", 2.0, 7);
        assertEquals(7, ppp1.getCountProduct());
        assertEquals("Книжка", ppp1.getName());
        assertEquals(0, Double.compare(14.0, ppp1.getNetto())); // 2.0 * 7
        assertEquals(0, Double.compare(15.0, ppp1.getBrutto())); // 14 + 1
    }

    @Test
    public void test16() {
        Package p1 = new Package("Картонная коробка", 1.0);
        PackagePieceProduct ppp1 = new PackagePieceProduct(p1, "Книжка", "Алгеом", 2.0, 7);
        PackagePieceProduct ppp2 = new PackagePieceProduct(p1, "Книжка", "Алгеом", 2.0, 7);
        assertEquals(ppp1, ppp2);
        assertEquals(ppp1.hashCode(), ppp2.hashCode());
    }

    @Test
    public void test17() {
        Package p1 = new Package("Картонная коробка", 1.0);
        PackagePieceProduct ppp1 = new PackagePieceProduct(p1, "Книжка", "Алгеом", 2.0, 7);
        String res = "PackagePieceProduct{aPackage=Package{name='Картонная коробка', weight=1.0}, countProduct=7}";
        assertEquals(res, ppp1.toString());
    }

    @Test
    public void test18() {
        BeginStringFilter b1 = new BeginStringFilter("Мама");
        BeginStringFilter b2 = new BeginStringFilter("мыла");
        String str1 = "Мама мыла раму";
        assertTrue(b1.apply(str1));
        assertFalse(b2.apply(str1));
        assertFalse(b2.apply(null));
        assertFalse(b2.apply(""));
    }

    @Test
    public void test19() {
        IncludeStringFilter i1 = new IncludeStringFilter("Мама");
        String str1 = "Мама мыла раму";
        String str2 = "Какой-то текст";
        assertTrue(i1.apply(str1));
        assertFalse(i1.apply(str2));
        assertFalse(i1.apply(null));
    }

    @Test
    public void test20() {
        Package p1 = new Package("Картонная коробка", 1.0);
        PackageWeightedProduct pwp1 = new PackageWeightedProduct(p1, "Книжки", "Мат анализ", 4.0); // brutto = 5.0
        PackagePieceProduct ppp1 = new PackagePieceProduct(p1, "Ноутбук", "Thinkbook", 1.5, 5);   // netto = 7.5, brutto = 8.5
        ProductBatch pb1 = new ProductBatch(new IPackedItem[]{pwp1, ppp1}, "Какое-то описание");
        assertEquals(0, Double.compare(13.5, pb1.getAllWeight())); // 5.0 + 8.5 = 13.5
    }

    @Test
    public void test21() {
        Package p1 = new Package("Картонная коробка", 1.0);
        PackageWeightedProduct pwp1 = new PackageWeightedProduct(p1, "Книжки", "Мат анализ", 4.0);
        PackagePieceProduct ppp1 = new PackagePieceProduct(p1, "Ноутбук", "Thinkbook", 1.5, 5);
        ProductBatch pb1 = new ProductBatch(new IPackedItem[]{pwp1, ppp1}, "Какое-то описание");

        BeginStringFilter b1 = new BeginStringFilter("Книж");
        assertEquals(1, ProductService.countByFilter(pb1, b1));

        IncludeStringFilter i1 = new IncludeStringFilter("Ноут");
        assertEquals(1, ProductService.countByFilter(pb1, i1));

        FilterEndsWith f1 = new FilterEndsWith("бук");
        assertEquals(1, ProductService.countByFilter(pb1, f1));
    }

    @Test
    public void test22() {//countByFilter
        Package p1 = new Package("Картонная коробка", 1.0);
        PackageWeightedProduct pwp1 = new PackageWeightedProduct(p1, "книжки", "Мат анализ", 4.0);
        PackageWeightedProduct pwp2 = new PackageWeightedProduct(p1, "нитки", "Черные", 1.0);
        PackagePieceProduct ppp1 = new PackagePieceProduct(p1, "Ноутбук", "Thinkbook", 1.5, 5);
        ProductBatch pb1 = new ProductBatch(new IPackedItem[]{pwp1, pwp2, ppp1}, "Какое-то описание");

        BeginStringFilter b1 = new BeginStringFilter("книж");
        assertEquals(1, ProductService.countByFilter(pb1, b1));

        IncludeStringFilter i1 = new IncludeStringFilter("ни");
        assertEquals(2, ProductService.countByFilter(pb1, i1));

        FilterEndsWith f1 = new FilterEndsWith("бук");
        assertEquals(1, ProductService.countByFilter(pb1, f1));
    }

    @Test
    public void test23(){
        Package p1 = new Package("Картонная коробка",1.0);
        Package p2 = new Package("Металлический сейф",250.0);
        Package p3 = new Package("Коробка для набора",2.0);

        PackageWeightedProduct pw1 = new PackageWeightedProduct(p1, "книжки", "Мат анализ", 4.0);
        PackagePieceProduct pp1 = new PackagePieceProduct(p2, "Ноутбук", "Thinkbook", 1.5, 5);

        IPackedItem[] ip1 = {pw1,pp1};
        PackagedSetProduct psp1 = new PackagedSetProduct(p3, ip1);

        assertEquals("Коробка для набора", psp1.getName());
        assertEquals(0, Double.compare(1+4+ 1.5*5 + 250, psp1.getNetto()));
        assertEquals(0, Double.compare(1+4+ 1.5*5 + 250 + 2, psp1.getBrutto()));
    }
}