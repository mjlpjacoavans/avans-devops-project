package main.java.pipeline;





public interface IPipeline {
//    public Boolean running = false;
//    public Boolean success = false;


    public void startPipeline();
    public void onPipelineStarts();
    public Boolean runSources();
    public Boolean runPackage();
    public Boolean runBuild();
    public Boolean runTest();
    public Boolean runAnalysis();
    public Boolean runDeploy();
    public Boolean runUtility();

    public void endPipeline();

    // TODO: Perhapse add a paramter to it to indicate if it crashed or was done by a user

    public void onPipelineEnds();

    public Boolean getRunning();

    public void setRunning(Boolean running);

    public Boolean getSuccess();

    public void setSuccess(Boolean success);

}
