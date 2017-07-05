package io;

import mvc.Product;

import java.util.ArrayList;

/**
 * Created by sendro on 04.07.17.
 */
public interface IDatabaseStub {

    ArrayList<Product> getAllProductsList();
    void addProduct(Product product);
    void removeAllProducts();
}
