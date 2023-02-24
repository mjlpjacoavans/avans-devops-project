package test.java.pipeline;

import main.java.pipeline.DeploymentPipeline;
import main.java.pipeline.DevelopmentPipeline;
import main.java.pipeline.IPipeline;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class PipelineTests {


    // These methods are used as default overrides
    private static class PipelineOverrideMethods{
        public static Boolean standardSuccessOverride(){
            System.out.println("Standard success override invoked.");
            return true;
        }

        public static Boolean standardFailureOverride(){
            System.out.println("Standard failure override invoked.");
            return false;
        }

    }

    @Test
    public void PIPLEINE_TEST_1_run_default_dev_pipeline_successfully() {
        IPipeline pipeline = new DevelopmentPipeline();
        pipeline.startPipeline();
        System.out.println(pipeline.getSuccess());
    }

    @Test
    public void PIPLEINE_TEST_2_run_default_dep_pipeline_successfully() {
        IPipeline pipeline = new DeploymentPipeline();
        pipeline.startPipeline();
        System.out.println(pipeline.getSuccess());
    }

    @Test
    public void PIPLEINE_TEST_3_run_overriden_dev_pipeline_successfully() {
        IPipeline pipeline = new DevelopmentPipeline(){
            public Boolean runSources(){
                return PipelineOverrideMethods.standardSuccessOverride();
            }
        };
        pipeline.startPipeline();
        System.out.println(pipeline.getSuccess());
    }


    // APPRENTLY LAMBDAS CAN NOT HAVE A RETURN VALUE IN JAVA.
    // THAT'S JUST REDICULOUS, WHAT EVEN IS THIS LMAOOO
    //    @Test
    //    public void PIPLEINE_TEST_4_run_lambda_dev_pipeline_successfully() {
    //        IPipeline pipeline = new DevelopmentPipeline(){
    //            public Boolean runSources(){
    //                return () ->{return true};
    //            }
    //        };
    //        pipeline.startPipeline();
    //        System.out.println(pipeline.getSuccess());
    //    }
}
