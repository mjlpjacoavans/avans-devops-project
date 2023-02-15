package main.java.pipeline;

public class DeploymentPipeline extends IPipelineTemplate {
    public DeploymentPipeline(Boolean automatic, String pipelineName) {
        super(automatic, pipelineName);
    }
}
