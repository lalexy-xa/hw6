package org.example;

import java.sql.*;

public class Database {
    private static final Database instance = new Database();
    private Connection connection;

    private Database(){
        String dbUrl = "jdbc:h2:test:";
        try{
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        } catch (SQLException e) {
            System.out.println("Fail");
        }
    }

    public static Database getInstance(){
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
