package org.example;

import org.example.result_select_classes.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    private Statement stmt;
    private Connection connection;

    public DatabaseQueryService(){
        try {
            connection = Database.getInstance().getConnection();
            stmt = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void connectionClose(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() throws IOException, SQLException {
        List<MaxProjectCountClient> maxProjectclientList = new ArrayList<>();
        String findMaxProjectsClientQuery = new String(Files.readAllBytes(Paths.get("src/main/resources/sql/find_max_projects_client.sql")));
        ResultSet result = stmt.executeQuery(findMaxProjectsClientQuery);
        while (result.next()){
            maxProjectclientList.add(new MaxProjectCountClient(result.getString(1), result.getInt(2)));
        }
        return maxProjectclientList;
    }

    public List<LongestProject> findLongestProject() throws IOException, SQLException {
        List<LongestProject> longestProjectList = new ArrayList<>();
        String findLongestProjectQuery = new String(Files.readAllBytes(Paths.get("src/main/resources/sql/find_longest_project.sql")));
        ResultSet result = stmt.executeQuery(findLongestProjectQuery);
        while (result.next()){
            longestProjectList.add(new LongestProject(result.getInt(1), result.getInt(2)));
        }
        return longestProjectList;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() throws IOException, SQLException {
        List<MaxSalaryWorker> maxSalaryWorkerList = new ArrayList<>();
        String findMaxSalaryWorkerQuery = new String(Files.readAllBytes(Paths.get("src/main/resources/sql/find_max_salary_worker.sql")));
        ResultSet result = stmt.executeQuery(findMaxSalaryWorkerQuery);
        while (result.next()){
           maxSalaryWorkerList.add(new MaxSalaryWorker(result.getString(1), result.getInt(2)));
        }
        return maxSalaryWorkerList;
    }

    public List<YoungestEldestWorker> findYoungestEldestWorkers() throws IOException, SQLException {
        List<YoungestEldestWorker> youngestEldestWorkerList = new ArrayList<>();
        String findYoungestEldestWorkersQuery = new String(Files.readAllBytes(Paths.get("src/main/resources/sql/find_youngest_eldest_workers.sql")));
        ResultSet result = stmt.executeQuery(findYoungestEldestWorkersQuery);
        while (result.next()){
            youngestEldestWorkerList.add(new YoungestEldestWorker(result.getString(1), result.getString(2), result.getDate(3)));
        }
        return youngestEldestWorkerList;
    }

    public List<ProjectPrice> findProjectPrices() throws IOException, SQLException {
        List<ProjectPrice> projectPriceList = new ArrayList<>();
        String findProjectPricesQuery = new String(Files.readAllBytes(Paths.get("src/main/resources/sql/print_project_prices.sql")));
        ResultSet result = stmt.executeQuery(findProjectPricesQuery);
        while (result.next()){
            projectPriceList.add(new ProjectPrice(result.getInt(1), result.getInt(2)));
        }
        return projectPriceList;
    }



}
