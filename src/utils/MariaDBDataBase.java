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
public class MariaDBDataBase {
    private static final Logger LOGGER = LogManager.getLogger("MariaDBDataBase");
    Connection conn;
    String dbURL;
    String user;
    String password;
    
    public MariaDBDataBase(String dbUrl, String user, String password) {
        conn = null;
        this.dbURL = dbUrl;
        this.user = user;
        this.password = password;
    }
    
    public Connection connectToMariaDbDatabase() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            LOGGER.info("Connecting to MariaDB Database");
            LOGGER.debug(dbURL);
            conn = DriverManager.getConnection(dbURL, user, password);
            if (conn != null) {
                LOGGER.info("Connected to MariaDB database");
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
