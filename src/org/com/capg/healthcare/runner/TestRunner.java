package org.com.capg.healthcare.runner;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="Feature/addcenter.feature", glue= {"org.com.capg.healthcare.stepdef"})

public class TestRunner {
	
	
}
