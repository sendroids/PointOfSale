package io;

import mvc.Product;

import java.util.ArrayList;

/**
 * Created by sendro on 04.07.17.
 */
public class Database implements IDatabaseStub {

    private static IDatabaseStub databaseStub;
    private final ArrayList<Product> products = new ArrayList<>();

    public static IDatabaseStub getInstance(){
        if(databaseStub == null){
            databaseStub = new Database();
        }
        return databaseStub;
    }

    @Override
    public ArrayList<Product> getAllProductsList() {
        return products;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void removeAllProducts() {
        products.clear();
    }
}
