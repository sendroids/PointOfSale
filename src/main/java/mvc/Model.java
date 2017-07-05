package mvc;


import io.IDatabaseStub;
import io.IScannerStub;
import io.Scanner;

import java.util.ArrayList;

/**
 * created by sendro on 04.07.17.
 */
public class Model implements IModel {

    private IDatabaseStub databaseStub;
    private IScannerStub scannerStub;

    public Model(IDatabaseStub databaseStub) {
        this.databaseStub = databaseStub;
        this.scannerStub = new Scanner(this);
    }

    @Override
    public void addNewProduct(Product product) {
        databaseStub.addProduct(product);
    }

    @Override
    public void clearProductsList() {
        databaseStub.removeAllProducts();
    }

    @Override
    public void scanProduct(String action, IScannerStub.ScanCallback callback) {
        scannerStub.scan(action, callback);
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        return databaseStub.getAllProductsList();
    }

    @Override
    public double getTotalPrice() {
        double total = 0;
        for (Product product : databaseStub.getAllProductsList()) {
            total += product.getProductPrice();
        }
        return total;
    }

}
