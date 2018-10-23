package edu.epam.trainings.kokotov.dao;

import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * The class contains the necessary database connection controls
 *
 * @author    Artem Kokotov
 */
public class DatabaseConnection {

    ResourceBundle resource = ResourceBundle.getBundle("dbSetings");

    final String url = resource.getString("url");

    /** Database user name. */
    final String user = resource.getString("user");

    /** Database user password.*/
    final String password = resource.getString("password");

    /** Literal for add database setings */
    final String add = resource.getString("addSetings");

    /** add Unicode setings. */
    final String useUnicode = resource.getString("useUnicode");

    /** add TimezoneShift setings. */
    final String useTimezoneShift = resource.getString("useTimezoneShift");

    /** add LegacyDatetimeCode setings. */
    final String useLegacyDatetimeCode = resource.getString("useLegacyDatetimeCode");

    /** add Timezone setings. */
    final String serverTimezone = resource.getString("serverTimezone");

    /** add SSL setings. */
    final String useSSL = resource.getString("useSSL");

    /** All database setings. */
    final String allDbSetings = add
            +useUnicode
            +useTimezoneShift
            +useLegacyDatetimeCode
            +serverTimezone
            +useSSL;

    /** Connection of database.*/
    private Connection connection = null;

    /** Logger */
    private static Logger log = Logger.getLogger(DatabaseConnection.class.getName());

    /**
     * establishing connection with Database.
     *
     */
    public  void establishСonnection() throws SQLException {
        connection= DriverManager.getConnection(url + allDbSetings, user, password);
        log.info("The connection is established");;
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
