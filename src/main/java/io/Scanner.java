package io;

import mvc.IModel;
import mvc.Product;
import scan.*;
import utils.FormatUtil;

import java.util.ArrayList;

/**
 * Created by sendro on 04.07.17.
 */
public class Scanner implements IScannerStub {

    public static final String SCAN_EMPTY = "scan_empty";
    public static final String SCAN_NOT_FOUND = "scan_not_found";
    public static final String SCAN_OK = "scan_ok";
    public static final String EXIT_AND_PRINT_ALL = "print_all";

    private IModel model;

    public Scanner(IModel model) {
        this.model = model;
    }

    @Override
    public Product getLastScannedProduct() {
        return new Product("Product", (double)Math.round(Math.random() * 10000d) / 100d);
    }

    @Override
    public void scan(String action, ScanCallback callback) {

        IScanResult result = null;
        switch (action){
            case SCAN_OK:{
                Product product = getLastScannedProduct();
                model.addNewProduct(product);
                result = new ResultOk(product);
                break;
            } case SCAN_EMPTY:{
                result = new ResultEmpty();
                break;
            } case SCAN_NOT_FOUND:{
                result = new ResultNotFound();
                break;
            } case EXIT_AND_PRINT_ALL:{
                ArrayList<String[]> listToPrint = new ArrayList<>();
                for (Product product : model.getAllProducts()) {
                    listToPrint.add(FormatUtil.convertProductToString(product));
                }
                result = new ResultPrintAll(listToPrint, model.getTotalPrice());
                model.clearProductsList();
            }
        }
        callback.onScanComplete(result);
    }

}
