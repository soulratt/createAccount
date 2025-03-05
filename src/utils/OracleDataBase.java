package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

/**
 * Class manage database connections
 * @author APVJX
 * @author cristian.ulloa@agfa.com
 * @version 1.2
 */
public class OracleDataBase {
    private static final Logger LOGGER = LogManager.getLogger("OracleDataBase");
    Connection conn;
    String dbURL;
    String user;
    String password;
    
    public OracleDataBase(String dbUrl, String user, String password) {
        conn = null;
        this.dbURL = dbUrl;
        this.user = user;
        this.password = password;
    }
    
    public Connection connectToOracleDatabase() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            LOGGER.info("Connecting to Oracle Database");
            LOGGER.debug(dbURL);
            conn = DriverManager.getConnection(dbURL, user, password);
            if (conn != null) {
                LOGGER.info("Connected to Oracle database");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            LOGGER.error(ex.toString());
        }
        
        return conn;
    }
    
    public void closeConnection() {
        try {
                conn.close();
                LOGGER.info("Connection closed to Oracle database");
            } catch (SQLException ex) {
                LOGGER.error(ex.toString());
            }
    }
}
