package main.java.sprintreport.domain;

import java.util.stream.Stream;

public class PDFSprintReport implements ISprintReport {

    Header header;
    Content content;
    Footer footer;

    String reportName;
    String reportFileName;

    public PDFSprintReport(String reportName, String reportFileName) {
        this.reportName = reportName;
        this.reportFileName = reportFileName;
    }

    public PDFSprintReport(Header header, Content content, Footer footer,
                           String reportName, String reportFileName) {
        this.header = header;
        this.content = content;
        this.footer = footer;
        this.reportName = reportName;
        this.reportFileName = reportFileName;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportFileName() {
        return reportFileName;
    }

    public void setReportFileName(String reportFileName) {
        this.reportFileName = reportFileName;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Footer getFooter() {
        return footer;
    }

    public void setFooter(Footer footer) {
        this.footer = footer;
    }

    @Override
    public String toString() {
        String msg = "Title: " + reportName +
                "\n" + this.getHeader() +
                "\n" + this.getContent() +
                "\n" + this.getFooter();
        return msg;
    }
}
