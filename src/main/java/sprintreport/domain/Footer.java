package sprintreport.domain;

import java.util.Date;

public class Footer {
    private String companyName;
    private String b64Logo;
    private String projectName;
    private String version;
    private Date date;


    public Footer(String companyName, String b64Logo, String projectName, String version, Date date) {
        this.companyName = companyName;
        this.b64Logo = b64Logo;
        this.projectName = projectName;
        this.version = version;
        this.date = date;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getB64Logo() {
        return b64Logo;
    }

    public void setB64Logo(String b64Logo) {
        this.b64Logo = b64Logo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Footer{" +
                "companyName='" + companyName + '\'' +
                ", b64Logo='" + b64Logo + '\'' +
                ", projectName='" + projectName + '\'' +
                ", version='" + version + '\'' +
                ", date=" + date +
                '}';
    }
}
