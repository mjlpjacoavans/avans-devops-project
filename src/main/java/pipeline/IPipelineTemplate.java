package main.java.pipeline;

// Template pattern
public abstract class IPipelineTemplate {

    private Boolean success;
    private Boolean automatic;
    private String pipelineName;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Boolean getAutomatic() {
        return automatic;
    }

    public void setAutomatic(Boolean automatic) {
        this.automatic = automatic;
    }

    public String getPipelineName() {
        return pipelineName;
    }

    public void setPipelineName(String pipelineName) {
        this.pipelineName = pipelineName;
    }

    public IPipelineTemplate(Boolean automatic, String pipelineName) {
        this.automatic = automatic;
        this.pipelineName = pipelineName;
    }

    void RunSources(){
        System.out.println("This is the default behaviour of this CI/CD stage. Skipping...");
    }

    void RunInstallPackages(){
        System.out.println("This is the default behaviour of this CI/CD stage. Skipping...");
    }

    void RunBuild(){
        System.out.println("This is the default behaviour of this CI/CD stage. Skipping...");
    }

    void RunTests(){
        System.out.println("This is the default behaviour of this CI/CD stage. Skipping...");
    }

    void RunAnalysis(){
        System.out.println("This is the default behaviour of this CI/CD stage. Skipping...");
    }

    void RunDeploy(){
        System.out.println("This is the default behaviour of this CI/CD stage. Skipping...");
    }

    void RunUtility(){
        System.out.println("This is the default behaviour of this CI/CD stage. Skipping...");
    }

}
