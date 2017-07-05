package scan;


import mvc.Product;
import utils.FormatUtil;

/**
 * created by sendro on 04.07.17.
 */
public class ResultOk implements IScanResult<String[]>{

    private String[] product;

    public ResultOk(Product product) {
        this.product = FormatUtil.convertProductToString(product);
    }

    @Override
    public String[] getResult() {
        return product;
    }
}
