package scan;

/**
 * created by sendro on 04.07.17.
 */
public class ResultNotFound implements IScanResult<String> {

    @Override
    public String getResult() {
        return "Product not found";
    }
}
