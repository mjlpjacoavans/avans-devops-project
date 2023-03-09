package main.java.sprintreport;

import main.java.sprintreport.domain.*;
import main.java.user.IUser;

import java.util.Date;
import java.util.List;

public class SprintReportBuilder implements ISprintReportBuilder {

    private final ISprintReport sprintReport;
    private final ReportFormat format;
    public SprintReportBuilder(ReportFormat format,
                               String reportName, String reportFileName) {
        this.format = format;
        if(this.format == ReportFormat.PDF){
            this.sprintReport = new PDFSprintReport(reportName, reportFileName);
        }
        else if (this.format == ReportFormat.PNG) {
            this.sprintReport = new PNGSprintReport(reportName, reportFileName);
        }
        else{
            throw new IllegalArgumentException("Enum value is not supported");
        }
    }

    @Override
    public void buildHeader(String companyName, String b64Logo ,
                            String projectName , String version , Date date) {
        Header header = new Header(companyName, b64Logo, projectName, version, date);
        this.sprintReport.setHeader(header);
    }

    @Override
    public void buildContent(List<IUser> teamMebers, List<Integer> burnDownChartData) {
        BurdownChart burdownChart = new BurdownChart(burnDownChartData);
        Content content = new Content(teamMebers, burdownChart);
        this.sprintReport.setContent(content);
    }

    @Override
    public void buildFooter(String companyName, String b64Logo ,
                            String projectName , String version , Date date) {
        Footer footer = new Footer(companyName, b64Logo, projectName, version, date);
        this.sprintReport.setFooter(footer);
    }

    public void saveReport(){
        String msg = "Saving report: " + sprintReport.getReportName() + " as " + sprintReport.getReportFileName() + "." + this.format.name()
                        + "\n$ cat " + sprintReport.getReportFileName() + "." + this.format.name()
                        + "\n$ type " + sprintReport.getReportFileName() + "." + this.format.name()
                        + "\nContent type: " + (this.format == ReportFormat.PDF ? "application/" : "image") + this.format.name()
                        + "\n" + sprintReport;
        System.out.println(msg);
    }
}
