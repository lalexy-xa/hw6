package org.example.result_select_classes;

public class ProjectPrice {
    private int projectId;
    private int projectPrice;

    public  ProjectPrice(int projectId, int projectPrice){
        this.projectId = projectId;
        this.projectPrice = projectPrice;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getProjectPrice() {
        return projectPrice;
    }
}
