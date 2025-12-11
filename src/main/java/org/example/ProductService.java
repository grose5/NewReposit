package org.example;

public class ProductService{
    public static int countByFilter(ProductBatch batch, IFilter filter){
        int c = 0;
        for(IPackedItem product : batch.getProducts()){
            if(filter.apply(product.getName())){
                c++;
            }
        }
        return c;
    }
}
