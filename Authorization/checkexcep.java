package Authorization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class checkexcep {
	
	public static void main(String[] args) throws IOException {
		
		
		try
		{
			File file = new File("C:\\Users\\HP\\eclipse-workspace\\demo1API\\Mydetails.properties");
			FileInputStream input = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(input);
			String values = prop.getProperty("url");
			System.out.println(values);
			
		}catch (FileNotFoundException e) {
			File file = new File("C:\\Users\\HP\\eclipse-workspace\\demo1API\\Mydetailss.properties");
			FileInputStream input = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(input);
			String values = prop.getProperty("url");
			System.out.println(values);
		}
		
		
		
		
		
	}

}
