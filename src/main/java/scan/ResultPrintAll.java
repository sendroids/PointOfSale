package scan;
import java.util.ArrayList;

/**
 * created by sendro on 04.07.17.
 */
public class ResultPrintAll implements IScanResult<ArrayList<String[]>>{

    private final ArrayList<String[]> printList;
    private double totalSum;

    public ResultPrintAll(ArrayList<String[]> printList, double totalSum) {
        this.printList = printList;
        this.totalSum = totalSum;
    }

    @Override
    public ArrayList<String[]> getResult() {
        return printList;
    }

    public double getTotalSum() {
        return totalSum;
    }
}
