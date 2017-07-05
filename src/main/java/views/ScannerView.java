package views;

import io.Scanner;
import mvc.IController;

import javax.swing.*;

/**
 * created by sendro on 04.07.17.
 */
public class ScannerView extends JPanel {

    private JButton scanButton;
    private JButton notFoundButton;
    private JButton emptyScanButton;
    private JButton exitButton;

    public ScannerView(IController controller) {
      initialize(controller);
    }

    private void initialize(IController controller){
        scanButton = new JButton("Product scanned");
        notFoundButton = new JButton("Product not found");
        emptyScanButton = new JButton("Empty scan");
        exitButton = new JButton("Exit and print");

        scanButton.setActionCommand(Scanner.SCAN_OK);
        scanButton.addActionListener(controller);

        notFoundButton.setActionCommand(Scanner.SCAN_NOT_FOUND);
        notFoundButton.addActionListener(controller);

        emptyScanButton.setActionCommand(Scanner.SCAN_EMPTY);
        emptyScanButton.addActionListener(controller);

        exitButton.setActionCommand(Scanner.EXIT_AND_PRINT_ALL);
        exitButton.addActionListener(controller);

        add(scanButton);
        add(notFoundButton);
        add(emptyScanButton);
        add(exitButton);
    }
}
