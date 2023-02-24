package main.java.pipeline;

public class DevelopmentPipeline implements IPipeline{

    private Boolean running = false;
    private Boolean success = false;




    @Override
    public void startPipeline(){
        System.out.println("Started pipeline");
        this.running = true;
        this.onPipelineStarts();
    }

    @Override
    public void onPipelineStarts() {
        System.out.println("Callback not overriden");
    }

    @Override
    public int runSources() {
        System.out.println("Pipeline phase not implemented. Skipping.");
        return 0;
    }

    @Override
    public int runPackage() {
        System.out.println("Pipeline phase not implemented. Skipping.");
        return 0;
    }

    @Override
    public int runBuild() {
        System.out.println("Pipeline phase not implemented. Skipping.");
        return 0;
    }

    @Override
    public int runTest() {
        System.out.println("Pipeline phase not implemented. Skipping.");
        return 0;
    }

    @Override
    public int runAnalysis() {
        System.out.println("Pipeline phase not implemented. Skipping.");
        return 0;
    }

    @Override
    public int runDeploy() {
        System.out.println("Pipeline phase not implemented. Skipping.");
        return 0;
    }

    @Override
    public int runUtility() {
        System.out.println("Pipeline phase not implemented. Skipping.");
        return 0;
    }

    @Override
    public void endPipeline(){
        System.out.println("Ended pipeline");
        this.running = false;
        this.onPipelineEnds();
    }

    @Override
    public void onPipelineEnds() {
        System.out.println("Callback not overriden");
    }

    public Boolean getRunning() {
        return running;
    }

    public void setRunning(Boolean running) {
        this.running = running;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
