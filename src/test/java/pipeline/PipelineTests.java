
package pipeline;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class PipelineTests {


    /// Arange some more realistic setup utilities


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

    // Imagine this to be a PAAS platform like heroku or something
    private class FakeDeploymentClient{

        private String zipPath;
        private final String apiKey;

        public FakeDeploymentClient(String apiKey) {
            this.apiKey = apiKey;
        }

        public String zipCode(String codePath) throws FileNotFoundException {
            System.out.println("Running zip command on destination: " + codePath);
            String zipPath = "./deployment.zip";
            this.zipPath = zipPath;
            return zipPath;
        }

        public void deploy(){
            System.out.println("Running deployment command. Deploying "
                    + this.zipPath + " with api key " + this.apiKey.replaceAll("[^,-]", "*"));
        }
    }

    private class FakeDeploymentClientFailing extends FakeDeploymentClient{

        public FakeDeploymentClientFailing(String apiKey) {
            super(apiKey);
        }

        public String zipCode(String codePath) throws FileNotFoundException {
            throw new FileNotFoundException();
        }
    }

    @Test
    public void PIPLEINE_TEST_1_run_default_dev_pipeline_successfully() {
        IPipeline pipeline = new DevelopmentPipeline();
        pipeline.startPipeline();
        Assertions.assertTrue(pipeline.getSuccess());
    }

    @Test
    public void PIPLEINE_TEST_2_run_default_dep_pipeline_successfully() {
        IPipeline pipeline = new DeploymentPipeline();
        pipeline.startPipeline();
        Assertions.assertTrue(pipeline.getSuccess());
    }

    @Test
    public void PIPLEINE_TEST_3_run_overriden_dev_pipeline_successfully() {
        IPipeline pipeline = new DevelopmentPipeline(){
            public Boolean runSources(){
                return PipelineOverrideMethods.standardSuccessOverride();
            }
        };
        pipeline.startPipeline();
        Assertions.assertTrue(pipeline.getSuccess());
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


    @Test // Imagine this to be a devops platform http controller or something
    public void PIPLEINE_TEST_4_run_client_dev_pipeline_successfully() {

        String paasApiToken = "aaaaaaaaaaa-bbbbbbbbbbb-cccccccccc";
        FakeDeploymentClient client = new FakeDeploymentClient(paasApiToken);
        IPipeline pipeline = new DeploymentPipeline(){
            public Boolean runBuild(){
                try {
                    client.zipCode("./");
                    return true;

                } catch (FileNotFoundException e) {
                    System.out.println("Exception occurred while building: " + e);
                    return false;
                }
            }
            public Boolean runDeploy(){
                client.deploy();
                return true;
            }
        };
        pipeline.startPipeline();
        Assertions.assertTrue(pipeline.getSuccess());
    }

    @Test
    public void PIPLEINE_TEST_5_unhappy_run_client_dev_pipeline_unsuccessfully() {

        String paasApiToken = "aaaaaaaaaaa-bbbbbbbbbbb-cccccccccc";
        FakeDeploymentClient client = new FakeDeploymentClientFailing(paasApiToken);
        IPipeline pipeline = new DevelopmentPipeline(){
            public void onPipelineFail(){
                System.out.println("Failure hook overriden");
            }
            public Boolean runBuild(){
                try {
                    client.zipCode("./");
                    return true;

                } catch (FileNotFoundException e) {
                    System.out.println("Exception occurred while building: " + e);
                    return false;
                }
            }
        };
        pipeline.startPipeline();
        Assertions.assertFalse(pipeline.getSuccess());
    }

    @Test
    public void PIPLEINE_TEST_6_run_client_dev_pipeline_on_success() {

        IPipeline pipeline = new DevelopmentPipeline(){
            public void onPipelineSuccess(){
                System.out.println("Success hook overriden");
            }

            public void onPipelineFail(){
                System.out.println("Failure hook overriden");
            }
        };
        pipeline.startPipeline();
        Assertions.assertTrue(pipeline.getSuccess());
    }

//    public void PIPLEINE_TEST_7_unhappy_dev_pipeline_can_not_deploy() {
//        IPipeline pipeline = new DevelopmentPipeline(){
//            SUGGESTION: This can not be done since it already crashes on compile time
//             and can not seem to figure out how to check if method is static via reflection
//            public Boolean runDeploy(){
//                System.out.println("Trying to deploy on a dev pipeline");
//            }
//        };
//        pipeline.startPipeline();
//        Assertions.assertTrue(pipeline.getSuccess());
//    }


}
