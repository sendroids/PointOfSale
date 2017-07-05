package views;


import mvc.IController;
import mvc.IView;
import scan.IScanResult;
import scan.ResultPrintAll;
import utils.FormatUtil;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;



/**
 * created by sendro on 04.07.17.
 */
public class MainWindowView extends JFrame implements IView {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private LcdDisplayView lcdDisplayView;
    private PrinterView printerView;
    private ScannerView scannerView;

    public final Dimension windowDimension = new Dimension(WIDTH, HEIGHT);

    @Override
    public void initialize(IController controller) {
        lcdDisplayView = new LcdDisplayView();
        printerView = new PrinterView();
        scannerView = new ScannerView(controller);
        setSize(windowDimension);
        setResizable(false);
        SpringLayout springLayout = new SpringLayout();
        JPanel panel = new JPanel(springLayout);
        panel.add(lcdDisplayView);
        panel.add(printerView);
        panel.add(scannerView);
        add(panel);
        springLayout.putConstraint(SpringLayout.EAST, lcdDisplayView, -10, SpringLayout.EAST, panel);
        springLayout.putConstraint(SpringLayout.NORTH, lcdDisplayView, 10, SpringLayout.NORTH, panel);
        springLayout.putConstraint(SpringLayout.WEST, printerView, 10, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.NORTH, printerView, 10, SpringLayout.NORTH, panel);
        springLayout.putConstraint(SpringLayout.SOUTH, scannerView, -20, SpringLayout.SOUTH, panel);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, scannerView, 0, SpringLayout.HORIZONTAL_CENTER, panel);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void print(IScanResult result) {
        lcdDisplayView.clear();
        printerView.clear();
        if (result.getResult() instanceof String){
            lcdDisplayView.print((String) result.getResult());
        } else if (result.getResult() instanceof String[]){
            lcdDisplayView.print((String[]) result.getResult());
        } else if (result.getResult() instanceof ArrayList){
            ArrayList list = (ArrayList<String[]>) result.getResult();
            double total = ((ResultPrintAll) result).getTotalSum();
            String[] totalRow = FormatUtil.convertProductToString("TOTAL", total);
            list.add(totalRow);
            printerView.print(list);
            lcdDisplayView.print(totalRow);
        }
    }

}
