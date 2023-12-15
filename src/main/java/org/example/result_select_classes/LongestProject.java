package org.example.result_select_classes;

public class LongestProject {
    private int id;
    private int countOfMonthes;

    public LongestProject(int id, int countOfMonthes){
        this.id = id;
        this.countOfMonthes = countOfMonthes;
    }

    public int getId() {
        return id;
    }

    public int getCountOfMonthes() {
        return countOfMonthes;
    }
}
