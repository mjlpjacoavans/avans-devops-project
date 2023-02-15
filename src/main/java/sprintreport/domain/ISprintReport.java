package main.java.sprintreport.domain;

public interface ISprintReport {
    String getReportName();
    void setReportName(String reportName);
    String getReportFileName();
    Header getHeader();
    void setHeader(Header header);
    Content getContent();

    void setContent(Content content);
    Footer getFooter();
    void setFooter(Footer footer);
    String toString();
}
