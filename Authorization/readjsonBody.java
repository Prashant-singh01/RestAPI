package Authorization;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
public class readjsonBody { 
	public static String Read_jsonBody(String Path) throws IOException
{
String path = Path;
FileInputStream tream = new FileInputStream(new File(path));

InputStreamReader read = new InputStreamReader(tream);

BufferedReader red = new BufferedReader(read);

StringBuilder build = new StringBuilder();
String line;
while((line = red.readLine()) != null)
{
build.append(line);
}
return build.toString();
}
}


