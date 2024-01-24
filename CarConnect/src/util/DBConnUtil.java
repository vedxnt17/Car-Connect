package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnUtil {
	
    public static Connection getConnection(String connectionString) throws SQLException, FileNotFoundException, IOException, ClassNotFoundException 
    {
    	
    	Properties properties = new Properties();
    	String fileName = "../src/db.properties";
        try(FileInputStream input = new FileInputStream(fileName)) {
          
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	properties.load(input);
        	String connectionString1=connectionString;
        	String username = properties.getProperty("db.username");
        	String password=properties.getProperty("db.password");
            
            
            
           
            return DriverManager.getConnection(connectionString1, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Error establishing database connection: " + e.getMessage(), e);
        }
    }

