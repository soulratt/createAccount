package portalaccountcreator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

/**
 * Class manage patient data
 * @author APVJX
 * @author cristian.ulloa@agfa.com
 * @version 3.0
 * Updates AXLOF walter.westermeier@agfa.com
 */
public class PatientData {
    private static final Logger LOGGER = LogManager.getLogger("Patient");

    private String patientIssuer;
    private String patientId;
    private String patientSsn;
    private String patientFirstName;
    private String patientLasttName;
    private String patientBirthDate;
    private String patientSex;
    private String patientEmail;
    private String patientPwd;
    private String patientPhone;
    
    public PatientData() {
        this.patientIssuer = "";
        this.patientId = "";
        this.patientSsn = "";
        this.patientFirstName = "";
        this.patientLasttName = "";
        this.patientBirthDate = "";
        this.patientSex = "";
        this.patientEmail = "";
        this.patientPwd = "";
        this.patientPhone = "";
    }

    public String getPatientIssuer() {
        return patientIssuer;
    }

    public void setPatientIssuer(String patientIssuer) {
        this.patientIssuer = patientIssuer;
    }
    
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientSsn() {
        return patientSsn;
    }

    public void setPatientSsn(String patientSsn) {
        this.patientSsn = patientSsn;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLasttName() {
        return patientLasttName;
    }

    public void setPatientLasttName(String patientLasttName) {
        this.patientLasttName = patientLasttName;
    }

    public String getPatientBirthDate() {
        return patientBirthDate;
    }

    public void setPatientBirthDate(String patientBirthDate) {
        this.patientBirthDate = patientBirthDate;
    }

    public String getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getPatientPwd() {
        return patientPwd;
    }

    public void setPatientPwd(String patientPwd) {
        this.patientPwd = patientPwd;
    }
    
    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }
}
