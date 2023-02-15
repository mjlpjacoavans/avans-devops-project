package main.java.sprintreport.domain;

import main.java.user.DeveloperUser;
import main.java.user.IUser;

import java.util.List;

public class Content {
    private List<IUser> teamMebers;
    private BurdownChart burdownChart;


    public Content(List<IUser> teamMebers, BurdownChart burdownChart) {
        this.teamMebers = teamMebers;
        this.burdownChart = burdownChart;
    }

    public List<IUser> getTeamMebers() {
        return teamMebers;
    }

    public void setTeamMebers(List<IUser> teamMebers) {
        this.teamMebers = teamMebers;
    }

    public BurdownChart getBurdownChart() {
        return burdownChart;
    }

    public void setBurdownChart(BurdownChart burdownChart) {
        this.burdownChart = burdownChart;
    }

    @Override
    public String toString() {
        return "Content{" +
                "teamMebers=" + teamMebers +
                ", burdownChart=" + burdownChart +
                '}';
    }
}