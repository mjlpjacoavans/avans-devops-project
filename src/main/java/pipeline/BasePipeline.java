package pipeline;

public abstract class BasePipeline implements IPipeline{
    private Boolean running = false;
    private Boolean success = false;

    protected BasePipeline(boolean autostart) {
        if(autostart){
            this.startPipeline();
        }
    }

    protected BasePipeline() {
    }

    @Override
    public void startPipeline(){
        System.out.println("Started pipeline");
        this.running = true;
        this.onPipelineStarts();


        Boolean sourcesPhaseSuccess;
        try {
             sourcesPhaseSuccess = this.runSources();
        }catch(Exception e){
            sourcesPhaseSuccess = false;
        }
        if(Boolean.FALSE.equals(sourcesPhaseSuccess)){
            this.running = false;
            this.success = false;
            this.onPipelineEnds();
            return;
        }

        Boolean packagePhaseSuccess;
        try {
            packagePhaseSuccess = this.runPackage();
        }catch(Exception e){
            packagePhaseSuccess = false;
        }
        if(Boolean.FALSE.equals(packagePhaseSuccess)){
            this.running = false;
            this.success = false;
            this.onPipelineEnds();
            return;
        }

        Boolean buildPhaseSuccess;
        try {
            buildPhaseSuccess = this.runBuild();
        }catch(Exception e){
            buildPhaseSuccess = false;
        }
        if(Boolean.FALSE.equals(buildPhaseSuccess)){
            this.running = false;
            this.success = false;
            this.onPipelineEnds();
            return;
        }

        Boolean testPhaseSuccess;
        try {
            testPhaseSuccess = this.runTest();
        }catch(Exception e){
            testPhaseSuccess = false;
        }
        if(Boolean.FALSE.equals(testPhaseSuccess)){
            this.running = false;
            this.success = false;
            this.onPipelineEnds();
            return;
        }

        Boolean analysisPhaseSuccess;
        try {
            analysisPhaseSuccess = this.runAnalysis();
        }catch(Exception e){
            analysisPhaseSuccess = false;
        }
        if(Boolean.FALSE.equals(analysisPhaseSuccess)){
            this.running = false;
            this.success = false;
            this.onPipelineEnds();
            return;
        }

        Boolean deployPhaseSuccess;
        try {
            deployPhaseSuccess = this.runDeploy();
        }catch(Exception e){
            deployPhaseSuccess = false;
        }
        if(Boolean.FALSE.equals(deployPhaseSuccess)){
            this.running = false;
            this.success = false;
            this.onPipelineEnds();
            return;
        }

        Boolean utilityPhaseSuccess;
        try {
            utilityPhaseSuccess = this.runUtility();
        }catch(Exception e){
            utilityPhaseSuccess = false;
        }
        if(Boolean.FALSE.equals(utilityPhaseSuccess)){
            this.running = false;
            this.success = false;
            this.onPipelineEnds();
            return;
        }

        this.running = false;
        this.success = true;
        this.onPipelineEnds();
    }

    @Override
    public void onPipelineStarts() {
        System.out.println("Callback not overriden");
    }

    @Override
    public Boolean runSources() {
        System.out.println("1. Pipeline phase not implemented. Skipping.");
        return true;
    }

    @Override
    public Boolean runPackage() {
        System.out.println("2. Pipeline phase not implemented. Skipping.");
        return true;
    }

    @Override
    public Boolean runBuild() {
        System.out.println("3. Pipeline phase not implemented. Skipping.");
        return true;
    }

    @Override
    public Boolean runTest() {
        System.out.println("4. Pipeline phase not implemented. Skipping.");
        return true;
    }

    @Override
    public Boolean runAnalysis() {
        System.out.println("5. Pipeline phase not implemented. Skipping.");
        return true;
    }

    @Override
    public Boolean runDeploy() {
        System.out.println("6. Pipeline phase not implemented. Skipping.");
        return true;
    }

    @Override
    public Boolean runUtility() {
        System.out.println("7. Pipeline phase not implemented. Skipping.");
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

        if(this.getSuccess()){
            this.onPipelineSuccess();
        }
        else{
            this.onPipelineFail();
        }
    }

    @Override
    public void onPipelineSuccess(){
        System.out.println("Pipepeline succeeded");
    }

    @Override
    public void onPipelineFail(){
        System.out.println("Pipeline failed");
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
