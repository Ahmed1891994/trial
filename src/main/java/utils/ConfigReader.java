package utils;

public class ConfigReader {
	private static String browserType;

	public synchronized static void setBrowserType(String browser) {
		MyLogger.info("save Browser type => " + browser);
		if (browser.length() <= 12) {
			browserType = browser;
		}
		MyLogger.info("setBrowserType " + browser + ". Thread id is: " + Thread.currentThread().getId());
	}

	public static String getBrowserType() {
		String result = browserType;
		if (result == null) {
			MyLogger.info("Browser is null");
			result = System.getProperty("browser", "Chrome");
			MyLogger.info("get Browser type" + result);
			browserType = result;
		}
		MyLogger.info("getBrowserType " + result + " Thread id is: " + Thread.currentThread().getId());
		return result;
	}
}
