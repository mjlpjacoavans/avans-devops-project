package pipeline;





public interface IPipeline {
//    public Boolean running = false;
//    public Boolean success = false;


    void startPipeline();
    void onPipelineStarts();
    Boolean runSources();
    Boolean runPackage();
    Boolean runBuild();
    Boolean runTest();
    Boolean runAnalysis();
    Boolean runDeploy();
    Boolean runUtility();

    void endPipeline();

    // SUGGESTION: Perhapse add a paramter to it to indicate if it crashed or was done by a user

    void onPipelineEnds();

    void onPipelineSuccess();
    void onPipelineFail();


    Boolean getRunning();

    void setRunning(Boolean running);

    Boolean getSuccess();

    void setSuccess(Boolean success);

}
