package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * created by sendro on 04.07.17.
 */
public interface IController extends ActionListener {

    @Override
    void actionPerformed(ActionEvent actionEvent);

    void initialize();


}
