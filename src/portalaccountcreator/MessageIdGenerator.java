package portalaccountcreator;

import ca.uhn.hl7v2.util.idgenerator.IDGenerator;
import java.io.IOException;
import java.util.UUID;

/**
 * Class generate HL7 ID
 * @author APVJX
 * @author cristian.ulloa@agfa.com
 * @version 1.0
 */
public class MessageIdGenerator implements IDGenerator{
    
    @Override
    public String getID() throws IOException {
        return UUID.randomUUID().toString();
    }
}
