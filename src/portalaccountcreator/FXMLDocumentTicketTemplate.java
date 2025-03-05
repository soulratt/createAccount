package portalaccountcreator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import utils.XmlParameter;

/**
 * Class manage template of ticket to print
 * @author APVJX
 * @author cristian.ulloa@agfa.com
 * @version 1.2
 */
public class FXMLDocumentTicketTemplate implements Initializable {
    private static final Logger LOGGER = LogManager.getLogger("FXMLDocumentTicketTemplate");
    private static final XmlParameter xmlParameter = new XmlParameter();

    @FXML
    private Label patientName;
    @FXML
    private Label patientUserName;
    @FXML
    private Label patientPassword;
    @FXML
    private Label lblPwd;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void patientInfo(String patientFirstName, String patientLastName, String ssn, String patientPwd,Boolean seePassword) {
        LOGGER.info("Data received from main FXML control");
        patientName.setText(patientFirstName.concat(" ").concat(patientLastName));
        //patientUserName.setText(xmlParameter.getUserPrefix() + ssn);
        patientUserName.setText(ssn);
        patientPassword.setText(patientPwd);
        patientPassword.setVisible(seePassword);
        lblPwd.setVisible(seePassword);
    }
}
