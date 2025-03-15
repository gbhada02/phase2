package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\java\\Features\\MakeMyTrip.feature",
		glue ="StepDefinitions",
		tags= "@Regression",
		monochrome = true 
		//dryRun = true
		)


public class Amazone {

}
