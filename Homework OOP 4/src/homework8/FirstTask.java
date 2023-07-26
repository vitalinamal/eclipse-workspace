package homework8;

import java.util.ArrayList;
import java.util.List;

public class FirstTask {

	public static void main(String[] args) {
		funWithList();

	}
	
	public static void funWithList() {
		List<String> list1 = new ArrayList<>();

	    list1.add("one");
	    list1.add("two");
	    list1.add("three");
	    list1.add("four");
	    list1.add("five");
	    list1.add("six");
	    list1.add("seven");
	    list1.add("eight");
	    list1.add("nine");
	    list1.add("ten");
	    
	    // removing of first two and last elements from list	    
	    list1.remove(0);
	    list1.remove(0);
	    list1.remove(list1.size()-1);
	    
//	    System.out.println(list1);
	    
	    for (String element : list1) {
	        System.out.println(element);
	      }
	    
	}

}
