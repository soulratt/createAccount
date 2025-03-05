package utils;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

/**
 * Class manage configuration parameters in XML file
 * @author APVJX
 * @author cristian.ulloa@agfa.com
 * @version 1.2
 */
public final class XmlParameter {
    private static final Logger LOGGER = LogManager.getLogger("XmlParameter.java");
    private static final Security SECURITY = new Security();
    private String connStringEi;
    private String userEi;
    private String pwdEi;
    private String connStringPortal;
    private String userPortal;
    private String pwdPortal;
    private String rutRequired;
    private String portalServer;
    private String portalPort;
    private String portalTls;
    private String sendApplication;
    private String sendFacility;
    private String messageType;
    private String messageTypeEvent;
    private String messageProcessing;
    private String messageVersion;
    private String messageCharacterSet;
    private String eventCode;
    private String userPrefix;
    private String issuerId;
    private String useOnlySsn;
    private String useOnlySsnLength;
    private String activeUpdate;
    private String stageProject;
    private String passMayusculas;
    private String passMinusculas;
    private String passEspeciales;
    private String passDigitos;
            
    public XmlParameter() {
        try {
            File fXmlFile = new File("config.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();
            LOGGER.info("Root element :" + doc.getDocumentElement().getNodeName());
            
            NodeList nList1 = doc.getElementsByTagName("dbEi");

            for (int temp = 0; temp < nList1.getLength(); temp++) {
                Node nNode = nList1.item(temp);
                LOGGER.debug("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    LOGGER.debug("connString : " + eElement.getElementsByTagName("connString").item(0).getTextContent());
                    try {
                        setConnStringEi(SECURITY.Decrypt(eElement.getElementsByTagName("connString").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }

                    LOGGER.debug("user : " + eElement.getElementsByTagName("user").item(0).getTextContent());
                    try {
                        setUserEi(SECURITY.Decrypt(eElement.getElementsByTagName("user").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }

                    LOGGER.debug("password : " + eElement.getElementsByTagName("password").item(0).getTextContent());
                    try {
                        setPwdEi(SECURITY.Decrypt(eElement.getElementsByTagName("password").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }
                }
            }
            
            NodeList nList3 = doc.getElementsByTagName("dbPortal");

            for (int temp = 0; temp < nList3.getLength(); temp++) {
                Node nNode = nList3.item(temp);
                LOGGER.debug("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    LOGGER.debug("connString : " + eElement.getElementsByTagName("connString").item(0).getTextContent());
                    try {
                        setConnStringPortal(SECURITY.Decrypt(eElement.getElementsByTagName("connString").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }

                    LOGGER.debug("user : " + eElement.getElementsByTagName("user").item(0).getTextContent());
                    try {
                        setUserPortal(SECURITY.Decrypt(eElement.getElementsByTagName("user").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }

                    LOGGER.debug("password : " + eElement.getElementsByTagName("password").item(0).getTextContent());
                    try {
                        setPwdPortal(SECURITY.Decrypt(eElement.getElementsByTagName("password").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }
                }
            }
            
            NodeList nList2 = doc.getElementsByTagName("settings");

            for (int temp = 0; temp < nList2.getLength(); temp++) {
                Node nNode = nList2.item(temp);
                LOGGER.debug("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    LOGGER.debug("rutRequired : " + eElement.getElementsByTagName("rutRequired").item(0).getTextContent());
                    try {
                        setRutRequired(SECURITY.Decrypt(eElement.getElementsByTagName("rutRequired").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }
                    
                    LOGGER.debug("portalServer : " + eElement.getElementsByTagName("portalServer").item(0).getTextContent());
                    try {
                        setPortalServer(SECURITY.Decrypt(eElement.getElementsByTagName("portalServer").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }
                    
                    LOGGER.debug("portalPort : " + eElement.getElementsByTagName("portalPort").item(0).getTextContent());
                    try {
                        setPortalPort(SECURITY.Decrypt(eElement.getElementsByTagName("portalPort").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }
                    
                    LOGGER.debug("portalTls : " + eElement.getElementsByTagName("portalTls").item(0).getTextContent());
                    try {
                        setPortalTls(SECURITY.Decrypt(eElement.getElementsByTagName("portalTls").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }
                    
                    LOGGER.debug("sendApplication : " + eElement.getElementsByTagName("sendApplication").item(0).getTextContent());
                    try {
                        setSendApplication(SECURITY.Decrypt(eElement.getElementsByTagName("sendApplication").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }
                    
                    LOGGER.debug("sendFacility : " + eElement.getElementsByTagName("sendFacility").item(0).getTextContent());
                    try {
                        setSendFacility(SECURITY.Decrypt(eElement.getElementsByTagName("sendFacility").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }
                    
                    LOGGER.debug("messageType : " + eElement.getElementsByTagName("messageType").item(0).getTextContent());
                    try {
                        setMessageType(SECURITY.Decrypt(eElement.getElementsByTagName("messageType").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }
                    
                    LOGGER.debug("messageTypeEvent : " + eElement.getElementsByTagName("messageTypeEvent").item(0).getTextContent());
                    try {
                        setMessageTypeEvent(SECURITY.Decrypt(eElement.getElementsByTagName("messageTypeEvent").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }
                    
                    LOGGER.debug("messageProcessing : " + eElement.getElementsByTagName("messageProcessing").item(0).getTextContent());
                    try {
                        setMessageProcessing(SECURITY.Decrypt(eElement.getElementsByTagName("messageProcessing").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }
                    
                    LOGGER.debug("messageVersion : " + eElement.getElementsByTagName("messageVersion").item(0).getTextContent());
                    try {
                        setMessageVersion(SECURITY.Decrypt(eElement.getElementsByTagName("messageVersion").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }
                    
                    LOGGER.debug("messageCharacterSet : " + eElement.getElementsByTagName("messageCharacterSet").item(0).getTextContent());
                    try {
                        setMessageCharacterSet(SECURITY.Decrypt(eElement.getElementsByTagName("messageCharacterSet").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }
                    
                    LOGGER.debug("eventCode : " + eElement.getElementsByTagName("eventCode").item(0).getTextContent());
                    try {
                        setEventCode(SECURITY.Decrypt(eElement.getElementsByTagName("eventCode").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }
                    
                    LOGGER.debug("userPrefix : " + eElement.getElementsByTagName("userPrefix").item(0).getTextContent());
                    try {
                        setUserPrefix(SECURITY.Decrypt(eElement.getElementsByTagName("userPrefix").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }
                    
                    LOGGER.debug("issuerId : " + eElement.getElementsByTagName("issuerId").item(0).getTextContent());
                    try {
                        setIssuerId(SECURITY.Decrypt(eElement.getElementsByTagName("issuerId").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }

                    LOGGER.debug("useOnlySsn : " + eElement.getElementsByTagName("useOnlySsn").item(0).getTextContent());
                    try {
                        setUseOnlySsn(SECURITY.Decrypt(eElement.getElementsByTagName("useOnlySsn").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }

                    LOGGER.debug("useOnlySsnLength : " + eElement.getElementsByTagName("useOnlySsnLength").item(0).getTextContent());
                    try {
                        setUseOnlySsnLength(SECURITY.Decrypt(eElement.getElementsByTagName("useOnlySsnLength").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }
                    
                    LOGGER.debug("activeUpdate : " + eElement.getElementsByTagName("activeUpdate").item(0).getTextContent());
                    try {
                        setActiveUpdate(SECURITY.Decrypt(eElement.getElementsByTagName("activeUpdate").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }
                    
                    LOGGER.debug("stageProject : " + eElement.getElementsByTagName("stageProject").item(0).getTextContent());
                    try {
                        setStageProject(SECURITY.Decrypt(eElement.getElementsByTagName("stageProject").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }
                    
                    LOGGER.debug("passMayusculas : " + eElement.getElementsByTagName("passMayusculas").item(0).getTextContent());
                    try {
                       setPassMayusculas(SECURITY.Decrypt(eElement.getElementsByTagName("passMayusculas").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }
                    
                    LOGGER.debug("passMinusculas : " + eElement.getElementsByTagName("passMinusculas").item(0).getTextContent());
                    try {
                        setPassMinusculas(SECURITY.Decrypt(eElement.getElementsByTagName("passMinusculas").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }
                    
                    LOGGER.debug("passEspeciales : " + eElement.getElementsByTagName("passEspeciales").item(0).getTextContent());
                    try {
                        setPassEspeciales(SECURITY.Decrypt(eElement.getElementsByTagName("passEspeciales").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }
                    LOGGER.debug("passDigitos : " + eElement.getElementsByTagName("passDigitos").item(0).getTextContent());
                    try {
                        setPassDigitos(SECURITY.Decrypt(eElement.getElementsByTagName("passDigitos").item(0).getTextContent()));
                    } catch (Exception ex) {
                       LOGGER.error(ex);
                    }
                }
            }
        } catch (IOException | ParserConfigurationException | DOMException | SAXException ex) {
            LOGGER.error(ex.toString());
        }
    }
    
    public void saveXml() {
        try {
            File fXmlFile = new File("config.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();
            LOGGER.info("Root element :" + doc.getDocumentElement().getNodeName());
            
            NodeList nList1 = doc.getElementsByTagName("dbEi");

            for (int temp = 0; temp < nList1.getLength(); temp++) {
                Node nNode = nList1.item(temp);
                LOGGER.debug("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    eElement.getElementsByTagName("connString").item(0).setTextContent(SECURITY.Encrypt(getConnStringEi()));
                    eElement.getElementsByTagName("user").item(0).setTextContent(SECURITY.Encrypt(getUserEi()));
                    eElement.getElementsByTagName("password").item(0).setTextContent(SECURITY.Encrypt(getPwdEi()));
                }
            }
            
            NodeList nList3 = doc.getElementsByTagName("dbPortal");

            for (int temp = 0; temp < nList3.getLength(); temp++) {
                Node nNode = nList3.item(temp);
                LOGGER.debug("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    eElement.getElementsByTagName("connString").item(0).setTextContent(SECURITY.Encrypt(getConnStringPortal()));
                    eElement.getElementsByTagName("user").item(0).setTextContent(SECURITY.Encrypt(getUserPortal()));
                    eElement.getElementsByTagName("password").item(0).setTextContent(SECURITY.Encrypt(getPwdPortal()));
                }
            }
            
            NodeList nList2 = doc.getElementsByTagName("settings");

            for (int temp = 0; temp < nList2.getLength(); temp++) {
                Node nNode = nList2.item(temp);
                LOGGER.debug("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    eElement.getElementsByTagName("rutRequired").item(0).setTextContent(SECURITY.Encrypt(getRutRequired()));
                    eElement.getElementsByTagName("portalServer").item(0).setTextContent(SECURITY.Encrypt(getPortalServer()));
                    eElement.getElementsByTagName("portalPort").item(0).setTextContent(SECURITY.Encrypt(getPortalPort()));
                    eElement.getElementsByTagName("portalTls").item(0).setTextContent(SECURITY.Encrypt(getPortalTls()));
                    eElement.getElementsByTagName("sendApplication").item(0).setTextContent(SECURITY.Encrypt(getSendApplication()));
                    eElement.getElementsByTagName("sendFacility").item(0).setTextContent(SECURITY.Encrypt(getSendFacility()));
                    eElement.getElementsByTagName("messageType").item(0).setTextContent(SECURITY.Encrypt(getMessageType()));
                    eElement.getElementsByTagName("messageTypeEvent").item(0).setTextContent(SECURITY.Encrypt(getMessageTypeEvent()));
                    eElement.getElementsByTagName("messageProcessing").item(0).setTextContent(SECURITY.Encrypt(getMessageProcessing()));
                    eElement.getElementsByTagName("messageVersion").item(0).setTextContent(SECURITY.Encrypt(getMessageVersion()));
                    eElement.getElementsByTagName("messageCharacterSet").item(0).setTextContent(SECURITY.Encrypt(getMessageCharacterSet()));
                    eElement.getElementsByTagName("eventCode").item(0).setTextContent(SECURITY.Encrypt(getEventCode()));
                    eElement.getElementsByTagName("userPrefix").item(0).setTextContent(SECURITY.Encrypt(getUserPrefix()));
                    eElement.getElementsByTagName("issuerId").item(0).setTextContent(SECURITY.Encrypt(getIssuerId()));
                    eElement.getElementsByTagName("useOnlySsn").item(0).setTextContent(SECURITY.Encrypt(getUseOnlySsn()));
                    eElement.getElementsByTagName("useOnlySsnLength").item(0).setTextContent(SECURITY.Encrypt(getUseOnlySsnLength()));
                    eElement.getElementsByTagName("activeUpdate").item(0).setTextContent(SECURITY.Encrypt(getActiveUpdate()));
                    eElement.getElementsByTagName("stageProject").item(0).setTextContent(SECURITY.Encrypt(getStageProject()));
                    eElement.getElementsByTagName("passMayusculas").item(0).setTextContent(SECURITY.Encrypt(getPassMayusculas()));
                    eElement.getElementsByTagName("passMinusculas").item(0).setTextContent(SECURITY.Encrypt(getPassMinusculas()));
                    eElement.getElementsByTagName("passEspeciales").item(0).setTextContent(SECURITY.Encrypt(getPassEspeciales()));
                    eElement.getElementsByTagName("passDigitos").item(0).setTextContent(SECURITY.Encrypt(getPassDigitos()));
                }
            }
            
            try {
                LOGGER.debug("Save changes to xml file");
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
                DOMSource source = new DOMSource(doc);
                StreamResult console = new StreamResult(fXmlFile);
                transformer.transform(source, console);
                LOGGER.debug("File saved successfully");
            } catch (TransformerConfigurationException ex) {
                LOGGER.error(ex.toString());
            } catch (TransformerException ex) {
                LOGGER.error(ex.toString());
            }
            
        } catch (IOException | ParserConfigurationException | DOMException | SAXException ex) {
            LOGGER.error(ex.toString());
        }
    }
    
    public void setConnStringEi(String str) {
        this.connStringEi = str;
    }
    public String getConnStringEi() {
        return this.connStringEi;
    }
    public void setUserEi(String str) {
        this.userEi = str;
    }
    public String getUserEi() {
        return this.userEi;
    }
    public void setPwdEi(String str) {
        this.pwdEi = str;
    }
    public String getPwdEi() {
        return this.pwdEi;
    }
    public void setConnStringPortal(String str) {
        this.connStringPortal = str;
    }
    public String getConnStringPortal() {
        return this.connStringPortal;
    }
    public void setUserPortal(String str) {
        this.userPortal = str;
    }
    public String getUserPortal() {
        return this.userPortal;
    }
    public void setPwdPortal(String str) {
        this.pwdPortal = str;
    }
    public String getPwdPortal() {
        return this.pwdPortal;
    }
    public void setRutRequired(String str) {
        this.rutRequired = str;
    }
    public String getRutRequired() {
        return this.rutRequired;
    }

    public String getPortalServer() {
        return portalServer;
    }

    public void setPortalServer(String portalServer) {
        this.portalServer = portalServer;
    }

    public String getPortalPort() {
        return portalPort;
    }

    public void setPortalPort(String portalPort) {
        this.portalPort = portalPort;
    }

    public String getPortalTls() {
        return portalTls;
    }

    public void setPortalTls(String portalTls) {
        this.portalTls = portalTls;
    }

    public String getSendApplication() {
        return sendApplication;
    }

    public void setSendApplication(String sendApplication) {
        this.sendApplication = sendApplication;
    }

    public String getSendFacility() {
        return sendFacility;
    }

    public void setSendFacility(String sendFacility) {
        this.sendFacility = sendFacility;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessageTypeEvent() {
        return messageTypeEvent;
    }

    public void setMessageTypeEvent(String messageTypeEvent) {
        this.messageTypeEvent = messageTypeEvent;
    }

    public String getMessageProcessing() {
        return messageProcessing;
    }

    public void setMessageProcessing(String messageProcessing) {
        this.messageProcessing = messageProcessing;
    }

    public String getMessageVersion() {
        return messageVersion;
    }

    public void setMessageVersion(String messageVersion) {
        this.messageVersion = messageVersion;
    }

    public String getMessageCharacterSet() {
        return messageCharacterSet;
    }

    public void setMessageCharacterSet(String messageCharacterSet) {
        this.messageCharacterSet = messageCharacterSet;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }
    
    public String getUserPrefix() {
        return userPrefix;
    }

    public void setUserPrefix(String userPrefix) {
        this.userPrefix = userPrefix;
    }
    
    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId;
    }

    public String getUseOnlySsn() {
        return useOnlySsn;
    }

    public void setUseOnlySsn(String useOnlySsn) {
        this.useOnlySsn = useOnlySsn;
    }

    public String getUseOnlySsnLength() {
        return useOnlySsnLength;
    }

    public void setUseOnlySsnLength(String useOnlySsnLength) {
        this.useOnlySsnLength = useOnlySsnLength;
    }
    
    public String getActiveUpdate() {
        return activeUpdate;
    }

    public void setActiveUpdate(String activeUpdate) {
        this.activeUpdate = activeUpdate;
    }
    
    public String getStageProject() {
        return stageProject;
    }

    public void setStageProject(String stageProject) {
        this.stageProject = stageProject;
    }
    
     public String getPassMayusculas() {
        return this.passMayusculas;
    }

    public void setPassMayusculas(String mayusculas) {
        this.passMayusculas = mayusculas;
    }
    
    public String getPassMinusculas() {
        return this.passMinusculas;
    }

    public void setPassMinusculas(String minusculas) {
        this.passMinusculas = minusculas;
    }
    
     public String getPassDigitos() {
        return this.passDigitos;
    }

    public void setPassDigitos(String digitos) {
        this.passDigitos = digitos;
    }
    
    public String getPassEspeciales() {
        return this.passEspeciales;
    }

    public void setPassEspeciales(String especiales) {
        this.passEspeciales= especiales;
    }
    
    
}
