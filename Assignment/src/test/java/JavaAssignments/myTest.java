package JavaAssignments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.testng.annotations.Test;
//import org.testng.annotations.Be

public class myTest {
	@Test
	public void LoginTest()
	{
		Map<String, List<String>> list = new HashMap<String, List<String>>();
		List<String> lis = new ArrayList<String>();
		List<String> li = new ArrayList<String>();
		lis.add("One");
		lis.add("One");
		lis.add("One");
		list.put("0", lis);
		li.add("Two");
		li.add("Two");
		li.add("Two");
		list.put("1", lis);
		
		for (Map.Entry<String, List<String>> me : list.entrySet()) {
			  String key = me.getKey();
			  List<String> valueList = me.getValue();
			  System.out.println("Key: " + key);
			  System.out.print("Values: ");
			  for (String s : valueList) {
			    System.out.print(s + " ");
			  }
			}
		
		
	}
	
}
