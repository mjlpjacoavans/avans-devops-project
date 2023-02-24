package main.java.pipeline;





public interface IPipeline {
//    public Boolean running = false;
//    public Boolean success = false;


    public void startPipeline();
    public void onPipelineStarts();
    public int runSources();
    public int runPackage();
    public int runBuild();
    public int runTest();
    public int runAnalysis();
    public int runDeploy();
    public int runUtility();

    public void endPipeline();
    public void onPipelineEnds();




    // Een deployment sprint is gekoppeld aan een development pipeline die eindigt met deployment.
    //Andere sprints kunnen ook worden gekoppeld aan een development pipeline die
    //automatisch/handmatig wordt uitgevoerd. Daarvan kan het einde ook deployment zijn (naar bv een
    //testomgeving), maar het kan ook eindigen na het uitvoeren van de tests en publicatie van
    //testresultaten.

    public Boolean getRunning();

    public void setRunning(Boolean running);

    public Boolean getSuccess();

    public void setSuccess(Boolean success);

}
