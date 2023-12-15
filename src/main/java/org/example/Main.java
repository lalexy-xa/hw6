package org.example;

import org.example.result_select_classes.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();
        List<MaxProjectCountClient> maxProjectCountClients = databaseQueryService.findMaxProjectsClient();
        System.out.println("MaxProjectCountClient");
        for (MaxProjectCountClient client: maxProjectCountClients){
            System.out.println(client.getName() + " " + client.getProjectCount());
        }
        List<LongestProject> longestProjects = databaseQueryService.findLongestProject();
        System.out.println("LongestProject");
        for (LongestProject prj: longestProjects){
            System.out.println(prj.getId() + " " + prj.getCountOfMonthes());
        }
        List<MaxSalaryWorker> maxSalaryWorkers = databaseQueryService.findMaxSalaryWorker();
        System.out.println("MaxSalaryWorker");
        for (MaxSalaryWorker worker: maxSalaryWorkers){
            System.out.println(worker.getName() + " " + worker.getSalary());
        }

        List<ProjectPrice> projectsPrices = databaseQueryService.findProjectPrices();
        System.out.println("Projects prices");
        for(ProjectPrice prj: projectsPrices){
            System.out.println(prj.getProjectId() + " " + prj.getProjectPrice() );
        }

        List<YoungestEldestWorker> youngestEldestWorkerList = databaseQueryService.findYoungestEldestWorkers();
        System.out.println("Youngest Eldest Workers");
        for (YoungestEldestWorker worker: youngestEldestWorkerList){
            System.out.println(worker.getType() + " " + worker.getName() + " " + worker.getBirthday());
        }

        databaseQueryService.connectionClose();



    }
}
