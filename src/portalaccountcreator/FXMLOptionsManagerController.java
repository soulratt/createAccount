/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package portalaccountcreator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import utils.XmlParameter;

/**
 * FXML Controller class
 *
 * @author axlof
 */
public class FXMLOptionsManagerController implements Initializable {
    private  XmlParameter xmlParameter = new XmlParameter();
    @FXML
    private Button btnLoadData;
    @FXML
    private Button btnSaveData;
    @FXML
    private TextField txtIssuerId;
    @FXML 
    private TextField txtConnString;
    @FXML 
    private TextField txtUserEI;
    @FXML 
    private TextField txtPwdEI;
    @FXML 
    private TextField txtConnStringPortal;
    @FXML 
    private TextField txtUserPortal;
    @FXML 
    private TextField txtPwdPortal;
    @FXML 
    private TextField txtReqRut;
    @FXML 
    private TextField txtPortalServer;
    @FXML 
    private TextField txtPortalPort;
    @FXML 
    private TextField txtPortalTLS;
    @FXML 
    private TextField txtSendApp;
    @FXML 
    private TextField txtSendFacility;
    @FXML 
    private TextField txtMessageType;
    @FXML 
    private TextField txtMessageTypeEvent;
    @FXML 
    private TextField txtMessageProcessing;
    @FXML 
    private TextField txtMessageVersion;
    @FXML 
    private TextField txtuserPrefix;
    @FXML 
    private TextField txtEventCode;
    @FXML 
    private TextField txtmessageCharacterSet;
    @FXML 
    private TextField txtuseOnlySsn;
    @FXML 
    private TextField txtUseOnlySsnLength;
    @FXML 
    private TextField txtactiveUpdate;
    @FXML 
    private TextField txtStageProject;
     @FXML 
    private TextField txtMayusculas;
    @FXML 
    private TextField txtEspeciales;
    @FXML 
    private TextField txtDigitos;
    @FXML 
    private TextField txtMinusculas;
    
    
    
    public void btnHandleLoadData(Event e)
    {
        txtConnString.setText(xmlParameter.getConnStringEi());
        txtIssuerId.setText(xmlParameter.getIssuerId());
        txtUserEI.setText(xmlParameter.getUserEi());
        txtPwdEI.setText(xmlParameter.getPwdEi());
        txtConnStringPortal.setText(xmlParameter.getConnStringPortal());
        txtUserPortal.setText(xmlParameter.getUserPortal());
        txtPwdPortal.setText(xmlParameter.getPwdPortal());
        txtReqRut.setText(xmlParameter.getRutRequired());
        txtPortalServer.setText(xmlParameter.getPortalServer());
        txtPortalPort.setText(xmlParameter.getPortalPort());
        txtPortalTLS.setText(xmlParameter.getPortalTls());
        txtSendApp.setText(xmlParameter.getSendApplication());
        txtSendFacility.setText(xmlParameter.getSendFacility());
        txtMessageType.setText(xmlParameter.getMessageType());
        txtMessageTypeEvent.setText(xmlParameter.getMessageTypeEvent());
        txtMessageProcessing.setText(xmlParameter.getMessageProcessing());
        txtMessageVersion.setText(xmlParameter.getMessageVersion());
        txtuserPrefix.setText(xmlParameter.getUserPrefix());
        txtEventCode.setText(xmlParameter.getEventCode());
        txtmessageCharacterSet.setText(xmlParameter.getMessageCharacterSet());
        txtuseOnlySsn.setText(xmlParameter.getUseOnlySsn());
        txtUseOnlySsnLength.setText(xmlParameter.getUseOnlySsnLength());
        txtactiveUpdate.setText(xmlParameter.getActiveUpdate());
        txtStageProject.setText(xmlParameter.getStageProject());
        txtMayusculas.setText(xmlParameter.getPassMayusculas());
        txtMinusculas.setText(xmlParameter.getPassMinusculas());
        txtEspeciales.setText(xmlParameter.getPassEspeciales());
        txtDigitos.setText(xmlParameter.getPassDigitos());
    }
    
     public void btnHandleSaveData(Event e)
    {
        xmlParameter.setIssuerId(txtIssuerId.getText());
        xmlParameter.setConnStringEi(txtConnString.getText());
        xmlParameter.setUserEi(txtUserEI.getText());
        xmlParameter.setPwdEi(txtPwdEI.getText());
        xmlParameter.setConnStringPortal(txtConnStringPortal.getText());
        xmlParameter.setUserPortal(txtUserPortal.getText());
        xmlParameter.setPwdPortal(txtPwdPortal.getText());
        xmlParameter.setRutRequired(txtReqRut.getText());
        xmlParameter.setPortalServer(txtPortalServer.getText());
        xmlParameter.setPortalPort(txtPortalPort.getText());
        xmlParameter.setPortalTls(txtPortalTLS.getText());
        xmlParameter.setSendApplication(txtSendApp.getText());
        xmlParameter.setSendFacility(txtSendFacility.getText());
        xmlParameter.setMessageType(txtMessageType.getText());
        xmlParameter.setMessageTypeEvent(txtMessageTypeEvent.getText());
        xmlParameter.setMessageProcessing(txtMessageProcessing.getText());
        xmlParameter.setMessageVersion(txtMessageVersion.getText());
        xmlParameter.setUserPrefix(txtuserPrefix.getText());
        xmlParameter.setEventCode(txtEventCode.getText());
        xmlParameter.setMessageCharacterSet(txtmessageCharacterSet.getText());
        xmlParameter.setUseOnlySsn(txtuseOnlySsn.getText());
        xmlParameter.setUseOnlySsnLength(txtUseOnlySsnLength.getText());
        xmlParameter.setActiveUpdate(txtactiveUpdate.getText());
        xmlParameter.setStageProject(txtStageProject.getText());
        xmlParameter.setPassMayusculas(txtMayusculas.getText());
        xmlParameter.setPassMinusculas(txtMinusculas.getText());
        xmlParameter.setPassEspeciales(txtEspeciales.getText());
        xmlParameter.setPassDigitos(txtDigitos.getText());
        
        Alert alert = new Alert((Alert.AlertType.INFORMATION));
        alert.setTitle("Information");
        alert.setHeaderText("Information");
        alert.setContentText("Reiniciar aplicacion, para cargar cambios realizados.");
        alert.showAndWait();
        
        xmlParameter.saveXml();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
