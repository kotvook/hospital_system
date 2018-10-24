package edu.epam.trainings.kokotov.dao;

import edu.epam.trainings.kokotov.resource.ConfigurationManager;
import edu.epam.trainings.kokotov.resource.ResourceManager;

import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * The class contains the necessary database connection controls
 *
 * @author    Artem Kokotov
 */
public class DatabaseConnection {

    /** Database user name. */
    final String user = ConfigurationManager.getProperty("user");

    /** Database password.*/
    final String password = ConfigurationManager.getProperty("password");

    /** Database url without settings. */
    final String url = ConfigurationManager.getProperty("url");

    /** Literal for add database setings */
    final String add = ConfigurationManager.getProperty("addSetings");

    /** add Unicode setings. */
    final String useUnicode = ConfigurationManager.getProperty("useUnicode");

    /** add TimezoneShift setings. */
    final String useTimezoneShift = ConfigurationManager.getProperty("useTimezoneShift");

    /** add LegacyDatetimeCode setings. */
    final String useLegacyDatetimeCode = ConfigurationManager.getProperty("useLegacyDatetimeCode");

    /** add Timezone setings. */
    final String serverTimezone = ConfigurationManager.getProperty("serverTimezone");

    /** add SSL setings. */
    final String useSSL = ConfigurationManager.getProperty("useSSL");

    /** All database setings. */
    final String allDbSetings = useUnicode
            +useTimezoneShift
            +useLegacyDatetimeCode
            +serverTimezone
            +useSSL;

    /** Connection of database.*/
    private Connection connection = null;

    /** Logger */
    private static Logger log = Logger.getLogger(DatabaseConnection.class.getName());

    ResourceManager manager = ResourceManager.INSTANCE;
    /**
     * establishing connection with Database.
     *
     */
    public  void establishСonnection() throws SQLException {
        connection= DriverManager.getConnection(url + add +  allDbSetings, user, password);
        log.info(manager.getString("connectionON"));;
    }

    /**
     * closing connection to Database.
     *
     */
    public  void closeConnection () throws SQLException {
        if (connection == null){
            log.info("There was no database connection!");
        } else if (connection.isClosed()){
            log.info("DB connection was closed earlier");
        } else {
            connection.close();
            log.info("Database connection was closed");
        }
    }

    public Connection getConnection (){
        return connection;
    }
}
