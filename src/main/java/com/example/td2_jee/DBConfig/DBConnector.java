package com.example.td2_jee.DBConfig;


import com.example.td2_jee.Connexion;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection connection = null;

    public static Connection getConnection(ServletContext context) throws SQLException {
        if (connection == null) {
            try {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(context.getInitParameter("db.url"), context.getInitParameter("db.username"), context.getInitParameter("db.password"));
            } catch (ClassNotFoundException e) {
                throw new SQLException("Échec du chargement du pilote JDBC", e);
            }
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
            connection = null;
        }
    }
}

