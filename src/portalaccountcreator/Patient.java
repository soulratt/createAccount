package portalaccountcreator;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import utils.OracleDataBase;
import utils.XmlParameter;

/**
 * Class manage patient information
 * @author APVJX
 * @author cristian.ulloa@agfa.com
 * @version 1.2
 */
public class Patient {
    private static final Logger LOGGER = LogManager.getLogger("Patient");
    private static final XmlParameter xmlParameter = new XmlParameter();
    public PatientData patientData = new PatientData();
    
    public PatientData searchPatient(String ssn, String issuerId) 
    {
        if (xmlParameter.getStageProject().equals("DEV2"))
        {
                patientData.setPatientIssuer("CLHP");
                patientData.setPatientId("8-123456");
                patientData.setPatientSsn("16431206-2");
                patientData.setPatientFirstName("Pedro");
                patientData.setPatientLasttName("Pablo");
                patientData.setPatientSex("M");
                patientData.setPatientBirthDate("1122222");
                patientData.setPatientEmail("ar@ar.cl");
                patientData.setPatientPhone("12345");
        }else
        {
            OracleDataBase oracleDBconn = new OracleDataBase(xmlParameter.getConnStringEi(), xmlParameter.getUserEi(), xmlParameter.getPwdEi());
            Connection conn = oracleDBconn.connectToOracleDatabase();
            Statement query;
            ResultSet resultSet = null;

            try {
                query = conn.createStatement();

                if (xmlParameter.getStageProject().equals("PROD"))
                {
                    resultSet = query.executeQuery("select iu.entity_id, pi.pat_id, p.ssn, pn.given_name, pn.family_name, p.pat_sex, p.pat_birthdate " +
                                                         "from AS_CORE.patient p INNER JOIN " +
                                                         "AS_CORE.person_name pn ON p.pat_name_fk=pn.pk INNER JOIN " +
                                                         "AS_CORE.patient_id pi ON p.pk=pi.patient_fk INNER JOIN " +
                                                         "AS_CORE.id_issuer iu ON pi.issuer_fk=iu.pk " +
                                                         "where p.active=1 and pi.issuer_fk=" + xmlParameter.getIssuerId() + " and p.ssn = '" + ssn + "'" +
                                                         "order by pi.pat_id asc");

                }

                if (xmlParameter.getStageProject().equals("DEV")) {
                    resultSet = query.executeQuery("select user_issuer, user_id, user_ssn, user_first_name, user_last_name, user_sex, user_birthdate from CIMPORTUSERPORTAL where user_ssn = '" + ssn + "'");
                }

                while (resultSet.next()) {
                    patientData.setPatientIssuer(resultSet.getString(1));
                    patientData.setPatientId(resultSet.getString(2));
                    patientData.setPatientSsn(resultSet.getString(3));
                    patientData.setPatientFirstName(resultSet.getString(4));
                    patientData.setPatientLasttName(resultSet.getString(5));
                    patientData.setPatientSex(resultSet.getString(6));
                    patientData.setPatientBirthDate(resultSet.getString(7));
                    LOGGER.info("Patient data loaded");
                }

                if (!"".equals(patientData.getPatientId())) {

                    if (xmlParameter.getStageProject().equals("PROD")) {
                        resultSet = query.executeQuery("select DISTINCT pi.pat_id, cc.email " +
                                               "from AS_CORE.patient p INNER JOIN " +
                                               "AS_CORE.person_name pn ON p.pat_name_fk=pn.pk INNER JOIN " +
                                               "AS_CORE.patient_communication_channel pcc ON p.pk=pcc.patient INNER JOIN " +
                                               "AS_CORE.communication_channel cc ON pcc.communication_channel=cc.id and cc.data_type=2 INNER JOIN " +
                                               "AS_CORE.patient_id pi ON p.pk=pi.patient_fk INNER JOIN " +
                                               "AS_CORE.id_issuer iu ON pi.issuer_fk=iu.pk " +
                                               "where p.active=1 and pi.issuer_fk=" + xmlParameter.getIssuerId() + " and pi.pat_id = '" + patientData.getPatientId() + "'");
                    }

                    if (xmlParameter.getStageProject().equals("DEV")) {
                        resultSet = query.executeQuery("select user_id, user_email from CIMPORTUSERPORTAL where user_id = '" + patientData.getPatientId() + "'");
                    }

                    while (resultSet.next()) {
                        patientData.setPatientEmail(resultSet.getString(2));
                        LOGGER.info("Patient email loaded");
                    }

                    if (patientData.getPatientEmail() == null) {
                        patientData.setPatientEmail("noemail@noemail.com");
                    } else if (patientData.getPatientEmail().isEmpty()) {
                        patientData.setPatientEmail("noemail@noemail.com");
                    }

                    if (xmlParameter.getStageProject().equals("PROD")) {
                        resultSet = query.executeQuery("select DISTINCT pi.pat_id, SUBSTR(cc.telephone_number, 2, 10) " +
                                               "from AS_CORE.patient p INNER JOIN " +
                                               "AS_CORE.person_name pn ON p.pat_name_fk=pn.pk INNER JOIN " +
                                               "AS_CORE.patient_communication_channel pcc ON p.pk=pcc.patient INNER JOIN " +
                                               "AS_CORE.communication_channel cc ON pcc.communication_channel=cc.id and cc.data_type=0 INNER JOIN " +
                                               "AS_CORE.patient_id pi ON p.pk=pi.patient_fk INNER JOIN " +
                                               "AS_CORE.id_issuer iu ON pi.issuer_fk=iu.pk " +
                                               "where p.active=1 and pi.issuer_fk=" + xmlParameter.getIssuerId() + " and pi.pat_id = '" + patientData.getPatientId() + "'");
                    }

                    if (xmlParameter.getStageProject().equals("DEV")) {
                        resultSet = query.executeQuery("select user_id, user_phone from CIMPORTUSERPORTAL where user_id = '" + patientData.getPatientId() + "'");
                    }

                    while (resultSet.next()) {
                        patientData.setPatientPhone(resultSet.getString(2));
                        LOGGER.info("Patient phone loaded");
                    }

                    if (patientData.getPatientPhone() == null) {
                        patientData.setPatientPhone("99999999");
                        LOGGER.info("Patient phone not available from source, replaced");
                    } else if (patientData.getPatientPhone().length() < 8){
                        patientData.setPatientPhone("99999999");
                        LOGGER.info("Patient phone not available from source, replaced");
                    }
                }

                oracleDBconn.closeConnection();

                generatePatientPwd();

            } catch (SQLException ex) {
                LOGGER.error(ex);
            }
        }
        return patientData;
    }
    
