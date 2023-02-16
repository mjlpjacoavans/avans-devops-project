package test.java.report;


import main.java.sprintreport.ISprintReportBuilder;
import main.java.sprintreport.SprintReportBuilder;
import main.java.sprintreport.domain.ReportFormat;
import main.java.user.DeveloperUser;
import main.java.user.IUser;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ReportTests {



    @Test
    public void REPORT_TEST_1_pdf_report_is_generated_successfully(){

        ReportFormat format = ReportFormat.PDF;
        String reportName = "Sprint one report";
        String reportFileName = "sprint-1-report";

        ISprintReportBuilder pdfSprintReportBuilder = new SprintReportBuilder(format, reportName, reportFileName);

        Calendar today = Calendar.getInstance();
        today.clear(Calendar.HOUR); today.clear(Calendar.MINUTE); today.clear(Calendar.SECOND);

        String companyName = "Company Name 1";
        String b64Logo  = "b64://<IMAGE>;";
        String projectName  = "Company Name 1 Project 1";
        String version  = "0.0.1";
        Date date = today.getTime();;

        List<IUser> teamMebers = Arrays.asList(
                new DeveloperUser("User 1", "user1@company.tld", "123456"),
                new DeveloperUser("User 2", "user2@company.tld", "234567"),
                new DeveloperUser("User 3", "user3@company.tld", "345678"));

        pdfSprintReportBuilder.buildHeader(companyName, b64Logo, projectName, version, date);
        pdfSprintReportBuilder.buildContent(teamMebers, Arrays.asList(1,2,3,4,5));
        pdfSprintReportBuilder.buildFooter(companyName, b64Logo, projectName, version, date);

        pdfSprintReportBuilder.saveReport();

    }

    @Test
    public void REPORT_TEST_1_png_report_is_generated_successfully(){

        ReportFormat format = ReportFormat.PNG;
        String reportName = "Sprint one report";
        String reportFileName = "sprint-1-report";

        ISprintReportBuilder pdfSprintReportBuilder = new SprintReportBuilder(format, reportName, reportFileName);

    }

}
