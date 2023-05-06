package cucumberOptions;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.ConfigReader;

@CucumberOptions(features={"src/test/resources/features"},glue ={"stepDefinitions"}
,monochrome=true,
plugin= {"pretty", "html:target/cucumber.html", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "json:target/cucumber-report.json","junit:target/cucumber-reports/Cucumber.xml"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	//ConfigReader configreader;
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
	
	@BeforeTest
	@Parameters({"browser"})
	public void defineBrowser(@Optional String browser)
	{
        System.out.println("Paramters one for test method: "+browser);
    //    configreader = new ConfigReader();
        ConfigReader.setBrowserType(browser);
	}
	
	
}
