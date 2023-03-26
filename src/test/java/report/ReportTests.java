package report;


import org.junit.jupiter.api.Assertions;
import sprintreport.ISprintReportBuilder;
import sprintreport.SprintReportBuilder;
import sprintreport.domain.ReportFormat;
import user.DeveloperUser;
import user.IUser;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.InvalidObjectException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class ReportTests {



    @Test
    public void REPORT_TEST_1_pdf_report_is_generated_successfully() throws InvalidObjectException {

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
        Date date = today.getTime();

        List<IUser> teamMebers = Arrays.asList(
                new DeveloperUser("User 1", "user1@company.tld", "123456","01"),
                new DeveloperUser("User 2", "user2@company.tld", "234567","02"),
                new DeveloperUser("User 3", "user3@company.tld", "345678","03"));

        pdfSprintReportBuilder.buildHeader(companyName, b64Logo, projectName, version, date);
        pdfSprintReportBuilder.buildContent(teamMebers, Arrays.asList(1,2,3,4,5));
        pdfSprintReportBuilder.buildFooter(companyName, b64Logo, projectName, version, date);

        pdfSprintReportBuilder.saveReport();

    }

    @Test
    public void REPORT_TEST_2_pdf_report_saves_successfully() throws InvalidObjectException {
        // Arrange
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
        Date date = today.getTime();

        List<IUser> teamMembers = Arrays.asList(
                new DeveloperUser("User 1", "user1@company.tld", "123456","01"),
                new DeveloperUser("User 2", "user2@company.tld", "234567","02"),
                new DeveloperUser("User 3", "user3@company.tld", "345678","03"));

        pdfSprintReportBuilder.buildHeader(companyName, b64Logo, projectName, version, date);
        pdfSprintReportBuilder.buildContent(teamMembers, Arrays.asList(1,2,3,4,5));
        pdfSprintReportBuilder.buildFooter(companyName, b64Logo, projectName, version, date);

        // Act
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        pdfSprintReportBuilder.saveReport();


        // Assert
        Assertions.assertTrue(outContent.toString().contains("Saving report:"));
    }

    @Test
    public void REPORT_TEST_3_pdf_report_contains_correctly_emails() throws InvalidObjectException {
        // Arrange
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
        Date date = today.getTime();

        List<IUser> teamMembers = Arrays.asList(
                new DeveloperUser("User 1", "user1@company.tld", "123456","01"),
                new DeveloperUser("User 2", "user2@company.tld", "234567","02"),
                new DeveloperUser("User 3", "user3@company.tld", "345678","03"));

        pdfSprintReportBuilder.buildHeader(companyName, b64Logo, projectName, version, date);
        pdfSprintReportBuilder.buildContent(teamMembers, Arrays.asList(1,2,3,4,5));
        pdfSprintReportBuilder.buildFooter(companyName, b64Logo, projectName, version, date);

        // Act
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        pdfSprintReportBuilder.saveReport();


        // Assert
        Assertions.assertTrue(
                outContent.toString().contains(teamMembers.get(0).getEmail()) &&
                outContent.toString().contains(teamMembers.get(1).getEmail()) &&
                outContent.toString().contains(teamMembers.get(2).getEmail())
        );
    }

    @Test
    public void REPORT_TEST_4_pdf_report_contains_correctly_data() throws InvalidObjectException {
        // Arrange
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
        Date date = today.getTime();

        List<IUser> teamMembers = Arrays.asList(
                new DeveloperUser("User 1", "user1@company.tld", "123456","01"),
                new DeveloperUser("User 2", "user2@company.tld", "234567","02"),
                new DeveloperUser("User 3", "user3@company.tld", "345678","03"));

        pdfSprintReportBuilder.buildHeader(companyName, b64Logo, projectName, version, date);
        pdfSprintReportBuilder.buildContent(teamMembers, Arrays.asList(1,2,3,4,5));
        pdfSprintReportBuilder.buildFooter(companyName, b64Logo, projectName, version, date);

        // Act
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        pdfSprintReportBuilder.saveReport();


        // Assert
        Assertions.assertTrue(
                outContent.toString().contains(companyName) &&
                        outContent.toString().contains(b64Logo) &&
                        outContent.toString().contains(projectName) &&
                        outContent.toString().contains(version) &&
                        outContent.toString().contains(date.toString())

        );
    }

    @Test
    public void REPORT_TEST_5_pdf_report_saved_correctly_extension() throws InvalidObjectException {
        // Arrange
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
        Date date = today.getTime();

        List<IUser> teamMembers = Arrays.asList(
                new DeveloperUser("User 1", "user1@company.tld", "123456","01"),
                new DeveloperUser("User 2", "user2@company.tld", "234567","02"),
                new DeveloperUser("User 3", "user3@company.tld", "345678","03"));

        pdfSprintReportBuilder.buildHeader(companyName, b64Logo, projectName, version, date);
        pdfSprintReportBuilder.buildContent(teamMembers, Arrays.asList(1,2,3,4,5));
        pdfSprintReportBuilder.buildFooter(companyName, b64Logo, projectName, version, date);

        // Act
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        pdfSprintReportBuilder.saveReport();


        // Assert
        Assertions.assertTrue(
                outContent.toString().contains("." + format.toString())
        );
    }


    @org.junit.Test(expected = InvalidObjectException.class)
    public void REPORT_TEST_6_unhappy_pdf_report_can_not_be_saved_correct() throws InvalidObjectException {
        // Arrange
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
        Date date = today.getTime();

        List<IUser> teamMembers = Arrays.asList(
                new DeveloperUser("User 1", "user1@company.tld", "123456","01"),
                new DeveloperUser("User 2", "user2@company.tld", "234567","02"),
                new DeveloperUser("User 3", "user3@company.tld", "345678","03"));

        pdfSprintReportBuilder.buildHeader(companyName, b64Logo, projectName, version, date);

        // Act
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));


        // Assert
        pdfSprintReportBuilder.saveReport();

    }
}
