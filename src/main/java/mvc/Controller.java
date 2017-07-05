package mvc;


import io.IScannerStub;
import scan.*;
import java.awt.event.ActionEvent;

/**
 * created by sendro on 04.07.17.
 */
public class Controller implements IController, IScannerStub.ScanCallback {

    private IModel model;
    private IView view;

    public Controller(IModel model, IView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        model.scanProduct(actionEvent.getActionCommand(), this);
    }

    @Override
    public void initialize() {
        view.initialize(this);
    }

    @Override
    public void onScanComplete(IScanResult scanResult) {
        view.print(scanResult);
    }
}
