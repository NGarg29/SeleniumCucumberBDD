package Runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = "src/test/resources/Feature/login.feature",
				 glue = "steps"
				)		
public class Runner extends AbstractTestNGCucumberTests{

}
