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
