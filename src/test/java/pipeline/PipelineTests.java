package test.java.pipeline;

import main.java.pipeline.DeploymentPipeline;
import main.java.pipeline.DevelopmentPipeline;
import main.java.pipeline.IPipeline;
import org.junit.jupiter.api.Test;

public class PipelineTests {

    @Test
    public void PIPLEINE_TEST_1_run_dev_pipeline_successfully() {
        IPipeline pipeline = new DevelopmentPipeline();
        pipeline.startPipeline();
        System.out.println(pipeline.getSuccess());
    }

    @Test
    public void PIPLEINE_TEST_2_run_dep_pipeline_successfully() {
        IPipeline pipeline = new DeploymentPipeline();
        pipeline.startPipeline();
        System.out.println(pipeline.getSuccess());
    }
}
