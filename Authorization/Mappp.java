package Authorization;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.groovy.parser.antlr4.GroovyParser.MapEntryContext;

import groovy.util.MapEntry;

public class Mappp {
	public static void main(String[] args) {
		
	java.util.Map<String, String> map = new HashMap<String, String>();
	
	map.put("name", "Prashant");
	map.put("job", "leader");
	
	System.out.println(map);
	System.out.println(map.get("job"));
	
	for(Map.Entry<String, String> values : map.entrySet())
	{
		System.out.println(values.getKey());
		System.out.println(values.getValue());
	}
		
		
		
		
	}

}
