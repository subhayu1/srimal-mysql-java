package projects.util;

import exception.DbException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    //use environment variables to store the database credentials


    private static final String HOST = System.getenv("DB_HOST");
    private static final String PORT = System.getenv("DB_PORT");
    private static final String SCHEMA =  System.getenv("DB_SCHEMA");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    private static final String USERNAME = System.getenv("DB_USER");

    private static final String DB_URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + SCHEMA + "?user=" + USERNAME + "&password=" + PASSWORD + "&useSSL=false&allowPublicKeyRetrieval=true";

    public static Connection getConnection() {
      try {
        // Create the MySQL connection URI

        // Obtain a connection using DriverManager
        Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

        // Print a success message to the console
        System.out.println("Connected to the database successfully");

        return connection;
      } catch (SQLException e) {
        // Print an error message to the console
        System.err.println("Failed to connect to the database");

        // Throw a DbException if the connection fails
        throw new DbException("Failed to connect to the database", e);
      }
    }
  }


