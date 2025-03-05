package portalaccountcreator;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import utils.PrintFX;
import utils.Support;
import utils.XmlParameter;

/**
 * Class manage main document controller
 * @author APVJX
 * @author cristian.ulloa@agfa.com
 * @version 1.3
 */
public class FXMLDocumentController implements Initializable {
   // private static final Logger LOGGER = LogManager.getLogger("FXMLDocumentController");
    private static final XmlParameter xmlParameter = new XmlParameter();
    
    @FXML
    private Button buttonAccept;
    
    @FXML
    private PasswordField txtPass;
    
    @FXML
    private Button btnOptions;
    
    @FXML
    private TextField patientSsn;
    
    @FXML
    private RadioButton actionCreate;
    
    @FXML private Button buttonCancel;
    
    @FXML private Label lblOptions;
    
    @FXML
    private RadioButton actionUpdate;
    
    @FXML
    private RadioButton actionOnlyPrint;
    
    @FXML
    private ToggleGroup action;
    
    @FXML
    private Pane ticketTemplate;
    
    @FXML
    private Label patientName;
    
    @FXML
    private Label patientRut;
    
    @FXML
    private Label labelPatientName;
    
    @FXML
    private Label labelPatientRut;
    
       
    private PatientData patientData;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        if (patientSsn.getText().isEmpty() == false) {
         //   LOGGER.info("Patient SSN: " + patientSsn.getText());
            if (actionCreate.isSelected()) {
           //   LOGGER.info("Create account");
                printInfoPatient("create");
            }
            if (actionUpdate.isSelected()) {
             // LOGGER.info("Update account");
                printInfoPatient("update");
            }
            if (actionOnlyPrint.isSelected()) {
               // LOGGER.info("Only Print");
                printInfoPatient("onlyPrint");
            }
        } else {
            showAlertWindow(Alert.AlertType.ERROR, "Agfa HealthCare", "Debe ingresar el rut del paciente y presionar el botón Buscar para continuar", "");
        //    LOGGER.info("RUT required");
        }
    }
    
    @FXML
    private void handleButtonReset(ActionEvent event) {
      //  LOGGER.info("Reset SSN");
        patientSsn.setText("");
        setComponentVisible(false);
        actionOnlyPrint.setVisible(false);
        
       // Support support = new Support();
        //support.getParameterEncrypt();
    }
    
    @FXML
    private void handleButtonSufix(ActionEvent event) {
        //LOGGER.info("Reset SSN");
       
       Patient p = new Patient(); 
        patientSsn.setText(p.generateRandomSufix());
        
        //Support support = new Support();
       // support.getParameterEncrypt();
    }
    @FXML
    public void handleLblOptions(ActionEvent event) throws IOException {
       // LOGGER.info("Open Options");
                
        if((txtPass.getText()).equals("4gf42w1n"))
        {
            Parent rootOpt = FXMLLoader.load(getClass().getClassLoader().getResource("FXMLOptionsManager.fxml"));
            Scene sceneOpt = new Scene(rootOpt);

            Stage stageOpt = new Stage();
            stageOpt.setTitle("Agfa HealthCare - Portal de pacientes - Opciones");     
            stageOpt.setScene(sceneOpt);
            stageOpt.initModality(Modality.NONE);
            stageOpt.show();
        }else
        {
                JOptionPane.showMessageDialog(null, "Password incorrecta");
        }
        
    }
    
    @FXML
    private void handleButtonSearch(ActionEvent event) {
        if (!patientSsn.getText().isEmpty()) {
           // LOGGER.info("Search patient information");
            try {
                Patient patient = new Patient();
                PortalPatient portalPatient = new PortalPatient();
                patientData = patient.searchPatient(patientSsn.getText(), xmlParameter.getIssuerId());
                if (!"".equals(patientData.getPatientId())) {
                    setComponentVisible(true);
                    patientName.setText(patientData.getPatientFirstName() + " " + patientData.getPatientLasttName());
                    patientRut.setText(patientSsn.getText());
                    buttonAccept.setDisable(false);
                    if (portalPatient.checkPatientPortal(patientData.getPatientId())) {
                        showAlertWindow(Alert.AlertType.ERROR, "Agfa HealthCare", "El paciente ya tiene una cuenta de usuario en Portal Paciente","Puede actualizar la contraseña directo en la administración del portal o reimprimir usuario");
                        actionUpdate.selectedProperty().set(true);
                        actionUpdate.disableProperty().set(false);
                        actionCreate.disableProperty().set(true);
                        actionOnlyPrint.setVisible(true);
                        actionOnlyPrint.setSelected(true);
                        buttonAccept.setDisable(false);
                      //  LOGGER.info("Patient exists in portal");
                    } else {
                        showAlertWindow(Alert.AlertType.ERROR, "Agfa HealthCare", "El paciente NO tiene una cuenta de usuario en Portal Paciente","Solo podra crear la cuenta de usuario");
                        actionCreate.selectedProperty().set(true);
                        actionCreate.disableProperty().set(false);
                        actionUpdate.disableProperty().set(true);
                        actionOnlyPrint.setVisible(false);
                        buttonAccept.setDisable(false);
                       // LOGGER.info("Patient not exists in portal");
                    }
                } else {
                    setComponentVisible(false);
                    buttonAccept.setDisable(true);
                    showAlertWindow(Alert.AlertType.INFORMATION, "Agfa HealthCare", "Paciente no encontrado en el sistema", "");
                  //  LOGGER.info("Patient not found");
                }
                
                if (patientData.getPatientEmail().equals("noemail@noemail.com")) {
                    showAlertWindow(Alert.AlertType.WARNING, "Agfa HealthCare", "El paciente no registra correo electrónico", "Puede actualizar los datos posteriormente en el portal paciente");
                }
                
                if (patientData.getPatientPhone().equals("99999999")) {
                    showAlertWindow(Alert.AlertType.WARNING, "Agfa HealthCare", "El paciente no registra teléfono móvil", "Puede actualizar los datos posteriormente en el portal paciente");
                }
                
            } catch (Exception ex) {
                showAlertWindow(Alert.AlertType.ERROR, "Agfa HealthCare", "Ha ocurrido un error el buscar al paciente", "Intentelo nuevamente, si el problema persiste contacte a Soporte");
               // LOGGER.error(ex);
            }    
        } else {
            showAlertWindow(Alert.AlertType.ERROR, "Agfa HealthCare", "Debe ingresar el rut del paciente, para continuar", "");
          //  LOGGER.info("RUT required");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        buttonAccept.setDisable(true);
        
        setComponentVisible(false);
        actionOnlyPrint.setVisible(false);
        btnOptions.setVisible(false);
        txtPass.setVisible(false);
        
        if (xmlParameter != null && xmlParameter.getActiveUpdate() != null && xmlParameter.getActiveUpdate().equals("false")){
            actionUpdate.setVisible(false);
            
        } else {
            actionUpdate.setVisible(true);
        }
    }
    
    private void printInfoPatient(String action) {
        ticketTemplate = null;
        try {
            
            Message message = new Message();
            boolean result = message.createMessage(patientData, action);
            
            if (result ) {
                FXMLLoader loader; 
                
                switch(xmlParameter.getSendFacility()) {
                    case "CSM":
                        loader = new FXMLLoader(getClass().getClassLoader().getResource("FXMLDocumentTicketTemplate_CSM.fxml"));
                    break;
                    case "CSM_SUC":
                        loader = new FXMLLoader(getClass().getClassLoader().getResource("FXMLDocumentTicketTemplate_CSM_SUC.fxml"));
                    break;
                    case "CLBB":
                        loader = new FXMLLoader(getClass().getClassLoader().getResource("FXMLDocumentTicketTemplate_CLBB.fxml"));
                    break;
                    case "CMVI":
                        loader = new FXMLLoader(getClass().getClassLoader().getResource("FXMLDocumentTicketTemplate_CMVI.fxml"));
                    break;
                    case "CVES":
                        loader = new FXMLLoader(getClass().getClassLoader().getResource("FXMLDocumentTicketTemplate_CVES.fxml"));
                    break;
                    case "CCDM":
                        loader = new FXMLLoader(getClass().getClassLoader().getResource("FXMLDocumentTicketTemplate_CCDM.fxml"));
                    break;
                    case "CDAV":
                        loader = new FXMLLoader(getClass().getClassLoader().getResource("FXMLDocumentTicketTemplate_CDAV.fxml"));
                    break;
                    case "CDAV_SUC":
                        loader = new FXMLLoader(getClass().getClassLoader().getResource("FXMLDocumentTicketTemplate_CDAV_SUC.fxml"));
                    break;
                    case "CM":
                        loader = new FXMLLoader(getClass().getClassLoader().getResource("FXMLDocumentTicketTemplate_CM.fxml"));
                    break;
                    case "CLHP":
                        loader = new FXMLLoader(getClass().getClassLoader().getResource("FXMLDocumentTicketTemplate_CHP.fxml"));
                    break;
                    default:
                        loader = new FXMLLoader(getClass().getClassLoader().getResource("FXMLDocumentTicketTemplate.fxml"));
                }
                
                ticketTemplate = loader.load();
                FXMLDocumentTicketTemplate fxmlDocumentTicketTemplate = loader.getController();
                boolean sp=true;
                if(action.equals("onlyPrint"))sp=false;
                fxmlDocumentTicketTemplate.patientInfo(patientData.getPatientFirstName(), patientData.getPatientLasttName(), patientSsn.getText(), patientData.getPatientPwd(),sp);
                PrintFX printTkt = new PrintFX();
                printTkt.print(ticketTemplate);
               // LOGGER.info("New ticket printed");
                setComponentVisible(false);
                patientSsn.setText("");
                buttonAccept.setDisable(true);
                actionOnlyPrint.setVisible(false);
                showAlertWindow(Alert.AlertType.INFORMATION, "Agfa HealthCare", "La acción solicitada se proceso correctamente!", "");
             //   LOGGER.info("Process complete");
            } else {
                showAlertWindow(Alert.AlertType.WARNING, "Agfa HealthCare", "Ha ocurrido un error el procesar la solicitud", "Intentelo nuevamente, si el problema persiste contacte a Soporte");
              //  LOGGER.info("Error process message or print information");
            }
            
        } catch (IOException ex) {
            showAlertWindow(Alert.AlertType.ERROR, "Agfa HealthCare", "Ha ocurrido un error el procesar la solicitud", "Intentelo nuevamente, si el problema persiste contacte a Soporte");
          //  LOGGER.error(ex);
        } catch (Exception ex) {
            showAlertWindow(Alert.AlertType.ERROR, "Agfa HealthCare", "Ha ocurrido un error el procesar la solicitud", "Intentelo nuevamente, si el problema persiste contacte a Soporte");
          //  LOGGER.error(ex);
        }
    }
    
    private void setComponentVisible(boolean status) {
            labelPatientName.setVisible(status);
            labelPatientRut.setVisible(status);
            patientName.setVisible(status);
            patientRut.setVisible(status);
            btnOptions.setVisible(false);
            actionCreate.disableProperty().set(false);
            actionUpdate.disableProperty().set(false);
            actionCreate.selectedProperty().set(true);
    }
    
    public void setOptionsTrue()
    {
       
        btnOptions.setVisible(!btnOptions.visibleProperty().getValue());
        txtPass.setVisible(!txtPass.visibleProperty().getValue());
    }
    
    private void showAlertWindow(Alert.AlertType alertType, String title, String headerText, String contentText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }  
}
