package views;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * created by sendro on 04.07.17.
 */
public class LcdDisplayView extends JPanel{


    private int width = MainWindowView.WIDTH/2;
    private int height = MainWindowView.HEIGHT;
    private JScrollPane scrollPane;
    private JLabel label;
    private JTable table;
    private final String COL_PRODUCT = "Product name";
    private final String COL_PRICE = "Price";

    private final DefaultTableModel tableModel = new DefaultTableModel();


    public LcdDisplayView() {
        setPreferredSize(new Dimension(width, 4 * height / 5));
        initLabel();
        initTable();
        SpringLayout springLayout = new SpringLayout();
        springLayout.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.SOUTH, label);
        springLayout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, this);
        setLayout(springLayout);
        add(label);
        add(scrollPane);
    }

    private void initLabel(){
        label = new JLabel("LcdDisplayView", SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(width, 20));
        label.setForeground(Color.blue);
        label.setFont(new Font(label.getName(), label.getFont().getStyle(), 17));
        label.setOpaque(true);
    }

    private void initTable(){
        table = new JTable(tableModel);
        tableModel.addColumn(COL_PRODUCT);
        tableModel.addColumn(COL_PRICE);
        table.getTableHeader().setReorderingAllowed(false);
        table.setCellSelectionEnabled(false);
        table.setDragEnabled(false);
        table.setRowSelectionAllowed(false);
        table.setColumnSelectionAllowed(false);
        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(width - 20, 7 * height / 10));
        hideTable();
    }

    public void hideTable(){
        scrollPane.setVisible(false);
    }

    public void showTable(){
        scrollPane.setVisible(true);
    }


    public void clear(){
        tableModel.setRowCount(0);
        hideTable();
    }

    public void print(String[] product){
        showTable();
        tableModel.addRow(product);
    }

    public void print(ArrayList<String[]> product){
        showTable();
        for (String[] strings : product) {
            tableModel.addRow(strings);
        }
    }

    public void print(String string){
        showTable();
        String[] message = new String[1];
        message[0] = string;
        tableModel.addRow(message);
    }

}
