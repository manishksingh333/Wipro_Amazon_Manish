package com.RunnerFile;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * @author manish.singh Description: Runner Class implementing testNg
 *         AbstractTestNGCucumberTests is used to execute the TestScenrios as
 *         testNg suite
 */
@CucumberOptions(plugin = { "pretty", "html:target/cucumber",
		"json:target/cucumber.json" }, features = "Features", glue = { "Tests" }, tags = "~@ignore", monochrome = true)

public class RunnerClass extends AbstractTestNGCucumberTests {

}
