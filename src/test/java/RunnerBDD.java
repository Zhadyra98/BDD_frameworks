import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

public class RunnerBDD {

    @RunWith(Cucumber.class)
    @CucumberOptions(
            strict = true,
            plugin = {
                    "pretty", "json:target/Cucumber.json",
                    "html:target/cucumber-html-report"
            }
    )
    public static class RunAcceptanceTest {
        @BeforeClass
        public static void initSelenium(){
            BaseTestClass.init();
        }
        @AfterClass
        public static void closeSelenium(){
            BaseTestClass.close();
        }
    }
}
