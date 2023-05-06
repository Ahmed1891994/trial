package base;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import Environments.Environment;
import utils.ConfigReader;
import utils.MyLogger;

public class TestSetupContext {
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	protected ThreadLocal<Environment> Environment = new ThreadLocal<Environment>();
	protected ThreadLocal<ElementActions> elementactions = new ThreadLocal<ElementActions>();
	protected ThreadLocal<BrowserActions> browseractions = new ThreadLocal<BrowserActions>();
	//protected ThreadLocal<ConfigReader> configreader = new ThreadLocal<ConfigReader>();
	public JSONObject countriesdata;
	
	public void setDriver(WebDriver driver) {
		MyLogger.debug("save the driver to ThreadLocal variable");
		this.driver.set(driver);
	}

	public WebDriver getDriver() {
		MyLogger.debug("get the driver from ThreadLocal variable");
		return driver.get();
	}
	
	public void setEnvironment(Environment env) {
		MyLogger.debug("save the Environment to ThreadLocal variable");
		this.Environment.set(env);
	}

	public Environment getEnvironment() {
		MyLogger.debug("get the Environment from ThreadLocal variable");
		return Environment.get();
	}
	
	public void setElementActions(ElementActions elementactions) {
		MyLogger.debug("save the ElementActions to ThreadLocal variable");
		this.elementactions.set(elementactions);
	}

	public ElementActions getElementActions() {
		MyLogger.debug("get the ElementActions from ThreadLocal variable");
		return elementactions.get();
	}
	
	public void setBrowserActions(BrowserActions browseractions) {
		MyLogger.debug("save the BrowserActions to ThreadLocal variable");
		this.browseractions.set(browseractions);
	}

	public BrowserActions getBrowserActions() {
		MyLogger.debug("get the BrowserActions from ThreadLocal variable");
		return browseractions.get();
	}
	
	/*public void setConfigReader(ConfigReader configreader) {
		MyLogger.debug("save the ConfigReader to ThreadLocal variable");
		this.configreader.set(configreader);
	}

	public ConfigReader getConfigReader() {
		MyLogger.debug("get the ConfigReader from ThreadLocal variable");
		return configreader.get();
	}*/
}
