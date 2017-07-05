import io.Database;
import io.IScannerStub;
import io.Scanner;
import mvc.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import scan.IScanResult;
import utils.FormatUtil;

import java.util.ArrayList;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;

/**
 * Created by sendro on 04.07.17.
 */
public class ScannerTest {

    private IScannerStub mockedScanner;
    private IModel model;
    private Product product;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        model = new Model(Database.getInstance());
        product = new Product("Lampa", 99.99);
        mockedScanner = new MockedScanner(product, model);
        model.clearProductsList();
    }

    @Test
    public void addingProductsTest(){
        int count = (int) (Math.random() * 100);
        for (int i = 0; i < count; i++) {
            model.addNewProduct(product);
        }
        assertThat(Database.getInstance().getAllProductsList().size(), is(count));
    }

    @Test
    public void okScanScenario() {

        mockedScanner.scan(Scanner.SCAN_OK, new IScannerStub.ScanCallback() {
            @Override
            public void onScanComplete(IScanResult scanResult) {
                assertThat(scanResult.getResult(), is(FormatUtil.convertProductToString(product)));
            }
        });
    }

    @Test
    public void emptyScanScenario() {

        mockedScanner.scan(Scanner.SCAN_EMPTY, new IScannerStub.ScanCallback() {
            @Override
            public void onScanComplete(IScanResult scanResult) {
                assertThat(scanResult.getResult(), is("Invalid bar-code"));
            }
        });
    }

    @Test
    public void notFoundScanScenario() {

        mockedScanner.scan(Scanner.SCAN_NOT_FOUND, new IScannerStub.ScanCallback() {
            @Override
            public void onScanComplete(IScanResult scanResult) {
                assertThat(scanResult.getResult(), is("Product not found"));
            }
        });
    }

    @Test
    public void exitAndPrintTest(){
        ArrayList<String[]> expectedResult = new ArrayList<>();
        String[] productString = FormatUtil.convertProductToString(product);
        model.clearProductsList();
        for (int i = 0; i < 10; i++) {
            model.addNewProduct(product);
            expectedResult.add(productString);
        }

        assertThat(model.getTotalPrice(), is(10 * product.getProductPrice()));

        mockedScanner.scan(Scanner.EXIT_AND_PRINT_ALL, new IScannerStub.ScanCallback() {
            @Override
            public void onScanComplete(IScanResult scanResult) {
                for (int i = 0; i < expectedResult.size(); i++) {
                    for (int j = 0; j < 2; j++) {
                        assertThat(((String[]) (((ArrayList) scanResult.getResult()).get(i)))[j], is(expectedResult.get(i)[j]));
                    }
                }
            }
        });

        assertThat(model.getTotalPrice(), is(0d));

    }


}
