package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {
	public static String readPropertyFile(String Property_name,String FilePath) {
		
		 Properties prop = new Properties();
		  try (InputStream input = new FileInputStream("./Data/Data.properties")) {

	         

			  
	          // load a properties file
	          prop.load(input);

	          // get the property value and print it out
	     

	      } catch (IOException ex) {
	          ex.printStackTrace();
	}
		return prop.getProperty(Property_name);
}
	

}
