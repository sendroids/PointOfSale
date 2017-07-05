package mvc;


import scan.IScanResult;

/**
 * created by sendro on 04.07.17.
 */
public interface IView {

    void initialize(IController controller);

    void print(IScanResult result);

}
