import io.IScannerStub;
import io.Scanner;
import mvc.IModel;
import mvc.Product;
import scan.*;
import utils.FormatUtil;

import java.util.ArrayList;

import static io.Scanner.*;

/**
 * Created by sendro on 04.07.17.
 */
public class MockedScanner implements IScannerStub {

    private Product product;
    private IModel model;

    public MockedScanner(Product product, IModel model) {
        this.product = product;
        this.model = model;
    }

    @Override
    public Product getLastScannedProduct() {
        return product;
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
