package utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonFileHandler {
	public JSONObject loadJson(String resourceName) {
		JSONObject jsonObject = null;
		InputStream inputStream = null;
		try {
			inputStream = getClass().getClassLoader().getResourceAsStream(resourceName + ".json");
			MyLogger.info("Loading JSON file: " + resourceName);
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
			JSONTokener tokener = new JSONTokener(inputStreamReader);
			jsonObject = new JSONObject(tokener);
		} catch (Exception e) {
			MyLogger.error("Error loading JSON file: " + resourceName);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					MyLogger.error("Error closing input stream for JSON file: " + resourceName);
				}
			}
		}
		return jsonObject;
	}
}
