package mvc;

import io.IScannerStub;

import java.util.ArrayList;

/**
 * created by sendro on 04.07.17.
 */
public interface IModel {

    void addNewProduct(Product product);
    void clearProductsList();
    void scanProduct(String action, IScannerStub.ScanCallback callback);
    ArrayList<Product> getAllProducts();
    double getTotalPrice();
}
