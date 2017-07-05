package scan;

/**
 * created by sendro on 04.07.17.
 */
public class ResultEmpty implements IScanResult<String>{

    @Override
    public String getResult() {
        return "Invalid bar-code";
    }
}