    private void generatePatientPwd() {
        String temp ="";
        String sufix = generateRandomSufix();
        if (patientData.getPatientFirstName().length() > 0 && patientData.getPatientLasttName().length() > 0) {
            if (xmlParameter.getUseOnlySsn().equals("true")) {
                temp = patientData.getPatientSsn().substring(0, 5);
            } else {
               /* temp = patientData.getPatientFirstName().substring(0, 1) +
                        patientData.getPatientLasttName().substring(0, 1).toLowerCase() + 
                        "." + 
                        patientData.getPatientSsn().substring(0, parseInt(xmlParameter.getUseOnlySsnLength()));*/
               temp = sufix;
            }
            
            if (temp.length() > 0) {
                patientData.setPatientPwd(temp);
                LOGGER.info("Patient password created");
            } else {
                LOGGER.error("Patient password not created, length is zero");
            }
        } else {
            LOGGER.error("Patient password not created");
        }
    }
    
    public String generateRandomSufix()
    {
        String lettersU = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lettersL = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String characters = "!*@.#";
        
        StringBuilder sb = new StringBuilder(3); 
        
        for(int i = 0;i<Integer.parseInt(xmlParameter.getPassMayusculas());i++)
        {
            int indexLettersU = (int)(lettersU.length()*Math.random());
            sb.append(lettersU.charAt(indexLettersU)); 
        }
         for(int i = 0;i<Integer.parseInt(xmlParameter.getPassMinusculas());i++)
        {
            int indexLettersL = (int)(lettersL.length()*Math.random());
            sb.append(lettersL.charAt(indexLettersL)); 
        }
          for(int i = 0;i<Integer.parseInt(xmlParameter.getPassEspeciales());i++)
        {
            int indexCharacters = (int)(characters.length()*Math.random());
            sb.append(characters.charAt(indexCharacters)); 
            
        }
            for(int i = 0;i<Integer.parseInt(xmlParameter.getPassDigitos());i++)
        {
             int indexNumbers = (int)(numbers.length()*Math.random());
               sb.append(numbers.charAt(indexNumbers)); 
        }
        
        
        
        
        
        
        
        
        return sb.toString();
    }
}
