package io;

import mvc.Product;
import scan.IScanResult;

/**
 * Created by sendro on 04.07.17.
 */
public interface IScannerStub {

    Product getLastScannedProduct();
    void scan(String action, ScanCallback callback);

    interface ScanCallback {
        void onScanComplete(IScanResult scanResult);
    }

}
