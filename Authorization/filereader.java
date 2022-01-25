package Authorization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class filereader {
	
	
	public static String readvalues(String data) throws IOException  

	{
		File file = new File("C:\\Users\\HP\\eclipse-workspace\\demo1API\\Mydetails.properties");
		FileInputStream input = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(input);
		
		String values = prop.getProperty("url");		
		return values;
	}
	

}
