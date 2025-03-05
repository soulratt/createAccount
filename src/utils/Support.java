package utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

/**
 * Class support for developers
 * @author APVJX
 * @author cristian.ulloa@agfa.com
 * @version 1.1
 */
public class Support {
    private static final Logger LOGGER = LogManager.getLogger("Support");
    
    public void getParameterEncrypt() {
        Security security = new Security();
        LOGGER.debug("Param rutRequired: " + security.Encrypt("true"));
        // PROD: 10.214.94.48 (OLD)
        // PROD: 10.214.94.60 (NEW)
        // DEV: 192.168.23.52
        LOGGER.debug("------------------------------------------------------");
        LOGGER.debug("DEV  - Param portalServer: " + security.Encrypt("192.168.23.52"));
        LOGGER.debug("PROD - Param portalServer: " + security.Encrypt("10.214.94.60"));
        LOGGER.debug("------------------------------------------------------");
        // PROD: 8002
        // DEV: 8000
        LOGGER.debug("------------------------------------------------------");
        LOGGER.debug("DEV  - Param portalPort: " + security.Encrypt("8000"));
        LOGGER.debug("PROD - Param portalPort: " + security.Encrypt("8002"));
        LOGGER.debug("------------------------------------------------------");
        LOGGER.debug("Param portalTls: " + security.Encrypt("false"));
        LOGGER.debug("Param sendApplication: " + security.Encrypt("AGFA_APP"));
        // Clinica Santa Maria:    CSM
        // Clinica Santa Maria:    CSM_SUC
        // Clinica BioBio:         CLBB
        // VidaIntegra:            CMVI
        // Clinica Vespucio:       CVES
        // Clinica Ciudad del Mar: CCDM
        // Clinica Davila:         CDAV
        // Clinica Davila:         CDAV_SUC
        // Centromed:              CM
        LOGGER.debug("------------------------------------------------------");
        LOGGER.debug("CSM      - Param sendFacility: " + security.Encrypt("CSM"));
        LOGGER.debug("CSM_SUC  - Param sendFacility: " + security.Encrypt("CSM_SUC"));
        LOGGER.debug("CLBB     - Param sendFacility: " + security.Encrypt("CLBB"));
        LOGGER.debug("CMVI     - Param sendFacility: " + security.Encrypt("CMVI"));
        LOGGER.debug("CVES     - Param sendFacility: " + security.Encrypt("CVES"));
        LOGGER.debug("CCDM     - Param sendFacility: " + security.Encrypt("CCDM"));
        LOGGER.debug("CDAV     - Param sendFacility: " + security.Encrypt("CDAV"));
        LOGGER.debug("CDAV_SUC - Param sendFacility: " + security.Encrypt("CDAV_SUC"));
        LOGGER.debug("CM     - Param sendFacility: " + security.Encrypt("CM"));
        LOGGER.debug("CDAV     - Param sendFacility: " + security.Encrypt("CLHP"));
        LOGGER.debug("------------------------------------------------------");
        LOGGER.debug("Param messageType: " + security.Encrypt("ADT"));
        LOGGER.debug("Param messageTypeEvent: " + security.Encrypt("A08"));
        LOGGER.debug("Param messageProcessing: " + security.Encrypt("P"));
        LOGGER.debug("Param messageVersion: " + security.Encrypt("2.5"));
        LOGGER.debug("Param messageCharacterSet: " + security.Encrypt("ISO 8859/1"));
        LOGGER.debug("Param eventCode: " + security.Encrypt("A08"));
        // Clinica Santa Maria:    CSM
        // Clinica BioBio:         CLBB
        // VidaIntegra:            CMVI
        // Clinica Vespucio:       CVES
        // Clinica Ciudad del Mar: CCDM
        // Clinica Davila:         CDAV
        // Centromed:              CMVI
        LOGGER.debug("------------------------------------------------------");
        LOGGER.debug("CSM  - Param userPrefix: " + security.Encrypt("CSM"));
        LOGGER.debug("CLBB - Param userPrefix: " + security.Encrypt("CLBB"));
        LOGGER.debug("CMVI - Param userPrefix: " + security.Encrypt("CMVI"));
        LOGGER.debug("CVES - Param userPrefix: " + security.Encrypt("CVES"));
        LOGGER.debug("CCDM - Param userPrefix: " + security.Encrypt("CCDM"));
        LOGGER.debug("CDAV - Param userPrefix: " + security.Encrypt("CDAV"));
        LOGGER.debug("CMVI - Param userPrefix: " + security.Encrypt("CMVI"));
        LOGGER.debug("------------------------------------------------------");
        // Clinica Santa Maria:    17313
        // Clinica BioBio:         10069
        // VidaIntegra:            15492
        // Clinica Vespucio:       10065
        // Clinica Ciudad del Mar: 10068
        // Clinica Davila:         10062
        // Centromed:              15492
        LOGGER.debug("------------------------------------------------------");
        LOGGER.debug("CSM  - Param issuerId: " + security.Encrypt("17313"));
        LOGGER.debug("CLBB - Param issuerId: " + security.Encrypt("10069"));
        LOGGER.debug("CMVI - Param issuerId: " + security.Encrypt("15492"));
        LOGGER.debug("CVES - Param issuerId: " + security.Encrypt("10065"));
        LOGGER.debug("CCDM - Param issuerId: " + security.Encrypt("10068"));
        LOGGER.debug("CDAV - Param issuerId: " + security.Encrypt("10062"));
        LOGGER.debug("CMVI - Param issuerId: " + security.Encrypt("15492"));
        LOGGER.debug("CLHP - Param issuerId: " + security.Encrypt("10071"));
        LOGGER.debug("------------------------------------------------------");
        // PROD: 10.214.94.11:1521/APROD
        // DEV: 192.168.23.50:1539/XEPDB1
        LOGGER.debug("------------------------------------------------------");
        LOGGER.debug("DEV  - Param DBEi: " + security.Encrypt("jdbc:oracle:thin:@192.168.23.50:1539/XEPDB1"));
        LOGGER.debug("PROD - Param DBEi: " + security.Encrypt("jdbc:oracle:thin:@10.214.94.11:1521/APROD"));
        LOGGER.debug("------------------------------------------------------");
        // PROD: agfa_ro
        // DEV: patient_portal
        LOGGER.debug("------------------------------------------------------");
        LOGGER.debug("DEV  - Param DBuserEi: " + security.Encrypt("patient_portal"));
        LOGGER.debug("PROD - Param DBuserEi: " + security.Encrypt("agfa_ro"));
        LOGGER.debug("------------------------------------------------------");
        // 4gf42w1n
        LOGGER.debug("------------------------------------------------------");
        LOGGER.debug("DEV  - Param DBPassEi: " + security.Encrypt("4gf42w1n"));
        LOGGER.debug("PROD - Param DBPassEi: " + security.Encrypt("4gf42w1n"));
        LOGGER.debug("------------------------------------------------------");
        // PROD: 10.214.94.47:3306/patient_portal (OLD)
        // PROD: 10.214.94.61:3306/patient_portal (NEW)
        // DEV: 192.168.23.41:3306/patient_portal
        LOGGER.debug("------------------------------------------------------");
        LOGGER.debug("DEV  - Param DBPortal: " + security.Encrypt("jdbc:mariadb://192.168.23.41:3306/patient_portal"));
        LOGGER.debug("PROD - Param DBPortal: " + security.Encrypt("jdbc:mariadb://10.214.94.61:3306/keycloak"));
        LOGGER.debug("------------------------------------------------------");
        // PROD: agfa_ro (OLD)
        // PROD: keycloack_ro (NEW)
        // DEV: patient_portal
        LOGGER.debug("------------------------------------------------------");
        LOGGER.debug("DEV  - Param DBuserPortal: " + security.Encrypt("patient_portal"));
        LOGGER.debug("PROD - Param DBuserPortal: " + security.Encrypt("root"));
        LOGGER.debug("------------------------------------------------------");
        // 4gf42w1n
        LOGGER.debug("------------------------------------------------------");
        LOGGER.debug("DEV  - Param DBPassPortal: " + security.Encrypt("4gf42w1n"));
        LOGGER.debug("PROD - Param DBPassPortal: " + security.Encrypt("4gf42w1n"));
        LOGGER.debug("------------------------------------------------------");
        LOGGER.debug("Param useOnlySsn: " + security.Encrypt("true"));
        LOGGER.debug("Param useOnlySsnLength: " + security.Encrypt("5"));
        LOGGER.debug("Param activeUpdate: " + security.Encrypt("false"));
        // Options: DEV, PROD
        LOGGER.debug("------------------------------------------------------");
        LOGGER.debug("DEV  - Param stageProject: " + security.Encrypt("DEV"));
        LOGGER.debug("PROD - Param stageProject: " + security.Encrypt("PROD"));
        LOGGER.debug("------------------------------------------------------");
    } 
}
