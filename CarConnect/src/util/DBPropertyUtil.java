package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {
	


	 public static String getConnectionString(String fileName) {
	        Properties properties = new Properties();

	        try (FileInputStream input = new FileInputStream(fileName)) {
	            properties.load(input);

	            String databaseUrl = properties.getProperty("db.url");

	            if (databaseUrl != null && !databaseUrl.isEmpty()) {
	                return databaseUrl;
	            } else {
	                throw new RuntimeException("Database URL not found in the properties file.");
	            }
	        } catch (IOException e) {
	            throw new RuntimeException("Error reading properties file: " + e.getMessage());
	        }
}
	 
	 
	 public static void main(String[] args) {
	     
	        String fileName = "../src/db.properties";
	        String connectionString = getConnectionString(fileName);

	        System.out.println("Connection String: " + connectionString);
	    }
}
