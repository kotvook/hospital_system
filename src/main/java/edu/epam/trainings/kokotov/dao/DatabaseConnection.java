package edu.epam.trainings.kokotov.dao;

import java.sql.*;
import java.util.logging.Logger;

/**
 * The class contains the necessary database connection controls
 *
 * @author    Artem Kokotov
 */
public class DatabaseConnection {

    /** Database user name. */
    final String user = "root";

    /** Database user password.*/
    final String password = "root";

    /** Database settings.*/
    final String dbSetings = "?useUnicode=true" +
            "&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC" +
            "&useSSL=false";

    /** Database user */
    final String url = "jdbc:mysql://localhost:3306/hospitalsystem" + dbSetings;

    /** Connection of database.*/
    private Connection connection = null;

    /** Logger */
    private static Logger log = Logger.getLogger(DatabaseConnection.class.getName());

    /**
     * establishing connection with Database.
     *
     */
    public  void establishСonnection() throws SQLException {
        connection= DriverManager.getConnection(url, user, password);
        log.info("The connection is established");;
    }

    /**
     * closing connection with Database.
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
