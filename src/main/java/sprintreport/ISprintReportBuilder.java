package sprintreport;

import user.IUser;

import java.io.InvalidObjectException;
import java.util.Date;
import java.util.List;

public interface ISprintReportBuilder {
    void buildHeader(String companyName, String b64Logo , String projectName , String version , Date date);
    void buildContent(List<IUser> teamMebers, List<Integer> burnDownChartData);
    void buildFooter(String companyName, String b64Logo , String projectName , String version , Date date);
    void saveReport() throws InvalidObjectException;

}
