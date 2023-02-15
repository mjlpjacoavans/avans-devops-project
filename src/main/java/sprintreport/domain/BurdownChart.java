package main.java.sprintreport.domain;

import java.util.List;

public class BurdownChart {
    private List<Integer> burnDownChartNumbers;

    public BurdownChart(List<Integer> burnDownChartNumbers) {
        // Imagine doing some real calculating and plotting right here
        this.burnDownChartNumbers = burnDownChartNumbers;
    }

    private String renderBurndownChartNumbersToSvg(){
        // Pretend to render the numbers to an svg output
        return "<svg>" +
                "<chart numbers=" + this.burnDownChartNumbers + "/>" +
                "</svg>";
    }

    // Pretend like this plots the chart
    @Override
    public String toString() {
        return this.renderBurndownChartNumbersToSvg();
    }
}
