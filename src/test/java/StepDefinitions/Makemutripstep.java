package StepDefinitions;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.gherkin.model.Scenario;

import Utility.PageActions;
import Utility.Utils;
import Validation.MakeMyTripvalidation;
import io.cucumber.java.en.*;

public class Makemutripstep extends Utils {
	 Scenario sc;
//	public Makemutripstep(Scenario sc) {
//		this.sc=sc;
//	}
	
	@Given("User is able to login using valid credentials {string}")
	public void user_is_able_to_login_using_valid_credentials(String string) throws IOException, InterruptedException {
	
		LocalDateTime local = LocalDateTime.now();
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss");
		String time = local.format(format);
		
		
		
		getExtendReport(time);
		PageActions.Login("chrome");
		MakeMyTripvalidation make = new MakeMyTripvalidation();
		make.login();
	}
	@When("User select from  {string} to {string} with round trip and Deprature date {string} , return date {string} and number of travellers {int}")
	public void user_select_from_to_with_round_trip_and_deprature_date_return_date_and_number_of_travellers(String string, String string2, String string3, String string4, Integer int1) {
	   
	}
	@Then("verify user is able to see the available flights.")
	public void verify_user_is_able_to_see_the_available_flights() {
	    // Write code here that turns the phrase above into concrete actions
	  
	}




}
