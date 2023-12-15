package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) throws IOException, SQLException {
        Connection connection = Database.getInstance().getConnection();
        String insertDBQuery = new String(Files.readAllBytes(Paths.get("src/main/resources/sql/populate_db.sql")));
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(insertDBQuery);
        connection.close();

    }
}
