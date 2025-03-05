package portalaccountcreator;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.Initiator;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.model.v25.message.ADT_A01;
import ca.uhn.hl7v2.model.v25.segment.EVN;
import ca.uhn.hl7v2.model.v25.segment.MSH;
import ca.uhn.hl7v2.model.v25.segment.PID;
import ca.uhn.hl7v2.model.v25.segment.PV1;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.util.idgenerator.FileBasedGenerator;
import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import utils.UtilDateTime;
import utils.XmlParameter;

/**
 * Class manage HL7 message to send
 * @author APVJX
 * @author cristian.ulloa@agfa.com
 * @version 1.3
 */
public class Message {
    private static final Logger LOGGER = LogManager.getLogger("Message");
    private static final XmlParameter xmlParameter = new XmlParameter();
    private final String host = xmlParameter.getPortalServer();
    private final boolean useTls = xmlParameter.getPortalTls().equals("true");
    private final int port = Integer.parseInt(xmlParameter.getPortalPort());
    
    public boolean createMessage(PatientData patientData, String action) throws Exception {
        try {     
            if(action.equals("onlyPrint")) return true;
            if (patientData.getPatientPwd().equals("")) {
                LOGGER.info("Skip HL7 message, password of patient account is required");
                return false;
            }
            
            FileBasedGenerator fileBaseGenerator = new FileBasedGenerator();
            UtilDateTime utilDateTime = new UtilDateTime();

            // Creation ADT message
            ADT_A01 adt1 = new ADT_A01();
            
            // Populate the MSH Segment
            MSH mshSegment = adt1.getMSH();
            // MSH 1.1 Field separator
            mshSegment.getFieldSeparator().setValue("|");
            // MSH 2.2 Encoding characters
            mshSegment.getEncodingCharacters().setValue("^~\\&");
            // MSH 3.1 Sending application
            mshSegment.getSendingApplication().getNamespaceID().setValue(xmlParameter.getSendApplication());
            // MSH 4.1 Sending facility
            mshSegment.getSendingFacility().getNamespaceID().setValue(xmlParameter.getSendFacility());
            // MSH 7.1 Date/time message
            mshSegment.getDateTimeOfMessage().getTime().setValue(utilDateTime.getActualDateTimeHL7Format());
            // MSH 9.1 Message type
            mshSegment.getMessageType().getMessageCode().setValue(xmlParameter.getMessageType());
            // MSH 9.2 Message type event
            mshSegment.getMessageType().getTriggerEvent().setValue(xmlParameter.getMessageTypeEvent());
            // MSH 10.1 Message control id
            mshSegment.getMessageControlID().setValue(fileBaseGenerator.getID());
            // MSH 11.1 Message processing id
            mshSegment.getProcessingID().getProcessingID().setValue(xmlParameter.getMessageProcessing());
            // MSH 12.1 Version id
            mshSegment.getVersionID().getVersionID().setValue(xmlParameter.getMessageVersion());
            // MSH 13.1 Sequence number
            mshSegment.getSequenceNumber().setValue("1");
            // MSH 18.1 Character set 
            mshSegment.getCharacterSet(0).setValue(xmlParameter.getMessageCharacterSet());
            LOGGER.debug("mshSegment generated");
            
            // Populate the EVN segment
            EVN evnSegment = adt1.getEVN();
            // EVN 1.1 Event type code
            evnSegment.getEventTypeCode().setValue(xmlParameter.getEventCode());
            // EVN 2.1 Recorded Date/time
            evnSegment.getRecordedDateTime().getTime().setValue(utilDateTime.getActualDateTimeHL7Format());
            // EVN 6.1 Event occurred
            evnSegment.getEventOccurred().getTime().setValue(utilDateTime.getActualDateTimeHL7Format());
            LOGGER.debug("evnSegment generated");
            
            // Populate the PID Segment
            PID pidSegment = adt1.getPID();
            // PID 3.1 Patient identifier list
            pidSegment.getPatientIdentifierList(0).getIDNumber().setValue(patientData.getPatientId());
            // PID 3.4 Assigning authority 
            pidSegment.getPatientIdentifierList(0).getAssigningAuthority().getNamespaceID().setValue(xmlParameter.getUserPrefix());
            // PID 4.1 Alternate patient id
            pidSegment.getAlternatePatientIDPID(0).getIDNumber().setValue(patientData.getPatientSsn());
            // PID 5.1 Patient name
            pidSegment.getPatientName(0).getFamilyName().getSurname().setValue(patientData.getPatientLasttName());
            // PID 5.2 Patient name
            pidSegment.getPatientName(0).getGivenName().setValue(patientData.getPatientFirstName());
            // PID 7.1 Date/time of birth
            pidSegment.getDateTimeOfBirth().getTime().setValue(patientData.getPatientBirthDate());
            // PID 8.1 Administrative sex
            pidSegment.getAdministrativeSex().setValue(patientData.getPatientSex());
            // PID 13.1 Phone number
            pidSegment.getPhoneNumberHome(0).getTelephoneNumber().setValue(patientData.getPatientPhone());
            // PID 13.1 Telecommunication use code
            pidSegment.getPhoneNumberHome(0).getTelecommunicationUseCode().setValue("PRN");
            // PID 13.1 Telecommunication equipment type
            pidSegment.getPhoneNumberHome(0).getTelecommunicationEquipmentType().setValue("CP");
            // PID 13.2 Phone number
            pidSegment.getPhoneNumberHome(1).getTelephoneNumber().setValue("");
            // PID 13.2 Telecommunication use code
            pidSegment.getPhoneNumberHome(1).getTelecommunicationUseCode().setValue("PRN");
            // PID 13.2 Telecommunication equipment type
            pidSegment.getPhoneNumberHome(1).getTelecommunicationEquipmentType().setValue("FX");
            // PID 13.3 Telecommunication use code
            pidSegment.getPhoneNumberHome(2).getTelecommunicationUseCode().setValue("NET");
            // PID 13.3 Telecommunication equipment type
            pidSegment.getPhoneNumberHome(2).getTelecommunicationEquipmentType().setValue("Internet");
            // PID 13.3 Phone email
            pidSegment.getPhoneNumberHome(2).getEmailAddress().setValue(patientData.getPatientEmail());
            // PID 19.1 SSN number
            pidSegment.getSSNNumberPatient().setValue(patientData.getPatientSsn());
            LOGGER.debug("pidSegment generated");
            
            // Populate the PV1 Segment
            PV1 pv1Segment = adt1.getPV1();
            pv1Segment.getPatientClass().setValue("O");
            LOGGER.debug("pv1Segment generated");
            
            // Populate the ZPI Segment
            adt1.addNonstandardSegment("ZPI");
            Terser te = new Terser(adt1);
            String str1 = "";
            if (action.equals("create")) {
                str1 = "C";
            } else if (action.equals("update")) {
                str1 = "U";
            }
            te.set("ZPI-3-1", str1);
            te.set("ZPI-5-1", patientData.getPatientPwd());
            LOGGER.debug("zpiSegment generated");
            LOGGER.info("HL7 message generated successfully");
            
            // Connection and send HL7 message to server
            HapiContext context = new DefaultHapiContext();
            Connection conn = context.newClient(host, port, useTls);
            Initiator initiator = conn.getInitiator();
            LOGGER.info("Connection to server");
            ca.uhn.hl7v2.model.Message response = initiator.sendAndReceive(adt1);
            Parser p = context.getPipeParser();
            String responseString = p.encode(response);
            LOGGER.info("Received response: " + responseString);
            conn.close();
            
            return responseString.contains("|AA|");
            
        } catch (HL7Exception | LLPException | IOException ex) {
            LOGGER.error(ex);
            return false;
        }
    }
}
