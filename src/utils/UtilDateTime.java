package utils;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.Date;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

/**
 * Class formats input/output for date/time values
 * @author APVJX
 * @author cristian.ulloa@agfa.com
 * @version 1.0
 */
public class UtilDateTime {
    private static final Logger LOGGER = LogManager.getLogger("UtilDateTime");
    
    public String getActualDateTimeHL7Format() {
         try {
                return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            } catch (DateTimeParseException ex) {
                LOGGER.error(ex);
                return "";
            }
    }
}
