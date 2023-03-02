package main.java.pipeline;

public class DevelopmentPipeline extends BasePipeline{
    public DevelopmentPipeline(boolean autostart) {
        super(autostart);
    }
    public DevelopmentPipeline() {
        super();
    }

    // TODO: Add other override constraints

    @Override
    final public Boolean runDeploy() {
        System.out.println("Deploy can not be ran in development pipeline. Skipping.");
        return true;
    }
}
