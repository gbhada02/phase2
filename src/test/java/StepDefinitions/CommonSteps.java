package StepDefinitions;

import com.aventstack.extentreports.gherkin.model.Scenario;

import Utility.Utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class CommonSteps extends Utils {
	
	

	@After(order=0)
	public void closeDriber() {
		driver.close();
		extend.flush();
	}
	
	
}
