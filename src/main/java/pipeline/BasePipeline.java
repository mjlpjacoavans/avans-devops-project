package main.java.pipeline;

// TODO: Check if this should not be an abstract class, check up the definition of that anyway
public abstract class BasePipeline implements IPipeline{
    private Boolean running = false;
    private Boolean success = false;


    @Override
    public void startPipeline(){
        System.out.println("Started pipeline");
        this.running = true;
        this.onPipelineStarts();

        Boolean sourcesPhaseSuccess = this.runSources();
        if(!sourcesPhaseSuccess){
            this.running = false;
            this.success = false;
            this.onPipelineEnds();
            return;
        }

        Boolean packagePhaseSuccess = this.runPackage();
        if(!packagePhaseSuccess){
            this.running = false;
            this.success = false;
            this.onPipelineEnds();
            return;
        }

        Boolean buildPhaseSuccess = this.runBuild();
        if(!buildPhaseSuccess){
            this.running = false;
            this.success = false;
            this.onPipelineEnds();
            return;
        }

        Boolean testPhaseSuccess = this.runTest();
        if(!testPhaseSuccess){
            this.running = false;
            this.success = false;
            this.onPipelineEnds();
            return;
        }

        Boolean analysisPhaseSuccess = this.runAnalysis();
        if(!analysisPhaseSuccess){
            this.running = false;
            this.success = false;
            this.onPipelineEnds();
            return;
        }

        Boolean deployPhaseSuccess = this.runDeploy();
        if(!deployPhaseSuccess){
            this.running = false;
            this.success = false;
            this.onPipelineEnds();
            return;
        }

        Boolean utilityPhaseSuccess = this.runUtility();
        if(!utilityPhaseSuccess){
            this.running = false;
            this.success = false;
            this.onPipelineEnds();
            return;
        }

        this.running = false;
        this.success = true;
        this.onPipelineEnds();
        return;
    }

    @Override
    public void onPipelineStarts() {
        System.out.println("Callback not overriden");
    }

    @Override
    public Boolean runSources() {
        System.out.println("Pipeline phase not implemented. Skipping.");
        return true;
    }

    @Override
    public Boolean runPackage() {
        System.out.println("Pipeline phase not implemented. Skipping.");
        return true;
    }

    @Override
    public Boolean runBuild() {
        System.out.println("Pipeline phase not implemented. Skipping.");
        return true;
    }

    @Override
    public Boolean runTest() {
        System.out.println("Pipeline phase not implemented. Skipping.");
        return true;
    }

    @Override
    public Boolean runAnalysis() {
        System.out.println("Pipeline phase not implemented. Skipping.");
        return true;
    }

    @Override
    public Boolean runDeploy() {
        System.out.println("Pipeline phase not implemented. Skipping.");
        return true;
    }

    @Override
    public Boolean runUtility() {
        System.out.println("Pipeline phase not implemented. Skipping.");
        return true;
    }

    @Override
    public void endPipeline(){
        System.out.println("Ended pipeline");
        this.running = false;
        this.onPipelineEnds();
    }

    @Override
    public void onPipelineEnds() {
        // this.running = false;
        System.out.println("Callback not overriden");
    }

    @Override
    public Boolean getRunning() {
        return running;
    }

    @Override
    public void setRunning(Boolean running) {
        this.running = running;
    }

    @Override
    public Boolean getSuccess() {
        return success;
    }

    @Override
    public void setSuccess(Boolean success) {
        this.success = success;
    }



    // TODO: Read this better and also keep this logic into account or somehting idk
    // Een deployment sprint is gekoppeld aan een development pipeline die eindigt met deployment.
    //Andere sprints kunnen ook worden gekoppeld aan een development pipeline die
    //automatisch/handmatig wordt uitgevoerd. Daarvan kan het einde ook deployment zijn (naar bv een
    //testomgeving), maar het kan ook eindigen na het uitvoeren van de tests en publicatie van
    //testresultaten.
}
