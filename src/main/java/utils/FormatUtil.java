package utils;

import mvc.Product;

import java.text.DecimalFormat;

/**
 * created by sendro on 04.07.17.
 */
public class FormatUtil {

    private static final DecimalFormat DECIMAL = new DecimalFormat("#.##");

    public static String[] convertProductToString(Product product){
        return new String[]{ product.getProductName(), FormatUtil.DECIMAL.format(product.getProductPrice()) + "zł"};
    }

    public static String[] convertProductToString(String name, Double price){
        return new String[]{ name, FormatUtil.DECIMAL.format(price) + "zł"};
    }
}
