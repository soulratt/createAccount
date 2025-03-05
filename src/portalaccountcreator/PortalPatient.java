package portalaccountcreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.MariaDBDataBase;
import utils.XmlParameter;

/**
 * Class manage portal patient information
 * @author APVJX
 * @author cristian.ulloa@agfa.com
 * @version 1.1
 */
public class PortalPatient {
    private static final Logger LOGGER = LogManager.getLogger("Patient");
    private static final XmlParameter xmlParameter = new XmlParameter();
    
    public boolean checkPatientPortal(String patientId) {
        if (xmlParameter.getStageProject().equals("DEV2")) return true;
        boolean patientExists = false;
        MariaDBDataBase mariaDbDBconn = new MariaDBDataBase(xmlParameter.getConnStringPortal(), xmlParameter.getUserPortal(), xmlParameter.getPwdPortal());
        Connection conn = mariaDbDBconn.connectToMariaDbDatabase();
        Statement query;
        ResultSet resultSet = null;
        
        try {
            query = conn.createStatement();
            
            if (xmlParameter.getStageProject().equals("DEV")) {
                resultSet = query.executeQuery("SELECT user_id, user_first_name, user_last_name, user_ssn FROM users WHERE user_id = '" + patientId + "'");
            }
            
            if (xmlParameter.getStageProject().equals("PROD")) {
                resultSet = query.executeQuery("SELECT ue.USERNAME, ue.FIRST_NAME, ue.LAST_NAME, ue.EMAIL, kg.NAME, ua.VALUE " +
                                                        "from USER_ENTITY ue INNER JOIN " +
                                                        "USER_GROUP_MEMBERSHIP ugm ON ue.ID=ugm.USER_ID INNER JOIN " +
                                                        "KEYCLOAK_GROUP kg ON ugm.GROUP_ID=kg.ID AND kg.NAME='Patient' INNER JOIN " +
                                                        "USER_ATTRIBUTE ua ON ue.ID=ua.USER_ID AND ua.NAME='id'" +
                                                        "WHERE ua.VALUE ='" + patientId + "'");
            }
            
            while (resultSet.next()) {
                patientExists = true;
                LOGGER.info("Patient exists in Xero Portal");
            }
            
            mariaDbDBconn.closeConnection();
            
            } catch (SQLException ex) {
            LOGGER.error(ex);
        }
        
        return patientExists;
    }
}
